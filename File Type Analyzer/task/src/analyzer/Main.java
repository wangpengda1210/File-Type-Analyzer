package analyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

import static analyzer.Util.readFile;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> params = Util.parseCommand(args);

        if (params.size() != 2) {
            System.out.println("Param error");
            return;
        }

        File patternsFile = new File(params.get(1));
        File fileToAnalyze = new File(params.get(0));
        String[] patterns = new String(Objects.requireNonNull(readFile(patternsFile)))
                .split("\n");
        ArrayList<Pattern> patternsList = new ArrayList<>();

        for (String pattern : patterns) {
            String[] elements = pattern.split(";");
            patternsList.add(new Pattern(Integer.parseInt(elements[0]),
                    elements[1].replace("\"", ""),
                    elements[2].replace("\"", "")));
        }

        Collections.sort(patternsList);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Callable<String>> callables = new ArrayList<>();
        if (fileToAnalyze.isDirectory()) {
            for (File subFile : Objects.requireNonNull(fileToAnalyze.listFiles())) {
                callables.add(() -> {
                    byte[] fileInBytes = readFile(subFile);
                    assert fileInBytes != null;
                    String fileContent = new String(fileInBytes);

                    for (Pattern pattern : patternsList) {
                        if (SearchUtil.RKSearch(fileContent, pattern.getPattern())) {
                            return subFile.getName() + ": " + pattern.getType();
                        }
                    }

                    return subFile.getName() + ": Unknown file type";
                });
            }
        }

        try {
            List<Future<String>> results = executorService.invokeAll(callables);

            for (Future<String> result : results) {
                System.out.println(result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

}

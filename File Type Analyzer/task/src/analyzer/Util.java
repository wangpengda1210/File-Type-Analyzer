package analyzer;

import java.io.*;
import java.util.ArrayList;

public class Util {

    public static ArrayList<String> parseCommand(String[] command) {
        ArrayList<String> params = new ArrayList<>();

        int endOfLastParam = 0;
        while (endOfLastParam != command.length) {
            if (command[endOfLastParam].startsWith("\"")) {
                if (command[endOfLastParam].endsWith("\"")) {
                    params.add(command[endOfLastParam].replace("\"", ""));
                } else {
                    StringBuilder sb = new StringBuilder(command[endOfLastParam]).append(" ");
                    while (endOfLastParam < command.length - 1) {
                        endOfLastParam++;
                        sb.append(command[endOfLastParam]).append(" ");
                        if (command[endOfLastParam].endsWith("\"")) {
                            break;
                        }
                    }
                    if (!sb.toString().endsWith("\" ")) {
                        return params;
                    }
                    params.add(sb.toString().trim().replace("\"", ""));
                }
            } else {
                params.add(command[endOfLastParam].replace("\"", ""));
            }
            endOfLastParam++;
        }

        return params;
    }

    public static byte[] readFile(File file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] fileInBytes = new byte[(int) file.length()];
            inputStream.read(fileInBytes);
            return fileInBytes;
        } catch (FileNotFoundException e) {
            System.out.println("File not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

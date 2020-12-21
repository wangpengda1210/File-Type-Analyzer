import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        // write your code here
        Collections.reverse(items);
        int sum = 0;
        for (Future<Callable<Integer>> item : items) {
            try {
                sum += item.get().call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

}
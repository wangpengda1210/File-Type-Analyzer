import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        // write your code here
        int depth = 1;

        Object object = callable.call();
        while (object instanceof Callable) {
            depth++;
            object = ((Callable<?>) object).call();
        }

        return depth;
    }

}
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        long[] array = new long[scanner.nextInt()];

        for (long i = 0; i < array.length; i++) {
            array[(int) i] = scanner.nextLong();
        }

        System.out.println(mergeSort(array, array.length));
    }

    /* This method sorts the input array and returns the
           number of inversions in the array */
    static long mergeSort(long arr[], int array_size)
    {
        long temp[] = new long[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static long _mergeSort(long arr[], long temp[], long left, long right)
    {
        long mid, inv_count = 0;
        if (right > left) {
            /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left) / 2;

            /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static long merge(long arr[], long temp[], long left, long mid, long right)
    {
        long i, j, k;
        long inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            }
            else {
                temp[(int) k++] = arr[(int) j++];

                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

        /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[(int) k++] = arr[(int) i++];

        /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[(int) k++] = arr[(int) j++];

        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[(int) i] = temp[(int) i];

        return inv_count;
    }

}
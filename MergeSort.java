package lab06;

public class MergeSort<E extends Comparable<E>> {

    /** The constant in the formula t = c * O() */
    private double c;

    /**
     * The order O() of the implementation. If your implementation is in O(n^2), use
     * Math.pow().
     * 
     * @param n index
     * @return the function of n inside the O()
     */
    public double O(int n) {
        // EXERCISE
        // conditional to prevent log(n)=-INFINITY
        if (n == 0) {
            return 0;
        } else {
            return n * Math.log(n);
        }
    }

    /**
     * Calculates the constant c using a given input array of type E. Units of time
     * should be converted to microseconds
     */
    public void fit(E[] array) {
        // EXERCISE
        long start = System.nanoTime();// returns the time in nanoseconds
        sort(array);
        long stop = System.nanoTime();
        double time = (stop - start) / 1000.0;
        double O = O(array.length);
        // conditional to prevent division by zero
        if (O == 0) {
            c = 0;
        } else {
            c = time / O;
        }
    }

    /**
     * Predicts the running time of a merge sort for some index n
     * 
     * @param n
     * @return the estimated amount of time in unit microseconds
     */
    public double predict(int n) {
        // EXERCISE
        return c * O(n);
    }

    /**
     * Performs a merge sort using a given input array
     * 
     * @param array the (unsorted) array
     * @return the sorted array
     */
    public E[] sort(E[] array) {
        if (array.length <= 1)
            return array;
        E[] sorted = array.clone();
        E[] array2 = sorted.clone();
        sort(sorted, array2, 0, array.length - 1);
        return sorted;
    }

    private void sort(E[] array1, E[] array2, int first, int last) {
        if (first >= last)
            return;

        int middle = (first + last) / 2;
        sort(array1, array2, first, middle);
        sort(array1, array2, middle + 1, last);

        int i = first;
        int a = first;
        int b = middle + 1;
        while (a <= middle && b <= last) {

            // EXERCISE

            // Copy the smaller of array[a] or array[b] to array2[i]
            // (in the case of a tie, copy array[a])
            // and increment i and a or b (the one you copied).
            if (array1[a].compareTo(array1[b]) <= 0) {
                array2[i] = array1[a];
                a++;

            } else {
                array2[i] = array1[b];
                b++;
            }
            i++;

        }
        // EXERCISE
        // Copy the rest of a or b, whichever is not at the end.
        if (a <= middle) {
            // Copy the rest of array1[a..middle] to array2[i..last]
            for (int j = a; j <= middle; j++) {
                array2[i] = array1[j];
                i++;
            }
        } else {
            // Copy the rest of array1[b..last] to array2[i..last]
            for (int j = b; j <= last; j++) {
                array2[i] = array1[j];
                i++;
            }
        }

        System.arraycopy(array2, first, array1, first, last - first + 1);
    }

}

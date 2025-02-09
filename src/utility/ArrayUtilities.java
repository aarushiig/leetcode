package utility;

public class ArrayUtilities {

    /**
     * Swaps two elements in a generic array at specified indices.
     *
     * <p>This method exchanges the elements at positions {@code i} and {@code j}
     * within the given array. It works with arrays of any object type.</p>
     *
     * @param <T>   The type of elements in the array.
     * @param array The input array in which elements will be swapped.
     * @param i     The index of the first element to be swapped.
     * @param j     The index of the second element to be swapped.
     * @throws ArrayIndexOutOfBoundsException if either {@code i} or {@code j}
     *                                        is outside the array's valid index range
     * @implNote This method modifies the original array in-place.
     */
    public static <T> void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

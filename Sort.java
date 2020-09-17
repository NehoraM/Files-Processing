package filesprocessing;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * this class is Heap-sort
 */
public class Sort {

    public static void sort(ArrayList<Path> arr, Comparator<Path> comparator) {

        int n = arr.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i , comparator);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Path temp = arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,temp);

            // call max heapify on the reduced heap
            heapify(arr, i, 0 , comparator);
        }
    }



    /**
     *
     * @param arr the array list to sort
     * @param n the length
     * @param i the current index
     * @param comparator the comparator of sort
     */

    static void heapify(ArrayList<Path> arr, int n, int i, Comparator<Path> comparator)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare(arr.get(l),arr.get(largest))>0)
            largest = l;


        // If right child is larger than largest so far
        if (r < n && comparator.compare(arr.get(r) , arr.get(largest))>0)
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            Path swap = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest,swap);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }

}

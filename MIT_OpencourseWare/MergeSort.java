// To be careful about equality signs and also check for the right side of the division
public class MergeSort {
    public static void main(String args[]) {
        int arr[] = new int[]{3, 4, 5, 1, 2};
        int res[] = new int[5];
        MergeSorter ms = new MergeSorter();
        res = ms.mergesort(arr, 0, arr.length-1);
        for (int i=0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    static class MergeSorter {
        public static void merge(int[] arr, int start, int mid, int fin) {
            int left[] = new int[mid-start+1];
            int right[] = new int[fin-mid];
            int i=0,j=0,k=start;
            // Pour into the new arrays
            for (int cout=start; cout<=mid; cout++) {
                left[cout-start] = arr[cout];
            }
            for (int cout=mid+1; cout<= fin; cout++) {
                right[cout-(mid+1)] = arr[cout];
            }
            // Now cmp
            while (i < (mid-start+1) && j < (fin-mid)) {
                if (left[i] < right[j]) {
                    arr[k] = left[i]; i++; k++;
                }
                else {
                    arr[k] = right[j]; j++; k++;
                }
            }
            while (i < (mid-start+1)) {
                arr[k] = left[i]; i++; k++;
            }
            while (j  < (fin-mid)) {
                arr[k] = right[j]; j++; k++;
            }
        }
        public static int[] mergesort(int[] arr, int start, int fin) {
            if (start < fin) {
                int mid = (start + fin)/2;
                mergesort(arr, start, mid);
                mergesort(arr, mid+1, fin);
                merge(arr, start, mid, fin);
            }
            return arr;
        }
    }
}
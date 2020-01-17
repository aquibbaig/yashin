// n/2 to n are leaf nodes, so they are assumed to be following the heap 
// property. However, we start from n/2-1 to 0 and recursively heapify.
// important thing to note is that if we do not change indexes after swap,
// the recursion will start from the place it began, which is what we want here
// that after every swap does the swap not break the heap property below us?
public class Heaps {
    public static void main(String args[]) {
      int arr[] = new int[]{4, 7, 8, 3, 2, 6, 5};
      MaxHeapify mh = new MaxHeapify();
      int res[] = new int[arr.length];
      res = mh.build_heap(arr);
      for (int i=0; i<res.length; i++) {
          System.out.print(res[i] + " ");
      }
    }
    static class MaxHeapify {
        public static int[] build_heap(int[] arr) {
            for (int i=(arr.length-1)/2; i>=0; i--) {
                max_heapify(arr, i);
            }
            return arr;
        }
        public static void max_heapify(int[] arr, int i) {
            int largest=i;
            int left = 2*i + 1;
            int right = 2*i + 2;
            if (left <= arr.length-1 && arr[left] > arr[i]) {
                largest = left;
            }
            if (right <= arr.length-1 && arr[right] > arr[largest]) {
                largest = right;
            }
            
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                max_heapify(arr, largest);
            }
        }
    }
}
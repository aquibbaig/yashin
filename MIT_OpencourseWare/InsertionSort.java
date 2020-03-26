package MIT_OpencourseWare;

public class InsertionSort {
    public static void main(String args[]) {
      int arr[] = new int[]{3,5,4,1,2};
      int res[] = new int[5];
      InsertionSorter is = new InsertionSorter();
      res = is.sort(arr);
      for (int i = 0; i < res.length; i++) {
          System.out.print(res[i]);
      }
  }

  static class InsertionSorter {
      public int[] sort(int[] arr) {
            for (int i=1; i< arr.length; i++) {
                int key = i;
                // put arr[i] in the correct position
                // by backtracking from the key 
                for (int j=key-1; j>=0; j--) {
                    if (arr[key] < arr[j]) {
                        int temp = arr[key];
                        arr[key] = arr[j];
                        arr[j] = temp;
                        key--;
                    }
                    else continue;
                }
            }
            return arr;
        } 
    }
}

// Using Binary Search
public class InsertionSortBinary {
    public static int Binarysearch(int[] arr, int el, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi)/2;
            if (el < arr[mid]) {
                return Binarysearch(arr, el, lo, mid);
            }
            else {
                return Binarysearch(arr, el, mid+1, hi);
            }
        } else {
            return lo;
        }
    }
    public static void printArr(int[] arr) {
        for (int i=0; i<5; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static int[] insertionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (i==0) {
                continue;
            }
            int pos = Binarysearch(arr, arr[i], 0, i-1);
            // System.out.println(pos + " :pos");
            int selected = arr[i];
            int j = i-1;
            // Shift other positions
            while (j>=pos) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[pos] = selected;
        }
        return arr;
    }
    public static void main(String args[]) {
      int arr[] = new int[]{5, 4, 3, 1, 2};
      int res[] = new int[5];
      res = insertionSort(arr);
      printArr(res);
    }
}
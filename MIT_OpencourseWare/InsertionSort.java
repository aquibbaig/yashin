public class InsertionSort {
    public static void main(String args[]) {
      int arr[] = new int[]{3,5,4,1,2};
      int res[] = new int[5];
      InsertionSorter is = new InsertionSorter();
      res = is.sort(arr);
      for (int i=0; i<res.length; i++) {
          System.out.print(res[i]);
      }
    }
    static class InsertionSorter {
        public static int[] sort (int[] arr) {
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
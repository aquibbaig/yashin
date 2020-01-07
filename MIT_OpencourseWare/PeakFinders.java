public class PeakFinders {
    public static void main(String args[]) {
      int arr[] = new int[]{11, 12, 5, 12, 40, 16};
      NaivePeakFinder np = new NaivePeakFinder();
      OptimalPeakFinder op = new OptimalPeakFinder();
      int res = np.finder(arr);
      int res2 = op.finder(arr, 0, arr.length-1);
      System.out.println(res);
      System.out.println(res2);
    }
    static class NaivePeakFinder {
        public int finder(int[] arr) {
            if (arr[0] > arr[1]) {
                return arr[0];
            }
            else if (arr[arr.length-1] > arr[arr.length - 2]) {
                return arr[arr.length-1];
            }
            else {
                int res=0;
                for (int i=1; i < arr.length; i++) {
                    if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                        res = arr[i];
                    }
                }
            return res;
            }
        }
    }
    static class OptimalPeakFinder {
        public int finder (int[] arr, int left, int right) {
            if (arr[0] > arr[1]) {  
                return arr[0];                    
            }
            else if (arr[arr.length-1] > arr[arr.length - 2]) {
                return arr[arr.length-1];
            }
            else {
                int mid = (left+right)/2;
                System.out.println(mid + ", " + right);
                if (arr[mid] < arr[mid+1]) {
                    // look on the right side
                    return finder(arr, mid, right);
                } else if (arr[mid] < arr[mid-1]) {
                    // look on the left side
                    return finder(arr, left, mid);
                }
                else return arr[mid];   
            }
        }
    }
}
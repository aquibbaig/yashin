// m rows, n columns
// TODO: Check edge cases
public class 2DPeakFinders {
    public static void main(String args[]) {
      OptimalPeakFinder op = new OptimalPeakFinder();
      int m = 3, n= 3;
      int arr[][] = new int[][]{{12,31,8,3}, {16,55,6,19}, {17,24,9,7}};
      int res = op.finder(arr, m, n);
      System.out.println(res);
    }
    static class OptimalPeakFinder {
        public int findGlobalMaximum(int[][] arr, int m, int midColIndex) {
            int max = 0;
            for (int i=0; i<m; i++) {
                if (arr[i][midColIndex] > arr[max][midColIndex]) {
                    max = i;
                }
            }
            return max;
        }
        public int finder(int[][] arr, int m, int n) {
            int midColIndex = n/2;
            int maxRowIndex = findGlobalMaximum(arr, m, midColIndex);
            // globalMaximum will be arr[maxRowIndex][midColIndex] and we continue from there
            if (arr[maxRowIndex][midColIndex] < arr[maxRowIndex][midColIndex+1]) {
                // go right
                return finder(arr, m, midColIndex+1);
            } 
            else if (arr[maxRowIndex][midColIndex] < arr[maxRowIndex][midColIndex-1]) {
                // go left
                return finder(arr, m, midColIndex-1);
            }
            else return arr[maxRowIndex][midColIndex];  
            
        }
    }
}
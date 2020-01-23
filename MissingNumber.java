// Find a missing number in O(logn)
public class MissingNumber {
    static class Solver {
        public static int solve(int[] arr, int start, int end) {
            if (start != end) {
                int mid = (start+end)/2;
                if (arr[mid] - mid == 1) {
                    // correct, move right
                    return solve(arr, mid+1, end);
                }
                return solve(arr, start, mid);
            }
            else return arr[start]-1;
        }
    }
    public static void main(String args[]) {
      int[] arr = new int[]{1,3,4,5,6,7};
      Solver solver = new Solver();
      int res = solver.solve(arr, 0, 6);
      System.out.println(res);
    }
}
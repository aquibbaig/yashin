// This question was important because it was a nice sequential thinking
// to use a Stack
// However there was simpler method  just by looking at the numbers, you could
// solve it. i.e. if (position = 0 & char = 'U') then we go out of the valley
import java.util.*;
import java.io.*;

public class CountingValleys {
    public static int count=0;
    public static int position=0;
    public static int newPosition (char ch) {
        switch (ch) {
            case 'U':
                return 1;
            case 'D':
                return -1;
            default:
                return 0;
        }
    }
    public static void main(String args[]) throws IOException, EmptyStackException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char ch[] = br.readLine().toCharArray();

        // Solution
        Stack<Character> stack = new Stack<>();
        //insertion
        for(int i=0; i<n; i++) {
            stack.push(ch[ch.length - i - 1]);
        }

        // solution
        while (!stack.isEmpty()) {
            position = position + newPosition(stack.pop());
            if (position < 0) {
                CountingValleys.count += 1;
                while (position < 0 && !stack.isEmpty()) {
                    position = position + newPosition(stack.pop());
                }
            }
        }
        System.out.println(CountingValleys.count);
    }
}

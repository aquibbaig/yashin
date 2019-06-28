//Question: Bob has a strange counter. At the first second, it displays the number 3. Each second, the number displayed by the counter decrements by 1 until it reaches 1.
//The counter counts down in cycles. In next second, the timer resets to 2 * initial number for the prior cycle  and continues counting down.
// The diagram below shows the counter values for each time t in the first three cycles:
// Diagram: https://s3.amazonaws.com/hr-challenge-images/22185/1469447349-bae87a5071-strange1.png

// Challenges: Handling Timeouts due to loops

// Solution 1:
// 1. No. of terms in a level form a GP. So you need to find where does this nth term given in question lie.
// 2. Relate this level info to find the upper bound of the level
// 3. Find the actual value

// Solution 2:
// Pattern: t is never smaller than right side until the upper bounds.
// Use this in while loop to find the upper bound
// There seems to be a pattern in the sums 3,6,12,24... in the upper bound occurences.
// Seems to be that if you subtract the sequence less than t from t itself and add +1 to the result, there is your solution
// E.g. t = 14, Subtract 3, 6, 12. (As they are less than 14).
import java.io.*;
import java.util.*;

public class StrangeCounter{
    public static long start = 3;
    public static void main(String args[]) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        long t = Long.parseLong(br.readLine());
        while (t > StrangeCounter.start) {
            t = t - StrangeCounter.start;
            StrangeCounter.start *= 2;
        }
        System.out.println(StrangeCounter.start - t + 1);
    }
}
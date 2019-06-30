//This code was written by me during TCS Codevita and was a wonderful problem based on the number of steps you had to
// write
// 1. Find primes in between two numbers
// 2. Find unique numbers out of the sequence
// 3. Find primes within that unique sequence
// 4. Find largest and smallest of the numbers
// 5. Find fibonacci series using the smallest and largest number as the first two and n = no. of elements in the array of step 3
// Trick: While calculating the fibonacci sequence the terms will come in wrong. You need to convert the terms into long format
import java.util.*;
import java.io.*;

public class PrimeFibonacci{
    public static List findPrimesWithinInterval(int low, int hi){
        List <Integer> temp = new ArrayList<Integer>();
        while (low < hi) {
            boolean count = false;
            for (int i =2; i <= low/2; ++i) {
                if (low % i == 0) {
                    count = true;
                    break;
                }
            }
            if (!count) {
                temp.add(low);
            }
            ++low;
        }
        return temp;
    }

    public static boolean isPrime(int element)
    {
        boolean isPrime = true;
        for (int i=2; i < element; i++) {
            if (element % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void findFibonacci(int previousNumber, int nextNumber, int size) {
        long sum = 0;
        long first = previousNumber;
        long second = nextNumber;
        for (int i=2; i<size; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        System.out.println(sum);
    }

    public static void main(String args[]) throws IOException, ClassCastException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input[] = br.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);

        List <Integer> primes = new ArrayList<Integer>();

        //Solution
        //Find primes between n1 and n2
        primes = findPrimesWithinInterval(n1, n2);

        List <Integer> secondArray = new ArrayList<Integer>();
        List <Integer> temp = new ArrayList<Integer>();

        // unique combination
        for (int i =0; i< primes.size(); i++) {
            for (int j=0; j<primes.size(); j++) {
                if (primes.get(i) != primes.get(j)) {
                    String str1 = Integer.toString(primes.get(i));
                    String str2 = Integer.toString(primes.get(j));
                    temp.add(Integer.parseInt(str1+str2));
                }
            }
        }

        //set
        Set<Integer> set = new HashSet<Integer>(temp);
        List<Integer> mylist = new ArrayList<>();
        mylist.addAll(set);

        // find primes within the array
        mylist.forEach((element) -> {
            if (isPrime(element)){
                secondArray.add(element);
            }
        });

        int min = (int) Collections.min(secondArray);
        int max = (int) Collections.max(secondArray);

        //fibonacci
        findFibonacci(min, max, secondArray.size());
    }
}
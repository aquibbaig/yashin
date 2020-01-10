import java.util.*;

public class DocumentDistance {
    public static void main(String args[]) {
        DocumentDistance dd = new DocumentDistance();
        int sol = dd.finder("I am a cat and I am a mouse", "I am a mouse");
        System.out.println(sol);
        
    }
    static class DocumentDistance{
        public HashMap<String, Integer> toFrequencyTable(String s) {
            HashMap<String, Integer> temp = new HashMap<String, Integer>();
            String arraySplice[] = s.split(" ");
            for (String t: arraySplice) {
                // insert into hashmap
                if (!temp.containsKey(t)) {
                    temp.put(t, 1);
                } else temp.put(t, temp.get(t) + 1);
            }
            return temp;
        }
        public int finder(String s1, String s2) {
            // logic goes here
            HashMap<String, Integer> d1 = toFrequencyTable(s1);
            HashMap<String, Integer> d2 = toFrequencyTable(s2);
            // dot product
            int result = 0;
            for (String s: d1.keySet()) {
                if (d2.containsKey(s)) {
                    result = result + d2.get(s)*d1.get(s); 
                }
            }
            return result;
        }
    }
}
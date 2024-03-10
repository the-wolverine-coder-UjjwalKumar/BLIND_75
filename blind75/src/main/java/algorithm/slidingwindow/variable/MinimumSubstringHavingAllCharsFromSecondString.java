package algorithm.slidingwindow.variable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSubstringHavingAllCharsFromSecondString {
    public static void main(String[] args) {
        String s = "timetopractise";
        String t = "toc";

        String s1 = "TOTMTAPTAT";
        String t1 = "TTA";

        // return the length of min substring which contains all the char
        // from t and in same quantity. order in substring picked doesn't matter.
        String ans = getMinimumUniqueSubString(s1, t1);
//        String ans = minWindow(s1, t1);
        System.out.println(ans);
    }

    private static String getMinimumUniqueSubString(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int count = map.size(); // denotes the total uniq characters required.

        int i = 0;
        int j = 0;
        int ansLength = Integer.MAX_VALUE;
        int start = 0; // to track the starting index of answer

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)-1);
            if (map.get(s.charAt(j)) == 0) count--;

            if (count == 0) {
                // we get one possible answer
                // now we start optimizing the string i.e. we will try to reduce it.
                while (count==0) {
                    if (ansLength > j-i+1) {
                        ansLength = j-i+1;
                        start = i;
                    }

                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
                    if (map.get(s.charAt(i)) > 0) count++;

                    i++;
                }
            }
            j++;

        }

        if (ansLength != Integer.MAX_VALUE)
            return s.substring(start, start + ansLength);
        else
            return "";

        // return ansLength; // returning only length

    }
}

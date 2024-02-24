package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKUniqueChars {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

         int longestStringLength = getLongestSubstringWithKUniqueChars(s, k);
        System.out.println(longestStringLength);
    }

    private static int getLongestSubstringWithKUniqueChars(String s, int k) {
        if (k > s.length()) return 0;

        int i = 0;
        int j = 0;
        int ans = 0;


        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() == k) {
                ans = Math.max(ans, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char charAtI = s.charAt(i);
                    map.put(charAtI, map.get(charAtI) - 1);

                    if (map.get(charAtI) == 0) {
                        map.remove(charAtI);
                    }

                    i++;
                }
            }
            j++;

        }
        return ans;
    }
}

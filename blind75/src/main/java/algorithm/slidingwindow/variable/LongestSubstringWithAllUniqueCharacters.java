package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAllUniqueCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";

        int longestStringLength = getLongestSubstringWithAllUniqueChars(s);
        System.out.println(longestStringLength);
    }

    private static int getLongestSubstringWithAllUniqueChars(String s) {

        int i = 0;
        int j = 0;
        int ans = 0;


        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() == j-i+1) {
                ans = Math.max(ans, j - i + 1);
            } else if (map.size() < j-i+1) {
                while (map.size() < j-i+1) {
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

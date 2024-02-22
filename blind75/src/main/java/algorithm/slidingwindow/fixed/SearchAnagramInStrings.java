package algorithm.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SearchAnagramInStrings {
    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String pattern = "for";

        int ans = getAnagramCount(s, pattern);
        System.out.println(ans);
    }

    private static int getAnagramCount(String s, String pattern) {
        if (s.isEmpty() || pattern.isEmpty() || s.length() < pattern.length()) return 0;

        int i = 0;
        int j = 0;
        int k = pattern.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (j < s.length()) {

            // append in window
            sb.append(s.charAt(j));


            if (j-i+1 >= k) {
                // window size hits
                boolean isAnagram = checkAnagram(sb.toString(), pattern);
                if (isAnagram) {
                    count++;
                }

                // remove starting block from window
                sb.deleteCharAt(0);
                i++;
            }

            j++;
        }

        return count;
    }

    private static boolean checkAnagram(String string, String pattern) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for (Character ch : string.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for (Character ch : pattern.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        for (Map.Entry<Character,Integer> entry : map1.entrySet()) {
            if (!Objects.equals(map1.get(entry.getKey()), map2.get(entry.getKey())))
                return false;
        }
        return true;
    }
}

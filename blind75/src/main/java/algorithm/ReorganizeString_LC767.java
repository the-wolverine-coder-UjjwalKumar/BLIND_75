package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString_LC767 {
    public static void main(String[] args) {
        String inputS = "aaabbb";
        String inputS2 = "aaab";
        String ans = reorganizeStringN(inputS2);
        if (!ans.isEmpty())
            System.out.println(ans);
        else
            System.out.println("Empty Str bro!!");

    }

    private static String reorganizeStringN(String inputS) {
        StringBuilder sb = new StringBuilder();

        Map<Character,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < inputS.length(); i++) {
            int cnt = hashMap.getOrDefault(inputS.charAt(i), 0);
            hashMap.put(inputS.charAt(i), (cnt+1));
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> -(a.getCnt() - b.getCnt()));

        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
            Pair record = new Pair(entry.getKey(), entry.getValue());
            maxHeap.add(record);
        }

        // Now processing current char and block them for next interval.
        Pair blocked;
        Pair currItem;

        blocked = maxHeap.poll();

        sb.append(blocked.getCh());
        blocked.setCnt((blocked.getCnt()-1));

        while (!maxHeap.isEmpty()) {
            currItem = maxHeap.poll();
            sb.append(currItem.getCh());
            currItem.setCnt((currItem.getCnt()-1));

            if (blocked.getCnt()>0)
                maxHeap.add(blocked);
            blocked = currItem;
        }

        if (blocked.getCnt()!=0 && maxHeap.isEmpty()) {
            return "";
        }

        return sb.toString();
    }

    static class Pair {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }

        public char getCh() {
            return this.ch;
        }

        public int getCnt() {
            return this.cnt;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

}

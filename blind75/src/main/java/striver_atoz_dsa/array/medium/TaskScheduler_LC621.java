package striver_atoz_dsa.array.medium;

import algorithm.ReorganizeString_LC767;

import java.util.*;

public class TaskScheduler_LC621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int interval = 2;
        int minInterval = leastInterval(tasks, interval);
        System.out.println(minInterval);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
                (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        q.addAll(map.entrySet());

        int count = 0;
        while (!q.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
            while (k > 0 && !q.isEmpty()) {
                Map.Entry<Character, Integer> top = q.poll(); // most frequency task
                top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
                tempList.add(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0) q.add(e); // add valid tasks
            }

            if (q.isEmpty()) break;
            count = count + k; // if k > 0, then it means we need to be idle
        }
        return count;
    }

    public int leastInterval1(char[] tasks, int n) {
        //Build Frequency Array
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task-'A']++;
        }
        Arrays.sort(freq);//Sort to get max frequency
        int maxFreq = freq[25];
        int idleTime = (maxFreq-1) * n;//eg, A : 3, n=2 -> A_ _A_ _A

        for(int i = 24; i >= 0; i--) {
            //Math.min handles the case where another task has same freq
            idleTime-= Math.min(maxFreq-1, freq[i]);
        }
        //Idle time cannot be negative, cap at 0
        return tasks.length + Math.max(idleTime, 0);
    }
}

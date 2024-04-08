package striver_atoz_dsa.array;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfSudentUnableToEatSanwiches_LC1700 {

    public static void main(String[] args) {
        int[] studentPref = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 0};

        int numOfStudentsCantEat = countStudents(studentPref, sandwiches);
        System.out.println(numOfStudentsCantEat);


    }

    public static int countStudents(int[] studentPref, int[] sandwiches) {
        int[] count = {0, 0};
        int n = studentPref.length;
        int numOfStudentServed;
        for (int a : studentPref)
            count[a]++;
        for (numOfStudentServed = 0; numOfStudentServed < n
                && count[sandwiches[numOfStudentServed]] > 0; ++numOfStudentServed)
            count[sandwiches[numOfStudentServed]]--;
        return n - numOfStudentServed;
    }

    public static int countStudents1(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>();
        Queue<Integer> sandwich = new LinkedList<>();
        for (int i : students) student.offer(i);
        for (int i : sandwiches) sandwich.offer(i);
        int count = 0;
        while (true) {
            if (student.peek() == sandwich.peek()) {
                student.poll();
                sandwich.poll();
                count = 0;
            } else if (student.peek() != sandwich.peek()) {
                int s = student.poll();
                student.offer(s);
                count++;
            }
            if (student.isEmpty() || count >= student.size()) break;
        }
        return student.size();
    }

}

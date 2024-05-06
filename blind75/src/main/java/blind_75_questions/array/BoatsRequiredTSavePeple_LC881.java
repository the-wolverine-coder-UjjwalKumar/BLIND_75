package blind_75_questions.array;

import java.util.Arrays;

public class BoatsRequiredTSavePeple_LC881 {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int boatLimit = 3;

        int boatCount = getMinBoatRequired(people, boatLimit);
        System.out.println(boatCount);
    }

    private static int getMinBoatRequired(int[] people, int boatLimit) {
        Arrays.sort(people);

        int boatCount=  0;
        int currBoatLimit = 0;

        for (int i = 0; i < people.length; i++) {
            currBoatLimit+=people[i];
            if (currBoatLimit < boatLimit) {
                continue;
            } else {
                boatCount++;
                currBoatLimit = 0;
            }
        }

        return boatCount;

    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; --j)
            if (people[i] + people[j] <= limit) ++i;
        return people.length - 1 - j;
    }
}

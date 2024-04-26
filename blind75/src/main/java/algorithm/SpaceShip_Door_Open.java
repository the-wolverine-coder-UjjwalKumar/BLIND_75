package algorithm;

import java.util.Arrays;

public class SpaceShip_Door_Open {
    public static void main(String[] args) {
        // door - 1 to 100
        // all initially closed
        // if open toggle to close it, if close toggle to open it
        // next go to every 2nd door (2,4,6...)
        // next go to every 3rd door (3,6,9...)
        // find out the final state of doors after toggling all 100 doors

        boolean[] doorsState = new boolean[101];
        Arrays.fill(doorsState, false);

        System.out.println("Before toggling door state: " + Arrays.toString(doorsState));
        boolean[] updatedState = updateDoorsByTogglingBruteForce(doorsState);
        System.out.println("After-toggling door state : " + Arrays.toString(updatedState));
        boolean[] updatedState3 = updateDoorsByTogglingOptimized(doorsState);
        System.out.println("After3-toggling door state : " + Arrays.toString(updatedState3));

    }

    /*
     * Before : [false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false]
     * After : [false, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, false, true]
     */

    // TC : O(N)
    public static boolean[] updateDoorsByTogglingOptimized(boolean[] doorsState) {
        for (int i = 1; i * i <= 100; i++) {
            doorsState[i * i] = !doorsState[i * i];
        }
        return doorsState;
    }

    // TC : O(N^2)
    public static boolean[] updateDoorsByTogglingBruteForce(boolean[] doorsState) {

        // Looping through each door toggling based on its multiples
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j += i) {
                doorsState[j] = !doorsState[j];
            }
        }

        return doorsState;
    }
}

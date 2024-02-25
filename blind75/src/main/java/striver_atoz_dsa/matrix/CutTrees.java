package striver_atoz_dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class CutTrees {

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(new ArrayList<>());
        forest.add(new ArrayList<>());
        forest.add(new ArrayList<>());

        forest.get(0).addAll(List.of(1,2,3));
        forest.get(1).addAll(List.of(0,0,5));
        forest.get(2).addAll(List.of(8,7,6));

        int ans = cutOffTree(forest);
        System.out.println(ans);
    }

    public static int cutOffTree(List<List<Integer>> forest) {
        int trees = 0;
        for (List<Integer> row : forest) {
            for (int height : row) {
                if (height >= 1)
                    trees++;
            }
        }

        return helper(forest, 0, 0, trees);
    }

    public static int helper(List<List<Integer>> forest, int i, int j, int trees) {
        if (trees <= 1) {
            return 0;
        }

        int rows = forest.size();
        int cols = forest.get(0).size();

        // allowed four directions
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int minSteps = Integer.MAX_VALUE;

        int currentHeight = forest.get(i).get(j);

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && forest.get(ni).get(nj) > 0) {
                int nextHeight = forest.get(ni).get(nj);

                if (nextHeight >= currentHeight) {
                    forest.get(i).remove(j);
                    forest.get(i).add(j,0);
                    int steps = helper(forest, ni, nj, trees - 1);

                    if (steps!=-1)
                        minSteps = Math.min(minSteps, 1+ steps);


                }
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    public static boolean isValid(List<List<Integer>> forest, int i, int j) {
        return (i >= 0 && i < forest.size() && j >= 0 && j < forest.get(0).size() && forest.get(i).get(j) > 0);
    }
}

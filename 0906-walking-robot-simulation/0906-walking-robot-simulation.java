import java.util.AbstractMap.SimpleEntry;

class Solution {
    private final static int[][] dirs = new int[][] {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] currPosition = new int[] {0, 0};
        int maxDistance = 0;
        Set<SimpleEntry<Integer, Integer>> hs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            hs.add(new SimpleEntry<>(obstacle[0], obstacle[1]));
        }
        int currDirIndex = 0;
        for (int command : commands) {
            if (command == -2) {
                currDirIndex = (currDirIndex + 3) % 4;
            } else if (command == -1) {
                currDirIndex = (currDirIndex + 1) % 4;
            } else {
                int stepsRemain = command;
                while (stepsRemain > 0) {
                    SimpleEntry<Integer, Integer> nextPosition = new SimpleEntry<>(currPosition[0] + dirs[currDirIndex][0], currPosition[1] + dirs[currDirIndex][1]);
                    if (hs.contains(nextPosition)) {
                        break;
                    } else {
                        currPosition[0] = nextPosition.getKey();
                        currPosition[1] = nextPosition.getValue();
                        maxDistance = Math.max(maxDistance, currPosition[0] * currPosition[0] + currPosition[1] * currPosition[1]);
                        --stepsRemain;
                    }
                }
            }
        }
        return maxDistance;
    }
}
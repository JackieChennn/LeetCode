class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = healths.length;
        // store the robot's index as key and its health and direction as value
        TreeMap<Integer, int[]> tm = new TreeMap<>();
        // store the going right robot's index
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tm.put(positions[i], new int[] {healths[i], (directions.charAt(i) == 'L') ? 0 : 1});
        }
        for (Map.Entry<Integer, int[]> entry : tm.entrySet()) {
            int index = entry.getKey();
            int[] temp = entry.getValue();
            if (stack.size() == 0) {
                // No robot is going right
                if (temp[1] == 0) {
                    // let go the left moveing robot
                    continue;
                } else {
                    // store the going right robot into stack
                    stack.push(index);
                }
            } else {
                // There are some robots going right
                if (temp[1] == 0) {
                    // currRobot going left, will collide with the last right robot
                    while (stack.size() > 0) {
                        int rightRobotIndex = stack.pop();
                        int[] rightRobotTemp = tm.get(rightRobotIndex);
                        if (temp[0] > rightRobotTemp[0]) {
                            temp[0]--;
                            rightRobotTemp[0] = 0;
                        } else if (temp[0] < rightRobotTemp[0]) {
                            rightRobotTemp[0]--;
                            if (rightRobotTemp[0] > 0) {
                                // goinf right robot is still alive, push it back to stack
                                stack.push(rightRobotIndex);
                            }
                            temp[0] = 0;
                            break;
                        } else {
                            temp[0] = 0;
                            rightRobotTemp[0] = 0;
                            break;
                        }
                        
                    }
                    
                } else {
                    // currRobot going right, simply store the going right robot into stack
                    stack.push(index);
                }
            }
        }
        for (int index : positions) {
            int currHealth = tm.get(index)[0];
            if (currHealth > 0) {
                res.add(currHealth);
            }
        }
        return res;
    }
}
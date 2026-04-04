class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        double[][] cars = new double[speed.length][3];// 0 for pos, 1 for speed, 2 for target reach time
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
            cars[i][2] = (double) (target - position[i]) /speed[i];
        }
        Arrays.sort(cars, (a,b)-> (int) (a[0]-b[0]));

        Stack<double[]> stack = new Stack<>();
        for (int i = 0; i < cars.length; i++) {
            while (!stack.isEmpty() && stack.peek()[2] <= cars[i][2]){
                stack.pop();
            }
            stack.push(cars[i]);
        }

        return stack.size();
    }
}

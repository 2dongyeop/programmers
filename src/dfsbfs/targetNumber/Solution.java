package dfsbfs.targetNumber;

public class Solution {
    private int sum = 0;
    private int index = 0;
    private int count = 0;
    public int solution(int[] numbers, int target) {

        makeTarget(numbers, target, sum, index);

        return count;
    }

    private final void makeTarget(final int[] numbers, final int target, final int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) count++;
        } else {
            makeTarget(numbers, target, sum + numbers[index], index + 1);
            makeTarget(numbers, target, sum - numbers[index], index + 1);
//            makeTarget(numbers, target, sum - numbers[index], index++);
        }
    }
}
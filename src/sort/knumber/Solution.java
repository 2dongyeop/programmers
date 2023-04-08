package sort.knumber;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int resultIndex = 0;

        for (int[] command: commands) {
            int size = command[1] - command[0];
            int[] targetArray = new int[size + 1];

            int index = 0;
            for (int i = command[0] - 1; i <= command[1] - 1; i++) {
                targetArray[index] = array[i];
                index++;
            }

            Arrays.sort(targetArray);
            answer[resultIndex] = targetArray[command[2] - 1];
            resultIndex++;
        }

        return answer;
    }
}

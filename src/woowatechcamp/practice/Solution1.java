package woowatechcamp.practice;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {

        int[] boxes = {1000, 800, 900};
        int m = 1000000;
        int k = 3;
        solution(boxes, m, k);
    }

    public static int solution(int[] boxes, int m, int k) {
        int answer = m;

        Arrays.sort(boxes);
        int length = boxes.length;

        for (int i = 0; i < k; i++) {
            for (int j = length - 1; j >= 0; j--) {
                int getMoney = (answer / 10000) * boxes[j];
                if (getMoney <= 100000) {
                    answer += getMoney;
                    break;
                }
            }
        }

        return answer;
    }
}

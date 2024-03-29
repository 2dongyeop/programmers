package stackqueue.printer;
import java.util.*;

public class Solution1 {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.add(priorities[i]);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] priorities = {2, 1, 3, 2};
        System.out.println(solution(priorities, 0));
    }
}
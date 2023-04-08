package heap.doublepriorityqueue;

import java.util.*;

class Solution {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        Queue<Integer> ascQueue = new PriorityQueue<>();
        Queue<Integer> descQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String input : operations) {
            StringTokenizer stringTokenizer = new StringTokenizer(input);

            validateOperation(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()), ascQueue, descQueue);
        }

        if (ascQueue.size() > 0) {
            answer[0] = descQueue.poll();
            answer[1] = ascQueue.poll();
        }
        return answer;
    }

    private void validateOperation(
            final String operation,
            final int number,
            final Queue<Integer> ascQueue,
            final Queue<Integer> descQueue) {

        if (operation.equals("I")) {
            ascQueue.add(number);
            descQueue.add(number);
        }

        if (operation.equals("D")) {
            if (descQueue.size() == 0 && ascQueue.size() == 0) {
                return;
            }

            if (number == 1) {
                Integer target = descQueue.poll();
                ascQueue.remove(target);
            } else if (number == -1) {
                Integer poll = ascQueue.poll();
                descQueue.remove(poll);
            }
        }
    }
}
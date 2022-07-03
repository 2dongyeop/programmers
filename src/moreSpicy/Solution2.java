package moreSpicy;

import java.util.PriorityQueue;

class Solution2 {
    private int count = 0; //섞은 횟수
    private final PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        arrayToQueue(heap, scoville);       //잦은 삭제와 추가로 인해 리스트를 이용

        while (heap.peek() < K) {           //제일 작은 수가 K보다 작으면 makeSpicy() 실행

            if (heap.size() < 2) return -1; //두 수를 합해 K 이상으로 만들 수 없는 경우
            makeSpicy(heap);                //가장 작은 두 수를 합해 맵게 만들기
        }

        return count;
    }

    private final void arrayToQueue(final PriorityQueue queue, final int[] array) {
        for (int a : array) {
            queue.add(a);
        }
    }

    private final void makeSpicy(final PriorityQueue queue) {
        int a = (int) queue.poll();
        int b = (int) queue.poll();
        int c = a + 2 * b;

        queue.add(c);
        count++;
    }
}
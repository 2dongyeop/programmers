package moreSpicy;

import java.util.PriorityQueue;

class Solution2 {
    static int count = 0; //섞은 횟수
    static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        arrayToQueue(heap, scoville); //잦은 삭제와 추가로 인해 리스트를 이용

        while (heap.peek() < K) {
            if (heap.size() < 2) return -1; //K 이상으로 만들 수 없는 경우
        //while (!isBiggerK(heap, K)) { //K보다 작은 값이 없을때까지 반복
            makeSpicy(heap);          //맵게 만들기
        }

        int answer = count;
        return answer;
    }

    public static void arrayToQueue(final PriorityQueue queue, final int[] array) { //배열을 리스트로 복사
        for (int a : array) {
            queue.add(a);
        }
    }

    public static void makeSpicy(final PriorityQueue queue) {
        int a = (int) queue.poll();
        int b = (int) queue.poll();
        int c = a + 2 * b;

        queue.add(c);
        count++;
    }
}
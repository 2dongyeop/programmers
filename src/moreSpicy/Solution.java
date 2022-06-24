package moreSpicy;

class Solution {
    static int count = 0;
    static int first = 0, second = 0;

    int solution(int[] scoville, int K) {
        int answer = 0;
        int[] copy = new int[scoville.length];

        while (!isBiggerK(scoville, K)) {
            makeSpicy(scoville);

        }

        answer = count;
        return answer;
    }

    boolean isBiggerK(int[] scoville, int K) {
        int countSmall = 0;
        for (int i = 0; i < scoville.length; i++) {
                if (scoville[i] < K) countSmall++;
        }

        if (countSmall != 0) return false;
        else return true;
    }

    void makeSpicy(int[] scoville) {
        chooseSmall(scoville);



        count++;
    }

    public void chooseSmall(int[] scoville) {
        for (int i = 0; i < scoville.length; i++) {
            if (first > scoville[i]) {
                first = scoville[i];
            } 
        }

        for (int i = 0; i < scoville.length; i++) {
            if (second > scoville[i] && second != first) {
                second = scoville[i];
            }
        }

    }


}
package moreSpicy;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int count = 0; //섞은 횟수
    static int first = 0, second = 0; //첫째, 둘째로 작은 수의 인덱스
    List<Integer> list = new ArrayList<>();

    int solution(int[] scoville, int K) {
        arrayToList(list, scoville);

        while (!isBiggerK(list, K)) {
            makeSpicy(list);
        }

        int answer = count;
        return answer;
    }

    static void arrayToList(List list, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int a = array[i];

            list.add(a);
        }
    }

    static boolean isBiggerK(List list, int K) {
        boolean isBigger = true;
        ;
        for (int i = 0; i < list.size(); i++) {
            int temp = (int) list.get(i);

            if (temp < K) isBigger = false;
        }
        return isBigger;
    }

    static void makeSpicy(List list) {
        chooseSmall(list);

        int a = (int) list.get(first);
        int b = (int) list.get(second);
        int c = a + 2 * b;

        list.add(c);
        list.remove(first);
        list.remove(second);
        count++;
    }

    static void chooseSmall(List list) {
        int tempFirst = 0, tempSecond = 0;

        for (int i = 0; i < list.size(); i++) {
            if (tempFirst > (int) list.get(i)) {
                first = i;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (tempSecond > (int) list.get(i) && tempFirst != tempSecond) {
                second = i;
            }
        }
    }


}
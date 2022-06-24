package moreSpicy;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int count = 0; //섞은 횟수
    static int firstIndex = 0, secondIndex = 0; //첫째, 둘째로 작은 수의 인덱스
    static List<Integer> heap = new ArrayList<>();

    public int solution(int[] scoville, int K) {
        arrayToList(heap, scoville); //잦은 삭제와 추가로 인해 리스트를 이용

        while (!isBiggerK(heap, K)) { //K보다 작은 값이 없을때까지 반복
            if (heap.size() < 2) return -1;
            makeSpicy(heap);          //맵게 만들기
        }

        int answer = count;
        return answer;
    }

    public void arrayToList(final List list, final int[] array) { //배열을 리스트로 복사
        for (int i = 0; i < array.length; i++) {
            int a = array[i];

            list.add(a);
        }
    }

    public boolean isBiggerK(final List list, final int K) {
        boolean isBigger = true; //초기값은 모두 K보다 크다고 가정

        for (int i = 0; i < list.size(); i++) {
            int temp = (int) list.get(i);

            if (temp < K) {
                isBigger = false; //K보다 작은 값이 있으면 false
                break;
            }
        }
        return isBigger;
    }

    public void makeSpicy(final List list) {
        chooseSmall(list); //가장 작은 수와 두번째로 작은 수의 인덱스를 알아옴

        int a = (int) list.get(firstIndex);
        int b = (int) list.get(secondIndex);
        int c = a + 2 * b;

        list.add(c);
        list.remove(firstIndex);
        list.remove(secondIndex);
        count++;
    }

    public void chooseSmall(final List list) {
        int tempFirst = (int) list.get(0);
        int tempSecond = (int) list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (tempFirst >= (int) list.get(i)) {
                tempFirst = (int) list.get(i);
                firstIndex = i;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (tempSecond >= (int) list.get(i) && tempFirst < (int) list.get(i)) {
                tempSecond = (int) list.get(i);
                secondIndex = i;
            }
        }
    }
}
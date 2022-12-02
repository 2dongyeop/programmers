package sort.maxNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int maxNumber;
    private final List<Integer> list = new ArrayList<>();
    private final List<Integer> temp = new ArrayList<>();

    public String solution(int[] numbers) {
        arrayToList(temp, numbers);                             //배열을 리스트로 복사

        while (!temp.isEmpty()) {                               //temp 리스트가 빌 때까지
            maxNumber = temp.get(0);

            for (int i = 1; i < temp.size(); i++) {
                int digit = temp.get(i) / 10;
                addMaxNum(maxNumber, temp.get(i), digit, i);    //최대 수를 판단하여 리스트에 추가
            }
        }

        String answer = list.toString();
        return answer;
    }

    private final void arrayToList(final List list, final int[] array) {
        for (int a : array) {
            list.add(a);
        }
    }

    //각 숫자의 맨 첫 자리수 크기를 비교
    //3과 23을 비교할 경우 3 * 10과 23을 비교
    //단, 이 경우 [34, 3, 5]가 있을 경우 "5343"이 아닌 "5334"로 배치될 수도 있어 문제가 발생
    private final void addMaxNum(final int currentMax, final int num, final int digit, final int index) {
        if (digit < 1) { //1자리수
            if (currentMax < num) {
                maxNumber = num;
                temp.remove(index);
                list.add(maxNumber);
            }
        } else if (digit < 10) { //2자리수
            if (currentMax * 10 < num) {
                maxNumber = num;
                temp.remove(index);
                list.add(maxNumber);
            }
        } else if (digit < 100) { //3자리수
            if (currentMax * 100 < num) {
                maxNumber = num;
                temp.remove(index);
                list.add(maxNumber);
            }
        } else if (digit == 1000) {
            if (currentMax * 1000 < num) {
                maxNumber = num;
                temp.remove(index);
                list.add(maxNumber);
            }
        }
    }
}

//int a가 0~9이면 a / 10 = 0; -> 1미만이면 1자리수
//10~99면 1~9;                -> 10미만이면 2자리수
//100~999면 10~99;            -> 100미만이면 3자리수
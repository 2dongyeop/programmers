package maxNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxNumber;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public String solution(int[] numbers) {
        arrayToList(temp, numbers); //temp에다 배열을 복사

        while (!temp.isEmpty()) {

            maxNumber = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                int digit = temp.get(i) / 10;
                addMaxNum(maxNumber, temp.get(i), digit, i);
            }
        }

        String answer = list.toString();
        return answer;
    }

    public void arrayToList(List list, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int a = array[i];

            list.add(a);
        }
    }

    public void addMaxNum(int currentMax, int num, int digit, int index) {
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
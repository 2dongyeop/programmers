package MaxNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int maxNumber;
    List<String> temp = new ArrayList<>();
    List<String> maxList = new ArrayList<>();
    List<String> e = new ArrayList<>();

    public String solution(int[] numbers) {
        int max = numbers[0];

        for (int i = 0 ; i < numbers.length; i++) {
//            if (numbers[i])
        }

        String answer = "";
        return answer;
    }

//    public String solution(int[] numbers) {
//        copyArray(temp, numbers);   //temp에 복사
//
//        for (int i = 0; i < numbers.length; i++) {
//            maxNumber(temp); //첫번째 자리에 들어갈 숫자를 temp에서 가져와 maxList에 넣음
//        }
//
//        String answer = e.toString();
//        return answer;
//    }

    public void copyArray(List list, int[] array) {
        for (int i = 0; i < array.length; i++) {
            String s = String.valueOf(array[i]);

            list.add(s);
        }
    }

    public void maxNumber(List list) {
        maxNumber = Integer.parseInt(String.valueOf(list.get(0).toString().charAt(0)));

        for (int i = 1; i < list.size(); i++) {
            if (maxNumber < Integer.parseInt(String.valueOf(list.get(i).toString().charAt(0)))) {
                maxNumber = Integer.parseInt(String.valueOf(list.get(i).toString().charAt(0)));

                list.remove(i);
                maxList.add(String.valueOf(maxNumber));
            }
        }
    }

    public static void main(String[] args) {
        int a = 10;
    }
}

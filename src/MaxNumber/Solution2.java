package maxNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public String solution(int[] numbers) {
        String answer = "";

        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println((o2+o1) + "과 " + (o1+o2) + " 비교");
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (String str : stringNumbers) {      //정렬된 순서대로 answer에 추가
            answer += str;
        }

        if (stringNumbers[0].equals("0")) {     //배열이 {0, 0, 0} 처럼 0으로만 주어질 경우 0을 리턴
            return "0";
        }

        return answer;
    }
}
package maxNumber;

import java.util.Arrays;
import java.util.Comparator;

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
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (String str : stringNumbers) {
            answer += str;
        }

        if (stringNumbers[0].equals("0")) {
            return "0";
        }

        return answer;
    }
    
}
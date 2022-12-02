package stackqueue.hatesamenumber;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        ArrayList<Integer> queue = new ArrayList<>();
        int previous = 10;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != previous) {
                queue.add(arr[i]);
                previous = arr[i];
            }
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            answer[i] = queue.get(i);
        }

        return answer;
    }
}
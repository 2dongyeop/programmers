package stackqueue.collectparentheses;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { //시작이 ( 이면 스택에 푸시
                stack.push('(');
            } else {

                if (stack.isEmpty()) return false; //스택이 비어있는데 )부터 오면 return false

                else stack.pop();
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }
}

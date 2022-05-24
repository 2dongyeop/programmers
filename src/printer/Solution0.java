package printer;


import java.util.*;

public class Solution0 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node('A',2));
        q.add(new Node('B',1));
        q.add(new Node('C',3));
        q.add(new Node('D',2));
    }
}

class Node {
    char data;
    int prior;

    Node(char data, int prior) {
        this.data = data;
        this.prior = prior;
    }
}

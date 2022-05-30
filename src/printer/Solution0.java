package printer;

import java.util.*;

public class Solution0 {
    static class Node {
        int location;
        int prior;

        Node(int location, int prior) {
            this.location = location;
            this.prior = prior;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Node(i, priorities[i]));
        }

        int now = 0;

        try {
            dwl:
            while (!q.isEmpty()) {
                Node peekNode = q.peek();

                for (Node n : q) {
                    if (n.prior > peekNode.prior) {
                        q.poll();
                        q.add(peekNode);
                    } else {
                        now++;
                        if (peekNode.location == location) {
                            answer = now;
                            break dwl;
                        }
                    }
                }
            }
        } catch (ConcurrentModificationException e) {}
        return answer;
    }
}


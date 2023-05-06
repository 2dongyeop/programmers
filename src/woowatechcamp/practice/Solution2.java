package woowatechcamp.practice;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

//        int width = 2;
//        int height = 2;
//        int[][] diagonals = {{1, 1}, {2, 2}};
//
        int width = 51;
        int height = 37;
        int[][] diagonals = {{17, 19}};
        System.out.println(solution(width, height, diagonals));

//        int distance = distance(17, 19);
//        System.out.println("distance = " + distance);
    }

    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;

        for (int i = 0; i < diagonals.length; i++) {
            int diagonalX = diagonals[i][0];
            int diagonalY = diagonals[i][1];

            /** 대각선을 왼&위에서 오&아래로 갈 때 */
            //step 1. 출발점에서 왼 & 위까지 가는 경우
            int leftUpCount = 0; //초기화
            if (diagonalX == 1) leftUpCount = 1;
//            else leftUpCount = distance(diagonalX - 1, diagonalY);
            else leftUpCount = distanceWithCache(diagonalX - 1, diagonalY);

            //step 2. 오&아래에서 도착점까지 가는 경우
            int rightBottomCount = 0;
            if (diagonalX == width) rightBottomCount = 1;
//            else rightBottomCount = distance(width - diagonalX, height - (diagonalY - 1));
            else rightBottomCount = distanceWithCache(width - diagonalX, height - (diagonalY - 1));

            answer += leftUpCount * rightBottomCount;
            System.out.println("answer = " + answer);


            /** 대각선을 오&아래에서 왼&위로 갈 때 */
            //step 1. 출발점에서 오&아래까지 가는 경우i
            int bottomRightCount = 0;
            if (diagonalY == 1) bottomRightCount = 1;
//            else bottomRightCount = distance(diagonalX, diagonalY - 1);
            else bottomRightCount = distanceWithCache(diagonalX, diagonalY - 1);

            //step 2. 왼&위에서 도착점까지 가는 경우
            int upLeftCount = 0;
            if (diagonalY == height) upLeftCount = 1;
//            else upLeftCount = distance(width - (diagonalX - 1), height - diagonalY);
            else upLeftCount = distanceWithCache(width - (diagonalX - 1), height - diagonalY);

            answer += bottomRightCount * upLeftCount;
            System.out.println("answer = " + answer);
        }

        return answer % 10000019;
    }

    private static int distance(int x, int y) {
        if (x == 0 || y == 0) return 1;
        return distance(x - 1, y) + distance(x, y - 1);
    }

    private static int distanceWithCache(int x, int y) {
        if (x == 0 || y == 0) return 1;

        String key = x + "," + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int result = distanceWithCache(x - 1, y) + distanceWithCache(x, y - 1);
        cache.put(key, result);

        return result;
    }

}

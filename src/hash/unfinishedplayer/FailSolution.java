package hash.unfinishedplayer;

public class FailSolution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean isChecked;

        forP:
        for (String p : participant) { // p 하나 뽑기
            isChecked = false; //초기 설정은 발견 못함
            forC:
            for (String c : completion) { // c 하나 뽑기
                //같은게 있다면? 완주자! -> 따라서 다음 반복문으로.
                if (p.equals(c)) {
                    isChecked = true; //발견했으니 값 바꾸기
                    continue;
                }
            }

            if (!isChecked) { //completion을 순환했을때, 발견하지 못했으면?
                answer = p;   //p가 완주하지 못한 참가자이므로 리턴!
            }
        }

        return answer;
    }
}
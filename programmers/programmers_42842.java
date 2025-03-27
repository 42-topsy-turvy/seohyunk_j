package programmers.java;

public class programmers_42842 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int total = brown + yellow;
            int[] answer = new int[2];
            // 가로 >= 세로
            for(int i = 3; i < (int)total / 2; i++){    // i: 행의 개수, total/i: 열의 개수
                int col_num = total / i;    // 열의 개수
                if((total % i == 0) && (col_num >= i)) {
                    if(col_num * 2 + (i  - 2) * 2 == brown){
                        answer[0] = col_num;
                        answer[1] = i;
                    }
                }
            }
            return answer;
        }
    }

}

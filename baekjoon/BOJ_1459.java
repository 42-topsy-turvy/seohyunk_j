// BOJ 1459 걷기
import java.util.*;
import java.io.*;

public class BOJ_1459 {
    static long x, y, w, s;
    static long answer, min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        w = Long.parseLong(st.nextToken());
        s = Long.parseLong(st.nextToken());

        min = Math.min(x, y);
        max = Math.max(x, y);
        

        // 경우 1: 평행만
        long case1 = (x + y) * w;
        
        // 경우 2: 대각선 + 평행
        long case2 = min * s + (max - min) * w;
        
        // 경우 3: 대각선만 (짝수/홀수 구분)
        long case3;
        if ((max - min) % 2 == 0) {
            // 짝수: 대각선만으로 갈 수 있음
            case3 = max * s;
        } else {
            // 홀수: 대각선 + 평행 1칸
            case3 = (max - 1) * s + w;
        }
        
        // 최솟값
        long answer = Math.min(case1, Math.min(case2, case3));
        
        System.out.println(answer);

    }
}

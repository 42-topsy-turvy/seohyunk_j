// BOJ 2776 암기왕
package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0){
            T--;
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>(); // 배열 A를 HashSet으로 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder(); // 출력 최적화를 위해 사용
        
            for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (set.contains(num)) { // 배열 A(HashSet)에 존재 여부 확인
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        
        // 결과 출력
        System.out.print(sb);
        }
    }
}


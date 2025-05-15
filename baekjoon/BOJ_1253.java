// baekjoon 1253 좋다
import java.io.*;
import java.util.*;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());  // 첫 줄: 숫자 개수
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < N; i++){
            if (N==1){
                System.out.println(0);
                return;
            }
            int cur = nums[i];
            int l = 0;
            int r = N-1;
            int left = nums[l];
            int right = nums[r];
            while (l < r){
                if (l == i) {
                    l++;
                    continue;}
                else if (r == i) {
                    r--;
                    continue;}
                left = nums[l];
                right = nums[r];
                // System.out.println(left + " + " + right + " =" + cur);
                if (left + right == cur){
                    result++;
                    break;
                }
                else if (left + right < cur){
                    l++;
                }
                else{
                    r--;
                }
            }
        }   
        System.out.println(result);
    }
}

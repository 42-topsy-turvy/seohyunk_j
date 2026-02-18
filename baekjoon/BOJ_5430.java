import java.util.*;
import java.io.*;

public class BOJ_5430 {
    static int T, n;
    static StringBuilder sb = new StringBuilder();
    static String command, arr;
    static char[] chars;
    static Deque<Integer> deque;
    static boolean isReversed, isError;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T --> 0){
            command = br.readLine();
            n = Integer.parseInt(br.readLine());
            arr = br.readLine();
            
            deque = new LinkedList<Integer>();

            if (n > 0){
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for (String num: nums){
                    deque.add(Integer.parseInt(num));
                }
            }

            isReversed = false;
            isError = false;

            for (char c: command.toCharArray()){
                if (c == 'R'){
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()){
                        isError = true;
                        break;
                    } else {
                        if (isReversed){
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (isReversed){
                    sb.append(deque.pollLast());
                    while (!deque.isEmpty()){
                        sb.append(',').append(deque.pollLast());
                    }
                } else {
                    sb.append(deque.pollFirst());
                    while (!deque.isEmpty()){
                        sb.append(',').append(deque.pollFirst());
                    }
                }
            }
                sb.append("]\n");
            }

        }
        System.out.println(sb);
    }
}

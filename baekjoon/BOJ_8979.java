// 올림픽

package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_8979 {
    static int N, K;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // for(int i=0; i<N; i++){
        //     StringTokenizer country_st = new StringTokenizer(br.readLine());
        //     for(int j=0; j<4; j++){
        //         if(country_st.hasMoreTokens()){
        //         arr[i][j] = Integer.parseInt(country_st.nextToken());
        //         }
        //     }
        // }
        // System.out.println(Arrays.deepToString(arr));

        while(N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze, 0));
        }
        Collections.sort(list);
        list.get(0).rank = 1;

        if(list.get(0).num == K){
            System.out.println(1);
            return;
        }
        for(int i = 1; i < list.size(); i++ ){
            System.out.println(i +" " + K);
            Node currentNode = list.get(i);
            int prev_g = list.get(i - 1).g;
            int prev_s = list.get(i - 1).s;
            int prev_b = list.get(i - 1).b;
            
            if (prev_g == currentNode.g && prev_s == currentNode.s && prev_b == currentNode.b){
                list.get(i).rank = list.get(i - 1).rank;
            }
            else{
                // list.get(i).rank = list.get(i - 1).rank + 1;
                list.get(i).rank = i + 1;
            }

            if (list.get(i).num == K){  // i == K - 1
                System.out.println(list.get(i).rank);
                return;
            }

        }
    }
}
// Comparable 인터페이스 이용
// Bool 제외 레퍼 클래스, String/Time/Date의 클래스 인스턴스 정렬 가능 => default: 오름차순
class Node implements Comparable<Node>{
    int num, g, s, b, rank;

    public Node(int num, int g, int s, int b, int rank) {
        this.num = num;
        this.g = g;
        this.s = s;
        this.b = b;
        this.rank = rank;
    }

// 금메달 수
// 은메달 수
// 동메달 수
    @Override
    public int compareTo(Node o) {
        if(this.g == o.g){
            if(this.s == o.s){
                return o.b - this.b;
            }
            else{
                return o.s - this.s;
            }
        }
        else{
            return o.g - this.g;
        }
    }
}
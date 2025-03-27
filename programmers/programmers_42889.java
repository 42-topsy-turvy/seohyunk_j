package programmers.java;

import java.util.*;

// N: 전체 스테이지 개수
// 각 스테지이별 실패욜을 내림차순으로 -> 스테이지 번호 나열
public class programmers_42889 {
    public int[] solution(int N, int[] stages) {
        // i를 1부터 N + 1까지 (1 ~ N)
        // stages를 돌면서 i보다 크거나 같으면 분모로
        // i와 같으면 분자로
        Map<Integer, Double> fails = new HashMap<>();
        
        for(int i = 1; i < N+1; i++){
            int under = 0;
            int up = 0;
            for(int j = 0; j < stages.length; j++){
                // if(stages[j] == 0)
                if(stages[j] == i) up++;
                // System.out.println("i: up : " + up);
                if(stages[j] >= i) under++;
                // System.out.println("i: under : " + under);
            }
            if(under == 0) fails.put(i, 0.0);
            else fails.put(i, ((double)(up)/(double)(under)));
            // System.out.println("i: " + i + " fail: " + ((double)(up)/(double)(under)));
        }
//         fails.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
//         return answer;
        return fails.entrySet().stream()
                    .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
    }
}

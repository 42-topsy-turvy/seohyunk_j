// programmers 43164 여행경로
package programmers.java;

import java.util.*;
public class programmers_43164 {
    class Solution {
        Map<String, PriorityQueue<String>> hashMap = new HashMap<>();
        List<String> route = new ArrayList<>();
        public String[] solution(String[][] tickets) {
                for (String[] ticket: tickets){
                    hashMap.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
                }
            DFS("ICN");

            Collections.reverse(route);

            return route.toArray(new String[0]);
        }
        public void DFS(String airport){
            while(hashMap.containsKey(airport) && !hashMap.get(airport).isEmpty()){ // 해당 공항이 키로 존재하는지, 해당 공항에 연결된 공항들이 있는지
                DFS(hashMap.get(airport).poll());
            }
            route.add(airport);
        }
    }
}

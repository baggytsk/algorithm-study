import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new TreeMap<>();
        
        for (String r : records) {
            String[] s = r.split(" ");
            int time = changeNum(s[0]);
            int carNum = Integer.parseInt(s[1]);
            
            if (s[2].equals("IN")) {
                inMap.put(carNum, time);
            } else {
                int parked = time - inMap.get(carNum);
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parked);
                inMap.remove(carNum);
            }
        }
        
        int endOfDay = 23 * 60 + 59;
        for (int carNum : inMap.keySet()) {
            int parked = endOfDay - inMap.get(carNum);
            timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parked);
        }
        
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        
        for (int carNum : timeMap.keySet()) {
            int totalTime = timeMap.get(carNum);
            int fee = fees[1];
            
            if (totalTime > fees[0]) {
                fee += Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3];
            }
            answer[idx++] = fee;
        }
        
        return answer;
    }
    
    int changeNum(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}
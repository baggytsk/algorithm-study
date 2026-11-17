import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            Deque<Character> q = new ArrayDeque<>();
            for(char c : skill.toCharArray()){
                q.offer(c);
            }
            
            boolean check = true;
            for(char c : s.toCharArray()){
                if(q.contains(c)){
                    if(q.poll() != c){
                        check = false;
                        break;
                    }
                }
            }
            if(check) answer++;
        }
        
        return answer;
    }
}
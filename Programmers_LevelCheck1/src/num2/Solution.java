package num2;

import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();

        if(s.length() == 1){
            return 1;
        }
        for(int i = 1; i <= s.length()/2; i++){
            int count = 1;
            String com1 = "";
            String result = "";
            for(int j = 0; j < s.length()/i; j++){
                String com2 = s.substring((i*j),(i*j)+i);
                if(com1.equals(com2)){
                    count++;
                    continue;
                }
                if(count > 1){
                    result += count + com1;
                }else{
                    result += com1;
                }
                com1 = com2;
                count = 1;
            }
           if(count > 1){
                result += count + com1;
            }else{
                result += com1;
            }
            if(s.length() % i != 0){
                result += s.substring(s.length()-(s.length()%i),s.length());
            }
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
package num1;

import java.util.*;
class Solution {
  public boolean solution(String s) {
      boolean answer = true;
      if(s.length() == 4 || s.length() == 6){
          for(int i = 0; i < s.length(); i++){
              if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                  answer = true;
              }else{
                  return false;
              }
          }
      }else{
      return false;
  }
      return answer;
  }
}
package 다트게임;
import java.util.*;
public class Solution {
//	다트 게임은 총 3번의 기회로 구성된다.
//	각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
//	점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
//	옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
//	스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
//	스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
//	스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
//	Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
//	스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	public static int solution(String dartResult) {
	      int answer = 0;
	      ArrayList<String> data = new ArrayList<>();
	      ArrayList<Integer> data_num = new ArrayList<>();
	      String temp = "";
	      for(int i = 0; i < dartResult.length(); i++){
	    	  if(dartResult.charAt(i) >='0' && dartResult.charAt(i) <= '9'){	//문자일때
	    		  temp += dartResult.charAt(i);
	    	  }else if(dartResult.charAt(i) >='A' && dartResult.charAt(i) <= 'Z' || (dartResult.charAt(i) <= '*' || dartResult.charAt(i) <= '#')){
	    		  temp += dartResult.charAt(i);
	    		  data.add(temp);
	    		  temp = "";
	    	  }
	      }
	      int option_count = 0;
	      for(int i = 0; i < data.size(); i++){
	    	  String num = "";
	    	  String bonus = "";
	    	  String option = "";
	    	  
	    	  if(data.get(i).length() >= 2){
	    		  num = data.get(i).substring(0,data.get(i).length()-1);
	    		  bonus = data.get(i).substring(data.get(i).length()-1);
	    		  if(bonus.equals("D")){
	    			  data_num.add((int)(Math.pow(Integer.parseInt(num), 2)));
	    		  }else if(bonus.equals("T")){
	    			  data_num.add((int)(Math.pow(Integer.parseInt(num), 3)));
	    		  }else{
	    			  data_num.add(Integer.parseInt(num));
	    		  }
	    	  }else if(data.get(i).equals("*")){
	    		  if(data_num.size() == 1){
	    			  data_num.set(0, data_num.get(0)*2);
	    		  }else{
	    			  for(int j = i-2; j < i; j++){
	    				  data_num.set(j-option_count, data_num.get(j-option_count)*2);
	    			  }
	    		  }
	    		  option_count++;
	    	  }else if(data.get(i).equals("#")){
	    		  data_num.set(i-1-option_count, data_num.get(i-1-option_count)*(-1));
	    		  option_count++;
	    	  }
	      }
	      for(int i = 0; i < data_num.size(); i++){
	    	  answer+= data_num.get(i);
	      }
	      
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));
	}

}

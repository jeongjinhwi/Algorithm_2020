import java.util.*;
public class num2 {
	
	
	 public static String solution(int[] numbers) {
	        String answer = "";
	        StringBuilder sb = new StringBuilder();
	        String[] result = new String[numbers.length];
	        
	        for(int i = 0; i < result.length; i++){
	        	result[i] = String.valueOf(numbers[i]);
	        }
	        Arrays.sort(result, (o1,o2)->(o2+o1).compareTo(o1+o2));
	        if(result[0].charAt(0) == '0'){
	        	sb.append("0");
	        }else{
	        	for(int i = 0; i < result.length; i++){
	        		sb = sb.append(result[i]);
	        	}
	        }
	        answer = sb.toString();
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] numbers = {6,10,2};
		int[] number2 = {3,30,34,5,9};
		System.out.println(solution(numbers));
	}

}

package ��Ʈ����;
import java.util.*;
public class Solution {
//	��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
//	�� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
//	������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3���� (����1 , ����2 , ����3 )���� ���ȴ�.
//	�ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
//	��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
//	��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
//	��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
//	Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
//	��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.
	public static int solution(String dartResult) {
	      int answer = 0;
	      ArrayList<String> data = new ArrayList<>();
	      ArrayList<Integer> data_num = new ArrayList<>();
	      String temp = "";
	      for(int i = 0; i < dartResult.length(); i++){
	    	  if(dartResult.charAt(i) >='0' && dartResult.charAt(i) <= '9'){	//�����϶�
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
		// TODO �ڵ� ������ �޼ҵ� ����
		String dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));
	}

}

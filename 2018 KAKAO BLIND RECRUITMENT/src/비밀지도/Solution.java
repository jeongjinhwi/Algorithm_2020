package 비밀지도;
import java.util.*;
public class Solution {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      String[][] data = new String[n][n];
	      
	      String[] result1 = trans(n, arr1).split(" ");
	      String[] result2 = trans(n, arr2).split(" ");
	      for(int i = 0; i < n; i++){
	    	  for(int j = 0; j < n; j++){
	    		  if(result1[i].charAt(j) == '0' && result2[i].charAt(j) == '0'){
	    			  data[i][j] = "";
	    		  }else if(result1[i].charAt(j) == '1' || result2[i].charAt(j) == '1'){
	    			  data[i][j] = "#";
	    		  }
	    	  }
	      }
	      
	      String temp = "";
	      for(int i = 0; i < n; i++){
	    	  for(int j = 0; j < n; j++){
	    		  if(data[i][j].equals("#")){
	    			  temp += "#";
	    		  }else{
	    			  temp += " ";
	    		  }
	    	  }
	    	  answer[i] = temp;
	    	  temp = "";
	      }
	      return answer;
	  }
	public static String trans(int n, int[] arr){
		int mod = 0;
		int na = 0;
		String temp = "";
		Stack<Integer> st = new Stack<>();
		
		for(int j = 0; j < arr.length; j++){
			int mod_temp = arr[j];
			for(int i = 0; i < n; i++){
				mod = mod_temp / 2;
				na = mod_temp % 2;
				if(mod == 0 && st.size() != n && na == 0){
					st.add(0);
				}else{
					st.add(na);
				}
				mod_temp = mod;
			}
			while(!st.isEmpty()){
				temp += Integer.toString(st.pop());
			}
			temp += " ";
		}
		return temp;
	}
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] result = solution(n, arr1, arr2);
		
		for(int i = 0; i<n; i++){
			System.out.println(result[i]);
		}
	}

}

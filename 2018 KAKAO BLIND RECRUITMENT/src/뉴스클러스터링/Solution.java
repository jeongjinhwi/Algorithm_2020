package 뉴스클러스터링;
import java.util.*;
public class Solution {
	static ArrayList<String> gyo_A_B = new ArrayList<>();
	static ArrayList<String> hap_A_B = new ArrayList<>();
	static ArrayList<String> str_A = new ArrayList<>();
    static ArrayList<String> str_B = new ArrayList<>();
	public static int solution(String str1, String str2) {
	      int answer = 0;
	      str1 = str1.toUpperCase();
	      str2 = str2.toUpperCase();
	      token(str_A, str1);
	      token(str_B, str2);
	      gyo(str_A, str_B);
	      hap();
	      if(gyo_A_B.size() == 0 && hap_A_B.size() == 0){
	    	  return 65536;
	      }else{
	    	  answer = (int) Math.floor(((double)gyo_A_B.size()/(double)hap_A_B.size())*65536);
	      }
	      return answer;
	      
	  }
	public static void token(ArrayList<String> str, String str_num){
		for(int i = 0; i < str_num.length()-1; i++){
	    	  if((str_num.charAt(i) >= 'A' && str_num.charAt(i) <= 'Z') && (str_num.charAt(i+1) >= 'A' && str_num.charAt(i+1) <= 'Z')){
	    		  str.add(Character.toString(str_num.charAt(i))+ Character.toString(str_num.charAt(i+1)));
	    	  }
	      }
	}
	public static void hap(){
		for(int i = 0; i < gyo_A_B.size(); i++){
			hap_A_B.add(gyo_A_B.get(i));
		}
		for(int i = 0; i < str_A.size(); i++){
			hap_A_B.add(str_A.get(i));
		}
		for(int i = 0; i < str_B.size(); i++){
			hap_A_B.add(str_B.get(i));
		}
	}
	public static void gyo(ArrayList<String> str_A, ArrayList<String> str_B){
		for(int i = 0; i < str_A.size(); i++){
			for(int j = 0; j < str_B.size(); j++){
				if(str_A.get(i).equals(str_B.get(j))){
					gyo_A_B.add(str_A.get(i));
					str_A.remove(i);
					str_B.remove(j);
					i = i-1;
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		System.out.println(solution(str1, str2));
	}

}

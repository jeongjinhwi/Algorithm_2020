package 실패율;
import java.util.*;
public class Solution {
	 public static int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        Data data;
	        List<Data> list = new ArrayList<>();
	        for(int i = 1; i <= N; i++){
	        	double clear = 0;
	        	double fail = 0;
	        	for(int j = 0; j <stages.length; j++){
	        		if(stages[j] > i){
	        			clear++;
	        		}else if(stages[j] == i){
	        			fail++;
	        		}
	        	}
	        	double rate = fail/(clear+fail);
	        	list.add(new Data(i, rate));
	        }
	        Collections.sort(list);
	        for(int i = 0; i < list.size(); i++){
	        		answer[i] = list.get(i).getInteger();
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int N = 4;
		int[] stages = {4,4,4,4,4};
		solution(N, stages);
	}

}

class Data implements Comparable<Data>{
	public int integer;
	public double dou;
	public Data(int integer, double dou){
		this.integer = integer;
		this.dou = dou;
	}
	public Data(){}
	public int getInteger() {
		return integer;
	}
	public void setInteger(int integer) {
		this.integer = integer;
	}
	public double getDou() {
		return dou;
	}
	public void setDou(double dou) {
		this.dou = dou;
	}
	@Override
	public int compareTo(Data o) {
		// TODO 자동 생성된 메소드 스텁
		if(this.dou < o.getDou()){
			return 1;
		}else if(this.dou > o.getDou()){
			return -1;
		}
		return 0;
	}
}
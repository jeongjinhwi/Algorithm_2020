package num4;
import java.util.*;
public class Solution {
	 public static int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        Queue<Integer> minimum = new PriorityQueue<Integer>();	//�ּ� ��
	        Queue<Integer> maximum = new PriorityQueue<Integer>(Comparator.reverseOrder());	//�ִ� ��
	        
	        String[] ops = {};
	        int temp = 0;
	        for(int i = 0; i<operations.length; i++){
	        	ops = operations[i].split(" ");
	        	if(ops[0].equals("I")){							//���� ����
	        		minimum.add(Integer.parseInt(ops[1]));
	        		maximum.add(Integer.parseInt(ops[1]));
	        	}else if(ops[0].equals("D")){	//ť���� ����
	        		if(minimum.size() != 0){
	        			if(ops[1].equals("1")){				//ť���� �ִ밪 ����
		        			temp = maximum.peek();
		        			maximum.remove(temp);
		        			minimum.remove(temp);
	        			}else if(ops[1].equals("-1")){		//ť���� �ּڰ� ����
	        				temp = minimum.peek();
		        			maximum.remove(temp);
		        			minimum.remove(temp);
	        			}
	        		}
	        	}
	        	
	        }
	        
	        if(maximum.size() == 0 || minimum.size() == 0){
	        	answer[0] = 0;
	        	answer[1] = 0;

	        }else{
	        	answer[0] = maximum.peek();
	        	answer[1] = minimum.peek();
	        	
	        }
	        
	        return answer;
	 }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		String[] op = {"I 16","D 1"};
		String[] op2 = {"I 7","I 5","I -5","D -1"};
		System.out.println(solution(op));
	}

}

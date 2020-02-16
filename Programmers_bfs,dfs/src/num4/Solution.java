package num4;
import java.util.*;
public class Solution {
	static Stack<String> airports = new Stack<String>();
	static boolean[] visit;
	static List<String> list = new ArrayList<>();
	static String route = "";
    
	public static String[] solution(String[][] tickets) {
//		��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�.
//		�־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�.
//		tickets�� �� �� [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�.
//		�־��� �װ����� ��� ����ؾ� �մϴ�.
//		���� ������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�.
//		��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.
		
		//�׽�Ʈ���̽� 1,2�� ��� ����
		/*
        String[] answer = {};
        String begin = "ICN";
        visit = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2)-> Character.compare(o1[1].charAt(0), o2[1].charAt(0)));	//2�� �̻��� �� �����Ƿ� ���� ���ĺ� ������ ����
        for(int i = 0; i < tickets.length; i++){
        	if(tickets[i][0].equals(begin)){
        		visit[i] = true;
        		airports.add(begin);
        		airports.add(tickets[i][1]);
        		dfs(tickets, airports.peek(),1);
        		break;
        	}
        }
        answer = new String[airports.size()];
        for(int i = 0; i<airports.size(); i++){
        	answer[i] = airports.get(i);
        }
        
        return answer;
    }
	public static void dfs(String [][] tickets, String begin, int index){
		for(int i = 0; i < tickets.length; i++){
			if(tickets[i][0].equals(begin) && (visit[i] == false)){	
				visit[i] = true;
				airports.add(tickets[i][1]);
				dfs(tickets, airports.peek(), index+1);
				
			}
			
			
		}
	}
	*/
	

        visit = new boolean[tickets.length];
		
		for(int i = 0 ; i < tickets.length; i++) {
			
			String departure = tickets[i][0];
			String destination = tickets[i][1];
			
			if(departure.equals("ICN")) {
				visit[i] = true;
				route = departure + ",";
				dfs(tickets, destination, 1);
				visit[i] = false;
			}
		}
		
		Collections.sort(list);
		String[] answer = list.get(0).split(",");
		return answer;
    }
	
	public static void dfs(String[][] tickets, String end, int count) {
		
		route += end + ",";
		
		if(count==tickets.length) {
			list.add(route);
			return;
		}
		
		for(int i = 0 ; i < tickets.length ; i++) {
			String depart = tickets[i][0];
			String desti = tickets[i][1];
			
			if(end.equals(depart) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, desti, count+1);
				visit[i] = false;
				route = route.substring(0, route.length()-4);
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets3 = {{"ICN", "COO"}, {"COO", "ICN"}, {"COO", "ICN"}}; 
		String[][] tickets4 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"},{"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
		String[] answer = solution(tickets4);
		for(int i = 0; i<answer.length; i++){
			System.out.println(answer[i]);
		}
	}

}

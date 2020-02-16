package num4;
import java.util.*;
public class Solution {
	static Stack<String> airports = new Stack<String>();
	static boolean[] visit;
	static List<String> list = new ArrayList<>();
	static String route = "";
    
	public static String[] solution(String[][] tickets) {
//		모든 공항은 알파벳 대문자 3글자로 이루어집니다.
//		주어진 공항 수는 3개 이상 10,000개 이하입니다.
//		tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
//		주어진 항공권은 모두 사용해야 합니다.
//		만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
//		모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
		
		//테스트케이스 1,2번 통과 못함
		/*
        String[] answer = {};
        String begin = "ICN";
        visit = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2)-> Character.compare(o1[1].charAt(0), o2[1].charAt(0)));	//2개 이상일 수 있으므로 도착 알파벳 순으로 정렬
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
		// TODO 자동 생성된 메소드 스텁
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

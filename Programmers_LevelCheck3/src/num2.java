import java.util.*;
public class num2 {
	static Stack<String> airports = new Stack<String>();
	static boolean[] visit;
	static List<String> list = new ArrayList<>();
	static String route = "";
	public static String[] solution(String[][] tickets) {
		 visit = new boolean[tickets.length];
			
			for(int i = 0 ; i < tickets.length; i++) {
				
				String departure = tickets[i][0];
				String destination = tickets[i][1];
				
				if(departure.equals("ICN")) {
					//visit[i] = true;
					route = departure + ",";
					//dfs(tickets, destination, 1);
					bfs(tickets, destination, 1, i);
					list.add(route);
					//visit[i] = false;
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
	
	public static void bfs(String[][] tickets, String end, int count , int index){
		visit = new boolean[tickets.length];
		visit[index] = true;
		route += end + ",";
		Queue<String> q = new LinkedList<String>();
		q.add(end);
		while(!q.isEmpty()){
			String new_start = q.poll();
			for(int i = 0; i < tickets.length; i++){
				String depart = tickets[i][0];
				String des = tickets[i][1];
				
				if(new_start.equals(depart) && !visit[i]){
					visit[i] = true;
					q.add(des);
					route += des + ",";
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"},{ "JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(solution(tickets2));
	}
}

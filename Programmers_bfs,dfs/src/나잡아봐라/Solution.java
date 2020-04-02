package 나잡아봐라;
import java.util.*;
public class Solution {
	static boolean[] visitied;
	static int[] dist;
	static boolean[] visitied2;
	static int[] dist2;
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	static int answer = -1;
	public static int solution(int C, int p) { // dfs는 스택, 재귀함수,
		// bfs는 큐로
		visitied = new boolean[200000];
		dist = new int[200000];
		visitied[C] = true;
		visitied2 = new boolean[200000];
		dist2 = new int[200000];
		visitied2[p] = true;
		
		q1.add(C);
		q2.add(p);
		bfs();
//		bfs(numbers, target, 0);
//		if(dist[p] != 0){
//			return dist[p];
//		}
		return answer;
	}
	public static void bfs(){
		while(!q1.isEmpty() || !q2.isEmpty()){
			int d = q1.poll();
			int d2 = q2.poll();
			if(d-1 >= 0 && visitied[d-1] == false){
				visitied[d-1] = true;
				dist[d-1] = dist[d]+1;
				q1.add(d-1);
			}
			if(d+1 < 200000  && visitied[d+1] == false){
				visitied[d+1] = true;
				dist[d+1] = dist[d]+1;
				q1.add(d+1);
			}
			if(d*2 < 200000  && visitied[d*2] == false){
				visitied[d*2] = true;
				dist[d*2] = dist[d]+1;
				q1.add(d*2);
			}
			
			if(d2-1 >= 0 && visitied2[d2-1] == false){
				visitied2[d2-1] = true;
				dist2[d2-1] = dist2[d2]+1;
				q2.add(d2-1);
			}
			if(d2+1 < 200000  && visitied2[d2+1] == false){
				visitied2[d2+1] = true;
				dist2[d2+1] = dist2[d2]+1;
				q2.add(d2+1);
			}
			if(d2*2 < 200000  && visitied2[d2*2] == false){
				visitied2[d2*2] = true;
				dist2[d2*2] = dist2[d2]+1;
				q2.add(d2*2);
			}
			if(d == d2 && visitied[d] == true && visitied2[d2] == true){
				int max = -1;
				for(int i = 0; i < dist.length; i++){
					max = Math.max(max, dist[i]);
				}
				answer = max;
			}
		}
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int C = 11;
		int p = 2;
		System.out.println(solution(C, p));
	}

}
/*
int solve(int conyPosition, int brownPosition) {
    int time = 0;
    bool visit[200001][2];
    queue<pair<int, int> > queue;
    memset(visit, 0, sizeof(visit));
    queue.push(make_pair(brownPosition, 0));
    while (1) {
      conyPosition += time;
        if (conyPosition > 200000)
            return -1;
        if (visit[conyPosition][time % 2])
            return time;
        for (int i = 0, size = queue.size(); i < size; i++) {
            int currentPosition = queue.front().first;
            int newTime = (queue.front().second + 1) % 2;
            int newPosition;
            queue.pop();
            newPosition = currentPosition - 1;
            if (newPosition >= 0 && !visit[newPosition][newTime]) {
                visit[newPosition][newTime] = true;
                queue.push(make_pair(newPosition, newTime));
            }
            newPosition = currentPosition + 1;
            if (newPosition < 200001 && !visit[newPosition][newTime]) {
                visit[newPosition][newTime] = true;
                queue.push(make_pair(newPosition, newTime));
            }
            newPosition = currentPosition * 2;
            if (newPosition < 200001 && !visit[newPosition][newTime]) {
                visit[newPosition][newTime] = true;
                queue.push(make_pair(newPosition, newTime));
            }
        }
        time++;
    }
}
*/
package 지도칠하기;

import java.util.*;
import java.io.*;

/*도전 실패*/

public class Solution {
	static ArrayList<ArrayList<Integer>> list;
	static int N = 0;
	static int[] color;
	
	public static int solution() {
		int answer = 0;
		int count = 0;
		int[] connect = new int[N];
		boolean[] used = new boolean[4];
		boolean maze_check = false;
		boolean[] visit = new boolean[N];
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).size(); j++){
				count += list.get(i).size();
			}
		}
		if(count/N == N){
			maze_check = true;
		}
		
		boolean color_check = true;
		for(int i = 0; i < N; i++){
			if(used[color[i]-1] == false){
				used[color[i]-1] = true;
			}else{
				color_check = false;
				break;
			}
		}
		if(maze_check == true && color_check == true){
			return 0;
		}else{
			int c = 0;
			int index = 0;
			for(int i = 0; i < list.size(); i++){
				connect[i] = list.get(i).get(index);
			}
			//상황별 구현 
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int loop = Integer.parseInt(st.nextToken());
		for (int i = 0; i < loop; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			color = new int[N];
			st = new StringTokenizer(br.readLine());
			list = new <ArrayList<Integer>>ArrayList();

			for (int j = 0; j < N; j++) {
				color[j] = Integer.parseInt(st.nextToken());
				list.add(new ArrayList<Integer>());
			}

			for (int z = 0; z < N; z++) {
				st = new StringTokenizer(br.readLine());
				for (int p = 0; p < N; p++) {
					int t = Integer.parseInt(st.nextToken());
					if (p != z && t == 1) {
						list.get(z).add(p);
					}
				}
			}
			System.out.println(solution());
		}

	}

}

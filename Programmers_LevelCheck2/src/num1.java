import java.util.*;

public class num1 {

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> hot = new PriorityQueue();
		Arrays.sort(scoville);
		for (int i : scoville) {
			hot.add(i);
		}

		int sc = 0;
		boolean check = false;
		while (!check) {
			if (hot.size() == 1 && hot.poll() < K) {
				answer = -1;
				break;
			} else {
				sc = hot.poll() + (hot.poll() * 2);
				hot.add(sc);
				answer++;

				if (hot.peek() >= K) {
					check = true;
					break;
				} else {
					continue;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;

		System.out.println(solution(scoville, K));
	}

}

package num4;
import java.util.*;
public class Solution {
	public static int solution(int[] priorities, int location) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : priorities){ 
			list.add(i);
		}
		int loc = location;
		int cnt = 0;
		
		/* 2 */
		while (!list.isEmpty()) {
			/* 3 */
			int max_priority = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				/* 4 */
				if (list.get(0) < list.get(i)) {
					if (loc == 0){ 
						loc = list.size() - 1;
					}
					else{
						loc--;
					}
					
					/* 5 */
					int tmp_priority = list.get(0);
					list.remove(0);
					list.add(tmp_priority);
					max_priority = 0;
					break;
				}
			}
			
			/* 6 */
			if (max_priority != 0) {
				list.remove(0);
				cnt++;
				if (loc == 0){ 
					break;
				}
				else loc--;
			}
		}

		return cnt;
    }
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] pri = {2, 1, 3, 2};
		int loc = 2;	//내 문서가 현재 대기목록의 어떤 위치에 있는지 알려줌
		solution(pri, loc);
	}

}

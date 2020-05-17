import java.util.*;

public class num1 {
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long max = 0;	//최악의 시간
        long min = 0;
        long mid = 0;
        for(int i : times){
        	if(i > max){
        		max = i;
        	}
        }
        max = max*n;
        while(min <= max){
            mid = (min+max)/2;
            long cnt = 0;	//심사가능한 수
            for (int time : times) {
                cnt += mid / time;
            }
            if(cnt<n){	//심사 다 못할 경우
                min = mid+1;
            }
            else{	//시간이 여유있거나, 맞는 경우
                if (mid < answer) {	//가장 빠른 시간
                    answer = mid;
                }
                max = mid-1;
            }
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int n = 6;
		int[] times = {7,10};
		System.out.println(solution(n, times));
	}

}

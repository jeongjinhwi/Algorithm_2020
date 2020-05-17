import java.util.*;

public class num1 {
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long max = 0;	//�־��� �ð�
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
            long cnt = 0;	//�ɻ簡���� ��
            for (int time : times) {
                cnt += mid / time;
            }
            if(cnt<n){	//�ɻ� �� ���� ���
                min = mid+1;
            }
            else{	//�ð��� �����ְų�, �´� ���
                if (mid < answer) {	//���� ���� �ð�
                    answer = mid;
                }
                max = mid-1;
            }
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int n = 6;
		int[] times = {7,10};
		System.out.println(solution(n, times));
	}

}

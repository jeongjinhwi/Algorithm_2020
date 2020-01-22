package num3;
import java.util.*;
public class Solution {
	 public static int solution(int[][] jobs) {
	        int answer = 0;
	        Queue<Job> job = new PriorityQueue<Job>();
	        ArrayList<Job> list = new ArrayList<>();	//timer와 useTime넣기 위해
	        
	        for(int i = 0; i<jobs.length; i++){
	        	job.add(new Job(jobs[i][0], jobs[i][1]));
	        }
	        for(int i = 0; i<jobs.length; i++){
	        	list.add(job.poll());
	        }
	        int complete_time = 0;
	        while(list.size()>0){
		        for(int i = 0; i<list.size(); i++){
		        	if(complete_time >= list.get(i).timer){
			        	complete_time = list.get(i).useTime + complete_time;
			        	answer = answer + complete_time - list.get(i).timer;
			        	list.remove(i);
			        	break;
		        	}
		        	if(i == list.size() -1){
		        		complete_time++;
		        	}
		        			
		        }
	        }
	        answer = answer / jobs.length;
	        
	        return answer;
	  }

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};	//[i][j] i는 요청 시간(timer), j는 소요시간(useTime)
		System.out.println(solution(jobs));
	}

}
class Job implements Comparable<Job> {
    int timer;
    int useTime;
    
    public Job(int timer, int useTime) {
        this.timer = timer;
        this.useTime = useTime;
    }
    
    @Override
    public int compareTo(Job job) {	//우선 순위 설정(소요시간)
        if (this.useTime > job.useTime) {
        	return 1;
        }else if (this.useTime < job.useTime){ 
        	return -1;
        }
        return (this.timer < job.timer) ? -1 : 1 ; // 소요 시간이 동일할 때 순서대로 우선순위 부여
    }
}

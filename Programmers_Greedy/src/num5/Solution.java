package num5;
import java.util.*;
public class Solution {
	public static int solution(int[][] routes) {
        int answer = 0; //routes[i][0]�� ������ ����, routes[i][1]�� ���� ����
        int min = -30000;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1])); //ī�޶� ������ �������� ��ġ
       
        for(int i = 0; i<routes.length; i++){
            if(min >= routes[i][1]){ //���� ����
                min = routes[i][1];
            }
            if(min < routes[i][0]){ 
                min = routes[i][1];
                answer++;
            }
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution(routes));
	}

}

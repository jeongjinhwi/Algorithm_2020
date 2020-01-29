package num4;

public class Solution {
	public static int[] solution(int brown, int red) {
		//카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
		//brown + red = return의 2개의 수 곱한 값
        int[] answer = new int[2];
        int garo = 0;
        int sero = 0;
        int data = brown + red;
        int minimum_use_block = 2005000;
        for(int i = 1; i <= data/2; i++){
        	sero = data/i;
        	int sero_na = data%i;
        	garo = data/sero;
        	int garo_na = data%sero;
        	if((garo-2)*(sero-2) == red && minimum_use_block > garo+sero && garo >= sero  && sero_na == 0 && garo_na == 0){
        		minimum_use_block = garo+sero;
        		answer[0] = garo;
        		answer[1] = sero;
        		break;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int brown = 24;
		int red = 24;
		System.out.println(solution(brown, red));
	}

}

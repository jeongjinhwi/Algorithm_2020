package num3;

public class Solution {
	public static String solution(String number, int k) {
		int index = 0;
		char temp;
		StringBuilder sb = new StringBuilder(); // answer시간 오류 날때 해주는 것

		if (number.charAt(0) == '0') { // 숫자 0일때 예외
			return "0";
		}
		// 각 자리 숫자 하나 하나 뽑을 때마다 그때의 최대값을 선택해야 한다. 가령, 예제에서 10의 자리 숫자로 9를 선택하고 1의
		// 자리 숫자로 그 다음으로 큰 수 4를 선택해야 정답이 나온다.
		// 인덱스가 0부터 시작할 때, k개의 숫자를 뺏을 때 최대 숫자는 적어도 0번째부터 k번째 숫자 중에 나와야 한다. 
		// (예제에 따르면, 1부터 2까지 중 숫자 하나를 골라야 마지막 숫자 4를 골랐을 때 답변의 총 길이가 2가 된다.)
		// 만약 첫번째 숫자로 4를 고르면 그 다음 숫자를 고를 수 없으므로 정답이 될 수 없다.
		// 따라서 범위는 int i = 0; i < number.length() - k; i++이다.
		// 지금 위치부터 그 다음 숫자를 뽑을 때까지 과정 역시 위와 같다. 범위는 int j = idx; j <= k + i; j++이다.

		for (int i = 0; i < number.length() - k; i++) {
			temp = '0';
			for (int j = index; j <= k + i; j++) {
				if (number.charAt(j) > temp) {
					index = j + 1;
					temp = number.charAt(j);
				}
			}
			sb.append(temp);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String num = "1924";
		int k = 2;
		System.out.println(solution(num, k));
	}

}

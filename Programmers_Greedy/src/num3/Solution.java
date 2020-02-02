package num3;

public class Solution {
	public static String solution(String number, int k) {
		int index = 0;
		char temp;
		StringBuilder sb = new StringBuilder(); // answer�ð� ���� ���� ���ִ� ��

		if (number.charAt(0) == '0') { // ���� 0�϶� ����
			return "0";
		}
		// �� �ڸ� ���� �ϳ� �ϳ� ���� ������ �׶��� �ִ밪�� �����ؾ� �Ѵ�. ����, �������� 10�� �ڸ� ���ڷ� 9�� �����ϰ� 1��
		// �ڸ� ���ڷ� �� �������� ū �� 4�� �����ؾ� ������ ���´�.
		// �ε����� 0���� ������ ��, k���� ���ڸ� ���� �� �ִ� ���ڴ� ��� 0��°���� k��° ���� �߿� ���;� �Ѵ�. 
		// (������ ������, 1���� 2���� �� ���� �ϳ��� ���� ������ ���� 4�� ����� �� �亯�� �� ���̰� 2�� �ȴ�.)
		// ���� ù��° ���ڷ� 4�� ���� �� ���� ���ڸ� �� �� �����Ƿ� ������ �� �� ����.
		// ���� ������ int i = 0; i < number.length() - k; i++�̴�.
		// ���� ��ġ���� �� ���� ���ڸ� ���� ������ ���� ���� ���� ����. ������ int j = idx; j <= k + i; j++�̴�.

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
		// TODO �ڵ� ������ �޼ҵ� ����
		String num = "1924";
		int k = 2;
		System.out.println(solution(num, k));
	}

}

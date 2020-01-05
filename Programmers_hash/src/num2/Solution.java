package num2;

public class Solution {
	 public boolean solution(String[] phone_book) {
	        boolean answer = true;

			for (int i = 0; i < phone_book.length - 1; i++) {
				for (int j = i + 1; j < phone_book.length; j++) {

					if (phone_book[i].startsWith(phone_book[j]) == true) {	//i번째가 j번째로 시작하는지 확인
						return false;
					} else if (phone_book[j].startsWith(phone_book[i]) == true) {		//j번재가 i번째로 시작하는지 확인
						return false;
					}
				}
			}
			return answer;
	    }
}

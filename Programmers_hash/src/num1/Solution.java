package num1;

import java.util.HashMap;

public class Solution {
	public String solution(String[] participant, String[] completion) {
	       String answer = "";
	        HashMap<String, Integer> hashMap = new HashMap<>();

	        for (String s : participant) {
	            if (!hashMap.containsKey(s)) {
	                hashMap.put(s, 0);
	            }
	            hashMap.put(s, hashMap.get(s) + 1);
	        }

	        for (String s : completion) {
	            hashMap.put(s, hashMap.get(s) - 1);
	        }

	        for (String s : hashMap.keySet()) {
	            if (hashMap.get(s) != 0) {
	                return s;
	            }
	        }
	        return answer;
	    }
}

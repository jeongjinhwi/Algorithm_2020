package num2;
import java.util.*;
public class Solution {
	/***************�� Ǯ�� Ʋ��...33��**************/
	/*
	 public static int solution(String numbers) {
	        int answer = 0;
	        String[] str = numbers.split("");
	        char[] data = new char[str.length];
	        ArrayList<String> list = new ArrayList<>();
	        for(int i = 0; i<str.length; i++){
	        	data[i] = numbers.charAt(i);
	        	list.add(str[i]);
	        }
	        String str2 = "";
	        perm(list, data, 0, data.length, data.length, str2);
	        HashSet<String> distinctData = new HashSet<String>(list);
            list = new ArrayList<String>(distinctData);
	        
	        for(int i = 0; i<list.size(); i++){
	        	if(list.get(i).startsWith("0") || list.get(i).equals("1")){
	        		continue;
	        	}else{
	        		int temp = Integer.parseInt(list.get(i));
	        		for(int j = 2; j<=temp; j++){
	        			int d = temp%j;
	        			if(d == 0 && j == temp){
	        				answer++;
	        			}else if(d == 0 && j!=temp){
	        				break;
	        			}
	        		}
	        	}
	        }
	        	
	        return answer;
	    }
	 public static void perm(ArrayList<String> list, char[] arr, int depth, int n, int k, String str2) {
			if (depth == k) { // �ѹ� depth �� k�� �����ϸ� ����Ŭ�� ������. �����.
				if(arr[0] == '0'){
					for(int i = 1; i<arr.length; i++){
						str2 = str2 + arr[i];
					}
				}else{
					for(int i = 0; i<arr.length; i++){
						str2 = str2 + arr[i];
					}
				}
				list.add(str2);
				return;
			}

			for (int i = depth; i < n; i++) {
				swap(arr, i, depth);
				perm(list, arr, depth + 1, n, k, str2);
				swap(arr, i, depth);
			}

		}

		// �ڹٿ����� �����Ͱ� ���� ������ �Ʒ��� ����, �ε��� i�� j�� ���� �ٲ���.
		public static void swap(char[] arr, int i, int j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		*/
public static int solution(String numbers) {
		
		int answer = 0;

		String[] nums = numbers.split("");

		Arrays.sort(nums,Collections.reverseOrder());

		String arrayNumber ="";

		for ( String num : nums ) {
			arrayNumber+=num;
		}

		int max = Integer.valueOf(arrayNumber);

		int[] visits = new int[max+1];

		List<Integer> prime = new ArrayList<Integer>();

		// �Ҽ� üũ. 0�̸� �Ҽ���.
		for ( int i = 2 ; i <= max; i++  ) {
			if ( visits[i] == 1 ) continue;
			for ( int j = 2*i; j <= max ; j+=i) {
				visits[j] = 1;
			}

			// �Ҽ��� 1�������� �Ÿ���. ����� numbers�� �ش���� �ʴ� ���� �������ִٸ� ó������̾ƴϴ�.
			String[] iS = String.valueOf(i).split("");
			boolean possible = true;

			for ( int k = 0 ; k < iS.length; k++ ) {
				if ( !numbers.contains(iS[k])) {
					possible = false;
					break;
				}
			}
			// 2�������� �Ÿ���. ����� ������ �� ���� ���� �������ִ� ��츦 üũ�Ѵ�.
			StringBuilder temp = new StringBuilder(numbers);
			
			for ( int r = 0 ; r < iS.length; r++ ) {
				int index = temp.indexOf(iS[r]);
				if ( index == -1 ) {
					possible = false;
					break;
				}
				else temp.setCharAt(index, '#');
			}
			if ( possible ) prime.add(i);
		}

		answer = prime.size();

		return answer;
	}
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		 String num = "17";
		
		System.out.println(solution(num));
	}

}

package �Ǻ���ġ��5;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO �ڵ� ������ �޼ҵ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		System.out.println(fibo(N));
	}

	public static int fibo(int N) {
		if (N == 0) {
			return 0;
		}
		else if(N == 1){
			return 1;
		}
		else {
			return fibo(N - 2) + fibo(N - 1);
		}
	}
}

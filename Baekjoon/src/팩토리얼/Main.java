package 팩토리얼;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if(N > 0){
		System.out.println(fac(N));
		}else{
			System.out.println(1);
		}
	}

	public static long fac(long N) {
		while (N > 1) {
			N = N* fac(N - 1);
			return N;
		}
		return N;
	}
}

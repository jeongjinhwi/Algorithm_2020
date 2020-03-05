package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int data[];
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int testnumber = Integer.parseInt(st.nextToken()); // N
		int K = Integer.parseInt(st.nextToken());

		data = new int[testnumber];

		for (int i = 0; i < testnumber; i++) {
			st = new StringTokenizer(br.readLine());

			data[i] = Integer.parseInt(st.nextToken());
		}
		
		find_value(K);
		System.out.println(count);
	}
	
	public static void find_value(int K){
		int divide;
		for(int i = data.length-1; i>=0; i--){
			if ( K >= data[i]){
				divide = K/data[i];
				K = K%data[i];
				count = count + divide;
			}
		}
	}
}
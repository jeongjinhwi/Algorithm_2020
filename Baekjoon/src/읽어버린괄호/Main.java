package 읽어버린괄호;
import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String[] input = str.split("\\-");
		
		int answer = 0;
		for(int i = 0; i < input.length; i++){
			String[] temp = input[i].split("\\+");
			int result = 0;
			for(int j = 0; j < temp.length; j++){
				result += Integer.parseInt(temp[j]);
			}
			if(i == 0){
				answer = result;
			}else{
				result = result*-1;
				answer+=result;
			}
		}
		
		System.out.println(answer);
	}
}

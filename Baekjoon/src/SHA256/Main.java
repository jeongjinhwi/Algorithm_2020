package SHA256;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		System.out.println(sha256(st.nextToken()));
	}
	public static String sha(byte[] cs){
		StringBuilder sb = new StringBuilder();
		for(byte b : cs){
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	 public static String sha256(String msg) throws NoSuchAlgorithmException {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(msg.getBytes());
	        
	        return sha(md.digest());
	    }


}

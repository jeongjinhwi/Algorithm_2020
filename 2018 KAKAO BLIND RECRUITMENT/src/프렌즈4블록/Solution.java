package 프렌즈4블록;

import java.util.*;

public class Solution {
	static int count = 0;
	static boolean ch = false;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		String[][] data = new String[m][n];
		boolean[][] deleted = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				data[i][j] = Character.toString(board[i].charAt(j));
			}
		}

		while (ch == false) {
			block(m, n, data, deleted);
		}
		answer = count;
		return answer;
	}

	public static void block(int m, int n, String[][] data, boolean[][] deleted) {
		ch = true;
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (data[i][j] != null && (data[i][j].equals(data[i][j + 1])) && (data[i][j].equals(data[i + 1][j]))
						&& (data[i][j].equals(data[i + 1][j + 1]))) {
					deleted[i][j] = deleted[i + 1][j] = deleted[i][j + 1] = deleted[i + 1][j + 1] = true;
					ch = false;
				}
			}
		}
		for (int i = 0; i < m; i++) { // 제거
			for (int j = 0; j < n; j++) {
				if (deleted[i][j] == true) {
					count++;
					deleted[i][j] = false;
					for (int k = i - 1; k >= 0; k--) {
						data[k + 1][j] = data[k][j];
						data[k][j] = null;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int m1 = 4;
		int n1 = 5;
		String[] board1 = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int m2 = 6;
		int n2 = 6;
		String[] board2 = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		int m3 = 8;
		int n3 = 5;
		String[] board3 = { "HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK" };
		System.out.println(solution(m3, n3, board3));
	}

}

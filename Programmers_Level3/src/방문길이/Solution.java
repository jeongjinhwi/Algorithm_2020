package πÊπÆ±Ê¿Ã;

import java.util.*;

public class Solution {
	public static int solution(String dirs) {
		ArrayList<Position> list = new ArrayList<Position>();
		Position ps;
		int answer = 0;
		int x = 0;
		int y = 0;
		char[] array = dirs.toCharArray();
		for (int i = 0; i < array.length; i++) {
			boolean check = true;
			if (array[i] == 'L') {
				if (x - 1 < -5) {
					continue;
				}
				for (int j = 0; j < list.size(); j++) {
					ps = list.get(j);
					if (ps.s_x == x && ps.s_y == y && ps.e_x == x - 1 && ps.e_y == y) {
						x--;
						check = false;
						break;
					}
				}

				if (check == true) {
					list.add(new Position(x, y, x - 1, y));
					list.add(new Position(x - 1, y, x, y));
					x--;
					answer++;
				}

			} else if (array[i] == 'R') {
				if (x + 1 > 5) {
					continue;
				}

				for (int j = 0; j < list.size(); j++) {
					ps = list.get(j);
					if (ps.s_x == x && ps.s_y == y && ps.e_x == x + 1 && ps.e_y == y) {
						x++;
						check = false;
						break;
					}
				}

				if (check == true) {
					list.add(new Position(x, y, x + 1, y));
					list.add(new Position(x + 1, y, x, y));
					x++;
					answer++;
				}

			} else if (array[i] == 'U') {
				if (y + 1 > 5) {
					continue;
				}
				for (int j = 0; j < list.size(); j++) {
					ps = list.get(j);
					if (ps.s_x == x && ps.s_y == y+1 && ps.e_x == x && ps.e_y == y) {
						y++;
						check = false;
						break;
					}
				}
				if (check == true) {
					list.add(new Position(x, y, x, y + 1));
					list.add(new Position(x, y + 1, x, y));
					y++;
					answer++;
				}

			} else if (array[i] == 'D') {
				if (y - 1 < -5) {
					continue;
				}
				for (int j = 0; j < list.size(); j++) {
					ps = list.get(j);
					if (ps.s_x == x && ps.s_y == y-1 && ps.e_x == x && ps.e_y == y) {
						y--;
						check = false;
						break;
					}
				}
				 if(check == true){
					list.add(new Position(x, y, x, y - 1));
					list.add(new Position(x, y - 1, x, y));
					y--;
					answer++;
				} 
			}
		}
		return answer;

	}

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
	}
}

class Position {
	int s_x; // Ω√¿€ x¡¬«•
	int s_y; // Ω√¿€ y¡¬«•
	int e_x; // µµ¬¯ x¡¬«•
	int e_y; // µµ¬¯ y¡¬«•

	public Position(int s_x, int s_y, int e_x, int e_y) {
		this.s_x = s_x;
		this.s_y = s_y;
		this.e_x = e_x;
		this.e_y = e_y;
	}
}
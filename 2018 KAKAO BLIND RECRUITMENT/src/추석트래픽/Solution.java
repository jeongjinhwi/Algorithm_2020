package 추석트래픽;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
	public static int solution(String[] lines) {
		int answer = 0;
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
		Date[] end = new Date[lines.length];
        Date[] start = new Date[lines.length];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < lines.length; i++) {
                String[] line = lines[i].split(" ");
                String dateStr = line[0] + " " + line[1];
                int seconds = (int) (Double.parseDouble(line[2].substring(0, line[2].length()-1)) * -1000);
                try {
					end[i] = format.parse(dateStr);
				} catch (ParseException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
                start[i] = addTime(end[i], seconds + 1);
        }
        for(int i = 0; i < end.length; i++){
        	int temp = 0;
        	long endmilliEnd = end[i].getTime();
            long endmilli_add_second = addTime(end[i], 1000).getTime();
			
            for(int j = 0; j < start.length; j++) {
                long startmilli = start[j].getTime();
                long endmilli = end[j].getTime();
                if(endmilli_add_second <= startmilli) {
                    continue;
                }
                if((endmilliEnd <= startmilli && endmilli_add_second > startmilli)
                    || (endmilliEnd  <= endmilli && endmilli_add_second > endmilli)
                    || (endmilliEnd > startmilli && endmilliEnd <= endmilli)) {
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }
        answer = max;
		return answer;
	}
     public static Date addTime(Date date, int seconds){
    	  Calendar cal = Calendar.getInstance();
          cal.setTime(date);
          cal.add(Calendar.MILLISECOND, seconds);
          return cal.getTime();
     }

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		System.out.println(solution(lines));
	}

}



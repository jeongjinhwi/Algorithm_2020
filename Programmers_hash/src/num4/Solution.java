package num4;
import java.util.*;
//��Ǯ�� ���� 46.7

public  class Solution {
	public static int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};
	        Map<String, Integer> m_list = new HashMap<>();
	        Map<Integer,Integer> plays_list = new HashMap<>();
	        List<Integer> result_list = new ArrayList<Integer>();
	        List<Integer> result_play = new ArrayList<Integer>();
	        ArrayList<Integer> temp_answer = new ArrayList<>();
	        String temp = "";
	        
	        for(int i = 0; i<genres.length; i++){
	        	if(m_list.containsKey(genres[i]) == false){
	        		m_list.put(genres[i], plays[i]);
	        		temp = temp+genres[i]+" ";
	        	}else if(m_list.containsKey(genres[i]) == true){
	        		m_list.put(genres[i], m_list.get(genres[i])+plays[i]);
	        	}
	        }
	        
	        //���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
	        answer = new int[m_list.size()*2];
	        String[] result_ge = temp.split(" ");
	        Integer[] result_pl = new Integer[m_list.size()];
	        String[] most_ge = new String[m_list.size()];
	        result_list.addAll(m_list.values());
	        for(int i = 0; i<m_list.size(); i++){
	        	result_pl[i] = result_list.get(i);
	        }
			Arrays.sort(result_pl,Collections.reverseOrder());
			
			for(int i = 0; i<result_pl.length; i++){
				for(int j = 0; j<result_ge.length; j++){
					if(result_pl[i] == m_list.get(result_ge[j])){
						most_ge[i] = result_ge[j];
					}
				}
			}
			
	        //�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
			//�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
			for(int i = 0; i<most_ge.length; i++){
				plays_list = new HashMap<Integer, Integer>();
				int count = 0;
				for(int j = 0; j<genres.length; j++){
					if(most_ge[i].equals(genres[j])){
						plays_list.put(j, plays[j]);
						count++;
					}
				}
				Integer[] play_index = new Integer[count];
				result_play = new ArrayList<Integer>();
				result_play.addAll(plays_list.values());
				for(int k = 0; k<play_index.length; k++){
		        	play_index[k] = result_play.get(k);
		        }
				Arrays.sort(play_index,Collections.reverseOrder());
				int add_count = 0;
				for(int j = 0; j<most_ge.length; j++){
					for(int k = 0; k<play_index.length; k++){
						if(most_ge[i].equals(genres[j])){	//key�� j
							for(int z = 0; z<plays.length; z++){
								if(play_index[k] == plays[z] && add_count < 2 && play_index.length != 1){
									add_count++;
									temp_answer.add(z);
								}else if(play_index[k] == plays[z] && play_index.length == 1){	//���� 1���� ���
									temp_answer.add(z);
									break;
								}
							}
						}
					}
				}
				
			}
			answer = new int[temp_answer.size()];
		    for (int i=0; i < answer.length; i++)
		    {
		        answer[i] = temp_answer.get(i).intValue();
		    }
	        
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		String[] ge = {"classic", "pop", "classic", "classic", "pop"};
		int[] play = {500, 600, 150, 500, 2500};
		
		System.out.println(solution(ge,play));
	}

}

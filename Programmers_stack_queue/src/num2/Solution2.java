package num2;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //�ٸ��� �ǳʱ� ���� ��� Ʈ�� ����Ʈ 
        Queue<Truck> q_wait = new LinkedList<>();
        
        //�ٸ��� �ǳʴ� Ʈ�� ����Ʈ 
        Queue<Truck> q_onBridge = new LinkedList<>();
        
        int onBridgeWeight = 0;
        
        for (int w : truck_weights) {
            q_wait.add(new Truck(w, 0));
        }
        
        onBridgeWeight += q_wait.peek().weight;
        q_onBridge.add(q_wait.poll());
        
        int time = 0;
        
        while(!q_onBridge.isEmpty()) {
            time++;
            
            for (Truck t : q_onBridge) {
                //�ٸ��� Ʈ������ ������ 
                t.index++;
            }
            
            //Ʈ���� �ٸ� ���� �ٴٸ� 
            if (q_onBridge.peek().index > bridge_length) {
                onBridgeWeight -= q_onBridge.poll().weight;
            }
            
            //��� �� Ʈ���� �ٸ��� �ø� (���� ����ؾ��� )
            if (!q_wait.isEmpty() && q_wait.peek().weight + onBridgeWeight <= weight ) {
                onBridgeWeight += q_wait.peek().weight;
                q_wait.peek().index++;
                q_onBridge.add(q_wait.poll());
            }
        } //while �� 
        
        answer = time;
        
        return answer;
    }
    static class Truck {
        int weight;
        int index;
        
        public Truck (int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }
}

package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5464 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] currentPark = new int[N+1];
		int[] weight = new int[M+1];
		int[] rs = new int[N+1];
		
		int sum = 0;
		
		PriorityQueue<Integer> parks = new PriorityQueue<>();
		for(int i=1; i<= N; i++) {
			rs[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1; i<= M; i++) {
			weight[i] = Integer.parseInt(br.readLine());
			parks.add(i);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		outer : for(int i=0; i<2 *M; i++) {
			int car = Integer.parseInt(br.readLine());
			if(car > 0) {
				for(int j=1; j<N+1; j++) {
					if(currentPark[j] == 0) {
						currentPark[j] = car;
						continue outer;
					}
				}
				queue.offer(car);
			}
			else {
				for(int j=1; j<N+1; j++) {
					if(currentPark[j] == car * -1) {
						currentPark[j] = 0;
						sum += rs[j] * weight[car * -1];
						if(!queue.isEmpty())
							currentPark[j] = queue.poll();
						break;
					}
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
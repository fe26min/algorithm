package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13335 {
	static int n, w, L;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int time = 0;
		int idx = 0;
		int sum = 0;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		while(idx<n || !queue.isEmpty()) {
			
			time++;
//			System.out.println(time + " " + sum);
			if(!queue.isEmpty()) {
				if(queue.peek()[1] <= time) {
//					System.out.println("POLL : " + time + " " + queue.peek()[0] + " " + queue.peek()[1]);
					sum -= queue.poll()[0];
				}
			}
			if(queue.size() < w && idx < n && arr[idx] + sum <= L) {
//				System.out.println("PUT : " + time + " " + arr[idx] + " " + (time + w));
				sum += arr[idx];
				queue.add(new int[] {arr[idx++], time + w});
			}
		}
		System.out.println(time);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}

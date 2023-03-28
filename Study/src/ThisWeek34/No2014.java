package ThisWeek34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2014 {
	static int K, N;
	static long[] arr;
	static PriorityQueue<Long> pq;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		long ans = 0;
		while(N-- > 0) {
			ans = pq.poll();
			System.out.println(ans);
			for(int i=0; i<K; i++) {
				if((ans * arr[i]) >= ((long) 2 << 20)) {
					break;
				}
				pq.add(ans * arr[i]);
				if(ans % arr[i] == 0) {
					break;
				}
			}
		}

		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		
		arr = new long[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			pq.add(arr[i]);
		}
		
		br.close();
	}
}

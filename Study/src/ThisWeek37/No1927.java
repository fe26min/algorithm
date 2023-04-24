package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No1927 {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(pq.size() == 0)
					sb.append("0\n");
				else
					sb.append(pq.poll() + "\n");
			}
			else
				pq.add(n);
		}
		System.out.println(sb);
		br.close();
	}
}

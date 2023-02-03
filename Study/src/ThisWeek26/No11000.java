package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Time timeTable[] = new Time[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			timeTable[i] = new Time(S,E);
		}
		
		Arrays.sort(timeTable, (l1, l2) -> l1.s == l2.s ? l1.e - l2.e : l1.s - l2.s);
		int e = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(timeTable[0].e);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= timeTable[i].s) {
				pq.poll();
			}
			pq.add(timeTable[i].e);
		}
		
		System.out.println(pq.size());
		
		br.close();
	}
}
class Time {
	int s, e;
	
	public Time(int s, int e) {
		this.s = s;
		this.e = e;
	}
}
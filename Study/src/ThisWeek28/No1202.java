package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {
	//dp 문제
	//여러 개의 가방을 가지고 있다.
	
	static int N, K;
	static Treasure[] treasures;
	static int[] bag;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		Arrays.sort(treasures);
		Arrays.sort(bag);
		
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		// 가방에 담자
		for(int i=0, j=0; i<K; i++) {
			// i번째 가방에 담을 수 있는 것들을 넣는다.
			while(j < N && treasures[j].m <= bag[i]) {
				pq.add(treasures[j++].v);
			}
			
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		treasures = new Treasure[N];
		bag = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			treasures[i] = new Treasure(m, v);
		}
		
		for(int i=0; i<K; i++) {
			int C = Integer.parseInt(br.readLine());
			bag[i] = C;
		}
		br.close();
	}
}

class Treasure implements Comparable<Treasure>{
	int m, v;
	
	public Treasure(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public int compareTo(Treasure o) {
		if(this.m == o.m) {
			return o.v - this.v;
		}
		return this.m - o.m;
	}
}
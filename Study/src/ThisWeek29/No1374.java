package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1374 {
	static int N;
	static PriorityQueue<Node1374> times;
	
	public static void main(String[] args) throws IOException {
		input(); 
		pro();
	}

	private static void pro() {
		int cnt = 0;
		// 끝나는 시간으로 정렬
		PriorityQueue<Integer> curTable = new PriorityQueue<>();
		while(!times.isEmpty()) {
			Node1374 cur = times.poll();
			
			while(!curTable.isEmpty() && cur.s >= curTable.peek()) {
				curTable.poll();
			}
			curTable.add(cur.e);
			cnt = Math.max(cnt, curTable.size());
		}
		System.out.println(cnt);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 
		 times = new PriorityQueue<>();
		 for(int i=0; i<N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());

			 int idx = Integer.parseInt(st.nextToken());
			 int s = Integer.parseInt(st.nextToken());
			 int e = Integer.parseInt(st.nextToken());
			 times.add(new Node1374(idx, s, e));
		 }
		 
		 br.close();
	}
}

class Node1374 implements Comparable<Node1374> {
	int idx, s, e;
		
	public Node1374(int idx, int s, int e) {
		this.idx = idx;
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Node1374 o) {
		return this.s - o.s;
	}
}

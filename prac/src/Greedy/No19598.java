package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No19598 {
	static int N;
	static PriorityQueue<Node19598> times;
	
	public static void main(String[] args) throws IOException {
		input(); 
		pro();
	}

	private static void pro() {
		int cnt = 0;
		// 끝나는 시간으로 정렬
		PriorityQueue<Integer> curTable = new PriorityQueue<>();
		while(!times.isEmpty()) {
			Node19598 cur = times.poll();
			
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

			 int s = Integer.parseInt(st.nextToken());
			 int e = Integer.parseInt(st.nextToken());
			 times.add(new Node19598(s, e));
		 }
		 
		 br.close();
	}
}

class Node19598 implements Comparable<Node19598> {
	int s, e;
		
	public Node19598(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Node19598 o) {
		return this.s - o.s;
	}
}

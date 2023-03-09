package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1931 {
	static int N;
	static PriorityQueue<Node1931> que;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int cnt = 0;
		int idx = 0;
		
		while(!que.isEmpty()) {
			if(idx <= que.peek().s) {
				cnt++;
				idx = que.poll().e;
			}
			else {
				que.poll();
			}
		}
		System.out.println(cnt);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		que = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
				
			que.add(new Node1931(s, e));
		}
		
		br.close();		
	}
}

class Node1931 implements Comparable<Node1931>{
	int s, e;
	
	public Node1931(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Node1931 o) {
		if(this.e == o.e)
			return this.s - o.s;
		return this.e - o.e;
	}
}
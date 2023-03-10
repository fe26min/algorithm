package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11085 {
	static PriorityQueue<Bridge11085> bridges;
	static int[] parent;
	static int p, c, v;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int answer = 1001;
		
		while(!bridges.isEmpty()) {
			Bridge11085 head = bridges.poll();
			answer = head.w;
			merge(head.s, head.e);
			
			if(! ((parent[c] == -1) && (parent[v] == -1)
					) && (find(c) == find(v))
			)
				break;
		}
		System.out.println(answer);
	}

	private static int find(int idx) {
		if(parent[idx] == -1)
			return idx;
		else {
			parent[idx] = find(parent[idx]);
			return parent[idx];
		}
	}

	private static void merge(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent != bParent)
			parent[bParent] = a;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		bridges = new PriorityQueue<Bridge11085>();
		parent = new int[p];
		for(int i=0; i<p; i++) {
			parent[i] = -1;
		}
		
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		while(w-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			bridges.offer(new Bridge11085(a, b, width));
		}
		br.close();
	}
}

class Bridge11085 implements Comparable<Bridge11085>{
	int s;
	int e;
	int w;
	
	public Bridge11085(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
	
	@Override
	public int compareTo(Bridge11085 o) {
		
		return o.w - this.w;
	}
}
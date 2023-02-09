package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11085 {
	
	static PriorityQueue<Bridge> bridges;
	static int[] parent;
	static int p, c, v;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		bridges = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<w; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			
			bridges.offer(new Bridge(s, e, width));
		}
		br.close();
	}
	
	private static void pro() {
		parent = new int[p];
		for(int i=0; i<p; i++) {
			parent[i] = -1;
		}
		
		int lastWidth = 1001;
		while(!bridges.isEmpty()) {
			Bridge head = bridges.poll();
			lastWidth = head.width;
			
			merge(head.nodeA, head.nodeB);
			if(! ((parent[c] == -1) && (parent[v] == -1)
					) && (find(c) == find(v))
			)
				break;
		}
		System.out.println(lastWidth);
	}

	private static int find(int id) {
		if(parent[id] == -1) return id;
		else {
			parent[id] = find(parent[id]);
			return parent[id];
		}
	}

	private static void merge(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent != bParent)
			parent[bParent] = a;
	}
}

class Bridge implements Comparable<Bridge>{
	public int nodeA;
	public int nodeB;
	public int width;
	
	public Bridge(int nodeA, int nodeB, int width) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.width = width;
	}

	@Override
	public int compareTo(Bridge o) {
		return o.width - this.width;
	}
}

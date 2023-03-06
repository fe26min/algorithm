package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1922 {
	static int N, M, parents[];
	static Node1922[] nodeList;
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(pro());
	}
	private static int pro() {
		int res = 0, cnt = 0;
		
		Arrays.sort(nodeList);
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(Node1922 node : nodeList) {
			if(union(node.s, node.e)) {
				res += node.c;
				if(++cnt == N - 1) {
					return res;
				}
			}
		}
		return res;
	}
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot)
			return false;
		parents[xRoot] = yRoot;
		return true;
	}
	private static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		nodeList = new Node1922[M];
		parents = new int[N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			nodeList[i] = new Node1922(s,e,c);
		}
		
		br.close();
	}
}

class Node1922 implements Comparable<Node1922>{
	int s, e, c;
	public Node1922(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
	@Override
	public int compareTo(Node1922 o) {
		return this.c - o.c;
	}
	
}
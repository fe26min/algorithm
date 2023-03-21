package ThisWeek32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		List<Node1446> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(e > D) continue;
			if(e-s <= w) continue;
			list.add(new Node1446(s, e, w));
		}
		
		Collections.sort(list);
		
		int idx = 0, move = 0;
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		dist[0] = 0;
		while(move <= D) {
			if(idx < list.size()) {
				Node1446 cur = list.get(idx);
				if(move == cur.s) {
					dist[cur.e] = Math.min(dist[move] + cur.w, dist[cur.e]);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			}
			else {
				dist[move + 1] = Math.min(dist[move+1], dist[move] + 1);
				move++;
			}
		}
		System.out.println(dist[D]);
	}
}

class Node1446 implements Comparable<Node1446>{
	int s, e, w;
	public Node1446(int s, int e, int w) {
		this.s = s; 
		this.e = e; 
		this.w = w; 
	}
	
	@Override
	public int compareTo(Node1446 o) {
		if(this.s == o.s)
			return this.e - o.e;
		return this.s - o.s;
	}
}

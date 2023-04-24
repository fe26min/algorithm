package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1766 {
	static int N;
	static ArrayList<Integer>[] tree;
	static int[] pNum;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(pNum[i]==0)
				pq.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			int p = pq.poll();
			sb.append(p + " ");
			
			for(int c : tree[p]) {
				pNum[c]--;
				if(pNum[c]==0) {
					pq.add(c);
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		pNum = new int[N+1];
		
		for(int i=1; i<=N; i++)
			tree[i] = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[p].add(c);
			pNum[c]++;
		}
		br.close();
	}
}

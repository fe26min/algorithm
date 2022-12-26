package backjoon.answer_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No9489 {
	
	static int n;
	static int[] parent;
	static ArrayList<Integer> child[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(n == 0 && k == 0) break;
			
			// 부모를 가르키는 배열
			parent = new int[n+1];
			// 자식을 가르키는 배열
			child = new ArrayList[n+1];
			
			for(int i=0; i<=n; i++)
				child[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			
			parent[0] = -1;
			int p = Integer.parseInt(st.nextToken());
			int pidx = 0;
			int kidx = -1;
			
			for(int i=2; i<=n; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num != p + 1) pidx++;
				p = num;
				parent[i] = pidx;
				child[pidx].add(i);
				if(num == k) kidx = i;
			}
			
			// 사촌의 수를 세는 문제
			pro(kidx);
			
		}
		System.out.println(sb);
		br.close();
	}

	private static void pro(int kidx) {
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			if(parent[parent[i]] == parent[parent[kidx]]) {
				if(parent[i] != parent[kidx]) count++;
			}
		}
		sb.append(count + "\n");
	}
}
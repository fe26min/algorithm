package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3584 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int ti=0; ti<T; ti++) {
			int N = Integer.parseInt(br.readLine());
			int[] parent = new int[N+1];
			boolean[] isParent = new boolean[N+1];
			
			StringTokenizer st;
			
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				parent[c] = p;
			}
			
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			isParent[A] = true;
			int B = Integer.parseInt(st.nextToken());
			isParent[B] = true;
			
			while(parent[A]!=0) {
				A = parent[A];
				isParent[A] = true;
			}
			
			while(parent[B]!=0) {
				B = parent[B];
				if(isParent[B] == true) {
					break;
				}
				isParent[B] = true;
			}
			sb.append(B +"\n");
		}
		System.out.println(sb);
		br.close();
	}
}

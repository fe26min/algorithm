package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//사촌 -> 부모 -> 부모 -> 자손 -> 자손
public class No9489 {

	static int N,K,fidx;
	static int[] arr, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			if(N==0 && K==0) break;
			
			arr = new int[N + 1];
			parent = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] == K)
					fidx = i;
			}
			
			parent[0] = -1;
			parent[1] = 0;
			
			if(N>=2)
				parent[2] = 1;
			
			int idx = 1;
			
			for(int i=3; i<=N; i++) {
				if(arr[i-1] != arr[i]-1) idx++;
				parent[i] = idx;
			}
			
			int answer = 0;
			for(int i=1; i<=N; i++) {
				if(parent[parent[i]] == parent[parent[fidx]] && parent[i] != parent[fidx]) answer++;
			}
			System.out.println(answer);
		}
		br.close();
	}
}
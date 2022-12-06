package backjoon.fastcampus.ch07.Tree_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20364 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N+1];
		int Q = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<Q; i++) {
			int want = Integer.parseInt(br.readLine());
			int path = want;
			int last = 0;
			
			while(path > 1) {
				if(arr[path]) {
					last = path;
				}
				path /= 2;
			}
			
			if(last != 0)
				sb.append(last+"\n");
			else {
				arr[want] = true;
				sb.append("0\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}

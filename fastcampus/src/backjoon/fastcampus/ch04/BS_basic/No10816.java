package backjoon.fastcampus.ch04.BS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No10816 {
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(hm.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
		}
		System.out.println(sb);
		br.close();
	}
}

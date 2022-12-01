package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<Integer> visit = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visit.add(N);
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {N, 0});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			if(cur[0]==K) {
				System.out.println(cur[1]);
				break;
			}
			int nc = cur[1] + 1;
			int nx = cur[0] - 1;
			if(nx>=0 && !visit.contains(nx)) {
				visit.add(nx);
				queue.add(new int[] {nx, nc});
			}
			
			nx = cur[0] + 1;
			if(nx < 400000 && !visit.contains(nx)) {
				visit.add(nx);
				queue.add(new int[] {nx, nc});
			}
			
			nx = cur[0] * 2;
			if(nx < 400000 && !visit.contains(nx)) {
				visit.add(nx);
				queue.add(new int[] {nx, nc});
			}
		}
		br.close();
	}
}

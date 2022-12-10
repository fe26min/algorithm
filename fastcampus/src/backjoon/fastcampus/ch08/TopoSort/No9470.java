package backjoon.fastcampus.ch08.TopoSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No9470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int ti=1; ti<=T; ti++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			Node9470[] nodeArr = new Node9470[M+1];
			int[] inCnt = new int[M+1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			
			for(int i=0; i<=M; i++) {
				nodeArr[i] = new Node9470(0, 0);
				list.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<P; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				list.get(A).add(B);
				inCnt[B]++;
			}
			
			Queue<int []> queue = new LinkedList<>();
			
			for(int i=1; i<=M; i++) {
				if(inCnt[i]==0)
					queue.add(new int[] {i, 1});
			}
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				
				for(int i : list.get(now[0])) {
					if(nodeArr[i].max < now[1]) {
						nodeArr[i].max = now[1];
						nodeArr[i].cnt = 1;
					}
					else if(nodeArr[i].max == now[1]) {
						nodeArr[i].cnt++;
					}
					
					if(--inCnt[i] == 0) {
						if(nodeArr[i].cnt > 1) nodeArr[i].max++;
						queue.add(new int[] {i, nodeArr[i].max});
					}
				}
			}
			sb.append(ti + " " + nodeArr[M].max + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
class Node9470 {
	int max, cnt;
	public Node9470 (int max, int cnt) {
		this.max = max;
		this.cnt = cnt;
	}
}
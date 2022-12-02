package backjoon.fastcampus.ch06.GS_pra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class No5567 {

	static HashMap<Integer, ArrayList<Integer>> freinds;
	static int mat[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		mat = new int[n+1];
		Arrays.fill(mat, -1);
		freinds = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=1; i<=n; i++)
			freinds.put(i, new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			freinds.get(x).add(y);
			freinds.get(y).add(x);
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {1, 0});
		
		int count = 0;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(mat[cur[0]] != -1) continue;
			mat[cur[0]] = cur[1];
			count++;
			
			if(cur[1]==2) continue;
			for(int i : freinds.get(cur[0])) {
				queue.add(new int[] {i, cur[1]+1});
			}
		}
		System.out.println(count - 1);
		br.close();
	}
}

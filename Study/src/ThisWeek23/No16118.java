package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No16118 {
	static int N;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {

		input();
		pro();
	}

	private static void pro() {
		
		int[] disF = new int[N+1];
		int[][] disW = new int[2][N+1];

		Arrays.fill(disF, Integer.MAX_VALUE);
		Arrays.fill(disW[0], Integer.MAX_VALUE);
		Arrays.fill(disW[1], Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pqF = new PriorityQueue<>(Comparator.comparing(o->o[1]));
		PriorityQueue<int[]> pqW = new PriorityQueue<>(Comparator.comparing(o->o[1]));

		pqF.add(new int[] {1, 0});
		disF[1] = 0;
		
		// 달빛 여우 다익스트라
		while(!pqF.isEmpty()) {
			int[] cur = pqF.poll();
			int pos = cur[0];
			int dis = cur[1];
			
			if(disF[pos] < dis) continue;
			
			for(int[] next : list[pos]) {
				if(disF[next[0]] > disF[pos] + next[1]) {
					disF[next[0]] = disF[pos] + next[1];
					pqF.add(new int[] {next[0], disF[next[0]]});
				}
			}
		}
//		for(int i : disF) {
//			System.out.print(i + " ");
//		}System.out.println();
		
		// 현재 위치, cost값, 현재 2배 달렸는지 아닌지(0:달림, 1: 안 달림)
		pqW.add(new int[] {1, 0, 1});
		disW[0][1] = 0;
		
		while(!pqW.isEmpty()) {
			int[] cur = pqW.poll();
			int pos = cur[0];
			int dis = cur[1];
			int dou = cur[2];
			
			if(disW[dou][pos] < dis)
				continue;
			
//			System.out.println(pos + " " + dis + " " + dou);
			for(int[] next : list[pos]) {
				int nd = next[1];
				
				if(dou == 1) {
					nd /= 2;
				}
				else if(dou == 0) {
					nd *= 2;
				}
				
				if(disW[1 - dou][next[0]] > disW[dou][pos] + nd) {
					disW[1- dou][next[0]] = disW[dou][pos] + nd;
					pqW.add(new int[] {next[0], disW[1- dou][next[0]], 1- dou});
				}
			}
		}
//		for(int i[] : disW) {
//			System.out.print(i[0] + " ");
//		}System.out.println();
//		for(int i[] : disW) {
//			System.out.print(i[1] + " ");
//		}System.out.println();
		
		int count = 0;
		for(int i=2; i<=N; i++) {
			if(disF[i]>=disW[0][i])
				continue;
			if(disF[i]>=disW[1][i])
				continue;
			count++;
		}
		System.out.println(count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 반으로 나누는 것을 좀 더 편하게 하기 위해서
			int c = Integer.parseInt(st.nextToken()) * 2;
			
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		
		br.close();
	}
}

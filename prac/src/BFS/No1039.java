package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1039 {
	static int N, K;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		Queue<int[]> queue = new LinkedList<>();
		visit = new boolean[1_000_001][K+1];
		
		queue.add(new int[] {N, 0});
		visit[N][0] = true;
		
		int max = -1;
		int len = ("" + N).length();
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[1] == K) {
				max = Math.max(max, cur[0]);
				continue;
			}
			
			for(int i=0; i<len; i++) {
				for(int j=i+1; j<len; j++) {
					int next = swap(cur[0], i, j);
					if(next == -1 || visit[next][cur[1] + 1])
						continue;
					queue.add(new int[] {next, cur[1] + 1});
					visit[next][cur[1] + 1] = true;
				}
			}
		}
		System.out.println(max);
	}

	private static int swap(int num, int i, int j) {
		char[] numChar = (""+num).toCharArray();
		
		if(i==0 && numChar[j]=='0')
			return -1;
		char temp = numChar[i];
		numChar[i] = numChar[j];
		numChar[j] = temp;
		
		return Integer.parseInt(new String(numChar));
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();		
	}
}
package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014 {
	static int F, S, G, U, D;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {S, 1});
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(cur[0] + U <= F) {
				if(cnt[cur[0] + U] == 0) {
					cnt[cur[0] + U] =  cur[1] + 1;
					queue.add(new int[] {cur[0] + U, cur[1] + 1});
				}
			}
			if(cur[0] - D > 0) {
				if(cnt[cur[0] - D] == 0) {
					cnt[cur[0] - D] =  cur[1] + 1;
					queue.add(new int[] {cur[0] - D, cur[1] + 1});
				}
			}
		}
		
//		for(int i=0; i<F; i++) {
//			System.out.print(cnt[i] + " ");
//		}System.out.println();

		if(cnt[G]==0) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(cnt[G] - 1);
		}
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		
		cnt = new int[F+1];
		
		S = Integer.parseInt(st.nextToken());
		cnt[S] = 1;
		
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		br.close();
	}
}

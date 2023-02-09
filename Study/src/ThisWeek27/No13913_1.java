package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13913_1 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		br.close();
	}
	private static void pro() {
		int max = Math.max(N + 1, 2 * K + 1);
		boolean[] visit = new boolean[max];
		int[] path = new int[max];
		
		Queue<Node13913_1> queue = new LinkedList<Node13913_1>();
		
		queue.add(new Node13913_1(N, 0));
		
		while(!queue.isEmpty()) {
			Node13913_1 cur = queue.poll();
			
			if(cur.idx == K) {
				System.out.println(cur.count);
				int idx = K;
				StringBuilder sb = new StringBuilder();
				
				while(idx != N) {
					sb.insert(0, idx + " ");
					idx = path[idx];
				}
				sb.insert(0, idx + " ");
				System.out.println(sb);
				return;
			}
			if(cur.idx < K) {
				if(cur.idx * 2 < max) {
					if(!visit[cur.idx * 2]) {
						visit[cur.idx * 2] = true;
						path[cur.idx * 2] = cur.idx;
						queue.add(new Node13913_1(cur.idx * 2, cur.count+1));
					}
				}
				if(cur.idx + 1 < max) {
					if(!visit[cur.idx + 1]) {
						visit[cur.idx + 1] = true;
						path[cur.idx + 1] = cur.idx;
						queue.add(new Node13913_1(cur.idx + 1, cur.count+1));
					}
				}
			}
			if(cur.idx - 1 >= 0) {
				if(!visit[cur.idx - 1]) {
					visit[cur.idx - 1] = true;
					path[cur.idx - 1] = cur.idx;
					queue.add(new Node13913_1(cur.idx - 1, cur.count+1));
				}
			}
		}
	}
}

class Node13913_1 {
	int idx, count;
	public Node13913_1(int idx, int count) {
		this.idx = idx;
		this.count = count;
	}
}
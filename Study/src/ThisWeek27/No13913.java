package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13913 {
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
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(new Node(N, 0, "" + N));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.idx == K) {
				System.out.println(cur.count);
				System.out.println(cur.path);
				return;
			}
			if(cur.idx * 2 < max) {
				if(!visit[cur.idx * 2]) {
					visit[cur.idx * 2] = true;
					queue.add(new Node(cur.idx *2, cur.count+1, cur.path + " " + (cur.idx * 2)));
				}
			}
			if(cur.idx - 1 >= 0) {
				if(!visit[cur.idx - 1]) {
					visit[cur.idx - 1] = true;
					queue.add(new Node(cur.idx - 1, cur.count+1, cur.path + " " + (cur.idx - 1)));
				}
			}
			if(cur.idx + 1 < max) {
				if(!visit[cur.idx + 1]) {
					visit[cur.idx + 1] = true;
					queue.add(new Node(cur.idx + 1, cur.count+1, cur.path + " " + (cur.idx + 1)));
				}
			}
		}
	}
}

class Node {
	int idx, count;
	String path;
	
	public Node(int idx, int count, String path) {
		this.idx = idx;
		this.count = count;
		this.path = path;
	}
}
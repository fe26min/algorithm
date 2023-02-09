package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17837 {
	
	static int N, K;
	static int[][] mat;
	static Node17837[][] nodeH, nodeT;
	static Queue<Node17837> queue;
	
	static int[] dirx = {0, 0, -1, 1};
	static int[] diry = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		int answer = 0;
		Queue nextQueue = new LinkedList<>();
		while(true) {
			answer ++;
			while(!queue.isEmpty()) {
				queue.poll();
				
			}
			
			if(nextQueue.isEmpty())
				break;
			queue = nextQueue;
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		nodeH = new Node17837[N][N];
		nodeT = new Node17837[N][N];
		boolean[][] isUpDown;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				
				nodeH[i][j] = new Node17837(i, j, -1);
				nodeT[i][j] = new Node17837(i, j, -1);
				
				nodeH[i][j].next = nodeT[i][j];
				nodeT[i][j].prev = nodeH[i][j];
			}
		}
		
		queue = new LinkedList<Node17837>();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) -1;
			int y = Integer.parseInt(st.nextToken()) -1;
			int d = Integer.parseInt(st.nextToken());
			
			Node17837 node = new Node17837(x,y,d);
			nodeH[x][y].add(node);
			queue.add(node);
		}
		br.close();
	}
}

class Node17837 {
	int x, y, d;
	Node17837 next;
	Node17837 prev;
	
	public Node17837(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
		next = null;
	}
	
	public void add(Node17837 node) {
		this.next.prev = node;
		this.next = node;
	}
}
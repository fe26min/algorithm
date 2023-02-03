package ThisWeek26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No12852 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		br.close();
		
		int dp[] = new int[X+1];
		dp[X] = 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(X, 0, "" + X));
		
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int depth = queue.peek().depth;
			String path = queue.peek().path;
			
			if(x == 1) {
				System.out.println(depth);
				System.out.println(path);
				break;
			}
			
			queue.poll();
			
			if(x%2 == 0 && dp[x/2]==0) {
				dp[x/2] = depth + 1;
				queue.add(new Node(x/2, depth+1, path +" " + (x/2)));
			}
			if(x%3==0 && dp[x/3]==0) {
				dp[x/3] = depth + 1;
				queue.add(new Node(x/3, depth+1, path +" " + (x/3)));
			}
			if(dp[x-1]==0) {
				dp[x-1] = depth + 1;
				queue.add(new Node(x-1, depth+1, path +" " + (x-1)));
			}
		}
		
	}
}

class Node {
	int x;
	int depth;
	String path;
	
	public Node(int x, int depth, String path) {
		this.x = x;
		this.depth = depth;
		this.path = path;
	}
}

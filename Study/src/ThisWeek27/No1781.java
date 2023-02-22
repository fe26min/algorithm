package ThisWeek27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1781 {
	static int N;
	static ArrayList<Node1781> arr;
	static PriorityQueue<Integer> pq ;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	
	private static void pro() {
		pq = new PriorityQueue<>();
		for(Node1781 node : arr) {
			int size = pq.size();
			
			if(size < node.deadLine) {
				pq.add(node.num);
			}
			
			else if(size == node.deadLine) {
				int peek = pq.peek();
				
				if(node.num > peek) {
					pq.poll();
					pq.add(node.num);
				}
			}
		}
		int answer  = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
	
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dead = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			arr.add(new Node1781(dead, num));
		}
		Collections.sort(arr);
		br.close();
	}
}

class Node1781 implements Comparable<Node1781>{
	int deadLine, num;
	
	public Node1781(int deadLine, int num) {
		this.deadLine = deadLine;
		this.num = num;
	}

	@Override
	public int compareTo(Node1781 o) {
		if(this.deadLine == o.deadLine) {
			return (int) (o.num - this.num);
		}
		return this.deadLine - o.deadLine;
	}
}
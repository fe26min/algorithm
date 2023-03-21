package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class No1655 {
	
	static PriorityQueue<Integer> left;
	static PriorityQueue<Integer> right;
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		init();
		input();
		System.out.println(sb);
	}

	private static void init() {
		left = new PriorityQueue<>(Collections.reverseOrder());
		right = new PriorityQueue<>();
		sb = new StringBuilder();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int mid = Integer.parseInt(br.readLine());
		sb.append(mid+"\n");
		for(int i=1; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// left에 넣어야 되는 경우
			if(num < mid) {
				// left에 숫자가 더 많은 경우
				if(left.size() >= right.size()) {
					right.add(mid);
					left.add(num);
					mid = left.poll();
				}
				else {
					left.add(num);
				}
			}
			// right에 넣어야 되는 경우
			else if(num > mid) {
				if(left.size() < right.size()) {
					right.add(num);
					left.add(mid);
					mid = right.poll();
				}
				else {
					right.add(num);
				}
			}
			else {
				if(left.size() < right.size()) {
					left.add(num);
				}
				else {
					right.add(num);
				}
			}
			sb.append(mid+"\n");
		}
		br.close();
	}
}

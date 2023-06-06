package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No2812 {
	static int N, K;
	static String input;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = input.charAt(i) - '0';
			
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && count < K) {
					if(stack.peek() < num) {
						stack.pop();
						count++;
					} else {
						break;
					}
				}
			}
			
			stack.push(num);
			
			if(count == K) {
				sb.append(input.substring(i+1));
				break;
			}
		}
		while(!stack.isEmpty()){
			int num = stack.pop();
			if(count < K) {
				count++;
				continue;
			}
			sb.insert(0, num);
		}
		System.out.println(sb.toString());
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = br.readLine();
		
		br.close();		
	}
}

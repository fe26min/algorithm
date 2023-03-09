package ThisWeek31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No6051 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer>[] stack = new Stack[N+1];
		
		sb = new StringBuilder();
		StringTokenizer st;
		
		stack[0] = new Stack<>();
		for(int i=1; i<=N; i++) {
			stack[i] = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
//			System.out.print(cmd + " ");
			switch(cmd) {
			case 'a':
				stack[i].addAll(stack[i-1]);
				int addIdx = Integer.parseInt(st.nextToken());
//				System.out.println(addIdx);
				stack[i].add(addIdx);
				break;
			case 's':
				stack[i].addAll(stack[i-1]);
//				System.out.println();
				if(!stack[i].isEmpty())
					stack[i].pop();
				break;
				
			case 't':
				int time = Integer.parseInt(st.nextToken());
//				System.out.println(time);
				stack[i].addAll(stack[time-1]);
				break;
			}
			if(stack[i].isEmpty()) {
//				System.out.println(-1);
				sb.append(-1 + "\n");
			}
			else {
//				System.out.println(stack[i].peek());
				sb.append(stack[i].peek() +"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}


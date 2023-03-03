package ThisWeek30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17298 {
	static int N;
	static int[] arr, ans;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		stack = new Stack<>();
		for(int i=N-1; i>=0; i--) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
				if(!stack.isEmpty())
					ans[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i : ans) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = -1;
		}
		br.close();
	}
}

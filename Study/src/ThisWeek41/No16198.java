package ThisWeek41;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No16198 {
	static int N, max;
	static LinkedList<Integer> W;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		max = 0;
		dfs(0, 0);
		System.out.println(max);
	}
	
	private static void dfs(int depth, int sum) {
		if(depth == N-2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=1; i<W.size()-1; i++) {
			int temp = W.get(i);
			int nextSum = sum + W.get(i-1) * W.get(i+1);
			W.remove(i);
			dfs(depth+1, nextSum);
			W.add(i, temp);
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		W = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			W.add(Integer.parseInt(st.nextToken()));
		}
		br.close();		
	}
}

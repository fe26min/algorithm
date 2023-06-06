package ThisWeek43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No15903 {
	static int n, m;
	static PriorityQueue<Long> arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int i=0; i<m; i++) {
			long a = arr.poll();
			long b = arr.poll();
			arr.add(a + b);
			arr.add(a + b);
		}
		
		long ans = 0;
		for(long i : arr) {
			ans += i;
		}
		System.out.println(ans);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new PriorityQueue<>();
		
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr.add(Long.parseLong(st.nextToken()));
		
		br.close();		
	}
}

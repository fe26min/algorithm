package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1138 {
	static int N;
	static LinkedList<Integer> list;
	static int[] arr, ans;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		ans = new int[N];
		list = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			list.add(i);
		}
		for(int i=0; i<N; i++) {
			ans[list.get(arr[i])] = i+1;
			list.remove(arr[i]);
		}
		
		for(int i: ans) {
			System.out.print(i + " ");
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}

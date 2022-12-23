package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17070 {
	static int N, B, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		long count = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] <= B) count += 1;
			else {
				count += 1;
				count += (arr[i]-B) / C;
				count += (arr[i]-B) % C == 0 ? 0 : 1;
			}
		}
		System.out.println(count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		br.close();
	}
}

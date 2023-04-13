package Ch005_CodingTestPrac.Basic.BruteForce_permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10972 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		if(N==1) {
			System.out.println(-1);
			return;
		}
		for(int i=N-2; i>0; i--) {
			for(int j=N-1; j>i; j--) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					for(int c : arr) {
						System.out.print(c + " ");
					}System.out.println();
					return;
				}
			}
		}
		System.out.println(-1);
		return;
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

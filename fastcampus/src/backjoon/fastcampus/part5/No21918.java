package backjoon.fastcampus.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21918 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1:
				arr[b-1] = c;
				break;
			case 2:
				for(int j = b-1; j <c; j++) {
					arr[j] = Math.abs(arr[j] - 1);
				}
				break;
			case 3:
				for(int j = b-1; j <c; j++) {
					arr[j] = 0;
				}
				break;
			case 4:
				for(int j = b-1; j <c; j++) {
					arr[j] = 1;
				}
				break;
			}
		}
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		br.close();
	}
}

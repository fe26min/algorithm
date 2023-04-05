package ThisWeek35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No5676 {
	static BufferedReader br;
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input = "";
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
		
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int idx = 1;
			while(idx < N) {
				idx <<= 1;
			}
//			System.out.println(idx);
			arr = new int[idx * 2];
			
			Arrays.fill(arr, 1);

			st = new StringTokenizer(br.readLine());
			for(int i=idx; i<idx+N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = (temp == 0) ? 0 : (temp>0) ? 1 : -1;
			}
			
			for(int i=idx*2-1; i>1; i--) {
				arr[i/2] *= arr[i];
			}

//			check();
			
			for(int k=0; k<K; k++) {
				String cmd[] = br.readLine().split(" ");
				
				switch(cmd[0].charAt(0)) {
				case 'C':
					int i = Integer.parseInt(cmd[1]) - 1;
					int v = Integer.parseInt(cmd[2]);
					v = (v == 0) ? 0 : (v > 0) ? 1 : -1;
					int temp = arr[idx + i];
					
					arr[idx+i] = v;
					for(int cidx = (idx + i)/2; cidx>0; cidx /= 2) {
						arr[cidx] = arr[cidx * 2] * arr[cidx * 2 + 1]; 
					}
					
//					check();
					break;
				case 'P':
					int l = Integer.parseInt(cmd[1]) - 1 + idx;
					int r = Integer.parseInt(cmd[2]) - 1 + idx;
					
					int cp = 1;
					
					long res = mul(l, r);
					
					if(res == 0) {
						sb.append(0);
					}
					else if(res < 0) {
						sb.append("-");
					}
					else {
						sb.append("+");
					}
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static long mul(int l, int r) {
		long cp = 1L;
		
		while(l < r) {
			if(l % 2 == 1) {
				cp *= arr[l];
			}
			if(r % 2 == 0) {
				cp *= arr[r];
			}
			l = (l+1)/2;
			r = (r-1)/2;
		}
		
		if(l== r)
			cp *= arr[l];
		return cp;
	}

	private static void check() {
		for(int a : arr) {
			System.out.print(a + " ");
		}System.out.println();
	}
}

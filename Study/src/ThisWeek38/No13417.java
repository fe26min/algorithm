package ThisWeek38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No13417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder ans = new StringBuilder();
		
		for(int ti =0; ti<T; ti++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			char first = st.nextToken().charAt(0);
			
			sb.append(first);
			
			for(int i=0; i<N - 1; i++) {
				char c = st.nextToken().charAt(0);
				
				if(c<=first) {
					sb.insert(0, c);
					first = c;
				}
				else {
					sb.append(c);
				}
			}
			ans.append(sb).append("\n");
		}
		System.out.println(ans);
		br.close();
	}
}

package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No22233 {
	
	static int N, M;
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] keywords = br.readLine().split(",");
			if(set.size()==0) {
				sb.append("0\n");
				continue;
			}
			for(String kword : keywords) {
				if(set.contains(kword)) {
					set.remove(kword);
				}
			}
			sb.append(set.size() +"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

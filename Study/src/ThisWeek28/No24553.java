package ThisWeek28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No24553 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<T; i++) {
			String line = br.readLine();
			int answer = line.charAt(line.length()-1) == '0' ? 1 : 0;
			sb.append(answer + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}

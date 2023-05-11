package ThisWeek40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class No1013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String pattern = "(100+1+|01)+";
		for(int ti=0; ti<T; ti++) {
			boolean result = Pattern.matches(pattern, br.readLine());
			if(result)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

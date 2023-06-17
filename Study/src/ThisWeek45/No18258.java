package ThisWeek45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] queue = new int[2_000_001];
		int idx = 0;
		int adIdx = 0;
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N; i++) {
			String[] cmds = br.readLine().split(" ");
			
			switch(cmds[0]) {
			case "push":
				queue[adIdx++] = Integer.parseInt(cmds[1]);
				break;
				
			case "pop":
				if(idx == adIdx)
					sb.append("-1\n");
				else 
					sb.append(queue[idx++]).append("\n");
				break;
				
			case "size":
				sb.append(adIdx - idx).append("\n");
				break;
				
			case "empty":
				if(idx == adIdx)
					sb.append("1\n");
				else 
					sb.append("0\n");
				break;
				
			case "front":
				if(idx == adIdx)
					sb.append("-1\n");
				else
					sb.append(queue[idx]).append("\n");
				break;
				
			case "back":
				if(idx == adIdx)
					sb.append("-1\n");
				else
					sb.append(queue[adIdx - 1]).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}

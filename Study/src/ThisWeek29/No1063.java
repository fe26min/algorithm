package ThisWeek29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1063 {
	static int[] king, stone;
	static HashMap<String, Integer> dirs;
	static int dirx[] = {1, -1, 0, 0, 1, -1, 1, -1};
	static int diry[] = {0, 0, -1, 1, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dirs = new HashMap<>();
		
		dirs.put("R", 0);
		dirs.put("L", 1);
		dirs.put("B", 2);
		dirs.put("T", 3);
		dirs.put("RT", 4);
		dirs.put("LT", 5);
		dirs.put("RB", 6);
		dirs.put("LB", 7);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		king = new int[2];
		stone = new int[2];
		
		String kingPos = st.nextToken();
		
		king[0] = kingPos.charAt(0) - 'A';
		king[1] = kingPos.charAt(1) - '1';
		String stonePos = st.nextToken();
		
		
		stone[0] = stonePos.charAt(0) - 'A';
		stone[1] = stonePos.charAt(1) - '1';
		
		int M = Integer.parseInt(st.nextToken());
		
		for(var i=0; i<M; i++) {
			move(br.readLine());
		}
		System.out.println("" +(char)(king[0] + 'A') + (char)(king[1] +'1'));
		System.out.println("" +(char)(stone[0] + 'A') + (char)(stone[1]+'1'));
		br.close();
	}
	
	private static void move(String cmd) {
		int nkx = king[0] + dirx[dirs.get(cmd)];
		int nky = king[1] + diry[dirs.get(cmd)];
		
		if(nkx < 0 || nky<0 ||nkx >= 8 || nky >=8)
			return;
		
		if(nkx == stone[0] && nky == stone[1]) {
			int nsx = stone[0] + dirx[dirs.get(cmd)];
			int nsy = stone[1] + diry[dirs.get(cmd)];
			
			if(nsx < 0 || nsy<0 ||nsx >= 8 || nsy >=8)
				return;
			
			stone[0] = nsx;
			stone[1] = nsy;
		}
		
		king[0] = nkx;
		king[1] = nky;
	}
}

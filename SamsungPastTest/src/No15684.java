import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 사다리 조작
public class No15684 {
	//dfs 깊이가 3을 넘어가면 끝!
	
	static int N, M, H;
	static ArrayList<int[]> ladders;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladders = new ArrayList<int[]>();
		br.close();
	}
}

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1865 {
	static BufferedReader br;
	static StringBuilder sb;
	
	static int N;
	static ArrayList<int[]>[] list;
    static final int INF = 987654321;	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		for(int ti = 0; ti<t; ti++) {
//			System.out.println("ti : " + ti);
			input();
			pro();
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static void pro() {
		for(int i=0; i<N; i++) {
			if(comeBack(i)) {
				sb.append("YES\n");
				return;
			}
		}
		sb.append("NO\n");
	}

    // 벨만포드 알고리즘
    public static boolean comeBack(int start) {
        int[] dist = new int[N];
    	Arrays.fill(dist, INF);
        dist[start] = 0; // 시작점은 0으로 초기화.
        boolean update = false;
        
        // 모든 점에 대해서
        for(int i=0; i<N; i++) {
        	// 모든 간점에 대해서
        	for(int j=0; j<N; j++) {
        		for(int[] edge : list[j]) {
        			if(dist[j] != INF && dist[edge[0]] > dist[j] + edge[1]) {
        				dist[edge[0]] = dist[j] + edge[1];
        				update = true;
        			}
        		}
        	}
        	if(!update)
        		break;
        }
        
        if(update) {
        	for(int i=0; i<N; i++) {
        		for(int[] edge : list[i]) {
        			if(dist[i] != INF && dist[edge[0]] > dist[i] + edge[1]) {
        				return true;
        			}
        		}
        	}
        }
        return false;
    }

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}

		int M = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
	
		for(int i=0; i<M + W; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			int T = Integer.parseInt(st.nextToken());
			
			if(i<M) {
				list[S].add(new int[] {E, T});
				list[E].add(new int[] {S, T});
			}
			else {
				list[S].add(new int[] {E, -T});
			}
		}
	}
}

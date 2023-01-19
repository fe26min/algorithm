import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1747 {
	static int N;
	static boolean[] sifter;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		eratosthenes();
		findpalindrome();
	}

	private static void findpalindrome() {
		for(int i=N; i<=1003001; i++) {
			if(!sifter[i]) {
				if(isPal(i)) {
					System.out.println(i);
					return;
				}
			}
		}
	}

	private static boolean isPal(int num) {
		String imsi = "" + num;
		
		for(int i=0; i<imsi.length()/2; i++) {
			if(imsi.charAt(i) != imsi.charAt(imsi.length()-1-i))
				return false;
		}
		return true;
	}

	private static void eratosthenes() {
		sifter = new boolean[1003002];
		sifter[1] = true;
		for(int i=2; i * i<= 1003001; i++) {
			if(sifter[i]) continue;
			for(int j=i*2; j<= 1003001; j+=i) {
				sifter[j] = true;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}

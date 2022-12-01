package backjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1181 {
	
	static Word1181[] arr;
	public static void main(String[] args) throws IOException {
		input();
		
		String imsi = "";
		for(Word1181 w: arr) {
			if(imsi.equals(w.word)) continue;
			System.out.println(w);
			imsi = w.word;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Word1181[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = new Word1181(br.readLine());
		}
		
		Arrays.sort(arr);
		br.close();
	}
}
class Word1181 implements Comparable<Word1181>{
	String word;
	public Word1181(String word){
		this.word = word;
	}
	
	@Override
	public int compareTo(Word1181 o) {
		if(word.length() == o.word.length())
			return word.compareTo(o.word);
		return word.length() - o.word.length();
	}
	
	@Override
	public String toString() {
		return word;
	}
}

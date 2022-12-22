package BOJ.samsung_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No16637 {
	
	// stack에 넣거나 빼거나?
	// dfs 처럼 괄호 처리 하거나 괄호 처리 안하거나
	// 모든 경우를 찾아야 하는 완전 탐색문제
	// dfs로 풀까? bfs로 풀까?
	
	// 3 + 8 * 7에서
	// 3 + 일때 더하거나 그대로 가거나
	// 11 * 7 또는 3 + 8 * 7로 나눠진다.
	
	// 숫자 stack과 문자 stack;
	
	static int N, max;
	static ArrayList<Integer> nums;
	static ArrayList<Character> signs;
	
	public static void main(String[] args) throws IOException {
		init();
		input();
		dfs(nums.get(0), 0);
		System.out.println(max);
	}

	private static void dfs(int num, int depth) {
		if(depth == signs.size()) {
			max = max < num ? num : max;
			return;
		}
		
		int res = calc(num, signs.get(depth), nums.get(depth + 1));
		dfs(res, depth + 1);
		
		if(depth + 2 >= nums.size()) return;
		res = calc(nums.get(depth + 1) , signs.get(depth + 1), nums.get(depth + 2));
		res = calc(num, signs.get(depth), res);
		dfs(res, depth + 2);
		
	}
	
	private static int calc(int num1, Character sign, int num2) {
		switch(sign) {
		case '+' : return num1 + num2;
		case '-' : return num1 - num2;
		case '*' : return num1 * num2;
		}
		return -1;
	}
	

	private static void init() {
		max = Integer.MIN_VALUE;
		nums = new ArrayList<>();
		signs = new ArrayList<>();
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			if(i % 2 == 0)
				nums.add(input.charAt(i) - '0');
			else 
				signs.add(input.charAt(i));
		}
		br.close();
	}
}

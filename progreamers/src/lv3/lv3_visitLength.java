package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class lv3_visitLength {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		 * (-5,-5)~(5,5) 배열 선언해서 지나간 선분 표시하면 될듯
		 * [x1][y1][x2][y2] , [x2][y2][x1][y1]둘다 표시(4차원배열이라) 저둘은 같음
		 * 
		 */
		String dirs = "LULLLLLLU";

		System.out.println(solution(dirs));

	}

	public static int solution(String dirs) {
		int answer = 7;
		int[][][][] arr = new int[10][10][10][10];
		int len = dirs.length();
		int x1=5,y1=5,x2=5,y2=5;

		for (int i = 0; i < len; i++) {
			switch (dirs.charAt(i)) {
			case 'L':
				if (x1 > 0) {
					x1--;
					arr[x1][y1][x2][y2]++;
					arr[x2][y2][x1][y1]++;
					System.out.println("왼쪽");
				}
				break;
			case 'R':
				if (x1 < 10) {
					x1++;
					arr[x1][y1][x2][y2]++;
					arr[x2][y2][x1][y1]++;
					System.out.println("오른쪽");
				}
				break;
			case 'U':
				if (y1 < 10) {
					y1++;
					arr[x1][y1][x2][y2]++;
					arr[x2][y2][x1][y1]++;
					System.out.println("위쪽");
				}
				break;
			case 'D':
				if (y1 > 0) {
					y1--;
					arr[x1][y1][x2][y2]++;
					arr[x2][y2][x1][y1]++;
					System.out.println("아래쪽");
				}
				break;

			}
		}
		
		

		return answer;
	}

}

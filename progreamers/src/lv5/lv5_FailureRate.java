package lv5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class lv5_FailureRate {
	public static void main(String[] args) {
		//실패율= 스테이지에 달했으나 못깬놈/ 스테이지 도달한애
		int N=5;	//전체스테이지
		int[] stages = {2,1,2,6,2,4,3,3};//1이상 N+1이하의 자연수  //stage 	길이는 1이상 200000 이
		
		System.out.println(solution(N,stages));
		
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = {};
		float[] fail=new float[N];
		int len= stages.length;
		int Ncount=0;

		ArrayList<Float> list = new ArrayList<>();
		
		for(int i=0;i<N;i++){
			Ncount=count(stages,i+1);
			fail[i]=(float)Ncount/len;
			list.add((float)Ncount/len);
			len-=Ncount;
			
		}
		for(int i=0;i<N;i++){
			System.out.println(fail[i]);
		}
		System.out.println("========");
		for(int i=0;i<N;i++){
			System.out.println(list.get(i));
		}
		Collections.sort(list, new Comparator<Float>() {

			@Override
			public int compare(Float o1, Float o2) {
				
				// TODO Auto-generated method stub
				return (int)(o1-o2);
			}
		});
		
		
		return answer;
	}
	public class indexSort{
		public int index;
		public float value;
		public indexSort(int index, float value) {
			super();
			this.index = index;
			this.value = value;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public float getValue() {
			return value;
		}
		public void setValue(float value) {
			this.value = value;
		}
		
	}
	public static int count(int[] arr,int n){
		boolean flag=false;
		int count=0;
		Arrays.sort(arr);
		int len=arr.length;
		for(int i=0;i<len;i++){
			if(arr[i]==n){
				count++;
				if(i!=len-1&&arr[i]!=arr[i+1]){
					return count;
				}
			}
		}
		
		return count;
	}
}

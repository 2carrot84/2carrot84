package codility.etc;

import java.util.ArrayList;

public class Permutation {

	private static ArrayList<String> arrStr = new ArrayList<String>();


	public static void main(String[] args) {
		System.out.println(Permutation.solution(3, 0, 7, 0));
	}

	public static void perm(int[] arr, int depth) { 
		if (depth == arr.length) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함. 
			print(arr); return; 
		}

		for (int i = depth; i < arr.length; i++) { 
			swap(arr, i, depth); 
			perm(arr, depth + 1); 
			swap(arr, i, depth); 
		} 
	} // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌. 

	public static void swap(int[] arr, int i, int j) { 
		if(i == j) return;

		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 

	public static void print(int[] arr) { 
		String result = "";
		for (int i = 0; i < arr.length; i++) { 
			result += arr[i];
		} 
		arrStr.add(result);
	}

	public static String getMaxTime() {
		int maxHour = 0;
		int maxMin = 0;

		for (int i = 0; i < arrStr.size(); i++) {
			int tmpHour = 0;
			int tmpMin = 0;

			String tmpTime = arrStr.get(i);
			tmpHour = Integer.parseInt(tmpTime.substring(0,2));
			tmpMin = Integer.parseInt(tmpTime.substring(2,4));

			if((tmpHour / 24) > 0 || (tmpMin / 60) > 0) {
				continue;
			}

			if(maxHour < tmpHour) {
				maxHour = tmpHour;
				maxMin = tmpMin;
			}
			else if (maxHour == tmpHour && maxMin < tmpMin)
				maxMin = tmpMin;
		}
		
		if(maxHour == 0 && maxMin == 0) {
			return "NOT POSSIBLE";
		}
		
		return maxHour + ":" + maxMin;
	}
	
	public static String solution(int A, int B, int C, int D) {
		int[] arr = { A, B, C, D }; 
		perm(arr, 0);
		return getMaxTime();
	}
}

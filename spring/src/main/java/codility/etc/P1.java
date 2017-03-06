package codility.etc;

import java.util.ArrayList;

public class P1 {
	public String solution(int A, int B, int C, int D) {
		ArrayList<String> timeList = new ArrayList<String>();
		int[] arr = { A, B, C, D }; 
		
		// input validation
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < 0 || 10 <= arr[i]) {
				return "NOT POSSIBLE";
			}	
		}
		
		perm(arr, 0, timeList);
		return getMaxTime(timeList);
	}
	
	public void perm(int[] arr, int depth, ArrayList<String> timeList) { 
		if (depth == arr.length) {  
			addTimeList(arr, timeList); return; 
		}

		for (int i = depth; i < arr.length; i++) { 
			swap(arr, i, depth); 
			perm(arr, depth + 1, timeList); 
			swap(arr, i, depth); 
		} 
	}  

	public void swap(int[] arr, int i, int j) { 
		if(i == j) return;

		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 

	public void addTimeList(int[] arr, ArrayList<String> timeList) { 
		String result = "";
		for (int i = 0; i < arr.length; i++) { 
			result += arr[i];
		} 
		timeList.add(result);
	}

	public String getMaxTime(ArrayList<String> timeList) {
		int maxHour = 0;
		int maxMin = 0;

		for (int i = 0; i < timeList.size(); i++) {
			int tmpHour = 0;
			int tmpMin = 0;

			String tmpTime = timeList.get(i);
			tmpHour = Integer.parseInt(tmpTime.substring(0,2));
			tmpMin = Integer.parseInt(tmpTime.substring(2,4));

			if((tmpHour / 24) > 0 || (tmpMin / 60) > 0) {
				continue;
			}

			if(maxHour < tmpHour) {
				maxHour = tmpHour;
				maxMin = tmpMin;
			}
			else if (maxHour == tmpHour && maxMin < tmpMin) {
				maxMin = tmpMin;
			}
		}
		
		if(maxHour == 0 && maxMin == 0) {
			return "NOT POSSIBLE";
		}
		
		return String.format("%02d", maxHour) + ":" + String.format("%02d", maxMin);
	}
}

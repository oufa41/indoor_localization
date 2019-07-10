package Helper;


import java.util.ArrayList;

public class Combination { 

	
	private ArrayList<Integer> arrayListcombination;
	 
	public Combination() {
		arrayListcombination = new ArrayList<Integer>();
	}


	public ArrayList<Integer> getarrayListcombination() {
		return arrayListcombination;
	}


	public void setCombination(ArrayList<Integer> arrayListcombination) {
		this.arrayListcombination = arrayListcombination;
	}


	public void combinationUtil(int arr[], int data[], int start, 
								int end, int index, int r) 
	{ 
		
		if (index == r) 
		{ 
			for (int j=0; j<r; j++) 
				arrayListcombination.add(data[j]);	
			return; 
		} 

		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{ 
			data[index] = arr[i]; 
			combinationUtil(arr, data, i+1, end, index+1, r); 
		} 
	} 

	
	public void getCombination(int arr[], int n, int r) 
	{ 	
		int data[]=new int[r]; 
		combinationUtil(arr, data, 0, n-1, 0, r); 
	} 

}
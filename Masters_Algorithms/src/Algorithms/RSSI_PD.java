package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;
import Helper.Combination;

public abstract class RSSI_PD extends Localization_Algorithm{
	private ArrayList<Integer> combinArrayList;


	public RSSI_PD(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);
		combinArrayList = getAnchorsIndexCombination();
		super.getSortedAnchorsDescending();
	}

	
	public ArrayList<Integer> getCombinArrayList() {
		return combinArrayList;
	}


	public void setCombinArrayList(ArrayList<Integer> combinArrayList) {
		this.combinArrayList = combinArrayList;
	}


	public ArrayList<Integer> getSameXIndex() {
		ArrayList<Double> anchorsXCoordinates = new ArrayList<Double>();

		for (int i = 0; i < super.getAnchorPoints().size(); i++)
			anchorsXCoordinates.add(super.getAnchorPoints().get(i)
					.getX_location());
		return getArrayListZeroDifferance(anchorsXCoordinates);

	}

	public ArrayList<Integer> getSameYIndex() {
		ArrayList<Double> anchorsYCoordinates = new ArrayList<Double>();

		for (int i = 0; i < super.getAnchorPoints().size(); i++)
			anchorsYCoordinates.add(super.getAnchorPoints().get(i)
					.getY_location());

		return getArrayListZeroDifferance(anchorsYCoordinates);

	}

	public ArrayList<Integer> getAnchorsIndexCombination() {
		int arr[] = new int[super.getAnchorPoints().size()];
		int r = 2;
		int n = super.getAnchorPoints().size();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Combination combination = new Combination();
		combination.getCombination(arr, n, r);

		return combination.getarrayListcombination();
	}

	public ArrayList<Integer> getArrayListZeroDifferance(
			ArrayList<Double> anchorPoints_axis) {

		ArrayList<Integer> sameDifference = new ArrayList<Integer>();
		for (int i = 0; i < combinArrayList.size(); i += 2) {

			double differance = anchorPoints_axis.get(combinArrayList.get(i))
					- anchorPoints_axis.get(combinArrayList.get(i + 1));
			if (differance == 0) {
				sameDifference.add(combinArrayList.get(i));

				sameDifference.add(combinArrayList.get(i + 1));
			}
		}
		return sameDifference;
	}

	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public double getRSSIPDEquation(double distance, double rssi1, double rssi2) {
		
		double power_difference = Math.pow((1/ rssi1), 0.5) - Math.pow((1/ rssi2), 0.5);
		return 0.5 * (distance + ((1 / distance) * power_difference));
	}
	
	public abstract double getXCoorinate();

	public abstract double getYCoorinate();
}

package Algorithms;

import java.util.ArrayList;
import java.util.Collections;

import Helper.AnchorPoint;

public abstract class Localization_Algorithm {
	private ArrayList<AnchorPoint> anchorPoints;
	public boolean isRealPowerCalculated = false;

	public Localization_Algorithm(ArrayList<AnchorPoint> anchorPoints) {

		this.anchorPoints = anchorPoints;
	}

	public ArrayList<AnchorPoint> getAnchorPoints() {
		return anchorPoints;
	}

	public void setAnchorPoints(ArrayList<AnchorPoint> anchorPoints) {
		this.anchorPoints = anchorPoints;
	}

	public ArrayList<AnchorPoint> getSortedAnchorsDescending() {
		Collections.sort(anchorPoints);
		return anchorPoints;
	}
	public abstract double getXCoorinate();

	public abstract double getYCoorinate();


}

package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public abstract class Weighted extends Localization_Algorithm {

	public Weighted(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);
	}

	public double getXCoorinate(ArrayList<Double> weights) {
		double result = 0;
		int index = 0;
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			result += anchor.getX_location() * weights.get(index);
			index++;
		}
		return result;
	}

	public double getYCoorinate(ArrayList<Double> weights) {

		double result = 0;
		int index = 0;
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			result += anchor.getY_location() * weights.get(index);
			index++;
		}
		return result;
	}

	public abstract double sumWeights();

	public abstract void getAlgorithmWeights();
}

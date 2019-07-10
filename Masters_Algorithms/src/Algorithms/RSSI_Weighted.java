package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public class RSSI_Weighted extends Weighted {

	ArrayList<Double> weights;

	public RSSI_Weighted(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);
		weights = new ArrayList<Double>();
		getAlgorithmWeights();
	}

	public double sumWeights() {
		double result = 0;
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			result += anchor.getRSSI();
		}
		return result;
	}

	public void getAlgorithmWeights() {
		double sumPower = sumWeights();
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			weights.add(anchor.getRSSI() / sumPower);
		}

	}

	public double getXCoorinate(ArrayList<Double> weights) {

		return super.getXCoorinate(weights);
	}

	public double getYCoorinate(ArrayList<Double> weights) {

		return super.getYCoorinate(weights);
	}

	@Override
	public double getXCoorinate() {
		// TODO Auto-generated method stub
		return getXCoorinate(weights);
	}

	@Override
	public double getYCoorinate() {
		// TODO Auto-generated method stub
		return getYCoorinate(weights);
	}

}

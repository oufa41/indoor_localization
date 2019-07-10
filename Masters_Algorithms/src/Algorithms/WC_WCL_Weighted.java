package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public class WC_WCL_Weighted extends Weighted {
	private ArrayList<Double> weights;

	public WC_WCL_Weighted(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);
		weights = new ArrayList<Double>();
		getAlgorithmWeights();
	}

	public double sumWeights() {
		double result = 0;
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			double weight = Math.pow(anchor.getRSSI(), 0.25);
			result += weight;
		}
		return result;
	}

	public void getAlgorithmWeights() {
		double sumPower = sumWeights();
		// old weight
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			double weight = Math.pow(anchor.getRSSI(), 0.25);
			weights.add(weight / sumPower);
		}
		// weight dash and sum of weights dash
		double resultDash= 0;
		for (int i = 0; i < weights.size(); i++) {
			double weightDash = weights.get(i)
					* Math.pow(getAnchorPoints().size(), 2 * weights.get(i));
			weights.set(i, weightDash);
			resultDash += weights.get(i);
		}	
		
	  // update weights ArrayList with Dash
		for (int i = 0; i < weights.size(); i++) {
			weights.set(i, weights.get(i)/resultDash);
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

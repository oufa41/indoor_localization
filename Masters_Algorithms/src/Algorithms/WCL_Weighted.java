package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public class WCL_Weighted extends Weighted{
	private ArrayList<Double> weights;

	public WCL_Weighted(ArrayList<AnchorPoint> anchorPoints) {
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
		System.out.println(sumPower);
		for (AnchorPoint anchor : super.getAnchorPoints()) {
			double weight = Math.pow(anchor.getRSSI(), 0.25);	
			weights.add(weight/ sumPower);
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

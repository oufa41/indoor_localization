package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public class RSSI_PD_Average extends RSSI_PD {

	public RSSI_PD_Average(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);

	}

	public double getXCoorinate() {
		ArrayList<Double> allEstimatedX = new ArrayList<Double>();
	
		int indexAPSDistance = 0;
		for (int i = 0; i < getSameYIndex().size(); i += 2) {
			double d1_x = getRSSIPDEquation(
					getAPSDistanceSameY().get(indexAPSDistance),
					getAnchorPoints().get(getSameYIndex().get(i)).getRSSI(),
					getAnchorPoints().get(getSameYIndex().get(i + 1)).getRSSI());

			if (getAnchorPoints().get(getSameYIndex().get(i)).getX_location() > getAnchorPoints()
					.get(getSameYIndex().get(i + 1)).getX_location())
				d1_x = getAnchorPoints().get(getSameYIndex().get(i))
						.getX_location() - d1_x;
			else
				d1_x = d1_x
						+ getAnchorPoints().get(getSameYIndex().get(i))
								.getX_location();
			allEstimatedX.add(d1_x);
			indexAPSDistance++;
		}
		return sum(allEstimatedX) / allEstimatedX.size();
	}

	@Override
	public double getYCoorinate() {
		ArrayList<Double> allEstimatedY = new ArrayList<Double>();
		int indexAPSDistance = 0;

		for (int i = 0; i < getSameXIndex().size(); i += 2) {
			double d1_y = getRSSIPDEquation(
					getAPSDistanceSameX().get(indexAPSDistance),
					getAnchorPoints().get(getSameXIndex().get(i)).getRSSI(),
					getAnchorPoints().get(getSameXIndex().get(i + 1)).getRSSI());
			if (getAnchorPoints().get(getSameXIndex().get(i)).getY_location() > getAnchorPoints()
					.get(getSameXIndex().get(i + 1)).getY_location())
				d1_y = getAnchorPoints().get(getSameXIndex().get(i))
						.getY_location() - d1_y;
			else

				d1_y = d1_y
						+ getAnchorPoints().get(getSameXIndex().get(i))
								.getX_location();

			allEstimatedY.add(d1_y);
			indexAPSDistance++;
		}

		return sum(allEstimatedY) / allEstimatedY.size();
	}

	public ArrayList<Double> getAPSDistanceSameX() {
		ArrayList<Double> getAPSDistanceSameX = new ArrayList<Double>();

		for (int i = 0; i < getSameXIndex().size(); i += 2) {
			double distance =getDistance(getAnchorPoints().get(getSameXIndex().get(i))
					.getX_location(),
					getAnchorPoints().get(getSameXIndex().get(i))
							.getY_location(),
					getAnchorPoints().get(getSameXIndex().get(i + 1))
							.getX_location(),
					getAnchorPoints().get(getSameXIndex().get(i + 1))
							.getY_location());
			getAPSDistanceSameX.add(distance);

		}

		return getAPSDistanceSameX;
	}

	public ArrayList<Double> getAPSDistanceSameY() {
		ArrayList<Double> getAPSDistanceSameY = new ArrayList<Double>();
		for (int i = 0; i < getSameYIndex().size(); i += 2) {
			double distance = getDistance(
					getAnchorPoints().get(getSameYIndex().get(i))
							.getX_location(),
					getAnchorPoints().get(getSameYIndex().get(i))
							.getY_location(),
					getAnchorPoints().get(getSameYIndex().get(i + 1))
							.getX_location(),
					getAnchorPoints().get(getSameYIndex().get(i + 1))
							.getY_location());
			getAPSDistanceSameY.add(distance);
		}
		return getAPSDistanceSameY;
	}

	public double sum(ArrayList<Double> values) {
		double result = 0;
		for (double value : values) {
			result += value;
		}
		return result;
	}
}

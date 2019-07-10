package Algorithms;

import java.util.ArrayList;

import Helper.AnchorPoint;

public class RSSI_PD_Normal extends RSSI_PD {

	public RSSI_PD_Normal(ArrayList<AnchorPoint> anchorPoints) {
		super(anchorPoints);

	}

	@Override
	public double getXCoorinate() {
		double d1_x = getRSSIPDEquation(getAPSDistanceSameY(),
				getAnchorPoints().get(getSameYIndex().get(0)).getRSSI(),
				getAnchorPoints().get(getSameYIndex().get(1)).getRSSI());

		if (getAnchorPoints().get(getSameYIndex().get(0)).getX_location() > getAnchorPoints()
				.get(getSameYIndex().get(1)).getX_location())
			return getAnchorPoints().get(getSameYIndex().get(0))
					.getX_location() - d1_x;

		return d1_x
				+ getAnchorPoints().get(getSameYIndex().get(0)).getX_location();

	}

	@Override
	public double getYCoorinate() {
		double d1_y = getRSSIPDEquation(getAPSDistanceSameX(),
				getAnchorPoints().get(getSameXIndex().get(0)).getRSSI(),
				getAnchorPoints().get(getSameXIndex().get(1)).getRSSI());
		if (getAnchorPoints().get(getSameXIndex().get(0)).getY_location() > getAnchorPoints()
				.get(getSameXIndex().get(1)).getY_location())
			return getAnchorPoints().get(getSameXIndex().get(0))
					.getY_location() - d1_y;

		return d1_y
				+ getAnchorPoints().get(getSameXIndex().get(0)).getY_location();
	}

	public double getAPSDistanceSameX() {

		return getDistance(getAnchorPoints().get(getSameXIndex().get(0))
				.getX_location(), getAnchorPoints().get(getSameXIndex().get(0))
				.getY_location(), getAnchorPoints().get(getSameXIndex().get(1))
				.getX_location(), getAnchorPoints().get(getSameXIndex().get(1))
				.getY_location());
	}

	public double getAPSDistanceSameY() {

		return getDistance(getAnchorPoints().get(getSameYIndex().get(0))
				.getX_location(), getAnchorPoints().get(getSameYIndex().get(0))
				.getY_location(), getAnchorPoints().get(getSameYIndex().get(1))
				.getX_location(), getAnchorPoints().get(getSameYIndex().get(1))
				.getY_location());
	}

}

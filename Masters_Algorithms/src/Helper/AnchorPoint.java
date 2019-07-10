package Helper;



public class AnchorPoint implements Comparable<AnchorPoint>{

	private String macAddress;
	private double RSSI;
	private double x_location;
	private double y_location;
	private double sumRSSI;
	private int countAverage;

	public AnchorPoint() {

	}

	public AnchorPoint(String macAddress, double RSSI) {

		this.macAddress = macAddress;
		if (RSSI > 0) {

		} else {
			this.RSSI = setRSSIInWatt(RSSI);

		}

	}

	public AnchorPoint(String macAddress, double RSSI, double x_location,
			double y_location) {
		super();
		this.macAddress = macAddress;
		this.sumRSSI = 0;
		if (RSSI > 0) {

		} else {
			this.RSSI = setRSSIInWatt(RSSI);
			sumRSSI += this.RSSI;
			countAverage++;
		}
		this.x_location = x_location;
		this.y_location = y_location;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public double getRSSI() {
		return RSSI;
	}

	public void setRSSI(double RSSI) {
		this.RSSI = RSSI;
	}

	public double getX_location() {
		return x_location;
	}

	public void setX_location(double x_location) {
		this.x_location = x_location;
	}

	public double getY_location() {
		return y_location;
	}

	public void setY_location(double y_location) {
		this.y_location = y_location;
	}

	public double setRSSIInWatt(double RSSI) {
		setRSSI(Math.pow(10, (RSSI / 10)));
		return getRSSI();
	}

	public double getAverageRSSI(double newRSSI) {
		this.sumRSSI += newRSSI;
		countAverage++;
		return this.sumRSSI / this.countAverage;
	}

	public int compareTo(AnchorPoint anchorPoint) {
		// TODO Auto-generated method stub
		// sort descending
		return this.RSSI < anchorPoint.RSSI ? 1
				: this.RSSI > anchorPoint.RSSI ? -1 : 0;
	}
}

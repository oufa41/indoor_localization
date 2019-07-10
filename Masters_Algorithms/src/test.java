import java.util.ArrayList;
import java.util.Collections;

import Algorithms.RSSI_PD_Average;
import Algorithms.RSSI_PD_Normal;
import Algorithms.RSSI_Weighted;
import Algorithms.WCL_Weighted;
import Algorithms.WC_WCL_Weighted;
import Helper.AnchorPoint;
import Helper.Combination;

public class test {
	static AnchorPoint anchorPoint = new AnchorPoint();

	public static void printArray(ArrayList values) {
		for (int i = 0; i < values.size(); i++) {
			System.out.print(values.get(i)+" ");
		}
	}
	public static void printArrayAnchors(ArrayList<AnchorPoint> values) {
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getRSSI()+" ");
		}
	}
	public static void main(String[] args) {
        AnchorPoint anchorPoint = new AnchorPoint("A", -41.0616, 0.0, 0.0);
        
		ArrayList<AnchorPoint> anchorPoints = new ArrayList<AnchorPoint>();
		/*anchorPoints.add(new AnchorPoint("A", -69.0000, 0.0, 0.0));
		anchorPoints.add(new AnchorPoint("B", -78.5424, 10.0, 0.0));
		anchorPoints.add(new AnchorPoint("C", -75.9897, 0.0, 10.0));
		anchorPoints.add(new AnchorPoint("D", -80.1394, 10.0, 10.0));*/
		anchorPoints.add(new AnchorPoint("A", -41.0616, 0.0, 0.0));
		anchorPoints.add(new AnchorPoint("B", -34.4855, 10.0, 0.0));
		anchorPoints.add(new AnchorPoint("C", -37.2665, 0.0, 10.0));
		anchorPoints.add(new AnchorPoint("D", -22.2789, 10.0, 10.0));
        
		for (int i = 0; i < anchorPoints.size(); i++) {
			System.err.println(anchorPoints.get(i).getRSSI());
		}
		
		RSSI_Weighted weighted = new RSSI_Weighted(anchorPoints);
		System.out.println("RSSI_Weighted_x: " + weighted.getXCoorinate());
		System.out.println("RSSI_Weighted_y: " + weighted.getYCoorinate());
		WCL_Weighted wcl_Weighted = new WCL_Weighted(anchorPoints);
		System.out.println("WCL_Weighted_x: " + wcl_Weighted.getXCoorinate());
		System.out.println("WCL_Weighted_y: " + wcl_Weighted.getYCoorinate());
		
		
		ArrayList<AnchorPoint> anchorPoints4 = new ArrayList<AnchorPoint>();
		anchorPoints4.add(new AnchorPoint("A", -79.0000, 0.0, 0.0));
		anchorPoints4.add(new AnchorPoint("B", -98.0849, 10.0, 0.0));
		anchorPoints4.add(new AnchorPoint("C", -92.9794, 0.0, 10.0));
		anchorPoints4.add(new AnchorPoint("D", -101.2789, 10.0, 10.0));

		WC_WCL_Weighted wcwcl_Weighted = new WC_WCL_Weighted(anchorPoints);
		System.out.println("WC_WCL_Weighted_x: " + wcwcl_Weighted.getXCoorinate());
		System.out.println("WC_WCL_Weighted_y: " + wcwcl_Weighted.getYCoorinate());
		
		
		
		ArrayList<AnchorPoint> anchorPoints2 = new ArrayList<AnchorPoint>();
		anchorPoints2.add(new AnchorPoint("A", -41.0616, 0.0, 0.0));
		anchorPoints2.add(new AnchorPoint("B", -34.4855, 10.0, 0.0));
		anchorPoints2.add(new AnchorPoint("C", -37.2665, 0.0, 10.0));
		anchorPoints2.add(new AnchorPoint("D", -22.2789, 10.0, 10.0));
		anchorPoints2.add(new AnchorPoint("E", -35.2686, 5.0, 0.0));
		anchorPoints2.add(new AnchorPoint("F", -36.6502, 0.0, 5.0));
		anchorPoints2.add(new AnchorPoint("G", -25.1055, 5.0, 10.0));
		anchorPoints2.add(new AnchorPoint("H", -18.0618, 10.0, 5.0));
		
		RSSI_PD_Normal rssi_PD = new RSSI_PD_Normal(anchorPoints);
		
		System.out.println("RSSI_PD_Normal_x: " + rssi_PD.getXCoorinate());
		System.out.println("RSSI_PD_Normal_y: " + rssi_PD.getYCoorinate());
		
		ArrayList<AnchorPoint> anchorPoints3 = new ArrayList<AnchorPoint>();
		anchorPoints3.add(new AnchorPoint("A", -41.0616, 0.0, 0.0));
		anchorPoints3.add(new AnchorPoint("B", -34.4855, 10.0, 0.0));
		anchorPoints3.add(new AnchorPoint("C", -37.2665, 0.0, 10.0));
		anchorPoints3.add(new AnchorPoint("D", -22.2789, 10.0, 10.0));
		anchorPoints3.add(new AnchorPoint("E", -35.2686, 5.0, 0.0));
		anchorPoints3.add(new AnchorPoint("F", -36.6502, 0.0, 5.0));
		anchorPoints3.add(new AnchorPoint("G", -25.1055, 5.0, 10.0));
		anchorPoints3.add(new AnchorPoint("H", -18.0618, 10.0, 5.0));
		RSSI_PD_Average rssi_PD2 = new RSSI_PD_Average(anchorPoints);
		
		System.out.println("RSSI_PD_Average_x: " + rssi_PD2.getXCoorinate());
		System.out.println("RSSI_PD_Average_y: " + rssi_PD2.getYCoorinate());
	
		
	}
}

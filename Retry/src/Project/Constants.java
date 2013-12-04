package Project;

import java.text.DecimalFormat;

public class Constants {
	public static final int numberOfNodes=21;
	public static double dPQ=.1;		
	public static final double ti = 0.001;		//processing delay (sec)
	public static final double pijKM = .000005;	//Propagation delay (sec) //remember to multiply by amount of kilometers
	public static final int l = 12000;			//average length of packet (bits)	
	public static double delta=(Constants.dPQ*Constants.numberOfNodes*(Constants.numberOfNodes-1));
	public static boolean overloadedLink=false; //set to true when a link overloads
	public static String filename = "results.txt";	
	public static DecimalFormat df = new DecimalFormat("#.###"); //for cleaning up the log
	
	
	public static double getdPQ() {
		return dPQ;
	}
	public static void setdPQ(double dPQ) {
		Constants.dPQ = dPQ;
	}
}

package Project;

public class Router {

	private int name;
	private double totalInputFlow=0; // bits per second
	private double processingDelay=0; //seconds



	public Router(int name) {
		this.name = name;
	}

	/*
	 * getter
	 */
	
	public double getTotalInputFlow() {
		return totalInputFlow;
	}

		public double getProcessingDelay() {
		return processingDelay;
	}
	
	/*
	 * setter
	 */
	
	public void setTotalInputFlow(double totalInputFlow) {
		this.totalInputFlow = totalInputFlow;
	}

	public void addTotalInputFlow(double fij) {
		this.totalInputFlow = +fij;
	}

	public void setProcessingDelay() {
		this.processingDelay = (Constants.ti*(this.totalInputFlow/8/1500));
	}
}

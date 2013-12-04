package Project;

public class Router {

	int name;
	double totalInputFlow=0; // bits per second

	public Router(int name) {
		this.name = name;
	}

	/*
	 * getter
	 */
	
	public double getTotalInputFlow() {
		return totalInputFlow;
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

}

package Project;

public class Adjacency {

	private int sourceNode;
	private int destinationNode;
	private int useCount = 0;
	private double speed;
	private double distance;
	private double Fij = Double.POSITIVE_INFINITY;
	private boolean alreadyProcessedLink = false;
	private double propogationDelay;

	public Adjacency(int argSourceNode, int argDestinationNode,
			double argspeed, double argDistance) {
		this.sourceNode = argSourceNode;
		this.destinationNode = argDestinationNode;
		this.speed = argspeed;
		this.distance = argDistance;
	}

	/*
	 * getters
	 */

	public int getSourceNode() {
		return this.sourceNode;
	}

	public int getDestinationNode() {
		return this.destinationNode;
	}

	public int getUseCount() {
		return this.useCount;
	}
	
	public double getFij(){
		return this.Fij;
	}

	public double getSpeed() {
		return this.speed;
	}

	public boolean getAlreadyProcessed() {
		return this.alreadyProcessedLink;
	}

	public double getPropogationDelay() {
		return propogationDelay;
	}

	public double getDistance() {
		return distance;
	}

	/*
	 * setters
	 */

	public void setUseCount(int argUseCount) {
		this.useCount = argUseCount;
	}

	public void setFij(double Fij) {
		this.Fij = Fij;
	}

	public void setProcessed(boolean argBool) {
		this.alreadyProcessedLink = argBool;
	}

	@Override
	public String toString() {

		return this.sourceNode + " to " + this.destinationNode + " use count "
				+ this.useCount + " speed " + this.speed + " distance "
				+ this.distance;
	}

	public void setPropogationDelay(double propogationDelay) {
		this.propogationDelay = propogationDelay;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}

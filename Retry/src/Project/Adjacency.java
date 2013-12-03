package Project;

public class Adjacency {

	private int sourceNode;
	private int destinationNode;
	private int useCount = 0;
	private double speed;
	private double distance;
	private double delay = Double.POSITIVE_INFINITY;
	private boolean alreadyProcessedLink = false;

	public Adjacency(int argSourceNode, int argDestinationNode,
		double argspeed, double argDistance) {
		this.sourceNode = argSourceNode;
		this.destinationNode = argDestinationNode;
		this.speed = argspeed;
		this.distance = argDistance;
	}

	public int getSourceNode() {
		return this.sourceNode;
	}

	public int getDestinationNode() {
		return this.sourceNode;
	}

	public int getUseCount() {
		return this.useCount;
	}

	public double getSpeed() {
		return this.speed;
	}

	public boolean getAlreadyProcessed() {
		return this.alreadyProcessedLink;
	}
	
	
	
	

	public void setUseCount(int argUseCount) {
		this.useCount = argUseCount;
	}

	public void setDelay(double argDelay) {
		this.delay = argDelay;
	}

	public void setProcessed(boolean argBool) {
		this.alreadyProcessedLink = argBool;
	}

	
	@Override
	public String toString(){
		
		return this.sourceNode + " to " + this.destinationNode + " use count " + this.useCount + " speed " + this.speed 
				+" distance " + this.distance;
		
	}

}

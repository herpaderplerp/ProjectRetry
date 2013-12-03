
public class Adjacency {

	int sourceNode;
	int destinationNode;
	int useCount;
	double speed;
	double distance;
	double delay;
	boolean alreadyProcessedLink =false;
	
	
	
	public Adjacency(int argSourceNode,int argDestinationNode, double argspeed, double argDistance){
		this.sourceNode=argSourceNode;
		this.destinationNode=argDestinationNode;
		this.speed=argspeed;
		this.distance=argDistance;
	}
	
	public int getSourceNode(){
		return this.sourceNode;
	}
	
	public int getDestinationNode(){
		return this.sourceNode;
	}
	
	public int getUseCount(){
		return this.useCount;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public boolean getAlreadyProcessed(){
		return this.alreadyProcessedLink;
	}
	
	
	
	
	
	public void setUseCount(int argUseCount){
		this.useCount=argUseCount;
	}
	
	public void setDelay(double argDelay){
		this.delay=argDelay;
	}
	
	public void setProcessed(boolean argBool){
		this.alreadyProcessedLink=argBool;
	}
	
	
	
	
}

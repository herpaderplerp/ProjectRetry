
public class Adjacency {

	int sourceNode;
	int destinationNode;
//	int useCount;
	double cost;
	double distance;
	
	
	
	public Adjacency(int argSourceNode,int argDestinationNode, double argCost, double argDistance){
		this.sourceNode=argSourceNode;
		this.destinationNode=argDestinationNode;
		this.cost=argCost;
		this.distance=argDistance;

	}
	
}

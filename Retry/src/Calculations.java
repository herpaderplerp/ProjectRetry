import java.util.LinkedList;

public class Calculations {

	public double determinePij(double linkLength) {
		return Constants.pijKM * linkLength;
	}

	public double determineFij(int linkUse) {
		return Constants.dPQ * linkUse;
	}

	public LinkedList<Adjacency> determineLinkDelay(LinkedList<Adjacency> adj,
			int[][] useMatrix) {

		int numberOfAdjacancies = adj.size();

		for (int i = 0; i < numberOfAdjacancies; i++) {

			if (adj.get(i).getAlreadyProcessed() == false) {

				/*
				 * ^ this adjacency hasn't already been processed
				 */

				for (int p = 0; i < numberOfAdjacancies; i++) {
					if ((adj.get(i).sourceNode == adj.get(p).destinationNode)
							&& (adj.get(i).destinationNode == adj.get(p).sourceNode)
							&& adj.get(p).alreadyProcessedLink) {
						/*
						 * the brother adjacency has already been processed in
						 * the calculation do not go further
						 */
					} else

					if (adj.get(i).sourceNode < adj.get(i).destinationNode) {
						// ensure we look at the right spot in the array
						adj.get(i).useCount = useMatrix[adj.get(i).sourceNode][adj
								.get(i).destinationNode];
						// copy the value over
					} else {
						adj.get(i).useCount = useMatrix[adj.get(i).destinationNode][adj
								.get(i).sourceNode];
					}

					adj.get(i).setProcessed(true);
				}

			}
			/*
			 * at this point the adjacency objects all have use counts except
			 * for their pair
			 */

			double possibleLinkFlow=(Constants.dPQ * adj.get(i).getUseCount()); //wrong not setting delay here
			if (possibleLinkFlow<adj.get(i).speed){
				adj.get(i).setDelay(possibleLinkFlow/(adj.get(i).speed-possibleLinkFlow));
				/*confirming the Fij doesn't exceed the Cij
				 * then determine and set link delay
				 */
			}else{
				/*
				 * need to determine what todo when constraint exceeded
				 * set
				 */
			}
				


		}

		return adj;

	}

}

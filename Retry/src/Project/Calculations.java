package Project;

import java.util.LinkedList;

public class Calculations {

	public double determinePij(double linkLength) {
		return Constants.pijKM * linkLength;
	}

	public double determineFij(int linkUse) {
		return Constants.dPQ * linkUse;
	}

	public static LinkedList<Adjacency> determineLinkDelay(
			LinkedList<Adjacency> adj, int[][] useMatrix) {

		LinkedList<Router> routs = new LinkedList<Router>();
		for (int i = 1; i < Constants.numberOfNodes + 2; i++) {
			Router e = new Router(i);
			routs.add(e);
		}
		/*
		 * ^ make a router object for every router will be useful later for
		 * determining total flow and processing delay
		 */

		int numberOfAdjacancies = adj.size();

		for (int i = 0; i < numberOfAdjacancies; i++) {

			if (adj.get(i).getAlreadyProcessed() == false) {

				/*
				 * ^ this adjacency hasn't already been processed
				 */

				for (int p = 0; p < numberOfAdjacancies; p++) {
					if ((adj.get(i).getSourceNode() == adj.get(p)
							.getDestinationNode())
							&& (adj.get(i).getDestinationNode() == adj.get(p)
									.getSourceNode())
							&& adj.get(p).getAlreadyProcessed()) {
						/*
						 * the brother adjacency has already been processed in
						 * the calculation do not go further
						 */
					} else

					if (adj.get(i).getSourceNode() < adj.get(i)
							.getDestinationNode()) {
						// ensure we look at the right spot in the array
						adj.get(i).setUseCount(
								useMatrix[adj.get(i).getSourceNode()][adj
										.get(i).getDestinationNode()]);
						// copy the value over
					} else {
						adj.get(i).setUseCount(
								useMatrix[adj.get(i).getDestinationNode()][adj
										.get(i).getSourceNode()]);
					}

					adj.get(i).setProcessed(true);
				}

			}
			/*
			 * at this point the adjacency objects all have use counts except
			 * for their pair
			 */

			double possibleLinkFlow = (Constants.dPQ * adj.get(i).getUseCount() * Constants.l);

			if (possibleLinkFlow < adj.get(i).getSpeed()) {
				adj.get(i).setFij(
						possibleLinkFlow
								/ (adj.get(i).getSpeed() - possibleLinkFlow));
				/*
				 * confirming the Fij doesn't exceed the Cij then determine and
				 * set link delay
				 */

				System.out.println(adj.get(i).toString());

				System.out.println("link " + adj.get(i).getSourceNode()
						+ " to " + adj.get(i).getDestinationNode());
				System.out.println("Cij = " + adj.get(i).getSpeed());
				System.out.println("Fij = " + possibleLinkFlow);

			} else {
				/*
				 * need to determine what todo when constraint exceeded set
				 */
				System.err.println("WARNING - link "
						+ adj.get(i).getSourceNode() + " to "
						+ adj.get(i).getDestinationNode());
				System.err.println("Link has exceeded maximum capacity");
				System.err.println("Cij = " + adj.get(i).getSpeed());
				System.err.println("Fij = " + possibleLinkFlow);

			}

			adj.get(i).setPropogationDelay(
					adj.get(i).getDistance() * Constants.pijKM);
			/*
			 * set propogation delay (sec) to every adj
			 */

			routs.get(adj.get(i).getSourceNode()).addTotalInputFlow(
					adj.get(i).getFij());
			routs.get(adj.get(i).getDestinationNode()).addTotalInputFlow(
					adj.get(i).getFij());		
			
			/*
			 * set processing delay
			 */

		}

		return adj;

	}
}

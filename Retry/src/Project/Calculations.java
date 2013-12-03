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

		// for (int i = 0; i < 21; i++) {
		// System.out.println(adj.get(i).toString());
		// }

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

					if (adj.get(i).getSourceNode() < adj.get(i).getDestinationNode()) {
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

			double possibleLinkFlow = (Constants.dPQ * adj.get(i).getUseCount());

			if (possibleLinkFlow < adj.get(i).getSpeed()) {
				adj.get(i).setDelay(
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

		}

		return adj;

	}

}

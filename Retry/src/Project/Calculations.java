package Project;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class Calculations {

	public static LinkedList<Adjacency> determineDelay(
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

		final int numberOfAdjacancies = adj.size();

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
				adj.get(i).setFij(possibleLinkFlow);
				/*
				 * confirming the Fij doesn't exceed the Cij then determine and
				 * set link delay
				 */

				// System.out.println(adj.get(i).toString());
				//
				// System.out.println("link " + adj.get(i).getSourceNode()
				// + " to " + adj.get(i).getDestinationNode());
				// System.out.println("Cij = " + adj.get(i).getSpeed());
				// System.out.println("Fij = " + possibleLinkFlow);

			} else {
				// routs.get(i).setProcessingDelay();
				/*
				 * will take info already in object to generate processingdelay
				 * value
				 */

				/*
				 * need to determine what todo when constraint exceeded set when
				 * constraint exceeded just set fIJ as max speed V
				 */
				adj.get(i).setFij(adj.get(i).getSpeed());

				Constants.overloadedLink = true;
				/*
				 * inform application that a link has been overloaded
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
					(adj.get(i).getFij()));
			routs.get(adj.get(i).getDestinationNode()).addTotalInputFlow(
					(adj.get(i).getFij()));
			/*
			 * set total input flow for every router
			 */

		}

		// for (int i = 1; routs.size() < Constants.numberOfNodes + 1; i++) {
		//
		// routs.get(i).setProcessingDelay();
		// /*
		// * will take info already in object to generate processingdelay
		// * value
		// */
		// }
		/*
		 * this is not required
		 */

		/*
		 * big boy calculation below
		 */
		double sumOfDelay = 0;
		for (int i = 0; i < numberOfAdjacancies; i++) {

			/*
			 * using the -alreadyprocessed- parameter to avoid adding twice
			 */
			if (adj.get(i).getAlreadyProcessed() == true) {

				double fIJ = adj.get(i).getFij();
				double speed = adj.get(i).getSpeed();
				double propdel = adj.get(i).getPropogationDelay();

				sumOfDelay = sumOfDelay
						+

						((adj.get(i).getFij() / (adj.get(i).getSpeed() - adj
								.get(i).getFij())) +

						((adj.get(i).getPropogationDelay() + Constants.ti) *

						(adj.get(i).getFij() / Constants.l)));
			}

		}

		Double networkAverageDelay;
		networkAverageDelay = (1 / Constants.delta) * sumOfDelay;

		System.out.println("Has overload occured " + Constants.overloadedLink);
		System.out.println("Current DPQ " + Constants.dPQ);
		System.out.println("Sum of network delay (ms) " + sumOfDelay);
		System.out.println("Avg network delay (ms) " + networkAverageDelay);

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(Constants.filename, true)));
			out.append("DPQ " + Constants.df.format(Constants.dPQ)
					+ " avgDelay " + Constants.df.format(networkAverageDelay)
					+ " overload " + Constants.overloadedLink);
			out.println();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adj;

	}
}

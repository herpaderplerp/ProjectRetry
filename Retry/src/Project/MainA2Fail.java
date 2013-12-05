package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainA2Fail {

	// file reader
	public static LinkedList<Adjacency> readFile(String filename) {

		LinkedList<Adjacency> adj = new LinkedList<Adjacency>();

		filename = "ARPA.txt";
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);

			int numberOfNodes = sc.nextInt();
			System.out.println("Number of nodes = " + numberOfNodes);
			while (sc.hasNext() == true) { // read file (effectively) line by
											// line

				int srcnode = sc.nextInt();
				int dstnode = sc.nextInt();
				double speed = sc.nextDouble();
				double distance = sc.nextDouble();

				Adjacency e = new Adjacency(srcnode, dstnode, speed, distance);
				adj.add(e);

			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return adj;

	}

	public static int[][] linkUseCount(int[][] useMatrix, String path) {

		path = path.replace("[", " "); // clean up string
		path = path.replace("]", " ");
		path = path.replace(",", " ");

		try {
			Scanner sc = new Scanner(path);

			int firstNode = sc.nextInt();
			if (sc.hasNextInt()) { // if this isn't the first lookup....
				useMatrix = deeper(firstNode, useMatrix, sc);
				// call
				// recursive
				// method
				// sending it
				// the name of
				// the first
				// node
			}

			sc.close();

		} catch (InputMismatchException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

		return useMatrix;

	}

	public static int[][] deeper(int previous, int[][] theArray, Scanner sc) {
		int next = sc.nextInt();
		if (previous < next) {
			/*
			 * this ensures the lowest value is always used as column index thus
			 * preventing the (3x1)!=(1x3) problem
			 */
			// System.out.println("no need to reverse index");
			// System.out.println("before change, index" + previous + "x" + next
			// + "=" + theArray[previous][next]);
			theArray[previous][next] = theArray[previous][next] + 1;
			// System.out.println("after change " + theArray[previous][next]);
		} else {
			// System.out.println("index was reversed");
			// System.out.println("before change, index " + next + "x" +
			// previous
			// + "=" + theArray[next][previous]);
			theArray[next][previous] = theArray[next][previous] + 1;
			// System.out.println("after change " + theArray[next][previous]);
		}

		if (sc.hasNext()) {
			deeper(next, theArray, sc);
		}
		return theArray;
	}

	public static void printUseMatrix(int[][] useMatrix) {
		// does
		// not
		// work
		int column = 1;
		String output = null;

		while (column < Constants.numberOfNodes) { // print column index
			System.out.print(column + " ");
			column++;
		}

		output += "\n";

		for (int row = 1; row < useMatrix.length; row++) {
			output += row;

			for (int col = 1; col < useMatrix[row].length; col++) {
				output += " " + useMatrix[row][col];
			}
			for (int index = 1; index < Constants.numberOfNodes; index++) {
			}
			output += "\n";
		}

		System.out.println(output);
	}

	public static String useArrayPrint(int[][] useMatrix) {
		return Arrays.deepToString(useMatrix);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final long startTime = System.currentTimeMillis();// start timer
		// http://stackoverflow.com/questions/2572868/how-to-time-java-program-execution-speed

		// importing text file

		int[][] useMatrix = new int[Constants.numberOfNodes + 1][Constants.numberOfNodes + 1]; // 2d
		// array
		// (needs
		// to
		// be
		// size+1
		// as
		// we
		// are
		// not
		// using
		// index0

		for (int row = 0; row < Constants.numberOfNodes; row++) {
			/*
			 * initialize with all zeros
			 */
			for (int column = 0; column < Constants.numberOfNodes; column++) {
				useMatrix[row][column] = 0;
			}
		}

		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");
		Vertex v9 = new Vertex("9");
		Vertex v10 = new Vertex("10");
		Vertex v11 = new Vertex("11");
		Vertex v12 = new Vertex("12");
		Vertex v13 = new Vertex("13");
		Vertex v14 = new Vertex("14");
		Vertex v15 = new Vertex("15");
		Vertex v16 = new Vertex("16");
		Vertex v17 = new Vertex("17");
		Vertex v18 = new Vertex("18");
		Vertex v19 = new Vertex("19");
		Vertex v20 = new Vertex("20");
		Vertex v21 = new Vertex("21");

		v1.adjacencies = new Edge[] { new Edge(v2, 1200000),
				new Edge(v8, 1500000), new Edge(v12, 1300000),
				new Edge(v16, 1500000) };

		v2.adjacencies = new Edge[] { new Edge(v1, 1200000),
				new Edge(v3, 1200000), new Edge(v11, 1500000),
				new Edge(v13, 1300000) };

		v3.adjacencies = new Edge[] { new Edge(v2, 1200000),
				new Edge(v4, 1500000) };

		v4.adjacencies = new Edge[] { new Edge(v3, 1500000),
				new Edge(v5, 1300000) };

		v5.adjacencies = new Edge[] { new Edge(v4, 1300000),
				new Edge(v6, 2000000), new Edge(v10, 1400000) };

		v6.adjacencies = new Edge[] { new Edge(v5, 2000000),
				new Edge(v7, 1900000) };

		v7.adjacencies = new Edge[] { new Edge(v6, 1900000),
				new Edge(v9, 1500000) };

		v8.adjacencies = new Edge[] { new Edge(v1, 1500000),
				new Edge(v14, 1500000) };

		v9.adjacencies = new Edge[] { new Edge(v21, 1300000),
				new Edge(v7, 1500000) };

		v10.adjacencies = new Edge[] { new Edge(v5, 1400000),
				new Edge(v15, 1500000) };

		v11.adjacencies = new Edge[] { new Edge(v2, 1500000),
				new Edge(v15, 1400000) };

		v12.adjacencies = new Edge[] { new Edge(v1, 1300000),
				new Edge(v16, 1500000) };

		v13.adjacencies = new Edge[] { new Edge(v2, 1300000),
				new Edge(v17, 1600000) };

		v14.adjacencies = new Edge[] { new Edge(v8, 1500000),
				new Edge(v17, 1500000) };

		v15.adjacencies = new Edge[] { new Edge(v10, 1500000),
				new Edge(v11, 1400000), new Edge(v19, 1400000) };

		v16.adjacencies = new Edge[] { new Edge(v1, 1500000),
				new Edge(v12, 1500000), new Edge(v17, 1500000) };

		v17.adjacencies = new Edge[] { new Edge(v13, 1600000),
				new Edge(v14, 1500000), new Edge(v16, 1500000),
				new Edge(v18, 1400000) };

		v18.adjacencies = new Edge[] { new Edge(v17, 1400000),
				new Edge(v19, 1500000) };

		v19.adjacencies = new Edge[] { new Edge(v15, 1400000),
				new Edge(v18, 1500000) 
//				,new Edge(v20, 2000000) //failed link
		};

		v20.adjacencies = new Edge[] { 
//				new Edge(v19, 2000000), //failed link
				new Edge(v21, 1700000) };

		v21.adjacencies = new Edge[] { new Edge(v9, 1300000),
				new Edge(v20, 1700000) };

		Vertex[] vertices = { v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11,
				v12, v13, v14, v15, v16, v17, v18, v19, v20, v21 };
		Dijkstra dij = new Dijkstra();
		for (int index = 0; index < Constants.numberOfNodes; index++) {

			dij.computePaths(vertices[index]);
			// System.out.println(dij.printPath(vertices, index));
			for (Vertex v : vertices) {
				System.out.println("Distance to " + v + ": " + v.minDistance);
				List<Vertex> path = dij.getShortestPathTo(v);

				String test = path.toString();

				// dij.printPath(vertices, index);
				// String test = path.toString();
				System.out.println("Path: " + path);
				useMatrix = linkUseCount(useMatrix, test);
			}
			// reset the distance for new cal
			for (int i = 0; i < Constants.numberOfNodes; i++) {
				vertices[i].minDistance = Double.POSITIVE_INFINITY;
				vertices[i].previous = null;
			}

		}

		// {
		// dij.computePaths(v2);
		// for (Vertex v : vertices) {
		// // System.out.println("Distance to " + v + ": " +
		// // v.minDistance);
		// List<Vertex> path = Dijkstra.getShortestPathTo(v);
		// String test = path.toString();
		// System.out.println("Path: " + path);
		// useMatrix = linkUseCount(useMatrix, test);
		// }
		// }
		//

		// printUseMatrix(useMatrix);

		LinkedList<Adjacency> adj = new LinkedList<Adjacency>();
		adj = readFile("test");
		/*
		 * create and fill objects
		 */

		Constants.filename="A2Fail.txt";
		Constants.dPQ=.1;
		while (Constants.overloadedLink == false) {
			adj = Calculations.determineDelay(adj, useMatrix);
			Constants.dPQ+=Constants.dPQincrement;
		}

		// for (int i = 0; i < 21; i++) {
		// System.out.println(adj.get(i).toString());
		// }

		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime)
				+ " milliseconds");

	}
}

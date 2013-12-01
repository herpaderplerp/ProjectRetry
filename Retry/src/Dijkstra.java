/* The authors of this work have released all rights to it and placed it
in the public domain under the Creative Commons CC0 1.0 waiver
(http://creativecommons.org/publicdomain/zero/1.0/).

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Dijkstra's_algorithm_(Java)?oldid=15444
 */

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;//added
import java.io.FileReader;
import java.io.IOException;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = (100000000/e.weight);
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}
	
	
	//file reader
	public String readFile(String filename)
	{
	   String content = null;
	   File file = new File("ARPA.txt"); //for ex foo.txt
	   try {
	       FileReader reader = new FileReader(file);
	       char[] chars = new char[(int) file.length()];
	       reader.read(chars);
	       content = new String(chars);
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return content;
	}
	
	
	public static void linkUseCount(int numberOfNodes, String path){
		
		 int useMatrix[][];
		
		Scanner sc = new Scanner(path);
		useMatrix[sc.nextInt()][sc.nextInt()]=++;
		
	}

	public static void main(String[] args) {
		//importing text file
		
		
		
		
		
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

		v1.adjacencies = new Edge[] { 
				new Edge(v2, 1200000), 
				new Edge(v8, 1500000),
				new Edge(v12, 1300000),
				new Edge(v16, 1500000) };
		
		v2.adjacencies = new Edge[] { new Edge(v1, 1200000),
				new Edge(v3, 1200000),
				new Edge(v11, 1500000),
				new Edge(v13, 1300000),};
		
		v3.adjacencies = new Edge[] { new Edge(v4, 1500000)};
		
		v4.adjacencies = new Edge[] { new Edge(v3, 1500000),
				new Edge(v5, 1300000)};
		
		v5.adjacencies = new Edge[] { new Edge(v4, 1300000),
				new Edge(v6, 2000000),
				new Edge(v10, 1400000)};
		
		
		v6.adjacencies = new Edge[] { new Edge(v5, 2000000), 
				new Edge(v7, 1900000) };
		
		v7.adjacencies = new Edge[] { new Edge(v6, 1900000), 
				new Edge(v9, 1500000) };
		
		v8.adjacencies = new Edge[] { new Edge(v14, 1500000)};
		
		v9.adjacencies = new Edge[] { new Edge(v21, 1300000)};
		
		v10.adjacencies = new Edge[] { new Edge(v15, 1500000)};
		
		v11.adjacencies = new Edge[] { new Edge(v15, 1400000)};
		

		v12.adjacencies = new Edge[] { new Edge(v16, 1500000)};
		

		v13.adjacencies = new Edge[] { new Edge(v17, 1600000)};
		
		
		v14.adjacencies = new Edge[] {new Edge(v8, 1500000),
				new Edge(v17, 1500000)};
		
		v15.adjacencies = new Edge[] {new Edge(v10, 1500000),
				new Edge(v11, 1400000),
				new Edge(v19, 1400000)};
		
		v16.adjacencies = new Edge[] {new Edge(v12, 1500000),
				new Edge(v17, 1500000)};
		
		v17.adjacencies = new Edge[] {new Edge(v13, 1600000),
				new Edge(v14, 1500000),
				new Edge(v16, 1500000),
				new Edge(v18, 1400000)};
		
		v18.adjacencies = new Edge[] {new Edge(v17, 1400000),
				new Edge(v19, 1500000)};
		
		v19.adjacencies = new Edge[] {new Edge(v15, 1400000),
				new Edge(v18, 1500000),
				new Edge(v20, 2000000)};
		
		v20.adjacencies = new Edge[] {new Edge(v19, 2000000),
				new Edge(v21, 1700000)};
		
		v21.adjacencies = new Edge[] {new Edge(v9, 1300000),
				new Edge(v20, 1700000)};
		
		
		
		
		
		
		
		Vertex[] vertices = {v1, v2, v3, v4, v5, v6, v7, v8 , v9 , v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21 };

		computePaths(v1);
		for (Vertex v : vertices) {
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
			System.out.println("Path: " + path);
		}
		

			computePaths(v2);
			for (Vertex v : vertices) {
				System.out.println("Distance to " + v + ": " + v.minDistance);
				List<Vertex> path = getShortestPathTo(v);
				System.out.println("Path: " + path);
			
		}
		
	}
}

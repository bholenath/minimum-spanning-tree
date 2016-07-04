# minimum-spanning-tree
This code simulates the Minimum Spanning Tree (M.S.T) Dijikstra's algorithm used in real networks for routing.

The program works on an input of certain number of vertices(hosts) and edges(links) that are provided by the user. 

Four files were used to implement this algorithm :

Mst.java -> the main file of the program which call major functions and display the final result.

Edge.java -> this file initilaizes and stores the weight of every edge and its connectivity to respective vertices.

Sorted.java -> here I sort all the edges by their weight and arrange them in a list which would be checked in order to form MST.

MinEdges.java -> this file finds the shortest route covering all nodes by checking for loops and cycle.

Data is fed through a test file which contains a sample of edges and vertices. Mst.java file divides the list between edges and vertices and pass it to the respective functions.  

A double dimesnional array is constructed by Sorted.java which stores object for every edge having information about the edge weight and vertices it is connected to.

MinEdges.java file is called from the main file Mst.java. Then from MinEdges.java file Sorted.java is called to get all sorted edges with detail which is returned back to MinEdges.java for generating the MST.

In Sorted.java firstly the filtering is performed to remove all non-essential edges which eases the complexity of the algorithm.

A function named 'remove_Reduntant' remove edges having same vertices based on their weight. Edges that form loop were also remove in this step.

As the edges were directional it was important to remove one of the edge in bi-directional edges (e.g., 0 -> 3 and 3 -> 0) based on their weight as they both could lead to an infinite loop of cycle between them.

A list is now generated from the remaining edges sorted in the ascending order of their weight and is returned to MinEdges.java.

Now the main work of MinEdges file starts. I added a timer to the function which dispalys the current MST on a periodic basis. A timer and timer task function were added which display edges present in Minimum Spanning Tree with every second.

This process works in a multi-threaded enviorment where one thread is concentrated on displaying MST periodically and the other thread working on genrating the MST.

To calculate the edges for minimum spanning tree the two lowest weight edges were required to make a network hence, they were the first to be added for the M.S.T. After this another double array list name "arrlist" was initialized which stores the common vertices which are involved in an edge (eg. if minimum spanning tree has a vertex 0-7 initially, so in the double dimension array list "arrlist" 0 vertex list would store 7 as a vertex in it and 7 would store 0). Now for every new edge from the sorted list its vertices are compared with the vertices already present in the "arrlist" so as to remove any cycle formation in the network.

For eg. if we have two vertices namely "a" and "b" in the new edge taken from sorted list, we would first compare "b" with all the vertices having edges with "a" (which are stored in the array 'arraylist') and vice versa, so as to verify if this new edge would not create a cycle and hence, whether it could be added to the M.S.T.

(eg. if a has a common edge with vertex 0 and b has edge with vertex 7. Now we see the edges common with vertex 0. Say vertex 0 has vertex 3 and 5 already added into the M.S.T. We now compare vertex 7 with vertices present in 3 and 5 array. If there is a match then the edge a-b is neglected for being in M.S.T. as it would result into a cycle. If there is no match then vice versa 0 is compared to vertices present in array 'arraylist' of 7. Even if after this we didn't get a match we run this process unitl all subsequent vertices of a and b vertex are checked and if there is still no vertex common we could add the edge 'a-b' to the M.S.T. The vertices for whom this process is already done are marked as done so as we not repeat there comparison if they come up in a new edge.

We continue this process of checking for new edges to be added in the M.S.T. until we get (no. of vertices - 1) edges as it is the maximum number of edges that can be present in a M.S.T.

Finally after concluding this we have our Minimum Spanning tree with all its edges.

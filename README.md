# minimum-spanning-tree
Helps to simulate the minimum spanning tree Dijikstra's algorithm used in real networks

/* This project report is for the Computer Network final Project of Fall 2014, made and compiled by Harshit Bhatt with inputs from Mahesh Kotapalli and Jenny Patel of Group -6. */

The program which I have made try to construct a Minimum Spanning Tree for a certain number of vertices(hosts) and edges(links) 
that are present initially with us. For the input I have take a file from the internet by providing its URL as the input for collecting data.

From the file I collected the number of vertices and constructed a double dimension array list which hold edges for each vertex.

There were four files thaat I have used to work out the whole program namely :

Mst.java -> this is the main file of the program which calls functions in other programs to display the result.
Edge.java -> this file saves the values of every Edge(vertices and edge weight).
Sorted.java -> this file does all the work of sorting the edges and finally making a single list.
MinEdges.java -> this file calculates and displays the edges for the Minimum Spanning Tree.

Mst.java only allows to take the input of file and read it for collecting vertices and edges present in our input.
Objects for every other file are present in the main file to call them for specific purposes.

After getting the total number of vertices in the system I first called the sorted.java file which constructs a double dimension Array 
list which stores object of every edge to its respective vertex. After this for Every edge an object is made which stores its vertices 
and edge weight that is made possible by the Edge.java file.

The values can be collected for any edge by calling certain functions in the Edge class which return vertices and edge weight for that 
edge. 

The edges are saved by calling addEdge function in sorted.java file to its respective vertex.

After this MinEdges.java file was called from main Mst.java file as all the sorted functions in Sorted.java are called from the
MinEdges.java constructor. First function named remove_Reduntant removes all the edges with same vertices present in a vertex based on
comparing their weight, so edge with lowest weight was saved and other removed. This also removes if their were any self loops present
in the network cause self loops can't be present in a Minimum Spanning tree. 

Second function single now moves all the remaining edges into a single array list. 

After this list_Remove_Duplicate function was called which removes bi-directional edges(eg. 0 -> 3 and 3 -> 0)
if present depending on the edge weight keeping the lowest weight edge.

After this the single list was sorted in order of their edge weight so as to make easy to add them to Minimum Spanning tree on 
comparison.

To get the edges values for comparison in Sorted.java, objects of Edge.java were made respective for each edge through which we get the
values for each edge.

Now the main work of MinEdges file started as we would like to display the data on a periodic basis so I constructed a timer and timer task function which displays Edges present in minimum spanning tree with every second.

For this I needed to construct another class Running which extends TimerTask class and hence as we override thread run function in it
which displays the Minimum Spanning tree that has been constructed within those seconds. The edges for minimum spanning tree are saved
by the name sorted list. Hence as sorted list is the global variable it is displayed for that time whereas other thread is still working on its calculations to extract the minimum spanning tree edges which are being done in the function check_Tree.

To calculate the edges for minimum spanning tree I initially took the first two edges present in the sorted list which we get from the sorted.java file as the two edges with least weight would surely be present in the minimum spanning tree as we have removed the concept of self-loops. After this another double array list name "arrlist" was initialized which stores the vertices for every vertex if that vertex is present in the minimum spanning tree (eg. if minimum spanning tree has a vertex 0-7 initially, so in the double dimension array list "arrlist" 0 vertex list would store 7 as a vertex in it and 7 would store 0). Now for every new edge from the sorted list, its vertices are compared with the vertices already present in the "arrlist" so as to remove any cycle formation in the network.

For eg. if we have two vertices namely "a" and "b" in the new edge taken from sorted list, we would first compare "b" with all the vertices present in the array of respective vertices of "a" (eg. if a=0, b=7 and 0 vertex array has 3,5(which means in the minimum spanning tree 0 has two edges with 3 and 5) vertex present in it, then 7 is compared with vertices present in 3 and 5 array - as 7 cannot be in the 0 vertex array as we don't have bi-directional edges in our network - if there is a match then that edge is neglected for minimum spanning tree as it would result into a cycle. If there is no match then 0 is now compared to vertex arrays of vertices present in 7(if 7 has 2,1 as vertices in its array 0 is compared to the vertices present in 2 and 1 vertex array) whenever we get a match we remove that edge from the contention of being in minimum spanning tree and move to next edge.) Even if after this we didn't get a match we run this process for second time by the run_Recheck function which checks for subsequent vertices in the vertex array for a match for either "a" or "b" respectively with run_Recheck and run_Recheck1 functions. I also made another set of array lists check_a and check_b which keep storing the vertices for whom the algorithm has already checked for with either "a" or "b" so we doesn't run into an infinite loop of rechecking the vertices again and again as every edge has been saved by both its vertices.

If we still didn't get a match after using subsequent search which ends if there is no edge remains in a vertex array to look for, we add that edge to the minimum spanning tree and add its vertices to their respective arrays for further edge checking. 

We continue this process of checking for new edges to be added in the minimum spanning tree until we get (no. of vertices - 1) edges as it is the maximum number of edges that can be present in a minimum spanning tree.

Finally after concluding this we have our Minimum Spanning tree with all its edges.

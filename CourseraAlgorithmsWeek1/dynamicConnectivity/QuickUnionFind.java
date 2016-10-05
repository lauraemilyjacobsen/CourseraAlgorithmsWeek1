package dynamicConnectivity;

public class QuickUnionFind {
	// Store objects in tree structures. Each connected component is one tree where all objects share a root.
	
	// Array containing the objects to be connected.
	private int[] id;
	
	// Initialize a union-find data structure with N objects
	public QuickUnionFind(int N){
		id = new int[N];
		// Initialize each object in id to the value of its index
		for (int i=0; i<N; i++){
			id[i] = i;
		}
	}
	
	// Add a connection between p and q
	public void union(int p, int q){
		// Set the root of p to be the root of q
		int i = id[p];
		int j = id[q];
		id[p] = j;
	}
	
	// Are p and q in the same component?
	public boolean connected(int p, int q){
		// p and q are connected if they have the same root.
		return root(p) == root(q);
	}
	
	// Get the root of i
	private int root(int i){
		// Chase parent pointers until we reach an object that is its own parent
		while (i != id[i]){
			i = id[i]; 
		}
		return i;
	}
	
	// Component identifier for p (0 to N-1)
	// This can be up to N accesses if the tree gets too tall.
	public int find(int p){
		return 0;
	}
	
	// Number of components
	public int count(){
		return 0;
	}
}
package dynamicConnectivity;

public class UnionFind {
	
	// Array containing the objects to be connected.
	private int[] id;
	
	// Initialize a union-find data structure with N objects
	public UnionFind(int N){
		id = new int[N];
		// Initialize each object in id to the value of its index
		for (int i=0; i<N; i++){
			id[i] = i;
		}
	}
	
	// Add a connection between p and q
	// Slow: Initializing array and performing unions on N objects takes quadratic time
	public void union(int p, int q){
		// Update the id of every object in p's component to q
		int pid = id[p];
		int qid = id[q];
		
		for (int i=0; i<id.length; i++){
			if (id[i]==pid){
				id[i]= qid;
			}
		}
	}
	
	// Are p and q in the same component?
	public boolean connected(int p, int q){
		// p and q are connected if they have the same id.
		return id[p] == id[q];
	}
	
	// Component identifier for p (0 to N-1)
	public int find(int p){
		return 0;
	}
	
	// Number of components
	public int count(){
		return 0;
	}
}
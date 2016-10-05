package dynamicConnectivity;

//When performing unions, always put the smaller tree lower. This will keep the trees balanced.
//Union and connected() operations take logarithmic time (scalable)

public class WeightedUnionFind {
	// Array containing the objects to be connected.
	private int[] id;
	
	// Array containing the size of trees rooted at sz[i]
	private int[] sz;
	
	// Initialize a union-find data structure with N objects
	public WeightedUnionFind(int N){
		id = new int[N];
		// Initialize each object in id to the value of its index
		for (int i=0; i<N; i++){
			id[i] = i;
		}
		
		sz = new int[N];
	}
	
	// Add a connection between p and q
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		if (i==j) return; // the objects are already connected
		
		// if sz[i] >= sz[j], put j under i
		if (sz[i] >= sz[j]){
			id[j] = i;
			sz[i] += sz[j];
		} 
		
		// if sz[i] < sz[j], put i under j
		else {
			id[i] = j;
			sz[j] += sz[i];
		}
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
			id[i] = id[id[i]]; // Path compression: make every other node point to its grandparent; flattens tree
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

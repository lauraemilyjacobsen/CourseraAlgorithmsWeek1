package dynamicConnectivity;
import princeton.StdIn;
import princeton.StdOut;

public class Client {
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFind uf = new UnionFind(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q)){
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		
	}

}
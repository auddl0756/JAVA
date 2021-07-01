package basic;

class DisjointSet {
	final int MAX;
	int[] parent;
	
	public DisjointSet() {
		this.MAX=10000;
		parent =new int[MAX];
		for(int i=0;i<MAX;i++) {
			parent[i]=i;
		}
	}
	
	public int find(int idx) {
		if(idx==parent[idx]) return idx;
		return parent[idx] = find(parent[idx]);	//경로 압축
	}
	
	public void merge(int idx1,int idx2) {
		int p1,p2;
		p1=find(idx1);
		p2=find(idx2);
		
		if(p1==p2) return;
		
		parent[p1]=p2;
	}
}

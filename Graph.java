import java.util.*;

public class Graph<E> {
	private ArrayList<E> vertex;
	private int[][] edges;
	private int numOfEdges;
    //此图中，vertex与邻接矩阵的顺序是一样的
	public Graph(int n) {
		edges = new int[n][n];
		vertex = new ArrayList<E>(n);
		numOfEdges = 0;// ?
	}
	
	private int getNumOfVertex(){
		return vertex.size();
	}
	
	public int getNumOfEdges(){
		return numOfEdges;
	}
	
	public E getValueByIndex(int i){
		return vertex.get(i);
	}
	//图的每一行1，2，3，4...元素对应的点的名字就是vertex中的第几个元素的值
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	
	public void insertVertex(E vertex){
		this.vertex.add(getNumOfVertex(),vertex);
	}
	
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2]=weight;
		numOfEdges++;
	}
	
	public void deleteEdge(int v1,int v2){
		edges[v1][v2]=0;
		numOfEdges--;
	}
	
	public int getFirstNeighbor(int index){
		for(int j=0;j<getNumOfEdges();j++){
			if(edges[index][j]>0){
				return j;
			}
		}
		return -1;
	}
	
	public int getNextNeighbor(int v1,int v2){
		//v1 的从 v2开始的下一个邻节点
		for(int j=v2+1;j<getNumOfVertex();j++){
			if(edges[v1][j]>0){
				return j;
			}
		}
		return -1;
	}

	public void depthFirstSearch(){
		int i=0;
		int NumVertex=getNumOfVertex();
		boolean[] isVisited=new boolean[NumVertex];
		while(i<NumVertex){
			isVisited[i]=false;
			i++;
		}
		for(i=0;i<NumVertex;i++){
			if(!isVisited[i]){
				depthFirstSearch(isVisited,i);
			}
		}
	}
	
	private void depthFirstSearch(boolean[] isVisited,int i){
		System.out.print(getValueByIndex(i)+"  ");
		isVisited[i]=true;
		int w=getFirstNeighbor(i);
		while(w!=-1){
			if(!isVisited[w]){
				depthFirstSearch(isVisited,w);
			}
			w=getNextNeighbor(i,w);
		}
	}
	
	public void broadFirstSearch() {
		int i=0;
		int NumVertex=getNumOfVertex();
		boolean[] isVisited=new boolean[NumVertex];
		while(i<NumVertex){
			isVisited[i]=false;
			i++;
		}
        for(i=0;i<getNumOfVertex();i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }
	
	private void broadFirstSearch(boolean[] isVisited,int i){
		int u,w;
		Queue<Integer> queue=new LinkedList<Integer>();
		System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.add(i);
        while(!queue.isEmpty()){
        	u=queue.remove();
        	w=getFirstNeighbor(u);
        	while(w!=-1){
        		if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.add(w);
            }
            //寻找下一个邻接结点
            w=getNextNeighbor(u, w);
        	}
        }
	}
	
	
}

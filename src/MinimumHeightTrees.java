import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class MinimumHeightTrees {
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			ArrayList<HashSet<Integer>> graph = new ArrayList<>();
			List<Integer> leaves = new ArrayList<Integer>();
			if(n <= 2){
				for(int i = 0 ; i < n ; i++)
					leaves.add(i);
				return leaves;
			}
			for(int i = 0 ; i < n ; i++)
				graph.add(new HashSet<Integer>());
			for(int i = 0 ; i < edges.length ; i++){
				int source = edges[i][0];
				int destination = edges[i][1];
				graph.get(source).add(destination);
				graph.get(destination).add(source);
			}
			for(int i = 0 ; i < n ; i++)
				if(graph.get(i).size() == 1)
					leaves.add(i);
			int m = n;
			
			while(n > 2){
				n -= leaves.size();
				List<Integer> temp = new ArrayList<Integer>();
				for(int leaf : leaves){
					// clear the edges of the leaf
					int j = graph.get(leaf).iterator().next();
					graph.get(j).remove(leaf);
					if(graph.get(j).size() == 1)
						temp.add(j);
					
				}
				leaves = temp;
			}
			return leaves;
	    }
	
	
	
	/*
	public void printArray(int[][] array){
		for(int i = 0 ; i < array.length ; i++){
			for(int j = 0 ; j < array[i].length ; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
	}
	*/
	
	public void printList(List<Integer> list){
		for(int number : list)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void main(String[] args){
		//n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
		MinimumHeightTrees obj = new MinimumHeightTrees();
		//int[][] array = {{0,3},{1,3},{2,3},{4,3},{5,4}}; 
		
		int[][] array = {{0,1},{0,2},{0,3},{3,4},{4,5}}; //obj.printArray(array);
		obj.printList(obj.findMinHeightTrees(6, array));
	}
	
}

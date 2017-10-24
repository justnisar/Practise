
public class MaxAreaOfIsland {	
	
	private int global;
	private int max;
	public MaxAreaOfIsland(){
		global = 0;
		max = 0;
	}
	
	public int numIslands(int[][] grid) {
        if(grid == null)
            return 0;
        int m = grid.length;
        int n = 0;
        if(m != 0)
        n = grid[0].length;
        if(m == 0 || n == 0)
            return 0;
        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                	global = 0;
                    DFS(i,j,m,n,visited,grid);
                    count++;
                    if(global > max)
                    	max = global;
                }           
            }
        }   
    return count;    
    }
	
	public void DFS(int x,int y,int m,int n,boolean visited[][],int grid[][]){
        visited[x][y] = true;
        global++;
        if(x+1 < m && !visited[x+1][y] && grid[x+1][y] == 1)
            DFS(x+1,y,m,n,visited,grid);
        if(y+1 < n && !visited[x][y+1] && grid[x][y+1] == 1)
            DFS(x,y+1,m,n,visited,grid);
        if(x-1 >= 0 && !visited[x-1][y] && grid[x-1][y] == 1)
            DFS(x-1,y,m,n,visited,grid);
        if(y-1 >= 0 && !visited[x][y-1] && grid[x][y-1] == 1)
            DFS(x,y-1,m,n,visited,grid);  
    }
	
	public int maxAreaOfIsland(int[][] grid) {
        numIslands(grid);
		return max;
    }
	
	public static void main(String[] args){
		/*
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(obj.numIslands(grid));
		System.out.println("Global : " + obj.global);
		System.out.println("Max : " + obj.max);
		*/
	}
	
}


public class IslandPerimeter {
  public int islandPerimeter(int[][] grid) {
   if(grid.length == 0)
     return 0;
   int result = 0;
   int rows = grid.length;//rows
   int columns = grid[0].length;//columns
   for(int i = 0 ; i < rows ; i++){
     for(int j = 0 ; j < columns ; j++){
       if(grid[i][j] == 1){
         
       
       if( i-1 < 0 || grid[i-1][j] != 1 )
         result++;
       if( i+1 > rows - 1 || grid[i+1][j] != 1 )
         result++;
       if( j-1 < 0 || grid[i][j-1] != 1 )
         result++;
       if( j+1 > columns - 1 || grid[i][j+1] != 1 )
         result++;
     }
     }
   }
   
    return result;
    
  }
}

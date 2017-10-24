
public class RotateImage {
  public void rotate(int[][] matrix) {
   
    // Transpose of a matrix
    int length = matrix.length;
    int[][] result = new int[length][length];
    for(int i = 0 ; i < length ; i++){
      for(int j = i + 1 ; j < length ; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    
    //Reverse each row in the current matrix
    for(int k = 0 ; k < length ; k++){
      int i = 0;
      int j = length - 1;
      while(i < j){
        int temp = matrix[k][i];
        matrix[k][i] = matrix[k][j];
        matrix[k][j] = temp;
        i++;
        j--;
      }
    }
    
    
  }
}

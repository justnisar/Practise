import java.util.HashSet;

class Pair{
  private int x;
  private int y;
  public Pair(int x,int y){
    this.x = x;
    this.y = y;
  }
}

public class Check {
  public static void main(){
    HashSet<Pair> hs = new HashSet<Pair>(); 
    hs.add(new Pair(1,2));
    hs.add(new Pair(2,3));
    hs.add(new Pair(1,2));
    System.out.println(hs.size()); 
  }
}

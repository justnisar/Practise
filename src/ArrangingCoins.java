
public class ArrangingCoins {
  public int arrangeCoins(int n) {
   int x = (int)Math.floor(Math.sqrt(2) * Math.sqrt(n));
   System.out.println("x = " + x);
   System.out.println("Expression : " + (x * (x+1))/2);
   if((x * (x+1))/2 > n)
     return x - 1;
   return x;
  }
  /*
  public static void main(String[] args){
    ArrangingCoins obj = new ArrangingCoins();
    obj.arrangeCoins(1804289383);
  }
  */
}

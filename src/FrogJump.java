import java.util.HashSet;

public class FrogJump {
  
  private HashSet<Integer> members;
  private int target;
  public FrogJump(){
    members = new HashSet<Integer>();
  }
  /*
  public boolean recfun(int[] stones,int start,int jump){
    if(start + jump == target || start + jump - 1 == target || start + jump + 1 == target)
      return true;
    if(members.contains(start + jump - 1) && recfun(stones,start + jump - 1,jump - 1))
      return true;
    if(members.contains(start + jump) && recfun(stones,start + jump,jump))
      return true;
    if(members.contains(start + jump + 1) && recfun(stones,start + jump + 1,jump + 1))
      return true;
    return false;
  }
  */
  
  private boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {
    if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
        return true;
    }
    if (hs.contains(pos + jump + 1) && canReach(hs, last, pos + jump + 1, jump + 1))
      return true;
    if (hs.contains(pos + jump) && canReach(hs, last, pos + jump, jump))
      return true;
    if (jump > 1 && hs.contains(pos + jump - 1))
      return true;
    return false;
}
  
  
  public boolean canCross(int[] stones) {
    int length = stones.length;
    if(length == 1)
      return true;
    if(stones[1] != 1)
      return false;
    target = stones[length - 1];
    for(int i = 0 ; i < length ; i++){
      if(i > 2 && stones[i] > stones[i-1] * 2)
        return false;
      members.add(stones[i]);
    }
    //return recfun(stones,1,1);
    return canReach(members,target,1,1);
  }
  
  public static void main(String[] args){
    FrogJump obj = new FrogJump();
    int[] array = {0,1,3,5,6,8,12,17};
    System.out.println(obj.canCross(array));
  }
  
  
}

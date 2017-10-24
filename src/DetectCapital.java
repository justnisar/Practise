
public class DetectCapital {
  
  public boolean isAllLower(String word){
    int length = word.length();   
    if(length == 0)
      return true;
    for(int i = 0 ; i < length ; i++){
      char ch = word.charAt(i);
      if(!(ch >= 'a' && ch <= 'z'))
        return false;
    }
    return true;
  }
  
  public boolean isAllUpper(String word){
    int length = word.length();
    if(length == 0)
      return true;
    for(int i = 0 ; i < length ; i++){
      char ch = word.charAt(i);
      if(!(ch >= 'A' && ch <= 'Z'))
        return false;
    }
    return true;
  }
  
  public boolean detectCapitalUse(String word) {
    return isAllUpper(word) || isAllLower(word) || ((word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') && isAllLower(word.substring(1)));
  }
  
  
  
}

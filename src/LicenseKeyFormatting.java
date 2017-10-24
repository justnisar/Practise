
public class LicenseKeyFormatting {
  
  
  public String licenseKeyFormatting(String S, int K) {
    S = S.replaceAll("-", "").toUpperCase();
    int length = S.length();
    StringBuffer result = new StringBuffer();
    int count = 0;
    for(int i = length - 1 ; i >= 0 ; i--){
      char ch = S.charAt(i);
      count++;
      result.insert(0, ch);
      if(count == K){
        result.insert(0,'-');
        count = 0;
      } 
    }
    return result.toString();
  }
}

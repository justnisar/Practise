import java.util.HashMap;
import java.util.Random;

public class Codec {
    
    // Database for holding tinyurls
    private HashMap<String,String> mapping;
    private Random rand;
    
    public Codec(){
      mapping = new HashMap<String,String>();
      rand = new Random();
    }
    
    // Randimizes a String of length 6
    public String randomize(){
      String charSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String result = "";
      for(int i = 0 ; i < 6 ; i++){
        char ch = charSet.charAt(rand.nextInt(charSet.length()));
        result += ch;
      }
      return result;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      String key = "";
      do{
        key = randomize();
      }while(mapping.containsKey(key));
      mapping.put(key,longUrl);
      return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(20);
        return mapping.get(key);
    }
    
}


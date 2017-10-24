
public class EditDistanceAscii {
	int editDistance(int start1,int end1,int start2,int end2,String s1,String s2){
		if(start1 > end1)
			return getAscii(s2,start2,end2);
		else if(start2 > end2)
			return getAscii(s1,start1,end1);
		else if(s1.charAt(start1) == s2.charAt(start2))
			return editDistance(start1+1,end1,start2+1,end2,s1,s2);
		else
			return Math.min(editDistance(start1+1,end1,start2,end2,s1,s2)+getAscii(s1,start1,start1),
				    editDistance(start1,end1,start2+1,end2,s1,s2)+getAscii(s2,start2,start2));
	}
	
	public int getAscii(String s, int start,int end){
		int result = 0;
		for(int i = start ; i <= end ;i++)
			result += s.charAt(i);
		return result;
	}
	
	
	public int minimumDeleteSum(String s1, String s2) {
        return editDistance(0, s1.length() - 1, 0 , s2.length() - 1,s1,s2);
    }
	
	public static void main(String[] args){
		String str1 = "delete";
		String str2 = "leet";
		EditDistanceAscii obj = new EditDistance();
		System.out.println(obj.minimumDeleteSum(str1, str2));
	}
}


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Time {
	int hours;
	int minutes;

	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
}

public class NextHighestTime {

	HashSet<List<Integer>> l;

	public NextHighestTime() {
		l = new HashSet<List<Integer>>();
	}

	public void recfun(int[] nums, int a, int b) {
		if (a == b) {
			List<Integer> ll = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++)
				ll.add(nums[i]);
			l.add(ll);
			return;
		}
		for (int i = a; i <= b; i++) {
			int t;
			t = nums[a];
			nums[a] = nums[i];
			nums[i] = t;
			recfun(nums, a + 1, b);
			t = nums[a];
			nums[a] = nums[i];
			nums[i] = t;
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		int n = nums.length;
		recfun(nums, 0, n - 1);
		List<List<Integer>> lll = new ArrayList<List<Integer>>(l);
		return lll;
	}

	public int getDifference(Time time1, Time time2) {

		return 0;
	}

	public boolean isTimeValid(String time){
		String[] time_arr = time.split(":");
		int hours = Integer.parseInt(time_arr[0]);
		int minutes = Integer.parseInt(time_arr[1]);
		return hours >= 0 && hours <= 23 && minutes >=0 && minutes <= 59;
	}

	public String nextClosestTime(String time) {
		/*
		String[] time_arr = time.split(":");
		int hours = Integer.parseInt(time_arr[0]);
		int minutes = Integer.parseInt(time_arr[1]);
		*/
		char[] digits = new char[4];
		int i = 0;
		for(char ch : time.toCharArray()){
			if(i != 2)
		}
		Time givenTime = new Time(hours, minutes);

		return null;
	}
}

package leetcode.weekcompetition.competition342;

public class Solution_1 {
	public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
		int totalTime = arrivalTime + delayedTime;
		int realtime;
		if (totalTime >= 24) {
			realtime = totalTime % 24;
		} else realtime = totalTime;
		System.out.println(realtime);
		return realtime;
	}
	
	public static void main(String[] args) {
		int arrivalTime = 13, delayedTime = 12;
		System.out.println(new Solution_1().findDelayedArrivalTime(arrivalTime, delayedTime));
		
	}
}

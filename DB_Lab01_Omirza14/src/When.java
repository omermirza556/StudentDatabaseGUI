/**
 * This class is an object to store when a class is, both in terms of days of
 * the week and in terms of time slots I used an array to store start and end
 * time
 * 
 * @author Omer Mirza
 *
 */
public class When {
	String days;
	String time;
	//String[] time = new String[2];

	public When(String days, String time) {
		this.days = days;
		this.time = time;
	}

	/*
	 * Getter and setter methods
	 */

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

//	public String[] getTime() {
//		return time;
//	}
//
//	public void setTime(String[] time) {
//		this.time = time;
//	}
//
//	public String getStart() {
//		return this.time[0];
//	}
//
//	public String getEnd() {
//		return this.time[1];
//	}

}

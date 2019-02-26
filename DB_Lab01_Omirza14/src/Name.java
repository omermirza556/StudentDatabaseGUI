/**
 * 
 * This class is used as an object to store parameters for a Name that a person
 * may have
 * 
 * @author Omer Mirza
 *
 */
public class Name {
	private String first, middle, last;

	/**
	 * This constructor takes into account students that have middle names
	 * 
	 * @param first  stands for first name
	 * @param middle stands for middle name
	 * @param last   stands for last name
	 */
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	/**
	 * This constructor takes into account that not all students have middle names
	 * 
	 * @param first stands for first name
	 * @param last  stands for last name
	 */
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
		this.middle = "";
	}

	/*
	 * The following methods are getters and setters for the name object
	 */

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

}

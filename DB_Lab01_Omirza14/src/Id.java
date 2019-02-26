
/**
 * This class is an object used to store a COURSES ID
 * 
 * I.e. its department and number
 * @author omer
 *
 */
public class Id {
	String dep;
	int num;
	
	/**
	 * This constructor uses a department and a course number
	 * @param dep
	 * @param num
	 */
	public Id(String dep, int num) {
		this.dep = dep;
		this.num = num;
	}
	
	/*
	 * getters and setters
	 */

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

}

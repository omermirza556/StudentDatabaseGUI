import java.util.ArrayList;

/**
 * This class is a student object. A student will have a unique ID (not to be
 * confused with the ID object), a name, classification and courses. It is a
 * subclass of person.
 * 
 * @author omer
 *
 */
public class Student {

	private int ID, box;
	private String email;
	private Name name;
	private Classification cla;
	private ArrayList<Course> studentCourses = new ArrayList<Course>();

	public Student(int ID, String email, Name name, Classification cla, int box) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.cla = cla;
		this.box = box;
	}

	/**
	 * This method adds a course to the students studentCourses array
	 * 
	 * @param course
	 *            is the course to be added
	 */
	public void AddAClass(Course course) {
		studentCourses.add(course);
		System.out.println("A course has been added.");
	}

	/*
	 * The following are generated getters and setters
	 */
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Classification getCla() {
		return cla;
	}

	public void setCla(Classification cla) {
		this.cla = cla;
	}

	public ArrayList<Course> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(ArrayList<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public int getBox() {
		return box;
	}

	public void setBox(int box) {
		this.box = box;
	}

	// @Override
	// public String toString() {
	// //return ID + " | " + name.getLast() + "," + name.getFirst() + "";
	// }

	@Override
	public String toString() {
		return name.getLast() + ", " + name.getFirst();
	}

}

import java.util.ArrayList;

/**
 * This is an object representation of a college course.
 * 
 * @author omer
 *
 */
public class Course {
	private Id ID;
	private String name, desc;
	private String prof;
	private When when;
	private int room, seats, seatsTaken;
	private ArrayList<Student> students = new ArrayList<Student>();

	public Course(Id ID, String name, String desc, When when, int room, int seats, String prof) {
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		this.when = when;
		this.room = room;
		this.seats = seats;
		this.prof = prof;

	}

	/**
	 * The following method adds a student to the class
	 * 
	 * @param stud
	 *            is the student to be added
	 * 
	 *            TODO Add a check to limit the amount of students
	 */
	public void addAStudent(Student stud) {

		students.add(stud);
		System.out.println("Student has been added to the course");
	}

	/*
	 *
	 * Generated getters and setters
	 */

	public Id getID() {
		return ID;
	}

	public void setID(Id iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public When getWhen() {
		return when;
	}

	public void setWhen(When when) {
		this.when = when;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public int getSeatsTaken() {
		return seatsTaken;
	}

	public void setSeatsTaken(int seatsTaken) {
		this.seatsTaken = seatsTaken;
	}

	@Override
	public String toString() {
		return name;
	}

}

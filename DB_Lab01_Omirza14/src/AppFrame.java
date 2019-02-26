import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.sql.*;

/**
 * This Class contains the main method, it creates the base frame for the entire
 * program. Based on buttons clicked it will create other options
 * 
 * @author omer
 *
 */
public class AppFrame {

	private JFrame frame;
	private JList<Student> lstStudent;
	private JList<Course> lstCourse;
	private JScrollPane scrlStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame window = new AppFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This method creates a connection to a database and then executes a query
	 * 
	 * @param query
	 */
	private void changeQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");
			System.out.println("....Connected");
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			stmt.close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	private ResultSet retrieveQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");
			System.out.println("....Connected");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// conn.close();
			return rs;
		} catch (SQLException e) {
			System.err.println("DATABASE CANT BE LOADED");
		}

		return null;

	}

	/**
	 * gets an arrayList of students
	 * 
	 * @return an arraylist of students
	 */
	private ArrayList<Student> getTheStudents() {
		ArrayList<Student> lstOfStudent = new ArrayList<Student>();
		String startingStudentSetQuery = "SELECT * FROM student";
		ResultSet rs = retrieveQuery(startingStudentSetQuery);
		try {

			while (rs.next()) {
				Name name = new Name(rs.getString("fname"), rs.getString("mname"), rs.getString("lname"));
				Classification clas;
				if (rs.getString("class").equals("freshman")) {
					clas = Classification.freshman;
				} else if (rs.getString("class").equals("sophomore")) {
					clas = Classification.sophomore;
				} else if (rs.getString("class").equals("junior")) {
					clas = Classification.junior;
				} else {
					clas = Classification.senior;
				}
				Student iter = new Student(rs.getInt("studid"), rs.getString("email"), name, clas, rs.getInt("box"));
				System.out.println(iter.toString());
				lstOfStudent.add(iter);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		return lstOfStudent;
	}

	/**
	 * this method returns a list of courses in our database
	 * 
	 * @return a list of courses in the system
	 * @throws SQLException
	 */
	private ArrayList<Course> getTheCourses() {
		ArrayList<Course> lstOfCourse = new ArrayList<Course>();
		String startingCourseSetQuery = "SELECT * FROM course";
		ResultSet rs = retrieveQuery(startingCourseSetQuery);
		try {
			while (rs.next()) {
				When when = new When(rs.getString("days"), rs.getString("time"));
				String idBlock[] = rs.getString("cid").split("-");

				String dept = idBlock[0];
				int deptno = Integer.parseInt(idBlock[1]);
				Course iter = new Course(new Id(dept, deptno), rs.getString("name"), rs.getString("description"), when,
						rs.getInt("room"), rs.getInt("spots"), rs.getString("prof"));
				lstOfCourse.add(iter);

			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lstOfCourse;
	}

	/**
	 * returns a default list model of all current students in the database
	 * 
	 * @return
	 */
	private DefaultListModel<Student> getStudentsDefaultListModel() {
		DefaultListModel<Student> dl = new DefaultListModel<Student>();
		for (Student iter : getTheStudents()) {
			dl.addElement(iter);
		}

		return dl;
	}

	/**
	 * returns a defualt list model of all current courses in the database
	 * 
	 * @return
	 */
	private DefaultListModel<Course> getCourseDefualtListModel() {
		DefaultListModel<Course> dl = new DefaultListModel<Course>();
		for (Course iter : getTheCourses()) {
			dl.addElement(iter);
		}

		return dl;

	}

	/**
	 * Create the application.
	 */
	public AppFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// connectToDataBase();
		ArrayList<Course> lstOfCourse = new ArrayList<Course>();
		// StudentConfirmFrame s = new StudentConfirmFrame();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel studentTab = new JPanel();
		tabbedPane.addTab("Students", studentTab);
		GridBagLayout gbl_studentTab = new GridBagLayout();
		gbl_studentTab.columnWidths = new int[] { 310, 10, 0 };
		gbl_studentTab.rowHeights = new int[] { 10, 0 };
		gbl_studentTab.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_studentTab.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		studentTab.setLayout(gbl_studentTab);

		JPanel studentDisplayPanel = new JPanel();
		GridBagConstraints gbc_studentDisplayPanel = new GridBagConstraints();
		gbc_studentDisplayPanel.insets = new Insets(0, 0, 0, 5);
		gbc_studentDisplayPanel.fill = GridBagConstraints.BOTH;
		gbc_studentDisplayPanel.gridx = 0;
		gbc_studentDisplayPanel.gridy = 0;
		studentTab.add(studentDisplayPanel, gbc_studentDisplayPanel);
		studentDisplayPanel.setLayout(new BorderLayout(0, 0));
		lstStudent = new JList<Student>(getStudentsDefaultListModel());
		scrlStudent = new JScrollPane(lstStudent);

		// for(Student iter : lstOfStudent) {
		// lstStudent.add(iter);
		// }

		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrlStudent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		studentDisplayPanel.add(scrlStudent, BorderLayout.CENTER);

		JPanel btnStudentPanel = new JPanel();
		GridBagConstraints gbc_btnStudentPanel = new GridBagConstraints();
		gbc_btnStudentPanel.fill = GridBagConstraints.BOTH;
		gbc_btnStudentPanel.gridx = 1;
		gbc_btnStudentPanel.gridy = 0;
		studentTab.add(btnStudentPanel, gbc_btnStudentPanel);
		GridBagLayout gbl_btnStudentPanel = new GridBagLayout();
		gbl_btnStudentPanel.columnWidths = new int[] { 0, 0 };
		gbl_btnStudentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_btnStudentPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_btnStudentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		btnStudentPanel.setLayout(gbl_btnStudentPanel);

		/*
		 * When the user selects the add student button it will open a window to prompt
		 * the user for a unique student ID
		 */
		JButton btnStudAdd = new JButton("Add");
		/*
		 * This action creates an instance of a unique ID frame and hides the main frame
		 */
		btnStudAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StudentConfirmFrame confirmF = new StudentConfirmFrame();
				confirmF.setVisible(true);
				/*
				 * This action checks for an action with the OK button on the confirm frame,
				 * asserts the ID is unique and creates a new student name frame
				 */
				confirmF.btnOk.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean isUnique = true;

						if (!(confirmF.textFieldID.getText().equals("") && isUnique)) {
							int iD = Integer.valueOf(confirmF.textFieldID.getText());

							NewStudentNameFrame newStudent = new NewStudentNameFrame();
							confirmF.dispose();
							newStudent.setVisible(true);

							/*
							 * this frame will dispose of the new student frame and go back to the original
							 * frame
							 */

							newStudent.btnCancel.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									newStudent.dispose();
									frame.setVisible(true);
								}
							});
							/*
							 * 
							 * This action checks for a press of the ok button on the new student name frame
							 * and goes to the next window, an attribute frame
							 */
							newStudent.btnOk.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if (!(newStudent.textFieldFirst.getText().equals(""))
											&& !(newStudent.textFieldLast.getText().equals(""))) {

										Name name;

										if (!(newStudent.textFieldMiddle.getText().equals(""))) {
											name = new Name(newStudent.textFieldFirst.getText(),
													newStudent.textFieldMiddle.getText(),
													newStudent.textFieldLast.getText());
											System.out.println(name.getFirst() + name.getLast() + name.getMiddle());
										} else {
											name = new Name(newStudent.textFieldFirst.getText(),
													newStudent.textFieldLast.getText());
											System.out.println(name.getFirst() + name.getLast() + name.getMiddle());
										}

										NewStudentAttributeFrame studentAt = new NewStudentAttributeFrame();
										studentAt.setVisible(true);
										newStudent.dispose();
										/*
										 * this button will dispose of the attribute frame and will reopen the original
										 * frame
										 */

										studentAt.btnCancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentAt.dispose();
												frame.setVisible(true);
											}
										});

										/*
										 * this button will open an add class frame for that student
										 */

										studentAt.btnOk.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {

												if (!(studentAt.textFieldBox.getText().equals(""))
														&& !(studentAt.textFieldEmail.getText().equals(""))
														&& studentAt.getClassification() != null) {

													int box = Integer.valueOf(studentAt.textFieldBox.getText());
													String email = studentAt.textFieldEmail.getText();
													Classification cla = studentAt.getClassification();
													System.out.println(name.getFirst());
													// Student theStudent = new Student(iD, email, name, cla, box);

													System.out.println(cla.toString());

													studentAt.dispose();
													addClassToStudentFrame addClass = new addClassToStudentFrame();

													DefaultListModel<Course> listModel = new DefaultListModel<Course>();

													addClass.list.setModel(listModel);

													addClass.repaint();

													addClass.setVisible(true);

													/*
													 * This button will add the class to the created student
													 */
													addClass.btnAdd.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {

															// TODO: create an SQL QUERY for a new element in ENROLLS
															// theStudent.AddAClass(lstOfCourse(addClass.list.getSelectedIndex()));;
														}
													});

													/*
													 * This button will cancel this process and go back to the original
													 * frame
													 */
													addClass.btnCancel.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															addClass.dispose();
															frame.setVisible(true);
														}
													});

													/*
													 * This button will add the completed student to the list and go
													 * back to the original frame
													 */

													addClass.btnFinish.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															addClass.dispose();

															String createAStudent = "INSERT INTO STUDENT (studid,email,box,fname,mname,lname,class) VALUES ("
																	+ iD + ", '" + email + "'," + box + ", '"
																	+ name.getFirst() + "' , '" + name.getMiddle()
																	+ "' , '" + name.getLast() + "' , '"
																	+ cla.toString() + "' );";

															changeQuery(createAStudent);

															/*
															 * THIS PART WILL UPDATE THE MODEL FOER THE LOVE OF GOD YOU
															 * NEED TO REMEMBER THIS
															 */
															lstStudent.setModel(getStudentsDefaultListModel());

															frame.repaint();
															frame.setVisible(true);
														}
													});

												}

											}
										});
									}

								}

							});
						}

					}
				});
				/*
				 * This will go back to the original frame and get rid of the current one
				 */
				confirmF.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmF.dispose();
						frame.setVisible(true);

					}
				});
			}
		});

		GridBagConstraints gbc_btnStudAdd = new GridBagConstraints();
		gbc_btnStudAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnStudAdd.gridx = 0;
		gbc_btnStudAdd.gridy = 0;
		btnStudentPanel.add(btnStudAdd, gbc_btnStudAdd);

		/*
		 * 
		 * The delete button will prompt a confirmation window to make sure the user is
		 * sure they want to delete a student
		 */
		JButton btnStudDelete = new JButton("Delete");
		btnStudDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				OkFrame ok = new OkFrame();
				ok.setVisible(true);
				/*
				 * This will prompt the user if they are sure they want to quit
				 * 
				 */
				ok.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok.dispose();
						frame.setVisible(true);
					}
				});
				/*
				 * This will confrim the user will delete the student
				 */
				ok.btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok.dispose();
						frame.setVisible(true);
						/*
						 * THIS BEAUTIFUL PIECE OF CODE DELETES STUDENTS
						 */
						String deleteQuery = "DELETE FROM student WHERE studid = "
								+ getTheStudents().get(lstStudent.getSelectedIndex()).getID() + ";";
						System.out.println(deleteQuery);
						changeQuery(deleteQuery);
						lstStudent.setModel(getStudentsDefaultListModel());

					}
				});

			}
		});

		GridBagConstraints gbc_btnStudDelete = new GridBagConstraints();
		gbc_btnStudDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnStudDelete.gridx = 0;
		gbc_btnStudDelete.gridy = 1;
		btnStudentPanel.add(btnStudDelete, gbc_btnStudDelete);

		/*
		 * This button will open editing windows
		 */
		JButton btnStudEdit = new JButton("Edit");
		btnStudEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Student temp = getTheStudents().get(lstStudent.getSelectedIndex());
				// Student temp = lstOfStudent.get(lstStudent.getSelectedIndex());
				frame.setVisible(false);
				StudentConfirmFrame confirmF = new StudentConfirmFrame();
				confirmF.textFieldID.setText(String.valueOf(temp.getID()));
				confirmF.setVisible(true);

				/*
				 * This action checks for an action with the OK button on the confirm frame,
				 * asserts the ID is unique and creates a new student name frame
				 */
				confirmF.btnOk.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						boolean isUnique = true;
						for (int i = 0; i < getTheStudents().size(); i++) {
							if (Integer.valueOf(confirmF.textFieldID.getText()) == getTheStudents().get(i).getID()) {
								isUnique = false;
							}

						}

						if (!(confirmF.textFieldID.getText().equals("") && isUnique)) {
							NewStudentNameFrame newStudent = new NewStudentNameFrame();
							newStudent.textFieldFirst.setText(temp.getName().getFirst());
							newStudent.textFieldMiddle.setText(temp.getName().getMiddle());
							newStudent.textFieldLast.setText(temp.getName().getLast());
							confirmF.dispose();
							newStudent.repaint();
							newStudent.setVisible(true);

							/*
							 * this frame will dispose of the new student frame and go back to the original
							 * frame
							 */

							newStudent.btnCancel.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									newStudent.dispose();
									frame.setVisible(true);
								}
							});
							/*
							 * 
							 * This action checks for a press of the ok button on the new student name frame
							 * and goes to the next window, an attribute frame
							 */
							newStudent.btnOk.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									NewStudentAttributeFrame studentAt = new NewStudentAttributeFrame();
									studentAt.textFieldBox.setText(String.valueOf(temp.getBox()));
									studentAt.textFieldEmail.setText(temp.getEmail());
									if (temp.getCla() == Classification.freshman) {
										studentAt.rdbtnFreshman.setSelected(true);
									} else if (temp.getCla() == Classification.sophomore) {
										studentAt.rdbtnSophomore.setSelected(true);
									} else if (temp.getCla() == Classification.junior) {
										studentAt.rdbtnJunior.setSelected(true);
									} else {
										studentAt.rdbtnSenior.setSelected(true);
									}

									if (!(newStudent.textFieldFirst.getText().equals(""))
											&& !(newStudent.textFieldLast.getText().equals(""))) {

										Name name;

										if (!(newStudent.textFieldMiddle.getText().equals(""))) {
											name = new Name(newStudent.textFieldFirst.getText(),
													newStudent.textFieldMiddle.getText(),
													newStudent.textFieldLast.getText());
											System.out.println(name.getFirst() + name.getLast() + name.getMiddle());
										} else {
											name = new Name(newStudent.textFieldFirst.getText(),
													newStudent.textFieldLast.getText());
											System.out.println(name.getFirst() + name.getLast() + name.getMiddle());
										}

										studentAt.repaint();

										studentAt.setVisible(true);
										newStudent.dispose();
										/*
										 * this button will dispose of the attribute frame and will reopen the original
										 * frame
										 */

										studentAt.btnCancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentAt.dispose();
												frame.setVisible(true);
											}
										});

										/*
										 * this button will open an add class frame for that student
										 */

										studentAt.btnOk.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												studentAt.textFieldBox.setText(String.valueOf(temp.getBox()));
												studentAt.textFieldEmail.setText(temp.getEmail());
												if (!(studentAt.textFieldBox.getText().equals(""))
														&& !(studentAt.textFieldEmail.getText().equals(""))
														&& studentAt.getClassification() != null) {
													String email = studentAt.textFieldEmail.getText();
													int box = Integer.valueOf(studentAt.textFieldBox.getText());
													Classification cla = studentAt.getClassification();

													studentAt.dispose();
													addClassToStudentFrame addClass = new addClassToStudentFrame();
													addClass.list.setModel(getCourseDefualtListModel());
													addClass.repaint();
													addClass.setVisible(true);

													/*
													 * This button will add the class to the created student
													 */
													addClass.btnAdd.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {

															// addClass.list.getModel().

															// System.out.print(s);

															System.out.print(getTheCourses()
																	.get(addClass.list.getSelectedIndex()).getID());

															int studid = getTheStudents()
																	.get(lstStudent.getSelectedIndex()).getID();

															String cid = getTheCourses()
																	.get(addClass.list.getSelectedIndex()).getID().dep
																	+ "-"
																	+ getTheCourses()
																			.get(addClass.list.getSelectedIndex())
																			.getID().num;

															System.out.println(studid + " | " + cid);

															String enrollsQuery = "INSERT INTO ENROLL (cid,studid) VALUES ('"
																	+ cid + "'," + studid + ");";

															// System.out.println(enrollsQuery);
															changeQuery(enrollsQuery);

															// TODO: this is where the backend comes in YOU WILL HAVE AN
															// INSERT STATEMENT IN HERE
														}
													});

													/*
													 * This button will cancel this process and go back to the original
													 * frame
													 */
													addClass.btnCancel.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															addClass.dispose();
															frame.setVisible(true);
														}
													});

													/*
													 * This button will add the completed student to the list and go
													 * back to the original frame
													 */

													addClass.btnFinish.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															addClass.dispose();

															/*
															 * THIS FINE PIECE OF CODE UPDATES THE STUDENT IN THE
															 * DATABASE
															 */
															String updateQuery = "UPDATE STUDENT SET email = '" + email
																	+ "' , fname = '" + name.getFirst() + "', mname = '"
																	+ name.getMiddle() + "' , lname = '"
																	+ name.getLast() + "', class = '" + cla.toString()
																	+ "', box = " + box + " WHERE studid = "
																	+ temp.getID() + ";";
															changeQuery(updateQuery);
															lstStudent.setModel(getStudentsDefaultListModel());
															frame.repaint();
															frame.setVisible(true);
														}
													});

												}
											}
										});
									}
								}
							});
						}
					}
				});

				/*
				 * This will go back to the original frame and get rid of the current one
				 */
				confirmF.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmF.dispose();
						frame.setVisible(true);

					}
				});
				System.out.println("What am I doing");

			}
		});
		GridBagConstraints gbc_btnStudEdit = new GridBagConstraints();
		gbc_btnStudEdit.gridx = 0;
		gbc_btnStudEdit.gridy = 2;
		btnStudentPanel.add(btnStudEdit, gbc_btnStudEdit);
		JPanel courseTab = new JPanel();
		tabbedPane.addTab("Courses", courseTab);
		GridBagLayout gbl_courseTab = new GridBagLayout();
		gbl_courseTab.columnWidths = new int[] { 310, 0, 0 };
		gbl_courseTab.rowHeights = new int[] { 0, 0 };
		gbl_courseTab.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_courseTab.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		courseTab.setLayout(gbl_courseTab);

		JPanel courseDisplayPanel = new JPanel();
		GridBagConstraints gbc_courseDisplayPanel = new GridBagConstraints();
		gbc_courseDisplayPanel.insets = new Insets(0, 0, 0, 5);
		gbc_courseDisplayPanel.fill = GridBagConstraints.BOTH;
		gbc_courseDisplayPanel.gridx = 0;
		gbc_courseDisplayPanel.gridy = 0;
		courseTab.add(courseDisplayPanel, gbc_courseDisplayPanel);
		courseDisplayPanel.setLayout(new BorderLayout(0, 0));

		lstCourse = new JList<Course>(getCourseDefualtListModel());

		JScrollPane scrlCourse = new JScrollPane(lstCourse);
		scrlCourse.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		courseDisplayPanel.add(scrlCourse, BorderLayout.CENTER);

		JPanel btnCoursePanel = new JPanel();
		GridBagConstraints gbc_btnCoursePanel = new GridBagConstraints();
		gbc_btnCoursePanel.fill = GridBagConstraints.BOTH;
		gbc_btnCoursePanel.gridx = 1;
		gbc_btnCoursePanel.gridy = 0;
		courseTab.add(btnCoursePanel, gbc_btnCoursePanel);
		GridBagLayout gbl_btnCoursePanel = new GridBagLayout();
		gbl_btnCoursePanel.columnWidths = new int[] { 0, 0 };
		gbl_btnCoursePanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_btnCoursePanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_btnCoursePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		btnCoursePanel.setLayout(gbl_btnCoursePanel);

		JButton btnCourseAdd = new JButton("Add");

		/*
		 * Opens course editor
		 */
		btnCourseAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseFrame cF = new CourseFrame();
				cF.setVisible(true);
				frame.setVisible(false);
				/*
				 * Ok button opens the next frame
				 */
				cF.btnOk.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (!(cF.textFieldCourseDep.getText().equals(""))
								&& !(cF.textFieldCourseNumber.getText().equals(""))
								&& !(cF.textFieldName.getText().equals("")) && !(cF.textFieldRoom.getText().equals(""))
								&& !(cF.textFieldSeats.getText().equals(""))) {
							String department = cF.textFieldCourseDep.getText();
							int num = Integer.valueOf(cF.textFieldCourseNumber.getText());
							String courseName = cF.textFieldName.getText();
							int roomNum = Integer.valueOf(cF.textFieldRoom.getText());
							int seats = Integer.valueOf(cF.textFieldSeats.getText());
							String prof = cF.textFieldProfessor.getText();

							cF.dispose();
							DescriptionFrame dF = new DescriptionFrame();
							dF.setVisible(true);

							/*
							 * Pressing ok will open the course frequency frame
							 */
							dF.btnOk.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if (!(dF.textFieldDescription.getText().equals(""))) {
										String desc = dF.textFieldDescription.getText();
										dF.dispose();
										CourseFreqFrame cFF = new CourseFreqFrame();
										cFF.setVisible(true);
										/*
										 * Cancels operation and goes back to the original frame
										 */
										cFF.btnCancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												cFF.dispose();
												frame.setVisible(true);
											}
										});
										/*
										 * Adds course to the arraylist
										 */
										cFF.btnFinish.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												if (!(cFF.dayString().equals("")
														&& !(cFF.textFieldEnd.getText().equals(""))
														&& !(cFF.textFieldStart.getText().equals("")))) {
													cFF.dispose();
													for (String st : cFF.dayString().split("")) {
														System.out.println(st);
													}

													When when = new When(cFF.dayString(), cFF.textFieldStart.getText()
															+ "-" + cFF.textFieldEnd.getText());

													Course newCourse = new Course(new Id(department, num), courseName,
															desc, when, roomNum, seats, prof);
													// String cid = cFF.dayString() +"|" + when.time;
													String cid = newCourse.getID().dep + "-" + newCourse.getID().num;
													String days = newCourse.getWhen().days;
													int seats = newCourse.getSeats();
													String time = newCourse.getWhen().time;
													String name = newCourse.getName();
													String desc = newCourse.getDesc();
													String prof = newCourse.getProf();
													int room = newCourse.getRoom();

													String createCourseQuery = "INSERT INTO course (cid,days,spots,spotsTaken,time,name,description,prof,room) VALUES ('"
															+ cid + "', '" + days + "', " + seats + "," + 0 + ", '"
															+ time + "','" + name + "', '" + desc + "', '" + prof + "',"
															+ room + ")";

													changeQuery(createCourseQuery);

													lstCourse.setModel(getCourseDefualtListModel());

												}

												frame.repaint();
												frame.setVisible(true);
											}
										});
									}

								}
							});
							/*
							 * Cancels operation and goes back to the original frame
							 */
							dF.btnCancel.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									dF.dispose();
									frame.setVisible(true);
								}
							});
						}
					}

				});
				/*
				 * Cancels operation and goes back to the original frame
				 */
				cF.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cF.dispose();
						frame.setVisible(true);
					}
				});

			}
		});
		GridBagConstraints gbc_btnCourseAdd = new GridBagConstraints();
		gbc_btnCourseAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnCourseAdd.gridx = 0;
		gbc_btnCourseAdd.gridy = 0;
		btnCoursePanel.add(btnCourseAdd, gbc_btnCourseAdd);

		JButton btnCourseDelete = new JButton("Delete");
		btnCourseDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				OkFrame ok = new OkFrame();
				ok.setVisible(true);
				/*
				 * This button will cancel the selected action
				 */
				ok.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok.dispose();
						frame.setVisible(true);
					}
				});
				/*
				 * This button will confirm the deletetion of the course
				 */
				ok.btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						String deleteQuery = "DELETE FROM course WHERE cid = '"
								+ getTheCourses().get(lstCourse.getSelectedIndex()).getID().getDep() + "-"
								+ getTheCourses().get(lstCourse.getSelectedIndex()).getID().getNum() + "';";

						changeQuery(deleteQuery);

						lstCourse.setModel(getCourseDefualtListModel());
						ok.dispose();
					}
				});

			}
		});
		GridBagConstraints gbc_btnCourseDelete = new GridBagConstraints();
		gbc_btnCourseDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnCourseDelete.gridx = 0;
		gbc_btnCourseDelete.gridy = 1;
		btnCoursePanel.add(btnCourseDelete, gbc_btnCourseDelete);

		JButton btnCourseEdit = new JButton("Edit");
		btnCourseEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course temp = getTheCourses().get(lstCourse.getSelectedIndex());
				System.out.print(temp.toString());

				CourseFrame cF = new CourseFrame();
				cF.textFieldCourseDep.setText(temp.getID().getDep());
				cF.textFieldCourseNumber.setText("" + temp.getID().getNum());
				cF.textFieldName.setText(temp.getName());
				cF.textFieldProfessor.setText(temp.getProf());
				cF.textFieldRoom.setText("" + temp.getRoom());
				cF.textFieldSeats.setText("" + temp.getSeats());
				cF.setVisible(true);
				frame.setVisible(false);

				/*
				 * Ok button opens the next frame
				 */

				cF.btnOk.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						if (!(cF.textFieldCourseDep.getText().equals(""))
								&& !(cF.textFieldCourseNumber.getText().equals(""))
								&& !(cF.textFieldName.getText().equals("")) && !(cF.textFieldRoom.getText().equals(""))
								&& !(cF.textFieldSeats.getText().equals(""))) {
							String department = cF.textFieldCourseDep.getText();
							int num = Integer.valueOf(cF.textFieldCourseNumber.getText());
							String courseName = cF.textFieldName.getText();
							int roomNum = Integer.valueOf(cF.textFieldRoom.getText());
							int seats = Integer.valueOf(cF.textFieldSeats.getText());
							String prof = cF.textFieldProfessor.getText();

							cF.dispose();
							DescriptionFrame dF = new DescriptionFrame();
							dF.getTextFieldDescription().setText(temp.getDesc());
							dF.setVisible(true);

							/*
							 * Pressing ok will open the course frequency frame
							 */
							dF.btnOk.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if (!(dF.textFieldDescription.getText().equals(""))) {
										String desc = dF.textFieldDescription.getText();
										dF.dispose();
										CourseFreqFrame cFF = new CourseFreqFrame();

										String days[] = temp.getWhen().getDays().split("-");

										for (String day : days) {
											System.out.println(day);
											if (day.equalsIgnoreCase("M")) {
												cFF.chckbxMonday.setSelected(true);
												;
											}

											if (day.equalsIgnoreCase("T")) {
												cFF.chckbxTuesday.setSelected(true);
											}

											if (day.equalsIgnoreCase("W")) {
												cFF.chckbxWednesday.setSelected(true);
											}

											if (day.equalsIgnoreCase("Th")) {
												cFF.chckbxThursday.setSelected(true);
											}

											if (day.equalsIgnoreCase("F")) {
												cFF.chckbxFriday.setSelected(true);
											}

										}

										String time[] = temp.getWhen().getTime().split("-");

										cFF.textFieldStart.setText(time[0]);
										cFF.textFieldEnd.setText(time[1]);

										cFF.setVisible(true);
										/*
										 * Cancels operation and goes back to the original frame
										 */
										cFF.btnCancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												cFF.dispose();
												frame.setVisible(true);
											}
										});
										/*
										 * edits course to the arraylist
										 */
										cFF.btnFinish.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												if (!(cFF.dayString().equals("")
														&& !(cFF.textFieldEnd.getText().equals(""))
														&& !(cFF.textFieldStart.getText().equals("")))) {
													cFF.dispose();
													for (String st : cFF.dayString().split("")) {
														System.out.println(st);
													}

													When when = new When(cFF.dayString(), cFF.textFieldStart.getText()
															+ "-" + cFF.textFieldEnd.getText());

													Course newCourse = new Course(new Id(department, num), courseName,
															desc, when, roomNum, seats, prof);
													// String cid = cFF.dayString() +"|" + when.time;
													String cid = newCourse.getID().dep + "-" + newCourse.getID().num;
													String days = newCourse.getWhen().days;
													int seats = newCourse.getSeats();
													String time = newCourse.getWhen().time;
													String name = newCourse.getName();
													String desc = newCourse.getDesc();
													String prof = newCourse.getProf();
													int room = newCourse.getRoom();

													String updateCourseQuery = "UPDATE COURSE SET days = '" + days
															+ "', spots = " + seats + ", time = '" + time
															+ "', name = '" + name + "', description = '" + desc
															+ "', prof = '" + prof + "', room = " + room + ";";

													changeQuery(updateCourseQuery);

													lstCourse.setModel(getCourseDefualtListModel());

												}

												frame.repaint();
												frame.setVisible(true);
											}
										});
									}

								}
							});
							/*
							 * Cancels operation and goes back to the original frame
							 */
							dF.btnCancel.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									dF.dispose();
									frame.setVisible(true);
								}
							});
						}
					}

				});
				/*
				 * Cancels operation and goes back to the original frame
				 */
				cF.btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cF.dispose();
						frame.setVisible(true);
					}
				});

			}
		});
		GridBagConstraints gbc_btnCourseEdit = new GridBagConstraints();
		gbc_btnCourseEdit.gridx = 0;
		gbc_btnCourseEdit.gridy = 2;
		btnCoursePanel.add(btnCourseEdit, gbc_btnCourseEdit);
		JPanel reportTab = new JPanel();
		tabbedPane.addTab("Reports", reportTab);
		reportTab.setLayout(new BorderLayout(0, 0));

		JPanel runReportPanel = new JPanel();
		reportTab.add(runReportPanel, BorderLayout.SOUTH);

		JButton btnReportButton = new JButton("Run Report");
		runReportPanel.add(btnReportButton);

		JPanel labelReportPanel = new JPanel();
		reportTab.add(labelReportPanel, BorderLayout.NORTH);
		labelReportPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblReport = new JLabel("Select Report");
		lblReport.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		labelReportPanel.add(lblReport, BorderLayout.NORTH);

		JPanel radioReportPanel = new JPanel();
		reportTab.add(radioReportPanel, BorderLayout.CENTER);
		GridBagLayout gbl_radioReportPanel = new GridBagLayout();
		gbl_radioReportPanel.columnWidths = new int[] { 442, 0 };
		gbl_radioReportPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_radioReportPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_radioReportPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		radioReportPanel.setLayout(gbl_radioReportPanel);

		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnStudentsInCourse = new JRadioButton("Students In Course Report");
		GridBagConstraints gbc_rdbtnStudentsInCourse = new GridBagConstraints();
		gbc_rdbtnStudentsInCourse.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnStudentsInCourse.gridx = 0;
		gbc_rdbtnStudentsInCourse.gridy = 0;
		radioReportPanel.add(rdbtnStudentsInCourse, gbc_rdbtnStudentsInCourse);

		JRadioButton rdbtnCoursesNotFull = new JRadioButton("Courses Not Full Report");
		GridBagConstraints gbc_rdbtnCoursesNotFull = new GridBagConstraints();
		gbc_rdbtnCoursesNotFull.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCoursesNotFull.gridx = 0;
		gbc_rdbtnCoursesNotFull.gridy = 1;
		radioReportPanel.add(rdbtnCoursesNotFull, gbc_rdbtnCoursesNotFull);

		JRadioButton rdbtnCourseForStudent = new JRadioButton("Courses For Student Report");
		GridBagConstraints gbc_rdbtnCourseForStudent = new GridBagConstraints();
		gbc_rdbtnCourseForStudent.gridx = 0;
		gbc_rdbtnCourseForStudent.gridy = 2;
		radioReportPanel.add(rdbtnCourseForStudent, gbc_rdbtnCourseForStudent);

		bg.add(rdbtnCourseForStudent);
		bg.add(rdbtnCoursesNotFull);
		bg.add(rdbtnStudentsInCourse);

		mainPanel.add(tabbedPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel, BorderLayout.NORTH);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 166, 117, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 29, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		/*
		 * This button will generate a report for the selected radio button
		 */
		btnReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportDisplayFrame report = new ReportDisplayFrame();

				report.textPane.setText("THIS IS SOMETHING ISN'T IT");

				if (rdbtnCourseForStudent.isSelected()) {
					report.textPane.setText("courses for students");
					int studid = getTheStudents().get(lstStudent.getSelectedIndex()).getID();
					String theString = "SELECT COURSE.name from student, enroll, course where student.studid = "
							+ studid + " AND student.studid = enroll.studid AND enroll.cid = course.cid";

					ResultSet rs = retrieveQuery(theString);

					String result = "";
					try {
						while (rs.next()) {
							if (result.equals("")) {
								result = result + rs.getString("name");
							} else {
								result = result + "," + rs.getString("name");
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					report.textPane.setText(result);

					// TODO course report
				}

				if (rdbtnCoursesNotFull.isSelected()) {
					// report.textPane.setText("courses not full");
					String theString = "SELECT COURSE.name from COURSE where course.spotstaken != course.spots";
					ResultSet rs = retrieveQuery(theString);
					String result = "";
					try {
						while (rs.next()) {
							if (result.equals("")) {
								result = result + rs.getString("name");
							} else {
								result = result + "," + rs.getString("name");
							}

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					report.textPane.setText(result);
					// TODO not full course report
				}

				if (rdbtnStudentsInCourse.isSelected()) {
					report.textPane.setText("students in this course");
					String cid = getTheCourses().get(lstCourse.getSelectedIndex()).getID().dep + "-"
							+ getTheCourses().get(lstCourse.getSelectedIndex()).getID().num;
					String theString = "SELECT STUDENT.lname, STUDENT.fname from student, enroll, course where course.cid = '" + cid
							+ "' AND student.studid = enroll.studid AND enroll.cid = course.cid";
					ResultSet rs = retrieveQuery(theString);
					String result = "";
					try {
						while (rs.next()) {
							if (result.equals("")) {
								result = result + rs.getString("fname") + " " + rs.getString("lname");
							} else {
								result = result + "," + rs.getString("fname ") + rs.getString("lname");
							}

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					report.textPane.setText(result);

					// TODO students in the course report
				}

				report.setVisible(true);
				frame.setVisible(false);
				/*
				 * this button will dismiss the message
				 */
				report.btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						report.dispose();
						frame.setVisible(true);

					}
				});
			}
		});

		JButton fileButton = new JButton("File");

		/*
		 * The following code allows the user to search their directory for a file to be
		 * inputed into the system
		 */
		fileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// JFileChooser fc = new JFileChooser();
				// if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// File file = fc.getSelectedFile();
				// }

				// try {
				// BufferedReader in = new BufferedReader(new FileReader("infilename"));
				// String str;
				// while((str = in.readLine()) !=null) {
				//
				// }
				//
				// }catch(IOException x) {
				// System.err.println("oh no");
				// }

			}
		});
		fileButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_fileButton = new GridBagConstraints();
		gbc_fileButton.insets = new Insets(0, 0, 0, 5);
		gbc_fileButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_fileButton.gridx = 0;
		gbc_fileButton.gridy = 0;
		buttonPanel.add(fileButton, gbc_fileButton);
	}

}

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
 * Allows the user to set the full name of a student
 * 
 * @author omer
 *
 */

public class NewStudentNameFrame extends JFrame {
	JTextField textFieldFirst;
	JTextField textFieldMiddle;
	JTextField textFieldLast;
	JButton btnOk, btnCancel;

	public NewStudentNameFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 300));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 0, 0 };
		gbl_mainPanel.rowHeights = new int[] { 217, 0, 0 };
		gbl_mainPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_mainPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		mainPanel.setLayout(gbl_mainPanel);

		JPanel AttributePanel = new JPanel();
		GridBagConstraints gbc_AttributePanel = new GridBagConstraints();
		gbc_AttributePanel.insets = new Insets(0, 0, 5, 0);
		gbc_AttributePanel.fill = GridBagConstraints.BOTH;
		gbc_AttributePanel.gridx = 0;
		gbc_AttributePanel.gridy = 0;
		mainPanel.add(AttributePanel, gbc_AttributePanel);
		GridBagLayout gbl_AttributePanel = new GridBagLayout();
		gbl_AttributePanel.columnWidths = new int[] { 0, 188, 0 };
		gbl_AttributePanel.rowHeights = new int[] { 0, 0 };
		gbl_AttributePanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_AttributePanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		AttributePanel.setLayout(gbl_AttributePanel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		AttributePanel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_2.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblFirstName, BorderLayout.CENTER);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblMiddleName, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_2.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblLastName, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		AttributePanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 0;
		panel_1.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		textFieldFirst = new JTextField();
		panel_10.add(textFieldFirst, BorderLayout.CENTER);
		textFieldFirst.setColumns(10);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_1.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		textFieldMiddle = new JTextField();
		panel_9.add(textFieldMiddle, BorderLayout.CENTER);
		textFieldMiddle.setColumns(10);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 2;
		panel_1.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		textFieldLast = new JTextField();
		panel_8.add(textFieldLast, BorderLayout.CENTER);
		textFieldLast.setColumns(10);

		JPanel ButtonPanel = new JPanel();
		GridBagConstraints gbc_ButtonPanel = new GridBagConstraints();
		gbc_ButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_ButtonPanel.gridx = 0;
		gbc_ButtonPanel.gridy = 1;
		mainPanel.add(ButtonPanel, gbc_ButtonPanel);
		GridBagLayout gbl_ButtonPanel = new GridBagLayout();
		gbl_ButtonPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_ButtonPanel.rowHeights = new int[] { 0, 0 };
		gbl_ButtonPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_ButtonPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		ButtonPanel.setLayout(gbl_ButtonPanel);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		ButtonPanel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		btnCancel = new JButton("Cancel");
		panel_4.add(btnCancel, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		ButtonPanel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		btnOk = new JButton("Ok");
		panel_3.add(btnOk, BorderLayout.CENTER);

		this.pack();

	}

	/*
	 * Generated getters and setters
	 * 
	 * @return
	 */

	public JTextField getTextFieldFirst() {
		return textFieldFirst;
	}

	public void setTextFieldFirst(JTextField textFieldFirst) {
		this.textFieldFirst = textFieldFirst;
	}

	public JTextField getTextFieldMiddle() {
		return textFieldMiddle;
	}

	public void setTextFieldMiddle(JTextField textFieldMiddle) {
		this.textFieldMiddle = textFieldMiddle;
	}

	public JTextField getTextFieldLast() {
		return textFieldLast;
	}

	public void setTextFieldLast(JTextField textFieldLast) {
		this.textFieldLast = textFieldLast;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

}

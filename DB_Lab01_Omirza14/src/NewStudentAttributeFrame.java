import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

/**
 * Allows the user to edit (or create) attributes of a student
 * 
 * @author omer
 *
 */
public class NewStudentAttributeFrame extends JFrame {
	JTextField textFieldEmail;
	JTextField textFieldBox;
	JButton btnOk, btnCancel;
	JRadioButton rdbtnSophomore, rdbtnFreshman, rdbtnJunior, rdbtnSenior;

	public NewStudentAttributeFrame() {

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

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblEmail, BorderLayout.CENTER);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblBox = new JLabel("Box");
		lblBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblBox, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_2.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblClassification = new JLabel("Classification");
		lblClassification.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblClassification, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		AttributePanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 94, 95, 0, 0 };
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

		textFieldEmail = new JTextField();
		panel_10.add(textFieldEmail, BorderLayout.CENTER);
		textFieldEmail.setColumns(10);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_1.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		textFieldBox = new JTextField();
		panel_9.add(textFieldBox, BorderLayout.CENTER);
		textFieldBox.setColumns(10);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 2;
		panel_1.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_8.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_8.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);
		ButtonGroup classGroup = new ButtonGroup();
		rdbtnFreshman = new JRadioButton("Freshman");
		GridBagConstraints gbc_rdbtnFreshman = new GridBagConstraints();
		gbc_rdbtnFreshman.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFreshman.gridx = 0;
		gbc_rdbtnFreshman.gridy = 0;
		panel_8.add(rdbtnFreshman, gbc_rdbtnFreshman);

		rdbtnSophomore = new JRadioButton("Sophomore");
		GridBagConstraints gbc_rdbtnSophomore = new GridBagConstraints();
		gbc_rdbtnSophomore.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSophomore.gridx = 1;
		gbc_rdbtnSophomore.gridy = 0;
		panel_8.add(rdbtnSophomore, gbc_rdbtnSophomore);

		rdbtnJunior = new JRadioButton("Junior");
		GridBagConstraints gbc_rdbtnJunior = new GridBagConstraints();
		gbc_rdbtnJunior.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnJunior.gridx = 0;
		gbc_rdbtnJunior.gridy = 1;
		panel_8.add(rdbtnJunior, gbc_rdbtnJunior);

		rdbtnSenior = new JRadioButton("Senior");
		GridBagConstraints gbc_rdbtnSenior = new GridBagConstraints();
		gbc_rdbtnSenior.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSenior.gridx = 1;
		gbc_rdbtnSenior.gridy = 1;
		panel_8.add(rdbtnSenior, gbc_rdbtnSenior);
		classGroup.add(rdbtnSenior);
		classGroup.add(rdbtnJunior);
		classGroup.add(rdbtnSophomore);
		classGroup.add(rdbtnFreshman);

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

	public Classification getClassification() {
		if (rdbtnFreshman.isSelected()) {
			return Classification.freshman;
		}

		if (rdbtnSophomore.isSelected()) {
			return Classification.sophomore;
		}
		if (rdbtnJunior.isSelected()) {
			return Classification.junior;
		}

		if (rdbtnSenior.isSelected()) {
			return Classification.senior;
		}

		return null;
	}

	/*
	 * Generated Getters and setters
	 */
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextField getTextFieldBox() {
		return textFieldBox;
	}

	public void setTextFieldBox(JTextField textFieldBox) {
		this.textFieldBox = textFieldBox;
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

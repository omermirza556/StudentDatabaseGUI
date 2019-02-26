import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * this class will be used to determine if the student ID is unique
 * 
 * @author omer
 *
 */
public class StudentConfirmFrame extends JFrame {
	JTextField textFieldID;
	public JButton btnCancel, btnOk;

	public StudentConfirmFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 100));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 56, 267, 0 };
		gbl_mainPanel.rowHeights = new int[] { 0, 0 };
		gbl_mainPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_mainPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		mainPanel.setLayout(gbl_mainPanel);

		JPanel panelLable = new JPanel();
		GridBagConstraints gbc_panelLable = new GridBagConstraints();
		gbc_panelLable.insets = new Insets(0, 0, 0, 5);
		gbc_panelLable.fill = GridBagConstraints.BOTH;
		gbc_panelLable.gridx = 0;
		gbc_panelLable.gridy = 0;
		mainPanel.add(panelLable, gbc_panelLable);
		panelLable.setLayout(new BorderLayout(0, 0));

		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		panelLable.add(lblStudentId, BorderLayout.CENTER);

		JPanel optionPanel = new JPanel();
		GridBagConstraints gbc_optionPanel = new GridBagConstraints();
		gbc_optionPanel.fill = GridBagConstraints.BOTH;
		gbc_optionPanel.gridx = 1;
		gbc_optionPanel.gridy = 0;
		mainPanel.add(optionPanel, gbc_optionPanel);
		GridBagLayout gbl_optionPanel = new GridBagLayout();
		gbl_optionPanel.columnWidths = new int[] { 0, 0 };
		gbl_optionPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_optionPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_optionPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		optionPanel.setLayout(gbl_optionPanel);

		JPanel textFieldPanel = new JPanel();
		GridBagConstraints gbc_textFieldPanel = new GridBagConstraints();
		gbc_textFieldPanel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPanel.fill = GridBagConstraints.BOTH;
		gbc_textFieldPanel.gridx = 0;
		gbc_textFieldPanel.gridy = 0;
		optionPanel.add(textFieldPanel, gbc_textFieldPanel);
		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.X_AXIS));

		textFieldID = new JTextField();
		textFieldPanel.add(textFieldID);
		textFieldID.setColumns(10);

		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		optionPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		JPanel panelCancel = new JPanel();
		GridBagConstraints gbc_panelCancel = new GridBagConstraints();
		gbc_panelCancel.insets = new Insets(0, 0, 0, 5);
		gbc_panelCancel.fill = GridBagConstraints.BOTH;
		gbc_panelCancel.gridx = 0;
		gbc_panelCancel.gridy = 0;
		buttonPanel.add(panelCancel, gbc_panelCancel);
		panelCancel.setLayout(new BorderLayout(0, 0));

		btnCancel = new JButton("Cancel");
		panelCancel.add(btnCancel, BorderLayout.CENTER);

		JPanel panelOk = new JPanel();
		GridBagConstraints gbc_panelOk = new GridBagConstraints();
		gbc_panelOk.fill = GridBagConstraints.BOTH;
		gbc_panelOk.gridx = 1;
		gbc_panelOk.gridy = 0;
		buttonPanel.add(panelOk, gbc_panelOk);
		panelOk.setLayout(new BorderLayout(0, 0));
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelOk.add(btnOk, BorderLayout.CENTER);
		this.pack();

	}

}

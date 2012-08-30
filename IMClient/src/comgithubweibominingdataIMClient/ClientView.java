package comgithubweibominingdataIMClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class ClientView extends JFrame {

	private JPanel contentPane;
	private JTextField textMsg;
	private JPanel panelStatus;
	private JComboBox comboBoxStatus;
	private JLabel lblUsrNam;
	private JLabel lblTopic;
	private JTextField textTopic;
	private JTextArea textMsgHistory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView frame = new ClientView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientView() {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("IM Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMsg = new JPanel();
		panelMsg.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelMsg, BorderLayout.SOUTH);
		GridBagLayout gbl_panelMsg = new GridBagLayout();
		gbl_panelMsg.columnWidths = new int[]{84, 134, 132, 0, 0};
		gbl_panelMsg.rowHeights = new int[]{29, 0};
		gbl_panelMsg.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMsg.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelMsg.setLayout(gbl_panelMsg);
		
		textMsg = new JTextField();
		GridBagConstraints gbc_textMsg = new GridBagConstraints();
		gbc_textMsg.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMsg.gridwidth = 3;
		gbc_textMsg.anchor = GridBagConstraints.NORTH;
		gbc_textMsg.insets = new Insets(0, 0, 0, 5);
		gbc_textMsg.gridx = 0;
		gbc_textMsg.gridy = 0;
		panelMsg.add(textMsg, gbc_textMsg);
		textMsg.setColumns(10);
		
		JButton btnSndMsg = new JButton("Send Message");
		GridBagConstraints gbc_btnSndMsg = new GridBagConstraints();
		gbc_btnSndMsg.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSndMsg.gridx = 3;
		gbc_btnSndMsg.gridy = 0;
		panelMsg.add(btnSndMsg, gbc_btnSndMsg);
		
		panelStatus = new JPanel();
		panelStatus.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelStatus, BorderLayout.NORTH);
		GridBagLayout gbl_panelStatus = new GridBagLayout();
		gbl_panelStatus.columnWidths = new int[]{74, 1, 113, 35, 134, 0};
		gbl_panelStatus.rowHeights = new int[]{28, 0};
		gbl_panelStatus.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelStatus.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelStatus.setLayout(gbl_panelStatus);
		
		lblUsrNam = new JLabel("");
		GridBagConstraints gbc_lblUsrNam = new GridBagConstraints();
		gbc_lblUsrNam.anchor = GridBagConstraints.WEST;
		gbc_lblUsrNam.insets = new Insets(0, 0, 0, 5);
		gbc_lblUsrNam.gridx = 1;
		gbc_lblUsrNam.gridy = 0;
		panelStatus.add(lblUsrNam, gbc_lblUsrNam);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Available", "Busy", "Idle"}));
		GridBagConstraints gbc_comboBoxStatus = new GridBagConstraints();
		gbc_comboBoxStatus.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBoxStatus.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxStatus.gridx = 2;
		gbc_comboBoxStatus.gridy = 0;
		panelStatus.add(comboBoxStatus, gbc_comboBoxStatus);
		
		lblTopic = new JLabel("Topic");
		GridBagConstraints gbc_lblTopic = new GridBagConstraints();
		gbc_lblTopic.anchor = GridBagConstraints.WEST;
		gbc_lblTopic.insets = new Insets(0, 0, 0, 5);
		gbc_lblTopic.gridx = 3;
		gbc_lblTopic.gridy = 0;
		panelStatus.add(lblTopic, gbc_lblTopic);
		
		textTopic = new JTextField();
		GridBagConstraints gbc_textTopic = new GridBagConstraints();
		gbc_textTopic.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTopic.anchor = GridBagConstraints.NORTH;
		gbc_textTopic.gridx = 4;
		gbc_textTopic.gridy = 0;
		panelStatus.add(textTopic, gbc_textTopic);
		textTopic.setColumns(10);
		
		textMsgHistory = new JTextArea();
		textMsgHistory.setBackground(Color.WHITE);
		textMsgHistory.setEnabled(false);
		textMsgHistory.setEditable(false);
		textMsgHistory.setLineWrap(true);
		contentPane.add(textMsgHistory, BorderLayout.CENTER);
	}

}

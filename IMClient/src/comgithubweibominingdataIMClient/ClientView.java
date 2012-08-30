package comgithubweibominingdataIMClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.BoxLayout;


public class ClientView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMsg;
	private JPanel panelStatus;
	private JComboBox comboBoxStatus;
	private JLabel lblUsrNam;
	private JLabel lblTopic;
	private JTextField textTopic;
	private JPanel panelCollaborative;
	private JTextArea textStatus;
	private JTextArea textHistory;

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
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("IM Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMsg = new JPanel();
		panelMsg.setBackground(Color.WHITE);
		contentPane.add(panelMsg, BorderLayout.SOUTH);
		panelMsg.setLayout(new BoxLayout(panelMsg, BoxLayout.X_AXIS));
		
		textMsg = new JTextField();
		panelMsg.add(textMsg);
		textMsg.setColumns(10);
		
		JButton btnSndMsg = new JButton("Send Message");
		panelMsg.add(btnSndMsg);
		
		panelStatus = new JPanel();
		panelStatus.setBackground(Color.WHITE);
		contentPane.add(panelStatus, BorderLayout.NORTH);
		panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.X_AXIS));
		
		lblUsrNam = new JLabel("    ");
		panelStatus.add(lblUsrNam);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Available", "Busy", "Idle"}));
		panelStatus.add(comboBoxStatus);
		
		lblTopic = new JLabel("Topic");
		panelStatus.add(lblTopic);
		
		textTopic = new JTextField();
		lblTopic.setLabelFor(textTopic);
		panelStatus.add(textTopic);
		textTopic.setColumns(10);
		
		panelCollaborative = new JPanel();
		contentPane.add(panelCollaborative, BorderLayout.CENTER);
		panelCollaborative.setLayout(new BoxLayout(panelCollaborative, BoxLayout.LINE_AXIS));
		
		textStatus = new JTextArea();
		panelCollaborative.add(textStatus);
		textStatus.setColumns(10);
		
		textHistory = new JTextArea();
		panelCollaborative.add(textHistory);
	}

}

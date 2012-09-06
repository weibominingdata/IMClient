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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClientView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textMsg;
	protected JPanel panelStatus;
	protected JComboBox comboBoxStatus;
	protected JLabel lblUsrNam;
	protected JLabel lblTopic;
	protected JTextField textTopic;
	protected JPanel panelCollaborative;
	protected JTextArea textCollaborativeStatus;
	protected JPanel panelCollaborativeStatus;
	protected JTextArea textChattingHistory;
	protected JPanel panelChattingHistory;
	protected JScrollPane scrollPane;
	protected JScrollPane scrollPane_1;
	
	protected JPanel contentPane;
	
	protected ClientModel model;
	protected ClientControl control;
	

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
		textMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.newMsgHandler();
			}
		});
		textMsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				control.editingStatusChangeHandler(2);
				
			}
		});
		textMsg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				control.editingStatusChangeHandler(0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				control.editingStatusChangeHandler(1);
			}
		});
		textMsg.addInputMethodListener(new InputMethodListener() {
			public void inputMethodTextChanged(InputMethodEvent event) {
			}

			@Override
			public void caretPositionChanged(InputMethodEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panelMsg.add(textMsg);
		textMsg.setColumns(10);
		
		JButton btnSndMsg = new JButton("Send Message");
		btnSndMsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.newMsgHandler();
			}
		});
		panelMsg.add(btnSndMsg);
		
		panelStatus = new JPanel();
		panelStatus.setBackground(Color.WHITE);
		contentPane.add(panelStatus, BorderLayout.NORTH);
		panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.X_AXIS));
		
		lblUsrNam = new JLabel("    ");
		panelStatus.add(lblUsrNam);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.usrStatusChangeHandler();
			}
		});
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
		panelCollaborative.setLayout(null);
		
		panelCollaborativeStatus = new JPanel();
		panelCollaborativeStatus.setBackground(Color.WHITE);
		panelCollaborativeStatus.setBorder(new TitledBorder(null, "User Status", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelCollaborativeStatus.setBounds(0, 0, 180, 410);
		panelCollaborative.add(panelCollaborativeStatus);
		panelCollaborativeStatus.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 20, 170, 380);
		panelCollaborativeStatus.add(scrollPane_1);
		
		textCollaborativeStatus = new JTextArea();
		textCollaborativeStatus.setEditable(false);
		scrollPane_1.setViewportView(textCollaborativeStatus);
		
		panelChattingHistory = new JPanel();
		panelChattingHistory.setAutoscrolls(true);
		panelChattingHistory.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Chatting History", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChattingHistory.setBounds(185, 0, 255, 410);
		panelCollaborative.add(panelChattingHistory);
		panelChattingHistory.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 20, 240, 380);
		panelChattingHistory.add(scrollPane);
		
		textChattingHistory = new JTextArea();
		textChattingHistory.setEditable(false);
		scrollPane.setViewportView(textChattingHistory);
		textChattingHistory.setLineWrap(true);
	}
	
	
}
	

	
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
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;


public class ClientView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textMsg;
	private JPanel panelStatus;
	private JComboBox comboBoxStatus;
	private JLabel lblUsrNam;
	private JLabel lblTopic;
	private JTextField textTopic;
	private JPanel panelCollaborative;
	private JTextArea textCollaborativeStatus;
	private JPanel panelCollaborativeStatus;
	private JTextArea textChattingHistory;
	private JPanel panelChattingHistory;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	private EditingStatusTracker eTracker = new EditingStatusTracker();
	private JPanel contentPane;
	

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
		textMsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					
				}
				eTracker.setLastKeyTypedTime(new Date());
				updateUsrStatus();
				
			}
		});
		textMsg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				eTracker.setLastKeyTypedTime(new Date());
				updateUsrStatus();
			}
			@Override
			public void focusLost(FocusEvent e) {
				updateUsrStatus();

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
		
		initilize();
		
	}

	public EditingStatusTracker geteTracker() {
		return eTracker;
	}

	
	private void initilize() {
		textCollaborativeStatus.setText("Alice: " + eTracker.getEditingStatus(new Date(), textMsg.getText().length()) + "\n");
	}
	
	protected void updateUsrStatus() {
		checkSetEditingStatus();
	}
	
	protected void updateChattingHistory() {
		
	}
	
	protected void checkSetEditingStatus(){
        textCollaborativeStatus.setText("Alice: " + eTracker.getEditingStatus(new Date(), textMsg.getText().length()) + "\n");
	}
	
}
	

	
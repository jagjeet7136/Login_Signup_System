package loginUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ForgotPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel invalidOTP;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass frame = new ForgotPass(null, null);
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
	public ForgotPass(String otp, String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1320, 400, 335, 273);
		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.BOLD, 11));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(102, 204, 255), 2, true));
		textField.setBounds(97, 52, 113, 28);
		contentPane.add(textField);

		invalidOTP = new JLabel("");
		invalidOTP.setForeground(Color.RED);
		invalidOTP.setFont(new Font("SansSerif", Font.BOLD, 12));
		invalidOTP.setBounds(109, 80, 101, 14);
		contentPane.add(invalidOTP);

		JButton btnVerify = new JButton("verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String entered = textField.getText(); 
				if(entered.equals(otp)) {
					setVisible(false);
					new NewPass(username).setVisible(true);
				}
				else {
					invalidOTP.setText("Wrong OTP");
				}
			}
		});
		btnVerify.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnVerify.setBorder(new LineBorder(new Color(102, 204, 255), 2, true));
		btnVerify.setBackground(new Color(255, 255, 204));
		btnVerify.setBounds(109, 126, 89, 28);
		contentPane.add(btnVerify);


	}
}

package loginUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OTP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
					OTP frame = new OTP(null,null,null,null,null,null,null,null);
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
	public OTP(String otp, String fName, String lName, String userName, String Email, String Gender, String selectdate, String pass) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1320, 400, 335, 273);
		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		textField.setBounds(95, 40, 113, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel wrong = new JLabel("");
		wrong.setFont(new Font("SansSerif", Font.BOLD, 11));
		wrong.setForeground(Color.RED);
		wrong.setBackground(new Color(255, 255, 204));
		wrong.setBounds(126, 70, 82, 14);
		contentPane.add(wrong);

		JButton btnVerify = new JButton("verify");
		btnVerify.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entered = textField.getText();
				if(entered.equals(otp)) {
					try {
						Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
						PreparedStatement stmt;
						stmt = con.prepareStatement("insert into credentials(firstName, lastname, username, email, password, gender, dob)"
								+ " values(?,?,?,?,?,?,?)");
						stmt.setString(1,fName);
						stmt.setString(2,lName);
						stmt.setString(3,userName);
						stmt.setString(4,Email);
						stmt.setString(5,pass);
						stmt.setString(6,Gender);
						stmt.setString(7,selectdate);

						int ii = stmt.executeUpdate();
						System.out.println(ii);
						setVisible(false);
						new Signin().setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
				}
				else {
					wrong.setText("Wrong OTP");
				}

			}
		});
		btnVerify.setBorder(new LineBorder(new Color(255, 255, 204), 2, true));
		btnVerify.setBackground(new Color(255, 255, 204));
		btnVerify.setBounds(107, 114, 89, 28);
		contentPane.add(btnVerify);

	}
}

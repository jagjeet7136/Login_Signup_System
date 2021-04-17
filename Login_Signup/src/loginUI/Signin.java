package loginUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField emailTf;
	private JPasswordField passwordField;

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
					Signin frame = new Signin();
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
	public Signin() {

		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 200, 749, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 191, 565);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Signin.class.getResource("/images/icons8_atomic_bomb_80px_1.png")));
		lblNewLabel.setBounds(55, 221, 80, 92);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(191, 0, 542, 565);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panel_2.setBackground(new Color(255, 255, 204));
		panel_2.setBounds(82, 36, 365, 494);
		panel_1.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Sign in");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(32, 25, 278, 40);
		panel_2.add(lblNewLabel_1);

		JLabel email = new JLabel("Username");
		email.setForeground(Color.DARK_GRAY);
		email.setFont(new Font("SansSerif", Font.BOLD, 13));
		email.setBounds(70, 92, 91, 14);
		panel_2.add(email);

		JLabel wrongDetails = new JLabel("");
		wrongDetails.setForeground(Color.RED);
		wrongDetails.setFont(new Font("SansSerif", Font.BOLD, 11));
		wrongDetails.setBounds(61, 243, 236, 14);
		panel_2.add(wrongDetails);

		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = emailTf.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean bool = username.length()<=0;
				boolean booll = password.length()<=0;

				if(bool && booll) {
					wrongDetails.setText("Invalid credentials");
					return;
				}
				else {
					wrongDetails.setText("");
				}


				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

					PreparedStatement p = c.prepareStatement("select password from credentials where username = ?");

					ResultSet r = null;
					String s = null;
					try {
						p.setString(1, username);
						r = p.executeQuery();
						r.next();
						s = r.getString(1);
					} catch(SQLException ee) {
						wrongDetails.setText("Invalid credentials");
						return;
					}

					if(s.equals(password)) {
						setVisible(false);
						Home h = new Home(username);
						h.setVisible(true);
					}
					else {
						wrongDetails.setText("Invalid credentials");
						return;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}});
		enter.setPreferredSize(new Dimension(59, 50));
		enter.setFont(new Font("SansSerif", Font.BOLD, 13));
		enter.setBorder(new LineBorder(Color.WHITE, 2, true));
		enter.setBounds(208, 379, 89, 36);
		panel_2.add(enter);

		emailTf = new JTextField();
		emailTf.setHorizontalAlignment(SwingConstants.RIGHT);
		emailTf.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		emailTf.setColumns(10);
		emailTf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		emailTf.setBounds(61, 107, 236, 40);
		panel_2.add(emailTf);



		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblPassword.setBounds(70, 186, 65, 14);
		panel_2.add(lblPassword);

		JButton forgotPass = new JButton("Forgot Password?");
		forgotPass.setBackground(new Color(255, 255, 204));
		forgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String userName = emailTf.getText();
				if(userName.length()==0) {
					wrongDetails.setText("Invalid credentials");

					return;
				}
				else {
					try {
						wrongDetails.setText("");
						wrongDetails.setText("Please check your email");
						System.out.println(userName);
						Class.forName("com.mysql.jdbc.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

						PreparedStatement p = c.prepareStatement("select email from credentials where username=?");

						ResultSet r = null;
						String s = null;

						p.setString(1, userName);
						r = p.executeQuery();
						r.next();
						s = r.getString(1);

						String otp = EmailSending.sendMail(s);
						new ForgotPass(otp, userName).setVisible(true);
						emailTf.setText("");
						passwordField.setText("");
					} catch(Exception ee) {
						wrongDetails.setText("No account found");
					}
				}

			}
		});
		forgotPass.setPreferredSize(new Dimension(59, 50));
		forgotPass.setFont(new Font("SansSerif", Font.BOLD, 13));
		forgotPass.setBorder(new LineBorder(Color.WHITE, 2, true));
		forgotPass.setBounds(61, 279, 139, 36);
		panel_2.add(forgotPass);

		JButton loginInstead = new JButton("Signup instead");
		loginInstead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup s = new Signup();
				s.setVisible(true);
			}
		});
		loginInstead.setPreferredSize(new Dimension(59, 50));
		loginInstead.setFont(new Font("SansSerif", Font.BOLD, 13));
		loginInstead.setBorder(new LineBorder(Color.WHITE, 2, true));
		loginInstead.setBackground(new Color(255, 255, 204));
		loginInstead.setBounds(59, 379, 113, 36);
		panel_2.add(loginInstead);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(61, 201, 236, 40);
		panel_2.add(passwordField);


	}
}

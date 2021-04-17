package loginUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JPasswordField passwordField;
	private JPasswordField confirmPassword;
	private JTextField emailTf;

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
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 200, 749, 604);
		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(535, 0, 198, 565);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(61, 226, 84, 80);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/images/icons8_atomic_bomb_80px.png")));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		panel_2.setBounds(0, 0, 536, 565);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(86, 36, 365, 494);
		panel_2.add(panel);
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Create your Account");
		lblNewLabel_1.setBounds(32, 25, 278, 40);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);

		firstName = new JTextField();
		firstName.setForeground(Color.BLACK);
		firstName.setBounds(32, 89, 125, 32);
		firstName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		firstName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(firstName);
		firstName.setColumns(10);
		firstName.setHorizontalAlignment(SwingConstants.RIGHT);

		lastName = new JTextField();
		lastName.setBounds(185, 89, 125, 32);
		lastName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lastName.setColumns(10);
		lastName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(lastName);
		lastName.setHorizontalAlignment(SwingConstants.RIGHT);

		username = new JTextField();
		username.setBounds(32, 156, 198, 32);
		username.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		username.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(username);
		username.setColumns(10);
		username.setHorizontalAlignment(SwingConstants.RIGHT);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(32, 354, 125, 32);
		passwordField.setToolTipText("PassWord");
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(passwordField);

		confirmPassword = new JPasswordField();
		confirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmPassword.setBounds(188, 354, 125, 32);
		confirmPassword.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(confirmPassword);

		JLabel lblNewLabel_4 = new JLabel("  First Name");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_4.setBounds(42, 76, 65, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Last Name");
		lblNewLabel_4_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_4_1.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(194, 76, 65, 14);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Username");
		lblNewLabel_4_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_4_2.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_4_2.setBounds(42, 143, 65, 14);
		panel.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_4 = new JLabel("PassWord");
		lblNewLabel_4_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4_4.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_4_4.setBounds(42, 340, 65, 14);
		panel.add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_4_1 = new JLabel("Confirm");
		lblNewLabel_4_4_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_4_4_1.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblNewLabel_4_4_1.setBounds(194, 340, 65, 14);
		panel.add(lblNewLabel_4_4_1);

		JComboBox<String> gender = new JComboBox<String>();
		gender.setOpaque(false);
		gender.setFont(new Font("SansSerif", Font.BOLD, 11));
		gender.setBorder(new LineBorder(Color.WHITE, 2, true));
		gender.setForeground(Color.BLACK);
		gender.setBackground(Color.WHITE);
		gender.setModel(new DefaultComboBoxModel<String>(new String[] {"Gender", "Male ", "Female"}));
		gender.setBounds(32, 292, 75, 32);
		panel.add(gender);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("SansSerif", Font.BOLD, 11));
		dateChooser.getCalendarButton().setBorder(new LineBorder(Color.WHITE, 2, true));
		dateChooser.getCalendarButton().setText("DOB  ");
		dateChooser.setBounds(185, 294, 127, 29);
		panel.add(dateChooser);

		JLabel wrongEmailUsername = new JLabel("");
		wrongEmailUsername.setForeground(Color.RED);
		wrongEmailUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		wrongEmailUsername.setBounds(32, 269, 198, 14);
		panel.add(wrongEmailUsername);
		
		JLabel wrongDetails = new JLabel("");
		wrongDetails.setForeground(Color.RED);
		wrongDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		wrongDetails.setBounds(208, 394, 104, 14);
		panel.add(wrongDetails);

		JButton finish = new JButton("Finish");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = firstName.getText();
				String lName = lastName.getText();
				String userName = username.getText().toLowerCase();
				String Email = emailTf.getText().toLowerCase();
				String Gender = gender.getItemAt(gender.getSelectedIndex());
				String selectdate =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				String pass = String.valueOf(passwordField.getPassword());
				String confirmPass = String.valueOf(confirmPassword.getPassword());

				if(fName.length()!=0 && userName.length()!=0 && Email.length()!=0 &&
						selectdate.length()!=0 && pass.length()!=0 && confirmPass.length()!=0) {
					wrongEmailUsername.setText("");
					Pattern p = Pattern.compile("^[A-Za-z]\\w{5,29}$");
					Matcher m = p.matcher(userName);
					boolean bool = m.matches();
					final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
					Pattern p1 = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
					Matcher m1 = p1.matcher(Email);
					boolean booll = m1.matches();
					boolean bbooll = (pass.equals(confirmPass));
					System.out.println(bool+" "+booll+" "+bbooll);

					if(bool==false || booll==false || bbooll==false || Gender.equals("Gender")) {
						wrongDetails.setText("Improper Details");
						System.out.println("Returning");
						return;
					}

					try {
						Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");

						try {
							String sql1 ="SELECT username FROM credentials WHERE username = ?";
							PreparedStatement pp = con.prepareStatement(sql1);
							ResultSet r = null;
							pp.setString(1, userName);
							pp.execute();
							r = pp.executeQuery();
							r.next();
							String s = r.getString(1);
							wrongEmailUsername.setText("Already taken Username/Email");
							wrongDetails.setText("");
							return;
						} catch(SQLException ee) {
							System.out.println("Username can be accepted");
						}

						try {
							String sql1 ="SELECT email FROM credentials WHERE email = ?";
							PreparedStatement pp = con.prepareStatement(sql1);
							ResultSet r = null;
							pp.setString(1, Email);
							pp.execute();
							r = pp.executeQuery();
							r.next();
							String s = r.getString(1);
							wrongEmailUsername.setText("Already taken Username/Email");
							wrongDetails.setText("");
							return;
						} catch(Exception eee) {
							System.out.println("Email can be accepted");
						}
						
						wrongDetails.setText("");
						wrongEmailUsername.setText("");
						String otp = EmailSending.sendMail(Email);
						new OTP(otp, fName, lName, userName, Email, Gender, selectdate, pass).setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				else {
					wrongDetails.setText("Improper Details");
					wrongEmailUsername.setText("");

				}

			}
		});
		finish.setPreferredSize(new Dimension(59, 50));
		finish.setFont(new Font("SansSerif", Font.BOLD, 13));
		finish.setBorder(new LineBorder(Color.WHITE, 2, true));
		finish.setBounds(225, 419, 89, 36);
		panel.add(finish);

		JButton signInInstead = new JButton("Sign in instead");
		signInInstead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signin s = new Signin();
				s.setVisible(true);

			}
		});
		signInInstead.setPreferredSize(new Dimension(59, 50));
		signInInstead.setFont(new Font("SansSerif", Font.BOLD, 13));
		signInInstead.setBorder(new LineBorder(Color.WHITE, 2, true));
		signInInstead.setBounds(32, 419, 110, 36);
		panel.add(signInInstead);

		emailTf = new JTextField();
		emailTf.setHorizontalAlignment(SwingConstants.RIGHT);
		emailTf.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		emailTf.setColumns(10);
		emailTf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		emailTf.setBounds(32, 234, 198, 32);
		panel.add(emailTf);

		JLabel email = new JLabel("Email");
		email.setForeground(Color.DARK_GRAY);
		email.setFont(new Font("SansSerif", Font.BOLD, 11));
		email.setBounds(42, 220, 65, 14);
		panel.add(email);
		
	}
}

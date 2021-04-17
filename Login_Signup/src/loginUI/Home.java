package loginUI;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;

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
					Home frame = new Home(null);
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
	public Home(String username) {
		if(username==null) {
			setVisible(false);
			System.exit(ABORT);
		}
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		}
		catch(Exception e) {}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(580, 200, 749, 604);
		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(204, 255, 204));
		panel2.setBounds(0, 386, 733, 179);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_atomic_bomb_80px_1.png")));
		lblNewLabel.setBounds(101, 47, 98, 85);
		panel2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_atomic_bomb_80px.png")));
		lblNewLabel_1.setBounds(526, 47, 117, 98);
		panel2.add(lblNewLabel_1);

		JPanel panel1 = new JPanel();
		panel1.setBorder(null);
		panel1.setBounds(new Rectangle(0, 0, 30, 30));
		panel1.setBackground(new Color(153, 204, 255));
		panel1.setBounds(0, 0, 733, 385);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel firstName = new JLabel("");
		firstName.setBounds(220, 89, 459, 14);
		firstName.setForeground(SystemColor.textInactiveText);
		firstName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(firstName);

		JLabel lastName = new JLabel("");
		lastName.setBounds(220, 114, 459, 14);
		lastName.setForeground(SystemColor.textInactiveText);
		lastName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lastName);

		JLabel Username = new JLabel("");
		Username.setBounds(220, 139, 459, 14);
		Username.setForeground(SystemColor.textInactiveText);
		Username.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(Username);

		JLabel Email = new JLabel("");
		Email.setBounds(220, 164, 459, 14);
		Email.setForeground(SystemColor.textInactiveText);
		Email.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(Email);

		JLabel Gender = new JLabel("");
		Gender.setBounds(220, 189, 459, 14);
		Gender.setForeground(SystemColor.textInactiveText);
		Gender.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(Gender);

		JLabel DOB = new JLabel("");
		DOB.setBounds(220, 214, 459, 14);
		DOB.setForeground(SystemColor.textInactiveText);
		DOB.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(DOB);

		String query = "select firstName,lastName,username,email,gender,dob from credentials where username=?";
		try {
			PreparedStatement p = connection.prepareStatement(query);
			p.setString(1, username);
			ResultSet r = p.executeQuery();
			r.next();

			firstName.setText(r.getString(1));
			lastName.setText(r.getString(2));
			Username.setText(r.getString(3));
			Email.setText(r.getString(4));
			Gender.setText(r.getString(5));
			DOB.setText(r.getString(6));


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 5, 2, 2);
		panel1.add(scrollPane);

		JLabel lblNewLabel_2 = new JLabel("You are Succesfully Signed in");
		lblNewLabel_2.setBounds(32, 27, 380, 51);
		lblNewLabel_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_home_50px.png")));
		panel1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("First Name :");
		lblNewLabel_3.setBounds(86, 89, 100, 14);
		lblNewLabel_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Last Name :");
		lblNewLabel_3_1.setBounds(86, 114, 100, 14);
		lblNewLabel_3_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Username :");
		lblNewLabel_3_2.setBounds(86, 139, 100, 14);
		lblNewLabel_3_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Email :");
		lblNewLabel_3_3.setBounds(86, 164, 100, 14);
		lblNewLabel_3_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3_3.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Gender");
		lblNewLabel_3_4.setBounds(86, 189, 100, 14);
		lblNewLabel_3_4.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3_4.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("Date of Birth : ");
		lblNewLabel_3_5.setBounds(86, 214, 119, 14);
		lblNewLabel_3_5.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3_5.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		panel1.add(lblNewLabel_3_5);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(170, 250, 291, 124);
		panel.setLayout(null);
		panel1.add(panel);


		JButton signout = new JButton("Sign out");
		signout.setBounds(598, 319, 100, 44);
		signout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("D://icons8_checked_20px.png");
				JLabel label1 = new JLabel("Do you wanna Signout");
				label1.setVerticalAlignment(SwingConstants.BOTTOM);
				label1.setBounds(20, 20, 200, 30);
				label1.setHorizontalAlignment(SwingConstants.CENTER);
				label1.setForeground(SystemColor.textInactiveText);
				label1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
				panel.add(label1);
				UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
				int res = JOptionPane.showConfirmDialog(null, panel, "Confirm",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon);
				if(res == 0) {
					setVisible(false);
					new Signin().setVisible(true);
				}
				else {
					return;
				}


			}
		});
		signout.setBackground(new Color(153, 204, 255));
		signout.setPreferredSize(new Dimension(59, 50));
		signout.setFont(new Font("SansSerif", Font.BOLD, 13));
		signout.setBorder(new LineBorder(new Color(153, 204, 255), 5, true));
		panel1.add(signout);

	}
}

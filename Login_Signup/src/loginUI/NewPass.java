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
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NewPass extends JFrame {

	private JPanel contentPane;
	private JTextField pass;
	private JTextField confirmPass;

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
					NewPass frame = new NewPass(null);
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
	public NewPass(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1320, 400, 335, 273);
		Image icon = Toolkit.getDefaultToolkit().getImage("D://icons8_atomic_bomb_15px_2.png");  
		setIconImage(icon); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pass = new JTextField();
		pass.setFont(new Font("SansSerif", Font.BOLD, 11));
		pass.setColumns(10);
		pass.setBorder(new LineBorder(new Color(102, 204, 255), 2, true));
		pass.setBounds(98, 37, 113, 28);
		contentPane.add(pass);

		JLabel wrongPass = new JLabel("");
		wrongPass.setForeground(Color.RED);
		wrongPass.setFont(new Font("SansSerif", Font.BOLD, 12));
		wrongPass.setBounds(105, 131, 106, 21);
		contentPane.add(wrongPass);

		JButton verify = new JButton("verify");
		verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first = pass.getText();
				String second = confirmPass.getText();
				if((first.length()==0 || second.length()==0) || !first.equals(second)) {
					wrongPass.setText("Password does not match");
				}
				else {
					wrongPass.setText("");
					try {
						Class.forName("com.mysql.jdbc.Driver");

						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
						PreparedStatement stmt;
						stmt = con.prepareStatement("update credentials set password=? where username=?");
						stmt.setString(1, second);
						stmt.setString(2, username);

						int ii = stmt.executeUpdate();
						System.out.println(ii);
						setVisible(false);
					} catch (Exception e1) {
						e1.printStackTrace();
					}  
				}
			}
		});
		verify.setFont(new Font("SansSerif", Font.BOLD, 11));
		verify.setBorder(new LineBorder(new Color(102, 204, 255), 2, true));
		verify.setBackground(new Color(255, 255, 204));
		verify.setBounds(109, 163, 89, 28);
		contentPane.add(verify);

		confirmPass = new JTextField();
		confirmPass.setFont(new Font("SansSerif", Font.BOLD, 11));
		confirmPass.setColumns(10);
		confirmPass.setBorder(new LineBorder(new Color(102, 204, 255), 2, true));
		confirmPass.setBounds(98, 102, 113, 28);
		contentPane.add(confirmPass);


	}

}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TrangchuView extends JFrame{

	public TrangchuView() {
		this.init();
	}
	
	private void init() {
		this.setTitle("ĐĂNG NHẬP");
		this.setSize(500, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	    

		JPanel jPanel_north = new JPanel();
		jPanel_north.setLayout(new BorderLayout());
		
		Font font = new Font("Arial", Font.BOLD, 25);
		Font font2 = new Font("Arial", Font.BOLD, 12);
				
		JLabel jLabel_dn = new JLabel("                        LOGIN HERE");
		jLabel_dn.setFont(font);
		jLabel_dn.setForeground(Color.BLUE);
		
		JPanel jPanel_addicon = new JPanel();
		jPanel_addicon.setLayout(new BorderLayout());
		
		JLabel jLabel_doc = new JLabel("");
		jLabel_doc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("Doctor_icon.png"))));
		JLabel jLabel_west = new JLabel("                                                              ");
		
		jPanel_addicon.add(jLabel_west, BorderLayout.WEST);
		jPanel_addicon.add(jLabel_doc, BorderLayout.CENTER);
		
		jPanel_north.add(jPanel_addicon, BorderLayout.NORTH);
		jPanel_north.add(jLabel_dn, BorderLayout.CENTER);

		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new BorderLayout());
		
		JPanel jPanel_text = new JPanel();
		jPanel_text.setLayout(new GridLayout(2, 2, 0, 15));
		
		JLabel jLabel_user = new JLabel("UserName");
		jLabel_user.setFont(font2);
		JTextField jTextField_user = new JTextField();
		JLabel jLabel_pass = new JLabel("PassWord");
		jLabel_pass.setFont(font2);
		JPasswordField jPasswordField = new JPasswordField();
		jPanel_text.add(jLabel_user);
		jPanel_text.add(jTextField_user);
		jPanel_text.add(jLabel_pass);
		jPanel_text.add(jPasswordField);
		
		JPanel jPanel_but = new JPanel();
		jPanel_but.setLayout(new GridLayout(2, 5));
		
		JButton jButton_dn = new JButton("SIGN IN");
		jButton_dn.setFont(font2);
		jButton_dn.setBackground(Color.BLUE);
		jButton_dn.setOpaque(true);
		//jButton_dn.setBorderPainted(false);
		JButton jButton_dk = new JButton("REGISTER"); 
		jButton_dk.setBackground(Color.GREEN);
		jButton_dk.setFont(font2);
		jButton_dk.setOpaque(true);
		//jButton_dk.setBorderPainted(false);
		
	    JLabel jLabel1 = new JLabel("            ");
	    JLabel jLabel2 = new JLabel("     ");
	    JLabel jLabel5 = new JLabel("            ");
	    JLabel jLabel6 = new JLabel();
	    JLabel jLabel7 = new JLabel();
	    JLabel jLabel8 = new JLabel();
	    JLabel jLabel9 = new JLabel();
	    JLabel jLabel0 = new JLabel();
	 
	    jPanel_but.add(jLabel1);
		jPanel_but.add(jButton_dn);
		jPanel_but.add(jLabel2);
		jPanel_but.add(jButton_dk);
		jPanel_but.add(jLabel5);
		jPanel_but.add(jLabel8);
		jPanel_but.add(jLabel7);
		jPanel_but.add(jLabel6);
		jPanel_but.add(jLabel9);
		jPanel_but.add(jLabel0);

		JLabel jLabel3 = new JLabel("                               ");
		JLabel jLabel4 = new JLabel("                             ");
	
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		
		jPanel.add(jPanel_text, BorderLayout.CENTER);
		jPanel.add(jLabel3, BorderLayout.WEST);
		jPanel.add(jLabel4, BorderLayout.EAST);
		
		jPanel_center.add(jPanel, BorderLayout.NORTH);
		
		JPanel jPanel_south = new JPanel();
		jPanel_south.setLayout(new BorderLayout());
		jPanel_south.add(jPanel_but, BorderLayout.NORTH);
		
		jButton_dn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String user = jTextField_user.getText();
				String pass = jPasswordField.getText();

				if (Valid(user, pass)) {
					JOptionPane.showMessageDialog(TrangchuView.this, "Đăng Nhập Thành Công");
					View();
					dispose();
				} else {
					JOptionPane.showMessageDialog(TrangchuView.this,
							"Tài Khoản Không Tồn Tại! Yêu cầu Kiểm Tra Lại Thông Tin!");
				
			}
			}
		});
		
		
		this.setLayout(new BorderLayout());
		URL iconURL = getClass().getResource("medical_icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		this.setIconImage(icon.getImage());
		
		this.add(jPanel_north, BorderLayout.NORTH);
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_south, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new TrangchuView();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean Valid(String user, String pass) {

		String url = "jdbc:mySQL://localhost:3306/management";
		String username = "root";
		String password = "";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM Account WHERE username = ? AND password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	private void View() {
		ThongTinBenhNhanView view = new ThongTinBenhNhanView();
		view.setVisible(true);
	}
}

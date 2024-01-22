package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.HSBN_DAO;
import model.Hoso;

public class HoSoBenhAnView extends JFrame {

	protected Component HoSoBenhAnView;
	private JTable jTable_hoso;

	public HoSoBenhAnView() {
		this.init();
	}

	private void init() {
		this.setTitle("HỒ SƠ BỆNH ÁN");
		this.setSize(5000, 5000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		URL url = MainView.class.getResource("hoso_icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);

		JPanel jPanel_all = new JPanel();
		jPanel_all.setLayout(new BorderLayout());

		Border border_all = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_all = new TitledBorder(border_all, "Tìm Kiếm, Hiển Thị");
		jPanel_all.setBorder(titledBorder_all);

		JPanel jPanel_Hoso = new JPanel();
		jPanel_Hoso.setLayout(new GridLayout(2, 2, 20, 20));

		JLabel jLabel_id = new JLabel("Mã Bệnh Nhân");
		JTextField jTextField_id = new JTextField(20);
		JLabel jLabel_hoten = new JLabel("Họ và Tên");
		JTextField jTextField_hoten = new JTextField(20);

		jPanel_Hoso.add(jLabel_id);
		jPanel_Hoso.add(jTextField_id);
		jPanel_Hoso.add(jLabel_hoten);
		jPanel_Hoso.add(jTextField_hoten);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());

		JButton jButton_tim = new JButton("Tìm Kiếm");
		jButton_tim.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("finding_icon.png"))));
		JButton jButton_hienthi = new JButton("Hiển Thị");
		jButton_hienthi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("display_icon.png"))));
		JButton jButton_thoat = new JButton("Thoát");
		jButton_thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exit_icon.png"))));
		JButton jButton_an = new JButton("Làm Mới");
		jButton_an.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("refresh_icon.png"))));

		jPanel_button.add(jButton_hienthi);
		jPanel_button.add(jButton_an);
		jPanel_button.add(jButton_tim);
		jPanel_button.add(jButton_thoat);

		jPanel_all.add(jPanel_Hoso, BorderLayout.NORTH);
		jPanel_all.add(jPanel_button, BorderLayout.CENTER);

		JPanel jPanel_table = new JPanel();
		jPanel_table.setLayout(new BorderLayout());

		// Tạo Viền và Tiêu Đề
		Border border_table = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_table = new TitledBorder(border_table, "Hồ Sơ Bệnh Án");
		jPanel_table.setBorder(titledBorder_table);

		DefaultTableModel table = new DefaultTableModel();
		table.addColumn("MãBệnhNhân");
		table.addColumn("Họ Tên");
		table.addColumn("Ngày Sinh");
		table.addColumn("Loại Bệnh");
		table.addColumn("Ngày Nhập Viện");
		table.addColumn("Ngày Xuất Viện");
		table.addColumn("Loại Điều Trị");

		jButton_hienthi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DefaultTableModel table = (DefaultTableModel) jTable_hoso.getModel();
				table.setRowCount(0);

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();

					ResultSet rs = st.executeQuery("SELECT * FROM dangki");

					while (rs.next()) {
						String id = rs.getString("MãBệnhNhân");
						String hoten = rs.getString("HọTên");
						String ngaysinh = rs.getString("NgàySinh");
						String loaibenh = rs.getString("LoạiBệnh");
						String ngayvao = rs.getString("NgàyNhậpViện");
						String ngayra = rs.getString("NgàyXuấtViện");
						String loaidieutri = rs.getString("LoạiĐiềuTrị");

						table.addRow(new Object[] { id, hoten, ngaysinh, loaibenh, ngayvao, ngayra, loaidieutri });
					}

					st.close();
					con.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		jButton_an.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jTextField_id.setText("");
				jTextField_hoten.setText("");
				DefaultTableModel table = (DefaultTableModel) jTable_hoso.getModel();
				table.setRowCount(0);

			}
		});

		jButton_tim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();

				ResultSet rs = st.executeQuery("SELECT * FROM dangki WHERE MãBệnhNhân LIKE '"+jTextField_id.getText()+"%' AND HọTên LIKE '"+jTextField_hoten.getText()+"%'");

					while (rs.next()) {
						String id = rs.getString("MãBệnhNhân");
						String hoten = rs.getString("HọTên");
						String ngaysinh = rs.getString("NgàySinh");
						String loaibenh = rs.getString("LoạiBệnh");
						String ngayvao = rs.getString("NgàyNhậpViện");
						String ngayra = rs.getString("NgàyXuấtViện");
						String loaidieutri = rs.getString("LoạiĐiềuTrị");

						table.addRow(new Object[] { id, hoten, ngaysinh, loaibenh, ngayvao, ngayra, loaidieutri });
					}

					st.close();
					con.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		});

		jTable_hoso = new JTable(table);
		JScrollPane jScrollPane_hoso = new JScrollPane(jTable_hoso);
		// jScrollPane_hoso.getViewport().add(jScrollPane_hoso);

		jPanel_table.add(jScrollPane_hoso, BorderLayout.CENTER);

		jButton_thoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int luaChon = JOptionPane.showConfirmDialog(HoSoBenhAnView, "Bạn Muốn Thoát Khỏi Chương Trình", "EXIT",
						JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		this.setLayout(new BorderLayout());
		this.add(jPanel_all, BorderLayout.NORTH);
		this.add(jPanel_table, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new HoSoBenhAnView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

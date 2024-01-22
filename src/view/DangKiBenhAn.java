package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.QLBNController;

public class DangKiBenhAn extends JFrame {

	protected Component DangKiBenhAn;
	private JRadioButton jRadioButton_dieutri;
	private JRadioButton jRadioButton_dieutri1;

	public DangKiBenhAn() {
		this.init();
	}

	private void init() {
		this.setTitle("LẬP BỆNH ÁN");
		this.setSize(5001, 5001);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		URL url_title = MainView.class.getResource("dangki_icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
		this.setIconImage(img);

		ActionListener action = new QLBNController(this);

		JPanel jPanel_dangki = new JPanel();
		jPanel_dangki.setLayout(new BorderLayout());

		// Tạo Panel chứa thông tin đăng kí
		JPanel jPanel_thongtin = new JPanel();
		jPanel_thongtin.setLayout(new GridLayout(6, 2, 20, 20));

		// Tạo viền và tieu đề
		Border border_thongtin = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_thongtin = new TitledBorder(border_thongtin, "Nhập Thông Tin");
		jPanel_thongtin.setBorder(titledBorder_thongtin);

		JLabel jLabel_MaBN = new JLabel("Mã Bệnh Nhân");
		JTextField jTextField_MaBN = new JTextField(40);
		JLabel jLabel_hoten = new JLabel("Họ Và Tên");
		JTextField jTextField_hoTen = new JTextField(40);
		JLabel jLabel_NgaySinh = new JLabel("Ngày Sinh");
		JTextField jTextField_ngaySinh = new JTextField(40);
		JLabel jLabel_loaibenh = new JLabel("Loại Bệnh");
		JTextField jTextField_loaibenh = new JTextField(40);
		JLabel jLabel_ngayNhapVien = new JLabel("Ngày Nhập Viện");
		JTextField jTextField_nhapvien = new JTextField(40);
		JLabel jLabel_ngayRaVien = new JLabel("Ngày Xuất Viện");
		JTextField jTextField_raVien = new JTextField(40);

		jPanel_thongtin.add(jLabel_MaBN);
		jPanel_thongtin.add(jTextField_MaBN);
		jPanel_thongtin.add(jLabel_hoten);
		jPanel_thongtin.add(jTextField_hoTen);
		jPanel_thongtin.add(jLabel_NgaySinh);
		jPanel_thongtin.add(jTextField_ngaySinh);
		jPanel_thongtin.add(jLabel_loaibenh);
		jPanel_thongtin.add(jTextField_loaibenh);
		jPanel_thongtin.add(jLabel_ngayNhapVien);
		jPanel_thongtin.add(jTextField_nhapvien);
		jPanel_thongtin.add(jLabel_ngayRaVien);
		jPanel_thongtin.add(jTextField_raVien);

		// Tạo Panel Chứa tất cả các phần của điều trị
		JPanel jPanel_all = new JPanel();
		jPanel_all.setLayout(new BorderLayout());

		// Tạo Panel chứa các nút nhấn
		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new GridLayout(2, 1, 20, 20));

		// Tạo viền và Tiêu Đề
		Border border_dieutri = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder_dieutri = new TitledBorder(border_dieutri, "Phương Thức Điều Trị");
		jPanel_button.setBorder(titledBorder_dieutri);

		jRadioButton_dieutri = new JRadioButton("Nội Trú");
		jRadioButton_dieutri1 = new JRadioButton("Ngoại Trú");

		ButtonGroup buttonGroup_dieutri = new ButtonGroup();
		buttonGroup_dieutri.add(jRadioButton_dieutri);
		buttonGroup_dieutri.add(jRadioButton_dieutri1);
		
		jPanel_button.add(jRadioButton_dieutri);
		jPanel_button.add(jRadioButton_dieutri1);

		// Tạo Panel chứa các lựa chọn
		JPanel jPanel_luachon = new JPanel();
		jPanel_luachon.setLayout(new FlowLayout());

		// Tạo viền và tiêu đề
		Border border_luachon = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_luachon = new TitledBorder(border_luachon, "Lựa Chọn");
		jPanel_luachon.setBorder(titledBorder_luachon);

		JButton jButton_them = new JButton("Thêm Mới");
		jButton_them.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("add_icon.png"))));
		JButton jButton_capnhat = new JButton("Xem Hồ Sơ");
		jButton_capnhat.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("hoso_icon.png"))));
		JButton jButton_luu = new JButton("Lưu");
		jButton_luu.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("save-icon.png"))));
		JButton jButton_thoat = new JButton("Thoát");
		jButton_thoat.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exit-icon.png"))));

		jPanel_luachon.add(jButton_them);
		jPanel_luachon.add(jButton_luu);
		jPanel_luachon.add(jButton_capnhat);
		jPanel_luachon.add(jButton_thoat);

		jPanel_all.add(jPanel_button, BorderLayout.NORTH);
		jPanel_all.add(jPanel_luachon, BorderLayout.SOUTH);

		jPanel_dangki.add(jPanel_thongtin, BorderLayout.WEST);
		jPanel_dangki.add(jPanel_all, BorderLayout.CENTER);

		jButton_thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(DangKiBenhAn, "Bạn Muốn Thoát Khỏi Chương Trình", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});

		jButton_luu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {

					String dieutri = "";
					if (jRadioButton_dieutri.isSelected())
						dieutri = jRadioButton_dieutri.getText();
					if (jRadioButton_dieutri1.isSelected())
						dieutri = jRadioButton_dieutri1.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();

					int n = st.executeUpdate(
							"INSERT INTO dangki(MãBệnhNhân, HọTên, NgàySinh, LoạiBệnh, NgàyNhậpViện, NgàyXuấtViện, LoạiĐiềuTrị)"
									+ "VALUES ('"+jTextField_MaBN.getText()+"','" + jTextField_hoTen.getText() + "', '" + jTextField_ngaySinh.getText()
									+ "', '" + jTextField_loaibenh.getText() + "', '" + jTextField_nhapvien.getText()
									+ "', '" + jTextField_raVien.getText() + "', '" + dieutri + "')");

					JOptionPane.showMessageDialog(null, "Success");

					System.out.println("Số Dòng Thay Đổi: " + n);

					if (n > 0) {
						System.out.println("Thêm dữ liệu Thành Công!");
					} else {
						System.out.println("Thêm dữ liệu Thất Bại!");

						st.close();
						con.close();
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
		jButton_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jTextField_MaBN.setText("");
				jTextField_hoTen.setText("");
				jTextField_ngaySinh.setText("");
				jTextField_nhapvien.setText("");
				jTextField_raVien.setText("");
				jTextField_loaibenh.setText("");
				buttonGroup_dieutri.clearSelection();
				
				
			}
		});
		
		jButton_capnhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoSoBenhAnView hoso = new HoSoBenhAnView();
				hoso.setVisible(true);
			}
		});

		this.setLayout(new BorderLayout());
		this.add(jPanel_dangki, BorderLayout.NORTH);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new DangKiBenhAn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

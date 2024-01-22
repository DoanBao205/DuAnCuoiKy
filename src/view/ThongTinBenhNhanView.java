package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.QLBNController;
import model.Benhnhan;
import model.QLTTBenhnhan;
import view.DangKiBenhAn;
import controller.QLBN_DAO;

public class ThongTinBenhNhanView extends JFrame {

	public QLTTBenhnhan model = new QLTTBenhnhan();
	public JButton jButton_tao;
	public JButton jButton_xem;
	public JButton jButton_thoat;
	public JButton jButton_luu;
	public JButton jButton_sua;
	public JButton jButton_them;
	public JTextField jTextField_id;
	public JTextField jTextField_hoten;
	public JTextField jTextField_ngaysinh;
	public JTextField jTextField_tinh;
	public JTextField jTextField_huyen;
	public JTextField jTextField_xa;
	public JRadioButton jRadioButton_nam;
	public JRadioButton jRadioButton_nu;
	public JRadioButton jRadioButton_khac;
	public ButtonGroup buttonGroup_benhan;
	public JRadioButton jRadioButton_Co;
	public JRadioButton jRadioButton_Khong;
	public ButtonGroup btg;
	private JTable jTable_thongtin_new;
	private JButton jButton_xoa;
	private JButton jButton_xemdl;

	public ThongTinBenhNhanView() {
		this.init();
	}

	private void init() {
		this.setTitle("THÔNG TIN BỆNH NHÂN");
		this.setSize(1500, 1200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		ActionListener action = new QLBNController(this);

		URL url_title = MainView.class.getResource("medical_icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
		this.setIconImage(img);

		JSeparator jSeparator = new JSeparator();
		Font font = new Font("Verdana", Font.BOLD, 30);
		Font font1 = new Font("Verdana", Font.BOLD, 60);

		// Tạo phần Thông tin Bệnh nhân
		JPanel jPanel_benhnhan = new JPanel();
		jPanel_benhnhan.setLayout(new GridLayout(4, 2, 10, 10));

		// Tạo viền và Tiêu Đề
		Border border_benhnhan = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledBorder_benhnhan = new TitledBorder(border_benhnhan, "Thông Tin Bệnh Nhân");
		jPanel_benhnhan.setBorder(titledBorder_benhnhan);

		JLabel jLabel_id = new JLabel("Mã Bệnh Nhân: ");
		jTextField_id = new JTextField(20);
		JLabel jLabel_hoten = new JLabel("Họ tên Bệnh Nhân: ");
		jTextField_hoten = new JTextField(20);
		JLabel jLabel_ngaysinh = new JLabel("Ngày Sinh: ");
		jTextField_ngaysinh = new JTextField(20);

		// Tạo Bệnh Án
		JPanel jPanel_benhAn = new JPanel();
		jPanel_benhAn.setLayout(new GridLayout(2, 2, 50, 10));

		// Tạo viền và tiêu đề cho bệnh án
		Border border_benhan = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_benhan = new TitledBorder(border_benhan, "Bệnh Án");
		jPanel_benhAn.setBorder(titledBorder_benhan);

		// Tạo các nút nhấn và JRadioButton
		jButton_tao = new JButton("Lập Bệnh Án");
		jButton_tao.addActionListener(action);
		jButton_xem = new JButton("Hồ Sơ Bệnh Án");
		jButton_xem.addActionListener(action);
		jRadioButton_Co = new JRadioButton("Có Bệnh Án");
		jRadioButton_Khong = new JRadioButton("Không có Bệnh Án");

		// Tạo nhóm các nút nhấn và các nút vào nhóm
		buttonGroup_benhan = new ButtonGroup();
		buttonGroup_benhan.add(jRadioButton_Co);
		buttonGroup_benhan.add(jRadioButton_Khong);
		buttonGroup_benhan.add(jButton_tao);
		buttonGroup_benhan.add(jButton_xem);

		// Add các nút vào JPanel
		jPanel_benhAn.add(jRadioButton_Co);
		jPanel_benhAn.add(jRadioButton_Khong);
		jPanel_benhAn.add(jButton_tao);
		jPanel_benhAn.add(jButton_xem);

		// Thêm vào phần thông tin bệnh nhân
		jPanel_benhnhan.add(jLabel_id);
		jPanel_benhnhan.add(jTextField_id);
		jPanel_benhnhan.add(jLabel_hoten);
		jPanel_benhnhan.add(jTextField_hoten);
		jPanel_benhnhan.add(jLabel_ngaysinh);
		jPanel_benhnhan.add(jTextField_ngaysinh);

		// Janel để chứa Bệnh nhân và Bệnh án
		JPanel jPanel_benhnhan_benhan = new JPanel();
		jPanel_benhnhan_benhan.setLayout(new BorderLayout());
		jPanel_benhnhan_benhan.add(jPanel_benhnhan, BorderLayout.NORTH);
		jPanel_benhnhan_benhan.add(jPanel_benhAn, BorderLayout.CENTER);
		// jPanel_benhnhan_benhan.add(jSeparator);

		// Tạo Phần Địa chỉ Bệnh Nhân
		JPanel jPanel_diachi = new JPanel();
		jPanel_diachi.setLayout(new GridLayout(4, 2, 10, 10));

		// Tạo viền và tiêu đề
		Border border_diachi = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_diachi = new TitledBorder(border_diachi, "Địa Chỉ Bệnh Nhân");
		jPanel_diachi.setBorder(titledBorder_diachi);

		JLabel jLabel_tinh = new JLabel("Tỉnh/ Thành Phố");
		jTextField_tinh = new JTextField(40);
		JLabel jLabel_huyen = new JLabel("Quận/Huyện");
		jTextField_huyen = new JTextField(40);
		JLabel jLabel_xa = new JLabel("Xã/ Phường/ Thị Trấn");
		jTextField_xa = new JTextField(40);

		jPanel_diachi.add(jLabel_tinh);
		jPanel_diachi.add(jTextField_tinh);
		jPanel_diachi.add(jLabel_huyen);
		jPanel_diachi.add(jTextField_huyen);
		jPanel_diachi.add(jLabel_xa);
		jPanel_diachi.add(jTextField_xa);

		// Tạo phần giới tính
		JPanel jPanel_gioitinh = new JPanel();
		jPanel_gioitinh.setLayout(new FlowLayout(10, 50, 0));

		// Tạo viền và tiêu đề cho Giới tính
		Border border_gioitinh = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_gioitinh = new TitledBorder(border_gioitinh, "Giới Tính");
		jPanel_gioitinh.setBorder(titledBorder_gioitinh);

		// Tạo hai RadioButton
		jRadioButton_nam = new JRadioButton("Nam");
		jRadioButton_nu = new JRadioButton("Nữ");

		// Nhóm các RadioButton vào btg
		btg = new ButtonGroup();
		btg.add(jRadioButton_nam);
		btg.add(jRadioButton_nu);
		btg.add(jRadioButton_khac);
		jPanel_gioitinh.add(jRadioButton_nam);
		jPanel_gioitinh.add(jRadioButton_nu);

		// Tạo panel để chứa phần địa chỉ và giới tính
		JPanel jPanel_diachi_gioitinh = new JPanel();
		jPanel_diachi_gioitinh.setLayout(new BorderLayout());
		jPanel_diachi_gioitinh.add(jPanel_diachi, BorderLayout.NORTH);
		jPanel_diachi_gioitinh.add(jPanel_gioitinh, BorderLayout.CENTER);
		// jPanel_diachi_gioitinh.add(jSeparator);

		// Tạo Panel chứa các lựa chọn
		JPanel jPanel_luachon = new JPanel();
		jPanel_luachon.setLayout(new FlowLayout());

		// Tạo tiêu đề và viền
		Border border_luachon = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titledBorder_luachon = new TitledBorder(border_luachon, "Lựa Chọn");
		jPanel_luachon.setBorder(titledBorder_luachon);

		// Tạo các nút nhấn
		jButton_them = new JButton("Thêm Mới");
		jButton_them.addActionListener(action);
		jButton_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("add_icon.png"))));
		jButton_luu = new JButton("Lưu");
		jButton_luu.addActionListener(action);
		jButton_luu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("save-icon.png"))));
		jButton_thoat = new JButton("Thoát");
		jButton_thoat.addActionListener(action);
		jButton_thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exit-icon.png"))));
		jButton_xoa = new JButton("Xóa");
		jButton_xoa.addActionListener(action);
		jButton_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("xoa_icon.png"))));
		jButton_xemdl = new JButton("Xem");
		jButton_xemdl.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("xem_icom.png"))));

		// Thêm các nút nhấn vào Panel
		jPanel_luachon.add(jButton_them);
		jPanel_luachon.add(jButton_xoa);
		jPanel_luachon.add(jButton_luu);
		jPanel_luachon.add(jButton_xemdl);
		jPanel_luachon.add(jButton_thoat);

		JPanel jPanel_benhnhan_diachi_all = new JPanel();
		jPanel_benhnhan_diachi_all.setLayout(new BorderLayout());
		jPanel_benhnhan_diachi_all.add(jPanel_benhnhan_benhan, BorderLayout.CENTER);
		jPanel_benhnhan_diachi_all.add(jPanel_diachi_gioitinh, BorderLayout.EAST);
		jPanel_benhnhan_diachi_all.add(jPanel_luachon, BorderLayout.SOUTH);

		// Tạo Panel chứa bảng
		JPanel jPanel_table_new = new JPanel();
		jPanel_table_new.setLayout(new BorderLayout());
		// Tạo bảng

		DefaultTableModel dm1 = new DefaultTableModel();
		dm1.addColumn("MãBệnhNhân");
		dm1.addColumn("HọTênBệnhNhân");
		dm1.addColumn("NgàySinh");
		dm1.addColumn("Tỉnh");
		dm1.addColumn("Huyện");
		dm1.addColumn("Xã");
		dm1.addColumn("GiớiTính");
		dm1.addColumn("BệnhÁn");

		jTable_thongtin_new = new JTable(dm1);
		
//		jPanel_benhnhan_diachi_all.setBackground(Color.CYAN);
//		jPanel_benhnhan_diachi_all.setOpaque(true);

		JScrollPane jScrollPane_table = new JScrollPane(jTable_thongtin_new);
		jPanel_table_new.add(jScrollPane_table, BorderLayout.CENTER);

		this.add(jPanel_benhnhan_diachi_all, BorderLayout.NORTH);
		this.add(jPanel_table_new, BorderLayout.CENTER);

//		jTable_thongtin_new.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				int i_row = jTable_thongtin_new.getSelectedRow();
//				String MãBệnhNhân = jTable_thongtin_new.getValueAt(i_row, 0).toString();
//				String HọTênBệnhNhân = jTable_thongtin_new.getValueAt(i_row, 1).toString();
//				String NgàySinh = jTable_thongtin_new.getValueAt(i_row, 2).toString();
//				String Tỉnh = jTable_thongtin_new.getValueAt(i_row, 3).toString();
//				String Huyện = jTable_thongtin_new.getValueAt(i_row, 4).toString();
//				String Xã = jTable_thongtin_new.getValueAt(i_row, 5).toString();
//				String GiớiTính = jTable_thongtin_new.getValueAt(i_row, 6).toString();
//				String BệnhÁn = jTable_thongtin_new.getValueAt(i_row, 7).toString();
//
//				jTextField_id.setText(MãBệnhNhân);
//				jTextField_hoten.setText(HọTênBệnhNhân);
//				jTextField_tinh.setText(Tỉnh);
//				jTextField_huyen.setText(Huyện);
//				jTextField_xa.setText(Xã);
//				jTextField_ngaysinh.setText(NgàySinh);
//
//				if (buttonGroup_benhan.equals(jRadioButton_Co.getText()))
//					jRadioButton_Co.setSelected(true);
//				if (buttonGroup_benhan.equals(jRadioButton_Khong.getText()))
//					jRadioButton_Khong.setSelected(true);
//				if (btg.equals(jRadioButton_nam.getText()))
//					jRadioButton_nam.setSelected(true);
//				if (btg.equals(jRadioButton_nu.getText()))
//					jRadioButton_nu.setSelected(true);
//
//			}
//		});
		
		jButton_xemdl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HienThiView hienthi = new HienThiView();
				hienthi.setVisible(true);
			}
		});

		// THỰC HIỆN CÁC CÂU LỆNH SQL

		jButton_luu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Benhnhan bn = new Benhnhan();
				QLBN_DAO ql = new QLBN_DAO();

				String mabn = jTextField_id.getText();
				int maBenhNhan = Integer.valueOf(mabn);
				bn.setMaBenhNhan(maBenhNhan);
				bn.setTenBenhNhan(jTextField_hoten.getText());
				bn.setDiaChi(jTextField_xa.getText() + "/" + jTextField_huyen.getText() + "/" + jTextField_tinh.getText());
				bn.setNgaySinh(jTextField_ngaysinh.getText());
				String gioiTinh = "";
				if (jRadioButton_nam.isSelected())
					gioiTinh = jRadioButton_nam.getText();
				if (jRadioButton_nu.isSelected())
					gioiTinh = jRadioButton_nu.getText();
				bn.setGioiTinh(gioiTinh);

				String benhAn = "";
				if (jRadioButton_Co.isSelected())
					benhAn = jRadioButton_Co.getText();
				if (jRadioButton_Khong.isSelected())
					benhAn = jRadioButton_Khong.getText();
				bn.setBenhAn(benhAn);

				ql.insert(bn);
			}
		});


		this.setVisible(true);
	}

	
	public void xoaThongTin_Xuli_Them() {
		jTextField_id.setText("");
		jTextField_hoten.setText("");
		jTextField_ngaysinh.setText("");
		jTextField_tinh.setText("");
		jTextField_huyen.setText("");
		jTextField_xa.setText("");
		buttonGroup_benhan.clearSelection();
		btg.clearSelection();

	}
	
	public void themSinhVien_Xuli_Luu() {
		// Lấy dữ liệu
		int maBenhNhan = Integer.valueOf(this.jTextField_id.getText() + "");
		String tenBenhNhan = this.jTextField_hoten.getText();
		String ngaySinh = this.jTextField_ngaysinh.getText();
		String tinh = this.jTextField_tinh.getText();
		String huyen = this.jTextField_huyen.getText();
		String xa = this.jTextField_xa.getText();
		String gioiTinh = "";
		if (this.jRadioButton_nam.isSelected()) {
			gioiTinh = "Nam";
		} else if (this.jRadioButton_nu.isSelected()) {
			gioiTinh = "Nữ";
		}
		String benhAn = "";
		if (this.jRadioButton_Co.isSelected()) {
			benhAn = "Có Bệnh Án";
		} else if (jRadioButton_Khong.isSelected()) {
			benhAn = "Không Có Bệnh Án";
		}

		DefaultTableModel dm1 = (DefaultTableModel) jTable_thongtin_new.getModel();
		dm1.addRow(new Object[] { maBenhNhan, tenBenhNhan, ngaySinh, tinh, huyen, xa, gioiTinh, benhAn });
	}

	public void thoatChuongTrinh_Xuli_Thoat() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn Muốn Thoát Khỏi Chương Trình", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void hienThiJFrame1() {
		// TODO Auto-generated method stub
		DangKiBenhAn dangki = new DangKiBenhAn();
		dangki.setVisible(true);
	}

	public void hienThiJFrame2() {
		// TODO Auto-generated method stub
		HoSoBenhAnView hoso = new HoSoBenhAnView();
		hoso.setVisible(true);

	}

	public void thucHienXoa() {
		DefaultTableModel dm1 = (DefaultTableModel) jTable_thongtin_new.getModel();
		int i_row = jTable_thongtin_new.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Dòng Đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			dm1.removeRow(i_row);
		}
		jTextField_id.setText("");
		jTextField_hoten.setText("");
		jTextField_ngaysinh.setText("");
		jTextField_tinh.setText("");
		jTextField_huyen.setText("");
		jTextField_xa.setText("");
		buttonGroup_benhan.clearSelection();
		btg.clearSelection();
		
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ThongTinBenhNhanView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

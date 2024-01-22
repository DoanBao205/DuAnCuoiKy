package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.AbstractButton;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.QLBN_DAO;
import model.Benhnhan;
import model.QLTTBenhnhan;

public class HienThiView extends JFrame {

	private JTextField jTextField_id;
	private JTextField jTextField_ngaySinh;
	private JTextField jTextField_ten;
	private JTextField jTextField_gioiTinh;
	private JTextField jTextField_diaChi;
	private JTextField jTextField_benhAn;
	private JTable table;
	private JButton jButton_update;
	private JButton jButton_dis;
	private AbstractButton jButton_del;
	private AbstractButton jButton_sapxep;
	private JButton jButton_refresh;
	private DefaultTableModel model_table;
	private DefaultTableModel table_model;

	public HienThiView() {
		this.init();
	}

	private void init() {
		this.setTitle("HIỂN THỊ THÔNG TIN BỆNH NHÂN");
		this.setSize(5000, 7000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JLabel jLabel_id = new JLabel("Mã Bệnh Nhân");
		jTextField_id = new JTextField();
		JLabel jLabel_ten = new JLabel("Họ Tên");
		JLabel jLabel_ngaySinh = new JLabel("Ngày Sinh");
		JLabel jLabel_diaChi = new JLabel("Địa Chỉ");
		JLabel jLabel_gioiTinh = new JLabel("Giới Tính");
		JLabel jLabel_benhAn = new JLabel("Bệnh Án");
		jTextField_ten = new JTextField();
		jTextField_ngaySinh = new JTextField();
		jTextField_diaChi = new JTextField();
		jTextField_gioiTinh = new JTextField();
		jTextField_benhAn = new JTextField();

		JPanel jPanel_text = new JPanel();
		jPanel_text.setLayout(new GridLayout(3, 4, 20, 20));

		jPanel_text.add(jLabel_id);
		jPanel_text.add(jTextField_id);
		jPanel_text.add(jLabel_ten);
		jPanel_text.add(jTextField_ten);
		jPanel_text.add(jLabel_ngaySinh);
		jPanel_text.add(jTextField_ngaySinh);
		jPanel_text.add(jLabel_diaChi);
		jPanel_text.add(jTextField_diaChi);
		jPanel_text.add(jLabel_gioiTinh);
		jPanel_text.add(jTextField_gioiTinh);
		jPanel_text.add(jLabel_benhAn);
		jPanel_text.add(jTextField_benhAn);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title = new TitledBorder(border, "Lựa Chọn");
		jPanel_button.setBorder(title);

		jButton_update = new JButton("Cập Nhật");
		jButton_update.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("update_icon.png"))));
		jButton_dis = new JButton("Hiển Thị");
		jButton_dis.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("display_icon.png"))));
		jButton_del = new JButton("Xóa");
		jButton_del.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("delete_icon.png"))));
		jButton_sapxep = new JButton("Sắp Xếp");
		jButton_sapxep.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("sx_icon.png"))));
		jButton_refresh = new JButton("Làm Mới");
		jButton_refresh.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("refresh_icon.png"))));

		jPanel_button.add(jButton_update);
		jPanel_button.add(jButton_sapxep);
		jPanel_button.add(jButton_dis);
		jPanel_button.add(jButton_del);
		jPanel_button.add(jButton_refresh);

		JPanel jPanel_all = new JPanel();
		jPanel_all.setLayout(new BorderLayout());
		jPanel_all.add(jPanel_text, BorderLayout.NORTH);
		jPanel_all.add(jPanel_button, BorderLayout.CENTER);

		JPanel jPanel_tb = new JPanel();
		jPanel_tb.setLayout(new BorderLayout());

		DefaultTableModel model_table = new DefaultTableModel();
		model_table.addColumn("MaBenhNhan");
		model_table.addColumn("HoTen");
		model_table.addColumn("NgaySinh");
		model_table.addColumn("DiaChi");
		model_table.addColumn("GioiTinh");
		model_table.addColumn("BenhAn");

		table = new JTable(model_table);
		JScrollPane jsc = new JScrollPane(table);
		jPanel_tb.add(jsc, BorderLayout.CENTER);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
			    if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
			        String id = table.getValueAt(table.getSelectedRow(), 0).toString();
			        String hoten = table.getValueAt(table.getSelectedRow(), 1).toString();
			        String ngaysinh = table.getValueAt(table.getSelectedRow(), 2).toString();
			        String diachi = table.getValueAt(table.getSelectedRow(), 3).toString();
			        String gioitinh = table.getValueAt(table.getSelectedRow(), 4).toString();
			        String benhan = table.getValueAt(table.getSelectedRow(), 5).toString();

			        jTextField_id.setText(id);
			        jTextField_ten.setText(hoten);
			        jTextField_benhAn.setText(benhan);
			        jTextField_diaChi.setText(diachi);
			        jTextField_ngaySinh.setText(ngaysinh);
			        jTextField_gioiTinh.setText(gioitinh);
			    }
			}
			
		});

		// THỰC HIỆN CÁC CÂU LỆNH SQL

		jButton_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Benhnhan bn = new Benhnhan();
				QLBN_DAO ql = new QLBN_DAO();
				
				String mabn = jTextField_id.getText();
				int maBenhNhan = Integer.valueOf(mabn);
				bn.setMaBenhNhan(maBenhNhan);
				bn.setTenBenhNhan(jTextField_ten.getText());
				bn.setDiaChi(jTextField_diaChi.getText());
				bn.setNgaySinh(jTextField_ngaySinh.getText());
				bn.setGioiTinh(jTextField_gioiTinh.getText());
				bn.setBenhAn(jTextField_benhAn.getText());

				ql.update(bn);
				
				JOptionPane.showMessageDialog(HienThiView.this, "Cập Nhật Thành Công!");
				
				loadData();

			}
		});

		jButton_del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Benhnhan bn = new Benhnhan();
				QLBN_DAO ql = new QLBN_DAO();

				String mabn = jTextField_id.getText();
				int maBenhNhan = Integer.valueOf(mabn);
				bn.setMaBenhNhan(maBenhNhan);
				bn.setTenBenhNhan(jTextField_ten.getText());
				bn.setDiaChi(jTextField_diaChi.getText());
				bn.setGioiTinh(jTextField_gioiTinh.getText());
				bn.setBenhAn(jTextField_benhAn.getText());
				bn.setNgaySinh(jTextField_ngaySinh.getText());

				int luachon = JOptionPane.showConfirmDialog(HienThiView.this, "Bạn Có Muốn Xóa Dòng Đã Chọn?");
				if(luachon == JOptionPane.YES_OPTION) {
					ql.delete(bn);
					loadData();
				}
//				ql.delete(bn);
//				loadData();
				
				jTextField_id.setText("");
				jTextField_ten.setText("");
				jTextField_benhAn.setText("");
				jTextField_diaChi.setText("");
				jTextField_gioiTinh.setText("");
				jTextField_ngaySinh.setText("");
			}
		});

		jButton_dis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				jTextField_id.setText("");
				jTextField_ten.setText("");
				jTextField_benhAn.setText("");
				jTextField_diaChi.setText("");
				jTextField_gioiTinh.setText("");
				jTextField_ngaySinh.setText("");
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				model_table.setRowCount(0);

				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();

					ResultSet rs = st.executeQuery("SELECT * FROM benhnhan");

					while (rs.next()) {
						String id = rs.getString("MaBenhNhan");
						String hoten = rs.getString("TenBenhNhan");
						String ngaysinh = rs.getString("Ngay_Sinh");
						String diachi = rs.getString("DiaChi");
						String gioitinh = rs.getString("GioiTinh");
						String benhan = rs.getString("BenhAn");

						model_table.addRow(new Object[] { id, hoten, ngaysinh, diachi, gioitinh, benhan });
					}

					st.close();
					con.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		jButton_refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				jTextField_id.setText("");
				jTextField_ten.setText("");
				jTextField_benhAn.setText("");
				jTextField_diaChi.setText("");
				jTextField_gioiTinh.setText("");
				jTextField_ngaySinh.setText("");
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				model_table.setRowCount(0);

//				try {
//
//					Class.forName("com.mysql.cj.jdbc.Driver");
//
//					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
//					Statement st = con.createStatement();
//
//					ResultSet rs = st.executeQuery("SELECT * FROM benhnhan");
//
//					while (rs.next()) {
//						String id = rs.getString("MaBenhNhan");
//						String hoten = rs.getString("TenBenhNhan");
//						String ngaysinh = rs.getString("Ngay_Sinh");
//						String diachi = rs.getString("DiaChi");
//						String gioitinh = rs.getString("GioiTinh");
//						String benhan = rs.getString("BenhAn");
//
//						model_table.addRow(new Object[] { id, hoten, ngaysinh, diachi, gioitinh, benhan });
//					}
//
//					st.close();
//					con.close();
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}

			}
		});

		jButton_sapxep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				QLBN_DAO ql = new QLBN_DAO();
				List<Benhnhan> lst = ql.getModel();

				for (Benhnhan bn : lst) {
					Object[] obj = new Object[6];
					obj[0] = bn.getMaBenhNhan();
					obj[1] = bn.getTenBenhNhan();
					obj[2] = bn.getDiaChi();
					obj[3] = bn.getNgaySinh();
					obj[4] = bn.getGioiTinh();
					obj[5] = bn.getBenhAn();

					model_table.addRow(obj);
				}
			}
		});

		this.setLayout(new BorderLayout());
		this.add(jPanel_all, BorderLayout.NORTH);
		this.add(jPanel_tb, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new HienThiView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateData() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");

            // Prepare update statement
            String updateQuery = "UPDATE benhnhan SET MaBenhNhan=?, TenBenhNhan=?, Ngay_Sinh=?, DiaChi=?, GioiTinh=?, BenhAn=? WHERE MaBenhNhan=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set parameters
            preparedStatement.setString(1, jTextField_id.getText());
            preparedStatement.setString(2, jTextField_ten.getText());
            preparedStatement.setString(3, jTextField_ngaySinh.getText());
            preparedStatement.setString(4, jTextField_diaChi.getText());
            preparedStatement.setString(5, jTextField_gioiTinh.getText());
            preparedStatement.setString(6, jTextField_benhAn.getText());
            preparedStatement.setString(7, jTextField_id.getText());

            // Execute update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data updated successfully!");
            }

            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
	
	private void loadData() {
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
        table_model.setRowCount(0);

        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");

            String selectQuery = "SELECT * FROM benhnhan";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            while (rs.next()) {
                Object[] row = {rs.getString("MaBenhNhan"),
                		        rs.getString("TenBenhNhan"),  
                		        rs.getString("Ngay_Sinh"), 
                		        rs.getString("DiaChi"), 
                		        rs.getString("GioiTinh"), 
                		        rs.getString("BenhAn")};
                table_model.addRow(row);
            }

            // Close resources
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
	
}

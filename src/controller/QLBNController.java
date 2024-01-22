package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import view.DangKiBenhAn;
import view.ThongTinBenhNhanView;
import model.QLTTBenhnhan;

public class QLBNController implements ActionListener {

	public ThongTinBenhNhanView view;
	public DangKiBenhAn dangki;
	public QLTTBenhnhan model;

	public QLBNController(ThongTinBenhNhanView view) {
		this.view = view;
	}
	
	public QLBNController(DangKiBenhAn dangki) {
		this.dangki = dangki;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();

		if (cm.equals("Thêm Mới")) {
			this.view.xoaThongTin_Xuli_Them();
		} else if (cm.equals("Lưu")) {
			try {
				this.view.themSinhVien_Xuli_Luu();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (cm.equals("Thoát")) {
			this.view.thoatChuongTrinh_Xuli_Thoat();
		}else if (cm.equals("Lập Bệnh Án")) {
			this.view.hienThiJFrame1();
		}else if  (cm.equals("Hồ Sơ Bệnh Án")) {
			this.view.hienThiJFrame2();
		}else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();
		}
	}
	
}

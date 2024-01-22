package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Hoso;

public class HSBN_DAO extends QLBN {

	public void find(Hoso hs) {
		String sqlFind = "SELECT * FROM dangki WHERE MãBệnhNhân LIKE '?%' OR HọTên LIKE '?%'";
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sqlFind); 
			
			rs.updateString(1, hs.getMaBenhNhan()+"");
			rs.updateString(2, hs.getHoTen());
			//stmt.setString(3, hs.getNgaySinh());
			//stmt.setString(4, hs.getLoaiBenh());
			//stmt.setString(5, hs.getNgayNhap());
			//stmt.setString(6, hs.getNgayXuat());
			//stmt.setString(7, hs.getLoaiDieuTri());
			
			while(rs.next()) {
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

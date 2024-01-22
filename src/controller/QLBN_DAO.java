package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import model.Benhnhan;

public class QLBN_DAO extends QLBN {

	public boolean insert(Benhnhan bn) {
		String sqlAdd = "INSERT INTO benhnhan(MaBenhNhan, TenBenhNhan, Ngay_Sinh, DiaChi, GioiTinh, BenhAn)" + " VALUES(?, ?, ?, ?, ?, ?) ";
		try {
			Connection con = getConnection();
			CallableStatement stmt = con.prepareCall(sqlAdd);

			stmt.setString(1, bn.getMaBenhNhan()+"");
			stmt.setString(2, bn.getTenBenhNhan());
			stmt.setString(3, bn.getNgaySinh());
			stmt.setString(4, bn.getDiaChi());
			stmt.setString(5, bn.getGioiTinh()+"");
			stmt.setString(6, bn.getBenhAn()+"");
			
			int i_row = stmt.executeUpdate();
			return i_row > 0;
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}
	
	public boolean update(Benhnhan bn) {
		String sqlUpdate = "UPDATE benhnhan set MaBenhNhan = ?, TenBenhNhan = ?, Ngay_Sinh = ?, DiaChi = ?, GioiTinh = ?, BenhAn = ? WHERE MaBenhNhan = ?";
		try {
			Connection con = getConnection();
			CallableStatement stmt = con.prepareCall(sqlUpdate);

			stmt.setString(1, bn.getMaBenhNhan()+"");
			stmt.setString(2, bn.getTenBenhNhan());
			stmt.setString(3, bn.getNgaySinh()+"");
			stmt.setString(4, bn.getDiaChi());
			stmt.setString(5, bn.getGioiTinh()+"");
			stmt.setString(6, bn.getBenhAn()+"");
			stmt.setString(7, bn.getMaBenhNhan()+"");
			
			int i_row = stmt.executeUpdate();
			return i_row > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public boolean delete(Benhnhan bn) {
		String sqlDelete = "DELETE FROM benhnhan WHERE MaBenhNhan = ? AND TenBenhNhan = ? AND Ngay_Sinh=? AND DiaChi=? AND GioiTinh=? AND BenhAn = ? LIMIT 1";
		try {
			Connection con = getConnection();
			CallableStatement stmt = con.prepareCall(sqlDelete);

			stmt.setString(1, bn.getMaBenhNhan()+"");
			stmt.setString(2, bn.getTenBenhNhan());
			stmt.setString(3, bn.getNgaySinh()+"");
			stmt.setString(4, bn.getDiaChi());
			stmt.setString(5, bn.getGioiTinh()+"");
			stmt.setString(6, bn.getBenhAn()+"");
			
			int i_row = stmt.executeUpdate();
			return i_row > 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Benhnhan> getModel() {
		Vector<Benhnhan> lstBN = new Vector<Benhnhan>();
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select * FROM benhnhan GROUP BY MaBenhNhan");
			
			while(rs.next()) {
				String maBenhNhan = rs.getString("MaBenhNhan");
				int maBN = Integer.valueOf(maBenhNhan);
				String tenBenhNhan = rs.getString("TenBenhNhan");
				String ngaySinh = rs.getString("Ngay_Sinh");
				String diaChi = rs.getString("DiaChi");
				String gioiTinh = rs.getString("GioiTinh");
				String benhAn = rs.getString("BenhAn");
				
				lstBN.add(new Benhnhan (maBN, tenBenhNhan, diaChi, ngaySinh, gioiTinh, benhAn));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lstBN;
	}
	
}

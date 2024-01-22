package model;

import java.util.Objects;

public class Hoso {

	private int maBenhNhan;
	private String hoTen;
	private String ngaySinh;
	private String loaiBenh;
	private String ngayNhap;
	private String ngayXuat;
	private String loaiDieuTri;
	
	public Hoso() {
		
	}

	public Hoso(int maBenhNhan, String hoTen, String ngaySinh, String loaiBenh, String ngayNhap, String ngayXuat,
			String loaiDieuTri) {
		this.maBenhNhan = maBenhNhan;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.loaiBenh = loaiBenh;
		this.ngayNhap = ngayNhap;
		this.ngayXuat = ngayXuat;
		this.loaiDieuTri = loaiDieuTri;
	}

	public int getMaBenhNhan() {
		return maBenhNhan;
	}

	public void setMaBenhNhan(int maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getLoaiBenh() {
		return loaiBenh;
	}

	public void setLoaiBenh(String loaiBenh) {
		this.loaiBenh = loaiBenh;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getLoaiDieuTri() {
		return loaiDieuTri;
	}

	public void setLoaiDieuTri(String loaiDieuTri) {
		this.loaiDieuTri = loaiDieuTri;
	}

	@Override
	public String toString() {
		return "Hoso [maBenhNhan=" + maBenhNhan + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", loaiBenh="
				+ loaiBenh + ", ngayNhap=" + ngayNhap + ", ngayXuat=" + ngayXuat + ", loaiDieuTri=" + loaiDieuTri + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoTen, loaiBenh, loaiDieuTri, maBenhNhan, ngayNhap, ngaySinh, ngayXuat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hoso other = (Hoso) obj;
		return Objects.equals(hoTen, other.hoTen) && Objects.equals(loaiBenh, other.loaiBenh)
				&& Objects.equals(loaiDieuTri, other.loaiDieuTri) && maBenhNhan == other.maBenhNhan
				&& Objects.equals(ngayNhap, other.ngayNhap) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(ngayXuat, other.ngayXuat);
	}
	
	
}

package model;

import java.util.Date;
import java.util.Objects;

public class Benhnhan {

	private int maBenhNhan;
	private String tenBenhNhan;
	private String diaChi;
	private String ngaySinh;
	private String tinh;
	private String huyen;
	private String xa;
    private String gioiTinh;
	private String benhAn;

	public Benhnhan() {

	}

	public Benhnhan(int maBenhNhan, String tenBenhNhan, String tinh, String huyen, String xa, String ngaySinh, String gioiTinh,
			String benhAn) {
		this.maBenhNhan = maBenhNhan;
		this.tenBenhNhan = tenBenhNhan;
	    this.tinh = tinh;
	    this.huyen = huyen;
	    this.xa = xa;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.benhAn = benhAn;
	}
	
	public Benhnhan(int maBenhNhan, String tenBenhNhan, String diaChi, String ngaySinh, String gioiTinh, String benhAn) {
		this.maBenhNhan = maBenhNhan;
		this.tenBenhNhan = tenBenhNhan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.benhAn = benhAn;
	}

	public int getMaBenhNhan() {
		return maBenhNhan;
	}

	public void setMaBenhNhan(int maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}

	public String getTenBenhNhan() {
		return tenBenhNhan;
	}

	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getBenhAn() {
		return benhAn;
	}

	public void setBenhAn(String benhAn) {
		this.benhAn = benhAn;
	}
	
	

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	@Override
	public String toString() {
		return "Benhnhan [maBenhNhan=" + maBenhNhan + ", tenBenhNhan=" + tenBenhNhan + ", diaChi=" + diaChi
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", benhAn=" + benhAn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(benhAn, diaChi, gioiTinh, maBenhNhan, ngaySinh, tenBenhNhan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Benhnhan other = (Benhnhan) obj;
		return benhAn == other.benhAn && Objects.equals(diaChi, other.diaChi) && gioiTinh == other.gioiTinh
				&& maBenhNhan == other.maBenhNhan && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(tenBenhNhan, other.tenBenhNhan);
	}

}

package model;

import java.util.ArrayList;

public class QLTTBenhnhan {

	private ArrayList<Benhnhan> dsBenhnhan;
	private String luaChon;

	public QLTTBenhnhan() {
		this.dsBenhnhan = new ArrayList();
	}

	public QLTTBenhnhan(ArrayList dsBenhnhan) {
		this.dsBenhnhan = dsBenhnhan;
		this.luaChon = "";
	}

	public ArrayList<Benhnhan> getDsBenhnhan() {
		return dsBenhnhan;
	}

	public void setDsBenhnhan(ArrayList<Benhnhan> dsBenhnhan) {
		this.dsBenhnhan = dsBenhnhan;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void insert(Benhnhan benhNhan) {
		this.dsBenhnhan.add(benhNhan);
	}

	public void delete(Benhnhan benhNhan) {
		this.dsBenhnhan.remove(benhNhan);
	}

	public void update(Benhnhan benhNhan) {
		this.dsBenhnhan.remove(benhNhan);
		this.dsBenhnhan.add(benhNhan);
	}

	public boolean kiemTraTonTai(Benhnhan bn) {
		for (Benhnhan benhNhan : dsBenhnhan) {
			if (benhNhan.getMaBenhNhan() == bn.getMaBenhNhan()) {
				return true;
			}
		}
		return false;
	}
}

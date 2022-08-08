package businesslogic.control;

import java.util.List;

import dao.KhachHangDao;
import model.DiaChi;
import model.KhachHang;

public class KhachHangControl {
	private KhachHangDao khachHangDao;
	public KhachHangControl() {
		khachHangDao = new KhachHangDao();
	}
	public KhachHang timKhachHangTuId(String id) {
		return khachHangDao.timKhachHangTuId(id);
	}
	public boolean themKhachHang(KhachHang kh) {
		return khachHangDao.themKhachHang(kh);
	}
	public List<KhachHang> timKhachHangBangTextSearch(String text){
		return khachHangDao.timKhachHangBangTextSearch(text);
	}
	public List<KhachHang> timKhachHang(String text, String gioiTinh, DiaChi diaChi){
		return khachHangDao.timKhachHang(text, gioiTinh, diaChi);
	}
	public List<KhachHang> layDanhSach100KhachHangMoiNhat(){
		return khachHangDao.layDanhSach100KhachHangMoiNhat();
	}
	public boolean xoaKhachHang(KhachHang kh) {
		return khachHangDao.xoaKhachHang(kh);
	}
	public boolean capNhatKhachHang(KhachHang kh) {
		return khachHangDao.capNhatKhachHang(kh);
	}




	
}

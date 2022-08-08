package businesslogic.control;

import java.util.List;

import dao.NhanVienDao;
import model.NhanVien;

public class NhanVienControl {
	private NhanVienDao nhanVienDao;
	public NhanVienControl() {
		nhanVienDao = new NhanVienDao();
	}
	public NhanVien timNhanVienTuId(String id) {
		return nhanVienDao.timNhanVienTuId(id);
	}
	public String dangNhap(String maNhanVien, String matKhau) {
		return nhanVienDao.dangNhap(maNhanVien, matKhau);
	}
	public boolean themNhanVien(NhanVien nv) {
		return nhanVienDao.themNhanVien(nv);
	}
	public boolean capNhatThongTinNhanVien(NhanVien nv) {
		return nhanVienDao.capNhatThongTinNhanVien(nv);
	}
	public List<NhanVien> layDanhSach100NhanVienMoiNhat() {
		return nhanVienDao.layDanhSach100NhanVienMoiNhat();
	}
	public List<NhanVien> timNhanVienBangTextSearch(String text) {
		return nhanVienDao.timNhanVienBangTextSearch(text);
	}
	public boolean xoaNhanVien(NhanVien kh) {
		return nhanVienDao.xoaNhanVien(kh);
	}




}	

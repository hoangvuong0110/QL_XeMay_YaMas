package businesslogic.control;

import java.util.List;

import dao.SanPhamDao;
import model.SanPham;

public class SanPhamControl {
	private SanPhamDao sanPhamDao;

	public SanPhamControl() {
		sanPhamDao = new SanPhamDao();
	}

	public SanPham timSanPhamTuId(String id) {
		return sanPhamDao.timSanPhamTuId(id);
	}

	public boolean themSanPham(SanPham kh) {
		return sanPhamDao.themSanPham(kh);
	}
	public List<SanPham> layDanhSachSanPhamMoiNhat(){
		return sanPhamDao.layDanhSachSanPhamMoiNhat();
	}
	public List<SanPham> timSanPham(String text){
		return sanPhamDao.timSanPham(text);
	}

	public List<SanPham> timSanPhamBangTextSearch(String text, String hangXe, String dongXe, String mauXe,
			String namSanXuat, String loaiXe, String mucGia) {
		return sanPhamDao.timSanPhamBangTextSearch(text, hangXe, dongXe, mauXe, namSanXuat, loaiXe, mucGia);
	}

	public List<String> layDanhSachMauXe(){
		return sanPhamDao.layDanhSachMauXe();
	}

	public List<String> layDanhSachDongXe(){
		return sanPhamDao.layDanhSachDongXe();
	}
	public List<String> layDanhSachHangSanXuat(){
		return sanPhamDao.layDanhSachHangSanXuat();
	}
	public List<String> layDanhSachNamSanXuat(){
		return sanPhamDao.layDanhSachNamSanXuat();
	}
	public List<String> layDanhSachLoaiXe() {
		return sanPhamDao.layDanhSachLoaiXe();
	}

	public boolean capNhatSanPham(SanPham sp) {
		return sanPhamDao.capNhatSanPham(sp);
	}
	public boolean xoaSanPham(SanPham sp) {
		return sanPhamDao.xoaSanPham(sp);
	}
	




	
}

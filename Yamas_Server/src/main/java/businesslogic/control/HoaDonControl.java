package businesslogic.control;

import java.util.List;

import dao.HoaDonDao;
import model.HoaDon;

public class HoaDonControl {
	private HoaDonDao HoaDonDao;
	public HoaDonControl() {
		HoaDonDao = new HoaDonDao();
	}
	public HoaDon timHoaDonTuId(int id) {
		return HoaDonDao.timHoaDonTuId(id);
	}
	public int themHoaDon(HoaDon hd) {
		return HoaDonDao.themHoaDon(hd);
	}
	public List<HoaDon> layDanhSach100HoaDonMoiNhat() {
		return HoaDonDao.layDanhSach100HoaDonMoiNhat();
	}
	public int huyHoaDon(HoaDon kh) {
		return HoaDonDao.huyHoaDon(kh);
	}
	public List<HoaDon> timHoaDonBangTextSearch(String text) {
		return HoaDonDao.timHoaDonBangTextSearch(text);
	}

		
}

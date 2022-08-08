package businesslogic.control;

import java.util.List;

import dao.DiaChiHanhChinhDao;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

public class DiaChiHanhChinhControl {
	private DiaChiHanhChinhDao diaChiHanhChinhDao;
	public DiaChiHanhChinhControl() {
		diaChiHanhChinhDao = new DiaChiHanhChinhDao();
	}
	public ThanhPho timThanhPhoTuId(String id) {
		return diaChiHanhChinhDao.timThanhPhoTuId(id);
	}
	public List<ThanhPho> layDanhSachTatCaThanhPho() {
		return diaChiHanhChinhDao.layDanhSachTatCaThanhPho();
		
	}
	public ThanhPho  timThanhPhoTheoTen(String tenTP) {
		return diaChiHanhChinhDao.timThanhPhoTheoTen(tenTP);
	}

	
	public List<Quan> layDanhSachQuanTheoThanhPho(String cityId) {
		return diaChiHanhChinhDao.layDanhSachQuanTheoThanhPho(cityId);
	}
	public Quan timQuanTheoTen(String quan, String citiesId) {
		return diaChiHanhChinhDao.timQuanTheoTen(quan,citiesId);
	}

	public List<Phuong> layDanhSachPhuongTheoQuan(String districtId) {
		return diaChiHanhChinhDao.layDanhSachPhuongTheoQuan(districtId);
	}
	public Phuong timPhuongTheoTen(String tenPhuong, String maQuan) {
		return diaChiHanhChinhDao.timPhuongTheoTen(tenPhuong,maQuan);
	}

}

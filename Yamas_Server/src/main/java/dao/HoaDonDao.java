package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import config.MySessionFactory;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.SanPham;

public class HoaDonDao {
	private OgmSessionFactory sessionFactory;
	SanPhamDao sanPhamDao;
	public HoaDonDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
		sanPhamDao = new SanPhamDao();
	}

	public HoaDon timHoaDonTuId(int id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		HoaDon hd = null;
		try {
			tr.begin();

			hd = session.find(HoaDon.class, id);

			tr.commit();
			return hd;

		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
		return hd;
	}
	public List<HoaDon> timHoaDonTuMaKhachHang(String maKhachHang) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String query = "db.HoaDon.find({'maKhachHang': '"+maKhachHang+"'})";
			System.out.println(query);
			list = session.createNativeQuery(query, HoaDon.class).getResultList();
			System.out.println(list.size());
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<HoaDon> timHoaDonTuMaNhanVien(String maNhanVien) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String query = "db.HoaDon.find({'maNhanVien': '"+maNhanVien+"'})";
			System.out.println(query);
			list = session.createNativeQuery(query, HoaDon.class).getResultList();
			System.out.println(list.size());
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public int themHoaDon(HoaDon kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<ChiTietHoaDon> dsCTHD = kh.getChiTietHoaDon();
		try {
			tr.begin();

			session.save(kh);
			System.out.println(kh.getMaHoaDon());
			tr.commit();
			for (int i = 0; i < dsCTHD.size(); i++) {
				ChiTietHoaDon cthd = dsCTHD.get(i);
				
				SanPham sp = cthd.getSanPham();
				sp.setSoLuongTonKho(sp.getSoLuongTonKho() - cthd.getSoLuong());
				if(sp.getSoLuongTonKho() <= 0) sp.setTrangThai("Hết hàng");
				if(sp.getSoLuongTonKho() <= 20 && sp.getSoLuongTonKho()>0) sp.setTrangThai("Sắp hết hàng");
				sp.setSoLuongDaBan(sp.getSoLuongDaBan()+cthd.getSoLuong());
				sanPhamDao.capNhatSanPham(sp);
			}
			return kh.getMaHoaDon();

		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
		return -1;
	}
	public int huyHoaDon(HoaDon kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if(kh.getTrangThai().equals("Đã huỷ")) return 0;
		List<ChiTietHoaDon> dsCTHD = kh.getChiTietHoaDon();
		try {
			tr.begin();
			kh.setTrangThai("Đã huỷ");
//			kh.setThoiGian(new Date());
			session.update(kh);
			tr.commit();
			for (int i = 0; i < dsCTHD.size(); i++) {
				ChiTietHoaDon cthd = dsCTHD.get(i);
				
				SanPham sp = cthd.getSanPham();
				sp.setSoLuongTonKho(sp.getSoLuongTonKho() + cthd.getSoLuong());
				if(sp.getSoLuongTonKho() <= 0) sp.setTrangThai("Hết hàng");
				if(sp.getSoLuongTonKho() <= 20 && sp.getSoLuongTonKho()>0) sp.setTrangThai("Sắp hết hàng");
				sp.setSoLuongDaBan(sp.getSoLuongDaBan() - cthd.getSoLuong());
				sanPhamDao.capNhatSanPham(sp);
			}
			return kh.getMaHoaDon();

		} catch (Exception e) {

			e.printStackTrace();

			tr.rollback();
			return -1;

		}
	}
	public List<HoaDon> layDanhSach100HoaDonMoiNhat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String query = "db.HoaDon.aggregate([{'$sort':{'_id': -1}},{'$limit': 100}])";
			System.out.println(query);
			list = session.createNativeQuery(query, HoaDon.class).getResultList();
			System.out.println(list.size());
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<HoaDon> timHoaDonBangTextSearch(String text) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			tr.begin();
			String query = "db.HoaDon.find( { $text: { $search: '" + text + "' } } ).sort({_id:-1})";
			list = session.createNativeQuery(query, HoaDon.class).getResultList();

			tr.commit();
			if(list.size()==0 || list== null) {
				try {
					int textSearchInMaHD = Integer.parseInt(text);
					tr.begin();
					 query = "db.HoaDon.find( { _id: "+textSearchInMaHD+" } ).sort({_id:-1})";
					 System.out.println(query);
					list = session.createNativeQuery(query, HoaDon.class).getResultList();

					tr.commit();
					return list;
				} catch (Exception e) {
					
				}
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	

	
	

}

package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import config.MySessionFactory;
import model.DiaChi;
import model.HoaDon;
import model.KhachHang;

public class KhachHangDao {
	private OgmSessionFactory sessionFactory;
	private HoaDonDao hoaDonDao;

	public KhachHangDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
		hoaDonDao = new HoaDonDao();
	}

	public KhachHang timKhachHangTuId(String id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		KhachHang kh = null;
		try {
			tr.begin();

			kh = session.find(KhachHang.class, id);

			tr.commit();
			return kh;

		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
		return kh;
	}

	public boolean themKhachHang(KhachHang kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			session.save(KhachHang.class.toString(), kh);

			tr.commit();
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
		return true;
	}
	public boolean capNhatKhachHang(KhachHang kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			session.update(KhachHang.class.toString(), kh);

			tr.commit();
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	

	public boolean xoaKhachHang(KhachHang kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> dsHoaDon = hoaDonDao.timHoaDonTuMaKhachHang(kh.getCmnd());
		
		try {
			if(dsHoaDon.size()==0) {
				tr.begin();

				session.delete(kh);

				tr.commit();
				return true;
			}
			else return false;
			

		} catch (Exception e) {
			
			e.printStackTrace();
			tr.rollback();

			return false;

		}
	}

	public List<KhachHang> timKhachHangBangTextSearch(String text) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			tr.begin();
			String query = "  db.KhachHang.find( { $text: { $search: '\"" + text + "\"' } } ).sort({ngayTao:-1})";
			list = session.createNativeQuery(query, KhachHang.class).getResultList();

			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<KhachHang> layDanhSach100KhachHangMoiNhat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> list = new ArrayList<KhachHang>();
		try {
			tr.begin();
			String query = "db.KhachHang.aggregate([{'$sort':{'ngayTao': -1}},{'$limit': 100}])";
			System.out.println(query);
			list = session.createNativeQuery(query, KhachHang.class).getResultList();
			System.out.println(list.size());
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	/**
	 * 
	 * @param text
	 * @return Danh sách khách hàng sau khi lọc
	 */
//	db.KhachHang.aggregate([{$match:{$text:{$search:"Nguyen"}}},{$match:{gioiTinh:'Nữ','diaChi.thanhPho':'Tỉnh Hưng Yên'}}])
	public List<KhachHang> timKhachHang(String text, String gioiTinh, DiaChi diaChi) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> list = new ArrayList<KhachHang>();

		try {
			String thanhPho = ",'diaChi.thanhPho':'" + diaChi.getThanhPho() + "'";
			String quan = ",'diaChi.quan':'" + diaChi.getQuan() + "'";
			String phuong = ",'diaChi.phuong':'" + diaChi.getPhuong() + "'";
			if (diaChi.getThanhPho().equals("Tất cả"))
				thanhPho = "";
			if (diaChi.getQuan().equals("Tất cả"))
				quan = "";
			if (diaChi.getPhuong().equals("Tất cả"))
				phuong = "";
			switch (gioiTinh) {
			case "Tất cả":
				gioiTinh = "";
				break;
			case "Nam":
				gioiTinh = ",'gioiTinh':'Nam'";
				break;
			case "Nữ":
				gioiTinh = ",'gioiTinh':'Nữ'";
				break;

			default:
				break;
			}
			tr.begin();
			String query = "db.KhachHang.aggregate([{'$match':{'$text':{'$search':'" + text + "'}" + gioiTinh + thanhPho
					+ quan + phuong + "}}])";
			list = session.createNativeQuery(query, KhachHang.class).getResultList();
			System.out.println(query);
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

}

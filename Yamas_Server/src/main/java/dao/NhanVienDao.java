package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import config.MySessionFactory;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.NhanVien;

public class NhanVienDao {
	private OgmSessionFactory sessionFactory;
	private HoaDonDao hoaDonDao;
	public NhanVienDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
		hoaDonDao = new HoaDonDao();
	}
	public NhanVien timNhanVienTuId(String id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		NhanVien nv = null;
		try {
			tr.begin();
			
			 nv = session.find(NhanVien.class, id);
			 System.out.println(nv);
			tr.commit();
			return nv;

		} catch (Exception e) {
			
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean themNhanVien(NhanVien nv) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		NhanVien nvMoiNhat = layNhanVienMoiNhat().get(0);
		
		String maNV = nvMoiNhat.getMaNhanVien().replace("NV", "");
		int maNVInt = Integer.parseInt(maNV)+1;
		nv.setMaNhanVien("NV"+maNVInt);
		System.out.println(nv.getMaNhanVien());
		try {
			tr.begin();
			
			 session.save(nv);
		
			tr.commit();
			return true;

		} catch (Exception e) {
			
			e.printStackTrace();
			tr.rollback();
			return false;

		}
	}
	public boolean capNhatThongTinNhanVien(NhanVien nv) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			session.update(nv);
		
			tr.commit();
			return true;

		} catch (Exception e) {
			
			e.printStackTrace();
			tr.rollback();
			return false;

		}
	}
	public String dangNhap(String maNhanVien, String matKhau) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		NhanVien nv = null;
		try {
			tr.begin();
			
			 nv = session.find(NhanVien.class, maNhanVien);
			 if(nv!=null) {
				 if(nv.getTrangThai().equals("Đã nghỉ việc")) return "Đã nghỉ việc";
			 if(nv.getMatKhau().equals(matKhau)) {
				 if(nv.getChucVu().equals("QL")) return "QL";
				 else return "NV";
			 }
			 else {
				 return "Mật khẩu không đúng!";
				 
			 }
			}
			 else return "Tài khoản không tồn tại";
			

		} catch (Exception e) {
			
			 return "Tài khoản không tồn tại";
		}
	}
	public List<NhanVien> layDanhSach100NhanVienMoiNhat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String query = "db.NhanVien.aggregate([{'$sort':{'ngayTao': -1}},{'$limit': 100}])";
			System.out.println(query);
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<NhanVien> layNhanVienMoiNhat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String query = "db.NhanVien.aggregate([{'$sort': {'_id':-1}},{'$limit':1}])";
			System.out.println(query);
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<NhanVien> timNhanVienBangTextSearch(String text) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			tr.begin();
			String query = "db.NhanVien.find( { $text: { $search: '" + text + "' } } ).sort({ngayTao:-1})";
			list = session.createNativeQuery(query, NhanVien.class).getResultList();
			System.out.println(query);
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public boolean xoaNhanVien(NhanVien kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> dsHoaDon = hoaDonDao.timHoaDonTuMaNhanVien(kh.getMaNhanVien());
		
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

}

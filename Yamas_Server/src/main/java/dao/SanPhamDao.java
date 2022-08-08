package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import config.MySessionFactory;
import model.SanPham;

public class SanPhamDao {
	private OgmSessionFactory sessionFactory;

	public SanPhamDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
	}

	public SanPham timSanPhamTuId(String id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		SanPham kh = null;
		try {
			tr.begin();

			kh = session.find(SanPham.class, id);

			tr.commit();
			return kh;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return kh;
	}

	
	public boolean themSanPham(SanPham kh) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();

			session.save(SanPham.class.toString(), kh);

			tr.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return true;
	}
	public boolean capNhatSanPham(SanPham sp) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if(sp.getTrangThai().equals("Ngừng kinh doanh")==false) {
			if(sp.getSoLuongTonKho() <= 0) sp.setTrangThai("Hết hàng");
			if(sp.getSoLuongTonKho() <= 20 && sp.getSoLuongTonKho()>0) sp.setTrangThai("Sắp hết hàng");
			if(sp.getSoLuongTonKho() >20) sp.setTrangThai("Đang bán");
		}
		
		try {
			tr.begin();

			session.update(sp);

			tr.commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return true;
	}
	public boolean xoaSanPham(SanPham sp) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		System.out.println(sp.getSoLuongDaBan());
		if(sp.getSoLuongDaBan()>0) return false;
		else {
			try {
				tr.begin();

				session.delete(sp);

				tr.commit();
				return true;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				tr.rollback();

			}
		}
		
		return false;

	}
	public List<SanPham> layDanhSachSanPhamMoiNhat(){
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> dsNam = layDanhSachNamSanXuat();
		String nam = dsNam.get(dsNam.size()-1);
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate( [ { '$match': { 'namSanXuat': "+nam+"} },{'$sort':{'soLuongDaBan': -1}} ] )";
			System.out.println(query);
			list = session.createNativeQuery(query, SanPham.class).getResultList();

			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<SanPham> timSanPham(String text){
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate( [ { '$match': { '$text': { '$search': '"+text+"' } } } ] )";
			System.out.println(query);
			list = session.createNativeQuery(query, SanPham.class).getResultList();

			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
//	db.SanPham.createIndex( { _id: "text", sdt: "text" ,ten:"text"} )
	public List<SanPham> timSanPhamBangTextSearch(String text, String hangXe, String dongXe, String mauXe,
			String namSanXuat, String loaiXe, String mucGia) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<SanPham> list = new ArrayList<SanPham>();
		String hangXeQuery ="";
		String dongXeQuery="";
		String mauXeQuery="";
		String namSanXuatQuery="";
		String loaiXeQuery="";
		String mucGiaQuery = "";
		Double from = 0.0;
		Double to = 0.0;
		
		if(hangXe.equals("Tất cả")==false) hangXeQuery=", 'hangSanXuat':'"+ hangXe+"'"; 
		if(dongXe.equals("Tất cả")==false) dongXeQuery=", 'dongXe':'"+ dongXe+"'"; 
		if(mauXe.equals("Tất cả")==false) mauXeQuery=", 'mauXe':'"+ mauXe+"'"; 
		if(namSanXuat.equals("Tất cả")==false) namSanXuatQuery=", 'namSanXuat':"+ namSanXuat; 
		if(loaiXe.equals("Tất cả")==false) loaiXeQuery=", 'loaiXe':'"+ loaiXe+"'"; 
		switch (mucGia) {
		case "Tất cả":

			break;
		case "Dưới 10 triệu VNĐ":
			from = 0.00;
			to = 10000000.00;
			mucGiaQuery= " ,'giaBan':{'$gte': "+from+", '$lte':"+to+"}";
			break;
		case "10 triệu - 20 triệu VNĐ":
			from = 10000000.00;
			to = 20000000.00;
			mucGiaQuery= " ,'giaBan':{'$gte': "+from+", '$lte':"+to+"}";
			break;
		case "20 triệu - 40 triệu VNĐ":
			from = 20000000.00;
			to = 40000000.00;
			mucGiaQuery= " ,'giaBan':{'$gte': "+from+", '$lte':"+to+"}";
			break;
		case "40 triệu - 100 triệu VNĐ":
			from = 40000000.00;
			to = 100000000.00;
			mucGiaQuery= " ,'giaBan':{'$gte': "+from+", '$lte':"+to+"}";
			break;
		case "Trên 100 triệu VNĐ":
			from = 100000000.00;
			
			mucGiaQuery= " ,'giaBan':{'$gte': "+from+"}";

			break;

		default:
			break;
		}
		try {
			tr.begin();
			
			String query = " db.SanPham.aggregate([ { '$match': { '$text': { '$search': '" + text +"'}"+loaiXeQuery+ hangXeQuery+ dongXeQuery+namSanXuatQuery+mauXeQuery
					 + mucGiaQuery +"} }])";
			if(text.equals("")) {
				query = " db.SanPham.aggregate([ { '$match': { "+loaiXeQuery+ hangXeQuery+ dongXeQuery+namSanXuatQuery+mauXeQuery
						 + mucGiaQuery +"} }])";
				query = query.replaceFirst("[,]", "");
				
			}
					
			System.out.println(query);
			list = session.createNativeQuery(query, SanPham.class).getResultList();

			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<String> layDanhSachMauXe() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> listStr = new ArrayList<String>();
		try {
			tr.begin();
			String query = " db.SanPham.aggregate([{'$group':{'_id':'$mauXe'}},{'$sort':{'_id':1}}])";
			System.out.println(query);
			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object o : list) {

				listStr.add(o.toString());

			}
			tr.commit();
			return listStr;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<String> layDanhSachDongXe() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> listStr = new ArrayList<String>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate([{'$group':{'_id':'$dongXe'}},{'$sort':{'_id':1}}])";

			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object o : list) {
				listStr.add(o.toString());
			}
			tr.commit();
			return listStr;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<String> layDanhSachHangSanXuat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> listStr = new ArrayList<String>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate([{'$group':{'_id':'$hangSanXuat'}},{'$sort':{'_id':1}}])";

			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object o : list) {
				listStr.add(o.toString());
			}
			tr.commit();
			return listStr;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<String> layDanhSachNamSanXuat() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> listStr = new ArrayList<String>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate([{'$group':{'_id':'$namSanXuat'}},{'$sort':{'_id':1}}])";

			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object o : list) {
				listStr.add(o.toString());
			}
			tr.commit();
			return listStr;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<String> layDanhSachLoaiXe() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<String> listStr = new ArrayList<String>();
		try {
			tr.begin();
			String query = "db.SanPham.aggregate([{'$group':{'_id':'$loaiXe'}},{'$sort':{'_id':1}}])";

			List<?> list = session.createNativeQuery(query).getResultList();
			for (Object o : list) {
				listStr.add(o.toString());
			}
			tr.commit();
			return listStr;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}

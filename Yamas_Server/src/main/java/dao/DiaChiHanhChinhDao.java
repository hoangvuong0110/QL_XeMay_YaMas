package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import config.MySessionFactory;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

public class DiaChiHanhChinhDao {
	private OgmSessionFactory sessionFactory;
	public DiaChiHanhChinhDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
	}
	public ThanhPho timThanhPhoTuId(String id) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		ThanhPho tp = null;
		try {
			tr.begin();
			
			 tp = session.find(ThanhPho.class, id);
		
			tr.commit();
			return tp;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<ThanhPho> layDanhSachTatCaThanhPho() {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<ThanhPho> list = new ArrayList<ThanhPho>();
		try {
			tr.begin();
			String query = "db.ThanhPho.find({})";
			list =  session.createNativeQuery(query, ThanhPho.class).getResultList();
			System.out.println(query);
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public ThanhPho timThanhPhoTheoTen(String tenTP) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<ThanhPho> list = new ArrayList<>();
		try {
			tr.begin();
			String query = " db.ThanhPho.find({'nameWithType':'"+tenTP+"'})";
			list = session.createNativeQuery(query, ThanhPho.class).getResultList();
			return list.get(0);
		
			

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<Quan> layDanhSachQuanTheoThanhPho(String cityId) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Quan> list = new ArrayList<Quan>();
		try {
			tr.begin();
			String query = "db.Quan.find({citiesId:'"+cityId+"'})";
			list =  session.createNativeQuery(query, Quan.class).getResultList();
		
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public Quan timQuanTheoTen(String quan,String citiesId) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Quan> list = new ArrayList<>();
		try {
			tr.begin();
			String query = " db.Quan.find({'nameWithType':'"+quan+"','citiesId':'"+citiesId+"'})";
			list = session.createNativeQuery(query, Quan.class).getResultList();
			return list.get(0);
		
			

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public List<Phuong> layDanhSachPhuongTheoQuan(String districtId) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Phuong> list = new ArrayList<Phuong>();
		try {
			tr.begin();
			String query = "db.Phuong.find({districtId:'"+districtId+"'})";
			list =  session.createNativeQuery(query, Phuong.class).getResultList();
		
			tr.commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public Phuong timPhuongTheoTen(String tenPhuong,String maQuan) {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<Phuong> list = new ArrayList<>();
		try {
			tr.begin();
			String query = " db.Phuong.find({'nameWithType':'"+tenPhuong+"','districtId':'"+maQuan+"'})";
			list = session.createNativeQuery(query, Phuong.class).getResultList();
			return list.get(0);
		
			

		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}


}

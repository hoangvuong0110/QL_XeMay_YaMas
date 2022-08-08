
package config;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;

public class MySessionFactory {
	
	private static MySessionFactory instance = null;
	private OgmSessionFactory sessionFactory;
	
	private MySessionFactory() {
		 StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.applySetting(OgmProperties.ENABLED, true)
					.configure()
					.build();
			 
			 Metadata meta = new MetadataSources(registry)
					 .addAnnotatedClass(model.KhachHang.class)
					 .addAnnotatedClass(model.HoaDon.class)
					 .addAnnotatedClass(model.ChiTietHoaDon.class)
					 .addAnnotatedClass(model.SanPham.class)
					 .addAnnotatedClass(model.KhachHang.class)
					 .addAnnotatedClass(model.NhanVien.class)
					 .addAnnotatedClass(model.DiaChi.class)
					 .addAnnotatedClass(model.addressVn.ThanhPho.class)
					 .addAnnotatedClass(model.addressVn.Phuong.class)
					 .addAnnotatedClass(model.addressVn.Quan.class)
					 
					 .getMetadataBuilder()
					 .build();
			 
			 sessionFactory = meta.getSessionFactoryBuilder()
					 .unwrap(OgmSessionFactoryBuilder.class)
					 .build();
	}
	
	public synchronized static MySessionFactory getInstance() {
		if(instance == null)
			instance = new MySessionFactory();
		return instance;
	}
	
	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void close() {
		sessionFactory.close();
	}
}

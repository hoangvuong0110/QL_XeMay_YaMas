package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import businesslogic.facade.DiaChiHanhChinhFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.SanPhamFacade;
import businesslogic.impl.DiaChiHanhChinhImpl;
import businesslogic.impl.HoaDonImpl;
import businesslogic.impl.KhachHangImpl;
import businesslogic.impl.NhanVienImpl;
import businesslogic.impl.SanPhamImpl;

public class Server {

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();

		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			LocateRegistry.createRegistry(2000);
			KhachHangFacade khachHangFacade = new KhachHangImpl();
			NhanVienFacade nhanVienFacade = new NhanVienImpl();
			DiaChiHanhChinhFacade diaChiHanhChinhFacade = new DiaChiHanhChinhImpl();
			HoaDonFacade hoaDonFacade = new HoaDonImpl();
			SanPhamFacade sanPhamFacade = new SanPhamImpl();
			Naming.bind("rmi://DESKTOP-VGO7GBM:2000/khachHangFacade", khachHangFacade);
			Naming.bind("rmi://DESKTOP-VGO7GBM:2000/nhanVienFacade", nhanVienFacade);
			Naming.bind("rmi://DESKTOP-VGO7GBM:2000/diaChiHanhChinhFacade", diaChiHanhChinhFacade);
			Naming.bind("rmi://DESKTOP-VGO7GBM:2000/hoaDonFacade", hoaDonFacade);
			Naming.bind("rmi://DESKTOP-VGO7GBM:2000/sanPhamFacade", sanPhamFacade);
			
			System.out.println("=======================================");
			System.out.println("Server is started at port 2000!");
			System.out.println("=======================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

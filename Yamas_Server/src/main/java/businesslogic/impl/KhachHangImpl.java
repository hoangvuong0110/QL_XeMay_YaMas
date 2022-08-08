package businesslogic.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import businesslogic.control.KhachHangControl;
import businesslogic.facade.KhachHangFacade;
import model.DiaChi;
import model.KhachHang;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6386329661609721513L;
	private KhachHangControl khachHangControl;
	public KhachHangImpl() throws RemoteException {
		super();
		khachHangControl = new KhachHangControl();
	}

	public KhachHang timKhachHangTuId(String id) throws RemoteException {
		
		return khachHangControl.timKhachHangTuId(id);
	}

	public boolean themKhachHang(KhachHang kh) throws RemoteException {
		
		return khachHangControl.themKhachHang(kh);
	}

	public List<KhachHang> timKhachHangBangTextSearch(String text) throws RemoteException {
		
		return khachHangControl.timKhachHangBangTextSearch(text);
	}

	@Override
	public List<KhachHang> timKhachHang(String text, String gioiTinh, DiaChi diaChi) throws RemoteException {
		
		return khachHangControl.timKhachHang(text, gioiTinh, diaChi);
	}

	@Override
	public List<KhachHang> layDanhSach100KhachHangMoiNhat() throws RemoteException {
		
		return khachHangControl.layDanhSach100KhachHangMoiNhat();
	}

	@Override
	public boolean xoaKhachHang(KhachHang kh) throws RemoteException {
		
		return khachHangControl.xoaKhachHang(kh);
	}

	@Override
	public boolean capNhatKhachHang(KhachHang kh) throws RemoteException {
		
		return khachHangControl.capNhatKhachHang(kh);
	}

}

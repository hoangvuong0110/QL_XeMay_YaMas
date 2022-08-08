package businesslogic.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import businesslogic.control.NhanVienControl;
import businesslogic.facade.NhanVienFacade;
import model.KhachHang;
import model.NhanVien;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8724704256466680802L;
	NhanVienControl nhanVienControl;
	public NhanVienImpl() throws RemoteException {
		super();
		nhanVienControl = new NhanVienControl();
	}

	public String dangNhap(String maNhanVien, String matKhau) throws RemoteException {
		return nhanVienControl.dangNhap(maNhanVien, matKhau);
	}

	public NhanVien timNhanVienTuId(String id) throws RemoteException {

		return nhanVienControl.timNhanVienTuId(id);
	}

	@Override
	public boolean themNhanVien(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienControl.themNhanVien(nv);
	}

	@Override
	public boolean capNhatThongTinNhanVien(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienControl.capNhatThongTinNhanVien(nv);
	}

	@Override
	public List<NhanVien> layDanhSach100NhanVienMoiNhat() throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienControl.layDanhSach100NhanVienMoiNhat();
	}

	@Override
	public List<NhanVien> timNhanVienBangTextSearch(String text) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienControl.timNhanVienBangTextSearch(text);
	}

	@Override
	public boolean xoaNhanVien(NhanVien kh) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienControl.xoaNhanVien(kh);
	}

	

}

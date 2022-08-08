package businesslogic.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import businesslogic.control.SanPhamControl;
import businesslogic.facade.SanPhamFacade;
import model.SanPham;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamFacade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6386329661609721513L;
	private SanPhamControl sanPhamControl;
	public SanPhamImpl() throws RemoteException {
		super();
		sanPhamControl = new SanPhamControl();
	}

	public SanPham timSanPhamTuId(String id) throws RemoteException {
		
		return sanPhamControl.timSanPhamTuId(id);
	}

	public boolean themSanPham(SanPham kh) throws RemoteException {
		
		return sanPhamControl.themSanPham(kh);
	}

	

	@Override
	public List<String> layDanhSachMauXe() throws RemoteException {
		
		return sanPhamControl.layDanhSachMauXe();
	}

	@Override
	public List<String> layDanhSachDongXe() throws RemoteException {
		
		return sanPhamControl.layDanhSachDongXe();
	}

	@Override
	public List<String> layDanhSachHangSanXuat() throws RemoteException {
		
		return sanPhamControl.layDanhSachHangSanXuat();
	}

	@Override
	public List<String> layDanhSachNamSanXuat() throws RemoteException {

		return sanPhamControl.layDanhSachNamSanXuat();
	}

	@Override
	public List<String> layDanhSachLoaiXe() throws RemoteException {

		return sanPhamControl.layDanhSachLoaiXe();
	}

	@Override
	public List<SanPham> timSanPhamBangTextSearch(String text, String hangXe, String dongXe, String mauXe,
			String namSanXuat, String loaiXe, String mucGia) throws RemoteException {
		// TODO Auto-generated method stub
		return sanPhamControl.timSanPhamBangTextSearch(text, hangXe, dongXe, mauXe, namSanXuat, loaiXe, mucGia);
	}

	@Override
	public List<SanPham> layDanhSachSanPhamMoiNhat() throws RemoteException {
		// TODO Auto-generated method stub
		return sanPhamControl.layDanhSachSanPhamMoiNhat();
	}

	@Override
	public List<SanPham> timSanPham(String text) throws RemoteException {
		// TODO Auto-generated method stub
		return sanPhamControl.timSanPham(text);
	}

	@Override
	public boolean capNhatSanPham(SanPham sp) throws RemoteException {
		// TODO Auto-generated method stub
		return sanPhamControl.capNhatSanPham(sp);
	}

	@Override
	public boolean xoaSanPham(SanPham sp) throws RemoteException {
		// TODO Auto-generated method stub
		return sanPhamControl.xoaSanPham(sp);
	}
	

}

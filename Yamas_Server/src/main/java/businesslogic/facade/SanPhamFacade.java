package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.SanPham;

public interface SanPhamFacade extends Remote {
	public SanPham timSanPhamTuId(String id) throws RemoteException;

	public boolean themSanPham(SanPham kh) throws RemoteException;

	public List<SanPham> timSanPhamBangTextSearch(String text, String hangXe, String dongXe, String mauXe,
			String namSanXuat, String loaiXe, String mucGia)  throws RemoteException;
	public List<String> layDanhSachMauXe() throws RemoteException;

	public List<String> layDanhSachDongXe() throws RemoteException;
	public List<String> layDanhSachHangSanXuat() throws RemoteException;
	public List<String> layDanhSachNamSanXuat() throws RemoteException;
	public List<String> layDanhSachLoaiXe() throws RemoteException;
	public List<SanPham> layDanhSachSanPhamMoiNhat() throws RemoteException;
	public List<SanPham> timSanPham(String text) throws RemoteException;
	public boolean capNhatSanPham(SanPham sp) throws RemoteException;
	public boolean xoaSanPham(SanPham sp) throws RemoteException;

}

package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.DiaChi;
import model.KhachHang;

public interface KhachHangFacade extends Remote {
	public KhachHang timKhachHangTuId(String id) throws RemoteException;
	public boolean themKhachHang(KhachHang kh) throws RemoteException;
	public List<KhachHang> timKhachHangBangTextSearch(String text) throws RemoteException;
	public List<KhachHang> timKhachHang(String text, String gioiTinh, DiaChi diaChi) throws RemoteException;
	public List<KhachHang> layDanhSach100KhachHangMoiNhat() throws RemoteException;
	public boolean xoaKhachHang(KhachHang kh) throws RemoteException;
	public boolean capNhatKhachHang(KhachHang kh) throws RemoteException;



}

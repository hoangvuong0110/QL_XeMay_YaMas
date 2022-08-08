package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.KhachHang;
import model.NhanVien;

public interface NhanVienFacade extends Remote {
	public String dangNhap(String maNhanVien, String matKhau) throws RemoteException;
	public NhanVien timNhanVienTuId(String id) throws RemoteException;
	public boolean themNhanVien(NhanVien nv) throws RemoteException;
	public boolean capNhatThongTinNhanVien(NhanVien nv) throws RemoteException;
	public List<NhanVien> layDanhSach100NhanVienMoiNhat()  throws RemoteException;
	public List<NhanVien> timNhanVienBangTextSearch(String text) throws RemoteException;
	public boolean xoaNhanVien(NhanVien kh) throws RemoteException;

}

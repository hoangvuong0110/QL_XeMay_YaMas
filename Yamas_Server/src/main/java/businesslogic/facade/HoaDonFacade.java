package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.HoaDon;

public interface HoaDonFacade extends Remote{
	public HoaDon timHoaDonTuId(int id) throws RemoteException;
	public int themHoaDon(HoaDon kh) throws RemoteException;
	public List<HoaDon> layDanhSach100HoaDonMoiNhat() throws RemoteException;
	public int huyHoaDon(HoaDon kh) throws RemoteException;
	public List<HoaDon> timHoaDonBangTextSearch(String text) throws RemoteException;

}

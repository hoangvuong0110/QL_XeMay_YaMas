package businesslogic.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;


public interface DiaChiHanhChinhFacade extends Remote {
	public ThanhPho timThanhPhoTuId(String id) throws RemoteException;
	public List<ThanhPho> layDanhSachTatCaThanhPho() throws RemoteException;
	public ThanhPho  timThanhPhoTheoTen(String tenTP) throws RemoteException;

	public List<Quan> layDanhSachQuanTheoThanhPho(String cityId) throws RemoteException;
	public Quan timQuanTheoTen(String tenQuan,String maTP) throws RemoteException;
			
	public List<Phuong> layDanhSachPhuongTheoQuan(String districtId) throws RemoteException;

	public Phuong timPhuongTheoTen(String tenPhuong,String maQuan) throws RemoteException;

}

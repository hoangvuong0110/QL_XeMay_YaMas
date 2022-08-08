package businesslogic.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import businesslogic.control.DiaChiHanhChinhControl;
import businesslogic.facade.DiaChiHanhChinhFacade;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

public class DiaChiHanhChinhImpl extends UnicastRemoteObject implements DiaChiHanhChinhFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8724704256466680802L;
	DiaChiHanhChinhControl diaChiHanhChinhControl;
	public DiaChiHanhChinhImpl() throws RemoteException {
		super();
		diaChiHanhChinhControl = new DiaChiHanhChinhControl();
	}

	public ThanhPho timThanhPhoTuId(String id) throws RemoteException {
		return diaChiHanhChinhControl.timThanhPhoTuId(id);
	}

	public List<ThanhPho> layDanhSachTatCaThanhPho() throws RemoteException {
		
		return diaChiHanhChinhControl.layDanhSachTatCaThanhPho();
	}

	public List<Quan> layDanhSachQuanTheoThanhPho(String cityId) throws RemoteException {
		
		return diaChiHanhChinhControl.layDanhSachQuanTheoThanhPho(cityId);
	}

	public List<Phuong> layDanhSachPhuongTheoQuan(String districtId) throws RemoteException {
		
		return diaChiHanhChinhControl.layDanhSachPhuongTheoQuan(districtId);
	}

	@Override
	public ThanhPho timThanhPhoTheoTen(String tenTP) throws RemoteException {
		// TODO Auto-generated method stub
		return diaChiHanhChinhControl.timThanhPhoTheoTen(tenTP);
	}

	@Override
	public Quan timQuanTheoTen(String tenQuan,String maTP) throws RemoteException {
		// TODO Auto-generated method stub
		return diaChiHanhChinhControl.timQuanTheoTen(tenQuan,maTP);
	}

	@Override
	public Phuong timPhuongTheoTen(String tenPhuong,String maQuan) throws RemoteException {
		// TODO Auto-generated method stub
		return diaChiHanhChinhControl.timPhuongTheoTen(tenPhuong,maQuan);
	}
	

}

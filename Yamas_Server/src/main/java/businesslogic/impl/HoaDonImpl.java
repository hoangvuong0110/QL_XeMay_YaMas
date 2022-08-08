package businesslogic.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import businesslogic.control.HoaDonControl;
import businesslogic.facade.HoaDonFacade;
import model.HoaDon;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2523047178950183499L;
	private HoaDonControl hoaDonControl;
	public HoaDonImpl() throws RemoteException {
		super();
		hoaDonControl = new HoaDonControl();
	}

	@Override
	public HoaDon timHoaDonTuId(int id) throws RemoteException {
		
		return hoaDonControl.timHoaDonTuId(id);
	}

	@Override
	public int themHoaDon(HoaDon kh) throws RemoteException {
		
		return hoaDonControl.themHoaDon(kh);
	}

	@Override
	public List<HoaDon> layDanhSach100HoaDonMoiNhat() throws RemoteException {
		
		return hoaDonControl.layDanhSach100HoaDonMoiNhat();
	}

	@Override
	public int huyHoaDon(HoaDon kh) throws RemoteException {
		
		return hoaDonControl.huyHoaDon(kh);
	}

	@Override
	public List<HoaDon> timHoaDonBangTextSearch(String text) throws RemoteException {
		// TODO Auto-generated method stub
		return hoaDonControl.timHoaDonBangTextSearch(text);
	}

}

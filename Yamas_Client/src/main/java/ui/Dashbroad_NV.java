package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.NhanVien;

public class Dashbroad_NV extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contain;
	private JMenuItem mntmQuayLai;

	public Dashbroad_NV(NhanVien nv) {
		try {
		     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
		 
		    } 
		catch (Exception e) 
		{
		      e.printStackTrace();
		    }
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setTitle("Nhân viên");
		//setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contain = this.getContentPane();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("Hệ thống"); menuBar.add(mnHeThong);
		
			JMenuItem mntmThoat = new JMenuItem("Thoát phần mềm"); mnHeThong.add(mntmThoat);
			 mntmQuayLai = new JMenuItem("Đăng xuất"); mnHeThong.add(mntmQuayLai);
			mntmQuayLai.addActionListener(this);
			
			
			mntmThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int hoiNhac = JOptionPane.showConfirmDialog(contain, "Bạn có muốn thoát phần mềm không?","Có", JOptionPane.YES_NO_OPTION);
					if(hoiNhac == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			
		JMenu mnCaNhan = new JMenu("Thông tin cá nhân"); menuBar.add(mnCaNhan);
		
			JMenuItem mnQLThongTin = new JMenuItem("Hồ sơ của tôi"); mnCaNhan.add(mnQLThongTin);
			mnQLThongTin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setTitle("Hồ sơ của tôi ");
					try {
						doiPanel(new Layout_ThongTinCaNhan(nv).getContentPane());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			//JMenuItem mnQLTaiKhoan = new JMenuItem("TÃ i khoáº£n Ä‘Äƒng nháº­p"); mnCaNhan.add(mnQLTaiKhoan);
			//mnQLTaiKhoan.addActionListener(new ActionListener() {
				//public void actionPerformed(ActionEvent e) {
					//doiPanel(new frmNhanVien().getContentPane());
				//}
			//});
			
			// háº¿t cÃ¡ nhÃ¢n
			
		JMenu mnQuanLy = new JMenu("Quản lý"); menuBar.add(mnQuanLy);
		
//			JMenuItem mnqlNhanVien = new JMenuItem("Nhân viên"); mnQuanLy.add(mnqlNhanVien);
//			mnqlNhanVien.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						doiPanel(new Layout_QuanLy_NhanVien().getContentPane());
//					} catch (RemoteException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			});
			
			JMenuItem mnqlXe = new JMenuItem("Sản phẩm"); mnQuanLy.add(mnqlXe);
			
			mnqlXe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doiPanel(new Layout_QuanLySanPham().getContentPane());
				}
			});

			
			JMenuItem mnqlKhachHang = new JMenuItem("Khách hàng"); mnQuanLy.add(mnqlKhachHang);
			mnqlKhachHang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						doiPanel(new Layout_QLKhachHang().getContentPane());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			JMenu mnqlHoaDon = new JMenu("Hoá đơn"); mnQuanLy.add(mnqlHoaDon);
			JMenuItem mnThemHd = new JMenuItem("Thêm hoá đơn"); mnqlHoaDon.add(mnThemHd);
			mnThemHd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						doiPanel(new Layout_LapHoaDon(nv).getContentPane());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			JMenuItem mnQuanLyHd = new JMenuItem("Quản lý hoá đơn"); mnqlHoaDon.add(mnQuanLyHd);
			mnQuanLyHd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						doiPanel(new Layout_QuanLyHoaDon().getContentPane());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		try {
				doiPanel(new Layout_ThongTinCaNhan(nv).getContentPane());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

	}
	
	private void doiPanel(Container container) {
		getContentPane().removeAll();
		getContentPane().add(container);
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
//		new Dashbroad_NV().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(mntmQuayLai)) {
			this.dispose();
			new Layout_Login().setVisible(true);
		}
		
		
	}
}


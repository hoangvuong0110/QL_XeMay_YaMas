package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import app.RunYamasApplication;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.SanPhamFacade;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

public class Layout_LapHoaDon extends JFrame implements MouseListener, ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtKhachHang;
	private JTextField txtSanPham;
	private JTextField txtSoLuong;
	private JButton btnTaoMoiHoaDon;

	private JTable tableCTHD;
	private DefaultTableModel modelMatHang;
	private JButton btnXoaSanPham;
	private JButton btnXoaTatCa;
	private JButton btnLuuHoaDon;
	private JButton btnThemVaoHoaDon;
	private JButton btnLocXe;
	private JButton btnAddKhachHang;
	private JButton btnXemKH;
	private JButton btnLocKH;
	private JButton btnSuaCTHD;
	private JComboBox<String> cbbMau;
	private JComboBox<SanPham> cbbTTSanPham;
	private JComboBox<KhachHang> cbbTTKhachHang;
	private JLabel lblDongXe;
	
	
	Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	NhanVien nhanVien ;
	KhachHangFacade khachHangFacade;
	SanPhamFacade sanPhamFacade;
	HoaDonFacade hoaDonFacade;
	KhachHang khachHangDangChon;
	List<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
	private JLabel lblTngTin;
	private JLabel lblTongTien;
	private JComboBox<String> cbbNamSanXuat;
	private JComboBox<String> cbbHangSanXuat;
	private JComboBox<String> cbbDongXe;
	private JComboBox<String> cbbLoaiXe;
	private JComboBox<String> cbbMucGia;
	HoaDon hoaDon;
	JFileChooser chooser;
	private JLabel lblVAT;
	private JLabel lblTongTienHoaDon;

	public Layout_LapHoaDon(NhanVien nv) throws RemoteException {
		khachHangFacade = RunYamasApplication.getInstance().getKhachHangFacade();
		sanPhamFacade = RunYamasApplication.getInstance().getSanPhamFacade();
		hoaDonFacade = RunYamasApplication.getInstance().getHoaDonFacade();
		hoaDon = hoaDonFacade.timHoaDonTuId(18);
		nhanVien = nv;
		setLocation(0, -17);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setBackground(Color.WHITE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // This line gives Windows
																							// Theme

		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(1000, 600);
		setResizable(true);
		// setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblTieuDe = new JLabel("L???p H??a ????n");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(337, 22, 296, 42);
		getContentPane().add(lblTieuDe);
		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKhachHang.setBounds(22, 84, 298, 22);
		getContentPane().add(txtKhachHang);
		txtKhachHang.setColumns(10);

		cbbTTKhachHang = new JComboBox<KhachHang>();
		List<KhachHang> dsKhachHang = khachHangFacade.layDanhSach100KhachHangMoiNhat();
		KhachHang[] dsKhachHangcbb = new KhachHang[dsKhachHang.size()];
		for (int i = 0; i < dsKhachHangcbb.length; i++) {
			dsKhachHangcbb[i] = dsKhachHang.get(i);
		}
		cbbTTKhachHang = new JComboBox<KhachHang>(dsKhachHangcbb);
		cbbTTKhachHang.setSelectedIndex(0);
		khachHangDangChon = (KhachHang) cbbTTKhachHang.getSelectedItem();
		
		cbbTTKhachHang.setMaximumRowCount(30);
		cbbTTKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbTTKhachHang.setBackground(Color.WHITE);
		cbbTTKhachHang.setBounds(22, 121, 298, 22);
		getContentPane().add(cbbTTKhachHang);

		txtSanPham = new JTextField();
		txtSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSanPham.setColumns(10);
		txtSanPham.setBounds(22, 238, 298, 22);
		getContentPane().add(txtSanPham);

		cbbTTSanPham = new JComboBox<SanPham>();
		List<SanPham> dsSanPhamTam = sanPhamFacade.layDanhSachSanPhamMoiNhat();
		List<SanPham> dsSanPham = new ArrayList<>();
		dsSanPhamTam.forEach(sp ->{
			if(sp.getTrangThai().equals("??ang b??n") || sp.getTrangThai().equals("S???p h???t h??ng") )
				dsSanPham.add(sp);
		});
		SanPham[] dsSanPhamCbb = new SanPham[dsSanPham.size()];
		for (int i = 0; i < dsSanPhamCbb.length; i++) {
			dsSanPhamCbb[i] = dsSanPham.get(i);
		}
		cbbTTSanPham = new JComboBox<SanPham>(dsSanPhamCbb);
		cbbTTSanPham.setMaximumRowCount(30);
		cbbTTSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbTTSanPham.setBackground(Color.WHITE);
		cbbTTSanPham.setBounds(22, 417, 490, 22);
		getContentPane().add(cbbTTSanPham);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(22, 474, 298, 22);
		getContentPane().add(txtSoLuong);

		btnLocKH = new JButton("T??m Kh??ch H??ng");
		btnLocKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocKH.setBounds(347, 84, 165, 22);
		getContentPane().add(btnLocKH);

		btnXemKH = new JButton("Xem th??ng tin");
		btnXemKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXemKH.setBounds(347, 121, 165, 22);
		getContentPane().add(btnXemKH);

		btnAddKhachHang = new JButton("Th??m kh??ch h??ng m???i");
		btnAddKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddKhachHang.setBounds(347, 158, 165, 22);
		getContentPane().add(btnAddKhachHang);

		btnLocXe = new JButton("T??m xe");
		btnLocXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocXe.setBounds(347, 238, 165, 22);
		getContentPane().add(btnLocXe);

		
		
		List<String> dsMauSP = sanPhamFacade.layDanhSachMauXe();
		String[] dsMauSPcbb = new String[dsMauSP.size()+1];
		dsMauSPcbb[0] = "T???t c???";
		for (int i = 0; i < dsMauSP.size(); i++) {
			dsMauSPcbb[i+1] = dsMauSP.get(i);
			
		}
		cbbMau= new JComboBox<>(dsMauSPcbb);
		cbbMau.setSelectedIndex(0);
		cbbMau.setMaximumRowCount(30);
		cbbMau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbMau.setBackground(Color.WHITE);
		cbbMau.setBounds(347, 285, 165, 22);
		getContentPane().add(cbbMau);

		btnThemVaoHoaDon = new JButton("Th??m v??o h??a ????n");
		btnThemVaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemVaoHoaDon.setBounds(347, 474, 165, 22);
		getContentPane().add(btnThemVaoHoaDon);

		btnLuuHoaDon = new JButton("L??u H??a ????n");
		btnLuuHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLuuHoaDon.setBounds(22, 517, 155, 22);
		getContentPane().add(btnLuuHoaDon);

		btnTaoMoiHoaDon = new JButton("H??a ????n M???i");
		btnTaoMoiHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTaoMoiHoaDon.setBounds(217, 517, 155, 22);
		getContentPane().add(btnTaoMoiHoaDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 74, 441, 331);
		getContentPane().add(scrollPane);
		String[] colHeader = { "STT", "M?? SP", "S??? l?????ng", "????n Gi??", "Th??nh Ti???n" };
		modelMatHang = new DefaultTableModel(colHeader, 0);
		tableCTHD = new JTable(modelMatHang);
		tableCTHD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableCTHD.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCTHD.getColumnModel().getColumn(1).setPreferredWidth(76);
		tableCTHD.getColumnModel().getColumn(2).setPreferredWidth(30);
//		tableCTHD.getColumnModel().getColumn(3).setPreferredWidth(60);
//		tableCTHD.getColumnModel().getColumn(4).setPreferredWidth(85);
		scrollPane.setViewportView(tableCTHD);

		btnXoaTatCa = new JButton("X??a t???t c???");
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTatCa.setBounds(607, 517, 155, 22);
		getContentPane().add(btnXoaTatCa);

		btnXoaSanPham = new JButton("X??a s???n ph???m");
		btnXoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaSanPham.setBounds(806, 517, 155, 22);
		getContentPane().add(btnXoaSanPham);

		lblDongXe = new JLabel("S??? L?????ng :");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDongXe.setBounds(22, 450, 298, 20);
		getContentPane().add(lblDongXe);

		JLabel lblTmKimKhch = new JLabel("T??m ki???m kh??ch h??ng:");
		lblTmKimKhch.setBounds(22, 65, 298, 16);
		getContentPane().add(lblTmKimKhch);

		JLabel lblKtQuTm = new JLabel("K???t qu??? t??m ki???m s???n ph???m:");
		lblKtQuTm.setBounds(22, 395, 174, 16);
		getContentPane().add(lblKtQuTm);

		JLabel lblTmKimSn = new JLabel("T??m ki???m s???n ph???m:");
		lblTmKimSn.setBounds(22, 220, 165, 16);
		getContentPane().add(lblTmKimSn);

		JLabel lblMuXe = new JLabel("M??u xe:");
		lblMuXe.setBounds(347, 267, 56, 16);
		getContentPane().add(lblMuXe);

		JLabel lblHngSnXut = new JLabel("H??ng s???n xu???t:");
		lblHngSnXut.setBounds(22, 267, 100, 16);
		getContentPane().add(lblHngSnXut);
		
		List<String> dsHangSanXuatSP = sanPhamFacade.layDanhSachHangSanXuat();
		String[] dsHangSanXuatSPcbb = new String[dsHangSanXuatSP.size()+1];
		dsHangSanXuatSPcbb[0] = "T???t c???";
		for (int i = 0; i < dsHangSanXuatSP.size(); i++) {
			dsHangSanXuatSPcbb[i+1] = dsHangSanXuatSP.get(i);
			
		}
		cbbHangSanXuat= new JComboBox<>(dsHangSanXuatSPcbb);
		cbbHangSanXuat.setSelectedIndex(0);
		cbbHangSanXuat.setMaximumRowCount(30);
		cbbHangSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbHangSanXuat.setBackground(Color.WHITE);
		cbbHangSanXuat.setBounds(22, 285, 100, 22);
		getContentPane().add(cbbHangSanXuat);

		JLabel lblDngXe = new JLabel("D??ng xe:");
		lblDngXe.setBounds(154, 267, 100, 16);
		getContentPane().add(lblDngXe);

		List<String> dsDongXeSP = sanPhamFacade.layDanhSachDongXe();
		String[] dsDongXeSPcbb = new String[dsDongXeSP.size()+1];
		dsDongXeSPcbb[0] = "T???t c???";
		for (int i = 0; i < dsDongXeSP.size(); i++) {
			dsDongXeSPcbb[i+1] = dsDongXeSP.get(i);
			
		}
		cbbDongXe= new JComboBox<>(dsDongXeSPcbb);
		cbbDongXe.setSelectedIndex(0);
		
		cbbDongXe.setMaximumRowCount(30);
		cbbDongXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbDongXe.setBackground(Color.WHITE);
		cbbDongXe.setBounds(146, 285, 174, 22);
		getContentPane().add(cbbDongXe);

		JLabel lblNmSnXut = new JLabel("N??m s???n xu???t:");
		lblNmSnXut.setBounds(22, 320, 100, 16);
		getContentPane().add(lblNmSnXut);

		 cbbNamSanXuat = new JComboBox<String>();
		List<String> dsNamSanXuatSP = sanPhamFacade.layDanhSachNamSanXuat();
		String[] dsNamSanXuatSPcbb = new String[dsNamSanXuatSP.size()+1];
		dsNamSanXuatSPcbb[0] = "T???t c???";
		for (int i = 0; i < dsNamSanXuatSP.size(); i++) {
			dsNamSanXuatSPcbb[i+1] = dsNamSanXuatSP.get(i);
			
		}
		cbbNamSanXuat= new JComboBox<>(dsNamSanXuatSPcbb);
		cbbNamSanXuat.setSelectedIndex(0);
		cbbNamSanXuat.setMaximumRowCount(30);
		cbbNamSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbNamSanXuat.setBackground(Color.WHITE);
		cbbNamSanXuat.setBounds(22, 338, 100, 22);
		getContentPane().add(cbbNamSanXuat);

		List<String> dsLoaiXeSP = sanPhamFacade.layDanhSachLoaiXe();
		String[] dsLoaiXeSPcbb = new String[dsLoaiXeSP.size()+1];
		dsLoaiXeSPcbb[0] = "T???t c???";
		for (int i = 0; i < dsLoaiXeSP.size(); i++) {
			dsLoaiXeSPcbb[i+1] = dsLoaiXeSP.get(i);
			
		}
		cbbLoaiXe= new JComboBox<>(dsLoaiXeSPcbb);
		cbbLoaiXe.setSelectedIndex(0);
		cbbLoaiXe.setMaximumRowCount(30);
		cbbLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbLoaiXe.setBackground(Color.WHITE);
		cbbLoaiXe.setBounds(146, 338, 174, 22);
		getContentPane().add(cbbLoaiXe);

		JLabel lblLoiXe = new JLabel("Lo???i xe:");
		lblLoiXe.setBounds(154, 320, 100, 16);
		getContentPane().add(lblLoiXe);

		String[] dsMucGiaSpcbb = new String[6];
		dsMucGiaSpcbb[0] = "T???t c???";
		dsMucGiaSpcbb[1] = "D?????i 10 tri???u VN??";
		dsMucGiaSpcbb[2] = "10 tri???u - 20 tri???u VN??";
		dsMucGiaSpcbb[3] = "20 tri???u - 40 tri???u VN??";
		dsMucGiaSpcbb[4] = "40 tri???u - 100 tri???u VN??";
		dsMucGiaSpcbb[5] = "Tr??n 100 tri???u VN??";
		cbbMucGia = new JComboBox<>(dsMucGiaSpcbb);
		cbbMucGia.setMaximumRowCount(30);
		cbbMucGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbMucGia.setBackground(Color.WHITE);
		cbbMucGia.setBounds(347, 338, 165, 22);
		getContentPane().add(cbbMucGia);

		JLabel lblMcGi = new JLabel("M???c gi??:");
		lblMcGi.setBounds(347, 320, 56, 16);
		getContentPane().add(lblMcGi);
		
		lblTngTin = new JLabel("T???ng ti???n h??ng:");
		lblTngTin.setBounds(542, 419, 109, 16);
		getContentPane().add(lblTngTin);
		
		lblTongTien = new JLabel("0 VN??");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongTien.setBounds(683, 419, 287, 16);
		getContentPane().add(lblTongTien);
		
		 btnSuaCTHD = new JButton("S???a ");
		btnSuaCTHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuaCTHD.setBounds(898, 42, 59, 22);
		getContentPane().add(btnSuaCTHD);
		
		JLabel lblThuVat = new JLabel("Thu??? VAT:");
		lblThuVat.setBounds(542, 448, 109, 16);
		getContentPane().add(lblThuVat);
		
		 lblVAT = new JLabel("0 VN??");
		lblVAT.setForeground(Color.RED);
		lblVAT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVAT.setBounds(683, 448, 287, 16);
		getContentPane().add(lblVAT);
		
		JLabel lblThnhTin = new JLabel("Th??nh ti???n:");
		lblThnhTin.setBounds(542, 480, 109, 16);
		getContentPane().add(lblThnhTin);
		
		 lblTongTienHoaDon = new JLabel("0 VN??");
		lblTongTienHoaDon.setForeground(Color.RED);
		lblTongTienHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongTienHoaDon.setBounds(683, 480, 287, 16);
		getContentPane().add(lblTongTienHoaDon);
		btnSuaCTHD.setVisible(false);
		// ????ng k?? l???ng nghe s??? ki???n
		btnLocKH.addActionListener(this);
		btnLocXe.addActionListener(this);
		btnXemKH.addActionListener(this);
		btnAddKhachHang.addActionListener(this);
		btnThemVaoHoaDon.addActionListener(this);
		btnLuuHoaDon.addActionListener(this);
		btnSuaCTHD.addActionListener(this);
		btnXoaSanPham.addActionListener(this);
		btnXoaTatCa.addActionListener(this);
		btnTaoMoiHoaDon.addActionListener(this);
		
		tableCTHD.addMouseListener(this);
		tableCTHD.addKeyListener(this);
		txtKhachHang.addKeyListener(this);
		txtSanPham.addKeyListener(this);
		txtSoLuong.addKeyListener(this);
		
		lamMoiGiaoDien();
		// X??? l?? khi cbb kh??ch h??ng thay ?????i gi?? tr???
		
		cbbTTKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khachHangDangChon = (KhachHang) cbbTTKhachHang.getSelectedItem();

			}
		});
	}

	private void lamMoiGiaoDien() {
		txtKhachHang.setText("");
		txtSanPham.setText("");
		txtSoLuong.setText("");
		cbbDongXe.setSelectedIndex(0);
		cbbHangSanXuat.setSelectedIndex(0);
		cbbLoaiXe.setSelectedIndex(0);
		cbbMau.setSelectedIndex(0);
		cbbMucGia.setSelectedIndex(0);
		cbbNamSanXuat.setSelectedIndex(0);
		cbbTTKhachHang.setSelectedIndex(0);
		cbbTTSanPham.setSelectedIndex(0);
		
		khachHangDangChon = (KhachHang) cbbTTKhachHang.getSelectedItem();
		dsCTHD.clear();
		capNhatChiTietHoaDon();
		
	}

	public static void main(String[] args) {
//		new Layout_LapHoaDon().setVisible(true);
	}

	private boolean validData() {
		String SoLuong = txtSoLuong.getText().trim();
		if (SoLuong.length() > 0) {
			try {
				int x = Integer.parseInt(SoLuong);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l?? s??? nguy??n >=0 !!!");
					txtSoLuong.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l?? s??? nguy??n >=0 !!!");
				txtSoLuong.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Kh??ng ????? tr???ng!!!");
			txtSoLuong.requestFocus();
			return false;
		}
		// Con maXe,kichThuoc
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLocKH))
			try {
				locKhachHang();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
		if (o.equals(btnLocXe))
			try {
				locXe();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
		if (o.equals(btnXemKH))
			xemThongTinKhachHang();
		if (o.equals(btnThemVaoHoaDon))
			themSanPhamVaoHoaDon();
		if(o.equals(btnLuuHoaDon)) luuHoaDonVaoDatabase();

		if (o.equals(btnAddKhachHang))
			try {
				new Layout_QLKhachHang().setVisible(true);
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
		if(o.equals(btnXoaSanPham)) xoaSanPham();
		if(o.equals(btnXoaTatCa)) xoaTatCaCTHD();
		if(o.equals(btnSuaCTHD)) suaCTHD();
		
		if(o.equals(btnTaoMoiHoaDon)) xoaTatCaCTHD();

	}

	private void inHoaDon() {
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Title");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		// disable the "All files" option.
		chooser.setAcceptAllFileFilterUsed(false);
		
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			 File path = chooser.getSelectedFile();
			   Document document = new Document();
			   

		        try {
		        	// kh???i t???o m???t PdfWriter truy???n v??o document v?? FileOutputStream
		        	String BODONIBLACK = "src/main/resources/font/UTMAvo.ttf";
		            PdfWriter.getInstance(document, new FileOutputStream(path+"/"+hoaDon.getMaHoaDon()+".pdf"));
		            try {
						BaseFont bf = BaseFont.createFont(BODONIBLACK, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					     // m??? file ????? th???c hi???n vi???t
			            document.open();
			            int boldStyle = Font.BOLD;
			            // th??m n???i dung s??? d???ng add function
			            com.itextpdf.text.Font smallFont = new com.itextpdf.text.Font(bf, 10);
			            com.itextpdf.text.Font smallFontBold = new com.itextpdf.text.Font(bf, 10);
			            com.itextpdf.text.Font mediumFont = new com.itextpdf.text.Font(bf, 13);
			            com.itextpdf.text.Font largeFont = new com.itextpdf.text.Font(bf, 15);
			            largeFont.setStyle(boldStyle);
			            smallFontBold.setStyle(boldStyle);
			          //Khai b??o 2 paragraph
			            Paragraph header = new Paragraph("C???a h??ng xe m??y Yamas\n", smallFont);
			            Paragraph title = new Paragraph("HO?? ????N MUA H??NG: \n", largeFont);
			            Paragraph customer = new Paragraph("",mediumFont);
			            Paragraph temp = new Paragraph("         \n",mediumFont);
			            Paragraph totalCost = new Paragraph("         \n",smallFontBold);
			            Paragraph signature = new Paragraph("         \n",smallFontBold);
			            //?????nh d???ng header
			            header.setIndentationLeft(80);
			            header.setIndentationRight(80);
			            header.setAlignment(Element.ALIGN_CENTER);
			            header.setSpacingAfter(15);
			            header.add(new Phrase("Ph??n ph???i xe m??y ch??nh h??ng t???i TP.HCM\n"));
			            header.add(new Phrase("?????a ch???: 12 Nguy???n V??n B???o, Ph?????ng 4, G?? V???p, Th??nh ph??? H??? Ch?? Minh\n"));
			            header.add(new Phrase("=======================================\n"));
			            header.add(new Phrase("M?? ho?? ????n: "+ hoaDon.getMaHoaDon()));
			            
			            //?????nh d???ng title:
			            
			            title.setIndentationLeft(80);
			            title.setIndentationRight(80);
			            title.setAlignment(Element.ALIGN_CENTER);
			            
			            //??inh d???ng customer
			            
			            customer.setSpacingBefore(15);
			            customer.setAlignment(Element.ALIGN_LEFT);
			            customer.add(new Phrase("T??n kh??ch h??ng: " + hoaDon.getKhachHang().getTen()));
			            customer.add(new Phrase("\n S??? ??i???n tho???i: " + hoaDon.getKhachHang().getSdt()));
			            customer.add(new Phrase("\n ?????a ch???: " + hoaDon.getKhachHang().getDiaChi().getDiaChiChiTiet()+ "\n"));
			           
			            // ?????nh d???nh table
			            
			            PdfPTable table = new PdfPTable(5);
			            table.setWidths(new int[]{1, 3, 1,3,3});
			           table.setWidthPercentage(100);
			           
			        	//Kh???i t???o 5 ?? table header
			           
			            PdfPCell sttCol = new PdfPCell(new Paragraph("STT",smallFontBold));
			            PdfPCell maSpCol = new PdfPCell(new Paragraph("M?? SP",smallFontBold));
			            PdfPCell soLuongCol = new PdfPCell(new Paragraph("S??? l?????ng",smallFontBold));
			            PdfPCell donGiaCol = new PdfPCell(new Paragraph("????n gi??",smallFontBold));
			            PdfPCell thanhTienCol = new PdfPCell(new Paragraph("Th??nh Ti???n",smallFontBold));
			        	
			            table.addCell(sttCol);
			            table.addCell(maSpCol);
			            table.addCell(soLuongCol);
			            table.addCell(donGiaCol);
			            table.addCell(thanhTienCol);

			        
			            Double thanhtien = 0.0;
			            List<ChiTietHoaDon> dsCTHDInHD = hoaDon.getChiTietHoaDon();
			            for (int i = 0; i < dsCTHDInHD.size(); i++) {
			            	ChiTietHoaDon cthd = dsCTHDInHD.get(i);
			            	thanhtien = thanhtien + cthd.getSoLuong()*cthd.getSanPham().getGiaBan();
				            PdfPCell stt = new PdfPCell(new Paragraph(i+1+"", smallFont));
				            PdfPCell maSp = new PdfPCell(new Paragraph(cthd.getSanPham().getMaSanPham(),smallFont));
				            PdfPCell soLuong = new PdfPCell(new Paragraph(cthd.getSoLuong()+"",smallFont));
				            PdfPCell donGia = new PdfPCell(new Paragraph(currencyVN.format(cthd.getSanPham().getGiaBan())+" ",smallFont));
				            PdfPCell thanhTien = new PdfPCell(new Paragraph(currencyVN.format(cthd.getSanPham().getGiaBan()*cthd.getSoLuong())+" ",smallFont));
				            table.addCell(stt);
				            table.addCell(maSp);
				            table.addCell(soLuong);
				            table.addCell(donGia);
				            table.addCell(thanhTien);

						}
			            
			            //T???ng ti???n
			            
			            totalCost.setIndentationLeft(320);
			            totalCost.setIndentationRight(0);
			            totalCost.add(new Phrase("T???ng ti???n h??ng: "+ currencyVN.format(thanhtien)+ " \n" ));
			            totalCost.add(new Phrase("Thu??? GTGT      : "+ currencyVN.format(thanhtien/10)+ " \n" ));
			            totalCost.add(new Phrase("Th??nh ti???n      : "+ currencyVN.format(thanhtien*1.1)+ " \n" ));
			            
			            
			            // Ch??? k??
			            
			            signature.setIndentationLeft(120);
			            signature.setIndentationRight(0);
			            signature.add(new Phrase("	Ng?????i b??n h??ng                                              Ng?????i mua h??ng\n " ));
			            signature.add(new Phrase("(K?? v?? ghi r?? h??? t??n)                                       (K?? v?? ghi r?? h??? t??n)\n" ));
			           
			           

			            
			            //Th??m v??o document
			            
			            document.add(header);
			            document.add(title);
			            document.add(customer);
			            document.add(temp);
			            document.add(table);
			            document.add(totalCost);
			            document.add(signature);

			            // ????ng file
			            
			            document.close();
			            JOptionPane.showMessageDialog(this, "Xu???t ho?? ????n th??nh c??ng!");
					} catch (IOException e) {
			            JOptionPane.showMessageDialog(this, "C?? l???i x???y ra, vui l??ng th??? l???i!");

						e.printStackTrace();
					}
		             

		          

		       

		        } catch (DocumentException e) {
		            e.printStackTrace();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
			
		} else {
		}
	}

	private void suaCTHD() {
		int rowDangChon = -1;
		 rowDangChon = tableCTHD.getSelectedRow();
		if(rowDangChon==-1) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n s???n ph???m n??o trong ho?? ????n ????? s???a! Vui l??ng th??? l???i!");
			
		}
		else {
			
		}
		
		
	}

	private void xoaTatCaCTHD() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (this, "Xo?? t???t c??? s???n ph???m ??ang c?? trong ho?? ????n?","Warning",dialogButton);
		if(dialogResult == JOptionPane.YES_OPTION){
			
			lamMoiGiaoDien();
			
		}
		else {
			
		}
		
	}

	private void xoaSanPham() {
		int rowDangChon = -1;
		 rowDangChon = tableCTHD.getSelectedRow();
		if(rowDangChon==-1) {
			JOptionPane.showMessageDialog(this, "Ch??a ch???n s???n ph???m n??o trong ho?? ????n ????? xo??! Vui l??ng th??? l???i!");
			
		}
		else {
			List<ChiTietHoaDon> dsCTHDTam = new ArrayList<>();
			for (int i = 0; i < dsCTHD.size(); i++) {
				if(i!= rowDangChon) dsCTHDTam.add(dsCTHD.get(i));
			}
			dsCTHD.clear();
			dsCTHD = dsCTHDTam;
			capNhatChiTietHoaDon();
		}
		
	}

	private void luuHoaDonVaoDatabase() {
		 khachHangDangChon = (KhachHang) cbbTTKhachHang.getSelectedItem();
		
		if(khachHangDangChon==null) {
			JOptionPane.showMessageDialog(this, "Vui l??ng th??m kh??ch h??ng cho ho?? ????n!");
		}
		else if(dsCTHD.size()==0) JOptionPane.showMessageDialog(this, "Vui l??ng th??m s???n ph???m cho ho?? ????n!");
		else {
			HoaDon hoaDonMoi = new HoaDon(khachHangDangChon, nhanVien, new Date(), "Ti???n m???t", dsCTHD, "???? thanh to??n");
			try {
				int checkThemHoaDon = hoaDonFacade.themHoaDon(hoaDonMoi);
				if(checkThemHoaDon != -1 ) {
					hoaDonMoi.setMaHoaDon(checkThemHoaDon);
					
//					
					hoaDon = hoaDonMoi;
					int reply = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n in ho?? ????n kh??ng?", "TH??M HO?? ????N TH??NH C??NG!", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
					   inHoaDon();
					} else {
					    
					}
				}
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(this, "C?? l???i x???y ra, vui l??ng th??? l???i!");
//				e.printStackTrace();
			}
			
		}
		
		
		
	}

	private void themSanPhamVaoHoaDon() {
		if (txtSoLuong.getText().trim().toString().equals(""))
			txtSoLuong.setText("1");
		int soLuong = Integer.parseInt(txtSoLuong.getText().trim().toString());
		SanPham sanPhamDangChon = (SanPham) cbbTTSanPham.getSelectedItem();
		if (sanPhamDangChon == null) {
			JOptionPane.showMessageDialog(this, "Ch??a c?? s???n ph???m n??o ???????c ch???n!");

		}
		else
		if (soLuong < 1 || soLuong > sanPhamDangChon.getSoLuongTonKho()) {
			JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i >0 v?? b?? h??n s??? l?????ng t???n kho!");
		} else {
			int checkTrungSp = -1;
			if(dsCTHD==null) {}
			else 
			for (int i = 0; i < dsCTHD.size(); i++) {
				if (dsCTHD.get(i).getSanPham().getMaSanPham() == sanPhamDangChon.getMaSanPham())
					checkTrungSp = i;
				
			}
			if (checkTrungSp == -1) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(sanPhamDangChon, soLuong);
				
				dsCTHD.add(cthd);
			}
			else {
				int soLuongCu = (int) modelMatHang.getValueAt(checkTrungSp, 2);
				dsCTHD.get(checkTrungSp).setSoLuong(soLuongCu+soLuong);
				
				
			}
			capNhatChiTietHoaDon();
		}

	}

	private void capNhatChiTietHoaDon() {
		modelMatHang.setRowCount(0);
		Double tongTien = 0.0;
		for (int i = 0; i < dsCTHD.size(); i++) {
			ChiTietHoaDon cthd = dsCTHD.get(i);
			modelMatHang.addRow(new Object[] { modelMatHang.getRowCount()+1, cthd.getSanPham().getMaSanPham(),
					cthd.getSoLuong(), currencyVN.format(cthd.getSanPham().getGiaBan())+"", currencyVN.format(cthd.getSanPham().getGiaBan() * cthd.getSoLuong()) + "" });
			tongTien= tongTien + cthd.getSanPham().getGiaBan() * cthd.getSoLuong();
			lblTongTien.setText(currencyVN.format(tongTien)+ "");
			
		}
		lblTongTien.setText(currencyVN.format(tongTien)+ "");
		lblVAT.setText(currencyVN.format(tongTien/10));
		lblTongTienHoaDon.setText(currencyVN.format(tongTien*1.1));

		
	}

	private void locXe() throws RemoteException {
		String queryLocSanpham = txtSanPham.getText();
		String hangXe = (String) cbbHangSanXuat.getSelectedItem();
		String dongXe = (String) cbbDongXe.getSelectedItem();
		String mauXe = (String) cbbMau.getSelectedItem();
		String namSanXuat = (String) cbbNamSanXuat.getSelectedItem();
		String mucGia = (String) cbbMucGia.getSelectedItem();
		String loaiXe = (String) cbbLoaiXe.getSelectedItem();
		if (queryLocSanpham == "") {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p th??ng tin c???n t??m!");
//			txtKhachHang.
		} else {
			List<SanPham> dsSPTam = sanPhamFacade.timSanPhamBangTextSearch(queryLocSanpham, hangXe, dongXe, mauXe, namSanXuat, loaiXe, mucGia);
			List<SanPham> dsSP = new ArrayList<>();
			dsSPTam.forEach(sp ->{
				if(sp.getTrangThai().equals("??ang b??n") || sp.getTrangThai().equals("S???p h???t h??ng") )
					dsSP.add(sp);
			});

			int soLuongSPTimDuoc = dsSP.size();
			if (soLuongSPTimDuoc == 0)
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y S???n ph???m n??o kh???p!");
			else {
				cbbTTSanPham.removeAllItems();

				for (int i = 0; i < dsSP.size(); i++) {
					if(dsSP.get(i).getTrangThai().equals("??ang b??n") || dsSP.get(i).getTrangThai().equals("S???p h???t h??ng") )
					cbbTTSanPham.addItem(dsSP.get(i));

				}
				cbbTTSanPham.setSelectedIndex(0);
				khachHangDangChon=(KhachHang) cbbTTKhachHang.getSelectedItem();
			}

		}

	}

	private void xemThongTinKhachHang() {
		if(khachHangDangChon==null) {JOptionPane.showMessageDialog(this, "Ch??a kh??ch h??ng n??o ???????c ch???n! Vui l??ng th??? l???i!");}
		else
		new Layout_XemThongTinKhachHang(khachHangDangChon).setVisible(true);

	}

	private void locKhachHang() throws RemoteException {
		String querytimKiemKH = txtKhachHang.getText().toString().trim();
		if (querytimKiemKH == "") {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p th??ng tin c???n t??m!");
		} else {
			List<KhachHang> dsKH = khachHangFacade.timKhachHangBangTextSearch(querytimKiemKH);
			int soLuongKHTimDuoc = dsKH.size();
			if (soLuongKHTimDuoc == 0)
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y kh??ch h??ng n??o kh???p!");
			else {
				cbbTTKhachHang.removeAllItems();

				for (int i = 0; i < dsKH.size(); i++) {
					cbbTTKhachHang.addItem(dsKH.get(i));

				}
				cbbTTKhachHang.setSelectedItem(dsKH.get(0));
				khachHangDangChon = (KhachHang) cbbTTKhachHang.getSelectedItem();

			}

		}

	}

	public void mouseClicked(MouseEvent e) {
		

	}

	public void mousePressed(MouseEvent e) {
		

	}

	public void mouseReleased(MouseEvent e) {
		

	}

	public void mouseEntered(MouseEvent e) {
		

	}

	public void mouseExited(MouseEvent e) {
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (o == txtKhachHang) {
				try {
					locKhachHang();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}
			if (o == txtSanPham) {
				try {
					locXe();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}

//			else txtMatKhau.requestFocus();
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			xoaSanPham();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}
}

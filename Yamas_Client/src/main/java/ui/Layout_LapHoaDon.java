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

		JLabel lblTieuDe = new JLabel("Lập Hóa Đơn");
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
			if(sp.getTrangThai().equals("Đang bán") || sp.getTrangThai().equals("Sắp hết hàng") )
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

		btnLocKH = new JButton("Tìm Khách Hàng");
		btnLocKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocKH.setBounds(347, 84, 165, 22);
		getContentPane().add(btnLocKH);

		btnXemKH = new JButton("Xem thông tin");
		btnXemKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXemKH.setBounds(347, 121, 165, 22);
		getContentPane().add(btnXemKH);

		btnAddKhachHang = new JButton("Thêm khách hàng mới");
		btnAddKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddKhachHang.setBounds(347, 158, 165, 22);
		getContentPane().add(btnAddKhachHang);

		btnLocXe = new JButton("Tìm xe");
		btnLocXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocXe.setBounds(347, 238, 165, 22);
		getContentPane().add(btnLocXe);

		
		
		List<String> dsMauSP = sanPhamFacade.layDanhSachMauXe();
		String[] dsMauSPcbb = new String[dsMauSP.size()+1];
		dsMauSPcbb[0] = "Tất cả";
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

		btnThemVaoHoaDon = new JButton("Thêm vào hóa đơn");
		btnThemVaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemVaoHoaDon.setBounds(347, 474, 165, 22);
		getContentPane().add(btnThemVaoHoaDon);

		btnLuuHoaDon = new JButton("Lưu Hóa Đơn");
		btnLuuHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLuuHoaDon.setBounds(22, 517, 155, 22);
		getContentPane().add(btnLuuHoaDon);

		btnTaoMoiHoaDon = new JButton("Hóa Đơn Mới");
		btnTaoMoiHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTaoMoiHoaDon.setBounds(217, 517, 155, 22);
		getContentPane().add(btnTaoMoiHoaDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 74, 441, 331);
		getContentPane().add(scrollPane);
		String[] colHeader = { "STT", "Mã SP", "Số lượng", "Đơn Giá", "Thành Tiền" };
		modelMatHang = new DefaultTableModel(colHeader, 0);
		tableCTHD = new JTable(modelMatHang);
		tableCTHD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableCTHD.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableCTHD.getColumnModel().getColumn(1).setPreferredWidth(76);
		tableCTHD.getColumnModel().getColumn(2).setPreferredWidth(30);
//		tableCTHD.getColumnModel().getColumn(3).setPreferredWidth(60);
//		tableCTHD.getColumnModel().getColumn(4).setPreferredWidth(85);
		scrollPane.setViewportView(tableCTHD);

		btnXoaTatCa = new JButton("Xóa tất cả");
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTatCa.setBounds(607, 517, 155, 22);
		getContentPane().add(btnXoaTatCa);

		btnXoaSanPham = new JButton("Xóa sản phẩm");
		btnXoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaSanPham.setBounds(806, 517, 155, 22);
		getContentPane().add(btnXoaSanPham);

		lblDongXe = new JLabel("Số Lượng :");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDongXe.setBounds(22, 450, 298, 20);
		getContentPane().add(lblDongXe);

		JLabel lblTmKimKhch = new JLabel("Tìm kiếm khách hàng:");
		lblTmKimKhch.setBounds(22, 65, 298, 16);
		getContentPane().add(lblTmKimKhch);

		JLabel lblKtQuTm = new JLabel("Kết quả tìm kiếm sản phẩm:");
		lblKtQuTm.setBounds(22, 395, 174, 16);
		getContentPane().add(lblKtQuTm);

		JLabel lblTmKimSn = new JLabel("Tìm kiếm sản phẩm:");
		lblTmKimSn.setBounds(22, 220, 165, 16);
		getContentPane().add(lblTmKimSn);

		JLabel lblMuXe = new JLabel("Màu xe:");
		lblMuXe.setBounds(347, 267, 56, 16);
		getContentPane().add(lblMuXe);

		JLabel lblHngSnXut = new JLabel("Hãng sản xuất:");
		lblHngSnXut.setBounds(22, 267, 100, 16);
		getContentPane().add(lblHngSnXut);
		
		List<String> dsHangSanXuatSP = sanPhamFacade.layDanhSachHangSanXuat();
		String[] dsHangSanXuatSPcbb = new String[dsHangSanXuatSP.size()+1];
		dsHangSanXuatSPcbb[0] = "Tất cả";
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

		JLabel lblDngXe = new JLabel("Dòng xe:");
		lblDngXe.setBounds(154, 267, 100, 16);
		getContentPane().add(lblDngXe);

		List<String> dsDongXeSP = sanPhamFacade.layDanhSachDongXe();
		String[] dsDongXeSPcbb = new String[dsDongXeSP.size()+1];
		dsDongXeSPcbb[0] = "Tất cả";
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

		JLabel lblNmSnXut = new JLabel("Năm sản xuất:");
		lblNmSnXut.setBounds(22, 320, 100, 16);
		getContentPane().add(lblNmSnXut);

		 cbbNamSanXuat = new JComboBox<String>();
		List<String> dsNamSanXuatSP = sanPhamFacade.layDanhSachNamSanXuat();
		String[] dsNamSanXuatSPcbb = new String[dsNamSanXuatSP.size()+1];
		dsNamSanXuatSPcbb[0] = "Tất cả";
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
		dsLoaiXeSPcbb[0] = "Tất cả";
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

		JLabel lblLoiXe = new JLabel("Loại xe:");
		lblLoiXe.setBounds(154, 320, 100, 16);
		getContentPane().add(lblLoiXe);

		String[] dsMucGiaSpcbb = new String[6];
		dsMucGiaSpcbb[0] = "Tất cả";
		dsMucGiaSpcbb[1] = "Dưới 10 triệu VNĐ";
		dsMucGiaSpcbb[2] = "10 triệu - 20 triệu VNĐ";
		dsMucGiaSpcbb[3] = "20 triệu - 40 triệu VNĐ";
		dsMucGiaSpcbb[4] = "40 triệu - 100 triệu VNĐ";
		dsMucGiaSpcbb[5] = "Trên 100 triệu VNĐ";
		cbbMucGia = new JComboBox<>(dsMucGiaSpcbb);
		cbbMucGia.setMaximumRowCount(30);
		cbbMucGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbMucGia.setBackground(Color.WHITE);
		cbbMucGia.setBounds(347, 338, 165, 22);
		getContentPane().add(cbbMucGia);

		JLabel lblMcGi = new JLabel("Mức giá:");
		lblMcGi.setBounds(347, 320, 56, 16);
		getContentPane().add(lblMcGi);
		
		lblTngTin = new JLabel("Tổng tiền hàng:");
		lblTngTin.setBounds(542, 419, 109, 16);
		getContentPane().add(lblTngTin);
		
		lblTongTien = new JLabel("0 VNĐ");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongTien.setBounds(683, 419, 287, 16);
		getContentPane().add(lblTongTien);
		
		 btnSuaCTHD = new JButton("Sửa ");
		btnSuaCTHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuaCTHD.setBounds(898, 42, 59, 22);
		getContentPane().add(btnSuaCTHD);
		
		JLabel lblThuVat = new JLabel("Thuế VAT:");
		lblThuVat.setBounds(542, 448, 109, 16);
		getContentPane().add(lblThuVat);
		
		 lblVAT = new JLabel("0 VNĐ");
		lblVAT.setForeground(Color.RED);
		lblVAT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVAT.setBounds(683, 448, 287, 16);
		getContentPane().add(lblVAT);
		
		JLabel lblThnhTin = new JLabel("Thành tiền:");
		lblThnhTin.setBounds(542, 480, 109, 16);
		getContentPane().add(lblThnhTin);
		
		 lblTongTienHoaDon = new JLabel("0 VNĐ");
		lblTongTienHoaDon.setForeground(Color.RED);
		lblTongTienHoaDon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongTienHoaDon.setBounds(683, 480, 287, 16);
		getContentPane().add(lblTongTienHoaDon);
		btnSuaCTHD.setVisible(false);
		// Đăng ký lắng nghe sự kiện
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
		// Xử lý khi cbb khách hàng thay đổi giá trị
		
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
					JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên >=0 !!!");
					txtSoLuong.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên >=0 !!!");
				txtSoLuong.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Không để trống!!!");
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
		        	// khởi tạo một PdfWriter truyền vào document và FileOutputStream
		        	String BODONIBLACK = "src/main/resources/font/UTMAvo.ttf";
		            PdfWriter.getInstance(document, new FileOutputStream(path+"/"+hoaDon.getMaHoaDon()+".pdf"));
		            try {
						BaseFont bf = BaseFont.createFont(BODONIBLACK, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					     // mở file để thực hiện viết
			            document.open();
			            int boldStyle = Font.BOLD;
			            // thêm nội dung sử dụng add function
			            com.itextpdf.text.Font smallFont = new com.itextpdf.text.Font(bf, 10);
			            com.itextpdf.text.Font smallFontBold = new com.itextpdf.text.Font(bf, 10);
			            com.itextpdf.text.Font mediumFont = new com.itextpdf.text.Font(bf, 13);
			            com.itextpdf.text.Font largeFont = new com.itextpdf.text.Font(bf, 15);
			            largeFont.setStyle(boldStyle);
			            smallFontBold.setStyle(boldStyle);
			          //Khai báo 2 paragraph
			            Paragraph header = new Paragraph("Cửa hàng xe máy Yamas\n", smallFont);
			            Paragraph title = new Paragraph("HOÁ ĐƠN MUA HÀNG: \n", largeFont);
			            Paragraph customer = new Paragraph("",mediumFont);
			            Paragraph temp = new Paragraph("         \n",mediumFont);
			            Paragraph totalCost = new Paragraph("         \n",smallFontBold);
			            Paragraph signature = new Paragraph("         \n",smallFontBold);
			            //Định dạng header
			            header.setIndentationLeft(80);
			            header.setIndentationRight(80);
			            header.setAlignment(Element.ALIGN_CENTER);
			            header.setSpacingAfter(15);
			            header.add(new Phrase("Phân phối xe máy chính hãng tại TP.HCM\n"));
			            header.add(new Phrase("Địa chỉ: 12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, Thành phố Hồ Chí Minh\n"));
			            header.add(new Phrase("=======================================\n"));
			            header.add(new Phrase("Mã hoá đơn: "+ hoaDon.getMaHoaDon()));
			            
			            //Định dạng title:
			            
			            title.setIndentationLeft(80);
			            title.setIndentationRight(80);
			            title.setAlignment(Element.ALIGN_CENTER);
			            
			            //Đinh dạng customer
			            
			            customer.setSpacingBefore(15);
			            customer.setAlignment(Element.ALIGN_LEFT);
			            customer.add(new Phrase("Tên khách hàng: " + hoaDon.getKhachHang().getTen()));
			            customer.add(new Phrase("\n Số điện thoại: " + hoaDon.getKhachHang().getSdt()));
			            customer.add(new Phrase("\n Địa chỉ: " + hoaDon.getKhachHang().getDiaChi().getDiaChiChiTiet()+ "\n"));
			           
			            // Định dạnh table
			            
			            PdfPTable table = new PdfPTable(5);
			            table.setWidths(new int[]{1, 3, 1,3,3});
			           table.setWidthPercentage(100);
			           
			        	//Khởi tạo 5 ô table header
			           
			            PdfPCell sttCol = new PdfPCell(new Paragraph("STT",smallFontBold));
			            PdfPCell maSpCol = new PdfPCell(new Paragraph("Mã SP",smallFontBold));
			            PdfPCell soLuongCol = new PdfPCell(new Paragraph("Số lượng",smallFontBold));
			            PdfPCell donGiaCol = new PdfPCell(new Paragraph("Đơn giá",smallFontBold));
			            PdfPCell thanhTienCol = new PdfPCell(new Paragraph("Thành Tiền",smallFontBold));
			        	
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
			            
			            //Tổng tiền
			            
			            totalCost.setIndentationLeft(320);
			            totalCost.setIndentationRight(0);
			            totalCost.add(new Phrase("Tổng tiền hàng: "+ currencyVN.format(thanhtien)+ " \n" ));
			            totalCost.add(new Phrase("Thuế GTGT      : "+ currencyVN.format(thanhtien/10)+ " \n" ));
			            totalCost.add(new Phrase("Thành tiền      : "+ currencyVN.format(thanhtien*1.1)+ " \n" ));
			            
			            
			            // Chữ ký
			            
			            signature.setIndentationLeft(120);
			            signature.setIndentationRight(0);
			            signature.add(new Phrase("	Người bán hàng                                              Người mua hàng\n " ));
			            signature.add(new Phrase("(Ký và ghi rõ họ tên)                                       (Ký và ghi rõ họ tên)\n" ));
			           
			           

			            
			            //Thêm vào document
			            
			            document.add(header);
			            document.add(title);
			            document.add(customer);
			            document.add(temp);
			            document.add(table);
			            document.add(totalCost);
			            document.add(signature);

			            // đóng file
			            
			            document.close();
			            JOptionPane.showMessageDialog(this, "Xuất hoá đơn thành công!");
					} catch (IOException e) {
			            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");

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
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm nào trong hoá đơn để sửa! Vui lòng thử lại!");
			
		}
		else {
			
		}
		
		
	}

	private void xoaTatCaCTHD() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (this, "Xoá tất cả sản phẩm đang có trong hoá đơn?","Warning",dialogButton);
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
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm nào trong hoá đơn để xoá! Vui lòng thử lại!");
			
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
			JOptionPane.showMessageDialog(this, "Vui lòng thêm khách hàng cho hoá đơn!");
		}
		else if(dsCTHD.size()==0) JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm cho hoá đơn!");
		else {
			HoaDon hoaDonMoi = new HoaDon(khachHangDangChon, nhanVien, new Date(), "Tiền mặt", dsCTHD, "Đã thanh toán");
			try {
				int checkThemHoaDon = hoaDonFacade.themHoaDon(hoaDonMoi);
				if(checkThemHoaDon != -1 ) {
					hoaDonMoi.setMaHoaDon(checkThemHoaDon);
					
//					
					hoaDon = hoaDonMoi;
					int reply = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hoá đơn không?", "THÊM HOÁ ĐƠN THÀNH CÔNG!", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
					   inHoaDon();
					} else {
					    
					}
				}
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
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
			JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào được chọn!");

		}
		else
		if (soLuong < 1 || soLuong > sanPhamDangChon.getSoLuongTonKho()) {
			JOptionPane.showMessageDialog(this, "Số lượng phải >0 và bé hơn số lượng tồn kho!");
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
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm!");
//			txtKhachHang.
		} else {
			List<SanPham> dsSPTam = sanPhamFacade.timSanPhamBangTextSearch(queryLocSanpham, hangXe, dongXe, mauXe, namSanXuat, loaiXe, mucGia);
			List<SanPham> dsSP = new ArrayList<>();
			dsSPTam.forEach(sp ->{
				if(sp.getTrangThai().equals("Đang bán") || sp.getTrangThai().equals("Sắp hết hàng") )
					dsSP.add(sp);
			});

			int soLuongSPTimDuoc = dsSP.size();
			if (soLuongSPTimDuoc == 0)
				JOptionPane.showMessageDialog(this, "Không tìm thấy Sản phẩm nào khớp!");
			else {
				cbbTTSanPham.removeAllItems();

				for (int i = 0; i < dsSP.size(); i++) {
					if(dsSP.get(i).getTrangThai().equals("Đang bán") || dsSP.get(i).getTrangThai().equals("Sắp hết hàng") )
					cbbTTSanPham.addItem(dsSP.get(i));

				}
				cbbTTSanPham.setSelectedIndex(0);
				khachHangDangChon=(KhachHang) cbbTTKhachHang.getSelectedItem();
			}

		}

	}

	private void xemThongTinKhachHang() {
		if(khachHangDangChon==null) {JOptionPane.showMessageDialog(this, "Chưa khách hàng nào được chọn! Vui lòng thử lại!");}
		else
		new Layout_XemThongTinKhachHang(khachHangDangChon).setVisible(true);

	}

	private void locKhachHang() throws RemoteException {
		String querytimKiemKH = txtKhachHang.getText().toString().trim();
		if (querytimKiemKH == "") {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm!");
		} else {
			List<KhachHang> dsKH = khachHangFacade.timKhachHangBangTextSearch(querytimKiemKH);
			int soLuongKHTimDuoc = dsKH.size();
			if (soLuongKHTimDuoc == 0)
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào khớp!");
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

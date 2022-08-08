package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Layout_XemChiTietHoaDon extends JFrame	implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblMaHoahdbsDon;
	private JLabel lblTenNhanVien;
	private JLabel lblCMND;
	private JLabel lblTnKhchHng;
	private JLabel lblSDT;
	private JLabel lblDiaChi;
	private JTextField txtTinhTp;
	private JTextField txtQuanHuyen;
	private JTextField txtPhuongXa;
	private JTextField txtMaHoaDon;
	private JTable table;
	private DefaultTableModel modelCTHD;
	 HoaDon hoaDon;
	 private JLabel lblhdeds;
	 private JLabel lblTongTienHang;
	 private JLabel lblThuVat;
	 private JLabel lblVAT;
	 private JLabel lblThnhTin;
	 private JLabel lblThanhTien;
	 private JLabel lblBngChiTit;
	 
	 Locale localeVN = new Locale("vi", "VN");
	NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	public Layout_XemChiTietHoaDon(HoaDon hd) {
		hoaDon = hd;
		setLocation(0, -17);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setBackground(Color.WHITE);
		try {
		     UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
		 
		    } 
		catch (Exception e) 
		{
		      e.printStackTrace();
		    }
		setSize(1000,700);
		setResizable(true);
		//setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCTHD = new JLabel("Xem Chi Tiết Hóa Đơn");
		lblCTHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCTHD.setBounds(350, 10, 223, 41);
		getContentPane().add(lblCTHD);
		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCMND.setColumns(10);
		txtCMND.setBounds(198, 171, 216, 25);
		getContentPane().add(txtCMND);
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(659, 120, 216, 25);
		getContentPane().add(txtTenNhanVien);
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(659, 171, 216, 25);
		getContentPane().add(txtHoTen);
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSDT.setColumns(10);
		txtSDT.setBounds(198, 205, 216, 25);
		getContentPane().add(txtSDT);
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(198, 277, 677, 25);
		getContentPane().add(txtDiaChi);
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(198, 120, 216, 25);
		getContentPane().add(txtMaNhanVien);
		
		lblMaNhanVien = new JLabel("Mã Nhân Viên:");
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNhanVien.setBounds(102, 124, 96, 20);
		getContentPane().add(lblMaNhanVien);
		
		lblTenNhanVien = new JLabel("Tên Nhân Viên:");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNhanVien.setBounds(544, 125, 105, 20);
		getContentPane().add(lblTenNhanVien);
		
		lblCMND = new JLabel("CMND/CCCD Khách hàng:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(38, 173, 160, 20);
		getContentPane().add(lblCMND);
		
		lblTnKhchHng = new JLabel("Tên Khách Hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnKhchHng.setBounds(544, 173, 105, 20);
		getContentPane().add(lblTnKhchHng);
		
		lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(102, 207, 96, 20);
		getContentPane().add(lblSDT);
		
		lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(102, 279, 82, 20);
		getContentPane().add(lblDiaChi);
		
		JLabel lblTinhTp = new JLabel("Tỉnh/Thành phố:");
		lblTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTp.setBounds(544, 207, 97, 20);
		getContentPane().add(lblTinhTp);
		
		txtTinhTp = new JTextField();
		txtTinhTp.setEditable(false);
		txtTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTinhTp.setColumns(10);
		txtTinhTp.setBounds(659, 205, 216, 25);
		getContentPane().add(txtTinhTp);
		
		txtQuanHuyen = new JTextField();
		txtQuanHuyen.setEditable(false);
		txtQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQuanHuyen.setColumns(10);
		txtQuanHuyen.setBounds(198, 242, 216, 25);
		getContentPane().add(txtQuanHuyen);
		
		JLabel lblQuanHuyen = new JLabel("Quận/Huyện:");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuanHuyen.setBounds(102, 245, 82, 20);
		getContentPane().add(lblQuanHuyen);
		
		txtPhuongXa = new JTextField();
		txtPhuongXa.setEditable(false);
		txtPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhuongXa.setColumns(10);
		txtPhuongXa.setBounds(659, 239, 216, 25);
		getContentPane().add(txtPhuongXa);
		
		JLabel lblPhuongXa = new JLabel("Phường/Xã:");
		lblPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhuongXa.setBounds(544, 244, 72, 20);
		getContentPane().add(lblPhuongXa);
		
		lblMaHoahdbsDon = new JLabel("Mã Hóa Đơn:");
//		lblMaHoaDon = new JLabel("Mã Hóa Đơn:" + HoaDon.getMaHoaDon);
		
		lblMaHoahdbsDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaHoahdbsDon.setBounds(360, 64, 112, 20);
		getContentPane().add(lblMaHoahdbsDon);
		
		//txtMaHoaDon = new JTextField();
		//txtMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//txtMaHoaDon.setColumns(10);
		//txtMaHoaDon.setBounds(198, 85, 216, 25);
		//getContentPane().add(txtMaHoaDon);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 330, 913, 200);
		getContentPane().add(scrollPane);
		
		String[] colHeader = { "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"};
		modelCTHD = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelCTHD);
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblMaHoaDon = new JLabel("");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHoaDon.setForeground(Color.RED);
		lblMaHoaDon.setBounds(484, 67, 183, 16);
		getContentPane().add(lblMaHoaDon);
		
				
		lblhdeds = new JLabel("Tổng tiền hàng:");
		lblhdeds.setBounds(614, 543, 105, 16);
		getContentPane().add(lblhdeds);
		
		lblTongTienHang = new JLabel("0");
		lblTongTienHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongTienHang.setForeground(Color.RED);
		lblTongTienHang.setBounds(731, 543, 200, 16);
		getContentPane().add(lblTongTienHang);
		
		lblThuVat = new JLabel("Thuế VAT:");
		lblThuVat.setBounds(614, 572, 105, 16);
		getContentPane().add(lblThuVat);
		
		lblVAT = new JLabel("0");
		lblVAT.setForeground(Color.RED);
		lblVAT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVAT.setBounds(731, 572, 200, 16);
		getContentPane().add(lblVAT);
		
		lblThnhTin = new JLabel("Thành tiền :");
		lblThnhTin.setBounds(614, 599, 105, 16);
		getContentPane().add(lblThnhTin);
		
		lblThanhTien = new JLabel("0");
		lblThanhTien.setForeground(Color.RED);
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThanhTien.setBounds(731, 599, 220, 16);
		getContentPane().add(lblThanhTien);
		
		lblBngChiTit = new JLabel("| Bảng chi tiết hoá đơn");
		lblBngChiTit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBngChiTit.setBounds(38, 543, 273, 16);
		getContentPane().add(lblBngChiTit);
		
		
		KhachHang kh = hoaDon.getKhachHang();
		NhanVien nv = hoaDon.getNhanvien();
		List<ChiTietHoaDon> dsCTHD = hoaDon.getChiTietHoaDon();
		
		txtMaNhanVien.setText(nv.getMaNhanVien());
		txtTenNhanVien.setText(nv.getTen());

		
		txtCMND.setText(kh.getCmnd());
		txtDiaChi.setText(kh.getDiaChi().getDiaChiChiTiet());
		txtHoTen.setText(kh.getTen());
		txtPhuongXa.setText(kh.getDiaChi().getPhuong());
		txtQuanHuyen.setText(kh.getDiaChi().getQuan());
		txtSDT.setText(kh.getSdt());
		txtTinhTp.setText(kh.getDiaChi().getThanhPho());

		lblMaHoaDon.setText(hoaDon.getMaHoaDon()+"");
		
		Double thanhTien = 0.0;
		for (int i = 0; i < dsCTHD.size(); i++) {
			ChiTietHoaDon cthd = dsCTHD.get(i);
			
			modelCTHD.addRow(new Object[] {i+1, cthd.getSanPham().getMaSanPham(),cthd.getSanPham().getTenSanPham(),cthd.getSoLuong(),currencyVN.format(cthd.getSanPham().getGiaBan()),currencyVN.format(cthd.getSanPham().getGiaBan()*cthd.getSoLuong())});
			thanhTien = thanhTien+ cthd.getSoLuong()* cthd.getSanPham().getGiaBan();
		}
		lblThanhTien.setText(currencyVN.format(thanhTien*1.1));
		lblVAT.setText(currencyVN.format(thanhTien/10));
		lblTongTienHang.setText(currencyVN.format(thanhTien));

		
	}
	public static void main(String[] args) {
//		new Layout_XemChiTietHoaDon().setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

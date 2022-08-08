package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import app.RunYamasApplication;
import businesslogic.facade.SanPhamFacade;
import model.DiaChi;
import model.KhachHang;
import model.SanPham;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Layout_QuanLySanPham extends JFrame implements ActionListener, MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtMaSanPham;
	private JTextField txtHangSanXuat;
	private JTextField txtGiaBan;
	private JTextField txtGiaNhap;
	private JTextField txtSoLuongTon;
	private JTextField txtDongXe;
	private JTextField txtMauXe;
	private JTextField txtTenSP;
	private JTextField txtNamSanXuat;
	private JTextField txtDungTichXiLanh;
	private JTextField txtDungTichBinhXang;
	private JTextField txtKichThuoc;
	private JTextField txtTim;
	private JButton btnThem;
	private JButton btnTim;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private String[] s = { "Đang bán", "Hết hàng", "Sắp hết hàng", "Ngừng kinh doanh" };
	private String[] loaiXe = { "Xe số", "Xe tay ga" };

	private JComboBox<String> cbbTrangThai;

	private JTable table_Xe;
	private DefaultTableModel modelXe;
	SanPhamFacade sanPhamFacade;
	NumberFormat formatter = new DecimalFormat("#0.00");

	Locale localeVN = new Locale("vi", "VN");
	NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	private List<SanPham> dsSanPham;
	private JComboBox cbbLoaiXe;
	private JButton btnCapNhat;
	SanPham sanPhamDangChon;

	public Layout_QuanLySanPham() {
		sanPhamFacade = RunYamasApplication.getInstance().getSanPhamFacade();
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

		JLabel lbltieude = new JLabel("QUẢN LÝ XE MÁY");
		lbltieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltieude.setBounds(215, 0, 540, 55);
		getContentPane().add(lbltieude);

		JLabel lblHangSanXuat = new JLabel("Hãng Sản Xuất :");
		lblHangSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHangSanXuat.setBounds(80, 61, 100, 25);
		getContentPane().add(lblHangSanXuat);

		txtHangSanXuat = new JTextField();
		txtHangSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHangSanXuat.setHorizontalAlignment(SwingConstants.LEFT);
		txtHangSanXuat.setBounds(215, 61, 270, 25);
		getContentPane().add(txtHangSanXuat);
		txtHangSanXuat.setColumns(10);

		JLabel lblTen = new JLabel("Tên Mặt Hàng : ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTen.setBounds(551, 61, 154, 25);
		getContentPane().add(lblTen);

		txtTenSP = new JTextField();
		txtTenSP.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSP.setBounds(713, 61, 220, 25);
		getContentPane().add(txtTenSP);
		txtTenSP.setColumns(10);

		JLabel lbltienNhap = new JLabel("Giá Nhập : ");
		lbltienNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltienNhap.setBounds(79, 121, 87, 25);
		getContentPane().add(lbltienNhap);
		txtGiaNhap = new JTextField();
		txtGiaNhap.setHorizontalAlignment(SwingConstants.LEFT);
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGiaNhap.setBounds(215, 121, 270, 25);
		getContentPane().add(txtGiaNhap);
		txtGiaNhap.setColumns(10);

		JLabel lblSoLuong = new JLabel("Dòng Xe :");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong.setBounds(551, 91, 154, 25);
		getContentPane().add(lblSoLuong);

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setHorizontalAlignment(SwingConstants.LEFT);
		txtSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongTon.setBounds(713, 121, 220, 25);
		getContentPane().add(txtSoLuongTon);
		txtSoLuongTon.setColumns(10);

		JLabel lblGiaBan = new JLabel("Giá bán ra : ");
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiaBan.setBounds(80, 151, 100, 25);
		getContentPane().add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setHorizontalAlignment(SwingConstants.LEFT);
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGiaBan.setBounds(215, 151, 270, 25);
		getContentPane().add(txtGiaBan);
		txtGiaBan.setColumns(10);

		JLabel lblMau = new JLabel("Màu:");
		lblMau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMau.setBounds(80, 181, 130, 25);
		getContentPane().add(lblMau);

		txtMauXe = new JTextField();
		txtMauXe.setHorizontalAlignment(SwingConstants.LEFT);
		txtMauXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMauXe.setBounds(215, 181, 270, 25);
		getContentPane().add(txtMauXe);
		txtMauXe.setColumns(10);

		JLabel lblDongCo = new JLabel("Dung Tich Xi Lanh :");
		lblDongCo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDongCo.setBounds(551, 181, 130, 25);
		getContentPane().add(lblDongCo);

		txtDungTichXiLanh = new JTextField();
		txtDungTichXiLanh.setHorizontalAlignment(SwingConstants.LEFT);
		txtDungTichXiLanh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDungTichXiLanh.setBounds(713, 181, 220, 25);
		getContentPane().add(txtDungTichXiLanh);
		txtDungTichXiLanh.setColumns(10);

		JLabel tlblKichThuoc = new JLabel("Kích Thước :");
		tlblKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tlblKichThuoc.setBounds(80, 211, 100, 25);
		getContentPane().add(tlblKichThuoc);

		txtKichThuoc = new JTextField();
		txtKichThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		txtKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKichThuoc.setBounds(215, 211, 271, 25);
		getContentPane().add(txtKichThuoc);
		txtKichThuoc.setColumns(10);

		JLabel lblNamSanXuat = new JLabel("Năm Sản Xuất :");
		lblNamSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNamSanXuat.setBounds(551, 211, 130, 25);
		getContentPane().add(lblNamSanXuat);

		txtNamSanXuat = new JTextField();
		txtNamSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNamSanXuat.setBounds(713, 211, 220, 25);
		getContentPane().add(txtNamSanXuat);
		txtNamSanXuat.setColumns(10);

		JLabel lblBaoHanh = new JLabel("Dung Tích Bình Xăng :");
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBaoHanh.setBounds(551, 151, 130, 25);
		getContentPane().add(lblBaoHanh);

		txtDungTichBinhXang = new JTextField();
		txtDungTichBinhXang.setHorizontalAlignment(SwingConstants.LEFT);
		txtDungTichBinhXang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDungTichBinhXang.setBounds(713, 150, 220, 25);
		getContentPane().add(txtDungTichBinhXang);
		txtDungTichBinhXang.setColumns(10);

		JLabel lblLoaiXe = new JLabel("Loại Xe : ");
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoaiXe.setBounds(80, 91, 100, 25);
		getContentPane().add(lblLoaiXe);

		JLabel lblDongXe = new JLabel("Số Lượng :");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDongXe.setBounds(551, 121, 154, 25);
		getContentPane().add(lblDongXe);

		txtDongXe = new JTextField();
		txtDongXe.setHorizontalAlignment(SwingConstants.LEFT);
		txtDongXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDongXe.setBounds(713, 91, 220, 25);
		getContentPane().add(txtDongXe);
		txtSoLuongTon.setColumns(10);

		String[] colHeader = { "Mã SP", "Hãng sản xuất", "Tên SP", "Trạng thái", "Đã bán", "Dòng Xe", "Loại Xe",
				"Số lượng", "Năm Sản Xuất", "Màu", "DT Xi Lanh", "DT Bình Xăng", "Giá Nhập", "Giá Bán", "Kích Thước" };
		modelXe = new DefaultTableModel(colHeader, 0);
		table_Xe = new JTable(modelXe) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);

				if (!isRowSelected(row)) {

					if (modelXe.getValueAt(row, 3).equals("Sắp hết hàng"))
						c.setBackground(new Color(255, 255, 204));
					if (modelXe.getValueAt(row, 3).equals("Hết hàng"))
						c.setBackground(new Color(255, 102, 102));
					if (modelXe.getValueAt(row, 3).equals("Ngừng kinh doanh"))
						c.setBackground(Color.GRAY);
					if (modelXe.getValueAt(row, 3).equals("Đang bán"))
						c.setBackground(Color.WHITE);

				}

				return c;
			}
		};
		table_Xe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table_Xe.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table_Xe.getColumnModel().getColumn(0).setMinWidth(100);
		table_Xe.getColumnModel().getColumn(1).setMinWidth(100);
		table_Xe.getColumnModel().getColumn(2).setMinWidth(200);
		table_Xe.getColumnModel().getColumn(3).setMinWidth(150);
		table_Xe.getColumnModel().getColumn(4).setMinWidth(85);
		table_Xe.getColumnModel().getColumn(5).setMinWidth(100);
		table_Xe.getColumnModel().getColumn(6).setMinWidth(100);
		table_Xe.getColumnModel().getColumn(7).setMinWidth(50);
		table_Xe.getColumnModel().getColumn(8).setMinWidth(150);
		table_Xe.getColumnModel().getColumn(9).setMinWidth(50);
		table_Xe.getColumnModel().getColumn(10).setMinWidth(120);
		table_Xe.getColumnModel().getColumn(11).setMinWidth(120);
		table_Xe.getColumnModel().getColumn(12).setMinWidth(150);
		table_Xe.getColumnModel().getColumn(13).setMinWidth(150);
		table_Xe.getColumnModel().getColumn(14).setMinWidth(180);
		JScrollPane scrollPane = new JScrollPane(table_Xe, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(80, 276, 853, 230);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_Xe);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(538, 526, 125, 25);
		getContentPane().add(btnThem);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/trash.png"));
			btnXoaTrang.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnXoaTrang.setBounds(808, 526, 125, 25);
		getContentPane().add(btnXoaTrang);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setBounds(80, 524, 189, 25);
		getContentPane().add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTim.setBounds(279, 526, 87, 25);
		getContentPane().add(btnTim);
		// Add Icon
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/add.png"));
			btnThem.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(538, 526, 125, 25);
		getContentPane().add(btnThem);

		btnXoa = new JButton("Xóa");
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/trash.png"));
			btnXoa.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(673, 526, 125, 25);
		getContentPane().add(btnXoa);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/trash.png"));
			btnXoaTrang.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/search.png"));
			btnTim.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		//
		cbbTrangThai = new JComboBox(s);
		cbbTrangThai.setMaximumRowCount(100);
		cbbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbTrangThai.setBackground(Color.WHITE);
		cbbTrangThai.setBounds(713, 241, 220, 25);
		getContentPane().add(cbbTrangThai);

		JLabel lblMaSP = new JLabel("Mã Sản Phẩm :");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSP.setBounds(80, 241, 100, 25);
		getContentPane().add(lblMaSP);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(215, 241, 271, 25);
		getContentPane().add(txtMaSanPham);

		JLabel lblTrangThai = new JLabel("Trạng Thái :");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(551, 241, 100, 25);
		getContentPane().add(lblTrangThai);

		cbbLoaiXe = new JComboBox(loaiXe);
		cbbLoaiXe.setBounds(215, 92, 270, 22);
		getContentPane().add(cbbLoaiXe);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapNhat.setBounds(401, 526, 125, 25);
		getContentPane().add(btnCapNhat);
		btnTim.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		table_Xe.addMouseListener(this);
		txtTim.addKeyListener(this);

		try {
			dsSanPham = sanPhamFacade.layDanhSachSanPhamMoiNhat();
			themDuLieuSanPhamVaoTable(dsSanPham);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void themDuLieuSanPhamVaoTable(List<SanPham> dsSanPhamCuaTable) {
		modelXe.setRowCount(0);

		for (int i = 0; i < dsSanPhamCuaTable.size(); i++) {
			SanPham sp = dsSanPhamCuaTable.get(i);

			modelXe.addRow(new Object[] { sp.getMaSanPham(), sp.getHangSanXuat(), sp.getTenSanPham(), sp.getTrangThai(),
					sp.getSoLuongDaBan(), sp.getDongXe(), sp.getLoaiXe(), sp.getSoLuongTonKho(), sp.getNamSanXuat(),
					sp.getMauXe(), sp.getDungTichBinhXang(), sp.getDungTichBinhXang(),
					currencyVN.format(sp.getGiaNhap()) + "", currencyVN.format(sp.getGiaBan()) + "",
					sp.getKichThuoc() });
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void main(String[] args) {
		new Layout_QuanLySanPham().setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table_Xe)) {
			ganDuLieuVaoForm();
		}

	}

	private void ganDuLieuVaoForm() {
		SanPham sp = dsSanPham.get(table_Xe.getSelectedRow());
		sanPhamDangChon = sp;
		txtDongXe.setText(sp.getDongXe());
		cbbLoaiXe.setSelectedItem(sp.getLoaiXe());
		txtDungTichBinhXang.setText(sp.getDungTichBinhXang());
		txtDungTichXiLanh.setText(sp.getDungTichXilanh());
		txtGiaBan.setText(formatter.format(sp.getGiaBan()));
		txtGiaNhap.setText(formatter.format(sp.getGiaNhap()));
		txtHangSanXuat.setText(sp.getHangSanXuat());
		txtKichThuoc.setText(sp.getKichThuoc());
		txtMaSanPham.setText(sp.getMaSanPham());
		txtMauXe.setText(sp.getMauXe());
		txtNamSanXuat.setText(sp.getNamSanXuat() + "");
		txtSoLuongTon.setText(sp.getSoLuongTonKho() + "");
		txtTenSP.setText(sp.getTenSanPham());
		cbbTrangThai.setSelectedItem(sp.getTrangThai());

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			System.out.println("Xoa Calling");
			xoaSanPham();

		}
		if (o.equals(btnThem)) {
			try {
				if (validData())

					ThemXe();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (o.equals(btnTim))
			timSanPham();
		if (o.equals(btnCapNhat)) {
//			if (validData())

			capNhatSanPham();
			System.out.println("CN Calling");

		}
	}

	private void xoaSanPham() {
		if (sanPhamDangChon == null) {
			JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm nào để xoá!");

		} else {

			int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá sản phẩm này không?",
					"XOÁ SẢN PHẨM", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				try {

					boolean kiemTra = sanPhamFacade.xoaSanPham(sanPhamDangChon);
					System.out.println(sanPhamDangChon);
					if (kiemTra == true) {
						JOptionPane.showMessageDialog(this, "Xoá thành công!");
						txtHangSanXuat.setText("");
						txtGiaBan.setText("");
						txtGiaNhap.setText("");
						txtSoLuongTon.setText("");
						txtDongXe.setText("");
						txtMauXe.setText("");
						txtTenSP.setText("");
						txtNamSanXuat.setText("");
						txtDungTichXiLanh.setText("");
						txtDungTichBinhXang.setText("");
						txtKichThuoc.setText("");
						cbbLoaiXe.setSelectedIndex(0);
						cbbTrangThai.setSelectedIndex(0);
						dsSanPham.remove(table_Xe.getSelectedRow());
						themDuLieuSanPhamVaoTable(dsSanPham);
					} else {
						JOptionPane.showMessageDialog(this, "Sản phẩm không được xoá do đã từng bán!");

					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng thử lại!");
				}
			} else {

			}

		}
	}

	private void capNhatSanPham() {
		String HangSanXuat = txtHangSanXuat.getText().trim();
		String GiaBan = txtGiaBan.getText().trim();
		String GiaNhap = txtGiaNhap.getText().trim();
		String SoLuongTon = txtSoLuongTon.getText().trim();
		String LoaiXe = cbbLoaiXe.getSelectedItem().toString();
		String DongXe = txtDongXe.getText().trim();
		String MauXe = txtMauXe.getText().trim();
		String TenSP = txtTenSP.getText().trim();
		String NamSanXuat = txtNamSanXuat.getText().trim();
		String DungTichXiLanh = txtDungTichXiLanh.getText().trim();
		String DungTichBinhXang = txtDungTichBinhXang.getText().trim();
		String KichThuoc = txtKichThuoc.getText().trim();
		String maSanPham = txtMaSanPham.getText().trim();
		String trangThai = (String) cbbTrangThai.getSelectedItem();
		double GiaBan1 = Double.parseDouble(GiaBan);
		double GiaNhap1 = Double.parseDouble(GiaNhap);
		int NamSanXuat1 = Integer.parseInt(NamSanXuat);
		int soLuongTonKho1 = Integer.parseInt(SoLuongTon);

		SanPham sp = new SanPham(maSanPham, TenSP, HangSanXuat, LoaiXe, DongXe, MauXe, GiaNhap1, GiaBan1, NamSanXuat1,
				DungTichXiLanh, DungTichBinhXang, KichThuoc, soLuongTonKho1, trangThai,
				sanPhamDangChon.getSoLuongDaBan());
		try {
			boolean kiemTra = sanPhamFacade.capNhatSanPham(sp);
			if (kiemTra == true) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");

			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
			e.printStackTrace();
		}

	}

	private void timSanPham() {
		String queryTimSanPham = txtTim.getText().toString().trim();
		if (queryTimSanPham == "") {
			JOptionPane.showMessageDialog(this, "Ô tìm kiếm đang trống, vui lòng thử lại!");
			txtTim.requestFocus();
		} else {
			try {
				List<SanPham> dsSanPhamTuTextSearch = sanPhamFacade.timSanPham(queryTimSanPham);
				if (dsSanPhamTuTextSearch.size() > 0) {
					themDuLieuSanPhamVaoTable(dsSanPhamTuTextSearch);
					dsSanPham = dsSanPhamTuTextSearch;
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào, vui lòng thử lại!");
					txtTim.requestFocus();

				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean validData() {
		String HangSanXuat = txtHangSanXuat.getText().trim();
		String GiaBan = txtGiaBan.getText().trim();
		String GiaNhap = txtGiaNhap.getText().trim();
		String SoLuongTon = txtSoLuongTon.getText().trim();
		String LoaiXe = cbbLoaiXe.getSelectedItem().toString();
		String DongXe = txtDongXe.getText().trim();
		String MauXe = txtMauXe.getText().trim();
		String TenSP = txtTenSP.getText().trim();
		String NamSanXuat = txtNamSanXuat.getText().trim();
		String DungTichXiLanh = txtDungTichXiLanh.getText().trim();
		String DungTichBinhXang = txtDungTichBinhXang.getText().trim();
		String KichThuoc = txtKichThuoc.getText().trim();
		if (!(TenSP.length() > 0 && TenSP.matches("[\\p{L}\\s\\d -]+"))) {
			JOptionPane.showMessageDialog(this, "Tên Xe không hợp lệ");
			txtTenSP.requestFocus();
			return false;
		}
		if (!(GiaBan.length() > 0 && GiaBan.matches("[1-9]{1}[0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Giá phải > 0!!!");
			txtGiaBan.requestFocus();
			return false;
		}
		if (!(GiaNhap.length() > 0 && GiaNhap.matches("[1-9]{1}[0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Giá phải > 0!!!");
			txtGiaNhap.requestFocus();
			return false;
		}
		if (SoLuongTon.length() > 0) {
			try {
				int x = Integer.parseInt(SoLuongTon);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên >=0 !!!");
					txtSoLuongTon.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên >=0 !!!");
				txtSoLuongTon.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Không để trống!!!");
			txtSoLuongTon.requestFocus();
			return false;
		}
		if (!(DungTichXiLanh.length() > 0 && DungTichXiLanh.matches("[1-9]{1}[0-9]+[c]{2}"))) {
			JOptionPane.showMessageDialog(this, "Dung tích xi lanh có cú pháp : XXXcc");
			txtDungTichXiLanh.requestFocus();
			return false;
		}
		if (!(DungTichBinhXang.length() > 0 && DungTichBinhXang.matches("[1-9]{1}[0-9]+[l]"))) {
			JOptionPane.showMessageDialog(this, "Dung tích bình xăng có cứu pháp : XXXl");
			txtDungTichBinhXang.requestFocus();
			return false;
		}
		
		
		
		 
//		dung tích bình xăng, dung tích xi lanh 
//		if (DungTichBinhXang.length() > 0) {
//			try {
//				double x = Double.parseDouble(DungTichBinhXang);
//				if (x <= 0) {
//					JOptionPane.showMessageDialog(this, "Dung tích bình xăng phải là số thực >=0 !!!");
//					txtDungTichBinhXang.requestFocus();
//					return false;
//				}
///			} catch (Exception e) {
//				JOptionPane.showMessageDialog(this, "Dung tích bình xăng phải là số thực >=0 !!!");
//				txtDungTichBinhXang.requestFocus();
//				return false;
//			}/
//
	//	} else {
//			JOptionPane.showMessageDialog(this, "Không để trống dung tích bình xăng!!!");
//			txtDungTichBinhXang.requestFocus();
//			return false;
//		}
//		if (DungTichXiLanh.length() > 0) {
//			try {
//				double x = Double.parseDouble(DungTichXiLanh);
//				if (x <= 0) {
//					JOptionPane.showMessageDialog(this, "Dung tích xi lanh phải là số thực >=0 !!!");
//					txtDungTichXiLanh.requestFocus();
//					return false;
//				}
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(this, "Dung tích xi lanh phải là số thực >=0 !!!");
//				txtDungTichXiLanh.requestFocus();
//				return false;
//			}
//
//		} else {
//			JOptionPane.showMessageDialog(this, "Không để trống dung tích xi lanh!!!");
//			txtDungTichXiLanh.requestFocus();
//			return false;
//		}
		if (!(DongXe.length() > 0 && DongXe.matches("[\\p{L}\\s\\d -]+"))) {
			JOptionPane.showMessageDialog(this, "Dòng xe không hợp lệ");
			txtDongXe.requestFocus();
			return false;
		}

		if (!(MauXe.length() > 0 && MauXe.matches("[\\p{L}\\s\\d -]+"))) {
			JOptionPane.showMessageDialog(this, "Năm xe không hợp lệ");
			txtMauXe.requestFocus();
			return false;
		}
		if (NamSanXuat.length() > 0) {
			try {
				int x = Integer.parseInt(NamSanXuat);
				if (x <= 1900) {
					JOptionPane.showMessageDialog(this, "Năm sản xuất lớn hơn 1900");
					txtNamSanXuat.requestFocus();
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Năm sản xuất lớn hơn 1900");
				txtNamSanXuat.requestFocus();
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(this, "Không để trống!!!");
			txtNamSanXuat.requestFocus();
			return false;
		}
		// Con maXe,kichThuoc
		if (!(KichThuoc.length() > 0 && KichThuoc.matches("(\\d)+( mm x \\d+){2}( mm)"))) {
			//Kích thước
			JOptionPane.showMessageDialog(this, "Kích thước phải theo kiểu amm x bmm x cmm");
			txtKichThuoc.requestFocus();
			return false;
		}
		return true;
	}

	private void ThemXe() throws RemoteException {
		String tenXe = txtTenSP.getText().toString().trim();
		String maXe = txtMaSanPham.getText().trim();
		List<SanPham> dsSanPhamKT = sanPhamFacade.timSanPham(tenXe);
		SanPham sanPhamKT = sanPhamFacade.timSanPhamTuId(maXe);
		if ((dsSanPhamKT == null) || dsSanPhamKT.size() > 0 || sanPhamKT != null) {
			JOptionPane.showMessageDialog(this, "Sản phẩm với tên :" + tenXe + " có Mã SP: " + maXe + "đã tồn tại");
			txtTenSP.requestFocus();
		} else {
			String HangSanXuat = txtHangSanXuat.getText().trim();
			String GiaBan = txtGiaBan.getText().trim();
			String GiaNhap = txtGiaNhap.getText().trim();
			String SoLuongTon = txtSoLuongTon.getText().trim();
			String LoaiXe = cbbLoaiXe.getSelectedItem().toString();
			String DongXe = txtDongXe.getText().trim();
			String MauXe = txtMauXe.getText().trim();
			String TenSP = txtTenSP.getText().trim();
			String NamSanXuat = txtNamSanXuat.getText().trim();
			String DungTichXiLanh = txtDungTichXiLanh.getText().trim();
			String DungTichBinhXang = txtDungTichBinhXang.getText().trim();
			String KichThuoc = txtKichThuoc.getText().trim();

			String trangThai = (String) cbbTrangThai.getSelectedItem();
			double GiaBan1 = Double.parseDouble(GiaBan);
			double GiaNhap1 = Double.parseDouble(GiaNhap);
			int NamSanXuat1 = Integer.parseInt(NamSanXuat);
			int soLuongTonKho1 = Integer.parseInt(SoLuongTon);
//			Tao mã Sản Phẩm như nào :))))) do ko viết mã tạo như nào nên t để thế này ha

			SanPham sp = new SanPham(maXe, TenSP, HangSanXuat, LoaiXe, DongXe, MauXe, GiaNhap1, GiaBan1, NamSanXuat1,
					DungTichXiLanh, DungTichBinhXang, KichThuoc, soLuongTonKho1, trangThai, 0);
			try {
				boolean checkThemSanPham = sanPhamFacade.themSanPham(sp);
				if (checkThemSanPham == true)
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (o.equals(txtTim))
				timSanPham();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}

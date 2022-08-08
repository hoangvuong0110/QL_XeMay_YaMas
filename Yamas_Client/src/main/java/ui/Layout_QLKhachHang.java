package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.RunYamasApplication;
import businesslogic.facade.DiaChiHanhChinhFacade;
import businesslogic.facade.KhachHangFacade;
import model.DiaChi;
import model.KhachHang;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Layout_QLKhachHang extends JFrame implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTable tableQLKhachHang;
	private JTextField txtDiaChi;
	private DefaultTableModel modelQLKhachHang;
	private JButton btnCapNhat;
	private JButton btnThem;
	private JButton btnXoa;
	private JTextField txtTim;
	private JLabel lblGioiTinh;
	private JLabel lblTrangThai;
	private JTextField txtTrangThai;
	private JComboBox cbbTinhTp;
	private JComboBox cbbPhuongXa;
	private JComboBox cbbQuanHuyen;
	private JComboBox cbGioiTinh;
	ThanhPho tpDangChon;
	Quan quanDangChon;
	Phuong phuongDangChon;
	KhachHangFacade khachHangFacade;
	DiaChiHanhChinhFacade diaChiHanhChinhFacade;
	List<KhachHang> dsKhachHangTable;
	private ThanhPho[] dsTPcbb;
	private Quan[] dsQuancbb;
	private Phuong[] dsPhuongcbb;
	private JButton btnTim;

	public Layout_QLKhachHang() throws RemoteException {
		khachHangFacade = RunYamasApplication.getInstance().getKhachHangFacade();
		diaChiHanhChinhFacade = RunYamasApplication.getInstance().getDiaChiHanhChinh();
		setTitle("Quản Lý Khách Hàng\r\n");
		try {
			// Connect_Data.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setLocation(0, -17);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setBackground(Color.WHITE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // This line gives Windows
																							// Theme

		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(1000, 700);
		setResizable(true);
		// setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Khách Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(297, 13, 348, 45);
		getContentPane().add(lblNewLabel);

		JLabel lblHoTen = new JLabel("Tên Khách Hàng:");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(79, 69, 146, 20);
		getContentPane().add(lblHoTen);

		JLabel lblCMND = new JLabel("Số CMND :");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(484, 69, 78, 20);
		getContentPane().add(lblCMND);

		JLabel lblSoDT = new JLabel("Số điện thoại:\r\n");
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoDT.setBounds(484, 110, 97, 20);
		getContentPane().add(lblSoDT);

		txtHoTen = new JTextField();
		txtHoTen.setText("Lưu Tuấn Kha");
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHoTen.setBounds(179, 69, 223, 22);
		getContentPane().add(txtHoTen);
		txtHoTen.setColumns(10);

		txtCMND = new JTextField();
		txtCMND.setText("187863406");
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCMND.setBounds(596, 69, 288, 22);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setText("0983860511");
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSDT.setBounds(596, 110, 288, 22);
		getContentPane().add(txtSDT);
		txtSDT.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\add.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(507, 585, 119, 25);
		getContentPane().add(btnThem);

		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setIcon(
				new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\rotate-right.png"));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapNhat.setBounds(636, 585, 119, 25);
		getContentPane().add(btnCapNhat);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(
				new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\time-delete.png"));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(765, 585, 119, 25);
		getContentPane().add(btnXoa);

//		JScrollPane scrollPane = new JScrollPane();
//		getContentPane().add(scrollPane);

		String[] colHeader = { "CMND/CCCD", "Họ và tên", "Giới Tính", "Trạng Thái", "Số ĐT", "Địa chỉ",
				"Tỉnh/Thành phố", "Quận/Huyện", "Phường/Xã", "Ngày tạo" };
		modelQLKhachHang = new DefaultTableModel(colHeader, 0);
		tableQLKhachHang = new JTable(modelQLKhachHang);
		tableQLKhachHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tableQLKhachHang.getColumnModel().getColumn(0).setMinWidth(50);
		tableQLKhachHang.getColumnModel().getColumn(1).setMinWidth(100);
		tableQLKhachHang.getColumnModel().getColumn(2).setMinWidth(30);
		tableQLKhachHang.getColumnModel().getColumn(3).setMinWidth(100);
		tableQLKhachHang.getColumnModel().getColumn(4).setMinWidth(63);
		tableQLKhachHang.getColumnModel().getColumn(5).setMinWidth(350);
		tableQLKhachHang.getColumnModel().getColumn(6).setMinWidth(160);
		tableQLKhachHang.getColumnModel().getColumn(7).setMinWidth(160);
		tableQLKhachHang.getColumnModel().getColumn(8).setMinWidth(160);
		tableQLKhachHang.getColumnModel().getColumn(9).setMinWidth(160);

		tableQLKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane scrollPane2 = new JScrollPane(tableQLKhachHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBounds(79, 258, 805, 308);

		getContentPane().add(scrollPane2);
		scrollPane2.setViewportView(tableQLKhachHang);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(79, 227, 65, 20);
		getContentPane().add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setText("127 Trần Bá Giao");
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setBounds(179, 228, 705, 22);
		getContentPane().add(txtDiaChi);
		txtDiaChi.setColumns(10);

		txtTim = new JTextField();
		txtTim.setBounds(79, 585, 160, 25);
		getContentPane().add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\search.png"));
		btnTim.setBounds(249, 586, 119, 25);
		getContentPane().add(btnTim);

		lblGioiTinh = new JLabel("Giới tính:\r\n");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(79, 110, 97, 20);
		getContentPane().add(lblGioiTinh);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(484, 149, 97, 20);
		getContentPane().add(lblTrangThai);

		txtTrangThai = new JTextField();
		txtTrangThai.setText("Khách hàng mới");
		txtTrangThai.setBounds(595, 150, 289, 22);
		getContentPane().add(txtTrangThai);
		txtTrangThai.setColumns(10);

		String[] dsgioiTinhcbb = new String[3];
		dsgioiTinhcbb[0] = "Nam";
		dsgioiTinhcbb[1] = "Nữ";
		dsgioiTinhcbb[2] = "Khác";
		cbGioiTinh = new JComboBox(dsgioiTinhcbb);
		cbGioiTinh.setSelectedIndex(0);

		cbGioiTinh.setBounds(179, 110, 223, 22);
		getContentPane().add(cbGioiTinh);

		JLabel lblTinhTp = new JLabel("Tỉnh/Thành phố:");
		lblTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTp.setBounds(79, 153, 97, 14);
		getContentPane().add(lblTinhTp);

		JLabel lblQuanHuyen = new JLabel("Quận/Huyện:");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuanHuyen.setBounds(79, 193, 97, 14);
		getContentPane().add(lblQuanHuyen);

		JLabel lblPhuongXa = new JLabel("Phường/Xã:");
		lblPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhuongXa.setBounds(484, 194, 97, 14);
		getContentPane().add(lblPhuongXa);

		cbbTinhTp = new JComboBox();
		List<ThanhPho> dsTP = diaChiHanhChinhFacade.layDanhSachTatCaThanhPho();
		dsTPcbb = new ThanhPho[dsTP.size()];
		for (int i = 0; i < dsTPcbb.length; i++) {
			dsTPcbb[i] = dsTP.get(i);

			cbbTinhTp.addItem(dsTP.get(i));

		}
		cbbTinhTp = new JComboBox(dsTPcbb);
		cbbTinhTp.setSelectedItem(0);
		tpDangChon = (ThanhPho) cbbTinhTp.getSelectedItem();

//		cbbTinhTp.setModel(new DefaultComboBoxModel(new String[] {"Thành phố Hồ Chí Minh", "Long An", "Đăk Lăk"}));
		cbbTinhTp.setBounds(179, 149, 223, 22);
		getContentPane().add(cbbTinhTp);

		cbbQuanHuyen = new JComboBox();
		List<Quan> dsQuan = diaChiHanhChinhFacade.layDanhSachQuanTheoThanhPho(tpDangChon.getId());
		dsQuancbb = new Quan[dsQuan.size()];
		for (int i = 0; i < dsQuancbb.length; i++) {
			dsQuancbb[i] = dsQuan.get(i);

			cbbTinhTp.addItem(dsQuan.get(i));

		}
		cbbQuanHuyen = new JComboBox(dsQuancbb);
		cbbQuanHuyen.setSelectedItem(0);
		
		quanDangChon = (Quan) cbbQuanHuyen.getSelectedItem();
		cbbQuanHuyen.setBounds(179, 190, 223, 22);
		getContentPane().add(cbbQuanHuyen);

		cbbPhuongXa = new JComboBox();
		List<Phuong> dsPhuong = diaChiHanhChinhFacade.layDanhSachPhuongTheoQuan(quanDangChon.getId());
		dsPhuongcbb = new Phuong[dsPhuong.size()];
		for (int i = 0; i < dsPhuong.size(); i++) {
			dsPhuongcbb[i] = dsPhuong.get(i);

			cbbTinhTp.addItem(dsPhuong.get(i));

		}
		cbbPhuongXa = new JComboBox(dsPhuongcbb);
		cbbPhuongXa.setSelectedItem(0);
		phuongDangChon = (Phuong) cbbPhuongXa.getSelectedItem();
		
		txtDiaChi.setText(phuongDangChon.getPathWithType());
		cbbPhuongXa.setBounds(596, 190, 288, 22);
		getContentPane().add(cbbPhuongXa);

		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		

		tableQLKhachHang.addMouseListener(this);

		txtTim.addKeyListener(this);
		tableQLKhachHang.addKeyListener(this);

		dsKhachHangTable = khachHangFacade.layDanhSach100KhachHangMoiNhat();
		ganDuLieuVaoTable(dsKhachHangTable);

		cbbTinhTp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thayDoiDiaChiThanhPho();
				} catch (RemoteException e1) {

					e1.printStackTrace();
				}
			}
		});
		cbbQuanHuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					thayDoiDiaChiQuan();
				} catch (RemoteException e1) {

					e1.printStackTrace();
				}
			}
		});
		cbbPhuongXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					thayDoiDiaChiPhuongXa();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}

			}
		});

	}

	private void ganDuLieuVaoTable(List<KhachHang> dsKhachHang) {
		modelQLKhachHang.setRowCount(0);
		for (int i = 0; i < dsKhachHang.size(); i++) {
			KhachHang kh = dsKhachHang.get(i);
//			String[] colHeader = { "Số CMND/Thẻ CC", "Họ và tên KH", "Giới Tính", "Trạng Thái", "Số điện thoại",
//					"Địa chỉ", "Tỉnh/Thành phố", "Quận/Huyện", "Phường/Xã", "Ngày tạo" };
			modelQLKhachHang.addRow(new Object[] { kh.getCmnd(), kh.getTen(), kh.getGioiTinh(), kh.getTrangThai(),
					kh.getSdt(), kh.getDiaChi().getDiaChiChiTiet(), kh.getDiaChi().getThanhPho(),
					kh.getDiaChi().getQuan(), kh.getDiaChi().getPhuong(), kh.getNgayTao().toString() });
		}

	}

	protected void thayDoiDiaChiPhuongXa() throws RemoteException {
		phuongDangChon = diaChiHanhChinhFacade.timPhuongTheoTen(cbbPhuongXa.getSelectedItem().toString(),
				quanDangChon.getId());

		txtDiaChi.setText(phuongDangChon.getPathWithType());

	}

	protected void thayDoiDiaChiQuan() throws RemoteException {
		quanDangChon = diaChiHanhChinhFacade.timQuanTheoTen(cbbQuanHuyen.getSelectedItem().toString(),
				tpDangChon.getId());
		List<Phuong> dsPhuong = diaChiHanhChinhFacade.layDanhSachPhuongTheoQuan(quanDangChon.getId());
		dsPhuongcbb = new Phuong[dsPhuong.size()];
		for (int i = 0; i < dsPhuongcbb.length; i++) {
			dsPhuongcbb[i] = dsPhuong.get(i);
		}
		cbbPhuongXa.setModel(new DefaultComboBoxModel(dsPhuongcbb));
//			 cbbPhuongXa.setSelectedIndex(0);

	}

	protected void thayDoiDiaChiThanhPho() throws RemoteException {
		tpDangChon = diaChiHanhChinhFacade.timThanhPhoTheoTen(cbbTinhTp.getSelectedItem().toString());
		System.out.println(tpDangChon);
		List<Quan> dsQuan = diaChiHanhChinhFacade.layDanhSachQuanTheoThanhPho(tpDangChon.getId());
		dsQuancbb = new Quan[dsQuan.size()];
		for (int i = 0; i < dsQuancbb.length; i++) {
			dsQuancbb[i] = dsQuan.get(i);
		}

		cbbQuanHuyen.setModel(new DefaultComboBoxModel(dsQuancbb));
//		cbbQuanHuyen.setSelectedIndex(0);

	}

	public static void main(String[] args) {
		try {
			new Layout_QLKhachHang().setVisible(true);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}

	private boolean validData() {
		String CMND = txtCMND.getText().trim();
		String HoTen = txtHoTen.getText().trim();
		String SDT = txtSDT.getText().trim();
		String TrangThai = txtTrangThai.getText().trim();
		String DiaChi = txtDiaChi.getText().trim();

		if (CMND.length() > 0) {
			if (!CMND.matches("(\\d{9})|(\\d{12})")) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại, Phải nhập 9 số (Số CMND) hoặc 12 số (Căn cước)!!");
				txtCMND.requestFocus();
				return false;
			}
		}
		if (!(HoTen.length() > 0 && HoTen.matches(
				"[\\p{L}\\s\\d -]+"))) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại, Không được sử dụng ký tự đặc biệt và số!!");
			txtHoTen.requestFocus();
			return false;
		}
		if (!(SDT.length() > 0 && SDT.matches("(0){1}\\d{9}"))) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại, Số điện thoại có 10 chữ số!!");
			txtSDT.requestFocus();
			return false;
		}
		if (TrangThai.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Trạng thái không được để trống!");
			txtTrangThai.requestFocus();
			txtTrangThai.selectAll();
			return false;
		}


		return true;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableQLKhachHang)) {
			ganDuLieuVaoForm();
		}

	}

	private void ganDuLieuVaoForm() {
		KhachHang kh = dsKhachHangTable.get(tableQLKhachHang.getSelectedRow());
		txtCMND.setText(kh.getCmnd());
		txtDiaChi.setText(kh.getDiaChi().getDiaChiChiTiet());
		txtHoTen.setText(kh.getTen());
		txtSDT.setText(kh.getSdt());
		txtTrangThai.setText(kh.getTrangThai());
		try {
			tpDangChon = diaChiHanhChinhFacade.timThanhPhoTheoTen(kh.getDiaChi().getThanhPho().toString());
			quanDangChon = diaChiHanhChinhFacade.timQuanTheoTen(kh.getDiaChi().getQuan(), tpDangChon.getId());
			phuongDangChon = diaChiHanhChinhFacade.timPhuongTheoTen(kh.getDiaChi().getPhuong(), quanDangChon.getId());
			System.out.println(tpDangChon);
			for (int i = 0; i < dsTPcbb.length; i++) {
				if (tpDangChon.getId().equals(dsTPcbb[i].getId()))
					cbbTinhTp.setSelectedIndex(i);
				
			}
			for (int i = 0; i < dsQuancbb.length; i++) {
				if (quanDangChon.getId().equals(dsQuancbb[i].getId()))
					cbbQuanHuyen.setSelectedIndex(i);
				
			}
			for (int i = 0; i < dsPhuongcbb.length; i++) {
				if (phuongDangChon.getId().equals(dsPhuongcbb[i].getId()))
					cbbPhuongXa.setSelectedIndex(i);
			
			}

		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem))
			try {
				if(validData())
				themKhachHangMoi();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
		if (o.equals(btnXoa)) {
			txtCMND.setText("");
			txtHoTen.setText("");
			txtDiaChi.setText("");
			// cbGioiTinh.setSelected(false);
			txtTrangThai.setText("");

		}
		if (o.equals(btnCapNhat)) {
//			if(validData())
			try {
				CapNhat();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (o.equals(btnTim))
			try {
				timKhachHang();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
		if(o.equals(btnXoa)) xoaKhachHang();

	}

	private void timKhachHang() throws RemoteException {
		String timKhachHangQuery = txtTim.getText().toString().trim();
		if (timKhachHangQuery == "") {
			JOptionPane.showMessageDialog(this, "Ô tìm kiếm đang trống! Vui lòng thử lại!");

		} else {
			List<KhachHang> dsKhachHangTemp = khachHangFacade.timKhachHangBangTextSearch(timKhachHangQuery);
			if (dsKhachHangTemp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào!");
			} else {
				dsKhachHangTable.clear();
				dsKhachHangTable = dsKhachHangTemp;
				ganDuLieuVaoTable(dsKhachHangTemp);
			}

		}

	}

	private void themKhachHangMoi() throws RemoteException {
		String CMND = txtCMND.getText().toString().trim();

		List<KhachHang> khachHang = khachHangFacade.timKhachHangBangTextSearch(CMND);
		if ((khachHang != null) && !khachHang.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Đã có khách hàng đăng ký với CMND này!");
			txtSDT.requestFocus();
		} else {
			String SDT = txtSDT.getText().toString().trim();
			String HoTen = txtHoTen.getText().toString().trim();
			String diaChiChiTiet = txtDiaChi.getText().toString().trim();
			String gioiTinh = (String) cbGioiTinh.getSelectedItem();
			DiaChi diaChi = new DiaChi(tpDangChon.getNameWithType(), quanDangChon.getNameWithType(),
					phuongDangChon.getNameWithType(), diaChiChiTiet);
			KhachHang kh = new KhachHang(CMND, SDT, HoTen, diaChi, gioiTinh, "Khách hàng mới", new Date());
			System.out.println(kh);
			try {
				boolean checkThemKhachHang = khachHangFacade.themKhachHang(kh);
				if (checkThemKhachHang == true)
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
			}
		}

	}

	private void CapNhat() throws RemoteException {
		String SDT = txtSDT.getText().toString().trim();
		String CMND = txtCMND.getText().toString().trim();
		String HoTen = txtHoTen.getText().toString().trim();
		String diaChiChiTiet = txtDiaChi.getText().toString().trim();
		String gioiTinh = (String) cbGioiTinh.getSelectedItem();
		DiaChi diaChi = new DiaChi(tpDangChon.getNameWithType(), quanDangChon.getNameWithType(),
				phuongDangChon.getNameWithType(), diaChiChiTiet);
		KhachHang kh = new KhachHang(CMND, SDT, HoTen, diaChi, gioiTinh, "Khách hàng mới", new Date());
		System.out.println(kh);
		boolean kiemTraCapNhat = khachHangFacade.capNhatKhachHang(kh);
		if(kiemTraCapNhat == true) {
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng thử lại!");
		}
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (o.equals(txtTim))
				try {
					timKhachHang();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
		}
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			System.out.println(o);
			if (o.equals(tableQLKhachHang))
				xoaKhachHang();
		}

	}

	private void xoaKhachHang() {
		int rowDangChon = -1;
		rowDangChon = tableQLKhachHang.getSelectedRow();
		if (rowDangChon == -1) {
			JOptionPane.showMessageDialog(this, "Không có khách hàng nào được chọn để xoá! Vui lòng thử lại!");
		} else {
			int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khách hàng này không?",
					"XOÁ KHÁCH HÀNG", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				try {
					boolean ketQua = khachHangFacade.xoaKhachHang(dsKhachHangTable.get(rowDangChon));
					if(ketQua == false) JOptionPane.showMessageDialog(this, "Khách hàng đã từng mua hàng! Không thể xoá!");
					else {
						modelQLKhachHang.removeRow(rowDangChon);
						dsKhachHangTable.remove(rowDangChon);
						JOptionPane.showMessageDialog(this, "Xoá thành công!");
					}
				} catch (RemoteException e) {
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
				}
			} 
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
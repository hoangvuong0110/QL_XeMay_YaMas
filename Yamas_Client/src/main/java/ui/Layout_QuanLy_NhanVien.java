package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import app.RunYamasApplication;
import businesslogic.facade.DiaChiHanhChinhFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;
import model.DiaChi;
import model.KhachHang;
import model.NhanVien;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

import javax.swing.DefaultComboBoxModel;

public class Layout_QuanLy_NhanVien extends JFrame implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JButton btnLuu;
	private JButton btnthem;
	private JTextField txtMaNV;
	private JTextField txtMatKhau;
	private JTextField txtSDT;
	private JLabel lblChucVu;
	private JTable tableNhanVien;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnXoa;
	private DefaultTableModel modelNhanVien;
	private JComboBox cbGioiTinh;
	private JTextField txtHoTen;
	private JLabel lblTinhTp;
	private JLabel lblQuanHuyen;
	private JLabel lblPhuongXa;
	private JComboBox cbbQuanHuyen;
	private JComboBox cbbTinhTp;
	private JComboBox cbbPhuongXa;
	private ThanhPho[] dsTPcbb;
	private Quan[] dsQuancbb;
	private Phuong[] dsPhuongcbb;

	ThanhPho tpDangChon;
	Quan quanDangChon;
	Phuong phuongDangChon;
	DiaChiHanhChinhFacade diaChiHanhChinhFacade;
	NhanVienFacade nhanVienFacade;
	List<NhanVien> dsNhanVienTable;
	private JComboBox cbbTrangThai;
	private JComboBox cbbChucVu;

	public Layout_QuanLy_NhanVien() throws RemoteException {
		nhanVienFacade = RunYamasApplication.getInstance().getNhanVienFacade();
		diaChiHanhChinhFacade = RunYamasApplication.getInstance().getDiaChiHanhChinh();
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
		setResizable(false);
		// setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblSCmnd = new JLabel("S\u1ED1 CMND:");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSCmnd.setBounds(133, 80, 117, 13);
		getContentPane().add(lblSCmnd);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCMND.setBounds(268, 77, 171, 22);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblGoiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGoiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGoiTinh.setBounds(493, 80, 99, 13);
		getContentPane().add(lblGoiTinh);

		JLabel lblHoTen = new JLabel("Họ tên Nhân Viên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(133, 110, 117, 13);
		getContentPane().add(lblHoTen);

		JLabel labelDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		labelDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDiaChi.setBounds(133, 202, 117, 13);
		getContentPane().add(labelDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(268, 198, 171, 22);
		getContentPane().add(txtDiaChi);

		btnLuu = new JButton("L\u01B0u thay \u0111\u1ED5i");
		btnLuu.setIcon(
				new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\rotate-right.png"));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLuu.setBounds(826, 587, 134, 25);
		getContentPane().add(btnLuu);

		JLabel lblThngTinC = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblThngTinC.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinC.setBounds(369, 0, 291, 91);
		getContentPane().add(lblThngTinC);

		btnthem = new JButton("Thêm");
		btnthem.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\add.png"));
		btnthem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnthem.setBounds(508, 587, 134, 25);
		getContentPane().add(btnthem);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(268, 137, 171, 22);
		getContentPane().add(txtMaNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(133, 140, 117, 13);
		getContentPane().add(lblMaNV);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMtKhu.setBounds(493, 140, 99, 13);
		getContentPane().add(lblMtKhu);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(580, 137, 252, 22);
		getContentPane().add(txtMatKhau);

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(493, 172, 99, 13);
		getContentPane().add(lblTrangThai);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(133, 172, 117, 13);
		getContentPane().add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSDT.setColumns(10);
		txtSDT.setBounds(268, 169, 171, 22);
		getContentPane().add(txtSDT);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChucVu.setBounds(493, 110, 99, 13);
		getContentPane().add(lblChucVu);

		String[] colHeader = { "Mã NV", "Số CMND", "Họ Tên NV", "Giới Tính", "Trạng Thái", "Số điện thoại", "Chức vụ",
				"Mật khẩu", "Địa chỉ", "Phường/Xã", "Quận/Huyện", "Tỉnh/Thành phố" };

		modelNhanVien = new DefaultTableModel(colHeader, 0);
		tableNhanVien = new JTable(modelNhanVien) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				// Alternate row color
				if (!isRowSelected(row))
					c.setBackground(row % 3 == 0 ? getBackground() : Color.LIGHT_GRAY);

				if (!isRowSelected(row)) {
					c.setBackground(modelNhanVien.getValueAt(row, 4).equals("Đang làm việc") ? getBackground()
							: new Color(255, 102, 102));

				}

				return c;
			}
		};
		tableNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tableNhanVien.getColumnModel().getColumn(0).setMinWidth(50);
		tableNhanVien.getColumnModel().getColumn(1).setMinWidth(100);
		tableNhanVien.getColumnModel().getColumn(2).setMinWidth(200);
		tableNhanVien.getColumnModel().getColumn(3).setMinWidth(50);
		tableNhanVien.getColumnModel().getColumn(4).setMinWidth(200);
		tableNhanVien.getColumnModel().getColumn(5).setMinWidth(100);
		tableNhanVien.getColumnModel().getColumn(6).setMinWidth(40);
		tableNhanVien.getColumnModel().getColumn(7).setMinWidth(50);
		tableNhanVien.getColumnModel().getColumn(8).setMinWidth(400);
		tableNhanVien.getColumnModel().getColumn(9).setMinWidth(150);
		tableNhanVien.getColumnModel().getColumn(10).setMinWidth(150);
		tableNhanVien.getColumnModel().getColumn(11).setMinWidth(150);

		JScrollPane scrollPane = new JScrollPane(tableNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(18, 287, 942, 287);
		getContentPane().add(scrollPane);

		scrollPane.setViewportView(tableNhanVien);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTim.setBounds(18, 587, 171, 25);
		getContentPane().add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\search.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTim.setBounds(206, 587, 134, 25);
		getContentPane().add(btnTim);

		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(
				new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\time-delete.png"));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(666, 587, 134, 25);
		getContentPane().add(btnXoa);

		String[] dsgioiTinhcbb = new String[3];
		dsgioiTinhcbb[0] = "Nam";
		dsgioiTinhcbb[1] = "Nữ";
		dsgioiTinhcbb[2] = "Khác";
		cbGioiTinh = new JComboBox(dsgioiTinhcbb);
		cbGioiTinh.setSelectedIndex(0);
		cbGioiTinh.setBounds(580, 76, 252, 22);
		getContentPane().add(cbGioiTinh);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(268, 107, 171, 22);
		getContentPane().add(txtHoTen);
		txtHoTen.setColumns(10);

		lblTinhTp = new JLabel("Tỉnh/Thành Phố:");
		lblTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTp.setBounds(470, 201, 101, 14);
		getContentPane().add(lblTinhTp);

		lblQuanHuyen = new JLabel("Quận/Huyện:");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuanHuyen.setBounds(133, 233, 87, 14);
		getContentPane().add(lblQuanHuyen);

		lblPhuongXa = new JLabel("Phường/Xã:");
		lblPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhuongXa.setBounds(491, 233, 80, 14);
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

		cbbTinhTp.setBounds(580, 198, 252, 22);
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

		cbbQuanHuyen.setBounds(268, 230, 171, 22);
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

		cbbPhuongXa.setBounds(580, 230, 252, 22);
		getContentPane().add(cbbPhuongXa);

		String[] dsTrangThaicbb = new String[2];
		dsTrangThaicbb[0] = "Đang làm việc";
		dsTrangThaicbb[1] = "Đã nghỉ việc";
		cbbTrangThai = new JComboBox(dsTrangThaicbb);

		cbbTrangThai.setBounds(580, 167, 252, 22);
		getContentPane().add(cbbTrangThai);

		String[] dsChucVucbb = new String[3];
		dsChucVucbb[0] = "QL";
		dsChucVucbb[1] = "NV";
		cbbChucVu = new JComboBox(dsChucVucbb);
		cbbChucVu.setBounds(580, 106, 252, 22);
		getContentPane().add(cbbChucVu);

		txtMaNV.setEditable(false);

		JLabel lblViChc = new JLabel("* Với chức năng \"Thêm\". Mã nhân viên sẽ được tự động tạo ");
		lblViChc.setForeground(Color.RED);
		lblViChc.setBounds(133, 269, 703, 16);
		getContentPane().add(lblViChc);

		btnLuu.addActionListener(this);
		btnthem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);

		txtTim.addKeyListener(this);

		tableNhanVien.addMouseListener(this);

		dsNhanVienTable = nhanVienFacade.layDanhSach100NhanVienMoiNhat();
		ganDuLieuVaoTable();
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

	private void ganDuLieuVaoTable() {
		modelNhanVien.setRowCount(0);
		for (int i = 0; i < dsNhanVienTable.size(); i++) {
			NhanVien nv = dsNhanVienTable.get(i);
			String[] colHeader = { "Mã NV", "Số CMND", "Họ Tên NV", "Giới Tính", "Trạng Thái", "Số điện thoại",
					"Chức vụ", "Mật khẩu", "Địa chỉ", "Phường/Xã", "Quận/Huyện", "Tỉnh/Thành phố" };

			modelNhanVien.addRow(new Object[] { nv.getMaNhanVien(), nv.getCmnd(), nv.getTen(), nv.getGioiTinh(),
					nv.getTrangThai(), nv.getSdt(), nv.getChucVu(), nv.getMatKhau(), nv.getDiaChi().getDiaChiChiTiet(),
					nv.getDiaChi().getPhuong(), nv.getDiaChi().getQuan(), nv.getDiaChi().getThanhPho() });
//			modelNhanVien.setRow
		}

	}

	private void ganDuLieuVaoUI() {
		NhanVien kh = dsNhanVienTable.get(tableNhanVien.getSelectedRow());
		txtCMND.setText(kh.getCmnd());

		txtDiaChi.setText(kh.getDiaChi().getDiaChiChiTiet());
		txtHoTen.setText(kh.getTen());
		txtMatKhau.setText(kh.getMatKhau());
		txtMaNV.setText(kh.getMaNhanVien());
		txtSDT.setText(kh.getSdt());

		cbbTrangThai.setSelectedItem(kh.getTrangThai());
		cbbChucVu.setSelectedItem(kh.getChucVu());
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

	private boolean validData() {
		String CMND = txtCMND.getText().trim();
		String Ho = txtHoTen.getText().trim();
		String MK = txtMatKhau.getText().trim();
		String DiaChi = txtDiaChi.getText().trim();


		if (CMND.length() > 0) {
			if (!CMND.matches("(\\d{9})|(\\d{12})")) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại, Trùng Mã số NV hoặc Số CMND!!");
				txtCMND.requestFocus();
				return false;
			}
		}
		if (!(Ho.length() > 0 && Ho.matches(
				"[\\p{L}\\s\\d -]+"))) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại, Không được sử dụng ký tự đặc biệt và số!!");
			txtHoTen.requestFocus();
			return false;
		}

		if (!(MK.length() > 0 && MK.matches("[a-zA-Z0-9 ]+"))) {
			JOptionPane.showMessageDialog(this,
					"Thêm thất bại, Mật khẩu chỉ bao gồm chữ cái và số có phân biệt hoa thường!!");
			txtMatKhau.requestFocus();
			return false;
		}
		if (!(DiaChi.matches(
				"[\\p{L}\\s\\d -]+"))) {
			// địa chỉ có kiểu X/Y/Z tên đường, tên phường, tên quận, tên thành phố : 65/3
			// Phạm Văn Bach, Phường 12, Quận Tân Bình, tp Hồ Chính Minh
			JOptionPane.showMessageDialog(this,
					"Thêm thất bại,địa chỉ có kiểu X/Y/Z tên đường, tên phường, tên quận, tên thành phố!!");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableNhanVien)) {
			ganDuLieuVaoUI();
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
		if (o.equals(btnthem))
//			if (validData() == true)
				try {
					ThemNV();
				} catch (RemoteException e1) {

					e1.printStackTrace();
				}

		if (o.equals(btnLuu)) {
			try {
				if (validData())
					CapNhat();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnXoa)) {
			xoaNV();

		}
		if (o.equals(btnTim))
			try {
				timNhanVien();
			} catch (RemoteException e1) {

				e1.printStackTrace();
			}

	}

	public void CapNhat() throws RemoteException {
		String maNhanVien = txtMaNV.getText().trim();
		String soCMND = txtCMND.getText().trim();
		String matKhau = txtMatKhau.getText().trim();
		String diaChiChitiet = txtDiaChi.getText().trim();
		String tenNhanVien = txtHoTen.getText().trim();
		String gioiTinh = (String) cbGioiTinh.getSelectedItem();
		String sdt = txtSDT.getText().trim();
		DiaChi diaChi = new DiaChi(tpDangChon.getNameWithType(), quanDangChon.getNameWithType(),
				phuongDangChon.getNameWithType(), diaChiChitiet);

		NhanVien nv = new NhanVien(maNhanVien, matKhau, soCMND, sdt, tenNhanVien, diaChi, gioiTinh,
				cbbChucVu.getSelectedItem().toString(), cbbTrangThai.getSelectedItem().toString(), new Date());
		boolean check = nhanVienFacade.capNhatThongTinNhanVien(nv);
		if (check == true)
			JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!!");
		else
			JOptionPane.showMessageDialog(this, "Cập nhật thông tin thất bại! Vui lòng thử lại");

	}

	public void timNhanVien() throws RemoteException {
		String timNhanVienQuery = txtTim.getText().toString().trim();
		if (timNhanVienQuery == "") {
			JOptionPane.showMessageDialog(this, "Ô tìm kiếm đang trống! Vui lòng thử lại!");

		} else {
			List<NhanVien> dsNhanVienTemp = nhanVienFacade.timNhanVienBangTextSearch(timNhanVienQuery);
			if (dsNhanVienTemp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào!");
			} else {
				dsNhanVienTable.clear();
				dsNhanVienTable = dsNhanVienTemp;
				ganDuLieuVaoTable();
			}

		}
	}

	public void xoaNV() {
		int rowDangChon = -1;
		rowDangChon = tableNhanVien.getSelectedRow();
		if (rowDangChon == -1) {
			JOptionPane.showMessageDialog(this, "Không có nhân viên nào được chọn để xoá! Vui lòng thử lại!");
		} else {
			int reply = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá nhân viên này không?",
					"XOÁ NHÂN VIÊN", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				try {
					boolean ketQua = nhanVienFacade.xoaNhanVien(dsNhanVienTable.get(rowDangChon));
					if (ketQua == false)
						JOptionPane.showMessageDialog(this, "Nhân viên đã từng hoạt động! Không thể xoá!");
					else {
						modelNhanVien.removeRow(rowDangChon);
						dsNhanVienTable.remove(rowDangChon);
						JOptionPane.showMessageDialog(this, "Xoá thành công!");
					}
				} catch (RemoteException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
				}
			}
		}

	}

	private void XoahetDLTableModel() {
		int s = tableNhanVien.getRowCount();
		System.out.println(s);
		for (int i = 0; i <= s; i++) {
			modelNhanVien.removeRow(i);
			s = tableNhanVien.getRowCount();

		}
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
	}

	private void ThemNV() throws RemoteException {
		String maNV = txtMaNV.getText().toString().trim();
		List<NhanVien> dsNVCheck = nhanVienFacade.timNhanVienBangTextSearch(txtCMND.getText().trim());
		if (dsNVCheck.size() != 0) {
			JOptionPane.showMessageDialog(this, "CMND nhân viên đã có trong hệ thống");
			txtCMND.requestFocus();
		} else {
			String SDT = txtSDT.getText().toString().trim();
			String HoTen = txtHoTen.getText().toString().trim();
			String diaChiChiTiet = txtDiaChi.getText().toString().trim();
			String matKhau = txtMatKhau.getText().toString().trim();
			String cmnd = txtCMND.getText().toString().trim();
			String trangThai = (String) cbbTrangThai.getSelectedItem();
			String gioiTinh = (String) cbGioiTinh.getSelectedItem();
			String chucVu = (String) cbbChucVu.getSelectedItem();
			
			DiaChi diaChi = new DiaChi(tpDangChon.getNameWithType(), quanDangChon.getNameWithType(),
					phuongDangChon.getNameWithType(), diaChiChiTiet);
			NhanVien nv = new NhanVien("", matKhau, cmnd, SDT, HoTen, diaChi, gioiTinh, chucVu, trangThai,
					new Date());
			System.out.println(nv);
			try {
				boolean checkThemNhanVien = nhanVienFacade.themNhanVien(nv);
				if (checkThemNhanVien == true)
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				else JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");

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
				try {
					timNhanVien();
				} catch (RemoteException e1) {

					e1.printStackTrace();
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

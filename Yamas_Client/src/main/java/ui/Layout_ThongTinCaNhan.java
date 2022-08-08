package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;

import app.RunYamasApplication;
import businesslogic.facade.DiaChiHanhChinhFacade;
import businesslogic.facade.NhanVienFacade;
import model.DiaChi;
import model.NhanVien;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Layout_ThongTinCaNhan extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCMND;
	private JTextField txtHoNV;
	private JTextField txtDiaChi;
	private JButton btnLuu;
	private JButton btnHoanTac;
	private JTextField txtMaNV;
	private JPasswordField txtMatKhau;
	private JLabel lblChucVu;
	private JTextField txtChucVu;
	private JTextField txtSDT;
	private JTextField txtTrangThai;
	private JComboBox cbbTinhTp;
	private JComboBox cbbQuanHuyen;
	private JComboBox cbbPhuongXa;
	private JComboBox cbbGioiTinh;
	NhanVien nhanVien;
	ThanhPho tpDangChon;
	Quan quanDangChon;
	Phuong phuongDangChon;
	NhanVienFacade nhanVienFacade;
	DiaChiHanhChinhFacade diaChiHanhChinhFacade;
	private JButton btnDoiMatKhau;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Layout_ThongTinCaNhan(NhanVien nv) throws RemoteException {
		
		nhanVienFacade = RunYamasApplication.getInstance().getNhanVienFacade();
		diaChiHanhChinhFacade = RunYamasApplication.getInstance().getDiaChiHanhChinh();
		nv = nhanVienFacade.timNhanVienTuId(nv.getMaNhanVien());
		nhanVien = nv;
		setTitle("Thông Tin Cá Nhân");
		try {
//			Connect_Data.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
		setSize(1000,600);
		setResizable(false);
		//setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblSCmnd = new JLabel("S\u1ED1 CMND:");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSCmnd.setBounds(133, 137, 117, 13);
		getContentPane().add(lblSCmnd);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCMND.setBounds(268, 134, 171, 22);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblGoiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGoiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGoiTinh.setBounds(493, 137, 99, 13);
		getContentPane().add(lblGoiTinh);
		
		JLabel lblHoten = new JLabel("Họ tên nhân viên\r\n");
		lblHoten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoten.setBounds(133, 190, 117, 13);
		getContentPane().add(lblHoten);
		
		txtHoNV = new JTextField();
		txtHoNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHoNV.setColumns(10);
		txtHoNV.setBounds(268, 187, 564, 22);
		getContentPane().add(txtHoNV);
		
		JLabel labelDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		labelDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDiaChi.setBounds(133, 447, 117, 13);
		getContentPane().add(labelDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(268, 443, 564, 22);
		getContentPane().add(txtDiaChi);
		
		 btnLuu = new JButton("L\u01B0u thay \u0111\u1ED5i");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLuu.setBounds(676, 513, 156, 34);
		btnLuu.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\disk .png"));
		getContentPane().add(btnLuu);
		
		JLabel lblThngTinC = new JLabel("TH\u00D4NG TIN C\u00C1 NH\u00C2N");
		lblThngTinC.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinC.setBounds(382, 10, 291, 113);
		getContentPane().add(lblThngTinC);
		
		 btnHoanTac = new JButton("Ho\u00E0n t\u00E1c");
		 btnHoanTac.setIcon(new ImageIcon("C:\\Users\\Hoang Vuong\\OneDrive\\Desktop\\BTL_PhanTan\\BTL\\icon\\angle-double-left.png"));
		btnHoanTac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHoanTac.setBounds(468, 513, 156, 35);
		getContentPane().add(btnHoanTac);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(268, 238, 171, 22);
		getContentPane().add(txtMaNV);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(133, 241, 117, 13);
		getContentPane().add(lblMaNV);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMtKhu.setBounds(493, 240, 99, 13);
		getContentPane().add(lblMtKhu);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(580, 238, 252, 22);
		getContentPane().add(txtMatKhau);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(133, 289, 117, 13);
		getContentPane().add(lblSDT);
		
		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChucVu.setBounds(493, 289, 99, 13);
		getContentPane().add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(580, 287, 252, 22);
		getContentPane().add(txtChucVu);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(268, 286, 171, 22);
		getContentPane().add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(133, 333, 79, 19);
		getContentPane().add(lblTrangThai);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setBounds(268, 333, 171, 22);
		getContentPane().add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JLabel lblPhuongXa = new JLabel("Phường/xã:");
		lblPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhuongXa.setBounds(478, 389, 79, 19);
		getContentPane().add(lblPhuongXa);
		
		JLabel lblQuanHuyen = new JLabel("Quận/huyện:");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuanHuyen.setBounds(133, 391, 99, 14);
		getContentPane().add(lblQuanHuyen);
		
		JLabel lblTinhTp = new JLabel("Tỉnh/thành phố:");
		lblTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTp.setBounds(477, 335, 93, 14);
		getContentPane().add(lblTinhTp);
		
		cbbTinhTp = new JComboBox();
//		cbbTinhTp.setModel(new DefaultComboBoxModel(new String[] {"Thành phố Hồ Chí Minh", "Long An", "Đăk Lăk"}));
		//Xử lý địa chỉ
		List<ThanhPho> dsTP = diaChiHanhChinhFacade.layDanhSachTatCaThanhPho();
		String[] dsTPcbb = new String[dsTP.size()];
		for(int i = 0; i < dsTPcbb.length; i++) {
		    dsTPcbb[i] = dsTP.get(i).getNameWithType();
		 
		    cbbTinhTp.addItem(dsTP.get(i).getNameWithType());
		    
		}
		 cbbTinhTp = new JComboBox(dsTPcbb);
		 cbbTinhTp.setSelectedItem(nv.getDiaChi().getThanhPho());
		 

		cbbTinhTp.setBounds(580, 332, 252, 22);
		getContentPane().add(cbbTinhTp);
		
//		cbbQuanHuyen = new JComboBox();
//		cbbQuanHuyen.setModel(new DefaultComboBoxModel(new String[] {"Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12 ", "Quận Gò Vấp", "Quận Bình Thạnh", "Quận Phú Nhuận"}));
		 tpDangChon = diaChiHanhChinhFacade.timThanhPhoTheoTen(nv.getDiaChi().getThanhPho());
		 List<Quan> dsQuan = diaChiHanhChinhFacade.layDanhSachQuanTheoThanhPho(tpDangChon.getId());
			String[] dsQuancbb = new String[dsQuan.size()];
			for(int i = 0; i < dsQuancbb.length; i++) {
			    dsQuancbb[i] = dsQuan.get(i).getNameWithType();
			}
			 cbbQuanHuyen = new JComboBox(dsQuancbb);
			 cbbQuanHuyen.setSelectedItem(nv.getDiaChi().getQuan());
			 
		cbbQuanHuyen.setBounds(268, 388, 171, 22);
		getContentPane().add(cbbQuanHuyen);
		
//		cbbPhuongXa = new JComboBox();
//		cbbPhuongXa.setModel(new DefaultComboBoxModel(new String[] {"Phường 1", "Phường 2", "Phường 3", "Phường 4 ", "Phường 5", "Phường 6 ", "Phường 7", "Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14", "Phường 15", "Phường 16"}));
		 quanDangChon = diaChiHanhChinhFacade.timQuanTheoTen(nv.getDiaChi().getQuan(),tpDangChon.getId());
		 List<Phuong> dsPhuong = diaChiHanhChinhFacade.layDanhSachPhuongTheoQuan(quanDangChon.getId());
			String[] dsPhuongcbb = new String[dsPhuong.size()];
			for(int i = 0; i < dsPhuongcbb.length; i++) {
			    dsPhuongcbb[i] = dsPhuong.get(i).getNameWithType();
			}
			 cbbPhuongXa = new JComboBox(dsPhuongcbb);
			 cbbPhuongXa.setSelectedItem(nv.getDiaChi().getPhuong());
		cbbPhuongXa.setBounds(580, 388, 252, 22);
		getContentPane().add(cbbPhuongXa);
		
		cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ", "Khác"}));
		cbbGioiTinh.setBounds(580, 133, 252, 22);
		getContentPane().add(cbbGioiTinh);
		
		 btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoiMatKhau.setBounds(268, 513, 156, 35);
		getContentPane().add(btnDoiMatKhau);
		
		txtTrangThai.setEditable(false);
		txtCMND.setEditable(false);
		txtMatKhau.setEditable(false);
				
		btnHoanTac.addActionListener(this);
		btnLuu.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		
		//Gán thông tin nhân viên vào UI
		ganThongTinVaoUI(nv);
		cbbTinhTp.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        try {
					thayDoiDiaChiThanhPho();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
		    }
		});
		cbbQuanHuyen.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        try {
					thayDoiDiaChiQuan();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
		    }
		});
		cbbPhuongXa.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       
					try {
						thayDoiDiaChiPhuongXa();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
		    }
		});
		
	

		
		
		
	}
	protected void thayDoiDiaChiPhuongXa() throws RemoteException {
		phuongDangChon = diaChiHanhChinhFacade.timPhuongTheoTen(cbbPhuongXa.getSelectedItem().toString(),quanDangChon.getId());
		
		txtDiaChi.setText(phuongDangChon.getPathWithType());
		
	}
	protected void thayDoiDiaChiQuan() throws RemoteException {
		quanDangChon = diaChiHanhChinhFacade.timQuanTheoTen(cbbQuanHuyen.getSelectedItem().toString(),tpDangChon.getId());
		 List<Phuong> dsPhuong = diaChiHanhChinhFacade.layDanhSachPhuongTheoQuan(quanDangChon.getId());
			String[] dsPhuongcbb = new String[dsPhuong.size()];
			for(int i = 0; i < dsPhuongcbb.length; i++) {
			    dsPhuongcbb[i] = dsPhuong.get(i).getNameWithType();
			}
			cbbPhuongXa.setModel(new DefaultComboBoxModel(dsPhuongcbb));
			 cbbPhuongXa.setSelectedIndex(0);
		
	}
	protected void thayDoiDiaChiThanhPho() throws RemoteException {
		tpDangChon = diaChiHanhChinhFacade.timThanhPhoTheoTen(cbbTinhTp.getSelectedItem().toString());
		System.out.println(tpDangChon);
		List<Quan> dsQuan = diaChiHanhChinhFacade.layDanhSachQuanTheoThanhPho(tpDangChon.getId());
		String[] dsQuancbb = new String[dsQuan.size()];
		for(int i = 0; i < dsQuancbb.length; i++) {
		    dsQuancbb[i] = dsQuan.get(i).getNameWithType();
		}
		cbbQuanHuyen.setModel(new DefaultComboBoxModel(dsQuancbb));
		cbbQuanHuyen.setSelectedIndex(0);
		
		
	}
	/**
	 * Gán thông tin nhân viên vào UI
	 * @param nv
	 */
	private void ganThongTinVaoUI(NhanVien nv) {
		if(nv.getChucVu().equals("NV")) txtChucVu.setText("Nhân viên");
		if(nv.getChucVu() == "QL") txtChucVu.setText("Quản lý");
		txtCMND.setText(nv.getCmnd());
		txtDiaChi.setText(nv.getDiaChi().getDiaChiChiTiet());
		txtHoNV.setText(nv.getTen());
		txtMaNV.setText(nv.getMaNhanVien());
		txtMatKhau.setText(nv.getMatKhau());
		txtSDT.setText(nv.getSdt());
		txtTrangThai.setText(nv.getTrangThai());
		cbbGioiTinh.setSelectedItem(nv.getGioiTinh());
		
		
	}
	/**
	 * Kiểm tra tính hợp lệ của dữ liệu đầu vào
	 * @return true nếu dữ liệu hợp lệ
	 */
	private boolean validData() {
		String CMND  = txtCMND.getText().trim();
		String ten = txtHoNV.getText().trim();
		String MK =  String.valueOf(txtMatKhau.getPassword());

		String DiaChi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String trangthai = txtTrangThai.getText().trim();
		if (CMND.length() > 0 )
		{
			if (!CMND.matches("(\\d{9})|(\\d{12})")) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại, Số CMND 9 số , căn cước 12 số!!");
				txtCMND.requestFocus();
				return false;
			}
		}
		if (!(sdt.length() > 0 && sdt.matches("(0){1}\\d{9}"))) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại, Số điện thoại có 10 chữ số!!");
			txtSDT.requestFocus();
			return false;
		}
		
		if (!(MK.length() > 0 && MK.matches("[a-zA-Z0-9 ]+"))) {
			JOptionPane.showMessageDialog(this, "Thêm thất bại, Mật khẩu bao gồm chữ cái viết hoa, viết thường và số!!");
			txtMatKhau.requestFocus();
			return false;
		}
		if (trangthai.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Trạng thái không được để trống!");
			txtTrangThai.requestFocus();
			txtTrangThai.selectAll();
			return false;
		}
		if (!(DiaChi.length() > 0 && DiaChi.matches("[\\p{L}\\s0-9()\\/_.,+-]+"))) {
			//địa chỉ có kiểu X/Y/Z tên đường, tên phường, tên quận, tên thành phố : 65/3 Phạm Văn Bach, Phường 12, Quận Tân Bình, tp Hồ Chính Minh 
			JOptionPane.showMessageDialog(this, "Thêm thất bại,địa chỉ có kiểu X/Y/Z tên đường!!");
			txtDiaChi.requestFocus();
			return false;
		}
		return true;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
		
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
		if(o.equals(btnHoanTac)) LayThongTin();
		
		if(o.equals(btnLuu)) {
			if(validData())
				try {
					CapNhat();
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			
		}
	if(o.equals(btnDoiMatKhau)) doiMatKhau();
		
	
}
	private void doiMatKhau() {
		// TODO Auto-generated method stub
		new  Layout_DoiMatKhau(nhanVien).setVisible(true);
		
	}
	private void CapNhat() throws RemoteException {
		NhanVien nhanVienCapNhat = new NhanVien(nhanVien.getMaNhanVien(), nhanVien.getMatKhau(), nhanVien.getCmnd(), txtSDT.getText().trim(), txtHoNV.getText().trim(), new DiaChi(cbbTinhTp.getSelectedItem().toString(), cbbQuanHuyen.getSelectedItem().toString(), cbbPhuongXa.getSelectedItem().toString(), txtDiaChi.getText().trim()), cbbGioiTinh.getSelectedItem().toString(), nhanVien.getChucVu(), nhanVien.getTrangThai(),new Date());
		boolean ktCapNhat = nhanVienFacade.capNhatThongTinNhanVien(nhanVienCapNhat);
		if (ktCapNhat == true ) {
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			nhanVien = nhanVienCapNhat;
		}
		else JOptionPane.showMessageDialog(this, "Cập nhật không thành công!");
		
	}
	private void LayThongTin() {
	
		
	}
}

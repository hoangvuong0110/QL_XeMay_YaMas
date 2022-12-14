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
		setTitle("Th??ng Tin C?? Nh??n");
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
		
		JLabel lblHoten = new JLabel("H??? t??n nh??n vi??n\r\n");
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
		
		JLabel lblMaNV = new JLabel("M?? Nh??n Vi??n:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(133, 241, 117, 13);
		getContentPane().add(lblMaNV);
		
		JLabel lblMtKhu = new JLabel("M???t kh???u:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMtKhu.setBounds(493, 240, 99, 13);
		getContentPane().add(lblMtKhu);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(580, 238, 252, 22);
		getContentPane().add(txtMatKhau);
		
		JLabel lblSDT = new JLabel("S??? ??i???n tho???i:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(133, 289, 117, 13);
		getContentPane().add(lblSDT);
		
		lblChucVu = new JLabel("Ch???c v???:");
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
		
		JLabel lblTrangThai = new JLabel("Tr???ng th??i:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(133, 333, 79, 19);
		getContentPane().add(lblTrangThai);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setBounds(268, 333, 171, 22);
		getContentPane().add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		JLabel lblPhuongXa = new JLabel("Ph?????ng/x??:");
		lblPhuongXa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhuongXa.setBounds(478, 389, 79, 19);
		getContentPane().add(lblPhuongXa);
		
		JLabel lblQuanHuyen = new JLabel("Qu???n/huy???n:");
		lblQuanHuyen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuanHuyen.setBounds(133, 391, 99, 14);
		getContentPane().add(lblQuanHuyen);
		
		JLabel lblTinhTp = new JLabel("T???nh/th??nh ph???:");
		lblTinhTp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTp.setBounds(477, 335, 93, 14);
		getContentPane().add(lblTinhTp);
		
		cbbTinhTp = new JComboBox();
//		cbbTinhTp.setModel(new DefaultComboBoxModel(new String[] {"Th??nh ph??? H??? Ch?? Minh", "Long An", "????k L??k"}));
		//X??? l?? ?????a ch???
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
//		cbbQuanHuyen.setModel(new DefaultComboBoxModel(new String[] {"Qu???n 1", "Qu???n 2", "Qu???n 3", "Qu???n 4", "Qu???n 5", "Qu???n 6", "Qu???n 7", "Qu???n 8", "Qu???n 9", "Qu???n 10", "Qu???n 11", "Qu???n 12 ", "Qu???n G?? V???p", "Qu???n B??nh Th???nh", "Qu???n Ph?? Nhu???n"}));
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
//		cbbPhuongXa.setModel(new DefaultComboBoxModel(new String[] {"Ph?????ng 1", "Ph?????ng 2", "Ph?????ng 3", "Ph?????ng 4 ", "Ph?????ng 5", "Ph?????ng 6 ", "Ph?????ng 7", "Ph?????ng 8", "Ph?????ng 9", "Ph?????ng 10", "Ph?????ng 11", "Ph?????ng 12", "Ph?????ng 13", "Ph?????ng 14", "Ph?????ng 15", "Ph?????ng 16"}));
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
		cbbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N???", "Kh??c"}));
		cbbGioiTinh.setBounds(580, 133, 252, 22);
		getContentPane().add(cbbGioiTinh);
		
		 btnDoiMatKhau = new JButton("?????i m???t kh???u");
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoiMatKhau.setBounds(268, 513, 156, 35);
		getContentPane().add(btnDoiMatKhau);
		
		txtTrangThai.setEditable(false);
		txtCMND.setEditable(false);
		txtMatKhau.setEditable(false);
				
		btnHoanTac.addActionListener(this);
		btnLuu.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		
		//G??n th??ng tin nh??n vi??n v??o UI
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
	 * G??n th??ng tin nh??n vi??n v??o UI
	 * @param nv
	 */
	private void ganThongTinVaoUI(NhanVien nv) {
		if(nv.getChucVu().equals("NV")) txtChucVu.setText("Nh??n vi??n");
		if(nv.getChucVu() == "QL") txtChucVu.setText("Qu???n l??");
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
	 * Ki???m tra t??nh h???p l??? c???a d??? li???u ?????u v??o
	 * @return true n???u d??? li???u h???p l???
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
				JOptionPane.showMessageDialog(this, "Th??m th???t b???i, S??? CMND 9 s??? , c??n c?????c 12 s???!!");
				txtCMND.requestFocus();
				return false;
			}
		}
		if (!(sdt.length() > 0 && sdt.matches("(0){1}\\d{9}"))) {
			JOptionPane.showMessageDialog(this, "Th??m th???t b???i, S??? ??i???n tho???i c?? 10 ch??? s???!!");
			txtSDT.requestFocus();
			return false;
		}
		
		if (!(MK.length() > 0 && MK.matches("[a-zA-Z0-9 ]+"))) {
			JOptionPane.showMessageDialog(this, "Th??m th???t b???i, M???t kh???u bao g???m ch??? c??i vi???t hoa, vi???t th?????ng v?? s???!!");
			txtMatKhau.requestFocus();
			return false;
		}
		if (trangthai.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tr???ng th??i kh??ng ???????c ????? tr???ng!");
			txtTrangThai.requestFocus();
			txtTrangThai.selectAll();
			return false;
		}
		if (!(DiaChi.length() > 0 && DiaChi.matches("[\\p{L}\\s0-9()\\/_.,+-]+"))) {
			//?????a ch??? c?? ki???u X/Y/Z t??n ???????ng, t??n ph?????ng, t??n qu???n, t??n th??nh ph??? : 65/3 Ph???m V??n Bach, Ph?????ng 12, Qu???n T??n B??nh, tp H??? Ch??nh Minh 
			JOptionPane.showMessageDialog(this, "Th??m th???t b???i,?????a ch??? c?? ki???u X/Y/Z t??n ???????ng!!");
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
			JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng!");
			nhanVien = nhanVienCapNhat;
		}
		else JOptionPane.showMessageDialog(this, "C???p nh???t kh??ng th??nh c??ng!");
		
	}
	private void LayThongTin() {
	
		
	}
}

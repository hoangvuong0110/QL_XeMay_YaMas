package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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

import model.KhachHang;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Layout_XemThongTinKhachHang extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JButton btnXoaTrang;
	private JLabel lblGioiTinh;
	private JLabel lblTrangThai;
	private JTextField txtTrangThai;
	private String[] s= {"Nam","Nữ","Khác"};
	KhachHang khachHang;
	private JComboBox cbGioiTinh;
	public Layout_XemThongTinKhachHang(KhachHang kh) {
		khachHang = kh;
		setTitle("Quản Lý Khách Hàng\r\n");
		try {
			//Connect_Data.getInstance().connect();
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

		setSize(800, 400);
		setResizable(true);
		// setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblXemThongTin = new JLabel("Xem Thông Tin Khách Hàng");
		lblXemThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblXemThongTin.setBounds(179, 10, 348, 45);
		getContentPane().add(lblXemThongTin);

		JLabel lblHoTen = new JLabel("Họ và tên Khách Hàng :");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(79, 69, 146, 20);
		getContentPane().add(lblHoTen);

		JLabel lblCMND = new JLabel("Số CMND :");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(79, 110, 78, 20);
		getContentPane().add(lblCMND);

		JLabel lblSoDT = new JLabel("Số điện thoại:\r\n");
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoDT.setBounds(345, 110, 97, 20);
		getContentPane().add(lblSoDT);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHoTen.setBounds(220, 69, 474, 22);
		getContentPane().add(txtHoTen);
		txtHoTen.setColumns(10);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCMND.setBounds(179, 110, 140, 22);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSDT.setBounds(457, 110, 237, 22);
		getContentPane().add(txtSDT);
		txtSDT.setColumns(10);

		 btnXoaTrang = new JButton("Sửa Thông Tin");
		 btnXoaTrang.setIcon(new ImageIcon(""));
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTrang.setBounds(563, 299, 133, 25);
		getContentPane().add(btnXoaTrang);


		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(79, 191, 65, 20);
		getContentPane().add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setBounds(179, 191, 515, 22);
		getContentPane().add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		lblGioiTinh = new JLabel("Giới tính:\r\n");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(79, 149, 97, 20);
		getContentPane().add(lblGioiTinh);
		
		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(345, 149, 97, 20);
		getContentPane().add(lblTrangThai);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setBounds(456, 150, 238, 22);
		getContentPane().add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		 cbGioiTinh = new JComboBox(s);
		cbGioiTinh.setBounds(179, 149, 140, 22);
		getContentPane().add(cbGioiTinh);
		btnXoaTrang.addActionListener(this);
		
		GanThongTinKhachHangVaoUI();

		
		
	}
	private void GanThongTinKhachHangVaoUI() {
		txtCMND.setText(khachHang.getCmnd().toString());
		txtDiaChi.setText(khachHang.getDiaChi().getDiaChiChiTiet());
		txtHoTen.setText(khachHang.getTen());
		txtSDT.setText(khachHang.getSdt());
		txtTrangThai.setText(khachHang.getTrangThai());
		cbGioiTinh.setSelectedItem(khachHang.getGioiTinh());
		
	}
	public static void main(String[] args) {
//		new Layout_XemThongTinKhachHang().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXoaTrang)) {
			// chuyển đến layout quản lý khách hàng	
		}

}
	private void LayThongTinKhachHang() {
		
		
	}
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import app.RunYamasApplication;
import businesslogic.facade.NhanVienFacade;
import model.NhanVien;

public class Layout_DoiMatKhau extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField txtMatKhauCu;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtMatKhauMoi2;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	NhanVienFacade nhanVienFacade;
	NhanVien nhanVien ;
	public Layout_DoiMatKhau(NhanVien nv){
		nhanVienFacade = RunYamasApplication.getInstance().getNhanVienFacade();
		nhanVien =nv;
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

		JLabel lblDoiMatKhau = new JLabel("Đổi Mật Khẩu");
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoiMatKhau.setBounds(179, 10, 348, 45);
		getContentPane().add(lblDoiMatKhau);
		
		txtMatKhauCu = new JPasswordField();
		txtMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhauCu.setBounds(257, 95, 285, 22);
		getContentPane().add(txtMatKhauCu);
		txtMatKhauCu.setColumns(10);

		txtMatKhauMoi = new JPasswordField();
		txtMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhauMoi.setBounds(257, 136, 285, 22);
		getContentPane().add(txtMatKhauMoi);
		txtMatKhauMoi.setColumns(10);

		txtMatKhauMoi2 = new JPasswordField();
		txtMatKhauMoi2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhauMoi2.setBounds(257, 177, 285, 22);
		getContentPane().add(txtMatKhauMoi2);
		txtMatKhauMoi2.setColumns(10);
		
		JLabel lblMatKhauCu = new JLabel("Mật Khẩu Hiện Tại :");
		lblMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatKhauCu.setBounds(133, 95, 114, 20);
		getContentPane().add(lblMatKhauCu);
		
		JLabel lblMatKhauMoi = new JLabel("Mật Khẩu Mới :");
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatKhauMoi.setBounds(133, 136, 114, 20);
		getContentPane().add(lblMatKhauMoi);
		
		JLabel lblNhapLaiMatKhau = new JLabel("Nhập Lại Mật Khẩu :");
		lblNhapLaiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhapLaiMatKhau.setBounds(133, 177, 114, 20);
		getContentPane().add(lblNhapLaiMatKhau);
		
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTrang.setBounds(257, 238, 133, 25);
		getContentPane().add(btnXoaTrang);
		
		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapNhat.setBounds(409, 238, 133, 25);
		getContentPane().add(btnCapNhat);
		
		
		final JCheckBox cbHienMatKhau = new JCheckBox("Hiện Mật Khẩu");
		cbHienMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbHienMatKhau.isSelected()) {
					txtMatKhauCu.setEchoChar((char)0);
					txtMatKhauMoi.setEchoChar((char)0);
					txtMatKhauMoi2.setEchoChar((char)0);
				}
				else {
					txtMatKhauCu.setEchoChar('*');
					txtMatKhauMoi.setEchoChar('*');
					txtMatKhauMoi2.setEchoChar('*');
				}
			}
		});
		cbHienMatKhau.setToolTipText("True: Lớn hơn - False: Bé hơn");
		cbHienMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbHienMatKhau.setBackground(Color.WHITE);
		cbHienMatKhau.setBounds(267, 208, 162, 21);
		getContentPane().add(cbHienMatKhau);
		
		// Add Icon 
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/trash.png"));
			btnXoaTrang.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoaTrang.setBounds(257, 238, 133, 25);
		getContentPane().add(btnXoaTrang);
		
//		btnCapNhat = new JButton("Cập Nhật");
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/disk.png"));
			btnCapNhat.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		//
		btnCapNhat.addActionListener(this);
		btnXoaTrang.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
//		new Layout_DoiMatKhau().setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXoaTrang)) {
			txtMatKhauCu.setText("");
			txtMatKhauMoi.setText("");
			txtMatKhauMoi2.setText("");
		}
		if(o.equals(btnCapNhat)) {
			if(validData()==true)
			ThayDoiMatKhau();
		}
		
	}


	private boolean validData() {
		// TODO Auto-generated method stub
		String MKCu = String.valueOf(txtMatKhauCu.getPassword());
		String MK = String.valueOf(txtMatKhauMoi.getPassword());
		String MK2 = String.valueOf(txtMatKhauMoi2.getPassword());
		if ((MK.equals(MKCu))) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới không được trùng mật khẩu cũ");
			txtMatKhauMoi.requestFocus();
			return false;
		}
		if (!(MK.equals(MK2))) {
			JOptionPane.showMessageDialog(this, "Hai lần nhập không khớp");
			txtMatKhauMoi.requestFocus();
			return false;
		}
		return true;
	}


	private void ThayDoiMatKhau() {
		
		String matKhauCu= String.valueOf(txtMatKhauCu.getPassword());
		String matKhauMoi=String.valueOf(txtMatKhauMoi.getPassword());
		
		if(matKhauCu.equals(nhanVien.getMatKhau())==false) {
			JOptionPane.showMessageDialog(this, "Mật khẩu cũ không chính xác! Vui lòng thử lại!");
		}
		else {
			
			try {
				nhanVien.setMatKhau(matKhauMoi);
				nhanVienFacade.capNhatThongTinNhanVien(nhanVien);
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}
}

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import app.RunYamasApplication;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;
import model.NhanVien;

public class Layout_Login extends JFrame implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JButton btnExit = new JButton("THOÁT");
	private JButton btnLogin = new JButton("ĐĂNG NHẬP");
	private JLabel lblngNhpVo;
	static String tk;
	static String mk;
	NhanVienFacade nhanVienFacade;
	public Layout_Login() {
		nhanVienFacade = RunYamasApplication.getInstance().getNhanVienFacade();
		setTitle("Đăng Nhập");

		getContentPane().setBackground(new Color(102, 153, 255));
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
		setResizable(false);
		getContentPane().setLayout(null);
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/sign-in.png"));
			btnLogin.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnLogin.setBounds(400, 392, 122, 25);
		getContentPane().add(btnLogin);
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/exit.png"));
			btnExit.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnExit.setBounds(532, 392, 116, 25);
		getContentPane().add(btnExit);

		JLabel lblTnngNhp = new JLabel("Mã số nhân viên:");
		lblTnngNhp.setBounds(265, 277, 125, 16);
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnngNhp.setForeground(Color.WHITE);
		getContentPane().add(lblTnngNhp);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setText("NV100001");
		txtTenDangNhap.setBounds(400, 277, 248, 19);
		getContentPane().add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setBounds(265, 332, 125, 13);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMtKhu.setForeground(Color.WHITE);
		getContentPane().add(lblMtKhu);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(400, 329, 248, 19);
		getContentPane().add(txtMatKhau);
		txtMatKhau.setColumns(10);
		txtMatKhau.setText("abcd1234");

		lblngNhpVo = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG YAMAS");
		lblngNhpVo.setBounds(255, 136, 561, 117);
		lblngNhpVo.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblngNhpVo.setForeground(Color.WHITE);
		getContentPane().add(lblngNhpVo);

		// Add action listener
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
		txtMatKhau.addKeyListener(this);
		txtTenDangNhap.addKeyListener(this);

	}

	public static void main(String[] args) {
		new Layout_Login().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnExit))
			thoatPhanMem();
		else {
			DangNhap();
			
		}
			
	}

	

	private void DangNhap() {

		try {
			
			String maNhanVien = txtTenDangNhap.getText().trim();
			String matKhau = String.valueOf(txtMatKhau.getPassword());
			switch (nhanVienFacade.dangNhap(maNhanVien, matKhau)) {
			case "NV":
				NhanVien nhanvien = nhanVienFacade.timNhanVienTuId(maNhanVien);
				new Dashbroad_NV(nhanvien).setVisible(true);
				this.dispose();
				break;
			case "QL":
				NhanVien quanly = nhanVienFacade.timNhanVienTuId(maNhanVien);

				new Dashbroad_QL(quanly).setVisible(true);
				this.dispose();
				break;
			case "Mật khẩu không đúng!":
				JOptionPane.showMessageDialog(this, "Sai mật khẩu! Vui lòng thử lại!");
				break;
			case "Tài khoản không tồn tại":
				JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại! Vui lòng thử lại!");
				break;
			case "Đã nghỉ việc":
				JOptionPane.showMessageDialog(this, "Tài khoản không còn quyền truy cập! Vui lòng liên hệ quản lý!");
				break;

			default:
				JOptionPane.showMessageDialog(this, "Mất kết nối với Server! Vui lòng thử lại!");

				break;
			}

		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

	private void thoatPhanMem() {
		System.exit(0);

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
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(o == txtMatKhau) DangNhap();
			else txtMatKhau.requestFocus();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}

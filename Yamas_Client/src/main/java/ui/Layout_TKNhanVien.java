package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
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
public class Layout_TKNhanVien  extends JFrame implements ActionListener, MouseListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNgayBD;
	private JTextField txtngayKT;
	private JTextField txtLuong;
	private JTable table;
	private JTextField txtMaNV;
	private String[] s= {"Tất cả","Nam","Nữ"};
	private String[] s2= {"Mã Nhân viên","tên nhân viên"};
	private JComboBox<String> cbbGioiTinh;
	private JComboBox<String> cbbTenorMa;
	private JCheckBox cbLonHon;
	private JButton btnLoc;
	private JButton btnLocNVNghi;
	private DefaultTableModel modelNhanVien;
	public Layout_TKNhanVien() {
	// TODO Auto-generated constructor stub
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
		setResizable(true);
		//setUndecorated(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblTNgy = new JLabel("Từ ngày:");
		lblTNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTNgy.setBounds(88, 99, 70, 19);
		getContentPane().add(lblTNgy);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNgayBD.setBounds(180, 98, 162, 19);
		getContentPane().add(txtNgayBD);
		txtNgayBD.setColumns(10);
		
		JLabel lbln = new JLabel("Đến:");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbln.setBounds(371, 101, 45, 13);
		getContentPane().add(lbln);
		
		txtngayKT = new JTextField();
		txtngayKT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtngayKT.setColumns(10);
		txtngayKT.setBounds(444, 98, 162, 19);
		getContentPane().add(txtngayKT);
		
		cbbGioiTinh = new JComboBox(s);
		cbbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbGioiTinh.setMaximumRowCount(100);
		cbbGioiTinh.setBackground(Color.WHITE);
		cbbGioiTinh.setBounds(444, 142, 162, 21);
		getContentPane().add(cbbGioiTinh);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiiTnh.setBounds(371, 146, 63, 13);
		getContentPane().add(lblGiiTnh);
		
		JLabel lblThngKNhn = new JLabel("Thống kê nhân viên");
		lblThngKNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngKNhn.setBounds(409, 21, 209, 41);
		getContentPane().add(lblThngKNhn);
		
		JLabel lblLng = new JLabel("Lương:");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLng.setBounds(88, 142, 70, 19);
		getContentPane().add(lblLng);
		
		txtLuong = new JTextField();
		txtLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLuong.setColumns(10);
		txtLuong.setBounds(180, 141, 162, 19);
		getContentPane().add(txtLuong);
		
		cbLonHon = new JCheckBox("Lớn hơn");
		cbLonHon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbLonHon.setToolTipText("True: Lớn hơn - False: Bé hơn");
		cbLonHon.setBackground(Color.WHITE);
		cbLonHon.setBounds(180, 169, 162, 21);
		getContentPane().add(cbLonHon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 270, 913, 283);
		getContentPane().add(scrollPane);
		
		String[] colHeader = { "Mã NV", "Số CMND", "Họ NV", "Tên NV", "Giới Tính", "Số Điện thoại","Chức vụ","Địa chỉ","Mật khẩu" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelNhanVien);
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		 btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoc.setToolTipText("Lọc theo các thuộc tính đã nhập");
		btnLoc.setBounds(699, 98, 125, 20);
		getContentPane().add(btnLoc);
		
		 btnLocNVNghi = new JButton("đã nghỉ làm");
		btnLocNVNghi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocNVNghi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLocNVNghi.setBounds(699, 159, 125, 20);
		getContentPane().add(btnLocNVNghi);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNV.setBounds(180, 198, 236, 19);
		getContentPane().add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblLcTheo = new JLabel("Tên/Mã NV:");
		lblLcTheo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLcTheo.setBounds(88, 201, 85, 13);
		getContentPane().add(lblLcTheo);
		
		cbbTenorMa = new JComboBox(s2);
		cbbTenorMa.setMaximumRowCount(100);
		cbbTenorMa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbTenorMa.setBackground(Color.WHITE);
		cbbTenorMa.setBounds(444, 198, 162, 21);
		getContentPane().add(cbbTenorMa);
		
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/search.png"));
			btnLoc.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		try {
			Image img = ImageIO.read(this.getClass().getResource("/img/search.png"));
			btnLocNVNghi.setIcon(new ImageIcon(img));
	} catch (Exception ex) {
			System.out.println(ex);
	}
		
		btnLoc.addActionListener(this);
		btnLocNVNghi.addActionListener(this);
		table.addMouseListener(this);
	}
	public static void main(String[] args) {
		new Layout_TKNhanVien().setVisible(true);
	}
	private boolean validData() {
		String NgayBD = txtNgayBD.getText().trim();
		String NgayKT = txtngayKT.getText().trim();
		String Luong = txtLuong.getText().trim();
		if (!(NgayBD.length() > 0 && NgayBD.matches("(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))"))) {
			JOptionPane.showMessageDialog(this, "Ngày theo định dạng : dd/mm/yyyy");
			txtNgayBD.requestFocus();
			return false;
		}
		if (!(NgayKT.length() > 0 && NgayKT.matches("(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))"))) {
			JOptionPane.showMessageDialog(this, "Ngày theo định dạng : dd/mm/yyyy");
			txtngayKT.requestFocus();
			return false;
		}
		if (!(Luong.length() > 0 && Luong.matches("[1-9]{1}[0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Lương phải > 0!!!");
			txtLuong.requestFocus();
			return false;
		}
		return true;
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

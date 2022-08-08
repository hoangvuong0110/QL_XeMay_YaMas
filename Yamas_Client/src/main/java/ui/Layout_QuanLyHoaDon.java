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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import app.RunYamasApplication;
import businesslogic.facade.HoaDonFacade;
import model.ChiTietHoaDon;
import model.HoaDon;

public class Layout_QuanLyHoaDon extends JFrame implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableQLHoaDon;
	private JTextField txtTimHoaDon;
	private DefaultTableModel modelQLHoaDon;
	private JButton btnTim;
	private JButton btnXemChiTiet;
	private JButton btnXoa;
	HoaDonFacade hoaDonFacade;
	List<HoaDon> dsHoaDon;
	NumberFormat formatter = new DecimalFormat("#0.00");
	HoaDon hoaDonDangChon;

	Locale localeVN = new Locale("vi", "VN");
	NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	JFileChooser chooser;

	private JLabel lblHonang;
	private JLabel lblHoaDonDangChon;
	private JButton btnInHoaDon;

	public Layout_QuanLyHoaDon() throws RemoteException {
		hoaDonFacade = RunYamasApplication.getInstance().getHoaDonFacade();
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

		JLabel lblHDDangChon = new JLabel("Quản Lý Hóa Đơn");
		lblHDDangChon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHDDangChon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHDDangChon.setBounds(295, 45, 348, 45);
		getContentPane().add(lblHDDangChon);

		String[] colHeader = { "Mã HĐ", "Mã Nhân Viên", "Tên nhân viên", "CMND Khách Hàng", "Tên khách hàng",
				"SĐT khách hàng ", "Trạng Thái", "Thành Tiền", "Hình Thức Thanh Toán", "Thời gian" };

		modelQLHoaDon = new DefaultTableModel(colHeader, 0);
		tableQLHoaDon = new JTable(modelQLHoaDon) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				// Alternate row color
				if (!isRowSelected(row))
					c.setBackground(row % 3 == 0 ? getBackground() : Color.LIGHT_GRAY);

				if (!isRowSelected(row)) {
					c.setBackground(modelQLHoaDon.getValueAt(row, 6).equals("Đã huỷ") == false ? getBackground()
							: new Color(255, 102, 102));

				}

				return c;
			}
		};
		tableQLHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tableQLHoaDon.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableQLHoaDon.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableQLHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableQLHoaDon.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableQLHoaDon.getColumnModel().getColumn(4).setPreferredWidth(200);
		tableQLHoaDon.getColumnModel().getColumn(5).setPreferredWidth(150);
		tableQLHoaDon.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableQLHoaDon.getColumnModel().getColumn(7).setPreferredWidth(100);
		tableQLHoaDon.getColumnModel().getColumn(8).setPreferredWidth(200);
		tableQLHoaDon.getColumnModel().getColumn(9).setPreferredWidth(200);
//		tableQLHoaDon.getColumnModel().getColumn(10).setPreferredWidth(100);
//		tableQLHoaDon.getColumnModel().getColumn(11).setPreferredWidth(100);

		tableQLHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane scrollPane = new JScrollPane(tableQLHoaDon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setViewportView(tableQLHoaDon);
		scrollPane.setBounds(94, 138, 805, 295);
		getContentPane().add(scrollPane);

		txtTimHoaDon = new JTextField();
		txtTimHoaDon.setBounds(94, 472, 169, 25);
		getContentPane().add(txtTimHoaDon);
		txtTimHoaDon.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("img/search.png"));
		btnTim.setBounds(275, 472, 89, 25);
		getContentPane().add(btnTim);

		btnXemChiTiet = new JButton("Xem Chi Tiết");
		btnXemChiTiet.setIcon(new ImageIcon("img/list.png"));
		btnXemChiTiet.setBounds(627, 472, 130, 25);
		getContentPane().add(btnXemChiTiet);

		btnXoa = new JButton("Huỷ hoá đơn");
		btnXoa.setIcon(new ImageIcon("img/trash.png"));
		btnXoa.setBounds(769, 472, 130, 25);
		getContentPane().add(btnXoa);

		lblHonang = new JLabel("Hoá đơn đang chọn:");
		lblHonang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHonang.setBounds(94, 101, 129, 16);
		getContentPane().add(lblHonang);

		lblHoaDonDangChon = new JLabel("Chưa chọn hoá đơn nào");
		lblHoaDonDangChon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHoaDonDangChon.setForeground(Color.RED);
		lblHoaDonDangChon.setBounds(235, 101, 234, 16);
		getContentPane().add(lblHoaDonDangChon);

		btnInHoaDon = new JButton("In hoá đơn");
		btnInHoaDon.setBounds(485, 471, 130, 25);
		getContentPane().add(btnInHoaDon);

		btnXemChiTiet.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnInHoaDon.addActionListener(this);

		tableQLHoaDon.addMouseListener(this);
		
		tableQLHoaDon.addKeyListener(this);
		txtTimHoaDon.addKeyListener(this);

		dsHoaDon = hoaDonFacade.layDanhSach100HoaDonMoiNhat();
		themDuLieuHoaDonVaoTable();
	}

	private void themDuLieuHoaDonVaoTable() {
		modelQLHoaDon.setRowCount(0);
		for (int i = 0; i < dsHoaDon.size(); i++) {
			HoaDon hd = dsHoaDon.get(i);
			String[] colHeader = { "Mã HĐ", "Mã Nhân Viên", "Tên nhân viên", "CMND Khách Hàng", "Tên khách hàng",
					"SĐT khách hàng ", "Trạng Thái", "Thành Tiền", "Hình Thức Thanh Toán", "Thời gian" };

			modelQLHoaDon.addRow(new Object[] { hd.getMaHoaDon(), hd.getNhanvien().getMaNhanVien(),
					hd.getNhanvien().getTen(), hd.getKhachHang().getCmnd(), hd.getKhachHang().getTen(),
					hd.getKhachHang().getSdt(), hd.getTrangThai(), currencyVN.format(hd.getThanhTien()),
					hd.getHinhThucThanhToan(), hd.getThoiGian() });
		}

	}

	public static void main(String[] args) {
		try {
			new Layout_QuanLyHoaDon().setVisible(true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableQLHoaDon)) {
			hoaDonDangChon = dsHoaDon.get(tableQLHoaDon.getSelectedRow());
			lblHoaDonDangChon.setText(hoaDonDangChon.getMaHoaDon() + "");
			if (hoaDonDangChon.getTrangThai().equals("Đã huỷ")) {
				btnXoa.setEnabled(false);
				btnInHoaDon.setEnabled(false);
			}
				
			else {
				btnXoa.setEnabled(true);
				btnInHoaDon.setEnabled(true);
			}
				
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
		if (o.equals(btnTim)) {
			try {
				TimHoaDon();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (o.equals(btnXemChiTiet)) {
			XemChiTiet();
		}

		if (o.equals(btnXoa)) {
			XoaHoaDon();
		}
		if (o.equals(btnInHoaDon))
			inHoaDon();
	}

	private void inHoaDon() {
		HoaDon hoaDon = this.hoaDonDangChon;
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Title");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// disable the "All files" option.
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File path = chooser.getSelectedFile();
			Document document = new Document();

			try {
				// khởi tạo một PdfWriter truyền vào document và FileOutputStream
				String BODONIBLACK = "src/main/resources/font/UTMAvo.ttf";
				PdfWriter.getInstance(document, new FileOutputStream(path + "/" + hoaDon.getMaHoaDon() + ".pdf"));
				try {
					BaseFont bf = BaseFont.createFont(BODONIBLACK, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					// mở file để thực hiện viết
					document.open();
					int boldStyle = Font.BOLD;
					// thêm nội dung sử dụng add function
					com.itextpdf.text.Font smallFont = new com.itextpdf.text.Font(bf, 10);
					com.itextpdf.text.Font smallFontBold = new com.itextpdf.text.Font(bf, 10);
					com.itextpdf.text.Font mediumFont = new com.itextpdf.text.Font(bf, 13);
					com.itextpdf.text.Font largeFont = new com.itextpdf.text.Font(bf, 15);
					largeFont.setStyle(boldStyle);
					smallFontBold.setStyle(boldStyle);
					// Khai báo 2 paragraph
					Paragraph header = new Paragraph("Cửa hàng xe máy Yamas\n", smallFont);
					Paragraph title = new Paragraph("HOÁ ĐƠN MUA HÀNG: \n", largeFont);
					Paragraph customer = new Paragraph("", mediumFont);
					Paragraph temp = new Paragraph("         \n", mediumFont);
					Paragraph totalCost = new Paragraph("         \n", smallFontBold);
					Paragraph signature = new Paragraph("         \n", smallFontBold);
					// Định dạng header
					header.setIndentationLeft(80);
					header.setIndentationRight(80);
					header.setAlignment(Element.ALIGN_CENTER);
					header.setSpacingAfter(15);
					header.add(new Phrase("Phân phối xe máy chính hãng tại TP.HCM\n"));
					header.add(new Phrase("Địa chỉ: 12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, Thành phố Hồ Chí Minh\n"));
					header.add(new Phrase("=======================================\n"));
					header.add(new Phrase("Mã hoá đơn: " + hoaDon.getMaHoaDon()));

					// Định dạng title:

					title.setIndentationLeft(80);
					title.setIndentationRight(80);
					title.setAlignment(Element.ALIGN_CENTER);

					// Đinh dạng customer

					customer.setSpacingBefore(15);
					customer.setAlignment(Element.ALIGN_LEFT);
					customer.add(new Phrase("Tên khách hàng: " + hoaDon.getKhachHang().getTen()));
					customer.add(new Phrase("\n Số điện thoại: " + hoaDon.getKhachHang().getSdt()));
					customer.add(
							new Phrase("\n Địa chỉ: " + hoaDon.getKhachHang().getDiaChi().getDiaChiChiTiet() + "\n"));

					// Định dạnh table

					PdfPTable table = new PdfPTable(5);
					table.setWidths(new int[] { 1, 3, 1, 3, 3 });
					table.setWidthPercentage(100);

					// Khởi tạo 5 ô table header

					PdfPCell sttCol = new PdfPCell(new Paragraph("STT", smallFontBold));
					PdfPCell maSpCol = new PdfPCell(new Paragraph("Mã SP", smallFontBold));
					PdfPCell soLuongCol = new PdfPCell(new Paragraph("Số lượng", smallFontBold));
					PdfPCell donGiaCol = new PdfPCell(new Paragraph("Đơn giá", smallFontBold));
					PdfPCell thanhTienCol = new PdfPCell(new Paragraph("Thành Tiền", smallFontBold));

					table.addCell(sttCol);
					table.addCell(maSpCol);
					table.addCell(soLuongCol);
					table.addCell(donGiaCol);
					table.addCell(thanhTienCol);

					Double thanhtien = 0.0;
					List<ChiTietHoaDon> dsCTHDInHD = hoaDon.getChiTietHoaDon();
					for (int i = 0; i < dsCTHDInHD.size(); i++) {
						ChiTietHoaDon cthd = dsCTHDInHD.get(i);
						thanhtien = thanhtien + cthd.getSoLuong() * cthd.getSanPham().getGiaBan();
						PdfPCell stt = new PdfPCell(new Paragraph(i + 1 + "", smallFont));
						PdfPCell maSp = new PdfPCell(new Paragraph(cthd.getSanPham().getMaSanPham(), smallFont));
						PdfPCell soLuong = new PdfPCell(new Paragraph(cthd.getSoLuong() + "", smallFont));
						PdfPCell donGia = new PdfPCell(
								new Paragraph(currencyVN.format(cthd.getSanPham().getGiaBan()) + " ", smallFont));
						PdfPCell thanhTien = new PdfPCell(new Paragraph(
								currencyVN.format(cthd.getSanPham().getGiaBan() * cthd.getSoLuong()) + " ", smallFont));
						table.addCell(stt);
						table.addCell(maSp);
						table.addCell(soLuong);
						table.addCell(donGia);
						table.addCell(thanhTien);

					}

					// Tổng tiền

					totalCost.setIndentationLeft(320);
					totalCost.setIndentationRight(0);
					totalCost.add(new Phrase("Tổng tiền hàng: " + currencyVN.format(thanhtien) + " \n"));
					totalCost.add(new Phrase("Thuế GTGT      : " + currencyVN.format(thanhtien / 10) + " \n"));
					totalCost.add(new Phrase("Thành tiền      : " + currencyVN.format(thanhtien * 1.1) + " \n"));

					// Chữ ký

					signature.setIndentationLeft(120);
					signature.setIndentationRight(0);
					signature.add(new Phrase(
							"	Người bán hàng                                              Người mua hàng\n "));
					signature.add(new Phrase(
							"(Ký và ghi rõ họ tên)                                       (Ký và ghi rõ họ tên)\n"));

					// Thêm vào document

					document.add(header);
					document.add(title);
					document.add(customer);
					document.add(temp);
					document.add(table);
					document.add(totalCost);
					document.add(signature);

					// đóng file

					document.close();
					JOptionPane.showMessageDialog(this, "Xuất hoá đơn thành công!");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");

					e.printStackTrace();
				}

			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
		}

	}

	private void XoaHoaDon() {
		if (hoaDonDangChon == null) {
			JOptionPane.showMessageDialog(this, "Chưa có hoá đơn nào được chọn để huỷ!!");

		} else {
			int reply = JOptionPane.showConfirmDialog(
					this, "Hoá đơn khi huỷ sẽ không thể sửa lại. Bạn có chắc muốn huỷ hoá đơn "
							+ hoaDonDangChon.getMaHoaDon() + " không?",
					"XÁC NHẬN HUỶ HOÁ ĐƠN", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				try {
					int check = hoaDonFacade.huyHoaDon(hoaDonDangChon);
					if (check == -1) {
						JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, vui lòng thử lại!");
					} else if (check == 0) {
						JOptionPane.showMessageDialog(this, "Đơn hàng đã bị huỷ trước đó!");

					} else {
						JOptionPane.showMessageDialog(this, "Huỷ hoá đơn thành công!");

					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

			}

		}

	}

	private void XemChiTiet() {
		if (hoaDonDangChon == null) {
			JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn nào để hiển thị!");
		} else
			new Layout_XemChiTietHoaDon(hoaDonDangChon).setVisible(true);

	}

	private void TimHoaDon() throws RemoteException {
		String timKiem = txtTimHoaDon.getText().trim();
		System.out.println(timKiem);

		if (timKiem == "") {
			JOptionPane.showMessageDialog(this, "Ô tìm kiếm đang trống, vui lòng thử lại!");

		} else {
			List<HoaDon> dsHoaDonTam = hoaDonFacade.timHoaDonBangTextSearch(timKiem);
			if (dsHoaDonTam.size() == 0 || dsHoaDonTam == null) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hoá đơn nào phù hợp, vui lòng thử lại!");

			} else {
				dsHoaDon.clear();
				dsHoaDon = dsHoaDonTam;
				themDuLieuHoaDonVaoTable();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (o.equals(txtTimHoaDon))
				try {
					TimHoaDon();
				} catch (RemoteException e1) {

					e1.printStackTrace();
				}
		}
	if(e.getKeyCode() == KeyEvent.VK_DELETE) {
		if(o.equals(tableQLHoaDon)) {
			XoaHoaDon();
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

package app;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import businesslogic.facade.DiaChiHanhChinhFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.SanPhamFacade;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;
import model.addressVn.Phuong;
import model.addressVn.Quan;
import model.addressVn.ThanhPho;
import ui.Layout_Login;

public class RunYamasApplication {
	private static RunYamasApplication instance = null;
	SecurityManager securityManager = System.getSecurityManager();
	private KhachHangFacade khachHangFacade;
	private NhanVienFacade nhanVienFacade;
	private DiaChiHanhChinhFacade diaChiHanhChinh;
	private HoaDonFacade hoaDonFacade;
	private SanPhamFacade sanPhamFacade;

	public RunYamasApplication() {

		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/khachHangFacade");
			nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/nhanVienFacade");
			diaChiHanhChinh = (DiaChiHanhChinhFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/diaChiHanhChinhFacade");
			hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/hoaDonFacade");
			sanPhamFacade = (SanPhamFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/sanPhamFacade");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public synchronized static RunYamasApplication getInstance() {
		if (instance == null)
			instance = new RunYamasApplication();
		return instance;
	}

	public NhanVienFacade getNhanVienFacade() {
		return nhanVienFacade;
	}

	public KhachHangFacade getKhachHangFacade() {
		return khachHangFacade;
	}

	public DiaChiHanhChinhFacade getDiaChiHanhChinh() {
		return diaChiHanhChinh;
	}
	public HoaDonFacade getHoaDonFacade() {
		return hoaDonFacade;
	}
	public SanPhamFacade getSanPhamFacade() {
		return sanPhamFacade;
	}
	

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();

		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

//		testServer();
		openLoginUI();
	}

	private static void openLoginUI() {
		System.out.println("Client Started!");
		
		new Layout_Login().setVisible(true);

	}

	private static void testServer() {
		try {
			KhachHangFacade khachHangFacade = (KhachHangFacade) Naming
					.lookup("rmi://DESKTOP-VGO7GBM:2000/khachHangFacade");
			DiaChiHanhChinhFacade diaChiHanhChinhFacade = (DiaChiHanhChinhFacade) Naming
					.lookup("rmi://DESKTOP-VGO7GBM:2000/diaChiHanhChinhFacade");
			SanPhamFacade sanPhamFacade = (SanPhamFacade) Naming
					.lookup("rmi://DESKTOP-VGO7GBM:2000/sanPhamFacade");
			NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-VGO7GBM:2000/nhanVienFacade");
			HoaDonFacade hoaDonFacade = RunYamasApplication.getInstance().getHoaDonFacade();
			System.out.println("Yamas application is started!");
			List<String> listHo = new ArrayList<String>();
			listHo.add("Lê");
			listHo.add("Lê Nguyễn");
			listHo.add("Lê Đăng");
			listHo.add("Nguyễn");
			listHo.add("Nguyễn Thị");
			listHo.add("Nguyễn Võ");
			listHo.add("Nguyễn Đăng");
			listHo.add("Nguyễn Hoàng");
			listHo.add("Nguyễn Lê");
			listHo.add("Lưu");
			listHo.add("Lưu Thị");
			listHo.add("Lê Thị");
			listHo.add("Ngô Thị");
			listHo.add("Ngân Thanh");
			listHo.add("Ngân Thị Thanh");
			listHo.add("Ngân Thị Huyền");
			listHo.add("Nguyễn Văn");
			listHo.add("Ngân Đức");
			listHo.add("Hoàng Lê");
			listHo.add("Hoàng Văn");
			listHo.add("Hoàng Thanh");
			listHo.add("Thái Văn");
			listHo.add("Thái Huyền");
			listHo.add("Thái Anh");
			listHo.add("Thái ");
			listHo.add("Phan Thị");
			listHo.add("Phan ");
			listHo.add("Thanh Thanh");
			
			listHo.add("Lưu Tuấn");
			List<String> listTen = new ArrayList<String>();
			
			listTen.add("Khánh");
			listTen.add("Kha");
			listTen.add("Khanh");
			listTen.add("Hoàng");
			listTen.add("Nam");
			listTen.add("Tiến");
			listTen.add("Chiến");
			listTen.add("Thắng");
			listTen.add("Vương");
			listTen.add("Hưng");
			listTen.add("Thanh");
			listTen.add("Lê");
			listTen.add("Thi");
			listTen.add("Ánh");
			listTen.add("Giang");
			listTen.add("Trâm");
			listTen.add("Nam");
			listTen.add("Hoàng");
			listTen.add("Ngân");
			listTen.add("Linh");
			listTen.add("Hương");
			listTen.add("Vĩnh");
			listTen.add("Hoà");
			listTen.add("Thành");
			listTen.add("Châu");
			listTen.add("Ngọc");
			Random random = new Random();
			List<String> listGioiTinh = new ArrayList<>();
			listGioiTinh.add("Nam");
			listGioiTinh.add("Nữ");
			listGioiTinh.add("Khác");
			System.out.println(listHo.get(random.nextInt(listHo.size())));
			List<ThanhPho> listThanhPho = new ArrayList<>();
			List<Phuong> listPhuong = new ArrayList<>();
			List<Quan> listQuan = new ArrayList<>();
			diaChiHanhChinhFacade.layDanhSachTatCaThanhPho().forEach(tp -> {
				listThanhPho.add(tp);
			});
//			System.out.println("Insert 30000 user!");
//			for (int i = 100000; i < 109999; i++) {
//				String gioiTinh = listGioiTinh.get(random.nextInt(listGioiTinh.size()));
//				ThanhPho thanhPho = listThanhPho.get(random.nextInt(listThanhPho.size()));
//				
//				listQuan = diaChiHanhChinhFacade.layDanhSachQuanTheoThanhPho(thanhPho.getId());
//				Quan quan = listQuan.get(random.nextInt(listQuan.size()));
//
//				listPhuong = diaChiHanhChinhFacade.layDanhSachPhuongTheoQuan(quan.getId());
//				Phuong phuong = listPhuong.get(random.nextInt(listPhuong.size()));
//
//				DiaChi diaChi = new DiaChi(thanhPho.getNameWithType(), quan.getNameWithType(), phuong.getNameWithType(), phuong.getPathWithType());
////				khachHangFacade.themKhachHang(new KhachHang(i+""+i, "0" + i + "566",
////						listHo.get(random.nextInt(listHo.size())) + " " + listTen.get(random.nextInt(listTen.size())),
////						diaChi, gioiTinh, "Khách hàng mới",new Date()));
//				NhanVien nv = new NhanVien("NV"+i, "abcd1234", i+""+i, "09"+i*2, listHo.get(random.nextInt(listHo.size())) + " " + listTen.get(random.nextInt(listTen.size())), diaChi, gioiTinh, "NV", "Đang làm việc",new Date());
//				NhanVien nv2 = new NhanVien("NV"+i, "abcd1234", i+""+i, "09"+i*2, listHo.get(random.nextInt(listHo.size())) + " " + listTen.get(random.nextInt(listTen.size())), diaChi, gioiTinh, "NV", "Đã nghỉ việc",new Date());
//				
//				if(i%2==0) nhanVienFacade.themNhanVien(nv);
//				if(i%2==1) nhanVienFacade.themNhanVien(nv2);
//				System.out.println(i+"/"+"110000");
//			}
			SanPham sp = new SanPham("maSanPham", "tenSanPham","HấngnXuat", "loaiXe", "dongXe", "mauXe", 100000000.0, 11000000.0, 2020, "dungTichXilanh", "dungTichBinhXang"," kichThuoc", 10000, "trangThai",0);
			Map<String, String> listMauXe = new HashMap<>();
			List<Integer> listNam = new ArrayList<>();
			Map<String, String> listDongXe = new HashMap<>();
			listDongXe.put("HD-SH","Honda SH");
			listDongXe.put("HD-SC","Honda SuperCup");
			listDongXe.put("HD-FT","Honda Future");
			listDongXe.put("HD-GW","Honda GoldWing");
			listDongXe.put("HD-AB","Honda AirBlade");
			listDongXe.put("HD-WV","Honda Wave");
			listDongXe.put("HD-WN","Honda Winner");
			listDongXe.put("HD-CB","Honda CB500");
			listDongXe.put("HD-CR","Honda CBR");
			listDongXe.put("HD-VS","Honda Vision");
			///
			listDongXe.put("YM-EX","Yamaha Exciter");
			listDongXe.put("YM-GD","Yamaha Grande");
			listDongXe.put("YM-ZY","Yamaha ZYF");
			listDongXe.put("YM-JP","Yamaha Jupiter");
			listDongXe.put("YM-LT","Yamaha Latte");
			listDongXe.put("YM-MT","Yamaha MT-03");
			listDongXe.put("YM-SR","Yamaha Sirius");
			listDongXe.put("YM-FG","Yamaha FreeGo");
			listDongXe.put("YM-AC","Yamaha Acruzo");
			listDongXe.put("YM-TF","Yamaha TFX");
			System.out.println(listDongXe);
			///
			listNam.add(2021);
			
			listNam.add(2018);
			///
			listMauXe.put("Y","Vàng");
			listMauXe.put("YB","Vàng Xanh");
			listMauXe.put("YR","Vàng Đỏ");
			listMauXe.put("W","Trắng");
			listMauXe.put("R","Đỏ");
			listMauXe.put("RO","Đỏ cam");
			listMauXe.put("B","Xanh");
			listMauXe.put("BP","Xanh Tím");
			listMauXe.put("BL","Đen");
			listMauXe.put("P","Hồng");
			listMauXe.put("GR","Xám");
			listMauXe.put("GRBL","Xám Đen");
			listMauXe.put("RBL","Đỏ đen");
			listMauXe.put("WBL","Trắng đen");
			listMauXe.put("BBL","Xanh đen");
			listMauXe.put("PBL","Hồng đen");
			listMauXe.put("YBL","Vàng đen");
			
//			System.out.println("thêm sản phẩm!");
//			for (Integer nam : listNam) {
//				listDongXe.entrySet().forEach(dongxe ->{
//					System.out.println(dongxe.getKey()+"---"+ dongxe.getValue()+nam);
//					listMauXe.entrySet().forEach(mauxe->{
//						String maSP = dongxe.getKey()+"-"+nam+"-"+mauxe.getKey();
//						String tenSP = dongxe.getValue() + " "+ nam+ " "+ mauxe.getValue();
//						String hangSanXuat = "Yamaha";
//						String loaiXe = "Xe số";
//						if(dongxe.getValue().contains("Honda")) hangSanXuat="Honda";
//						if(dongxe.getValue().contains("Grande") || 
//								dongxe.getValue().contains("AirBlade") || dongxe.getValue().contains("Vision") || 
//								dongxe.getValue().contains("Latte") || dongxe.getValue().contains("FreeGo") ||
//								dongxe.getValue().contains("SH") || dongxe.getValue().contains("Acruzo") 
//								) loaiXe="Xe tay ga";
//						
//						SanPham sp2 = new SanPham(maSP,tenSP,hangSanXuat,loaiXe,dongxe.getValue(),mauxe.getValue(),10000000.0+1000.0*nam,10000000.0+1000*nam*1.2,nam,"220cc", "5l", "1.820mm x 685mm x 1.150mm", nam+12, "Đang bán",0);
////						System.out.println(sp2);
//						try {
////							if(sp2.get)
//							sanPhamFacade.themSanPham(sp2);
//						} catch (RemoteException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					});
//				});
//				
//			}
//			System.out.println("TextSearch Test:");
//			System.out.println(khachHangFacade.timKhachHangBangTextSearch("nguyen").size());
//			
//			System.out.println("Tìm khách hàng Test:");
//					System.out.println(khachHangFacade.timKhachHang("nguyen","Nam",new DiaChi("Tỉnh Bình Phước", "Huyện Bù Đốp", "Xã Thanh Hòa", "")).size());
//			System.out.println(sanPhamFacade.layDanhSachDongXe());
//			System.out.println(sanPhamFacade.layDanhSachMauXe());
			sanPhamFacade.layDanhSachSanPhamMoiNhat().forEach(i ->{
				System.out.println(i);
			});
//			NhatKyHoatDong nk = new NhatKyHoatDong(maNhatKy, nhanvien, tenHanhDong, doiTuongTacDong, thoiGian)
			
			
			List<NhanVien> dsNhanVien = nhanVienFacade.layDanhSach100NhanVienMoiNhat();
			List<SanPham> dsSanPham = sanPhamFacade.timSanPham("2021");
			List<KhachHang> dsKhachHang = khachHangFacade.layDanhSach100KhachHangMoiNhat();
			List<String> dsTrangThai = new ArrayList<>();
			dsTrangThai.add("Đã thanh toán");
			dsTrangThai.add("Đã huỷ");
			List<String> dsNgay = new ArrayList<>();
			List<String> dsThang = new ArrayList<>();
			List<String> dsNam = new ArrayList<>();
			for (int j = 1; j < 28; j++) {
				dsNgay.add(j+"");
			}
			for (int j = 11; j < 13; j++) {
				dsThang.add(j+"");
			}
			for (int j = 2021; j < 2022; j++) {
				dsNam.add(j+"");
			}
			for (int j = 0; j < 2000; j++) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(dsSanPham.get(random.nextInt(dsSanPham.size())),1);
				ChiTietHoaDon cthd2 = new ChiTietHoaDon(dsSanPham.get(random.nextInt(dsSanPham.size())),1);
				ChiTietHoaDon cthd3 = new ChiTietHoaDon(dsSanPham.get(random.nextInt(dsSanPham.size())),1);
				List<ChiTietHoaDon> dsCTHD = new ArrayList<>();
				String ngaySTs = dsNgay.get(random.nextInt(dsNgay.size()))+"/"+ dsThang.get(random.nextInt(dsThang.size()))+"/"+ dsNam.get(random.nextInt(dsNam.size()));
				 Date ngayTao=new SimpleDateFormat("dd/MM/yyyy").parse(ngaySTs); 
				
				dsCTHD.add(cthd);
				dsCTHD.add(cthd2);
				dsCTHD.add(cthd3);
				
				
				HoaDon hd = new HoaDon(dsKhachHang.get(random.nextInt(dsKhachHang.size())), dsNhanVien.get(random.nextInt(dsNhanVien.size())), ngayTao, "Tiền mặt", dsCTHD, dsTrangThai.get(random.nextInt(dsTrangThai.size())));
				hoaDonFacade.themHoaDon(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}

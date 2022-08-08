package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HoaDon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2404797687145642771L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="maHoaDon")
	private int maHoaDon;
	@ManyToOne
	@JoinColumn(name="maKhachHang", nullable=false)
	private KhachHang khachHang;
	@OneToOne
	@JoinColumn(name="maNhanVien", nullable=false)
	private NhanVien nhanvien;
	private Date thoiGian;
	private String hinhThucThanhToan;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<ChiTietHoaDon> chiTietHoaDon;
	private String trangThai;
	@SuppressWarnings("unused")
	private Double thanhTien;
	public HoaDon(KhachHang khachHang, NhanVien nhanvien, Date thoiGian, String hinhThucThanhToan,
			List<ChiTietHoaDon> chiTietHoaDon, String trangThai) {
		super();
		this.khachHang = khachHang;
		this.nhanvien = nhanvien;
		this.thoiGian = thoiGian;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.chiTietHoaDon = chiTietHoaDon;
		this.trangThai = trangThai;
		this.thanhTien = getThanhTien();
	}
	@Column(name="thanhTien")
	public Double getThanhTien() {
		Double tt = 0.0;
		List<ChiTietHoaDon> dsCTHD = this.getChiTietHoaDon();
		for (ChiTietHoaDon cthd : dsCTHD) {
			tt= cthd.getSanPham().getGiaBan()*cthd.getSoLuong();
		}
		return tt*1.1;
	}
	
	
	
	
	

}

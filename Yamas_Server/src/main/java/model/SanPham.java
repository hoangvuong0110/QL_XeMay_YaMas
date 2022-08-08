package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8012194572089691860L;
	
	@Id
	private String maSanPham;
	private String tenSanPham;
	private String hangSanXuat;
	private String loaiXe;
	private String dongXe;
	private String mauXe;
	private Double giaNhap;
	private Double giaBan;
	private int namSanXuat;
	private String dungTichXilanh;
	private String dungTichBinhXang;
	private String kichThuoc;
	private int soLuongTonKho;
	private String trangThai;
	private int soLuongDaBan;

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return  maSanPham  + " | "+tenSanPham+ " | "+ formatter.format(giaBan)+" VNĐ"+ " | "+ soLuongTonKho+" Chiếc ";
	}
	
	
	
}

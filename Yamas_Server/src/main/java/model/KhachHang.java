package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="KhachHang")
public class KhachHang implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7465251150310007847L;
	@Id
	@Column(name="cmnd")
	private String cmnd;
	private String sdt;
	private String ten;
	@Embedded
	@Column(nullable=false)
	private DiaChi diaChi;
	private String gioiTinh;
	private String trangThai;
	private Date ngayTao;
	@Override
	public String toString() {
		return  sdt + "-" + ten + "";
	}
	
	
	
	

}

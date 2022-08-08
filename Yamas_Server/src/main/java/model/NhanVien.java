package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="NhanVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8274749082077748112L;
	@Id
	@Column(name="maNhanVien")
	private String maNhanVien;
	
	private String matKhau;

	private String cmnd;
	private String sdt;
	private String ten;
	@Embedded
	private DiaChi diaChi;
	private String gioiTinh;
	private String chucVu;
	private String trangThai;
	private Date ngayTao;


}

package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
@ToString
public class DiaChi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4044395487646442330L;
	private String thanhPho;
	private String quan;
	private String phuong;
	private String diaChiChiTiet;
	

}

package model.addressVn;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Phuong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phuong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3123349462450861162L;
	@Id
	private String id;
	private String name;
	private String slug;
	private String nameWithType;
	private String path;
	private String pathWithType;
	@ManyToOne()
	@JoinColumn(name = "districtId", nullable = false)
	private Quan district;
	@Override
	public String toString() {
		return nameWithType;
	}
	
	
}

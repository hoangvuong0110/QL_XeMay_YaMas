package model.addressVn;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Quan")
@Entity
public class Quan implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5226275652656122697L;

	@Id
	private String id;
	private String name;
	private String slug;
	private String nameWithType;
	private String path;
	private String pathWithType;
	@ManyToOne()
	@JoinColumn(name = "citiesId", nullable = false)
	private ThanhPho city;
	@OneToMany(mappedBy="district",fetch = FetchType.EAGER)
	private Set<Phuong> wards;
	@Override
	public String toString() {
		return nameWithType;
	}
	
	

}

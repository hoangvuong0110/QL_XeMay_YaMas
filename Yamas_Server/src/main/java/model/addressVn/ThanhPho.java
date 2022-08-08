package model.addressVn;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="ThanhPho")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThanhPho implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4305012062769798459L;
	@Id
	private String id;
	private String name;
	private String slug;
	private String type;
	private String nameWithType;
	@OneToMany(mappedBy="city", fetch = FetchType.EAGER)
	private Set<Quan> districts;
	public ThanhPho(String id, String name, String slug, String type, String nameWithType) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.type = type;
		this.nameWithType = nameWithType;
	}
	@Override
	public String toString() {
		return nameWithType;
	}
	
	

}

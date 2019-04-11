package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="school.group")
public class Group {
	@Id
	 @Column(name="idgroup")
	private int idgroup;
	
	 @Column(name="description")
	private String description;
	public Group() {
		
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Group [idgroup=" + idgroup + ", description=" + description + "]";
	}
	
}

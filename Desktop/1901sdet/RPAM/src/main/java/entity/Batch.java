package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Associate> associates = new ArrayList<Associate>();

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Client> clients = new ArrayList<Client>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(List<Associate> associates) {
		this.associates = associates;
	}

	
	
	
}

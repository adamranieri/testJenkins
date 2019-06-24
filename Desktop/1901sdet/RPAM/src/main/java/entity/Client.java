package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy= "clients")
	List<Batch> batches = new ArrayList<Batch>();
	
	
}

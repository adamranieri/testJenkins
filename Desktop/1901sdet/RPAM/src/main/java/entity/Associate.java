package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Associate {
	
	@Id   // marks it as a the primary key 
	@GeneratedValue // generated a unique value
	private int id;
	
	private String name;
	private int points;
		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", name=" + name + ", points=" + points + "]";
	}
	
	
	

}

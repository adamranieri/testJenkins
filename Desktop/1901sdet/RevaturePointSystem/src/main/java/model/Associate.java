package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Associate {
	
	String name;
	int points;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@XmlElement(name ="RevaPoints")
	public int getPoints() {
		return points;
	}
	
//	@XmlElement(name ="interesting")
//	public int getSomething() {
//		return 100;
//	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Associate [name=" + name + ", points=" + points + "]";
	}
	
	

}

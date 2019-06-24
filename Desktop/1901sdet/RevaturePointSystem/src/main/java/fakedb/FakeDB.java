package fakedb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import model.Associate;


public class FakeDB {
	
	
	public static List<Associate> associates = new ArrayList<Associate>();
	
	static {generateAssociates();}
	
	public static void generateAssociates() {
		
		Associate peter = new Associate();
		peter.setName("Peter");
		peter.setPoints(Integer.MAX_VALUE+1);
		
		Associate bowtieguy = new Associate();
		bowtieguy.setName("Jamir");
		bowtieguy.setPoints(700);
		
		Associate aarron = new Associate();
		aarron.setName("Aaarrrooonnn");
		aarron.setPoints(1500);
		
		associates.add(aarron);
		associates.add(peter);
		associates.add(bowtieguy);		
	}

}

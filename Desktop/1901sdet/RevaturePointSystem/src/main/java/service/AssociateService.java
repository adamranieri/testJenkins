package service;

import java.util.List;

import fakedb.FakeDB;
import model.Associate;

public class AssociateService {
	
	
	public static Associate getAssociate(String name) {
		
		List<Associate> associates = FakeDB.associates;
		Associate a = null;
		
		for(int i =0;i<associates.size();i++) {
			
			if(associates.get(i).getName().equals(name)) {
				a = associates.get(i);
				return a;
			}
		}
		
		return a;
	}

	public static boolean addAssociate(Associate a) {
		
		try {
			
			FakeDB.associates.add(a);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}

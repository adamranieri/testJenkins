package practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.BearDAO;
import entity.Bear;
import util.HibernateUtil;

public class Playground {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session sess = sf.openSession();
		
		sess.beginTransaction();
		
		Bear yogi = new Bear();
		yogi.setName("Yogi");
//		
//		sess.persist(yogi);
//		
		
		sess.getTransaction().commit();
		
		BearDAO bd = new BearDAO();
		
//		Bear yogi2 = bd.getBear(1);
//		
//		System.out.println(yogi2.getName());
//		bd.deleteBear(yogi2);
//		bd.createBear(yogi);
		
	}

}

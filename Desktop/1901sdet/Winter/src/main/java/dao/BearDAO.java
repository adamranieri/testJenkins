package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Bear;
import util.HibernateUtil;

public class BearDAO  implements IBear{
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public Bear getBear(int id) {
		
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Bear bear = sess.get(Bear.class, id);
		
		sess.getTransaction().commit();
		sess.close();
		
		return bear;
	}

	public boolean deleteBear(Bear b) {
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			Bear bear = sess.get(Bear.class, b.getId());
			sess.delete(bear);
			sess.getTransaction().commit();
			sess.close();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}
		
		
	}

	public boolean createBear(Bear bear) {
		
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			sess.persist(bear);
			System.out.println(bear.getId());
			
			sess.getTransaction().commit();
			sess.close();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}
	
	}

	public boolean updateOrCreateBear(Bear bear) {
		
		
		try {
			Session sess = sf.openSession();
			sess.beginTransaction();
			
			sess.saveOrUpdate(bear);
			
			sess.getTransaction().commit();
			sess.close();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}
	}

}

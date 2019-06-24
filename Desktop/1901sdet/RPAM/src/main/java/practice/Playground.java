package practice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import entity.Associate;
import entity.Batch;
import util.HibernateUtil;


public class Playground {
	
	
	public static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		
		startup();
//		stateEx();
//		sql();
//		criteria();
//		hql();
//		get();
//		load();
		mergeVSupdate();
		sf.close();
		
	}
	
	public static void startup() {
		Associate bowser = new Associate();
		bowser.setName("Bowser");
		bowser.setPoints(12000);
		
		Associate jr = new Associate();
		jr.setName("Bowser JR");
		jr.setPoints(12000);
		
		Associate ike = new Associate();
		ike.setName("Ike");
		ike.setPoints(9000);
		
		List<Associate> students = new ArrayList<Associate>();
		
		students.add(ike);
		students.add(bowser);
		students.add(jr);
		
		// Session is going to be a bunch of operations to perform regarding your
		//database
		Batch b = new Batch();
		b.setTrainer("Adam");
		b.setAssociates(students);
		
		
		Session sess = sf.openSession();
		
		// creates that atomic unit of logic
		sess.beginTransaction();
		
		sess.persist(b);
		
		sess.getTransaction().commit();
		
		// indicates we are done working with the database for now
		sess.close();
			
	}

	
	public static void stateEx() {
		// hibernate has 3 states for an object
		
		// transient state - this an object which is not associated with a session
		// persistent state - this an object which is associate
		// detached state -  this an object that was persisted at one point
		// but the session has since closed
		
	// Lucina is in a transient state
	// not connected to a session
		Associate lucina = new Associate();
		lucina.setName("Lucina");
		lucina.setPoints(50000);
		
		Session sess = sf.openSession();
		
		sess.beginTransaction();
		
		// turns lucina into a persistent state object
		
		// when you persist an object changes to it
		// are permanent and will be applied to the database when it actually commits
		sess.persist(lucina);
		lucina.setName("Female Marth");
		
		sess.getTransaction().commit();
		sess.close();
		
		// lucina is now in a detached state
		// changes to it do not affect the database
		lucina.setName("Sword Person");
		System.out.println(lucina);
	}
	
	
	public static void sql() {
		// Is basically a last resort 
		// It can be helpful if need a very specific feature of sql
		// but other criteria and HQL are easier to use
		Session sess = sf.openSession();
		
		String sql = "select * from associate";
		SQLQuery sq = sess.createSQLQuery(sql);
		
		List result =sq.list();
		
		System.out.println(result);
		
	}
	
	public static void criteria() {
		
		// The most oop way of performing queries to you database
		// you create a criteria with the class as that you will returning
		// then you add restrictions to that criteria to form you query
		Session sess = sf.openSession();
				
		Criteria crit = sess.createCriteria(Associate.class);
		
		crit.add(Restrictions.like("name", "%Bowser%"));
		
		List associates = crit.list();
		System.out.println(associates);
		
	}
	
	public static void hql() {
		// HQL is a way to query using Hibernate Query Language
		// similar to sql but a bit more oop centered
		// It is independent of sql syntax for a database
		// HQL is case sensitive
		
		Session sess = sf.openSession();
		String hql = "FROM Associate A where A.points > 9000";
		Query q = sess.createQuery(hql);
		List result = q.list();
		
		System.out.println(result);
		
		
		
	}

	public static void get() {
		
		Session sess = sf.openSession();
		
		long start = System.currentTimeMillis();
		Batch sdet = sess.get(Batch.class, 1);	
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		sess.close();
//		System.out.println(sdet.getAssociates());
				
	}
	public static void load(){
		// Hibernate has both a load and get for grabbing objects from the database
		// load by default will do lazy loading
		// get will do eager loading
		// you can override this in the entity class. 
		
		// Load uses a proxy
		// instead of getting a real batch you get a proxy
		// It is a contract with an object saying this information belongs
		// to you if you request it
		// Fake object with holes for information that get filled when requested
		
		
		Session sess = sf.openSession();
		
		long start = System.currentTimeMillis();
		Batch sdet = sess.load(Batch.class, 1);	
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		sess.close();

		
	}
	
	public static void mergeVSupdate() {
		
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Associate pit = new Associate();
		pit.setName("Pit");
		pit.setPoints(5700);
		
		sess.save(pit);
		
		Associate dark_pit = new Associate();
		
		dark_pit.setId(pit.getId());
		dark_pit.setName("DarkPit");
		dark_pit.setPoints(9999999);
		
		//sess.update(dark_pit);
		sess.merge(dark_pit);
		
		sess.getTransaction().commit();
		
		
	}
	

}

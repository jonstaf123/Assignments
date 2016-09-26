package ssa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="major")
public class Major {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	public Major(int reqSat, String description) {
		super();
		this.reqSat = reqSat;
		this.description = description;
		
	}

	
	public int getId() {
		return id;
	}

	public int getReqSat() {
		return reqSat;
	}

	public void setReqSat(int reqSat) {
		this.reqSat = reqSat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="req_sat")
	int reqSat;
	
	@Column(name="description")
	String description;
	
	public static void insertMajor(int reqSat, String description) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			Major mjr = new Major(reqSat, description);
			
			session.beginTransaction();
			
			session.save(mjr);
			System.out.println("New Record" + mjr);
			
			session.getTransaction().commit();
					
					
		} catch (Exception e) { e.printStackTrace(); }
			// TODO: handle exception
		finally{
			factory.close();
		}
	}
	public static void updateMajor(int reqSat, String description){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			Major mjr = new Major(reqSat,description);
			
			session.beginTransaction();
			
			session.save(mjr);
			
			session.getTransaction().commit();
					
					
		} catch (Exception e) { e.printStackTrace(); }
			// TODO: handle exception
		finally{
			factory.close();
		}
	}
	public void updateMajor(String description, String newDescription ){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
	      try{
	         session.beginTransaction();
	         Major major = (Major)session.get(Major.class, description); 
	         major.setDescription(newDescription);
			 session.update(major); 
			 session.getTransaction().commit();
	      } catch (Exception e) { e.printStackTrace(); }
			// TODO: handle exception
		finally{
			factory.close();
		}
	}

	public static void deleteMajor(int id){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Major.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		 try{
			 Major major = (Major)session.get(Major.class, id);
			  session.delete(major); 
			  session.getTransaction().commit();
	      } catch (Exception e) { e.printStackTrace(); }
			// TODO: handle exception
		finally{
			factory.close();
		}
}
}
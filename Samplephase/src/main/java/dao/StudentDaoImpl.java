package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import SchoolTables.Students;
import config.Configmain;

public class StudentDaoImpl{

	public List<Students> getAll() {
		// TODO Auto-generated method stub
		
		Session sf=getsession1();
		
		Query a=sf.createQuery("select s from SchoolTables.Students s");
		List<Students> h=a.list();
		return h;
	}
	public Students delete(int r) {
		// TODO Auto-generated method stub
		
		Session sf=getsession1();
		Transaction t=sf.beginTransaction();
		
		
		
		 Query aa=sf.createQuery("from SchoolTables.Students where rollno=:sam");
	     aa.setParameter("sam", r);
		 Students h=(Students)aa;
		 Query aa1=sf.createQuery("delete from Students s  where s.rollno=:nn");
		 aa1.setParameter("nn", r);
		 aa1.executeUpdate();
		 t.commit();
		 return h;
	}
	public static Session getsession1() {
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		return sf;
	}
	
	
}

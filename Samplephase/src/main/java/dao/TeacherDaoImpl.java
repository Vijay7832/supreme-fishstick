package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SchoolTables.Section;
import SchoolTables.Teacher;
import config.Configmain;

public class TeacherDaoImpl {
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		
		Session sf=getsession1();
		Query a=sf.createQuery("select s from SchoolTables.Teacher s");
		List<Teacher> h=a.list();
		return h;
	}
	public Teacher getOneClass(int a) {
		// TODO Auto-generated method stub
		
		Session sf=getsession1();
		
		Teacher ko=sf.get(Teacher.class, a);
		return ko;
	}
	public static Session getsession1() {
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		return sf;
	}
	

}



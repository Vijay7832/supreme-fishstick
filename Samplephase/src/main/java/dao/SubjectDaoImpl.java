package dao;

import java.util.List;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import SchoolTables.Subjects;
import config.Configmain;

public class SubjectDaoImpl {
	public List<Subjects> getAll() {
		// TODO Auto-generated method stub
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		Query a=sf.createQuery("select s from SchoolTables.Subjects s");
		List<Subjects> h=(List<Subjects>) a.list();
		return h;
	}
}

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SchoolTables.Section;
import SchoolTables.Students;
import config.Configmain;
import org.hibernate.Transaction;
public class SectionDaoImpl{

	
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		
		Query a=sf.createQuery("select s from SchoolTables.Section s");
		List<Section> h=a.list();
		return h;
	}
	public Section getOneClass(int a) {
		// TODO Auto-generated method stub
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		
		Section ko=sf.get(Section.class, a);
		return ko;
	}
	public void addsection(int a) {
		// TODO Auto-generated method stub
		SessionFactory ss=Configmain.getsessionfactory();
		Session sf=ss.openSession();
		Transaction t=sf.beginTransaction();
		Section ko=new Section(a);
		sf.save(ko);
		t.commit();
	}
	
}

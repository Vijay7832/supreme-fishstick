package config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import SchoolTables.Section;
import SchoolTables.Students;
import SchoolTables.Subjects;
import SchoolTables.Teacher;



public class Configmain {

	public static SessionFactory getsessionfactory(){
//	public static void main(String[] args) {
		Configuration c=new Configuration();
		Properties p=new Properties();
		p.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		p.put(Environment.URL,"jdbc:mysql://localhost:3306/Schooltest");
		p.put(Environment.USER, "root");
		p.put(Environment.PASS,"Vijay@123");
		p.put(Environment.SHOW_SQL,true);
		p.put(Environment.FORMAT_SQL,true );
		p.put(Environment.HBM2DDL_AUTO,"update");
		p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	    c.setProperties(p);
	    c.addAnnotatedClass(Section.class);
	    c.addAnnotatedClass(Students.class);
	    c.addAnnotatedClass(Subjects.class);
	    c.addAnnotatedClass(Teacher.class);
	    SessionFactory sf=c.buildSessionFactory();
		return sf;
	}

}
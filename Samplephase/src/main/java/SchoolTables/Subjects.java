package SchoolTables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table
public class Subjects {
	@Id
	private int subjectno;
	private String subjectname;
	@ManyToMany
	private List<Teacher> t=new ArrayList();
	@ManyToMany(mappedBy="sub")
	private List<Section> sec=new ArrayList(); 
	public Subjects() {
		super();
	}
	public Subjects(int subjectno, String subjectname) {
		super();
		this.subjectno = subjectno;
		this.subjectname = subjectname;
	}
	public int getSubjectno() {
		return subjectno;
	}
	public void setSubjectno(int subjectno) {
		this.subjectno = subjectno;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public List<Teacher> getT() {
		return t;
	}
	public void setT(List<Teacher> t) {
		this.t = t;
	}
	@Override
	public String toString() {
		return subjectname;
	}
	
	
}

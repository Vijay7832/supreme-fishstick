package SchoolTables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table
public class Teacher {
	@Id
	private int empid;
	private String name;
	
	private int experience;
	
	@ManyToMany(mappedBy="t")
	private List<Subjects> sub=new ArrayList();
	
	@ManyToMany(mappedBy="tec")
	private List<Section> sec=new ArrayList(); 
	public Teacher() {
		super();
	}
	public Teacher(int empid, String name, int experience) {
		super();
		this.empid = empid;
		this.name = name;
		this.experience = experience;
	
	}
	public int getEmpid() {
		return empid;
	}
	public String getName() {
		return name;
	}
	public int getExperience() {
		return experience;
	}
	public List<Subjects> getSub() {
		return sub;
	}
	public void setSub(List<Subjects> sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "Teacher [empid=" + empid + ", name=" + name + "]";
	}
	
	
	
	
}

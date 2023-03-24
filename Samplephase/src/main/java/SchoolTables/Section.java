package SchoolTables;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="class")
public class Section {
    @Id
	private int classno;
    @OneToMany(mappedBy="s")
    private List<Students> l=new ArrayList();
    
    @ManyToMany
	private List<Teacher> tec=new ArrayList(); 
    
    @ManyToMany
    private List<Subjects> sub = new ArrayList(); 
	public Section() {
		super();
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public Section(int classno) {
		super();
		this.classno = classno;
	}
	public List<Students> getL() {
		return l;
	}
	public void setL(List<Students> l) {
		this.l = l;
	}
	public List<Subjects> getSub() {
		return sub;
	}
	public void setSub(List<Subjects> sub) {
		this.sub = sub;
	}
	public List<Teacher> getTec() {
		return tec;
	}
	public void setTec(List<Teacher> tec) {
		this.tec = tec;
	}
	
	
	
}

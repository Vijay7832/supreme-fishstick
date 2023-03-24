package SchoolTables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity

@Table
public class Students {
	@Id
	private int rollno;
	private String name;
	private String fathername;
	
	@ManyToOne
	@JoinColumn
	private Section s;
	
	public Students() {
		super();
	}
	public Students(int rollno, String name, String fathername) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.fathername = fathername;
	}
	
	
	
	
	public Students(int rollno, String name, String fathername, Section s) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.fathername = fathername;
		this.s = s;
	}
	public void setS(Section s) {
		this.s = s;
	}
	public int getRollno() {
		return rollno;
	}
	public String getName() {
		return name;
	}
	public String getFathername() {
		return fathername;
	}
	public Section getS() {
		return s;
	}
	@Override
	public String toString() {
		return "Students [rollno=" + rollno + ", name=" + name + ", fathername=" + fathername + ", s=" + s + "]";
	}
	
}
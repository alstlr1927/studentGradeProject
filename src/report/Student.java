package report;

import java.util.Objects;

public class Student {
	
	private int id;
	private String name;
	private int java;
	private int kotlin;
	private int db;
	private int c;
	private int total;
	private double avg;
	private String grade;
	
	public Student(int id, String name, int java, int kotlin, int db, int c) {
		this(id, name, java, kotlin, db, c, 0, 0.0, null);
	}

	public Student(int id, String name, int java, int kotlin, int db, int c, int total, double avg, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.java = java;
		this.kotlin = kotlin;
		this.db = db;
		this.c = c;
		this.total = total;
		this.avg = avg;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getKotlin() {
		return kotlin;
	}

	public void setKotlin(int kotlin) {
		this.kotlin = kotlin;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag =false;
		if(obj instanceof Student) {
			Student student = (Student)obj;
			if(this.id == student.id) {
				flag =true;
			}
		}
		return flag;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + java + "\t" + kotlin + "\t" + db + "\t"
				+ c + "\t" + total + "\t" + avg + "\t" + grade;
	}
	
}

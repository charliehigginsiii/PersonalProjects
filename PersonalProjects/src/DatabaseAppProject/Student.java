package DatabaseAppProject;

public class Student {
	private int id;
	private String name;
	private String classification;
	private String age;
	private String major;
	private String gpa;
	private String residence;
	public Student(int id,String name, String classification, String age, String major, String gpa, String residence) {
		super();
		this.id=id;
		this.name = name;
		this.classification = classification;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
		this.residence = residence;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
}

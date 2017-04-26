package study.modernjava;

public class Guest {
	private final int grade;
	private final String name;
	private final String company;
	
	public Guest(int grade, String name, String company) {
		super();
		this.grade = grade;
		this.name = name;
		this.company = company;
	}
	public int getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public String getCompany() {
		return company;
	}
}

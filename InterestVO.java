package kr.co.sist.vo;

public class InterestVO {
	private String name,interest;

	public InterestVO(String name, String interest) {
		this.name = name;
		this.interest = interest;
	}
	
	public InterestVO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
	
}

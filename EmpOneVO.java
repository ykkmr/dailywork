package day0407;

public class EmpOneVO {
	private String ename;
	private int deptno;
	private String job;
	private String hiredate;
	
	
	public EmpOneVO() {
	}


	public EmpOneVO(String ename, int deptno, String job, String hiredate) {
		super();
		this.ename = ename;
		this.deptno = deptno;
		this.job = job;
		this.hiredate = hiredate;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	

}

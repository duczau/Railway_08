package com.vti.Candidate.backend.entity;

public class ExperienceCandidate extends Candidates {

	private int expInYear;
	private String proSkill;

	public ExperienceCandidate(int id, String firstName, String lastName, String phone, String email, String password, String type,
			int expInYear, String proSkill) {
		super(id, firstName, lastName, phone, email, password,type);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString()+", expInYear= " + expInYear + ", proSkill= " + proSkill;
	}

}

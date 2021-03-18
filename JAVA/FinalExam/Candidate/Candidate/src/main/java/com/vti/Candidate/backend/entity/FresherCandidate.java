package com.vti.Candidate.backend.entity;

public class FresherCandidate extends Candidates {

	private String graduationRank;

	public FresherCandidate(int id, String firstName, String lastName, String phone, String email, String password,String type, String graduationRank) {
		super(id, firstName, lastName, phone, email,password, type);
		this.graduationRank = graduationRank;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	@Override
	public String toString() {
		return super.toString()+" graduationRank= " + graduationRank;
	}

}

package com.vti.Candidate.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Candidate.backend.entity.Candidates;
import com.vti.Candidate.backend.service.CandidateService;
import com.vti.Candidate.backend.service.ICandidateService;

public class CandidateController {
	private ICandidateService candidateService;

	public CandidateController() {
		candidateService = new CandidateService();
	}
	
	public List<Candidates> getListCandidatesController()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return candidateService.getListCandidatesService();
	}

	public void createCandidateController(String newPhone, String newEmail, String password, int expInYear, String graduationRank)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		candidateService.createCandidateService(newPhone, newEmail, password,expInYear, graduationRank);
	}

	public boolean isCandidateEmailExistsController(String email)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return candidateService.isCandidateEmailExistsService(email);
	}

	public boolean loginController(String email, String pass)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException, Exception {
		return candidateService.loginService(email, pass);
	}
}

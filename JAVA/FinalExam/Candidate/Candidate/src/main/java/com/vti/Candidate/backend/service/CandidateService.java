package com.vti.Candidate.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Candidate.backend.entity.Candidates;
import com.vti.Candidate.backend.repository.CandidateRepository;
import com.vti.Candidate.backend.repository.ICandidateRepository;

public class CandidateService implements ICandidateService {
	private ICandidateRepository candidateRepository;

	public CandidateService() {
		candidateRepository = new CandidateRepository();
	}
	
	public List<Candidates> getListCandidatesService()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return candidateRepository.getListCandidates();
	}

	public void createCandidateService(String newPhone, String newEmail, String password, int expInYear, String graduationRank)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		candidateRepository.createCandidate(newPhone, newEmail, password,expInYear, graduationRank);
	}

	public boolean isCandidateEmailExistsService(String email)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return candidateRepository.isCandidateEmailExists(email);
	}

	public boolean loginService(String email, String pass)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException, Exception {
		return candidateRepository.login(email, pass);
	}

}

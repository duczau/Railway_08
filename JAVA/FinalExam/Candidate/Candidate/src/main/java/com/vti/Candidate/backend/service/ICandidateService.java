package com.vti.Candidate.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Candidate.backend.entity.Candidates;

public interface ICandidateService {
	List<Candidates> getListCandidatesService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	void createCandidateService(String newPhone, String newEmail, String password,int expInYear, String graduationRank) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	boolean isCandidateEmailExistsService(String email) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;

	boolean loginService(String email, String pass) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException, Exception;
}

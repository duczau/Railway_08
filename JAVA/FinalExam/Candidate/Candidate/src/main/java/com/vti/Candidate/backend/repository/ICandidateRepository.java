package com.vti.Candidate.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Candidate.backend.entity.Candidates;


public interface ICandidateRepository {
	List<Candidates> getListCandidates() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	void createCandidate(String newPhone, String newEmail, String password,int expInYear, String graduationRank) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	boolean isCandidateEmailExists(String email) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;

	boolean login(String email, String pass) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException, Exception;
}

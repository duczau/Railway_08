package com.vti.Candidate.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Candidate.Ultils.JBDCUltils;
import com.vti.Candidate.backend.entity.Candidates;
import com.vti.Candidate.backend.entity.ExperienceCandidate;
import com.vti.Candidate.backend.entity.FresherCandidate;

public class CandidateRepository implements ICandidateRepository {
	private JBDCUltils jbdcUltils;
	private Connection connection;

	public CandidateRepository() {
		jbdcUltils = new JBDCUltils();
	}

	public List<Candidates> getListCandidates()
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Candidates> candidates = new ArrayList<Candidates>();

		try {
			connection = jbdcUltils.connect();

			String sql = "Select * FROM candidate";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (resultSet.getString("type").equals("experiencecandidate")) {
					Candidates exp = new ExperienceCandidate(resultSet.getInt("id"), resultSet.getString("firstName"),
							resultSet.getString("lastName"), resultSet.getString("phone"), resultSet.getString("email"),
							resultSet.getString("password"), resultSet.getString("type"), resultSet.getInt("expInYear"),
							resultSet.getString("proSkill"));
					candidates.add(exp);
				} else {
					Candidates fresh = new FresherCandidate(resultSet.getInt("id"), resultSet.getString("firstName"),
							resultSet.getString("lastName"), resultSet.getString("phone"), resultSet.getString("email"),
							resultSet.getString("password"), resultSet.getString("type"),
							resultSet.getString("graduationRank"));
					candidates.add(fresh);
				}

			}
			return candidates;
		} finally {
			connection.close();
		}
	}

	public void createCandidate(String newPhone, String newEmail, String password, int expInYear, String graduationRank)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		connection = jbdcUltils.connect();

		String sql = "INSERT INTO candidate (phone,email,password,`type`,expInYear,graduationRank) "
				+ " VALUES (? , ? , ?, ?, ?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, newPhone);
		preparedStatement.setString(2, newEmail);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, "freshercandidate");
		preparedStatement.setInt(5, expInYear);
		preparedStatement.setString(6, graduationRank);
		preparedStatement.executeUpdate();

	}

	public boolean isCandidateEmailExists(String email)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		connection = jbdcUltils.connect();

		String sql = "SELECT email FROM candidate WHERE email = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	public boolean login(String email, String pass) throws Exception {
		connection = jbdcUltils.connect();

		String sql = "SELECT email, password FROM candidate WHERE email = ? AND password = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, pass);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

}

package com.simpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RailwayCrossingDAO {
	private Connection connection;

	public RailwayCrossingDAO() {
		// Initialize the database connection
		connection = DatabaseConnection.getConnection();
	}

	// Fetch all values from the database
	public List<RailwayCrossing> getAllCrossings() {
		List<RailwayCrossing> crossings = new ArrayList<>();
		try {
			String query = "SELECT * FROM railway_crossing";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				RailwayCrossing crossing = new RailwayCrossing();
				crossing.setId(resultSet.getInt("id"));
				crossing.setName(resultSet.getString("name"));
				crossing.setAddress(resultSet.getString("address"));
				crossing.setLandmark(resultSet.getString("landmark"));
				crossing.setTrainSchedule(resultSet.getString("train_schedule"));
				crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
				crossing.setStatus(resultSet.getString("status"));
				crossings.add(crossing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crossings;
	}

	// Search values by id and display it from the database
	public RailwayCrossing getCrossingById(int crossingId) {
		RailwayCrossing crossing = null;
		try {
			String query = "SELECT * FROM railway_crossing WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, crossingId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				crossing = new RailwayCrossing();
				crossing.setId(resultSet.getInt("id"));
				crossing.setName(resultSet.getString("name"));
				crossing.setAddress(resultSet.getString("address"));
				crossing.setLandmark(resultSet.getString("landmark"));
				crossing.setTrainSchedule(resultSet.getString("train_schedule"));
				crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
				crossing.setStatus(resultSet.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crossing;
	}

	// update the values in the database
	public void updateCrossing(RailwayCrossing crossing) {
		try {
			String query = "UPDATE railway_crossing SET name=?, address=?, landmark=?, train_schedule=?, person_in_charge=?, status=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, crossing.getName());
			statement.setString(2, crossing.getAddress());
			statement.setString(3, crossing.getLandmark());
			statement.setString(4, crossing.getTrainSchedule());
			statement.setString(5, crossing.getPersonInCharge());
			statement.setString(6, crossing.getStatus());
			statement.setInt(7, crossing.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Railway Crossing
	public void deleteCrossing(int crossingId) {
		try {
			connection.setAutoCommit(false); // Start transaction

			// Delete associated favorite crossings
			String deleteFavoriteCrossingsQuery = "DELETE FROM favorite_crossing WHERE railway_crossing_id = ?";
			try (PreparedStatement deleteFavoriteCrossingsStatement = connection
					.prepareStatement(deleteFavoriteCrossingsQuery)) {
				deleteFavoriteCrossingsStatement.setInt(1, crossingId);
				deleteFavoriteCrossingsStatement.executeUpdate();
			}

			// Delete the railway crossing
			String deleteRailwayCrossingQuery = "DELETE FROM railway_crossing WHERE id = ?";
			try (PreparedStatement deleteRailwayCrossingStatement = connection
					.prepareStatement(deleteRailwayCrossingQuery)) {
				deleteRailwayCrossingStatement.setInt(1, crossingId);
				deleteRailwayCrossingStatement.executeUpdate();
			}

			connection.commit(); // Commit the transaction
			connection.setAutoCommit(true); // Reset auto-commit to true
		} catch (SQLException e) {
			try {
				connection.rollback(); // Rollback the transaction if an error occurs
			} catch (SQLException rollbackException) {
				rollbackException.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	// Add values to the database
	public void addCrossing(RailwayCrossing crossing) {
		try {
			String query = "INSERT INTO railway_crossing (name, address, landmark, train_schedule, person_in_charge, status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, crossing.getName());
			statement.setString(2, crossing.getAddress());
			statement.setString(3, crossing.getLandmark());
			statement.setString(4, crossing.getTrainSchedule());
			statement.setString(5, crossing.getPersonInCharge());
			statement.setString(6, crossing.getStatus());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RailwayCrossing> getFavoriteCrossings() {
		List<RailwayCrossing> favoriteCrossings = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT rc.* FROM railway_crossing rc "
					+ "JOIN favorite_crossing fc ON rc.id = fc.railway_crossing_id";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RailwayCrossing crossing = new RailwayCrossing();
				crossing.setId(resultSet.getInt("id"));
				crossing.setName(resultSet.getString("name"));
				crossing.setAddress(resultSet.getString("address"));
				crossing.setLandmark(resultSet.getString("landmark"));
				crossing.setTrainSchedule(resultSet.getString("train_schedule"));
				crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
				crossing.setStatus(resultSet.getString("status"));

				favoriteCrossings.add(crossing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return favoriteCrossings;
	}

	public void addToFavorites(int crossingId) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "INSERT INTO favorite_crossing (railway_crossing_id) VALUES (?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, crossingId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
	}

	public void removeFromFavorites(int crossingId) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "DELETE FROM favorite_crossing WHERE railway_crossing_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, crossingId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception as needed
		}
	}

}

package nr2;

import java.sql.*;
import java.util.*;
import db.ConnectToDB;

public class DBHandlerBokliste {

	private String databaseName;
	private String serverName;
	private ConnectToDB db;
	private Connection con;
	private String tableName = "bokliste";
	private PreparedStatement pstmtUpdateTittel;
	private PreparedStatement pstmtUpdateForfatter;
	private PreparedStatement pstmtDeleteForfatter;
	private PreparedStatement pstmtDeleteTittel;
	private PreparedStatement pstmtInsertRow;
	private PreparedStatement pstmtGetTable;
	private PreparedStatement pstmtGetRow;

	public DBHandlerBokliste(String user, String password) throws SQLException {

		db.setServerName(serverName);
		db.setDatabaseName(databaseName);
		
		db = new ConnectToDB(user, password);
		con = db.getConnection();
	}

	public String getDatabaseName() {
		return databaseName;
	}

	@SuppressWarnings("unused")
	private void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getServerName() {
		return serverName;
	}

	@SuppressWarnings("unused")
	private void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int updateTittel(String nyTittel, String tittel) throws SQLException {

		String updateTittel = "UPDATE ? SET TITTEL = ? WHERE TITTEL = ?";
		con = null;
		pstmtUpdateTittel = null;
		int rowsAffected;

		try {
			con = db.getConnection();
			pstmtUpdateTittel = con.prepareStatement(updateTittel);
			pstmtUpdateTittel.setString(1, tableName);
			pstmtUpdateTittel.setString(2, nyTittel);
			pstmtUpdateTittel.setString(3, tittel);

			rowsAffected = pstmtUpdateTittel.executeUpdate();
		} finally {
			try {
				pstmtUpdateTittel.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				con.close();
			} catch (Exception e) {
				/* ignored */ }
		}
		return rowsAffected;
	}

	public int updateForfatter(String nyForfatter, String forfatter) throws SQLException {

		String updateForfatter = "UPDATE ? SET FORFATTER = ? WHERE FORFATTER = ?";
		con = null;
		pstmtUpdateForfatter = null;
		int rowsAffected;

		try {
			con = db.getConnection();
			pstmtUpdateForfatter = con.prepareStatement(updateForfatter);
			pstmtUpdateForfatter.setString(1, tableName);
			pstmtUpdateForfatter.setString(2, nyForfatter);
			pstmtUpdateForfatter.setString(3, forfatter);

			rowsAffected = pstmtUpdateForfatter.executeUpdate();
		} finally {
			try {
				pstmtUpdateForfatter.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				con.close();
			} catch (Exception e) {
				/* ignored */ }
		}
		return rowsAffected;
	}

	public int deleteForfatter(String forfatter) throws SQLException {

		String deleteForfatter = "DELETE FROM ? WHERE FORFATTER = ?";
		con = null;
		pstmtDeleteForfatter = null;
		int rowsAffected;

		try {
			con = db.getConnection();
			pstmtDeleteForfatter = con.prepareStatement(deleteForfatter);
			pstmtDeleteForfatter.setString(1, tableName);
			pstmtDeleteForfatter.setString(2, forfatter);

			rowsAffected = pstmtDeleteForfatter.executeUpdate();
		} finally {
			try {
				pstmtDeleteForfatter.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				con.close();
			} catch (Exception e) {
				/* ignored */ }
		}
		return rowsAffected;
	}

	public int deleteTittel(String tittel) throws SQLException {

		String deleteTittel = "DELETE FROM ? WHERE TITTEL = ?";
		con = null;
		pstmtDeleteTittel = null;
		int rowsAffected;

		try {
			con = db.getConnection();
			pstmtDeleteTittel = con.prepareStatement(deleteTittel);
			pstmtDeleteTittel.setString(1, tableName);
			pstmtDeleteTittel.setString(2, tittel);

			rowsAffected = pstmtDeleteTittel.executeUpdate();
		} finally {
			try {
				pstmtDeleteTittel.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				con.close();
			} catch (Exception e) {
				/* ignored */ }
		}
		return rowsAffected;
	}

	public int insertRow(String isbn, String forfatter, String tittel) throws SQLException {

		String insertRow = "INSERT INTO ? VALUES (?, ?, ?)";
		con = null;
		pstmtInsertRow = null;
		int rowsAffected;

		try {
			con = db.getConnection();
			pstmtInsertRow = con.prepareStatement(insertRow);
			pstmtInsertRow.setString(1, tableName);
			pstmtInsertRow.setString(2, isbn);
			pstmtInsertRow.setString(3, forfatter);
			pstmtInsertRow.setString(4, tittel);

			rowsAffected = pstmtInsertRow.executeUpdate();
		} finally {
			try {
				pstmtInsertRow.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				con.close();
			} catch (Exception e) {
				/* ignored */ }
		}
		return rowsAffected;
	}

	public ArrayList<String[]> getTable() throws SQLException {

		ArrayList<String[]> al = new ArrayList<String[]>();

		String getTable = "SELECT * FROM ?";
		pstmtGetTable.setString(1, tableName);

		ResultSet rs = pstmtGetTable.executeQuery(getTable);

		int antall = rs.getMetaData().getColumnCount();

		while (rs.next()) {
			String[] row = new String[antall];
			for (int i = 0; i < antall; i++) {
				row[i] = rs.getString(i + 1);
			}
			al.add(row);
		}

		try {
			pstmtGetTable.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			con.close();
		} catch (Exception e) {
			/* ignored */ }

		return al;
	}

	public String getRow(String forfatter, String tittel) throws SQLException {

		String getRow = "SELECT * FROM ? WHERE FORFATTER = ? AND TITTEL = ?";
		pstmtGetRow.setString(1, tableName);
		pstmtGetRow.setString(2, forfatter);
		pstmtGetRow.setString(3, tittel);

		ResultSet rs = pstmtGetRow.executeQuery(getRow);

		try {
			rs.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			pstmtGetRow.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			con.close();
		} catch (Exception e) {
			/* ignored */ }

		return rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3);
	}

}
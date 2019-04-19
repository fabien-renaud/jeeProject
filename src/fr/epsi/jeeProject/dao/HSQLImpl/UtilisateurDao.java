package fr.epsi.jeeProject.dao.HSQLImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IUtilisateurDao;

public class UtilisateurDao implements IUtilisateurDao {

	private static final Logger logger = LogManager.getLogger(UtilisateurDao.class);

	@Override
	public Utilisateur getUtilisateur(String email) {

		Utilisateur myUser = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				myUser = new Utilisateur();
				myUser.setEmail(rs.getString(1));
				myUser.setNom(rs.getString(2));
				myUser.setPassord(rs.getString(4));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			myUser = null;
			logger.error("Error while getting user " + email, e);
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				logger.warn("Error while closing connection");
			}
		}

		return myUser;
	}

	@Override
	public void createUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

}
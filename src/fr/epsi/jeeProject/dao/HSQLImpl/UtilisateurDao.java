package fr.epsi.jeeProject.dao.HSQLImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IUtilisateurDao;

public class UtilisateurDao implements IUtilisateurDao {

	private static final String SQL_INSERT = "INSERT INTO USERS (IS_ADMIN,PASSWORD,DATE_CREATION,NOM,EMAIL) VALUES (?,?,?,?,?)";
	private static final Logger logger = LogManager.getLogger(UtilisateurDao.class);

	@Override
	public Utilisateur getUtilisateur(String email) {
		email = email == null ? email = "" : email;
		Utilisateur myUser = new Utilisateur();
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
				myUser.setAdmin(rs.getBoolean(5));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
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
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement preparedStatement = initialisationRequetePreparee( con, SQL_INSERT, true, utilisateur.getAdmin(), utilisateur.getPassord(), utilisateur.getDateCreation(),utilisateur.getNom(),utilisateur.getEmail());
	        logger.warn(preparedStatement);
			int statut = preparedStatement.executeUpdate();
			logger.info("Utilisateur créé", statut);
			con.close();
		} catch (SQLException e) {
			logger.error("Error while creating user", e);
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				logger.error("Error while closing connection", e);
			}
		}

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}
	
	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

}
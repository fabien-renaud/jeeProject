package fr.epsi.jeeProjectTest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;

class UtilisateurTest {

	public Utilisateur monUser = new Utilisateur();
	public UtilisateurDao monUserDao = new UtilisateurDao();

	@Test
	void testGetUserNominal() {
		monUser = monUserDao.getUtilisateur("contact@aquasys.fr");
		assertEquals(monUser.getNom(), "Le prof");
		assertEquals(monUser.getPassord(), "Epsi2019");
		assertEquals(monUser.getAdmin(), true);
	}

	@Test
	void testGetUserNull() {
		monUser = monUserDao.getUtilisateur(null);
		assertEquals(monUser.getNom(), null);
		assertEquals(monUser.getPassord(), null);
		assertEquals(monUser.getAdmin(), null);
	}

	@Test
	void testGetUserMauvais() {
		monUser = monUserDao.getUtilisateur("utilisateurInexistant");
		assertEquals(monUser.getNom(), null);
		assertEquals(monUser.getPassord(), null);
		assertEquals(monUser.getAdmin(), null);
	}

	@Test
	void testADDUser() throws SQLException {
		Utilisateur user = new Utilisateur("email", "nom", "passord", new Date(2019, 05, 13), false);
		monUserDao.createUtilisateur(user);

		monUser = monUserDao.getUtilisateur("email");
		assertEquals(monUser.getNom(), "nom");
		assertEquals(monUser.getPassord(), "passord");
		assertEquals(monUser.getAdmin(), false);
	}

}

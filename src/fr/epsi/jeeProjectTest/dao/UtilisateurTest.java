package fr.epsi.jeeProjectTest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;

class UtilisateurTest {
	public Utilisateur monUser = new Utilisateur();
	public UtilisateurDao monUserDao = new UtilisateurDao();

	@Test
	void testGetUserNominal() {
		monUser = monUserDao.getUtilisateur("contact@aquasys.fr");
		assertEquals(monUser.getNom(),"Le prof");
		assertEquals(monUser.getPassord(),"Epsi2019");
		assertEquals(monUser.getAdmin(),true);
	}
	
	@Test
	void testGetUserNull() {
		monUser = monUserDao.getUtilisateur(null);
		assertEquals(monUser.getNom(),null);
		assertEquals(monUser.getPassord(),null);
		assertEquals(monUser.getAdmin(),null);
	}
	
	@Test
	void testGetUserMauvais() {
		monUser = monUserDao.getUtilisateur("utilisateurInexistant");
		assertEquals(monUser.getNom(),null);
		assertEquals(monUser.getPassord(),null);
		assertEquals(monUser.getAdmin(),null);
	}

}

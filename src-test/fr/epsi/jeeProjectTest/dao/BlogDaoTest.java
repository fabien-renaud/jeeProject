package fr.epsi.jeeProjectTest.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogDao;

class BlogDaoTest {
	public Blog monBlog = new Blog();
	public BlogDao monBlogDao = new BlogDao();

	@Test
	void testGetBlogNominal() {
		monBlog = monBlogDao.getBlog(1);
		assertEquals(monBlog.getTitre(), "titre1");
		assertEquals(monBlog.getDescription(), "contenue1");
	}

	@Test
	void testGetBlogNull() {
		monBlog = monBlogDao.getBlog(null);
		assertEquals(monBlog.getTitre(), null);
		assertEquals(monBlog.getDescription(), null);
	}

	@Test
	void testGetBlogMauvais() {
		monBlog = monBlogDao.getBlog(94568214);
		assertEquals(monBlog.getTitre(), null);
		assertEquals(monBlog.getDescription(), null);
	}

	@Test
	void testADDBlog() throws SQLException {
		Utilisateur monUser= new Utilisateur("contact@aquasys.fr", "contact", "pass", new Date(2019,05,17), true);
		Blog myBlog = new Blog(9999,"titre","madescription",monUser,new Date(2019,05,17),new Date(2019,05,17));

		monBlogDao.createBlog(myBlog);

		monBlog = monBlogDao.getBlog(9999);
		assertEquals(monBlog.getTitre(), "titre");
		assertEquals(monBlog.getDescription(), "madescription");
	}

	@Test
	void testDELBlog() throws SQLException {
		Utilisateur monUser= new Utilisateur("contact@aquasys.fr", "contact", "pass", new Date(2019,05,17), true);
		Blog myBlog = new Blog(9999,"titre","madescription",monUser,new Date(2019,05,17),new Date(2019,05,17));

		monBlogDao.createBlog(myBlog);

		monBlog = monBlogDao.getBlog(9999);
		assertEquals(monBlog.getTitre(), "titre");
		monBlogDao.deleteBlog(9999);
		monBlog = monBlogDao.getBlog(9999);
		assertEquals(monBlog, null);
	}
}

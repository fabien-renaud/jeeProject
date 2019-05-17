package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogDao;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;
import fr.epsi.jeeProject.listeners.StartupListener;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/new-article")
public class NewArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = LogManager.getLogger(LoginServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    public static UtilisateurDao monUserDao = new UtilisateurDao();
    public static BlogDao monBlogDao = new BlogDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewArticleServlet() {
        super();
    }

	/**a
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("GET NewArticle");
		request.getRequestDispatcher("./WEB-INF/NewArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("POST NewArticle");
        HttpSession session = request.getSession();
        String pathInfo = request.getParameter("id");
        if(session.getAttribute("mail") == null){
        	logger.info("Utilisateur non connecté, redirection en cours");
    		response.sendRedirect(request.getContextPath() + "/login");
        } else {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			if(!title.isEmpty() && !description.isEmpty()) {
				try {
					Utilisateur utilisateur = monUserDao.getUtilisateur((String) request.getSession().getAttribute("mail"));
					Blog monBlog = new Blog();
					monBlog.setTitre(title);
					monBlog.setDescription(description);
					monBlog.setCreateur(utilisateur);
					monBlogDao.createBlog(monBlog);
					logger.info("Utilisateur créé");
				} catch (SQLException e) {
					logger.error("Utilisateur non créé", e);
		    		response.sendRedirect(request.getContextPath() + "/signup");
				}
	    		response.sendRedirect(request.getContextPath() + "/home");
			} else {
				logger.error("Utilisateur non crée, formulaire incomplet");
	    		response.sendRedirect(request.getContextPath() + "/signup");
			}
        }
	}

}

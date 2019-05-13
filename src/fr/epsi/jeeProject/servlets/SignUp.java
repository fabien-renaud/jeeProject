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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;
import fr.epsi.jeeProject.listeners.StartupListener;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = LogManager.getLogger(LoginServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    public static UtilisateurDao monUserDao = new UtilisateurDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("mail");
		String nom = request.getParameter("nom");
		String passord = request.getParameter("password");
        Date dateCreation = new Date(2019,05,17);
		Boolean admin = false;
		
		if(!email.isEmpty() && !nom.isEmpty() && !passord.isEmpty()) {
			try {
				monUserDao.createUtilisateur(new Utilisateur(email,nom,passord,dateCreation,admin));
				logger.info("User créée");
			} catch (SQLException e) {
				logger.error("User non créée");
				e.printStackTrace();
			}
			request.getRequestDispatcher("./WEB-INF/TestJSP.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("est dan sla servlet signup");
        doGet(request, response);
	}

}

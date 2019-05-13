package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;
import fr.epsi.jeeProject.listeners.StartupListener;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger logger = LogManager.getLogger(LoginServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    public static UtilisateurDao monUserDao = new UtilisateurDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	HttpSession session = request.getSession(); 
    	if (session.getAttribute("mail") != null) {
        	logger.info("Utilisateur déjà connecté, redirection en cours");
    		response.sendRedirect(request.getContextPath() + "/TestServlet");
    	} else {
        	logger.info("Page de Login");
    		request.getRequestDispatcher("Login.jsp").forward(request, response);
    	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Utilisateur monUser = monUserDao.getUtilisateur(request.getParameter("mail"));
    	HttpSession session = request.getSession(); 
    	if(monUser.getPassord() != null && monUser.getPassord().equals(request.getParameter("password"))) {
        	logger.info("Connexion OK, redirection en cours"); 
            session.setAttribute("mail", request.getParameter("mail"));
    		response.sendRedirect(request.getContextPath() + "/TestServlet");
    	} else {
        	logger.info("Connexion KO, veuillez réessayer");
    		response.sendRedirect(request.getContextPath() + "/LoginServlet");
    	}
    }

}
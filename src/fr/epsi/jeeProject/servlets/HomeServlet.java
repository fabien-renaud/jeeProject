package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.listeners.StartupListener;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger logger = LogManager.getLogger(HomeServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("GET Home");
        HttpSession session = request.getSession();
        if(session.getAttribute("mail") == null){
        	logger.info("Utilisateur non connecté, redirection en cours");
    		response.sendRedirect(request.getContextPath() + "/Login");
        } else {
        	logger.info("Utilisateur connecté");
            request.getRequestDispatcher("./WEB-INF/Home.jsp").forward(request, response);        	
        }
    }
}
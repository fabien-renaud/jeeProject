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
@WebServlet("/SignOut")
public class SignOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger logger = LogManager.getLogger(HomeServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOutServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("GET SignOut");
        HttpSession session = request.getSession();
        session.invalidate();
    	logger.info("Redirection vers la page de Login");
		response.sendRedirect(request.getContextPath() + "/Login");
    }
}
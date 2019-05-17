package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogDao;
import fr.epsi.jeeProject.listeners.StartupListener;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/delete-article")
public class DeleteArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger logger = LogManager.getLogger(HomeServlet.class);
    public static StartupListener monStartupListener = new StartupListener();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticleServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("GET DeleteArticle");
        HttpSession session = request.getSession();
        String pathInfo = request.getParameter("id");
        if(session.getAttribute("mail") == null){
        	logger.info("Utilisateur non connecté, redirection en cours");
    		response.sendRedirect(request.getContextPath() + "/login");
        } else {
        	logger.info("Utilisateur connecté");
        	try {
        		int id = Integer.parseInt(pathInfo);
        		BlogDao monBlogDao = new BlogDao();
        		Blog monBlog = monBlogDao.getBlog(id);
        		monBlogDao.deleteBlog(monBlog);
        	} catch (Exception e) {
            	logger.warn("Article ID incorrect", e);        		
        	}
    		response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
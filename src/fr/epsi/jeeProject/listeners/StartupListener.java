package fr.epsi.jeeProject.listeners;

import fr.epsi.jeeProject.jmx.Premier;
import fr.epsi.jeeProject.servlets.TestServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class StartupListener implements ServletContextListener {
    
    private static final Logger logger = LogManager.getLogger(TestServlet.class);
    /**
     * Default constructor.
     */
    public StartupListener() {
    }
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Démarrage");
        logger.debug("Démarrage");

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
            logger.info("Connexion ok sur localhost");
            con.close();
        } catch (ClassNotFoundException e) {
            logger.error("Driver not available", e);
        } catch (SQLException e) {
            logger.error("Error while connecting to DB", e);
        }
        
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = null;

        try {
            name = new ObjectName("fr.epsi.jmx:type=PremierMBean");
            Premier mbean = new Premier();

            mbs.registerMBean(mbean, name);

        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
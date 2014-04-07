package akkz;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class StudentServerInitializer
 * 
 */
@WebListener
public class ServerInitializer implements ServletContextListener
{

	/**
	 * Default constructor.
	 */
	public ServerInitializer()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sec)
	{
		// TODO Auto-generated method stub
		
		ServletContext context = sec.getServletContext();
		
		String username = (String) context.getInitParameter("username");
		String password = (String) context.getInitParameter("password");
		String url = (String) context.getInitParameter("url");
		
		StudentServer studentServer = new StudentServer(username, password, url);
		
		context.setAttribute("studentServer", studentServer);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO Auto-generated method stub
	}

}

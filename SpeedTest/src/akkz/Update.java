package akkz;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Update extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	public Update()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String ip = request.getRemoteAddr();
		String speed = (String)request.getParameter("fspeed");
		String size = (String)request.getParameter("fsize");
		String operator = (String)request.getParameter("operator");
		String building = (String)request.getParameter("building");
		
		StudentServer studentServer = (StudentServer) this.getServletContext().getAttribute("studentServer");

		studentServer.update(ip, operator, size, speed, building);
		
		response.sendRedirect("/speedtest/result.jsp");
	}

}

package akkz;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataSend extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int receive = Integer.parseInt(request.getParameter("fileSize"));
		
		if(receive < 32 || receive > 1024)
			return;
		
		int size = receive * 1024;
		int process = 0;

		request.getSession().setAttribute("State", "0");
		PrintStream ps = new PrintStream(response.getOutputStream());
		
		long s = System.currentTimeMillis();
		
		for(int i=0; i<=size; i+=128)
		{
			ps.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			
			if(i*100/size > process)
			{
				process = i*100/size;
				
				request.getSession().setAttribute("State", process);
			}
		}
		
		//System.out.println(request.getRemoteAddr() + " " + size / 1024 * 1000 / (System.currentTimeMillis() - s) + "KB/s FileSize:" + size/1000 + "KB");
		
		ps.flush();
		ps.close();
		
		
	}
}

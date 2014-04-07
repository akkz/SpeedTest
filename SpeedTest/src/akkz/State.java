package akkz;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class State extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String kind = request.getParameter("kind");

		PrintStream ps = new PrintStream(response.getOutputStream());

		if (kind != null)
		{
			if (kind.equals("ajaxTest"))
			{
				Object o = request.getSession().getAttribute("State");

				if (o == null)
					ps.print("");
				else
					ps.print(o);
			}
			else if (kind.equals("pressTestState"))
			{
				PressState p = (PressState) request.getSession().getAttribute("PressState");

				if (p == null)
					ps.print("");
				else
					ps.print(p.getState());
			}
			else if (kind.equals("pressTestReamin"))
			{
				PressState p = (PressState) request.getSession().getAttribute("PressState");

				if (p == null)
					ps.print("");
				else
					ps.print(p.getRemain());
			}
		}

	}
}

package akkz;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PressTest extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int process = Integer.parseInt(request.getParameter("fileSize"));
		if(process < 1 || process > 10)
			return;
		
		int size = process * 1048576;
		
		PrintStream ps = new PrintStream(response.getOutputStream());
		
		PressState p = new PressState();
		p.setRemain(process*1024);
		p.setState("[0, 0]");
		request.getSession().setAttribute("PressState", p);
		 
		TimeTrack tt = new TimeTrack();
		tt.setP(p);
		tt.go();
		tt.start();
		
		String oneKb = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		for(int i=size; i>0; i-=1024)
		{
			ps.print(oneKb);
		}
		tt.end();
		
		ps.flush();
		ps.close();
	}
	
	private class TimeTrack extends Thread
	{
		private int send = 0;
		private long s;
		private String state = "";
		private int second = 1;
		boolean flag = false;
		private PressState p;
		
		@Override
		public void run()
		{
			try
			{
				while(flag)
				{
					Thread.sleep(1000);
					
					long e = System.currentTimeMillis();
					state += "[" + second++ + "," + send*1000/(e-s) + "],";
					send = 0;
					s = e;
					
					p.setState("[[" + state.substring(0, state.length()-1) + "]]");
				}
			}
			catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
		

		public void sendData()
		{
			p.send();
			send += 1;
		}
		
		public void go()
		{
			s = System.currentTimeMillis();
			flag = true;
		}
		
		public void end()
		{
			flag = false;
		}

		public void setP(PressState p)
		{
			this.p = p;
		}
	}
}

package akkz;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class StudentServer
{
	private boolean connectedState = false;
	private Connection conn = null;
	Statement state = null;
	ResultSet result = null;
	
	private String username;
	private String password;
	private String url;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public StudentServer(String username, String password, String url)
	{
		this.username = username;
		this.password = password;
		this.url = url;
	}
	
	//==========db操作==========
	
	public void dbConnected()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, password);
			state = conn.createStatement();
			
			if ( !conn.isClosed() )
			{
				connectedState = true;
			}
		}
		catch (ClassNotFoundException ex)
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null,ex);
		}
		catch (SQLException e)
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void dbDisConnected()
	{
		try
		{
			if(result != null)
			{
				result.close();
			}
		}
		catch( SQLException e )
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
			
			throw new RuntimeException(e);
		}
		
		try
		{
			if(state != null)
			{
				state.close();
			}
		}
		catch( SQLException e )
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
			
			throw new RuntimeException(e);
		}
		
		try
		{
			if(conn != null)
			{
				conn.close();
			}
		}
		catch( SQLException e )
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
			
			throw new RuntimeException(e);
		}
	}

	public boolean isConnected()
	{
		return connectedState;
	}
	
	//==========信息获取==========
	
	public void update(String ip, String operator, String size, String speed, String building)
	{
		try
		{
			dbConnected();
			
			Date current = new Date();
			
			//speed = "0";
			
			String sql = "insert into speedtest(ip,filesize,speed,operator,building,datetime) values(\"" + ip + "\",\"" + size + "\",\"" + speed + "\",\"" + operator + "\",\"" + building + "\",\"" + dateFormat.format(current) + "\")";
			
			System.out.println(sql);
			state.execute(sql);
		}
		catch (SQLException e)
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
			
			throw new RuntimeException(e);
		}
		finally
		{
			this.dbDisConnected();
		}
		
	}
	
	public List<Catch> getResult()
	{
		try
		{
			dbConnected();
			
			result = state.executeQuery("SELECT * FROM speedtest");
			
			ArrayList<Catch> list = new ArrayList<Catch>();
			
			while(result.next())
			{
				list.add(new Catch(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
			}
			
			return list;
		}
		catch (SQLException e)
		{
			Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, e);
			
			throw new RuntimeException(e);
		}
		finally
		{
			this.dbDisConnected();
		}
	}
}

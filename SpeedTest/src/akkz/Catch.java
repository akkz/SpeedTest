package akkz;

public class Catch
{
	private String ip;
	private String operator;
	private String speed;
	private String size;
	private String date;
	private String building;

	public Catch(String ip, String size, String speed, String operator, String building, String date)
	{
		super();
		this.ip = ip;
		this.operator = operator;
		this.speed = speed;
		this.size = size;
		this.date = date;
		this.building = building;
	}

	public String getBuilding()
	{
		return building;
	}

	public void setBuilding(String building)
	{
		this.building = building;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getSpeed()
	{
		return speed;
	}

	public void setSpeed(String speed)
	{
		this.speed = speed;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

}

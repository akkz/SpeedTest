package akkz;

public class PressState
{
	private String state;
	private Integer remain;

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Integer getRemain()
	{
		return remain;
	}

	public void setRemain(Integer remain)
	{
		this.remain = remain;
	}

	public void send()
	{
		this.remain--;
	}
}

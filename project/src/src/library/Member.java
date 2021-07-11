package library;

import libraryManager.MemberManager;

public class Member 
{
	private int ID;
	private String Name;
	private String Family;
	private String Password;
	
	//------------------------- getID ----------------------
	public int getID()
	{
		return ID;
	}
	
	//------------------------- setID ----------------------
	public void setID()
	{
		MemberManager mm=new MemberManager();
		int x=mm.CountOFLine();
		ID = 1111+x;
	}
	
	//------------------------- getName ----------------------
	public String getName() 
	{
		return Name;
	}
	
	//------------------------- setName ----------------------
	public void setName(String name)
	{
		Name = name;
	}
	
	//------------------------- getFamily ----------------------
	public String getFamily()
	{
		return Family;
	}
	
	//------------------------- setFamily ----------------------
	public void setFamily(String family) 
	{
		Family = family;
	}
	
	//------------------------- getPassword ----------------------
	public String getPassword()
	{
		return Password;
	}
	
	//------------------------- setPassword ----------------------
	public void setPassword(String password)
	{
		Password = password;
	}

	
	
	
	
	
	
	
	
	
}//end of class

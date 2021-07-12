package libraryManager;

import library.Book;
import library.Member;
import txtManager.txtManager;

public class MemberManager extends txtManager
{

	//----------------------------- Constructor ---------------------------
	public MemberManager()
	{
		super("Member.txt");
		
	}
	
	//----------------------------- AddMember --------------------------------
	public void AddMember(Member m) 
	{
		String s="ID=" + m.getID() + "," + "Password=" + m.getPassword() + "," + "Name=" + m.getName() + "," + "Family=";
		
		super.txtWrite(s);
	}
	
	//----------------------------- Read --------------------------------
	public String[] txtRead ()
	{
		
		return  super.txtRead();
	}
	
	//----------------------------- ReadToString -------------------------
	public String txtReadToString() 
	{
		
		return super.txtReadToString();
	}
	
	//----------------------------- CountOFLine -------------------------
	public int CountOFLine() 
	{
		
		return super.CountOFLine();
	}
	
	//----------------------------- search ------------------------------
	public int[] search (String s) 
	{
		int A[]=new int[100];
		A= super.search(s);
		return A;
	}
	
	//----------------------------- indexA ------------------------------
	public int indexA()
	{
		return super.indexA();
	}
	
	//----------------------------- DeleteMember --------------------------------
	public void DeleteMember(int x)
	{
		 super.txtDeleteLine(x);
	}
	
	
	
	
	
	
}//end of class

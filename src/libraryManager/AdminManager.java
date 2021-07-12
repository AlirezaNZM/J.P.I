package libraryManager;

import txtManager.txtManager;

public class AdminManager extends txtManager
{
	//----------------------------- Constructor ---------------------------
	public AdminManager()
	{
		super("Admin.txt");
		
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
	
}//end if class


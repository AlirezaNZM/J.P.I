package libraryManager;




import txtManager.txtManager;

public class AvailableManager extends txtManager
{
	//----------------------------- Constructor ---------------------------
	public AvailableManager() 
	{
		super("Available.txt");
		
		
	}
	
	//----------------------------- AddBook --------------------------------
	
	private void AddBook(String s) 
	{

		super.txtWrite(s);
	}
	
	//----------------------------- UpdateList --------------------------------
	public void UpdateList ()
	{
		BookManager bm=new BookManager();
		int countofbook=bm.CountOFLine();
		String s[]=bm.txtRead();
		AmanatManager am=new AmanatManager();
		int countofAmanat=am.CountOFLine();
		String t[]=am.txtRead();
		for(int i=0;i<countofAmanat;i++)
		{
			String a=t[i].substring(8,t[i].lastIndexOf(","));
			int A[]=bm.search(a);
			s[A[0]]="";
				
		}
		
		for(int i=0;i<countofbook;i++)
			this.AddBook(s[i]);
		
	}
	
	
	
}//end of class AvailableManager

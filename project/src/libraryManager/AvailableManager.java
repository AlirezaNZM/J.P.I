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
		this.Delete();
		BookManager bm=new BookManager();
		int countofbook=bm.CountOFLine();
		String s[]=bm.txtRead();
		AmanatManager am=new AmanatManager();
		int countofAmanat=am.CountOFLine();
		String t[]=am.txtRead();
		for(int i=0;i<countofAmanat;i++)
		{
			String a=t[i].substring(8,t[i].lastIndexOf(","));
			System.out.println(a);

			for(int j=0;j<countofbook;j++)
			{
		        for (int z = 0; z < s[j].length() - a.length() + 1; z++) 
		        {
		            boolean flag = true;
		            
		            for (int m = 0; m < a.length(); m++) 
		            {
		                if (s[j].charAt(z + m) != a.charAt(m))
		                    flag = false;
		            }//end of for m
		            
		            if (flag) 
		            {
		            	s[j]="";
		            	
		            }
		                
		            
		        }//end of for z
				
			}//end of for j
				
		}//end of for i
		
		for(int i=0;i<countofbook;i++)
			this.AddBook(s[i]);
		
	}
	
	//----------------------------- Delete --------------------------------
	protected void Delete()
	{
		 super.txtDelete();
	}
	
	//----------------------------- ReadToString -------------------------
	public String txtReadToString() 
	{
		
		return super.txtReadToString();
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

}//end of class AvailableManager

package libraryManager;

import library.Amanat;
import library.Book;
import library.Member;
import txtManager.txtManager;

public class AmanatManager extends txtManager 
{
	//----------------------------- Constructor ---------------------------
	public AmanatManager() 
	{
		super("Amanat.txt");
		
		
	}
	
	//-----------------------------  --------------------------------
	//Member m=new Member();
	public void AddBook(Amanat a) 
	{
		String s="ID=" + a.getID() + "," +"Title=" + a.getTitle() + "," + "Author=" + a.getAuthor();
		
		super.txtWrite(s);
	}
	
	
	
	

}

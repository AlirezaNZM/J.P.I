package libraryManager;
import java.util.Date;
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
		Date date = new Date();
		String str = String.format("Data=%tF", date);
		String s="ID=" + a.getID()+"," +"Title=" + a.getTitle() + "," + "Author=" + a.getAuthor() + ","+ str;
		
		super.txtWrite(s);
	}
	
	
	
	

}

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
	
	//----------------------------- AddBook --------------------------------
	
	public void AddBook(Amanat a) 
	{
		Date date = new Date();
		String str = String.format("Data=%tF", date);
		String s="ID=" + a.getID()+"," +"Title=" + a.getTitle() + "," + "Author=" + a.getAuthor() + ","+ str;
		
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
	public void DeleteBook(int x)
	{
		 super.txtDeleteLine(x);
	}
	
	
	

}

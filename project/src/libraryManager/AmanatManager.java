package libraryManager;
import java.time.LocalDate;
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
		LocalDate catch_date = LocalDate.now();

		LocalDate return_data = catch_date.plusDays(10);

		String s="ID=" + a.getID() + "," +"Title=" + a.getTitle() + "," + "Author=" + a.getAuthor() + "," + "Catch date=" + catch_date + " " + "Return date=" + return_data;



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
	
	//----------------------------- DeleteBook --------------------------------
	public void DeleteBook(int x)
	{
		 super.txtDeleteLine(x);
	}
	
	
	

}

package libraryManager;

import library.Book;
import txtManager.txtManager;

public class BookManager extends txtManager
{
	
	//----------------------------- Constructor ---------------------------
	public BookManager()
	{
		super("Book.txt");
		
	}

	//----------------------------- AddBook --------------------------------
	public void AddBook(Book b) 
	{
		String s="Title=" + b.getTitle() + "," + "Author=" + b.getAuthor();
		
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

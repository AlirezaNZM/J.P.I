package library;

public class Book 
{
	private String Title;
	private String Author;
	private Boolean Status;
	
	//------------------- getTitle -------------------------
	public String getTitle() 
	{
		return Title;
	}
	
	//------------------- setTitle -------------------------
	public void setTitle(String title) 
	{
		Title = title;
	}
	
	//------------------- getAuthor -------------------------
	public String getAuthor() 
	{
		return Author;
	}
	
	//------------------- setAuthor -------------------------
	public void setAuthor(String author) 
	{
		Author = author;
	}

	//------------------- getStatus -------------------------
	public 	Boolean getStatus() { return Status; }

	//------------------- setStatus -------------------------
	public void setStatus(Boolean status) { Status = status; }
}//end of class

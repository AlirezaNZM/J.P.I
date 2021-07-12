package Main;

import java.util.Scanner;

import library.Amanat;
import library.Book;
import library.Member;
import libraryManager.AdminManager;
import libraryManager.AmanatManager;
import libraryManager.AvailableManager;
import libraryManager.BookManager;
import libraryManager.MemberManager;
import txtManager.txtManager;


public class Main {

	public static void main(String[] args) 
	{


		
		
		//------------------------------- Login -------------------------------
		int login=-1;
		String search,id="",password,Name,Family;
		Scanner input =new Scanner (System.in);
		System.out.println("Welcome to the H.U.T library");
		System.out.println("Select one of the following (enter its number)");
		while(1==1)
		{
			
			System.out.println("1:Admin \t \n" + "2:Librarian \t \n" + "3:Exit");
			login=input.nextInt();
			if(login==1)
			{
				break;
			}
			else if(login==2)
			{
				break;
			}
			else if(login==3)
			{
				break;
			}
			else
				System.out.println("Enter the number correctly");
		}
		
		//------------------------------- Admin -------------------------------
		boolean AdminInformation=false;
		if(login==1)
		{
			System.out.println("You selected Admin");
			while(1==1)
			{
				System.out.print("Enter ID:");
				id=input.next();
				System.out.print("Enter Password:");
				password=input.next();
				search="ID=" + id + "," + "Password=" + password;
				System.out.println(search);
				AdminManager admin=new AdminManager();
				admin.search(search);
				if(admin.indexA()==0)
					System.out.println("The information entered is not valid !");
				else if(admin.indexA()==1)
				{
					System.out.println("You are logged in...");
					AdminInformation=true;
					break;
				}
			}

		}// end of if AdminInformation
		int AdminMenu=0;
		if(AdminInformation==true)
		{
			
			System.out.println("Select one of the following (enter its number)");
			while(1==1)
			{
				
				System.out.println("1:Home \t \n" + "2:User Management \t \n" + "3:Book Management \t \n" + "4:Report \t \n" + "5:Logout");
				AdminMenu=input.nextInt();
				if(AdminMenu==1)
				{
					break;
				}
				else if(AdminMenu==2)
				{
					break;
				}
				else if(AdminMenu==3)
				{
					break;
				}
				else if(AdminMenu==4)
				{
					break;
				}
				else if(AdminMenu==5)
				{
					break;
				}
				else
					System.out.println("Enter the number correctly !");
			}
			
		}// end of if AdminMenu
		
		//Home
		if(AdminMenu==1)
		{
			System.out.println("You selected Home");
			System.out.println("List of library books");
			BookManager bm=new BookManager();
			System.out.println(bm.txtReadToString());
			
		}// end of if Home
		
		//User Management
		if(AdminMenu==2)
		{
			System.out.println("You selected User Management");
			System.out.println("Select one of the following (enter its number)");
			int usermanagement;
			while(1==1) {
				System.out.println("1:Home \t \n" + "2:Add Member \t \n" + "3:Delete Member \t \n" + "4:User information") ;
				usermanagement = input.nextInt();
				if (usermanagement == 1) {
					break;
				} else if (usermanagement == 2) {
					break;
				} else if (usermanagement == 3) {
					break;
				} else if (usermanagement == 4){
					break;
				} else
					System.out.println("Enter the number correctly !");
				}// end of if user management

			//Home
			if(usermanagement==1)
			{
				System.out.println("You selected Home");


			}// end of if Home

			//add member
			if (usermanagement==2) {
				System.out.println("You selected Add Member");
				System.out.print("Enter Name:");
				Name = input.next();
				System.out.print("Enter Family:");
				Family = input.next();
				System.out.print("Enter Password:");
				password = input.next();
				Member member = new Member();
				member.setID();
				member.setName(Name);
				member.setFamily(Family);
				member.setPassword(password);
				MemberManager mm = new MemberManager();
				mm.AddMember(member);
				
				}//end of add member

			//delete member
			if (usermanagement==3)
			{
				System.out.println("You selected Delete Member");
				System.out.print("Enter ID:");
				id=input.next();
				System.out.print("Enter Password:");
				password = input.next();
				System.out.print("Enter Name:");
				Name = input.next();
				System.out.print("Enter Family:");
				Family = input.next();

				search="ID=" + id + "," + "Password=" + password+ "," + "Name=" + Name+ "," + "Family=" + Family;
				MemberManager mm = new MemberManager();
				int A[]=mm.search(search);
				if(mm.indexA()==0)
					System.out.println("The member was not found");
				else if (mm.indexA()==1)
				{
					mm.DeleteMember(A[0]);
					
					System.out.println("The member was deleted");
				}
					
					
				
				
				
				

			}//end of if delete member

			//user informatin
			if (usermanagement==4){
				System.out.println("You selected User information");
				System.out.println("Select one of the following (enter its number)");
				int userinformation;
				while(1==1) 
				{
					System.out.print("1:Serach by Name and Famaily \t \n" + "2:Search by ID \t \n") ;
					userinformation = input.nextInt();
					if (userinformation == 1) {
						break;
					} else if (userinformation == 2) {
						break;
					} else
						System.out.println("Enter the number correctly !");
					
				}// end of while user information
				//Serach by Name and Famaily
				if(userinformation == 1)
				{
					System.out.println("You selected Serach by Name and Famaily");
					System.out.print("Enter Name:");
					Name=input.next();
					System.out.print("Enter Family:");
					Family=input.next();
					search="Name="+ Name  + "," + "Family=" + Family;
					MemberManager mm = new MemberManager();
					int A[]=mm.search(search);
					String s[]=mm.txtRead();
					search=s[A[0]].substring(0, 7);
					System.out.println(search);
					AmanatManager am=new AmanatManager();
					int B[]=am.search(search);
					String t[]=am.txtRead();
					for(int i=0;i<am.indexA();i++)
						System.out.println(t[i]);
				}

				//Serach by ID
				else if(userinformation == 2)
				{
					System.out.println("You selected Serach by ID");
					System.out.print("Enter ID:");
					id=input.next();
					search="ID="+ id;
					AmanatManager am=new AmanatManager();
					int A[]=am.search(search);
					String t[]=am.txtRead();
					for(int i=0;i<am.indexA();i++)
						System.out.println(t[i]);
				}
				
				
				

			}//end of if user information

		}// end of if User Management
		
		//Book Management
		if(AdminMenu==3)
		{
			System.out.println("You selected Book Management");
			System.out.println("Select one of the following (enter its number)");
			int bookmanagement;
			while(1==1) {
				System.out.println("1:Home \t \n" + "2:Add Book \t \n" + "3:Delete Book  \t \n" + "4:Available Book list \t \n" + "5:Amanat Book list");
				bookmanagement = input.nextInt();
				if (bookmanagement == 1) {
					break;
				} else if (bookmanagement == 2) {
					break;
				} else if (bookmanagement == 3) {
					break;
				} else if (bookmanagement == 4) {
					break;
				} else if (bookmanagement == 5) {
					break;
				} else
					System.out.println("Enter the number correctly !");
			}// end of if bookmanagement

			//Home
			if(bookmanagement==1)
			{
				System.out.println("You selected Home");


			}// end of if Home

			//Add book
			if (bookmanagement==2) {
				System.out.println("You selected Add book");

				System.out.print("Enter a Title:");
				String name = input.next();
				System.out.print("Enter author name:");
				String author = input.next();

				search="Title=" + name + "," + "Author=" + author;
				BookManager checkbook =new BookManager();
				int A[]=checkbook.search(search);
				if(checkbook.indexA()==1){
					System.out.println("the book is exist");
				} else if(checkbook.indexA()==0)
				{

					Book book = new Book();
					book.setTitle(name);
					book.setAuthor(author);

					BookManager nb = new BookManager();
					nb.AddBook(book);
					System.out.println("Done!");
					AvailableManager av=new AvailableManager();
					av.UpdateList();
				}
			}//end of if add book

			//Delete book
			if (bookmanagement==3){
				System.out.println("You selected Delete book");
				System.out.println("Enter book Title:");
				String name = input.next();
				System.out.println("Enter author name:");
				String author = input.next();

				search="Title=" + name + "," + "Author=" + author ;
				BookManager checkbook =new BookManager();
				int A[]=checkbook.search(search);
				if(checkbook.indexA()==0)
					System.out.println("the book is not exist");

				else if (checkbook.indexA()==1) {

					checkbook.DeleteBook(A[0]);
					AvailableManager av=new AvailableManager();
					av.UpdateList();
				}
				}//end of if delete book

			//Available book list
			if (bookmanagement==4){
				System.out.println("You selected Available book list");
				AvailableManager av=new AvailableManager();
				av.UpdateList();
				System.out.println(av.txtReadToString());

			}//end of if Available book list

			//Amanat book list
			if (bookmanagement==5){
				System.out.println("You selected Amanat book list");
				AmanatManager am=new AmanatManager();
				System.out.println(am.txtReadToString());

			}//end of if Amanat book list

		}// end of if Book Management
		
		//Report
		if(AdminMenu==4)
		{
			System.out.println("You selected Report");
			System.out.println("Select one of the following (enter its number)");
			int report;
			while(1==1)
			{
				System.out.print("1:Report by one date \t \n" + "2:Report by two dates \t \n" + "3:Report by user name \t \n" + "4:Report by book name" ) ;
				report = input.nextInt();
				if(report==1)
				{
					break;
				}
				else if(report==2)
				{
					break;
				}
				else if(report==3)
				{
					break;
				}
				else if(report==4)
				{
					break;
				}

				else
					System.out.println("Enter the number correctly !");

			}// end of while report
			//if by one date
			if (report==1){
				System.out.println("You selected report by one date");
				System.out.println("Enter a day");
				int day = input.nextInt();
				System.out.println("Enter a month");
				int month = input.nextInt();
				System.out.println("Enter a year");
				int year = input.nextInt();
				String date ="Return date=" + year + "-" + month + "-" + day;
				search = date;
				AmanatManager checkdate = new AmanatManager();
				String s[]=checkdate.txtRead();
				int A[]=checkdate.search(search);
				if (checkdate.indexA()==0){
					System.out.println("there is not any book with this date");
				} else {
					for (int i=0;i<checkdate.indexA();i++){
						System.out.println(s[A[i]]);
					}
				}


			}//end of if by one date

			//if by two date
			if (report==2){
				System.out.println("You selected report by two dates");

			}//end of if by two date

			//if by user name
			if (report==3){
				System.out.println("You selected report by user name");
				System.out.print("Enter Name:");
				Name=input.next();
				System.out.print("Enter Family:");
				Family=input.next();
				search="Name="+ Name  + "," + "Family=" + Family;
				MemberManager mm = new MemberManager();
				int A[]=mm.search(search);
				String s[]=mm.txtRead();
				search=s[A[0]].substring(0, 7);
				System.out.println(search);
				AmanatManager am=new AmanatManager();
				int B[]=am.search(search);
				String t[]=am.txtRead();
				for(int i=0;i<am.indexA();i++)
					System.out.println(t[i]);

			}//end of if by user name

			//if by book name
			if (report==4){
				System.out.println("You selected report by book name");
				System.out.println("Enter the book name");
				String name = input.next();
				System.out.println("Enter author name");
				String author = input.next();
				search = "Title=" + name + "," + "Author=" + author;
				AmanatManager checkbook = new AmanatManager();
				int A[]=checkbook.search(search);
				if (checkbook.indexA()==0){
					System.out.println("the book is available");
				} else {
					String r[]=checkbook.txtRead();
					for (int i=0;i<checkbook.indexA();i++)
						System.out.println(r[A[i]]);
				}

			}//end of if by book name



		}// end of if Report
		
		//Logout
		if(AdminMenu==5)
		{
			System.out.println("You selected Logout");
			
			
		}// end of if Logout
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------- Librarian -------------------------------
		boolean MemberInformation=false;
		if(login==2)
		{
			System.out.println("You selected Librarian");
			while(1==1)
			{
				System.out.print("Enter ID:");
				id=input.next();
				System.out.print("Enter Password:");
				password=input.next();
				search="ID=" + id + "," + "Password=" + password;
				System.out.println(search);
				MemberManager mm=new MemberManager();
				mm.search(search);
				if(mm.indexA()==0)
					System.out.println("The information entered is not valid !");
				else if(mm.indexA()==1)
				{
					System.out.println("You are logged in...");
					
					
					MemberInformation=true;
					break;
				}
			}

			
		}// end of if MemberInformation
		
		int MemberMenu=0;
		if(MemberInformation==true)
		{
			
			System.out.println("Select one of the following (enter its number)");
			while(1==1)
			{

				System.out.println("1:Home \t \n" + "2:Book Management \t \n" + "3:Change password\t \n" + "4:Logout");
				MemberMenu=input.nextInt();
				if(MemberMenu==1)
				{
					break;
				}
				else if(MemberMenu==2)
				{
					break;
				}
				else if(MemberMenu==3)
				{
					break;
				}

				else if (MemberMenu==4)
				{
					break;
				}
				else
					System.out.println("Enter the number correctly !");

			}
			
		}// end of if MemberMenu

		//Home
		if(MemberMenu==1)
		{
			System.out.println("You selected Home");
					
					
		}// end of if Home
				
		//Book Management
		if(MemberMenu==2)
		{
			System.out.println("You selected Book Management");
			System.out.println("Select one of the following (enter its number)");
			int bookmanagement;
			while(1==1)
			{
				System.out.println( "1:add book \t \n" + "2:search author\t \n" + "3:Borrow a book \t \n" + "4:My book list\t \n" + "5:Amanat book list\t \n" + "6:Relapse a book");
				bookmanagement = input.nextInt();
				if (bookmanagement == 1) {
					break;
				} else if (bookmanagement == 2) {
					break;
				} else if (bookmanagement == 3) {
					break;
				} else if (bookmanagement == 4) {
					break;
				} else if (bookmanagement == 5) {
					break;
				} else if (bookmanagement == 6) {
					break;
				}else
					System.out.println("Enter the number correctly !");
			}//end of while bookmanagement

			//add book
			if (bookmanagement == 1){
				System.out.println("You selected add book");
				System.out.print("Enter a Title:");
				String name = input.next();
				System.out.print("Enter author name:");
				String author = input.next();

				search="Title=" + name + "," + "Author=" + author;
				BookManager checkbook =new BookManager();
				int A[]=checkbook.search(search);
				if(checkbook.indexA()==1){
					System.out.println("the book is exist");
				} else if(checkbook.indexA()==0)
				{

					Book book = new Book();
					book.setTitle(name);
					book.setAuthor(author);

					BookManager nb = new BookManager();
					nb.AddBook(book);
					System.out.println("Done!");
					AvailableManager av=new AvailableManager();
					av.UpdateList();
				}
			}//end of if add book

			//search author
			if (bookmanagement == 2){
				System.out.println("You selected search author");
				System.out.println("Enter the author name");
				String name = input.next();
				search="Author=" + name;
				BookManager autherbook = new BookManager();
				String s[]=autherbook.txtRead();
				int A[]= autherbook.search(search);
				if (autherbook.indexA()==0){
					System.out.println("there is not any book by this author");
				} else {
					for (int i=0;i<autherbook.indexA();i++){
						System.out.println(s[A[i]]);
					}
				}
			}//end of if search author

			//borrow abook
			if (bookmanagement == 3){
				System.out.println("You selected borrow a book");
				System.out.print("Enter a Title:");
				String name = input.next();
				System.out.print("Enter author name:");
				String author = input.next();

				search="Title=" + name + "," + "Author=" + author;
				BookManager checkbook =new BookManager();
				int A[]=checkbook.search(search);
				if(checkbook.indexA()==0){
					System.out.println("the book is not exist");

				} else if(checkbook.indexA()==1) {
					AvailableManager secendcheck = new AvailableManager();
					int B[]=secendcheck.search(search);
					if (secendcheck.indexA()==0){
						System.out.println("the book is unavailable");
					}else if (secendcheck.indexA()==1) {
						Amanat tx = new Amanat();
						tx.setAuthor(name);
						tx.setTitle(author);
						tx.setID(id);
						AmanatManager am = new AmanatManager();
						am.AddBook(tx);
					}
				}


			}//end of if borrow a book

			//my book list
			if (bookmanagement == 4){
				System.out.println("You selected my book list");
				search="ID" + id;
				AmanatManager bl = new AmanatManager();
				int A[]=bl.search(search);
				if (bl.indexA()==0){
					System.out.println("You dont have any book");
				} else {
					String t[] = bl.txtRead();
					for (int i = 8; i < bl.indexA(); i++)
						System.out.println(t[i]);
				}
			}//end of if my book list

			//amanat boo list
			if (bookmanagement == 5){
				System.out.println("You selected amanat book list");
				AmanatManager am=new AmanatManager();
				System.out.println(am.txtReadToString());
			}//end of if amanat

			//relaps a book
			if (bookmanagement == 6){
				System.out.println("You selected relapse a book");
				System.out.println("Enter book Title:");
				String name = input.next();
				System.out.println("Enter author name:");
				String author = input.next();

				search="Title=" + name + "," + "Author=" + author ;
				AmanatManager checkbook =new AmanatManager();
				int A[]=checkbook.search(search);
				if(checkbook.indexA()==0)
					System.out.println("You have not borrowed this book");

				else if (checkbook.indexA()==1) {

					checkbook.DeleteBook(A[0]);
					AvailableManager av=new AvailableManager();
					av.UpdateList();
				}
			}
		}//end of if Book Management
				
		//Change password
		if(MemberMenu==3)
		{
			System.out.println("You selected change password");
					
					
		}// end of if change password

		//Logout
		if (MemberMenu==4)
		{
			System.out.println("You selected Logout");

		}//end of if logout
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------- Exit -------------------------------
		if(login==3)
			System.out.println("Have good day :)");
		
		
		
		
	}// end of main
	

	
	
	
	
	
	

}// end of class

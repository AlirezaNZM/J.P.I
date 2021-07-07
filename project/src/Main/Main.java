package Main;

import java.util.Scanner;

import library.Amanat;
import library.Book;
import library.Member;
import libraryManager.AdminManager;
import libraryManager.AmanatManager;
import libraryManager.BookManager;
import libraryManager.MemberManager;
import txtManager.txtManager;


public class Main {

	public static void main(String[] args) 
	{
		
		
		
		
		
		//------------------------------- Login -------------------------------
		int login=-1;
		String search,id="",password;
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
			
			
		}// end of if Home
		
		//User Management
		if(AdminMenu==2)
		{
			System.out.println("You selected User Management");

			//add member
			System.out.println("You selected Add Member");
			System.out.println("Enter name");
			String name = input.next();
			System.out.println("Enter family");
			String family = input.next();
			System.out.println("Enter Password");
			String Password = input.next();
			Member member = new Member();
			member.setID();
			member.setName(name);
			member.setFamily(family);
			member.setPassword(Password);
			MemberManager nm = new MemberManager();
			nm.AddMember(member);
			//end of add member

		}// end of if User Management
		
		//Book Management
		if(AdminMenu==3)
		{
			System.out.println("You selected Book Management");
			System.out.println("Select one of the following (enter its number)");
			int bookmanagement;
			while(1==1) {
				System.out.println("1:Home \t \n" + "2:Add Book \t \n" + "3:Delete Book  \t \n" + "4:Search Book \t \n" + "5:Available Book list");
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

				System.out.println("Enter a name");
				String name = input.next();
				System.out.println("Enter author name");
				String author = input.next();
				System.out.println("Enter a status (true/false");
				Boolean status = input.nextBoolean();
				Book book = new Book();
				book.setTitle(name);
				book.setAuthor(author);
				book.setStatus(status);
				BookManager nb = new BookManager();
				nb.AddBook(book);
				System.out.println("Done!");
			}//end of if add book

			//Delete book
			if (bookmanagement==3){
				System.out.println("You selected Delete book");

			}//end of if delete book

			//search book
			if (bookmanagement==4){
				System.out.println("You selected Search book");

			}//end of if Search book

			//Available book
			if (bookmanagement==5){
				System.out.println("You selected Available book list");

			}//end of if available book list

		}// end of if Book Management
		
		//Report
		if(AdminMenu==4)
		{
			System.out.println("You selected Report");
			
			
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
				MemberManager member=new MemberManager();
				member.search(search);
				if(member.indexA()==0)
					System.out.println("The information entered is not valid !");
				else if(member.indexA()==1)
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
				
				System.out.println("1:Home \t \n" + "2:Book Management \t \n" + "3:Logout");
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
			
			Amanat tx=new Amanat();
			tx.setAuthor("asdasd");
			tx.setTitle("asdasd");
			tx.setID(id);
			AmanatManager am=new AmanatManager();
			am.AddBook(tx);
			
		}//end of if Book Management
				
		//Logout
		if(MemberMenu==3)
		{
			System.out.println("You selected Logout");
					
					
		}// end of if Logout
				
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------- Exit -------------------------------
		if(login==3)
			System.out.println("Have good day :)");
		
		
		
	}// end of main
	

	
	
	
	
	
	

}// end of class

package txtManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class txtManager 
{
	//----------------------------- Attribute -----------------------------
	private String FileName;
	private int CountOFLine=0;
	private String line[]=new String[100];
	private int indexA=0;
	
	//----------------------------- Constructor ---------------------------
	protected txtManager(String FileName)
	{
		this.FileName=FileName;
	}
	
	
	//----------------------------- Write --------------------------------
	protected void txtWrite (String s)
	{
		
		
        try {
            File file = new File(this.FileName);
            if (!file.exists()) {
                 file.createNewFile();
                 System.out.println("creating new file");
            }else{
                 System.out.println("updating file");

            }
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file , true));
            
            buffer.write(s);
            buffer.write("\n");
            buffer.close();
            System.out.println("finish writing to file");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	//----------------------------- txtDelete --------------------------------
	protected void txtDelete ()
	{
        
            File file = new File(this.FileName);
            
                 file.delete();
                 
          
	}
	
	
	
	
	//----------------------------- Read --------------------------------
	protected String[] txtRead ()
	{
		
		int i=0;
        try 
        {
            File file = new File(this.FileName);
            if (file.exists()) 
            {
                 System.out.println("****** Reading file ... ******");
                 BufferedReader buffer = new BufferedReader(new FileReader(file));
                 
                 while ((line[i] = buffer.readLine()) != null) 
                 {
                     i++;
                     this.CountOFLine++;
                 }
                 buffer.close();
                 System.out.println("****** Finish Reading file ******");
            }
            else
            {
                 System.out.println(file.getAbsolutePath()+" not exist");
            }

        }//end of try 
        catch (FileNotFoundException e) 
        {
            // TODO Auto-generated catch block
        	
            e.printStackTrace();
            
        }//end of catch
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
        	
            e.printStackTrace();
            
        }//end of catch
        
        return line;

	}
	
	
	//----------------------------- ReadToString --------------------------------
	protected String txtReadToString ()
	{
		String t[]=txtRead();
		String s="";
		for(int i=0;i<CountOFLine;i++)
		{
			s=s+ t[i]+"\n" ;
			
		}
		return s;
	}
	
	
	
	
	
	//----------------------------- CountOFLine --------------------------------
	protected int CountOFLine()
	{
		if (CountOFLine!=0)
		{
			return this.CountOFLine;
		}
		else
		{
			String t[]=txtRead();
			return this.CountOFLine;
		}

	}
	
	//----------------------------- Search ------------------------------------
	protected int[] search (String s)
	{
		int A[]=new int[100];
		
		
		String t[]=txtRead();
		
		for(int i=0;i<CountOFLine;i++)
		{
			
	        for (int j = 0; j < t[i].length() - s.length() + 1; j++) 
	        {
	            boolean flag = true;
	            
	            for (int z = 0; z < s.length(); z++) 
	            {
	                if (t[i].charAt(j + z) != s.charAt(z))
	                    flag = false;
	            }//end of for z
	            
	            if (flag) 
	            {
	            	A[indexA]=i;
	            	indexA++;
	            }
	                
	            
	        }//end of for j
			
			
		}//end of for i
		
		return A;
		
	}
	
	//----------------------------- indexA --------------------------------
	protected int indexA()
	{
		return this.indexA;
	}
	
	//----------------------------- DeleteLine --------------------------------
	protected void txtDeleteLine(int x)
	{
		int z=CountOFLine;
		String t[]=this.txtRead();
		
		t[x]="";
		this.txtDelete();
		for(int i=0;i<z;i++)
		{
			this.txtWrite(t[i]);
		}
		
	}
	
	
	
}//end of class

/*
 * Author: Shrikant Pawar
 * Assignment no: 2; Date: 09/10/2015.
 * Description of this program: This program takes the input file and does following things:
   Counts the amount of words in the file. A word can end with a --- space/tab, EOLN character or a punctuation mark (which will be part of the word).
   Count the amount of lines in the file.
   Count the amount of alphanumeric characters in the file.
   Count the number of sentences in the file.
   Count the amount of vowels in the file - only a, e, i, o, u (upper & lower case) are vowels.
   Count the amount of punctuations in the file.
   it outputs a output file with all the above information.
   Instructions for usage: Input a .txt file name when prompted, it will generate an output file named output.txt with the required information.
   Data structures used in this program: Arrays.
 * 
 */
import java.util.*;
import java.io.*;
public class Wordcount{
	public static void main(String[] args)throws FileNotFoundException    //throwing an exception if no file found
	{	
		String filename,input;
		int lcount=0,vcount=0,pcount=0,ccount=0,wcount=0,scount=0;  //defining the initial count to 0 
		int i,j;
		char ch;
		char vowel[]={'A','a','E','e','I','i','O','o','U','u'}; //defining vowels
		char punct[]={'.','!',',','?',':',';'};   //defining punctuation comma, semicolon, colon
		char white[]={'\n','\t',' '};          //defining spaces
		int count = 0;
		String pattern = "[a-z]+[0-9]+";		
		Scanner in=new Scanner(System.in);     //scanner to read in file 
		System.out.print("Enter input file name: ");
		filename=in.next();
		try{PrintStream foutput=new PrintStream(new File("output.txt"));    //output the results in new file named output.txt
		Scanner finput=new Scanner(new FileReader(filename));
		if(!finput.hasNext())
		{System.out.println(filename+"The input file is empty");
		System.exit(1);
		}	
		while(finput.hasNextLine())
		{input=finput.nextLine();
		wcount++;
		for(i=0;i<input.length();i++)
		{ch=input.charAt(i);
		ccount++;
		for(j=0;j<white.length;j++)
		{if(ch==white[j])
			wcount++;
		}
		for( j=0;j<punct.length;j++)
			if(ch==punct[j])
			{pcount++;
			//	if(j<3)  
			scount++;  
			}	  
		for( j=0;j<vowel.length;j++)
			if(ch==vowel[j])
				vcount++;
		}	
		lcount++;			
		}
		
		
		ArrayList <String> ipArray = new ArrayList <String> ();	
			while(finput.hasNextLine()){			
			String [] ipArray1=finput.nextLine().split(" ");	
			ipArray.addAll(Arrays.asList(ipArray1));			
				for(j=0;j<ipArray.size();j++) {
					
					ipArray.get(j);
					
					if (ipArray.get(j).matches(pattern)) {
						
					} 
				}
			}
				
			count++;
				

		//Printing counts on console

		System.out.println("words: "+wcount);
		System.out.println("lines: "+lcount);
		System.out.println("sentences: "+scount);
		System.out.println("vowels: "+vcount);
		System.out.println("characters: "+ccount);
		System.out.println("punctuations: "+pcount);
		foutput.println("Alphanumeric characters: "+count);

		//Exporting counts in .txt file

		foutput.println("words: "+wcount);
		foutput.println("lines: "+lcount);
		foutput.println("sentences: "+scount);
		foutput.println("vowels: "+vcount);
		foutput.println("characters: "+ccount);
		foutput.println("punctuations: "+pcount);
		System.out.println("Alphanumeric characters: "+count);
		
		foutput.close();
		finput.close();
		System.exit(0);
		}catch ( FileNotFoundException e)         // catching if exception found
		{System.out.println("The file you entered does not exist.");
		System.exit(2);
		}
	
	}
}


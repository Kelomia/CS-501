/*
    @author: Zimu Jiao
    HW5-CS501
    6.23
    
    Write a method finds the number of occurrences of a specified character in-
    a string using the following header:
    Example: count("Welcome",'e') return 2. Write a test program that prompts the user- 
    to enter a string followed by a character then displays the number of occurrences- 
    of the character in the string
*/
import java.io.*;
import java.util.Scanner;

class Line{
	String str;
	char ch;
	Line(){}
	
	public void match() throws Exception {
		int mark=0;

		char[] s=this.str.toCharArray();
		for(int i=0;i<this.str.length();i++) {
			if(s[i]==this.ch) {
				System.out.println("The character \""+this.ch+"\" is at "+i+" of the String");
				mark=1;
			}
		}
		if(mark==0) {
			System.out.println("The character \""+this.ch+"\" is not in the String");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		Line line=new Line();

		System.out.print("Please input the String:");
		do {
			try {
				
				line.str=scan.nextLine();
				System.out.println("The String is:\n\t"+line.str);

				System.out.println("Now check the character in String?(1)\n"
						+ "Re-enter the String:");
				if(scan.nextInt()==0) {continue;}
				do {
					System.out.println("Please input the character:");
					line.ch=scan.next().charAt(0);
					
					try {
						line.match();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					System.out.print("Re-enter the character(1)/ Re-enter the String or Quit(0)");
					if(scan.nextInt()==0) {break;}
				}while(true);
				
				System.out.println("Quit(0)/Re-enter the string:");
				if(scan.nextInt()==0) {break;}
			}catch(Exception e) {}
		}while(true);
		
	}
}
/*
    @author: Zimu Jiao
    HW5-CS501
    6.18
    
    Write a method checks whether a string is a valid password:
    ~must have at least ten characters
    ~consists of only letters and digits
    ~must contain at least three digits
    Print "Valid Password" if the rules are followed or "Invalid Password" otherwise.
    
*/

import java.util.Scanner;

class Password{
	String ID;
	String password;
	
	Password(){
		ID="Admin";
		password="PW12345678";
	}
	Password(String ID,String pw){
		this.ID=ID;
		this.password=pw;
	}
	
	public void setPassword(String pw) {
		this.password=pw;
	}
	public void setID(String id) {
		this.ID=id;
	}
	
	
	public int count(String pw,char ch) {
		int position=0;

		char[] password=pw.toCharArray();
		for(int i=0;i<password.length;i++) {
			if(password[i]==ch) {
				position=i+1;
				return position;
			}
		}
		System.out.println("The letter \""+ch+"\" is not in password.");
		return position;
	}
	
    public static void main(String[] args) {
    	boolean mark=true;
    	String temp_id;
    	String temp_pw;
    	Scanner scan = new Scanner(System.in);
    	Password user=new Password();
    	
    	System.out.println("\nMenu:\n\t"
				+ "1.Set ID and Password.\n\t"
				+ "0.Quit?");
		int choose=scan.nextInt();
		if(choose==0) {
			mark=false;
		}
		
		while(mark){
    		System.out.print("Please input ID:");
			temp_id=scan.next();
			// Can add parts of check-ID HERE.
			user.setID(temp_id);
			boolean Valid=true;
			do {
				Valid=true;
				System.out.print("Please input password:");
        		temp_pw=scan.next();
        		char[] chars=temp_pw.toCharArray();
        		if(temp_pw.length()<10) {
        			System.out.println("\tPassword at least 10 characters.");
        			Valid=false;
        		}
        		int countDigit=0;
        		for(int i=0;i<chars.length;i++) {
        			if(Character.isLetterOrDigit(chars[i])) {
        				if(Character.isDigit(chars[i])) {
            				countDigit++;
            			}
        			} else {
        				
        				Valid=false;
        			}
        		}
        		if(!Valid) {
        			System.out.println("\tPassword only consist letter or digit");
        		}
        		if(countDigit<3) {
        			System.out.println("\tPassword must have at least 3 Digits");
        			Valid=false;
        		}
        		if(Valid) {
        			Valid=true;
        		} else {
        			System.out.println("\n\tInvalid Password");
        		}
			}while(!Valid);
    		
    		// At this point, the password is valid.
			user.setPassword(temp_pw);
    		System.out.println("Hello "+user.ID+".\nValid Password.");
    		
    		System.out.println("\nMenu:\n\t"
    				+ "1.Set ID and Password.\n\t"
    				+ "0.Quit?");
    		choose=scan.nextInt();
    		if(choose==0) {
    			mark=false;
    			break;
    		}
    	}
		scan.close();
    }
}
/*
    @author: Zimu Jiao
    HW5-CS501
    12.13
    
    Write a program that will count the number of characters, words, and lines in a file.
    Words are separated by whitespace characters.
    The file name should be passed as a command-line argument,
*/
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

class File {
	String FileName;
	int Count_character=0;
	int Count_word=0;
	int Count_line=0;
	
	File(){
		this.FileName="test.txt";
	}
	
	File(String FileName){
		this.FileName=FileName;
	}
	
	public void setFileName(String name) {
		this.FileName=name;
	}
	
	public void ReadFile() throws Exception {
		JFileChooser chooser= new JFileChooser();
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			java.io.File file = chooser.getSelectedFile();
			
			Scanner read=new Scanner(file);
			do {
				this.Count_line++;
				String line=read.nextLine();
				this.Count_character+=line.length();
				for(String words: line.replaceAll("[^a-zA-Z]+"," ").split(" ")) {
					// Replace all non-alphabet with whitespace and count each last.
					this.Count_word++;
				}
			} while(read.hasNext());
			
			
			// Print the file's count.
			System.out.println("File:"+file);
			System.out.println("Line:"+this.Count_line);
			System.out.println("Character:(includ space)"+this.Count_character);
			System.out.println("Word:(not include number)"+this.Count_word);
			
			read.close();
			/* -To print the file content:
			 * Scanner input = new Scanner(file);
			
			while(input.hasNext()) {
				System.out.println(input.nextLine());
			}
			input.close();
			 */
		}else {
			System.out.println("NO FILE SELECTED");
		}
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		do{
			try {
				File F1=new File();
				F1.ReadFile();
			} catch (Exception e) {
				System.out.println("The file was not found.");
				//TODO Auto-generated catch block
				//e.printStackTrace();
			}
			System.out.print("Keep check(1) or Quit(0):");
			if(scan.nextInt()==0) {
				break;
			}
		}while(true);
		scan.close();
	}
}

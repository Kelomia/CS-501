import java.io.*;
import java.util.Scanner;
class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a point's x and y coordinates:");
		float x=scan.nextFloat();
		float y=scan.nextFloat();
		System.out.println("  X="+x+" Y="+y);
		if(((y+0.5*x)<=100.0)&& x>=0 && y>=0){
		    System.out.println("The point is in the triangle.");
		}else{
		    System.out.println("The point is not in the triangle.");
		}
	}
}

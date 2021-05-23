import java.io.*;
import java.util.Scanner;
class Equation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("For equation:\n\taX+bY=e cX+dY=f (type: float)\nPlease enter a,b,c,d,e,f:");
		float a= scan.nextFloat();
		float b= scan.nextFloat();
		float c= scan.nextFloat();
		float d= scan.nextFloat();
		float e= scan.nextFloat();
		float f= scan.nextFloat();
		if(a*d-b*c==0){
			System.out.println("The equation has no solution.");
		}else{
			float x=(e*d-b*f)/(a*d-b*c);
			float y=(a*f-e*c)/(a*d-b*c);
			System.out.println("The result of X and Y is:\n\tX= "+x+" Y= "+y);
		}
	}
}

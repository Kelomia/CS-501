// Test class for Triangle.

import java.util.Scanner;

public class TriangleTest{
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Color of the Triangle:");
		String color=scan.next();
		
		System.out.println("Filled Triangle:(true/false)");
		boolean filled=scan.nextBoolean();
		boolean flag=true;
		
		do{
			System.out.print("Input the sides of Triangle:");
			double side1=scan.nextDouble();
			double side2=scan.nextDouble();
			double side3=scan.nextDouble();
			
			try{
				Triangle triangle = new Triangle(side1,side2,side3);
				triangle.setColor(color);
				
				System.out.println(triangle.toString());
				System.out.println("Area:"+triangle.getArea());
				System.out.println("Perimeter:"+triangle.getPerimeter());
				System.out.println("Color:"+triangle.getColor());
				
				System.out.println("Triangle is Filled:"+triangle.isFilled());
			} catch(IllegalTriangleException e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("Re-input triangle:(YES-true/NO-false)");
			flag=scan.nextBoolean();
		}while(flag);
	}
}
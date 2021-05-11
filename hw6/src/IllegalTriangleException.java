/*
    @author: Zimu Jiao
    HW6-CS501
	
	11.1/12.5
	Check if the Triangle is valid, a+b>c.
    getArea()	getPerimeter()	toString()
	
	class IllegalTriangleException
*/
public class IllegalTriangleException extends Exception{
	private double side1,side2,side3;
	
	// Constructor:
	
	public IllegalTriangleException(double side1, double side2, double side3){
		super("Illegal Triangle:\n\tside1:"+ side1+"\n\tside2:"+side2+"\n\tside3:"+side3);
		   
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	
	// Getter methods:
	public double getS1(){
		return this.side1;
	}
	public double getS2(){
		return this.side2;
	}
	public double getS3(){
		return this.side3;
	}
	
	// Setter methods:
	public void setS1(double side1){
		this.side1=side1;
	}
	public void setS2(double side2){
		this.side2=side2;
	}
	public void setS3(double side3){
		this.side3=side3;
	}
}
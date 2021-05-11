/*
    @author: Zimu Jiao
    HW6-CS501
	
	11.1/12.5
	Check if the Triangle is valid, a+b>c.
    getArea()	getPerimeter()	toString()
	
	class IllegalTriangleException
*/
public class Triangle extends GeometricObject{
	double side1,side2,side3;
	
	// Constructor:
	public Triangle(){
		this.side1=1.0;
		this.side2=1.0;
		this.side3=1.0;
	}
	
	public Triangle(double side1,double side2,double side3) throws IllegalTriangleException{
		if(side1+side2 <= side3 || side1+side3 <= side2 || side2+side3 <= side1){
			throw new IllegalTriangleException(side1,side2,side3);			
		}
		   
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
	
	public double getArea(){
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	
	public double getPerimeter(){
		return this.side1+this.side2+this.side3;
	}
	
	public String toString(){
		return "Triangle:\n\tSide1="+this.side1+"\n\tSide2="+this.side2+"\n\tSide3="+this.side3;
	}
}
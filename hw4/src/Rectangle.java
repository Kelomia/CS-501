import java.util.Scanner;

/*
    @author: Zimu Jiao
    HW4-CS501
    9.1: Class Rectangle:
    Two double value of height and width, both set as 1;
    The constructor with height and width/ and non-arg constructor;
    Method of getPerimeter,getArea return perimeter and area of rectangle;
    9.5/9.11+9.12
*/
class Rectangle{
    double width;
    double height;

    public Rectangle(){
        this.width=1;
        this.height=1;
    }

    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }

    public boolean isValid(){
        if(this.height<0 || this.width<0)
            return false;
        else
            return true;
    }

    public void setWidth(double width){
        this.width=width;
    }
    public double getWidth(double width){
        return this.width;
    }

    public void setHeight(double height){
        this.height=height;
    }
    public double getHeight(double height){
        return this.height;
    }

    public double getArea(){
        return this.width*this.height;
    }

    public double getPerimeter(){
        return (this.width+this.height)*2;
    }
    public static void main(String[] args) {
        Rectangle rect1= new Rectangle(4,40);
        Rectangle rect2= new Rectangle(3.5,35.9);
        System.out.println("The area of Rectangle 1 is:"+rect1.getArea());
        System.out.println("The perimeter of Rectangle 1 is:"+rect1.getPerimeter());
        System.out.println("The area of Rectangle 2 is:"+rect2.getArea());
        System.out.println("The perimeter of Rectangle 2 is:"+rect2.getArea());

        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("Please input the width and height for your Rectangle:");
            double h,w;
            h=scan.nextDouble();
            w=scan.nextDouble();

            Rectangle myRect=new Rectangle(w,h);
            while(myRect.isValid()){
                System.out.println("Please input the width and height for your Rectangle:");
                w=scan.nextDouble();
                h=scan.nextDouble();
                myRect.setWidth(w);
                myRect.setHeight(h);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
	}
}
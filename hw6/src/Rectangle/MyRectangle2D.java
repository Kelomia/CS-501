/*
    @author: Zimu Jiao
    HW6-CS501
    
	10.13
    Check input if negative.
	Consist of 3 loops, outer one, middle one to enter base rectangle(may be combine this two), inner loop for test rectangles to be checked for all 
	four of inclusion, overlap, abutment and distincions to the base rectangle. It's possible more than one of these conditions exist.
	The program should be structered at the first, base rectangle once in every repear loop, not repeat entered again.
	Every time the new test rectangles the new shapes should be compared to the same base rectangle entered first.
	All 4 tests should be done automatically, don't ask user which tests to make.
	Few games ask the user if they should report these interactions. The program proceeds appropriately by showing their effects.
	
	11.1/12.5
	Check if the Triangle is valid, a+b>c.
    
*/
package Rectangle;

public class MyRectangle2D{
    double x;
    double y;
    double width;
    double height;

    // Constructor:
    public MyRectangle2D(double x,double y,double width,double height) throws Exception{
        if(width<=0 || height<=0){
            throw new Exception("Width or Height is not allow be negative.");
        }

        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public MyRectangle2D(){
        this.x=0;
        this.y=0;
        this.width=1;
        this.height=1;
    }

    //Setter and getter of X and Y
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }

    //Setter and getter of width and height
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }

    // getArea()
    public double getArea(){
        return width*height;
    }

    // getPerimeter
    public double getPerimeter(){
        return (width+height)*2;
    }

    // contains() methods:
    public boolean contains(double x, double y){
        if( x < this.x-this.width/2 || x > this.x+this.width/2 ||
                y < this.y-this.height/2 || y > this.y+this.height/2){
            return false;
        }
        return true;
    }

    public boolean contains(MyRectangle2D r){
        if( r.x < this.x-this.width/2 || r.x > this.x+this.width/2 ||
                r.y < this.y-this.height/2 || r.y > this.y+this.height/2){
            // Check if the r.center out of this rectangle.
            return false;
        } else if(r.x-r.width/2 < this.x-this.width/2 || r.x+r.width/2 > this.x+this.width/2 ||
                r.y-r.height/2 < this.y-this.height/2 || r.y+r.height/2 >this.y+this.height/2){
            // Check if overlap
            return false;
        }
        return true;
    }

    /*
    The four point (x,y) of rectangle is:
    AB	(x-width/2,y+heitht/2) (x+width/2,y+heitht/2)
    CD	(x-width/2,y-heitht/2) (x+width/2,y-heitht/2)
    */
    public boolean overlaps(MyRectangle2D r){
        if(!this.contains(r)){
            // if the rectangle is not in, when any point
            if(this.contains(r.x-r.width/2,r.y+r.height/2) || this.contains(r.x+r.width/2,r.y+r.height/2) ||
                    this.contains(r.x-r.width/2,r.y-r.height/2) || this.contains(r.x+r.width/2,r.y-r.height/2)){
                return true;
            }
        }
        return false;
    }

    public void printInfo(){
        System.out.println("Rectangle info:\n\tCenter("+x+","+y+")");
        System.out.println("\tWidth:"+width+" Height:"+height);
        System.out.println("\tArea:"+getArea()+" Perimeter:"+getPerimeter());
    }
}
/*
    @author: Zimu Jiao
    HW4-CS501
    9.11: Class named LinearEquation for a 2*2 system of linear equations:
    ax+by=e cx+dy=f    x=(ed-bf)/(ad-bc) y=(af-ec)/(ad-bc)
    Class contains: Private data fields: a,b,c,d,e,f
                    A constructor with arg:a,b,c,d,e,f
                    Six getter methods for a,b,c,d,e,f
                    A method named isSolvable() that return if ad-bc is not 0
                    Methods getX() and getY() that return the solution for the equation.
    9.12: Two line intersecting point, for line1 (x1,y1),(x2,y2) and line2 (x3,y3),(x4,y4),
          using the (y1-y2)x-(x1-x2)y=(y1-y2)x1-(x1-x2)y1 and (y3-y4)x-(x3-x4)y=(y3-y4)x3-(x3-x4)y3 from Exercise 3.25,
          combined with 9.11, set
                    a=y1-y2 ; b=-(x1-x2) , equal to x1+x2 ;
                    e=(y1-y2)x1-(x1-x2)y1, equal to x1y1-x1y2-x1y1+x2y1, as x2y1-x1y2
                    c=y3-y4 ; d=-(x3-x4) , equal to x3+x4 ;
                    f=(y3-y4)x3-(x3-x4)y3, equal to x3y3-x3y4-x3y3+x4y3, as x4y3-x3y4

*/
import java.util.Scanner;
class LinearEquation{
    //private data fields:
    private double a,b,c,d,e,f;

    public LinearEquation(){
        this.a=1;this.b=1;
        this.c=1;this.d=1;
        this.e=1;this.f=1;
    }
    //The constructor with arg:a,b,c,d,e,f;
    public LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
        this.f=f;
    }
    //The getter methods:
    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}
    public double getD(){return d;}
    public double getE(){return e;}
    public double getF(){return f;}
    //The set methods
    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }
    public void setC(double c){
        this.c=c;
    }
    public void setD(double d){
        this.d=d;
    }
    public void setE(double e){
        this.e=e;
    }
    public void setF(double f){
        this.f=f;
    }

    //Method isSolvable():
    public boolean isSolvable(){
        if((a*d-b*c)==0){
            return false;
        }else{
            return true;
        }
    }

    //Two getX/Y methods
    public double getX(){
        return (e*d-b*f)/(a*d-b*c);
    }

    public double getY(){
        return (a*f-e*c)/(a*d-b*c);
    }

    public static void main(String[] args) {

	    LinearEquation Equa= new LinearEquation(1,2,3,4,5,6);
	    // Set equation as (1,2,3,4,5,6);
	    System.out.println("a:"+Equa.a+"\nb:"+Equa.b+"\nc:"+Equa.c+"\nd:"+Equa.d+"\ne:"+Equa.e+"\nf:"+Equa.f);
	    // Show the equation;

        int flag=1; // Mark for LinearEquation or LinesIntersect;

        Scanner scan = new Scanner(System.in);

        // Let the user choose LinearEquation or LinesIntersect;
        System.out.println("Please choose:\n\t1.LinearEquation \n\t2.Two line intersecting");
        flag=scan.nextInt();
        while(flag>0){
            if(flag==1){
                System.out.println("\nPlease input the a,b,c,d,e,f for ax+by=e cx+dy=f\n"+
                "(Separate with space, value type:double):");
	    	    // Let user input arg: a,b,c,d,e,f;
	            double temp;
	            System.out.print("a = ");
	            Equa.setA(temp=scan.nextDouble());
	            System.out.print("b = ");
	            Equa.setB(temp=scan.nextDouble());
	            System.out.print("c = ");
	            Equa.setC(temp=scan.nextDouble());
	            System.out.print("d = ");
	            Equa.setD(temp=scan.nextDouble());
	            System.out.print("e = ");
	            Equa.setE(temp=scan.nextDouble());
	            System.out.print("f = ");
	            Equa.setF(temp=scan.nextDouble());
	        }else if(flag==2){
                System.out.println("Please input the two lines' points' information(x1,y1)(x2,y2) and (x3,y3)(x4,y4)");
                System.out.println("Separate by space");
                double x1,x2,x3,x4,y1,y2,y3,y4;
                System.out.print("x1 y1:");
                x1=scan.nextDouble();y1=scan.nextDouble();
                System.out.print("x2 y2:");
                x2=scan.nextDouble();y2=scan.nextDouble();
                System.out.print("x3 y3:");
                x3=scan.nextDouble();y3=scan.nextDouble();
                System.out.print("x4 y4:");
                x4=scan.nextDouble();y4=scan.nextDouble();

                // Get the a,b,c,d,e,f for lines' intersecting;
                Equa.setA(y1-y2);Equa.setB(x1+x2);Equa.setC(y3=y4);
                Equa.setD(x3+x4);Equa.setE(x2*y1-x1*y2);Equa.setF(x4*y3-x3*y4);
            }

                // If equation is solvable, show the solution, else tell not solvable;
            if(Equa.isSolvable()){
                 if(flag==1){
                    System.out.println("Equation is solvable, x="+Equa.getX()+" y="+Equa.getY());
                 }else{
                    System.out.println("The intersecting point is("+Equa.getX()+","+Equa.getY()+")");
                 }
            }else{
                if(flag==1){
                    System.out.println("Equation is not solvable.");
                }else{
                    System.out.println("Two lines do not intersect.");
                }
            }

                // Ask User if quit program.
	            System.out.println("Please choose:\n\t1. LinearEquation\n\t2. Two lines intersecting\n\t0. Quit");
	            flag=scan.nextInt();
	        }
	    }
}
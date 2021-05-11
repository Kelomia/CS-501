import java.util.Scanner;

public class Triangle {
    // Use method to calculate the length of lines:
    public static double distance(double x1,double y1,double x2,double y2){
        return Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double x1,x2,x3,y1,y2,y3;
        System.out.println("Please enter the coordinates of three points separated by spaces:");

        System.out.println("x1,y1:");
        x1= scan.nextDouble();
        y1= scan.nextDouble();
        System.out.println("x2,y2:");
        x2= scan.nextDouble();
        y2= scan.nextDouble();
        System.out.println("x3,y3:");
        x3= scan.nextDouble();
        y3= scan.nextDouble();

        double l1=distance(x1,y1,x2,y2);
        double l2=distance(x1,y1,x3,y3);
        double l3=distance(x2,y2,x3,y3);

        double s=(l1+l2+l3)/2;

        double area=Math.pow(s*(s-l1)*(s-l2)*(s-l3),0.5);

        System.out.println("The area of triangle is:"+area);
    }
}

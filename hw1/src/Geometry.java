import java.util.Scanner;

public class Geometry {
    public static void main(String[] args){
        double x1,x2,y1,y2;
        Scanner scan=new Scanner(System.in);
        System.out.println("Please input the x1,y1 and x2,y2:");
        System.out.println("x1,y1:");
        x1=scan.nextDouble();
        y1=scan.nextDouble();
        System.out.println("x2,y2:");
        x2=scan.nextDouble();
        y2=scan.nextDouble();

        System.out.println("The distance between the two points is:"+Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5));
    }
}

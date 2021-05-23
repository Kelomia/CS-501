// Test class for MyRectangle.
package Rectangle;
import java.util.Scanner;

public class RectangleTest{

    public static void main(String[] args){
        // Outer-Loop:
        Scanner scan =new Scanner(System.in);
        double x,y;
        double width,height;

        boolean flag=true;

        do{
            System.out.println("Input the center(x,y):");
            x=scan.nextDouble();
            y=scan.nextDouble();
            System.out.println("Input the width and height:");
            width=scan.nextDouble();
            height=scan.nextDouble();

            MyRectangle2D myRect;
            try{
                myRect = new MyRectangle2D(x,y,width,height);
            } catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            // Print the value of myRectangle.
            /*
            System.out.println("myRectangle info:\nCenter("+myRect.x+","+myRect.y+")");
            System.out.println("\nWidth:"+myRect.width+" Height:"+myRect.height);
            System.out.println("\nArea:"+myRect.getArea()+" Perimeter:"+myRect.getPerimeter());
            */
            myRect.printInfo();

            boolean changeInfo=true;
            do{// Inner-Loop
                System.out.println("Input the center(x,y):");
                x=scan.nextDouble();
                y=scan.nextDouble();
                System.out.println("Input the width and height:");
                width=scan.nextDouble();
                height=scan.nextDouble();

                MyRectangle2D testRect;
                try{
                     testRect = new MyRectangle2D(x, y, width, height);
                } catch(Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }
                // Print test-Rectangle info:
                /*
                System.out.println("test-Rectangle info:\nCenter("+testRect.x+","+testRect.y+")");
                System.out.println("\nWidth:"+testRect.width+" Height:"+testRect.height);
                System.out.println("\nArea:"+testRect.getArea()+" Perimeter:"+testRect.getPerimeter());
                */
                testRect.printInfo();

                // Print methods' result:
                System.out.println("\n\ttest-Rectangle center in myRectangle:"+myRect.contains(testRect.x,testRect.y));
                System.out.println("\tmyRectangle contains test-Rectangle:"+myRect.contains(testRect));
                System.out.println("\tmyRectangle overlap test-Rectangle:"+myRect.overlaps(testRect));

                System.out.println("Change the base-rectangle value: Yes-true/No-false");
                changeInfo=scan.nextBoolean();
            }while(!changeInfo);

            System.out.println("Exit? Yes-true/No-false");
            flag=scan.nextBoolean();
        }while(!flag);
    }
}
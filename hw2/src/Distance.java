import java.io.*;
import java.util.Scanner;
class Distance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the points' latitude and longitude(x and y):\n\t Point1: ");
		double x1=scan.nextDouble();
		double y1=scan.nextDouble();
		System.out.print("\t Point2: ");
		double x2=scan.nextDouble();
		double y2=scan.nextDouble();
		System.out.println("the point-1 x and y is:"+x1+' '+y1);
		System.out.println("the point-2 x and y is:"+x2+' '+y2);
		final double RADIUS=6371.01;
		x1 = Math.toRadians(x1);
		y1 = Math.toRadians(y1);
		x2 = Math.toRadians(x2);
		y2 = Math.toRadians(y2);
		double distance=RADIUS*Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
		System.out.println("The distance between the two points is "+distance+" km");
	}
}

import java.io.*;
import java.util.Scanner;
class Area {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double Ax=33.74,Ay=84.38,
		        Ox=28.53,Oy=81.37,
		        Sx=32.08,Sy=81.09,
		        Cx=35.22,Cy=80.84;
		final double RADIUS=6371.01;
		System.out.println("Citys' latitude and longitude are:");
		System.out.println("\tAtlanta:\n\t"+Ax+", "+Ay);
		System.out.println("\tOrlando:\n\t"+Ox+", "+Oy);
		System.out.println("\tSavannah:\n\t"+Sx+", "+Sy);
		System.out.println("\tCharlotte:\n\t"+Cx+", "+Cy);

		Ax = Math.toRadians(Ax); Ay = Math.toRadians(Ay);
		Ox = Math.toRadians(Ox); Oy = Math.toRadians(Oy);
		Sx = Math.toRadians(Sx); Sy = Math.toRadians(Sy);
		Cx = Math.toRadians(Cx); Cy = Math.toRadians(Cy);
		//culculate the length of sides of Triangle ASO and ASC
		double d_AC=RADIUS*Math.acos(Math.sin(Ax)*Math.sin(Cx)+Math.cos(Ax)*Math.cos(Cx)*Math.cos(Ay-Cy));
		double d_AO=RADIUS*Math.acos(Math.sin(Ax)*Math.sin(Ox)+Math.cos(Ax)*Math.cos(Ox)*Math.cos(Ay-Oy));
		double d_SO=RADIUS*Math.acos(Math.sin(Sx)*Math.sin(Ox)+Math.cos(Sx)*Math.cos(Ox)*Math.cos(Sy-Oy));
		double d_SC=RADIUS*Math.acos(Math.sin(Sx)*Math.sin(Cx)+Math.cos(Sx)*Math.cos(Cx)*Math.cos(Sy-Cy));
		double d_AS=RADIUS*Math.acos(Math.sin(Ax)*Math.sin(Sx)+Math.cos(Ax)*Math.cos(Sx)*Math.cos(Ay-Sy));

		System.out.println("The distance between Atlanta and Orlando is: "+d_AO);
		System.out.println("The distance between Atlanta and Savannah is: "+d_AS);
		System.out.println("The distance between Savannah and Charlotte is: "+d_SC);
		System.out.println("The distance between Atlanta and Charlotte is: "+d_AC);
		System.out.println("The distance between Savannah and Orlando is: "+d_SO);


		double s_ASO=(d_AS+d_AO+d_SO)/2.0;
		double s_ASC=(d_AS+d_SC+d_AC)/2.0;
		double area_ASO=Math.sqrt(s_ASO*(s_ASO-d_AS)*(s_ASO-d_AO)*(s_ASO-d_SO));
		double area_ASC=Math.sqrt(s_ASC*(s_ASC-d_AS)*(s_ASC-d_AC)*(s_ASC-d_SC));

		double area=area_ASO+area_ASC;
		System.out.println("The areas A-S-O and A-S-C are: \n\t"+area_ASO+" km^2, "+area_ASC+" km^2");
		System.out.println("The area is: "+area+" km^2");
	}
}

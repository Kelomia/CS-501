/*
    @author: Zimu Jiao
    HW4-CS501
    9.5: Calendar: Using java.util.GregorianCalendar to show the current time(year,month and day), then show the elapsed
    time since 1970/1/1 to 1234567898764L;
*/
import java.util.GregorianCalendar;
class Calendar{

    public static void main(String[] args) {
        // Create a object
        GregorianCalendar calendar = new GregorianCalendar();

        System.out.println("Current Year/Month/Day:");
	    System.out.println("\t"+calendar.get(calendar.YEAR)+"/"+calendar.get(calendar.MONTH)+
	                       "/"+calendar.get(calendar.DAY_OF_MONTH));

        // Set elapsed time since 1970, January 1 to 1234567898765L;
	    calendar.setTimeInMillis(1234567898765L);
	    System.out.println("Elapsed time since January 1, 1970 to 1234567898764L in format Year/Month/Day");
	    System.out.println("\t"+calendar.get(calendar.YEAR)+"/"+calendar.get(calendar.MONTH)+
	                       "/"+calendar.get(calendar.DAY_OF_MONTH));
	}
}
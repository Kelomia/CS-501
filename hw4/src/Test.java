/*
    @author: Zimu Jiao
    HW4-CS501
    The test class
*/

import java.lang.reflect.Method;

class    test{
    public static void main(String[] args) {
        System.out.println("Here is test.class");
        String idStr="Test";
        Method method;
        try{
            System.out.println("Here begin the Calendar test:");
            method=Calendar.class.getMethod("main",String[].class);
            method.invoke(Calendar.class.newInstance(),new Object[]{new String[]{idStr}});
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println("\nHere begin the Rectangle test:");
            method = Rectangle.class.getMethod("main", String[].class);
            method.invoke(Rectangle.class.newInstance(), new Object[]{new String[]{idStr}});
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            System.out.println("\nHere begin the LinearEquation test:");
            method = LinearEquation.class.getMethod("main", String[].class);
            method.invoke(LinearEquation.class.newInstance(), new Object[]{new String[]{idStr}});
        }catch(Exception e){
            e.printStackTrace();
        }


	}
}
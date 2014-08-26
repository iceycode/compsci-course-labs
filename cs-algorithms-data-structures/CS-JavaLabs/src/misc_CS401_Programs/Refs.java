package misc_CS401_Programs;
/*
 * This program shows that Java is a pass-by-value language.
 * When one passes reference, passing content of memory 
 * 
 */


public class Refs  {
	
   public static void main(String[] args)  {
      MyPoint p1 = new MyPoint(10, 10);
      MyPoint p2 = new MyPoint(20, 20);

      System.out.println("Before swap() p1 is " + p1 + ", and p2 is " + p2);
      swap(p1, p2);
      System.out.println("After swap() p1 is " + p1 + ", and p2 is " + p2);
      System.out.println("----------------------------------------------");

      System.out.println("Before change_1(), p1 is " + p1);
      change_1(p1);
      //after return from change_1 class, turns back to 10,10
      System.out.println("After change_1(), p1 is " + p1);
      System.out.println("----------------------------------------------");
      
      System.out.println("Before change_2(), p1 is " + p1);
      change_2(p1);
      //after change_2, it stays at 100, 100 - this is b/c 
      System.out.println("After change_2(), p1 is " + p1);
      System.out.println("----------------------------------------------");
 
      return;
   }

   public static void swap (MyPoint arg1, MyPoint arg2)  {
      MyPoint temp;

      temp = arg1;
      arg1 = arg2;
      arg2 = temp;

      System.out.println("In swap() p1 is " + arg1 + ", and p2 is " + arg2);
   }

   public static void change_1(MyPoint arg1)  {
	  //arg1 = p1 = (10,10)
      arg1 = new MyPoint(100, 100); 
      System.out.println("In change_1() p1 is " + arg1);
      
   }

   public static void change_2(MyPoint arg1)  {
	   //turns x & y, turns into 100, 100
      arg1.x = 100;		//these values are actually changed throughout the entire program
      arg1.y = 100;
      System.out.println("In change_1() p1 is " + arg1);
      //changes get reflected in the main function
   }
}

/*
 * class that has 2 integers
 */
class MyPoint  {
      public Integer x, y;

      public MyPoint(Integer arg_x, Integer arg_y)  {
         x = arg_x;
         y = arg_y;
      }

      public String toString()  {

         return "MyPoint[x=" + x + ",y=" + y + "]";
      }
}


package chapter07.SinglyLinked.SinglyLinked;

import java.util.*;

public class SLL
{
   public static void main (String[] args)
   {
      new SLL().run();
   } // method main
   
   public void run()
   {
      SinglyLinkedList myLinked = new SinglyLinkedList();
      
      myLinked.addToFront ("about");
      myLinked.addToFront ("away");
      myLinked.addToFront ("avast");
      myLinked.addToFront ("axed");

      String s;

      Iterator<String> itr = myLinked.iterator( );

      while (itr.hasNext( )) 
      {
          s = (String)itr.next();
          if (s.length( ) == 4)
              System.out.println (s);
      } // while
  } // method run
   
} // class SLL

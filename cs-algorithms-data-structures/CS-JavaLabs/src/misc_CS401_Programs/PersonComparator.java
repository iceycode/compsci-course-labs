package misc_CS401_Programs;
import java.util.Comparator;

/*
 * This is an example of using the third option we discussed in class
 * during the lecture --- the Comparator interface (see
 * http://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html
 *
 * Here, the class that does the comparison is separate from the 
 * class whose objects are compared.  See example below.
 *
 * One reason that the Comparator interface is used is if you do not
 * have the source code to a class whose objects you want to compare
 * a bit differently than the comparison provided by the provider of
 * that class (makes sense?)
 */

public class PersonComparator implements Comparator
{
   public int compare(Object a1, Object a2)
   {
      Person a = (Person) a1; //cast objects as type person
      Person b = (Person) a2;

      int r1;

      r1 = a.name.compareTo(b.name);
      
      //comparing the ages
      if (r1 == 0) /* Names are the same, check ages */
      {
         if (a.age > b.age) 
            r1 = 1;
         else if (a.age < b.age)
            r1 = -1;
         else
            r1 = 0;
      }

      return r1;
   }

   public boolean equals(Object o)
   {
      return false; /* For the sake of completeness since Comparator also
                       provides a signature for the equals() method. */
   }

  public static void main(String args[])
  {
     Person a = new Person("Mickey Mouse", 20),
            b = new Person("Mickey Mouse", 20);

     System.out.println("(" + a + ") == (" + b + ")? " +
                        new PersonComparator().compare(a,b));

     a = new Person("Zickey Mouse", 20);
     System.out.println("(" + a + ") == (" + b + ")? " +
                        new PersonComparator().compare(a,b));

     a = new Person("Mickey Mouse", 23);
     System.out.println("(" + a + ") == (" + b + ")? " +
                        new PersonComparator().compare(a,b));

     a = new Person("Aickey Mouse", 20);
     System.out.println("(" + a + ") == (" + b + ")? " +
                        new PersonComparator().compare(a,b));

     return;
  }
}


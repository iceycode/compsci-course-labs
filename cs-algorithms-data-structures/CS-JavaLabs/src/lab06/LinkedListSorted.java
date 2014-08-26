package lab06;

import java.util.Iterator;

public class LinkedListSorted
{
   public static void main(String[] args)
   {
      LinkedListImpl<Chores> 
                    chores_list = new LinkedListImpl<Chores>();

      Chores a = new Chores("Make Bed", 10);
      Chores b = new Chores("Do Laundry", 5);
      Chores c = new Chores("Take out garbage", 20);
      Chores d = new Chores("Clean car", 18);
      Chores e = new Chores("Excercise", 70);
      Chores f = new Chores("Sleep", 50);

      chores_list.add_sorted(a); 
      chores_list.add_sorted(b); 
      chores_list.add_sorted(c); 
      chores_list.add_sorted(d);
      chores_list.add_sorted(e); 
      chores_list.add_sorted(f);

      System.out.println("There are " + chores_list.size() +
                         " elements on the chores list!");

      System.out.println("These are: ");
      Iterator<Chores> itr = chores_list.iterator();
      while (itr.hasNext())
          System.out.println(itr.next());
   }
}

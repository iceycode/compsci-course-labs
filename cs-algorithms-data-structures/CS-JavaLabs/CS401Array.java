public class CS401Array
{
   public static void main(String[] args)
   {
      CS401ArrayImpl<String> chores = new CS401ArrayImpl<String>();

      chores.add("Make Bed");
      chores.add("Do Laundry");
      chores.add("Take out the garbage");

      System.out.println("There are " + chores.size() + " chores to do today!");
      System.out.println("These are: ");
      for (int i = 0; i < chores.size(); i++)
      {
         String s = chores.get(i);
         System.out.println("  " + (i+1) + " " + s);
      }

      chores.remove(0);

      System.out.println("There are now " + chores.size() + 
                         " chores left to do today!");
      System.out.println("These are: ");
      for (int i = 0; i < chores.size(); i++)
      {
         String s = chores.get(i);
         System.out.println("  " + (i+1) + " " + s);
      }
   }
}

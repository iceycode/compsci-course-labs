import java.util.*;

public class ByName implements Comparator<Student>
{
    public int compare (Student stu1, Student stu2)
    {
        String name1 = new Scanner (stu1.toString()).next(),
               name2 = new Scanner (stu2.toString()).next();
        
        return name1.compareTo (name2);
    } // method compare
    
} // class ByName
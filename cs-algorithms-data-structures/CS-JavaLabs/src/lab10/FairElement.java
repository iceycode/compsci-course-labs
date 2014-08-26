package lab10;

public class FairElement<E> 
{  
  protected E element;
  
  long count;
  
  public FairElement (E element, long count)  {  
    this.element = element;
    this.count = count;    
  } // constructor
    
} // class FairElement

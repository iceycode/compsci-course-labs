package lab07;

/** QueueInterface.java
 * - interface methods used in Queue data structures
 * 
 * @author Allen
 *
 * @param <E>
 */

public interface QueueInterface<E>  {

	public void add(E element);
   
   
   public E remove();
   
   
   public E peek();
   
   
   public boolean is_empty();
   
   
   public boolean is_full();
}

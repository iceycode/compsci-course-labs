package queues;

public interface CS401QueueInterface<E>  {
   public void add(E element);
   public E remove();
   public E peek();
   public boolean is_empty();
   public boolean is_full();
}

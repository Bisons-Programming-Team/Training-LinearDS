import java.util.*;

public class Solution
{
  static final int LENGTH = 50000;
  
  public static void main(String[] args)
  {
    LinkedList<Integer> ll = new LinkedList<>();
    ArrayList<Integer> al = new ArrayList<>();
    
    for (int i = 0; i < LENGTH; i++)
    {
      ll.add(i);
      al.add(i);
    }
    
    long start = System.currentTimeMillis();
    // delete every second item in the linked list
    for (int i = 0; i < ll.size(); i++)
    {
      ll.remove(i);
    }
    long finish = System.currentTimeMillis();
    System.out.println("Linked list without iterators: " + (finish - start) + "ms");
    System.out.println("New length: " + ll.size());
    
    ll = new LinkedList<>();
    for (int i = 0; i < LENGTH; i++)
    {
      ll.add(i);
    }
    
    start = System.currentTimeMillis();
    // delete every second item in the linked list
    ListIterator<Integer> listIt = ll.listIterator();
    boolean skip = false;
    while (listIt.hasNext())
    {
      listIt.next();
      if (!skip)
      {
        listIt.remove();
      }
      skip = !skip;
    }
    finish = System.currentTimeMillis();
    System.out.println("Linked list with iterators: " + (finish - start) + "ms");
    System.out.println("New length: " + ll.size());
    
    start = System.currentTimeMillis();
    // delete every second item in the array list
    for (int i = 0; i < al.size(); i++)
    {
      al.remove(i);
    }
    finish = System.currentTimeMillis();
    System.out.println("Dynamic array time: " + (finish - start) + "ms");
    System.out.println("New length: " + al.size());
  }
}
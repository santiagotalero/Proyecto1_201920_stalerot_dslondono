package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;


public interface ILinkedQueue<Item>  
{
	 boolean isEmpty();

    int size();

    Item peek();

    void agregar(Item item);

    Item eliminar();

    String toString();
   
    boolean check(); 

    Iterator<Item> iterator(); 

}

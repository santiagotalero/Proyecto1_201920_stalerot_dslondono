package model.data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedQueue<Item> implements ILinkedQueue,Iterable<Item> 
{
	/*
	*
	*	Numero de elementos en la lista
	*/
    private int n;     

     /*
	*	Primer nodo de la lista
	*/   
    private Node primero;  

    /*
	*	Ultimo nodo de la lista
	*/  
    private Node ultimo;     

    /*
	*	Metodo constructor privado de la clase Node
	*/
    private class Node 
    {
        private Item item;

        private Node siguiente;
    }

    /**
     * Inicializa una LinkedList Vacía
     */
    public LinkedQueue() 
    {
        primero = null;
        ultimo  = null;
        n = 0;
        assert check();
    }

    /**
     * Metodo para ver si la lista está vacía
     * @return true si está vacía
     */
    public boolean isEmpty() 
    {
        return primero == null;
    }

    /**
     * Retorna el numero de elementos en la LinkedList
     * @return el numero de items en la LinkedList
     */
    public int size() 
    {
        return n;     
    }

    /**
     * Retorna el elemento agregado más viejo
     * @return El elemento agregado más viejo
     * @throws java.util.NoSuchElementException si el queue está vacío
     */
    public Item peek() 
    {
        if (isEmpty()) throw new NoSuchElementException("Desbordamiento de Queue");
        return primero.item;
    }

    /**
     * Agrega un elemento al queue
     * @param item item a agregar
     */
    public void agregar(Object item) 
    {
        Node pUltimo = ultimo;
        ultimo = new Node();
        ultimo.item = (Item)item;
        ultimo.siguiente = null;
        if (isEmpty()) primero = ultimo;
        else           pUltimo.siguiente = ultimo;
        n++;
        assert check();
    }

    /**
     * Elimina y retorna el item en esta queue que fue el ultimo agregado.
     * @return El elemento en esta queue que fue el ultimo agregado
     * @throws java.util.NoSuchElementException si el queue esta vacio
     */
    public Item eliminar() 
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = primero.item;
        primero = primero.siguiente;
        n--;
        if (isEmpty()) ultimo = null;   
        assert check();
        return item;
    }

    /**
     * Returns a string representation of this queue.
     * @return the sequence of items in FIFO order, separated by spaces
     */
    //METODO TO STRING
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 

    // check internal invariants
    public boolean check() 
    {
        if (n < 0) {
            return false;
        }
        else if (n == 0) {
            if (primero != null) return false;
            if (ultimo  != null) return false;
        }
        else if (n == 1) {
            if (primero == null || ultimo == null) return false;
            if (primero != ultimo)                 return false;
            if (primero.siguiente != null)            return false;
        }
        else {
            if (primero == null || ultimo == null) return false;
            if (primero == ultimo)      return false;
            if (primero.siguiente == null) return false;
            if (ultimo.siguiente  != null) return false;

            // check internal consistency of instance variable n
            int numberOfNodes = 0;
            for (Node x = primero; x != null && numberOfNodes <= n; x = x.siguiente) {
                numberOfNodes++;
            }
            if (numberOfNodes != n) return false;

            // check internal consistency of instance variable last
            Node lastNode = primero;
            while (lastNode.siguiente != null) {
                lastNode = lastNode.siguiente;
            }
            if (ultimo != lastNode) return false;
        }

        return true;
    } 
 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  
    {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    //Clase Iterator
    private class ListIterator implements Iterator<Item> {
        private Node current = primero;

        public boolean hasNext()  { return current != null;                     }


        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.siguiente; 
            return item;
        }
    }
    
    public Item bottom()
    {
    	Item x = (Item) new Node();
    	
    	return x;
    }


}

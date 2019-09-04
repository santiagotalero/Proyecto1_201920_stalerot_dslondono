package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.LinkedQueue;

public class TestLinkedQueue 
{
	
	private LinkedQueue lista;
	private static int tamano=100;
	
	@Before
	public void setup1()
	{
		lista= new LinkedQueue();
	}
	
	public void setup2()
	{
		for(int i =0; i< tamano; i++)
		{
			lista.agregar(i);
		}
	}
	
	@Test
	public void testLinkedQueue() 
	{
		assertTrue(lista!=null);
		
		setup2();
		assertEquals(100, lista.size());
	}
	
	@Test
	public void testIsEmpty()
	{
		assertTrue(lista.isEmpty());
		
		setup2();
		assertFalse(lista.isEmpty());
	}
	
	@Test
	public void testPeek()
	{
		setup2();
		assertEquals(0, lista.peek());
	}
	
	@Test
	public void testBottom()
	{
		setup2();
		assertEquals(99, lista.bottom());
	}
	
	@Test
	public void testAgregar()
	{
		lista.agregar("prueba");
		assertEquals("prueba", lista.bottom());
	}
	
	@Test
	public void testEliminar()
	{
		lista.agregar("prueba");
		int t=lista.size();
		Object i=lista.eliminar();
		assertEquals("prueba", i);
		assertEquals(lista.size(),t-1);
	}


}

package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.opencsv.CSVReader;

import model.data_structures.ILinkedQueue;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.LinkedQueue;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	
	//CONSTANTES QUE REPRESENTAN CADA ESTRUCTURA DE DATOS
	
	private final static int LISTA_HORA=1;
	private final static int PILA_MES=2;
	private final static int COLA_DIA=3;
	
	
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedQueue listaHora;
	private Stack pilaMes;
	private Queue colaDia;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		listaHora = new LinkedQueue();
		pilaMes= new Stack();
		colaDia= new Queue();
	}


	//ALGORITMOS DE ORDENAMIENTO
	
	public void ordenarAscendentemente(int tipoEstructura)
	{
		
	}
	
	public void ordenarDescendentemente(int tipoEstructura)
	{
		
	}
	
	
	//METODOS PARA USAR EN CARGA DE ARCHIVO
	
	public Stack viajesMes()
	{
		return pilaMes;
	}
	


	public LinkedQueue viajesHora()
	{
		return listaHora;
	}
	


	public Queue viajesDia()
	{
		return colaDia;
	}
	
	public int zonaMenor()
	{
		int id=100000000;
		
		Iterator iter1= listaHora.iterator();
		while(iter1.hasNext())
		{
			Viaje actual= (Viaje)iter1.next();
			
			if(actual.getSourceID()<actual.getDstID())
			{
				if(actual.getSourceID()<id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()<id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		Iterator iter2= pilaMes.iterator();
		while(iter2.hasNext())
		{
			Viaje actual= (Viaje)iter2.next();
			
			if(actual.getSourceID()<actual.getDstID())
			{
				if(actual.getSourceID()<id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()<id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		Iterator iter3= colaDia.iterator();
		while(iter3.hasNext())
		{
			Viaje actual= (Viaje)iter3.next();
			
			if(actual.getSourceID()<actual.getDstID())
			{
				if(actual.getSourceID()<id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()<id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		return id;
	}
	
	public int zonaMayor()
	{
		int id=0;
		
		Iterator iter1= listaHora.iterator();
		while(iter1.hasNext())
		{
			Viaje actual= (Viaje)iter1.next();
			
			if(actual.getSourceID()>actual.getDstID())
			{
				if(actual.getSourceID()>id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()>id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		Iterator iter2= pilaMes.iterator();
		while(iter2.hasNext())
		{
			Viaje actual= (Viaje)iter2.next();
			
			if(actual.getSourceID()>actual.getDstID())
			{
				if(actual.getSourceID()>id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()>id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		Iterator iter3= colaDia.iterator();
		while(iter3.hasNext())
		{
			Viaje actual= (Viaje)iter3.next();
			
			if(actual.getSourceID()>actual.getDstID())
			{
				if(actual.getSourceID()>id)
				{
					id= actual.getSourceID();
				}
				
			}
			else
			{
				if(actual.getDstID()>id)
				{
					id= actual.getDstID();
				}
			}
		}
		
		return id;
	}
	

	//CARGAR ARCHIVOS
	public void cargarArchivo(int trimestre) throws IOException
	{
		CSVReader reader = null;
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+trimestre+"-All-HourlyAggregate.csv"));

			
			reader.readNext();

			for(String[] nextLine : reader)
			{
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				listaHora.agregar(actual);
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+trimestre+"-All-MonthlyAggregate.csv"));

			
			reader.readNext();

			for(String[] nextLine : reader)
			{
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				pilaMes.push(actual);
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+trimestre+"-WeeklyAggregate.csv"));

			
			reader.readNext();

			
			for(String[] nextLine : reader)
			{
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				colaDia.enqueue(actual);
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	
	
	
	//REQUERIMIENTOS PARTE A
	
	public double[] req1A(int origen, int destino ,int mes)
	{
		double [] stats= new double[2];
		
		//Implementar
		
		return stats;
	}
	

	public Stack  req2A(int n, int mes)
	{
		Stack aux= new Stack();
		
		return aux;
	}


	public Stack req3A(int mes, int zona, int zonaMayor, int zonaMenor)
	{
		Stack aux= new Stack();
		
		return aux;
	}

	//REQUERIMIENTOS PARTE B

	public double[] req1B(int origen, int destino, int dia)
	{
		double [] stats= new double[2];

		//Implementar

		return stats;
	}

	public Queue  req2B(int n, int dia)
	{
		Queue aux= new Queue();
		
		return aux;
	}

	public Queue req3B(int dia, int zona, int zonaMayor, int zonaMenor)
	{
		Queue aux= new Queue();
		
		return aux;
	}
	
	
	//REQUERIMIENTOS PARTE C
	
	public LinkedQueue req1C(int horaInicial, int horaFinal)
	{
		LinkedQueue aux= new LinkedQueue();
		
		return aux;
	}
	

	public LinkedQueue req2C(int n, int hora)
	{
		LinkedQueue aux= new LinkedQueue();
		
		return aux;
	}
	
	public LinkedQueue req3C(int zonaOrigen, int zonaDestino)
	{
		LinkedQueue aux= new LinkedQueue();
		
		return aux;
	}

}

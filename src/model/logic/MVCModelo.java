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
	private final static int LISTA_MES=2;
	private final static int COLA_DIA=3;
	
	
	/**
	 * Atributos del modelo del mundo
	 */
	private LinkedQueue listaHora;
	private LinkedQueue listaMes;
	private LinkedQueue listaDia;
	
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		listaHora = new LinkedQueue();
		listaMes= new LinkedQueue();
		listaDia= new LinkedQueue();
		
	}


	//ALGORITMOS DE ORDENAMIENTO
	
	
	
	public double[] darArregloTiempoPromedio() 
	{
		double[] x = new double[listaMes.size()];
		Iterator iter = listaMes.iterator();
		int i = 0; 
		while( iter.hasNext()) 
		{
			Viaje actual = (Viaje) iter.next();
			double tiempo = actual.getMeanTravelTime();
			x[i] = tiempo; 
			i++; 
		}
		
		return x; 
	}
	
	public int[] darArregloZonaOrigen() 
	{
		int[] x = new int[listaMes.size()];
		Iterator iter = listaMes.iterator();
		int i = 0; 
		while( iter.hasNext()) 
		{
			Viaje actual = (Viaje) iter.next();
			int zonaOrigen = actual.getSourceID();
			x[i] = zonaOrigen; 
			i++; 
		}
		
		return x; 
	}
	
	
	public int[] darArregloZonaDestino() 
	{
		int[] x = new int[listaMes.size()];
		Iterator iter = listaMes.iterator();
		int i = 0; 
		while( iter.hasNext()) 
		{
			Viaje actual = (Viaje)listaMes.iterator();
			int zonaDestino = actual.getDstID();
			x[i] = zonaDestino;
			i++;
		}
		
		return x; 
	}
	
	//Quicksort ascendentemente
	public static void quicksort( int[] array) 
	{
		quicksort(array, 0, array.length -1 );
	}
	
	public static void quicksort(int[] array, int left, int right) 
	{
		if( left >= right) 
		{
			return; 
		}
		
		int pivot = array[(left+right)/2];
		int index = partition(array,left,right,pivot);
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
	}
	
	public static int partition( int[] array, int left, int right, int pivot ) 
	{
		while( left <= right ) 
		{
			while( array[left] < pivot ) 
			{
				left++;
			}
			
			while( array[right] > pivot) 
			{
				right--; 
			}
			
			if( left <= right ) 
			{
				swap(array, left, right);
				left++;
				right--;
			}
		}
		
		return left; 
	}
	


	public void ordenarAscendentementePorHora(int listaHora2) {
		// TODO Auto-generated method stub
		
	}



	public static void swap(int[] array, int left, int right) 
	{
	
	/////Implementar	
		
	}
	
	
	//Quicksort para ordenamiento descendente
	
	public static void quicksortDes( int[] array) 
	{
		quicksort(array, 0, array.length -1 );
	}
	
	public static void quicksortDes(int[] array, int left, int right) 
	{
		if( right >= left) 
		{
			return; 
		}
		
		int pivot = array[(left+right)/2];
		int index = partitionDes(array,right,left,pivot);
		quicksortDes(array, right, index - 1);
		quicksortDes(array, index, left);
	}
	
	
	public static int partitionDes( int[] array, int left, int right, int pivot ) 
	{
		while( right <= left ) 
		{
			while( array[right] < pivot ) 
			{
				right++;
			}
			
			while( array[left] > pivot) 
			{
				left--; 
			}
			
			if( right <= left ) 
			{
				swap(array, left, right);
				right++;
				left--;
			}
		}
		
		return right; 
	}

	
	
	
	//METODOS PARA USAR EN CARGA DE ARCHIVO
	
	public LinkedQueue viajesMes()
	{
		return listaMes;
	}
	


	public LinkedQueue viajesHora()
	{
		return listaHora;
	}
	


	public LinkedQueue viajesDia()
	{
		return listaDia;
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
		
		Iterator iter2= listaMes.iterator();
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
		
		Iterator iter3= listaDia.iterator();
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
		
		Iterator iter2= listaMes.iterator();
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
		
		Iterator iter3= listaDia.iterator();
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

			//for(String[] nextLine : reader)
			{
				//Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				//listaHora.agregar(actual);
			}
			int i=1;
			while(i<40)
			{
				String [] nextLine= reader.readNext();
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				listaHora.agregar(actual);
				i++;
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

			//for(String[] nextLine : reader)
			{
				//Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				//listaMes.agregar(actual);
			}
			int i=1;
			while(i<40)
			{
				String [] nextLine= reader.readNext();
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				listaMes.agregar(actual);
				i++;
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

			
			//for(String[] nextLine : reader)
			{
				//Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				//colaDia.enqueue(actual);
			}
			int i=1;
			while(i<40)
			{
				String [] nextLine= reader.readNext();
				Viaje actual= new Viaje(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));
				listaDia.agregar(actual);
				i++;
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
	
	public LinkedQueue req1A(int origen, int destino ,int mes)
	{
		
		LinkedQueue auxCumplen= new LinkedQueue();
		
		Iterator iter= listaMes.iterator();
		
		while(iter.hasNext())
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getSourceID()==origen && actual.getDstID()==destino && actual.getIdentificador()==mes)
			{
				auxCumplen.agregar(actual);
			}	
		}
		
			return auxCumplen;
	}
	


	public LinkedQueue req2A(int n, int mes)
	{
		LinkedQueue aux= new LinkedQueue();
		
		this.ordenarDescendentementPorTiempoPromedio(LISTA_MES);
		
		Iterator iter=listaMes.iterator();
		
		while(iter.hasNext() && n>0)
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getIdentificador()==mes)
			{
				aux.agregar(actual);
				n--;
			}
			
		}
		
		
		return aux;
	}


	private void ordenarDescendentementPorTiempoPromedio(int listaMes2) {
		// TODO Auto-generated method stub
		
	}


	public Object[] req3A(int mes, int zona, int zonaMayor, int zonaMenor)
	{
		Object[] arreglos= new Object[2];
		
		int rango= zonaMayor-zonaMenor+1;
		double[] opcionA= new double[rango];
		double[]opcionB=new double[rango];
		int i=0;
		int j=0;
		
		while(zonaMenor<=zonaMayor)
		{
			Viaje v1= buscarViajePila(mes, zona, zonaMenor);
			if(v1!=null)
			{
				opcionA[i]=v1.getMeanTravelTime();
				i++;
			}
			else
			{
				opcionA[i]=-1;
				i++;
			}
			
			Viaje v2= buscarViajePila(mes, zonaMenor, zona);
			
			if(v2!=null)
			{
				opcionB[j]=v2.getMeanTravelTime();
				j++;
			}
			else
			{
				opcionB[j]=-1;
				j++;
			}
			
			zonaMenor++;
		}

		arreglos[0]=opcionA;
		arreglos[1]=opcionB;
		return arreglos;
	}

	//REQUERIMIENTOS PARTE B

	public LinkedQueue req1B(int origen, int destino, int dia)
	{

		LinkedQueue aux= new LinkedQueue();

		this.ordenarAscendentementePorTiempoPromedio(COLA_DIA);

		
		Iterator iter = listaDia.iterator();
		
		while( iter.hasNext()) 
		{
			Viaje actual = (Viaje) iter.next();
			
			if( actual.getSourceID() == origen && actual.getDstID() == destino && actual.getIdentificador() == dia ) 
			{
				aux.agregar(actual);
			}
		}
		
		return aux;
	}
	
	private void ordenarAscendentementePorTiempoPromedio(int colaDia) {
		// TODO Auto-generated method stub
		
	}


	public LinkedQueue req2B(int n, int dia)
	{
		LinkedQueue aux= new LinkedQueue();
		

		this.ordenarAscendentementePorTiempoPromedio(COLA_DIA);
		Iterator iter = listaDia.iterator();

		
		while(iter.hasNext() && n>0)
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getIdentificador()==dia)
			{
				aux.agregar(actual);
				n--;
			}
			
		}
		
		
		return aux;

	}

	public Object[] req3B(int dia, int zona, int zonaMayor, int zonaMenor)
	{
		Object[] arreglos= new Object[2];
		
		int rango= zonaMayor-zonaMenor+1;
		double[] opcionA= new double[rango];
		double[]opcionB=new double[rango];
		int i=0;
		int j=0;
		
		while(zonaMenor<=zonaMayor)
		{
			Viaje v1= buscarViajeCola(dia, zona, zonaMenor);
			if(v1!=null)
			{
				opcionA[i]=v1.getMeanTravelTime();
				i++;
			}
			else
			{
				opcionA[i]=-1;
				i++;
			}
			
			Viaje v2= buscarViajeCola(dia, zonaMenor, zona);
			
			if(v2!=null)
			{
				opcionB[j]=v2.getMeanTravelTime();
				j++;
			}
			else
			{
				opcionB[j]=-1;
				j++;
			}
			
			zonaMenor++;
		}

		arreglos[0]=opcionA;
		arreglos[1]=opcionB;
		return arreglos;
	}
	
	
	//REQUERIMIENTOS PARTE C
	
	public LinkedQueue req1C(int zonaOrigen, int zonaDestino,int horaInicial, int horaFinal)
	{
		LinkedQueue aux= new LinkedQueue();
		
		Iterator iter=listaHora.iterator();
		
		while(iter.hasNext() && horaInicial<=horaFinal)
		{
			Viaje actual=(Viaje)iter.next();
			
			if(actual.getSourceID()==zonaOrigen && actual.getDstID()==zonaDestino && actual.getIdentificador()==horaInicial)
			{
				aux.agregar(actual);
				horaInicial++;
			}
		}
		
		return aux;
	}
	

	public LinkedQueue req2C(int n, int hora)
	{
		LinkedQueue aux= new LinkedQueue();
		
		this.ordenarDescendentementPorTiempoPromedio(LISTA_HORA);
		
		Iterator iter=listaHora.iterator();
		
		while(iter.hasNext() && n>0)
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getIdentificador()==hora)
			{
				aux.agregar(actual);
				n--;
			}
			
		}
		
		
		return aux;
	}
	
	public LinkedQueue req3C(int zonaOrigen, int zonaDestino)
	{
		this.ordenarAscendentementePorHora(LISTA_HORA);
		
		LinkedQueue aux= new LinkedQueue();
		
		Iterator iter= listaHora.iterator();
		
		while(iter.hasNext())
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getSourceID()==zonaOrigen && actual.getDstID()==zonaDestino)
			{
				aux.agregar(actual);
			}
		}
		
		
		
		return aux;
	}
	
	
	


	//Métodos auxiliares
	public Viaje buscarViajePila(int mes, int zonaOrigen, int zonaDestino)
	{
		Viaje v=null;
		
		Iterator iter=listaMes.iterator();
		
		while(iter.hasNext()&& v==null)
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getDstID()==zonaDestino&& actual.getIdentificador()==mes&&actual.getSourceID()==zonaOrigen)
			{
				v=actual;
			}
		}
		
		
		return v;
		
	}
	
	public Viaje buscarViajeCola( int dia, int zonaOrigen, int zonaDestino) 
	{
		Viaje v=null;
		
		Iterator iter=listaDia.iterator();
		
		while(iter.hasNext()&& v==null)
		{
			Viaje actual= (Viaje) iter.next();
			
			if(actual.getDstID()==zonaDestino&& actual.getIdentificador()==dia&&actual.getSourceID()==zonaOrigen)
			{
				v=actual;
			}
		}
		
		
		return v;
	}
}

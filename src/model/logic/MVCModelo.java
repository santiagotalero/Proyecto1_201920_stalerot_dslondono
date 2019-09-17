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
	
	public void ordenarAscendentementePorTiempoPromedio(int tipoEstructura)
	{
		
	}
	
	public void ordenarDescendentementPorTiempoPromedio(int tipoEstructura)
	{
		
	}
	
	public void ordenarAscendentementePorZonaOrigen(int tipoEstructura)
	{
		
	}
	
	public void ordenarDescendentementPorZonaOrigen(int tipoEstructura)
	{
		
	}
	
	public void ordenarAscendentementePorZonaDestino(int tipoEstructura)
	{
		
	}
	
	public void ordenarDescendentementPorZonaDestino(int tipoEstructura)
	{
		
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
		
		//this.ordenarAscendentementePorTiempoPromedio(PILA_MES);;
		
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
	

<<<<<<< HEAD
	public LinkedQueue  req2A(int n, int mes)
=======
	public Stack req2A(int n, int mes)
>>>>>>> 0942914990079763a3875d85857a4ef73a5ec642
	{
		LinkedQueue aux= new LinkedQueue();
		
		//this.ordenarDescendentementPorTiempoPromedio(PILA_MES);
		
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


	public Object[] req3A(int mes, int zona, int zonaMayor, int zonaMenor)
	{
		//this.ordenarAscendentementePorZonaOrigen(LISTA_MES);
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

	public Queue req1B(int origen, int destino, int dia)
	{
		Queue aux= new Queue();
		this.ordenarAscendentementePorTiempoPromedio(COLA_DIA);
		
		Iterator iter = colaDia.iterator();
		
		while( iter.hasNext()) 
		{
			Viaje actual = (Viaje) iter.next();
			
			if( actual.getSourceID() == origen && actual.getDstID() == destino && actual.getIdentificador() == dia ) 
			{
				aux.enqueue(actual);
			}
		}
		
		return aux;
	}
	
	public Queue req2B(int dia)
	{
		Queue retorno = new Queue<>();
		
		this.ordenarAscendentementePorTiempoPromedio(COLA_DIA);
		Iterator iter = colaDia.iterator();
		
		while(iter.hasNext()) 
		{
			Viaje viajeDia = (Viaje)iter.next();
			if( viajeDia.getIdentificador() == dia) 
			{
				retorno.enqueue(viajeDia.getSourceID());
				retorno.enqueue(viajeDia.getDstID());
				retorno.enqueue(viajeDia.getMeanTravelTime());
				retorno.enqueue(viajeDia.getStandardDeviationTravelTime());
			}
		}


		return retorno;
	}

	public Object[] req3B(int dia, int zona, int zonaMayor, int zonaMenor)
	{
		Object[] arreglos= new Object[2];
		
		int rango= zonaMayor-zonaMenor;
		double[] opcionA= new double[rango];
		double[] opcionB= new double[rango];
		int i=0;
		int j=0;
		
		while(zonaMenor<zonaMayor)
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
				opcionA[j]=-1;
				j++;
			}
			
			zonaMenor++;
		}

		arreglos[0]=opcionA;
		arreglos[1]=opcionB;
		return arreglos;
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
		
		//this.ordenarDescendentementPorTiempoPromedio(listaHora);
		
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
		LinkedQueue aux= new LinkedQueue();
		
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
		Viaje retorno = null;
		Iterator iter = colaDia.iterator();
		
		while( iter.hasNext() ) 
		{
			Viaje x = (Viaje) iter.next();
			if( x.getDstID() == zonaOrigen && x.getSourceID() == zonaOrigen && x.getIdentificador() == dia) 
			{
				retorno = x; 
			}
		}
		
		return retorno; 
	}

}


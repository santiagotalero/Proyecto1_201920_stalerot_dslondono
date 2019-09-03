package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	//private IArregloDinamico datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		//datos = new ArregloDinamico(7);
	}


	//ALGORITMOS DE ORDENAMIENTO
	
	public void ordenarAscendentemente()
	{
		
	}
	
	public void ordenarDescendentemente()
	{
		
	}
	
	
	//METODOS PARA USAR EN CARGA DE ARCHIVO
	
	//Cambiar void por estructura a usar
	public void viajesMes()
	{
		
	}
	
	//Cambiar void por estructura a usar
	public void viajesHora()
	{
		
	}
	
	//Cambiar void por estructura a usar
	public void viajesDia()
	{
		
	}
	
	public int zonaMenor()
	{
		int id=0;
		
		return id;
	}
	
	public int zonaMayor()
	{
		int id=0;
		
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
				//ViajeHora actual= new ViajeHora(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));

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
				//ViajeMes actual= new ViajeMes(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));

			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+trimestre+"-All-WeeklyAggregate.csv"));

			
			reader.readNext();

			
			for(String[] nextLine : reader)
			{
				//ViajeDia actual= new ViajeDia(Integer.parseInt(nextLine[0]),Integer.parseInt(nextLine[1]),Integer.parseInt(nextLine[2]),Double.parseDouble(nextLine[3]),Double.parseDouble(nextLine[4]),Double.parseDouble(nextLine[5]),Double.parseDouble(nextLine[6]));

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
	
	//Cambiar void por estructura a usar
	public void  req2A(int n, int mes)
	{

	}

	//Cambiar void por estructura a usar
	public void req3A(int mes, int zona, int zonaMayor, int zonaMenor)
	{

	}

	//REQUERIMIENTOS PARTE B

	public double[] req1B(int origen, int destino, int dia)
	{
		double [] stats= new double[2];

		//Implementar

		return stats;
	}

	//Cambiar void por estructura a usar
	public void  req2B(int n, int dia)
	{

	}

	//Cambiar void por estructura a usar
	public void req3B(int dia, int zona, int zonaMayor, int zonaMenor)
	{

	}
	
	
	//REQUERIMIENTOS PARTE C
	
	//Cambiar void por estructura a usar
	public void req1C(int horaInicial, int horaFinal)
	{
		
	}
	
	//Cambiar void por estructura a usar
	public void req2C(int n, int hora)
	{
		
	}
	
	//Cambiar void por estructura a usar
	public void req3C(int zonaOrigen, int zonaDestino)
	{
		
	}

}

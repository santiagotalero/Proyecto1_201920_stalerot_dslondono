package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import model.data_structures.LinkedQueue;
import model.data_structures.Stack;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	//Centinela carga archivos
	private boolean cargaArchivos;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
		cargaArchivos=false;
	}
		
	public void run() 
	{
		
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
;

		while( !fin )
		{
			//Esperar 3,5 segundos para que el usuario pueda leer
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			view.printMenu();
			

			int option = lector.nextInt();
			switch(option){
			case 1:
				
				if(!cargaArchivos)
				{
					System.out.println("Ingrese el número de trimestre a cargar: ");
					
					int trimestre = lector.nextInt();

					try {
						modelo.cargarArchivo(trimestre);
					} catch (IOException e) {
						e.printStackTrace();
					}

					System.out.println("--------- \nDatos carga de archivos\n");

					//Realizar el .size respectivo una vez implementado tipo estructura en modelo
					System.out.println("El número total de datos para el archivo por meses es: "+modelo.viajesMes().size()+";\n");

					//Realizar el .size respectivo una vez implementado tipo estructura en modelo
					System.out.println("El número total de datos para el archivo por dias es: "+modelo.viajesDia().size()+";\n");

					//Realizar el .size respectivo una vez implementado tipo estructura en modelo
					System.out.println("El número total de datos para el archivo por horas es: "+modelo.viajesHora().size()+";\n");

					System.out.println("La zona con menor identificador encontrada en los archivos es: "+modelo.zonaMenor()+";\n");

					System.out.println("La zona con mayor identificador encontrada en los archivos es: "+modelo.zonaMayor()+";\n");
					
					cargaArchivos=true;
				}
				else
				{
					System.out.println("Ya cargó archivos una vez, no puede volverlo a hacer.");
				}

				break;


			case 2: 
				
				System.out.println("Ingrese un mes dado");
				int mes2=lector.nextInt();
				
				System.out.println("Ingrese una zona de origen dada");
				int zdo2= lector.nextInt();
				
				System.out.println("Ingrese una zona de destino dada");
				int zdd2= lector.nextInt();
				
				LinkedQueue aux2= modelo.req1A(zdo2, zdd2, mes2);
				
				System.out.println("Los datos obtenidos con las parametros ingresados son:");
				
				Iterator iter2= aux2.iterator();
				
				while(iter2.hasNext())
				{
					Viaje actual= (Viaje)iter2.next();
					System.out.println("Tiempo promedio: "+actual.getMeanTravelTime() + ", desviación estándar: "+ actual.getStandardDeviationTravelTime());
				}
				
				break;	
			
			case 3: 
				
				System.out.println("Ingrese el número de viajes");
				int n3= lector.nextInt();
				
				System.out.println("Ingrese el número de mes");
				int mes3=lector.nextInt();
				
				LinkedQueue aux3= modelo.req2A(n3, mes3);
				
				Iterator iter3= aux3.iterator();
				
				System.out.println("Los datos obtenidos con los parámetros ingresados son:");
				
				while(iter3.hasNext())
				{
					Viaje actual= (Viaje) iter3.next();
					
					System.out.println("Zona de origen: "+actual.getSourceID()+" zona de destino: " + actual.getDstID()+ " tiempo promedio: "+ actual.getMeanTravelTime()+ " desviación estándar: "+ actual.getStandardDeviationTravelTime());
				}


				break;
			
			case 4: 
				
				System.out.println("Ingrese un mes dado");
				int mes4=lector.nextInt();
				
				System.out.println("Ingrese una zona dada");
				int zona4=lector.nextInt();
				
				System.out.println("Ingrese el numero menor de un rango de zonas");
				int zonaMenor=lector.nextInt();
				
				System.out.println("Ingrese el numero mayor de un rango de zonas");
				int zonaMayor=lector.nextInt();
				
				Object[] arreglos= modelo.req3A(mes4, zona4, zonaMayor, zonaMenor);
				
				double[] a= (double[]) arreglos[0];
				double[] b= (double[]) arreglos[1];
				
				int i=0;
				
				while(i<a.length)
				{
					
					String texto=null;
					String texto2=null;
					if(a[i]==-1)
					{
						texto= "No hay viajes";
					}
					else
					{
						texto=Double.toString(a[i]);
					}
					if(b[i]==-1)
					{
						texto2= "No hay viajes";
					}
					else
					{
						texto2=Double.toString(b[i]);
					}
					
					System.out.println(texto+" de "+ zona4 +" a "+ (zonaMenor+i)+ " vs "+ texto2+" de "+ (zonaMenor+i)+ " a "+ zona4);
					i++;
				}


				break;
			
			case 5: 

				System.out.println("Ingrese un dia dado");
				int dia5=lector.nextInt();
				
				System.out.println("Ingrese una zona de origen dada");
				int zdo5= lector.nextInt();
				
				System.out.println("Ingrese una zona de destino dada");
				int zdd5= lector.nextInt();
				
				LinkedQueue aux5= modelo.req1B(zdo5, zdd5, dia5);
				
				System.out.println("Los datos obtenidos con las parametros ingresados son:");
				
				Iterator iter5= aux5.iterator();
				
				while(iter5.hasNext())
				{
					Viaje actual= (Viaje)iter5.next();
					System.out.println("Tiempo promedio: "+actual.getMeanTravelTime() + ", desviación estándar: "+ actual.getStandardDeviationTravelTime());
				}
				
				break;
			
			case 6: 

				System.out.println("Ingrese el número de viajes");
				int n6= lector.nextInt();
				
				System.out.println("Ingrese el número de dia");
				int mes6=lector.nextInt();
				
				LinkedQueue aux6= modelo.req2B(n6, mes6);
				
				Iterator iter6= aux6.iterator();
				
				System.out.println("Los datos obtenidos con los parámetros ingresados son:");
				
				while(iter6.hasNext())
				{
					Viaje actual= (Viaje) iter6.next();
					
					System.out.println("Zona de origen: "+actual.getSourceID()+" zona de destino: " + actual.getDstID()+ " tiempo promedio: "+ actual.getMeanTravelTime()+ " desviación estándar: "+ actual.getStandardDeviationTravelTime());
				}


				break;
			
			case 7: 

				System.out.println("Ingrese un dia dado");
				int mes7=lector.nextInt();
				
				System.out.println("Ingrese una zona dada");
				int zona7=lector.nextInt();
				
				System.out.println("Ingrese el numero menor de un rango de zonas");
				int zonaMenor7=lector.nextInt();
				
				System.out.println("Ingrese el numero mayor de un rango de zonas");
				int zonaMayor7=lector.nextInt();
				
				Object[] arreglos7= modelo.req3B(mes7, zona7, zonaMayor7, zonaMenor7);
				
				double[] a7= (double[]) arreglos7[0];
				double[] b7= (double[]) arreglos7[1];
				
				int i7=0;
				
				while(i7<a7.length)
				{
					
					String texto=null;
					String texto2=null;
					if(a7[i7]==-1)
					{
						texto= "No hay viajes";
					}
					else
					{
						texto=Double.toString(a7[i7]);
					}
					if(b7[i7]==-1)
					{
						texto2= "No hay viajes";
					}
					else
					{
						texto2=Double.toString(b7[i7]);
					}
					
					System.out.println(texto+" de "+ zona7 +" a "+ (zonaMenor7+i7)+ " vs "+ texto2+" de "+ (zonaMenor7+i7)+ " a "+ zona7);
					i7++;
				}
				break;
			
			case 8: 
				
				System.out.println("Ingrese una zona de origen dado");
				int zdo8=lector.nextInt();
				
				System.out.println("Ingrese una zona de destino dada");
				int zdd8=lector.nextInt();
				
				System.out.println("Ingrese el numero menor de un rango de horas");
				int horaMenor8=lector.nextInt();
				
				System.out.println("Ingrese el numero mayor de un rango de horas");
				int horaMayor8=lector.nextInt();
				
				LinkedQueue aux8= modelo.req1C(zdo8, zdd8, horaMenor8, horaMayor8);
				
				Iterator iter8= aux8.iterator();
				
				while(iter8.hasNext())
				{
					Viaje actual= (Viaje)iter8.next();
					
					System.out.println("Tiempo promedio: "+actual.getMeanTravelTime() +" desviación estándar: "+actual.getStandardDeviationTravelTime() + " hora: "+actual.getIdentificador() );
				}

				break;
			
			case 9: 

				System.out.println("Ingrese el número de viajes");
				int n9= lector.nextInt();
				
				System.out.println("Ingrese el número de hora");
				int mes9=lector.nextInt();
				
				LinkedQueue aux9= modelo.req2C(n9, mes9);
				
				Iterator iter9= aux9.iterator();
				
				System.out.println("Los datos obtenidos con los parámetros ingresados son:");
				
				while(iter9.hasNext())
				{
					Viaje actual= (Viaje) iter9.next();
					
					System.out.println("Zona de origen: "+actual.getSourceID()+" zona de destino: " + actual.getDstID()+ " tiempo promedio: "+ actual.getMeanTravelTime()+ " desviación estándar: "+ actual.getStandardDeviationTravelTime());
				}

				break;
			
			case 10: 
				
				System.out.println("Ingrese una zona de origen dada: ");
				int zdo10=lector.nextInt();
				
				System.out.println("Ingrese una zona de destino dada: ");
				int zdd10=lector.nextInt();
				
				LinkedQueue aux10= modelo.req3C(zdo10, zdd10);
				
				System.out.println("Aproximación en minutos de viajes entre zona origen y zona destino.");
				System.out.println("Trimestre X del 2018 detallado por cada hora del día");
				System.out.println("Zona Origen: "+ zdo10);
				System.out.println("Zona destino: " + zdd10);
				System.out.println("Hora|  # de minutos");
				
				Iterator iter10= aux10.iterator();
				
				while(iter10.hasNext())
				{
					Viaje actual= (Viaje)iter10.next();
					
					String as= this.generarAsteriscos((int)actual.getMeanTravelTime()/60);
					
					if(as.equals(""))
					{
						as="no hay viaje";
					}
					
					System.out.println(actual.getIdentificador()+"  |  " + as);
					
				}

				break;

			case 11:
				System.out.println("--------- \nHasta pronto! \n ");
				lector.close();
				fin = true;
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}
	
	private String generarAsteriscos(int n)
	{
		String as="";
		
		while(n>0)
		{
			as.concat("*");
			n--;
		}
		return as;
	}
}

package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

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
				
				Stack aux2= modelo.req1A(zdo2, zdd2, mes2);
				
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
				
				Stack aux3= modelo.req2A(n3, mes3);
				
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
					
					System.out.println(texto+"de"+ zona4 +" a "+ (zonaMenor+i)+ " vs "+ texto2+" de "+ (zonaMenor+i)+ " a "+ zona4);
				}


				break;
			
			case 5: 


				break;
			
			case 6: 


				break;
			
			case 7: 


				break;
			
			case 8: 


				break;
			
			case 9: 


				break;
			
			case 10: 


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
}

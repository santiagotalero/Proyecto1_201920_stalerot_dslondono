package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


import model.logic.MVCModelo;
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


				break;	
			
			case 3: 


				break;
			
			case 4: 


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

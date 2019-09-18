package view;

import java.util.Scanner;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{

			
			System.out.println("\nConsulta de viajes UBER\n");
			
			System.out.println("\nOprima 1 para iniciar la carga de archivos por trimestre (SOLO PUEDE REALIZARSE UNA VEZ), luego oprimir tecla Return: (e.g., 1):\n");
			
			System.out.println("No puede realizar ningúna de las otras consultas sin haber cargado los datos primero. \n");
			
			System.out.println("Oprima 2 para realizar una consulta tiempo promedio y desviación estándar entre una zona de origen y una zona de destino de un mes dado, luego oprimir tecla Return: (e.g., 2):\n");
			
			System.out.println("Oprima 3 para realizar una consulta de los n viajes con mayor tiempo promedio de un mes dado, luego oprimir tecla Return: (e.g., 3):\n");
			
			System.out.println("Oprima 4  para realizar una cosulta de req 3A , luego oprimir tecla Return: (e.g., 4):\n");
			
			System.out.println("Oprima 5 para  realizar una consulta de req 1B, luego oprimir tecla Return: (e.g., 5):\n");
			
			System.out.println("Oprima 6 para realizar una consulta de req 2B, luego oprimir tecla Return: (e.g., 6):\n");
			
			System.out.println("Oprima 7 para realizar una consulta de 3B , luego oprimir tecla Return: (e.g., 7):\n");
			
			System.out.println("Oprima 8 para  realizar una consulta de 1C, luego oprimir tecla Return: (e.g., 8):\n");
			
			System.out.println("Oprima 9 para realizar una consulta de 2C , luego oprimir tecla Return: (e.g., 9):\n");
			
			System.out.println("Oprima 10 para realizar una consulta de 3C , luego oprimir tecla Return: (e.g., 10):\n");
			
			System.out.println("Oprima 11 para salir del programa , luego oprimir tecla Return: (e.g., 10):\n");

			
			
		}


}

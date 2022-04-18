import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

// Combina los metodos generados en las activvidades 2 y 3 creando uan aplicacion que gestione ventas y control de stock en una misma interfaz.
// Utiliza para ello las estructuras de datos que creas conveniente
public class Ejercicio4 {

	public static void main(String[] args) {
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);

		// Llamamos las funciones
		Hashtable <String, String> stockProductos = new Hashtable <String, String>();
		stockProductos = crearBaseDatos();
		opcionesConsola(stockProductos);

	}

	// Creamos el array con cada producto
	public static Hashtable <String, String> crearBaseDatos() {
		Hashtable <String, String> baseDatos = new Hashtable <String, String>();
		baseDatos.put("pera", "1.00");
		baseDatos.put("albondigas", "4.30");
		baseDatos.put("bocata", "5.50");
		baseDatos.put("kiwi", "2.20");
		baseDatos.put("jabon", "3.10");
		baseDatos.put("ensalada", "3.10");
		baseDatos.put("brocoli", "1.50");
		baseDatos.put("escalibada", "2.60");
		baseDatos.put("chocolate", "3.00");
		baseDatos.put("tomaquet", "2.50");

		return baseDatos;

	}
	// Creamos el menu para elegir opcion
		public static Hashtable opcionesConsola(Hashtable stockProductos) {
			Scanner sc = new Scanner(System.in);
			
			int seleccionMenu = 0;
			String eleccion = "";

			// Mientras no escribas una de las opcines
			do {
				System.out.println(" 1- Añadir " + " 2- Consultar " + " 3- Listar " + " 4- Salir ");			
				eleccion = sc.nextLine();

				switch (eleccion.toUpperCase()) {
				case "AÑADIR":
					System.out.println("AÑADIR ");
					stockProductos= afegir(stockProductos);
					System.out.println(stockProductos);

					break;
				case "CONSULTAR":
					System.out.println("CONSULTAR: ");
					consultar(stockProductos);
					break;

				case "LISTAR":
					System.out.println("LISTAR: ");
					listar(stockProductos);
					break;

				case "SALIR":
					System.out.println("SALIR ");
					seleccionMenu = 1;
					break;

				default:
					System.out.println("default ");
					break;

				}
			}while(seleccionMenu == 0);	

			return stockProductos;	
		}		
	
	// Funcion con el HashTable
	public static Hashtable<String, String> afegir(Hashtable<String, String> array){
		Scanner sc = new Scanner(System.in);

		// Pedimos el nombre que quiere añadir
		System.out.println("Que articulo quieres añadir: ");
		String producto = sc.nextLine();

		// Pedimos el precio que quiere añadir
		System.out.println("Añade el precio: ");
		String precio = sc.nextLine();

		array.put(producto, precio);

		return array;
	}

	public static void  consultar(Hashtable<String, String> array){
		Scanner sc = new Scanner(System.in);

		// Pedimos que stock quiere ver
		System.out.println("Que producto quieres consultar: ");
		String consultado = sc.nextLine();

		for (String i: array.keySet()) {
			if (consultado.equals(i)) {
				System.out.println( "Producto - " + i + " Precio - " + array.get(i)); 

			}

		}

	}

	// Funcion para mostrar el ticket
	public static void listar(Hashtable<String, String> array){
		for (String i: array.keySet()) {
			System.out.println( "Producto - " + i + "/precio - " + array.get(i)); 
		}

	}
	
}
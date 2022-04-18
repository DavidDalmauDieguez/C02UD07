import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

// Crea una base de datos de 10 articulos para controlar el stock de productos de una tienda por medio de un diccionario de datos. 
// El usuario podra añadir, por medio de interfaz visual articulos nuevos y cantidades de estos. 
// El usuario podra consultar la informacion almacenada en el diccionario referente a un articulo concreto e incluso listar toda informacion en el terminal del programa
public class Ejercicio3 {
	public static void main(String[] args) {
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		Hashtable<String, Integer> producto = new Hashtable<String, Integer>();

		// Añadimos los productos a la Hashtable
		producto.put("manzana", 2);
		producto.put("platano", 1);
		producto.put("agua", 1);
		producto.put("pan", 4);
		producto.put("kiwi", 3);
		producto.put("pera", 4);
		producto.put("jamon", 3);
		producto.put("bombones", 5);
		producto.put("cerezas", 8);
		producto.put("atun", 9);

		int eleccionMenu = JOptionPane.showConfirmDialog(null, "¿Desea añadir algún artículo?");

		while (JOptionPane.OK_OPTION == eleccionMenu) {
			String seleccion = JOptionPane.showInputDialog(null, "Añade el nombre del producto: ");
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Añade la cantidad del producto: "));

			producto.put(seleccion, cantidad);

			eleccionMenu = JOptionPane.showConfirmDialog(null, "Quieres añadir otro producto? ");

		}

		int stockProductos = JOptionPane.showConfirmDialog(null, "Quieres ver el stock?");

		while (JOptionPane.OK_OPTION == stockProductos) {

			String infoProducto = JOptionPane.showInputDialog(null, "Nombre del artículo a mostrar la información: ");
			JOptionPane.showInputDialog("Articulo: " + infoProducto + " Stock: " + producto.get(infoProducto));

			stockProductos = JOptionPane.showConfirmDialog(null, "Quieres seguir viendo el stock?");

		}

	}

}
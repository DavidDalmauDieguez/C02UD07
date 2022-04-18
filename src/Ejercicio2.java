import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Crea una aplicacion que gestione el flujo de ventas de una caja de supermercado. 
// El programa guardara las cantidades del carrito de compra dentro de una lista. Mostrara por pantalla:
// IVA APLICADO (21% o 4%)
// precio total bruto y precio mas iva
// numero de articulos comprados
// cantidad pagada
// cambio a devolver al cliente


// Guardar nombre del producto con su precio y al pedir la cantidad que se multiplique el precio por la cantidad i las demas operaciones
public class Ejercicio2 {
	public static void main(String []args){
		// Creamos el scanner
		Scanner sc = new Scanner(System.in);
		
		DecimalFormat df = new DecimalFormat("0.00");
		HashMap<String, Double> producto = new HashMap<String, Double>();
		boolean compraRealizada = false;

		// productos
		producto.put("leche nostra           ", 0.89);
		producto.put("batido puleva          ", 1.25);
		producto.put("gazpacho alvalle       ", 3.24);
		producto.put("tarta canada menorquina", 1.85);
		producto.put("pastel de chocolate    ", 3.45);
		producto.put("pechuga de pollo       ", 3.13);
		producto.put("queso camembert        ", 2.79);
		producto.put("manzana                ", 2.39);
		producto.put("mortadela              ", 1.05);
		producto.put("risotto                ", 1.85);

		// Mientras no acabes la compra
		do {
			// Arrays para guardar los valores elegidos
			HashMap<String, Integer> carritoCompra = new HashMap<String, Integer>();
			ArrayList<String> tempCarritoCompra = new ArrayList<>();
			boolean pasarPorCajaRealizada = false;

			// Mientras no acabes la compra
			do {
				System.out.println("");
				int contador = 1;
				// Leemos el HashMap
				for (String i : producto.keySet()) {
					if (contador < 10) {
						System.out.print("0");
					}
					System.out.println(contador + ". " + i + ", " + producto.get(i) + " €");
					contador++;
				}

				System.out.println("(1/10. pasar por caja)\t\t(0. Terminar)");
				int respuesta = sc.nextInt();

				// Cuando la respuesta sea 0 acabas de pedir
				if (respuesta == 0) {
					pasarPorCajaRealizada = true;
				} else if (respuesta > 0 && respuesta <= 10) {
					String indexHashmap = (String) producto.keySet().toArray()[respuesta-1];
					tempCarritoCompra.add(indexHashmap);
				}

			} while (!pasarPorCajaRealizada);

			// Contador de productos añadidos
			for (String i : producto.keySet()) {
				int contadorCantidadProducto = 0;
				// Sumamos cantidad al producto seleccionado
				for (int j = 0; j < tempCarritoCompra.size(); j++) {
					if (i.equals(tempCarritoCompra.get(j))) {
						contadorCantidadProducto++;
					}
				}
				
				
				if (contadorCantidadProducto != 0) {
					carritoCompra.put(i, contadorCantidadProducto);
				}
			}

			// Mostramos todo 
			System.out.println("Producto\t\t Precio\t Cantidad");
			System.out.println("--------------------------------------------------------");
			
			// Mostramos el precio y las unidades
			for (String i1 : carritoCompra.keySet()) {
				System.out.println(i1 + "  " + producto.get(i1) + "€   " + carritoCompra.get(i1) + " Und.");
			}

			System.out.println("");
			System.out.println("        \t\t Total \t +IVA(21%)");
			System.out.println("--------------------------------------------------------");

			// Suma de los precios
			double sumaTotal = 0;
			for (int i = 0; i < tempCarritoCompra.size(); i++) {
				sumaTotal = producto.get(tempCarritoCompra.get(i)) + sumaTotal;
			}
			System.out.println("        \t\t " + df.format(sumaTotal) + "€\t " + df.format(sumaTotal * 1.21) + "€");

			compraRealizada = true;
		} while (!compraRealizada);
	}
}

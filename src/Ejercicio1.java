import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

// Crea una aplicacion que calcule la nota media de los alumnos pertenecientes al curso de programacion. 
// Una vez calculada la nota media se guardara esta informacion en un diccionario de datos que almacene la nota media de cada alumno. 
// Todos estos datos se han de proporcionar por pantalla.
public class Ejercicio1 {

	public static void main(String[] args) {
		// Creamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Creamos las variables
		// Cantidad de alumnos y notas por alumno
		int numAlumnos;
		int numDeNotas;
		// Nombre del alumno
		String nombreAlumno;
		// Nota del alumno
		double notaAlumno;		

		double medio = 0;
		
		double nota = 0;
		double notaMedia;

		// Contadores para sabe ren que alumno y nota estamos
		int contadorAlumnos = 0;
		int contadorNotas = 0;

		HashMap<String, Double> nombreAlumnos = new HashMap<String, Double>();
		
		// Pedimos el numero de alumnos que queremos
		System.out.println("Añade numero de alumnos: ");
		numAlumnos = sc.nextInt();
		sc.nextLine();

		// Pedimos el numero de notas que quiere el alumno
		System.out.println("Añade el numero de notas del alumno: ");
		numDeNotas = sc.nextInt();
		sc.nextLine();

		// Mientras haya alumnos preguntamos por su nombre
		do {			
			System.out.println("Añade el nombre del alumno: ");
			nombreAlumno = sc.nextLine();

			// Mientras haya notas preguntamos por la nota del alumno
			do {
				System.out.println("Añade la nota " + (contadorNotas+1));
				notaAlumno = sc.nextInt();
				sc.nextLine();

				medio = notaAlumno + medio;
				contadorNotas++;
				
			} while (contadorNotas != numDeNotas);
			
			// Calculamos la media
			medio = medio/numDeNotas;
			
			// Guardamos la media en el HashMap
			nombreAlumnos.put(nombreAlumno, medio);
			
			// Reiniciamos contadores
			medio = 0;
			contadorNotas = 0;
			
			contadorAlumnos++;
			
		} while (contadorAlumnos != numAlumnos);

		// Imprimimos los valores guardados en el hashmap
		System.out.println(nombreAlumnos);

	}
}

package juegoPGG;

//Clase principal de ejecucion del juego
public class Main {

	public static void main(String[] args) 
	{	
		//System.out.println("Ingrese cantidad de cartas");
		//PGG baraja = new PGG(Integer.parseInt(Entrada.readLine())); 
		PGG baraja = new PGG(8); // Instancia: n == 8
		//O(1)
		baraja.agregarNaipe("Perro"); // Agrego un Perro
		baraja.agregarNaipe("Perro"); // Agrego un Gato
		baraja.agregarNaipe("Perro"); // O(1)
		baraja.agregarNaipe("Gato");
		baraja.agregarNaipe("Gato");
		baraja.agregarNaipe("Gato");
		baraja.agregarNaipe("Gallina");
		baraja.agregarNaipe("Gallina");
		
		System.out.println();
		while (baraja.ganador() == "" && baraja.cantManosJugadas() < 1000) // O(1000)
		{
			//como máximo hacerlo 1000 veces
			baraja.jugar(); // Se juega una mano | O(N^3)
			System.out.println(baraja.ver()); //Se muestra un resumen del juego (la ultima jugada por cada llamada)
		}
		System.out.println(baraja.ganador());
		System.out.println(baraja.cantManosJugadas());
	}
}

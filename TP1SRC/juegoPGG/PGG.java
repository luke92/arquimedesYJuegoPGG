package juegoPGG;
//Clase principal que hace uso de las otras clases para el desarrollo del juego
public class PGG 
{
	private int cantManosJugadas;
	private Jugador j1;
	private Jugador j2;
	private Naipes naipes;
	private Turno turno;
	private String ganador;
	public PGG(int n) // n > 1 | O(1)
	{
		if(n < 2) throw new RuntimeException("La cantidad minima de cartas debe ser 2");
		if(!Funciones.esPar(n)) throw new RuntimeException("La cantidad de cartas debe ser par");
		this.naipes = new Naipes(n);
		this.j1 = new Jugador(n);
		this.j2 = new Jugador(n);
		this.cantManosJugadas = 0;
		this.ganador = "";
	}
	
	public void agregarNaipe(String tipoNaipe) //Define un naipe en la baraja | O(1)
	{
		this.naipes.agregar(new Naipe(tipoNaipe));
	}
	
	public String ganador() //O(1)
	{
		return this.ganador;
		
	}
	
	public int cantManosJugadas() //O(1)
	{
		return this.cantManosJugadas;
	}
	
	public String ver() //O(1)
	{
		return turno.verTurno();
	}
	
	public void jugar() //O(N^3)
	{
		if(this.cantManosJugadas() == 0) //O(1)
		{
			comprobarInvariante(); //O(N)
			ingresarNombresJugadores(); //O(1)
			repartirCartas(); //O(N^2)
		}
		System.out.println("Presiona enter para que los jugadores jueguen \n");
		Entrada.readLine();
		turno = new Turno(j1,j2);
		this.cantManosJugadas++;
		if(j2.cantidadNaipes() == 0) this.ganador = j1 + " gano";
		if(j1.cantidadNaipes() == 0) this.ganador = j2 + " gano";
		if(this.cantManosJugadas() == 1000)
		{
			if(j1.cantidadNaipes() == j2.cantidadNaipes()) this.ganador = "Hubo empate de ambos jugadores\n";
			if(j1.cantidadNaipes() > j2.cantidadNaipes()) this.ganador = j1 + " gano \n";
			if(j2.cantidadNaipes() > j1.cantidadNaipes()) this.ganador = j2 + " gano \n";
		}
	}
	
	public void comprobarInvariante() //O(N)
	{
		if(!this.getNaipes().mazoLleno()) throw new RuntimeException("Faltaron agregar naipes a la baraja"); //O(1)
		//O(N)
		if(!this.getNaipes().mazoJugable()) throw new RuntimeException("El mazo no cuenta con al menos 2 tipos de naipes, por lo que los jugadores siempre empataran");
	}
	
	public void repartirCartas() //O(N^2)
	{
		this.naipes.barajar(); //O(N)
		int cantidadPorJugador = this.naipes.tamaño() / 2; //O(1)
		this.j1.repartirCartas(this.naipes, cantidadPorJugador); //O(N/2)
		this.j2.repartirCartas(this.naipes, cantidadPorJugador); //O(N/2)
	}

	public void ingresarNombresJugadores() //O(1)
	{
		System.out.println("Ingrese nombre de jugador 1");
		this.j1.setNombre(Entrada.readLine());
		System.out.println("Ingrese nombre de jugador 2");
		this.j2.setNombre(Entrada.readLine());
	}
	
	private Naipes getNaipes() {
		return naipes;
	}
}

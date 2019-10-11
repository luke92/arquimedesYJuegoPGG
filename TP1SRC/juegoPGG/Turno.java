package juegoPGG;
//Clase que describe que sucede y que se hace en cada turno del juego 
public class Turno 
{
	private String jugada;
	
	public Turno(Jugador j1, Jugador j2)//O(1)
	{
		jugada = "";
		jugada += j1 + ":" + j1.cantidadNaipes() + ", ";
		jugada += j2 + ":" + j2.cantidadNaipes() + "\n";
		Naipe n1 = j1.juegaCarta();
		Naipe n2 = j2.juegaCarta();
		jugada += j1 + " saco el naipe " + n1 + "\n";
		jugada += j2 + " saco el naipe " + n2 + "\n";
		if(n1.gana(n2))
		{
			j1.agregarNaipe(n1);
			j1.agregarNaipe(n2);
			jugadorGana(j1, j2, n1, n2);;
		}
		if(n2.gana(n1))
		{	
			j2.agregarNaipe(n1);
			j2.agregarNaipe(n2);
			jugadorGana(j2, j1, n2, n1);
		}
		if(n1.empata(n2))
		{
			j1.agregarNaipe(n1);
			j2.agregarNaipe(n2);
			j1.mezclarCartas();
			j2.mezclarCartas();
			empate(j1, j2);
		}
		
	}
	
	private void jugadorGana(Jugador gana, Jugador pierde, Naipe fuerte, Naipe debil)//O(1)
	{
		jugada += gana + " gana \n";
	}
	
	private void empate(Jugador j1, Jugador j2)//O(1)
	{
		jugada += j1 + " y " + j2 + " empataron, se devuelve la carta al mazo de cada jugador y se barajan ambos mazos \n";
	}
	
	public String verTurno()
	{
		return jugada;
	}
	
}

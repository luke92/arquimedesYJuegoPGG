package juegoPGG;
//Clase que representa a cada jugador y su mazo
public class Jugador 
{

	private String nombre; //Nombre del jugador
	private Naipes naipes; //Mazo del jugador
	
	private void setNaipes(Naipes naipes) //O(1)
	{
		this.naipes = naipes;
	}
	
	public String getNombre() //O(1)
	{
		return nombre;
	}
	
	public void setNombre(String nombre) //O(1)
	{
		this.nombre = nombre;
	}
	
	public Jugador(int n) //O(1)
	{
		this.setNaipes(new Naipes(n));
	}
	
	public void repartirCartas(Naipes naipes, int cantidad) //O(N)
	{
		for(int i = 0; i < cantidad; i++)
		{
			this.naipes.agregar(naipes.cima());
		}
	}
	
	public void agregarNaipe(Naipe naipe) //O(1)
	{
		naipes.agregar(naipe);
	}
	
	public Naipe juegaCarta() //O(1)
	{
		return naipes.cima();
	}
	
	public int cantidadNaipes() //O(1)
	{
		return this.naipes.tamaño();
	}
	
	public void mezclarCartas() //O(N)
	{
		naipes.barajar();
	}
	@Override
	public String toString() 
	{
		return nombre;
	}
}

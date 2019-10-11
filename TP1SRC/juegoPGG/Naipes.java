package juegoPGG;
import java.util.ArrayList;

//Clase que representa a un mazo de naipes
public class Naipes 
{
	private ArrayList<Naipe> naipes;
	private int cantidadObligatoria;
	
	private int getCantidadObligatoria() {
		return cantidadObligatoria;
	}

	private void setCantidadObligatoria(int cantidadObligatoria) {
		this.cantidadObligatoria = cantidadObligatoria;
	}

	public ArrayList<Naipe> getNaipes() {
		return naipes;
	}

	public void setNaipes(ArrayList<Naipe> naipes) {
		this.naipes = naipes;
	}
	
	public Naipes(int n)//O(1)
	{
		this.setCantidadObligatoria(n);
		naipes = new ArrayList<Naipe>();
	}
	
	public void agregar(Naipe naipe) //O(1)
	{
		if(mazoLleno()) throw new RuntimeException("No se puede exceder la cantidad de naipes maxima");
		this.naipes.add(naipe);
	}
	
	public int tamaño() //O(1)
	{
		return this.naipes.size();
	}
	
	public boolean mazoJugable() //O(N)
	{
		Naipe n = naipes.get(0);
		for(int i = 1; i < this.tamaño(); i++)
		{
			if(!n.empata(naipes.get(i))) return true;
		}
		return false;
	}
	
	public boolean mazoLleno() //O(1)
	{
		return this.tamaño() == this.getCantidadObligatoria();
	}
	
	public void barajar() //O(N)
	{   // Abre metodo barajar
		for ( int i = 0; i < this.tamaño(); i++ )
		{	 
			int aleatorio = Funciones.naipeAleatorio(tamaño());
			 
			Naipe aux = naipes.get(i);
			naipes.set(i, naipes.get(aleatorio));
			naipes.set(aleatorio, aux);
		} 
	}
	
	public Naipe cima() //O(1)
	{
		if(this.tamaño() > 0)
		return naipes.remove(0);
		return null;
	}
}

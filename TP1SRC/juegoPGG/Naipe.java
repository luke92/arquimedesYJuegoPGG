package juegoPGG;
//Clase para representar cada naipe del juego
public class Naipe 
{
	private String animal; //Animal que representa la carta
	private String naipeDebil; //Animal que pierde contra por el naipe

	public Naipe(String animal) //Constructo del naipe
	{
		this.animal = animal;
		if(animal != "Perro" && animal != "Gato" && animal != "Gallina") // 3
			throw new RuntimeException("El juego solo admite los tipos de naipe: 'Perro', 'Gato o 'Gallina'"); 
		
			if(animal == "Perro")
			this.naipeDebil = "Gato";
			
			if(animal == "Gato")
			this.naipeDebil = "Gallina";
	
			
			if(animal == "Gallina")
			this.naipeDebil = "Perro";	
	}
	
	public boolean gana(Naipe naipe) //O(1)
	{
		return (this.naipeDebil == naipe.animal);
	}
	
	public boolean empata(Naipe naipe) //O(1)
	{
		return (this.animal == naipe.animal);
	}

	@Override
	public String toString() {
		return this.animal;
	}
}

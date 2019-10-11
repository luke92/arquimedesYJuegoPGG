package juegoPGG;

import java.util.Random;

//Funciones de utilidad
public class Funciones 
{
	//Verificar si el numero es par
	public static boolean esPar(int n) //O(1)
	{
		return (n%2==0); //1
	}
	
	//Devolver alguna posicion aleatoria de una lista de naipes
	public static int naipeAleatorio(int tamaño) //O(1)
	{
		Random rnd = new Random(); // 1
		return rnd.nextInt(tamaño); //O(1)
	}
	
}

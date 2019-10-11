package arquimedes;

public class Barco {
	
		Integer id;

		String Nombre;



		public Barco(Integer id, String nombre){

			this.id = id;

			this.Nombre = nombre;
		}


		@Override
		public String toString() {

			return id + " " + Nombre;

		} 
	}







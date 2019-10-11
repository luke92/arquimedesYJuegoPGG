package arquimedes;

public class Main {

	public static void main(String[] args) {

			Mapa m1 = new Mapa(5);
			m1.asignarNombre(0, "B01");
			m1.asignarNombre(1, "B02");
			m1.asignarNombre(2, "B03");
			m1.asignarNombre(3, "B04");
			m1.asignarNombre(4, "B05");
			m1.setDistEsp(0, 10 );
			m1.setDistEsp(1, 11 );
			m1.setDistEsp(2, 12 );
			m1.setDistEsp(3, 13 );
			m1.setDistEsp(4, 14 );
			m1.setDistIJ(0, 1, 5, true);
			m1.setDistIJ(0, 2, 6, true);
			m1.setDistIJ(0, 3, 7, true);
			m1.setDistIJ(0, 4, 9, true);
			m1.setDistIJ(1, 2, 10, true);
			m1.setDistIJ(1, 3, 15, true);
			m1.setDistIJ(1, 4, 30, true);
			m1.setDistIJ(2, 3, 15, true);
			m1.setDistIJ(2, 4, 25, true);
			m1.setDistIJ(3, 4, 5, true);
			
			System.out.println(m1.caminoMinimoProbableB());
			System.out.println(m1.distancia(m1.caminoMinimoProbableB()));
			
			}
	



	}



package arquimedes;

import java.util.ArrayList;

public class Mapa {

		private Barco [] barcos;

		private int [][] distancias; // distancia de i a j

		private int [] distanciaEspejo; // distancia al espejo

		private int n;
		
		private boolean [] quemados;



		public Mapa(int tamano){

			n= tamano;

			barcos = new Barco [n];

			quemados = new boolean [n];

			distancias = new int [n][n];

			distanciaEspejo = new int [n];

			for (int i=0; i<n; i++){

				quemados[i] = false;

				barcos [i] = new Barco(i,"Barco" + i);

				distanciaEspejo[i] = 0;

				for (int j=0; j<n; j++){

					distancias[i][j] = 0; //distancias default en 0
				}
			}
		}


		public int tamano(){
			return n;
		}


		public void asignarNombre(Integer ciudadID, String nombre){

			barcos[ciudadID].Nombre = nombre;
		}


		public void setDistIJ(int i, int j, int dist, boolean simetrico){

			distancias[i][j] = dist;

			if (simetrico){

			distancias[j][i] = dist;
			}
		}



		public void setDistEsp(int i, int dist){
			distanciaEspejo[i] = dist;
		}
			// distancias nominales


		public int getDistIJ(int i, int j){

			return distancias[i][j];
		}


		
		public void QuemarBarco (int posicionBarco){
			quemados[posicionBarco] = true;


			}

		public boolean todosQuemados(){
			boolean estanQuemados = true;
			for (int i = 0; i < this.quemados.length ; i++){
				estanQuemados = estanQuemados && quemados[i];
			}
			return estanQuemados;
		}


		public boolean estaQuemado(int posicionBarco){
			return quemados[posicionBarco];
		}
		
		public void limpiarQuemados(){
			for (int i=0; i<n; i++){
				quemados[i] = false;
			}
			
		}

		public ArrayList<Barco> caminoMinimoProbableA(){				//*****A*****

			ArrayList<Barco> ret = new ArrayList<Barco>();	
			int barcoActual = barcoCercaEspejo(this.distanciaEspejo);
			QuemarBarco(barcoActual);
			ret.add(this.barcos[barcoActual]);

			while (todosQuemados() == false){
			barcoActual = barcoMasCercano(barcoActual);
			QuemarBarco(barcoActual);
			ret.add(this.barcos[barcoActual]);
			
			}
			limpiarQuemados();
			return ret;
			
		}




		public ArrayList<Barco> caminoMinimoProbableB(){				//*****B*****

			ArrayList<Barco> ret = new ArrayList<Barco>();
			int barcoActual = barcoCercaEspejo(this.distanciaEspejo);
			QuemarBarco(barcoActual);
			ret.add(this.barcos[barcoActual]);

			while (todosQuemados() == false){
			barcoActual = barcoCercaEspejo(this.distanciaEspejo);
			QuemarBarco(barcoActual);
			ret.add(this.barcos[barcoActual]);
			
			}
			limpiarQuemados();
			return ret;
		}




		private int barcoMasCercano(Integer barcoOrigen){
				int barcoCercano = 0;
				int distanciaCercana = 0;
				for (int o= 0; o < this.distancias[0].length; o++){
					
					if ( distancias[barcoOrigen][o] > distanciaCercana){
						if (estaQuemado(o)==false){
							barcoCercano = o;
							distanciaCercana = distancias[barcoOrigen][o];							
						}						
					}
				}
			
				for (int i= 0; i < this.distancias[0].length; i++){
					if ( distancias[barcoOrigen][i] < distanciaCercana){
						if (estaQuemado(i)==false){
							barcoCercano = i;
							distanciaCercana = distancias[barcoOrigen][i];	
						}
					}
				}
			
			return barcoCercano;
		}

		int barcoCercaEspejo (int [] distanciasEspejo){
			int i=0;
			int barcoCercano = 0;
			int distanciaMenor = 0;
			
			while(i<distancias.length){
				if(distanciaMenor<distanciaEspejo[i]){
					if(estaQuemado(i)==false){
						distanciaMenor = distanciaEspejo[i]; 
						barcoCercano = i;
					}				
				}
				i++;
				
			}		
			
			for(int o = 0; o < distanciaEspejo.length; o++){
				if (distanciaEspejo[o]<distanciaMenor && estaQuemado(o) == false ){
					distanciaMenor = distanciaEspejo[o];
					barcoCercano = o;	
				}
			}

			return barcoCercano;
		}


		public Integer distancia(ArrayList<Barco> camino){

			Integer _distancia = 0;
			_distancia = distanciaEspejo[barcoCercaEspejo(this.distanciaEspejo)];
				for (int i=0;i< camino.size()-1;i++){
					
					_distancia = _distancia + distancias[camino.get(i).id][camino.get(i+1).id];  
				}
	
				return _distancia;
		}
	

}

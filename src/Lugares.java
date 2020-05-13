/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */
import java.util.Hashtable;

public class Lugares {
	
	private Hashtable<String, int[]> lugares;
	private Hashtable<String, Integer> nodos;
	private Hashtable<Integer, int[]> nodosUbicacion;
	private Hashtable<Integer, String> nombres;
	
	public Lugares() {		
		this.lugares = new Hashtable<String, int[]>();
						//Nombre del lugar y ubicacion(pixeles)
		this.lugares.put("Hard Rock Hotel", new int[] {473, 119});
		this.lugares.put("Cinepolis", new int[] {659, 70});
		this.lugares.put("Cancha de basketball", new int[]{965, 86});
		this.lugares.put("Construcción", new int[]{1152, 86});
		this.lugares.put("MetLife Building", new int[] {473, 278});
		this.lugares.put("7 Eleven", new int[] {639, 281});
		this.lugares.put("Hospital San Javier", new int[] {825, 260});
		this.lugares.put("Librerías Ghandi", new int[] {1016, 274});
		this.lugares.put("Los Tarascos", new int[] {1153, 263});
		this.lugares.put("Ishop", new int[] {466, 443});
		this.lugares.put("Farmacia", new int[] {671, 433});
		this.lugares.put("Mi Casa", new int[] {914, 422});
		this.lugares.put("Carls Jr", new int[] {1048, 425});
		this.lugares.put("Gasolinera", new int[] {522, 594});
		this.lugares.put("OXXO", new int[] {595, 590}); //628
		this.lugares.put("Tec de Monterrey", new int[] {676, 590});
		this.lugares.put("Costco", new int[] {926, 594});
		this.lugares.put("Parque", new int[] {1139, 588});
		this.lugares.put("Cajero Automático", new int[] {660, 706});
		
		
		this.nodos = new Hashtable<String, Integer>();
							//Nombre del nodo y el identificador del nodo
		this.nodos.put("Nodo 0", 0);
		this.nodos.put("Hard Rock Hotel", 1);
		this.nodos.put("Cinepolis", 2);
		this.nodos.put("Nodo 3", 3);
		this.nodos.put("Cancha de basketball", 4);
		this.nodos.put("Construcción", 5);
		this.nodos.put("Nodo 6", 6);
		this.nodos.put("Nodo 7", 7);
		this.nodos.put("MetLife Building", 8);
		this.nodos.put("7 Eleven", 9);
		this.nodos.put("Hospital San Javier", 10);
		this.nodos.put("Librerías Ghandi", 11);
		this.nodos.put("Los Tarascos", 12);
		this.nodos.put("Nodo 13", 13);
		this.nodos.put("Ishop", 14);
		this.nodos.put("Farmacia", 15);
		this.nodos.put("Mi Casa", 16);
		this.nodos.put("Carls Jr", 17);
		this.nodos.put("Nodo 18", 18);
		this.nodos.put("Nodo 19", 19);
		this.nodos.put("Gasolinera", 20);
		this.nodos.put("OXXO", 21);
		this.nodos.put("Tec de Monterrey", 22);
		this.nodos.put("Costco", 23);
		this.nodos.put("Parque", 24);
		this.nodos.put("Nodo 25", 25);
		this.nodos.put("Cajero Automático", 26);
		this.nodos.put("Nodo 27", 27);
		
		
		this.nodosUbicacion = new Hashtable<Integer, int[]>();
		this.nodosUbicacion.put(0, new int[] {317,99});
		this.nodosUbicacion.put(1, new int[] {473,119});
		this.nodosUbicacion.put(2, new int[] {659,100}); //70
		this.nodosUbicacion.put(3, new int[] {652,6});
		this.nodosUbicacion.put(4, new int[] {965,86});
		this.nodosUbicacion.put(5, new int[] {1152,86});
		this.nodosUbicacion.put(6, new int[] {1200,107});
		this.nodosUbicacion.put(7, new int[] {319,261});
		this.nodosUbicacion.put(8, new int[] {473,278});
		this.nodosUbicacion.put(9, new int[] {639,281});
		this.nodosUbicacion.put(10, new int[] {825,260});
		this.nodosUbicacion.put(11, new int[] {1016,274});
		this.nodosUbicacion.put(12, new int[] {1153,263});
		this.nodosUbicacion.put(13, new int[] {312,421});
		this.nodosUbicacion.put(14, new int[] {460,443});
		this.nodosUbicacion.put(15, new int[] {671,433});
		this.nodosUbicacion.put(16, new int[] {914,422});
		this.nodosUbicacion.put(17, new int[] {1048,425});
		this.nodosUbicacion.put(18, new int[] {1155,423});
		this.nodosUbicacion.put(19, new int[] {312,589});
		this.nodosUbicacion.put(20, new int[] {522,594});
		this.nodosUbicacion.put(21, new int[] {652, 584});
		this.nodosUbicacion.put(22, new int[] {663,574});
		this.nodosUbicacion.put(23, new int[] {926,594});
		this.nodosUbicacion.put(24, new int[] {1139, 588});
		this.nodosUbicacion.put(25, new int[] {1175,570});
		this.nodosUbicacion.put(26, new int[] {657,725});
		this.nodosUbicacion.put(27, new int[] {1175,725});
		
		
		
			this.nombres = new Hashtable<Integer, String>();
			//Nombre del nodo y el identificador del nodo
			this.nombres.put(0, "Nodo 0");
			this.nombres.put(1, "Hard Rock Hotel");
			this.nombres.put(2, "Cinepolis");
			this.nombres.put(3, "Nodo 3");
			this.nombres.put(4, "Cancha de basketball");
			this.nombres.put(5, "Construcción");
			this.nombres.put(6, "Nodo 6");
			this.nombres.put(7, "Nodo 7");
			this.nombres.put(8, "MetLife Building");
			this.nombres.put(9, "7 Eleven");
			this.nombres.put(10, "Hospital San Javier");
			this.nombres.put(11, "Librerías Ghandi");
			this.nombres.put(12, "Los Tarascos");
			this.nombres.put(13, "Nodo 13");
			this.nombres.put(14, "Ishop");
			this.nombres.put(15, "Farmacia");
			this.nombres.put(16, "Mi Casa");
			this.nombres.put(17, "Carls Jr");
			this.nombres.put(18, "Nodo 18");
			this.nombres.put(19, "Nodo 19");
			this.nombres.put(20, "Gasolinera");
			this.nombres.put(21, "OXXO");
			this.nombres.put(22, "Tec de Monterrey");
			this.nombres.put(23, "Costco");
			this.nombres.put(24, "Parque");
			this.nombres.put(25, "Nodo 25");
			this.nombres.put(26, "Cajero Automático");
			this.nombres.put(27, "Nodo 27");
		
		
		
		
	}
	
	//Metood que regresa la ubicacion(pixeles) del lugar
	public int[] cordenadas(String lugar) {
		return this.lugares.get(lugar);
	}
	
	public int nodos(String lugar) {
		return this.nodos.get(lugar);
	}
	
	public int[] nodosUbicacion(Integer lugar) {
		return this.nodosUbicacion.get(lugar);
	}
	
	public String nombres(Integer lugar) {
		return this.nombres.get(lugar);
	}
	
	public Hashtable<String, int[]> getLugares() {
		return this.lugares;
	}
}

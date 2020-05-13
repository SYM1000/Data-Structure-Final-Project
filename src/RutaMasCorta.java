/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class RutaMasCorta {

	private Queue<Integer> ruta;
	private int n;
	private ArrayList<LinkedList<NodoConexion<Integer>>> listaAdyacencia;
	private String archivo = "conexiones.txt";
	private Lugares lugares;
	
	public RutaMasCorta() {
		this.ruta = new LinkedList<Integer>();
		this.listaAdyacencia = new ArrayList<LinkedList<NodoConexion<Integer>>>();
		this.lugares =  new Lugares();
		leerArchivo();
	}
	
	//Metodo para leer el archivo y crear la lista de adyacencia
	public void leerArchivo() {
		
		String linea = null;
		try {
			String[] arreglo;
			FileReader fileReader = new FileReader(this.archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//Leer el archivo
			int cont = 0;
			while((linea = bufferedReader.readLine()) != null) {
				LinkedList<NodoConexion<Integer>> listaLigada = new LinkedList<NodoConexion<Integer>>();
                arreglo = linea.split(" ");    
                for (int i = 0; i < arreglo.length; i++) {
                	
                	int costo = Integer.parseInt(arreglo[i]);
                	if(costo > 0) {
                		NodoConexion<Integer> conexion = new NodoConexion<Integer>((i), costo);
                		listaLigada.add(conexion);
                		
                		//System.out.println("Valor diferente de 0");
                		//System.out.println("el nodo " + (cont) + " se conecta con el nodo " + conexion.getIdentificador() + " con un costo de " + conexion.getCosto());
                		//System.out.println();	
                	}else {
                		continue;
                	}			
				}
               cont++;
               this.listaAdyacencia.add(listaLigada);
            }
			this.n = cont;
			bufferedReader.close();
			
			//System.out.println("Se completó con exito la creacion");
			//System.out.println(this.n);
			
		}catch (FileNotFoundException e) {
			//System.out.println("No se pudo encontrar el archivo: " + this.archivo);
			JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo: " + this.archivo);
			
		}catch (IOException error) {
			//System.out.println("Error al abrir el archivo");
			JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
			error.printStackTrace();
		}	
	}
	
	//Metodo para ver las conexiones
	public void imprimirConexiones() {
		for (int i = 0; i < this.listaAdyacencia.size(); i++) {
			for (int j = 0; j < this.listaAdyacencia.get(i).size(); j++) {
				System.out.println("el nodo " + (i) + " se conecta con el nodo " + this.listaAdyacencia.get(i).get(j).getIdentificador() + " con un costo de "  + this.listaAdyacencia.get(i).get(j).getCosto());
			}
		}
	}
	
	//Algoritmo de dijkstra
		public void rutaMasCorta(int inicio, int fini) {
			int[] pesoConexiones = new int[this.n];
			boolean[] encontrado = new boolean[this.n];
			Queue<Integer>[] rutas = (Queue<Integer>[]) new LinkedList[this.n];
			this.ruta.clear(); //Limpiar la ruta			
			
			for (int i = 0; i < this.n; i++) {
				pesoConexiones[i] = Integer.MAX_VALUE;
				encontrado[i] = false;
				rutas[i] = new LinkedList<Integer>();
			}
			
			pesoConexiones[inicio] = 0;
			encontrado[inicio] = true;
			rutas[inicio].add(inicio);
			
			for (int i = 0; i < listaAdyacencia.get(inicio).size(); i++) {
				int pos = listaAdyacencia.get(inicio).get(i).getIdentificador();
				int costo = listaAdyacencia.get(inicio).get(i).getCosto();
				pesoConexiones[pos] = costo;
				rutas[pos].add(inicio);
				rutas[pos].add(pos);
			}
			
			int min = minDistancia(pesoConexiones, encontrado);
			if (min == fini) {
				encontrado[fini] = true;
			}
			
			while(encontrado[fini] == false) {
				int menor = minDistancia(pesoConexiones, encontrado);
				encontrado[menor] = true;
				
				if(menor == fini) {
					break;
				}
				
				for (int i = 0; i < this.listaAdyacencia.get(menor).size(); i++) {
					int nodo = this.listaAdyacencia.get(menor).get(i).getIdentificador();
					int costo = this.listaAdyacencia.get(menor).get(i).getCosto();
					
					int nuevoCosto = costo + pesoConexiones[menor];
					
					if(nuevoCosto < pesoConexiones[nodo] && encontrado[nodo] == false ) { //
						pesoConexiones[nodo] = nuevoCosto;
						int n = rutas[menor].size();
						rutas[nodo].clear(); //Si se encuentra una ruta mas rapida, se borra la que ya se tenía
						for (int j = 0; j< n; j++){
							int v = rutas[menor].poll();
							rutas[nodo].add(v);
							rutas[menor].add(v);
						}
						
						rutas[nodo].add(nodo);
					}
				}
			}
			
			//System.out.println("el costo final es de :" + pesoConexiones[fini]);
			this.ruta = rutas[fini];
			
			if(pesoConexiones[fini] < 0 || pesoConexiones[fini] == Integer.MAX_VALUE) {
				JOptionPane.showMessageDialog(null, "No se puede llegar desde " + lugares.nombres(inicio) +  " a " + lugares.nombres(fini));
				this.ruta.clear();
			}
		}
		
		
		public int minDistancia(int costos[], boolean[] encontrado) {
			int min = Integer.MAX_VALUE, 
			    index = -1;
			
			for(int i = 0; i<costos.length ; i++) {
				if(encontrado[i] == false && costos[i] <= min) {
					 min = costos[i];
					 index = i;
				}
			}
			if(index < 0) {
				JOptionPane.showMessageDialog(null, "No se puede llegar");
			}
			return index;	
		}


		public Queue<Integer> getRuta() {
			return ruta;
		}


		public void setRuta(Queue<Integer> ruta) {
			this.ruta = ruta;
		}


		public int getN() {
			return n;
		}


		public void setN(int n) {
			this.n = n;
		}


		public ArrayList<LinkedList<NodoConexion<Integer>>> getListaAdyacencia() {
			return listaAdyacencia;
		}


		public void setListaAdyacencia(ArrayList<LinkedList<NodoConexion<Integer>>> listaAdyacencia) {
			this.listaAdyacencia = listaAdyacencia;
		}
		
		
		
		
		
}

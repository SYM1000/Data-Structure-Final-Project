/*
 * PROYECTO FINAL
 * Nombre: Santiago Yeomans
 * Matricula: A01251000
 */

import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Main {	
	
	//Atributos
	private VentanaPrincipal VentanaPrincipal;
	private int n;
	private ArrayList<LinkedList<NodoConexion<Integer>>> listaAdyacencia;
	private Lugares lugares;
	private RutaMasCorta algoritmo;
	
		
	//Constructor
	public Main() {
		this.lugares =  new Lugares();
		this.algoritmo = new RutaMasCorta();
		this.VentanaPrincipal = new VentanaPrincipal();
	}
	
	
	//Metodo Main
	public static void main(String[] args) {
		Main proyecto = new Main();
		proyecto.VentanaPrincipal.main(args);
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




//Clase nodo que almacena con que nodo se hace conexion y cual es el costo de esa conexion
	class NodoConexion<E extends Comparable<E>>{
		
		//Atributos
		 private final E Identificador;
		 private Integer Costo;
		 
		//Constructor
		public NodoConexion(E Id, Integer costo) {
			super();
			this.Identificador = Id;
			this.Costo = costo;
		}

		//Metodos
		public Integer getCosto() {
			return Costo;
		}

		public void setCosto(Integer costo) {
			Costo = costo;
		}

		public E getIdentificador() {
			return Identificador;
		}	
		
		
		
	}
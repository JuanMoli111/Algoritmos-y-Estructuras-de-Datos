package TP3;

import TP2.ListaEnlazadaGenerica;
import TP2.ListaGenerica;

public class ArbolBinario<T> {
	
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}


	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el árbol en preorden  
	public void printPreorden() {
		System.out.println(this.getDato() + " ");
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
	
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
		
	}

	// imprime el arbol en inorden
	public void printInorden() {
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printInorden();
			
		System.out.println(this.getDato() + " ");

		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printInorden();

	}

	// imprime el arbol en postorden
	public void printPostorden() {
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostorden();
	
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPostorden();

		System.out.println(this.getDato() + " ");

	}


	public void recorridoPorNiveles() {
		
	}



	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	
	
	public int contarHojas() {




		return 0;
	}

	

}

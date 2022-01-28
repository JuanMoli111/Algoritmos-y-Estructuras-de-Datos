package TP6.GrafoCatedra;

/**
 * Representa una Vertice de un grafo.
 * 
 * @author juan
 *
 */
public interface Vertice<T> {
	
	public T getDato();
	public void setDato(T dato);
	public int getPosicion();

}

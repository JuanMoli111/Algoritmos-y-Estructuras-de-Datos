package TP6.GrafoCatedra;

/**
 * Representa una arista de un {@link Grafo} 
 * 
 * @author juan
 *
 */
public interface Arista<T> {
	
	public Vertice<T> getVerticeDestino();
	public int getPeso();

}

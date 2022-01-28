package TP6.GrafoCatedra;


public class AristaImpl<T> implements Arista<T> {
	private Vertice<T> destino;
	private int peso;
	
	public AristaImpl(Vertice<T> dest, int p){
		destino = dest;
		peso = p;
	}
	
	@Override
	public Vertice<T> getVerticeDestino() {
		return destino;
	}

	@Override
	public int getPeso() {
		return peso;
	}

	//hacer los setters
}

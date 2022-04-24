package Cursada2022.TP1.EJ5;

public class Data{
    int max, min;
    double prom;

    public Data(){}
    
    public Data(int max, int min, double prom) {
        this.max = max;
        this.min = min;
        this.prom = prom;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }

    public String toString(){
        return "Max: " + this.getMax() + " Min: " + this.getMin() + " Prom: " + this.getProm();
    }
}

package material_profe;

public class NodoAB {
    private int info;
    private ArbolB izquierdo;
    private ArbolB derecho;

    public NodoAB(int info) {
        this.info = info;
        this.izquierdo = new ArbolB();
        this.derecho = new ArbolB();
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    public ArbolB getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(ArbolB izquierdo) {
        this.izquierdo = izquierdo;
    }
    public ArbolB getDerecho() {
        return derecho;
    }
    public void setDerecho(ArbolB derecho) {
        this.derecho = derecho;
    }
    
        
}

package Interfaces;

public interface I_Conjunto {
    void inicialzarConjunto();
    void agregar(int x);
    void eliminar(int x);
    int elegir();
    boolean pertenece(int x);
    void vaciar();
    boolean estavacio();
    int largo();
}


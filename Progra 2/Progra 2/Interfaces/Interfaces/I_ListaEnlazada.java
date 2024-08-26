package Interfaces;

public interface I_ListaEnlazada {
    boolean estaVacia();

    void vaciar();

    int largo();

    boolean pertenece(int val);

    void InicializarLista();
    
    void Agregar(int x);

    void eliminar(int x);
    
}
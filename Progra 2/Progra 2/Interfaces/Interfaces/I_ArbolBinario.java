package Interfaces;

import Logica.ArbolBinario;

public interface I_ArbolBinario {

    boolean estaVacio();
    void inicializarArbol();
    ArbolBinario hijoIzquierdo();
    ArbolBinario hijoDerecho();
    int raiz();
    void agregar(int x);
    void eliminar(int x);
    
}
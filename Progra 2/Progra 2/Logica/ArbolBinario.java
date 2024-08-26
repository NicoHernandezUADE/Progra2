package Logica;

public class ArbolBinario implements Interfaces.I_ArbolBinario{

    int contenido;
    NodoABB hijoIzq;
    NodoABB hijoDer;

    class NodoABB{
        int contenido;
        ArbolBinario hijoIzq;
        ArbolBinario hijoDer;
    }

    @Override
    public boolean estaVacio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaVacio'");
    }

    @Override
    public void inicializarArbol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inicializarArbol'");
    }

    @Override
    public ArbolBinario hijoIzquierdo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hijoIzquierdo'");
    }

    @Override
    public ArbolBinario hijoDerecho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hijoDerecho'");
    }

    @Override
    public int raiz() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'raiz'");
    }

    @Override
    public void agregar(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public void eliminar(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    public int Suma(ArbolBinario arbol){
        if(this.estaVacio()){
            return 0;
        }else{
            return this.contenido + Suma(this.hijoIzquierdo()) + Suma(this.hijoDerecho());
        }
    }
    
}

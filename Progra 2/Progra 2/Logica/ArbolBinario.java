package Logica;

public class ArbolBinario implements Interfaces.I_ArbolBinario{

    
    class NodoABB{
        int contenido;
        ArbolBinario hijoIzq;
        ArbolBinario hijoDer;

        NodoABB(int contenido){
            this.contenido = contenido;
            this.hijoIzq = new ArbolBinario();
            this.hijoDer = new ArbolBinario();
        }
    }

    NodoABB raiz;

    public ArbolBinario(){
        this.inicializarArbol();
    }

    @Override
    public boolean estaVacio() {
        // TODO Auto-generated method stub
        return this.raiz == null;
    }

    @Override
    public void inicializarArbol() {
        // TODO Auto-generated method stub
        this.raiz = null;
    }

    @Override
    public int raiz(){
        return this.raiz.contenido;
    }
    @Override
    public ArbolBinario hijoIzquierdo() {
        // TODO Auto-generated method stub
        return this.raiz.hijoIzq;
    }

    @Override
    public ArbolBinario hijoDerecho() {
        // TODO Auto-generated method stub
        return this.raiz.hijoDer;
    }

    @Override
    public void agregar(int valor) {
        if (this.estaVacio()) {
            this.raiz = new NodoABB(valor);
        } else {
            agregarRecursivo(this.raiz, valor);
        }
    }

    private void agregarRecursivo(NodoABB nodo, int valor) {
        if (valor < nodo.contenido) {
            if (nodo.hijoIzq.estaVacio()) {
                nodo.hijoIzq.raiz = new NodoABB(valor);
            } else {
                agregarRecursivo(nodo.hijoIzq.raiz, valor);
            }
        } else if (valor > nodo.contenido) {
            if (nodo.hijoDer.estaVacio()) {
                nodo.hijoDer.raiz = new NodoABB(valor);
            } else {
                agregarRecursivo(nodo.hijoDer.raiz, valor);
            }
        }
    }


    public void eliminar(int valor) {
        this.raiz = eliminarRecursivo(this.raiz, valor);
    }

    private NodoABB eliminarRecursivo(NodoABB nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.contenido) {
            nodo.hijoIzq.raiz = eliminarRecursivo(nodo.hijoIzq.raiz, valor);
        } else if (valor > nodo.contenido) {
            nodo.hijoDer.raiz = eliminarRecursivo(nodo.hijoDer.raiz, valor);
        } else {
            // Caso 1: Nodo hoja
            if (nodo.hijoIzq.estaVacio() && nodo.hijoDer.estaVacio()) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo
            if (nodo.hijoIzq.estaVacio()) {
                return nodo.hijoDer.raiz;
            } else if (nodo.hijoDer.estaVacio()) {
                return nodo.hijoIzq.raiz;
            }
            // Caso 3: Nodo con dos hijos
            nodo.contenido = encontrarMinimo(nodo.hijoDer.raiz).contenido;
            nodo.hijoDer.raiz = eliminarRecursivo(nodo.hijoDer.raiz, nodo.contenido);
        }
        return nodo;
    }

    public int Suma(ArbolBinario arbol) {
        if (arbol.estaVacio()) {
            return 0;
        } else {
            return arbol.raiz() + Suma(arbol.hijoIzquierdo()) + Suma(arbol.hijoDerecho());
        }
    }

    // Metodos privados
    
    private int mayor(ArbolBinario arbol){
        if(arbol.hijoDerecho().estaVacio()){
            return arbol.raiz();
        }else{
            return mayor(arbol.hijoDerecho());
        }
    }

    private NodoABB encontrarMinimo(NodoABB nodo) {
        while (nodo.hijoIzq.raiz != null) {
            nodo = nodo.hijoIzq.raiz;
        }
        return nodo;
    }

    public ListaEnlazada almacenarHojas() {
        ListaEnlazada listaHojas = new ListaEnlazada();
        if (!this.estaVacio()) {
            almacenarHojasRecursivo(this.raiz, listaHojas);
        } else {
            System.out.println("El arbol esta vacio");
        }
        return listaHojas;
    }
    
    private void almacenarHojasRecursivo(NodoABB nodo, ListaEnlazada lista) {
        if (nodo == null) {
            return;
        }
        if (nodo.hijoIzq.estaVacio() && nodo.hijoDer.estaVacio()) {
            lista.Agregar(nodo.contenido); // Asumiendo que ListaEnlazada tiene un método agregar
        } else {
            almacenarHojasRecursivo(nodo.hijoIzq.raiz, lista);
            almacenarHojasRecursivo(nodo.hijoDer.raiz, lista);
        }
    }
    // Recorridos
    public void preOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            System.out.println(arbol.raiz());
            preOrder(arbol.hijoIzquierdo());
            preOrder(arbol.hijoDerecho());
        }
    }

    public void inOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            inOrder(arbol.hijoIzquierdo());
            System.out.println(arbol.raiz());
            inOrder(arbol.hijoDerecho());
        }
    }

    public void postOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            postOrder(arbol.hijoIzquierdo());
            postOrder(arbol.hijoDerecho());
            System.out.println(arbol.raiz());
        }
    }

}

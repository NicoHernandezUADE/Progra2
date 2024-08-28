package Logica;

public class ArbolBinario implements Interfaces.I_ArbolBinario{

    
    class NodoABB{
        int contenido;
        ArbolBinario hijoIzq;
        ArbolBinario hijoDer;
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
    public void agregar(int x) {
        // TODO Auto-generated method stub
        if (this.raiz == null) {
            this.raiz = new NodoABB();
            this.raiz.contenido = x;
        }else{
            if (x < this.raiz.contenido) {
                this.raiz.hijoIzq = agregar(this.raiz.hijoIzq,x);
            }else if (x > this.raiz.contenido) {
                this.raiz.hijoDer = agregar(this.raiz.hijoDer,x);
            }
        }
    }
    
    private NodoABB agregar(NodoABB nodo, int x) {
        if (nodo == null) {
            NodoABB nuevoNodo = new NodoABB();
            nuevoNodo.contenido = x;
            return nuevoNodo;
        } else if (x < nodo.contenido) {
            nodo.hijoIzq = agregar(nodo.hijoIzq, x);
        } else if (x > nodo.contenido) {
            nodo.hijoDer = agregar(nodo.hijoDer, x);
        }
        return nodo;
    }

   /*@Override
    public void eliminar(int x) {
        // TODO Auto-generated method stub
        if(this.raiz != null){ // verificar que no este vacio
            if(this.raiz.contenido == x && this.raiz.hijoIzq.estaVacio() && this.raiz.hijoDer.estaVacio()){
                this.raiz = null;
            }else if (this.raiz.contenido == x && !this.raiz.hijoIzq.estaVacio()) { // si podemos reemplazamos con el mayor de la izq
                this.raiz.contenido = this.mayor(this.raiz.hijoIzq);
                this.raiz.hijoIzq.eliminar(raiz.contenido);
            }else if(raiz.contenido == x && raiz.hijoIzq.estaVacio()){ // entonces buscamos por la derecha
                raiz.contenido = this.menor(raiz.hijoDer);
                raiz.hijoDer.eliminar(raiz.contenido);
            }else if (raiz.contenido < x) {
                raiz.hijoDer.eliminar(x); // buscamos por la derecha
            }else{
                raiz.hijoIzq.eliminar(x); // buscamos por la izquierda
            }
        }
    }*/

    @Override
    public void eliminar(int x){
        this.raiz = eliminar(this.raiz,x);
    }

    private NodoABB eliminar(NodoABB nodo, int x) {
        if (nodo == null) return null;

        if (x < nodo.contenido) {
            nodo.hijoIzq = eliminar(nodo.hijoIzq, x);
        } else if (x > nodo.contenido) {
            nodo.hijoDer = eliminar(nodo.hijoDer, x);
        } else {
            // Caso 1: Nodo con un solo hijo o sin hijos
            if (nodo.hijoIzq == null) return nodo.hijoDer;
            if (nodo.hijoDer == null) return nodo.hijoIzq;

            // Caso 2: Nodo con dos hijos
            nodo.contenido = menor(nodo.hijoDer);
            nodo.hijoDer = eliminar(nodo.hijoDer, nodo.contenido);
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

    private int menor(ArbolBinario arbol){
        if(arbol.hijoIzquierdo().estaVacio()){
            return arbol.raiz();
        }else{
            return menor(arbol.hijoIzquierdo());
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

package material_profe;
public class ArbolB implements TDAArbol {
    NodoAB raiz ;

    public ArbolB() {
        this.InicializaArbol();
    }

    //Indica si el arbol está vacio
    public boolean EsVacio() {
        return (this.raiz == null);
    }

    //Crea un arbol vacio
    public void InicializaArbol() {
        this.raiz = null;
    }

    //Devuelve el sub-Arbol izquierdo
    public TDAArbol HijoIzquierdo() {
        return this.raiz.getIzquierdo();
    }

    //Devuelve el sub-Arbol derecho
    public TDAArbol HijoDerecho() {
        return this.raiz.getDerecho();
    }

    //Devuelve la raiz de un árbol, si es que existe.
    public int Raiz() {
        return this.raiz.getInfo();
    }

    // agrega un elemento x
    public void Agregar(int x) {
        if (this.EsVacio()) {
            this.raiz = new NodoAB(x);
        } else {
            if (x < this.Raiz()) {
                this.raiz.getIzquierdo().Agregar(x);
            } else {
                this.raiz.getDerecho().Agregar(x);
            }
        }
    }

    private boolean esHoja() {
        if (this.HijoIzquierdo().EsVacio() && this.HijoDerecho().EsVacio()) {
            return true;
        } else {
            return false;
        }

    }

    private int mayor(TDAArbol arbol) {
        if (arbol.HijoDerecho().EsVacio()) {
            return arbol.Raiz();
        } else {
            return mayor(arbol.HijoDerecho());
        }
    }

    private int menor(TDAArbol arbol) {
        if (arbol.HijoIzquierdo().EsVacio()) {
            return arbol.Raiz();
        } else {
            return menor(arbol.HijoIzquierdo());
        }
    }

    // elimina un elemento x    
    public void Eliminar(int x) {
        if (this.EsVacio()) {
            return;
        }
        if ((this.Raiz() == x) && this.esHoja()) {
            this.InicializaArbol();
        } else {
            if ((this.Raiz() == x) && this.HijoDerecho().EsVacio()) {
                int valorMayor = this.mayor(this.HijoIzquierdo());
                this.raiz.setInfo(valorMayor);
                this.HijoIzquierdo().Eliminar(valorMayor);
            }
            if (this.Raiz() == x) {
                int valorMenor = this.menor(this.HijoDerecho());
                this.raiz.setInfo(valorMenor);
                this.HijoDerecho().Eliminar(valorMenor);
            }
            if (this.Raiz() > x) {
                this.HijoIzquierdo().Eliminar(x);
            } else {
                this.HijoDerecho().Eliminar(x);
            }

        }
    }

    // Devuelve espacios, para estetica
    private String espacios(int n) {
        String salida = "";
        for (int i = 0; i < n*2; i++) {
            salida = salida + " ";
        }
        return salida;
    }

    /**
     *  Arbol (6, (2, ((1,5), 8) ), (8,,(9,,)))        
     * 
     * 6
     *   2
     *      1
     *      5
     *   8
     *      9
     */
    private String show(TDAArbol arbol, int profundidad)
    {
        if (arbol.EsVacio())        
        {
            return "";
        }

        String salida = this.espacios(profundidad);

        salida += arbol.Raiz() + "\n";
        salida += show(arbol.HijoIzquierdo(), profundidad+1);
        salida += show(arbol.HijoDerecho(), profundidad+1);
        return salida;
    }  

    public String toString() {
        String salida = this.show(this, 0);

        return salida;
    }
}

package Logica;

public class DiccionarioMultiple {
    public Elemento[] elementos;
    public int cantidadElementos;
    public class Elemento{
        public int clave;
        public ListaEnlazada valores;
    }

    public DiccionarioMultiple(){
        this.elementos = new Elemento[100];
        this.cantidadElementos = 0;
    }

    public void AgregarClave(int clave){
        Elemento nuevoElemento = new Elemento();
        nuevoElemento.clave = clave;
        nuevoElemento.valores = new ListaEnlazada();
        this.elementos[this.cantidadElementos] = nuevoElemento;
        this.cantidadElementos++;
    }

    public void AgregarValor(int clave, int valor){
        for (int i = 0; i < this.cantidadElementos; i++) {
            if(this.elementos[i].clave == clave){
                this.elementos[i].valores.Agregar(valor);
            }
        }
    }

    public void ObtenerValores(int clave){
        for (int i = 0; i < this.cantidadElementos; i++) {
            if(this.elementos[i].clave == clave){
                System.out.println(this.elementos[i].valores.toString());
                return;
            }
        }
    }

    public void eliminarClave(int clave){
        for (int i = 0; i < this.cantidadElementos; i++) {
            if(this.elementos[i].clave == clave){
                this.elementos[i] = this.elementos[this.cantidadElementos - 1];
                this.cantidadElementos--;
                return;
            }
        }
    }

    public void eliminarValor(int clave, int valor){
        for (int i = 0; i < this.cantidadElementos; i++) {
            if(this.elementos[i].clave == clave){
                this.elementos[i].valores.eliminar(valor);
                if (elementos[i].valores.largo == 0) {
                    this.eliminarClave(clave);
                }
                return;
            }
        }
    }

    public boolean pertenceClave(int clave){
        for (int i = 0; i < this.cantidadElementos; i++) {
            if(this.elementos[i].clave == clave){
                return true;
            }
        }
        return false;
    }

    public void agregarElemento(Elemento elem){
        this.elementos[this.cantidadElementos] = elem;
        this.cantidadElementos++;
    }
}

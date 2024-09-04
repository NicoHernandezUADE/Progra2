package Logica;

public class GrafoEstDinamica implements Interfaces.I_Grafo {

    public class NodoGrafo {
        int valor;
        NodoArista arista;
        NodoGrafo siguienteNodo;   
    }

    public class NodoArista {
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista siguienteArista;
    }

    NodoGrafo origen;

    @Override
    public void InicializarGrafo() {
        // TODO Auto-generated method stub
        this.origen = null;
    }

    @Override
    public void AgregarVertice(int v) {
        // TODO Auto-generated method stub
        NodoGrafo aux = new NodoGrafo();
        aux.valor = v;
        aux.arista = null;
        aux.siguienteNodo = this.origen;
        origen = aux;
    }

    @Override
    public void EliminarVertice(int v) {
        // TODO Auto-generated method stub
        if (origen.valor == v) {
            origen = origen.siguienteNodo;
        }

        NodoGrafo aux = origen;
        while (aux != null) {
            this.EliminarAristaNodo(aux, v);

            if (aux.siguienteNodo != null && aux.siguienteNodo.valor == v) {
                aux.siguienteNodo = aux.siguienteNodo.siguienteNodo;
            }
            aux = aux.siguienteNodo;
        }
    }

    private void EliminarAristaNodo(NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;

        if (aux != null) {
            
            if (aux.nodoDestino.valor == v) {
                nodo.arista = aux.siguienteArista;
            }
            else{
                while (aux.siguienteArista != null && aux.siguienteArista.nodoDestino.valor != v) {
                    aux = aux.siguienteArista;
                }
                if (aux.siguienteArista != null) {
                    aux.siguienteArista = aux.siguienteArista.siguienteArista;
                }
            }
        }
    }

    @Override
    public Conjunto Vertices() {
        // TODO Auto-generated method stub
        Conjunto vertices = new Conjunto();
        NodoGrafo aux = origen;
        while(aux != null){
            vertices.agregar(aux.valor);
            aux = aux.siguienteNodo;
        }
        return vertices;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        // TODO Auto-generated method stub
        NodoGrafo vert1 = Vert2Nodo(v1);
        NodoGrafo vert2 = Vert2Nodo(v1);
        
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = vert2;
        aux.siguienteArista = vert1.arista;
        vert1.arista = aux;
    }

    private NodoGrafo Vert2Nodo(int v){
        NodoGrafo aux = origen;
        while (aux != null && aux.valor != v) {
            aux = aux.siguienteNodo;
        }
        return aux;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        // TODO Auto-generated method stub
        NodoGrafo vert1 = Vert2Nodo(v1);
        EliminarAristaNodo(vert1, v2);
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        // TODO Auto-generated method stub
        NodoGrafo vert1 = Vert2Nodo(v1);

        if (vert1 == null) {
            return false; // Si el vértice no existe, la arista no puede existir
        }

        NodoArista aux = vert1.arista;
        while (aux != null && aux.nodoDestino.valor != v2) {
            aux = aux.siguienteArista;
        }

        return aux != null; // si se encontro la arista, aux no es null
    }

    @Override
    public int PesoArista(int v1, int v2) {
        // TODO Auto-generated method stub
        NodoGrafo vert1 = Vert2Nodo(v1);

        NodoArista aux = vert1.arista;
        while (aux.nodoDestino.valor != v2) {
            aux = aux.siguienteArista;
        }

        return aux.etiqueta;
    }
    
}

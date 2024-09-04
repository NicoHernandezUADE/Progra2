package Logica;


public class GrafoEstEstatica implements Interfaces.I_Grafo{

    static int n = 100;
    int [][] matAdy;
    int [] etiqs;
    int cantNodos;

    @Override
    public void InicializarGrafo() {
        // TODO Auto-generated method stub
        this.matAdy = new int[n][n];
        this.etiqs = new int[n];
        this.cantNodos = 0;
    }

    @Override
    public void AgregarVertice(int v) {
        // TODO Auto-generated method stub
        this.etiqs[this.cantNodos] = v;
        for(int i=0; i<= this.cantNodos;i++){
            this.matAdy[this.cantNodos][i] = 0;
            this.matAdy[i][this.cantNodos] = 0;
        }
        cantNodos++;
    }

    @Override
    public void EliminarVertice(int v) {
        // TODO Auto-generated method stub
        int pos = Vert2Indice(v);

        for(int i=0; i < this.cantNodos; i++){
            this.matAdy[i][pos] = this.matAdy[i][this.cantNodos-1];
        }
        for(int i=0; i < this.cantNodos; i++){
            this.matAdy[pos][i] = this.matAdy[this.cantNodos-1][i];
        }
    }

    private int Vert2Indice(int v){
        int i = this.cantNodos - 1;
        while (i >= 0 && etiqs[i] != v) {
            i--;
        }   
        return i;
    }

    @Override
    public Conjunto Vertices() {
        // TODO Auto-generated method stub
        Conjunto vertices = new Conjunto();
        
        for(int i=0; i<this.cantNodos;i++){
            vertices.agregar(this.etiqs[i]);
        }

        return vertices;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        // TODO Auto-generated method stub
        int origen = Vert2Indice(v1);
        int destino = Vert2Indice(v2);
        matAdy[origen][destino] = peso;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        // TODO Auto-generated method stub
        if (!ExisteArista(v1, v2)) {
            System.out.println("No existe la arista de la que se desea eliminar");
            return;
        }

        int origen = Vert2Indice(v1);
        int destino = Vert2Indice(v2);
        matAdy[origen][destino] = 0;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        // TODO Auto-generated method stub
        int origen = Vert2Indice(v1);
        int destino = Vert2Indice(v2);
        return matAdy[origen][destino] != 0;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        // TODO Auto-generated method stub
        int origen = Vert2Indice(v1);
        int destino = Vert2Indice(v2);

        if (ExisteArista(v1, v2)) {
            return matAdy[origen][destino];
        }else
            System.out.println("No existe la arista de la que se desea obtener el peso");
            return 0;
        
    }
    
}

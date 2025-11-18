public class ListaEnlazada {
    //atributo
    private Nodo cabeza;

    
    //constructor
    public ListaEnlazada(){
        this.cabeza = null;
    }

    //metodos propios
    public void agregarPrimero(Object dato){
        //nuevo es un nodo auxiliar
        Nodo nuevo = new Nodo(dato);
      
        nuevo.setSiguiente(this.cabeza);
        
        this.cabeza = nuevo;
      
    }

    public boolean estaVacia(){
        
        return this.cabeza == null;
        
    }

    public void mostrarLista(){
        
       //copia de la cabeza
        Nodo actual = this.cabeza;

       while(actual != null){
        System.out.print(" "+ actual.getDato() + " ->");
        actual = actual.getSiguiente();
       }

       if(estaVacia()){
            System.out.println("Lista vacia.");
        }
       System.out.print(" null");
       
    }

    public int contarElementos(){
        int cantidad = 0;
        Nodo actual = this.cabeza;
        while(actual != null){
            cantidad++;
            actual = actual.getSiguiente();
            
        }
        return cantidad;
    }

    public boolean existe(Object buscado){
        Nodo actual = this.cabeza;

        while(actual!=null){
            if(actual.getDato().equals(buscado)){
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void eliminar(Object eliminar){
        Nodo actual = this.cabeza;
        Nodo anterior = null;

        if(estaVacia()){
            System.out.println("No hay elementos");
            return;
        }
        if(!existe(eliminar)){
            System.out.println("no existe dicho elemento");
            return;
        }
        while(actual != null){
            if(actual.getDato().equals(eliminar)){
                //caso A: El nodo a eliminar es la CABEZA
                if(actual == this.cabeza){
                    this.cabeza = actual.getSiguiente();
                    return;
                }else{
                    anterior.setSiguiente(actual.getSiguiente());
                return;
                }
                
            }
            anterior = actual;
            actual = actual.getSiguiente();
            
        }
        
    }
}
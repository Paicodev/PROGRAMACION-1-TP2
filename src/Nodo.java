class Nodo{
    //atributos
    private Object dato;
    private Nodo siguiente;

    //constructores
    public Nodo(Object dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(Object dato, Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    

    //metodos gets y sets

    public Object getDato(){
        return this.dato;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente(){
        return this.siguiente;
    }


}
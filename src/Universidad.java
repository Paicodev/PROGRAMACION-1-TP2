public class Universidad {
    private String nombre;
    private String direccion;
    private ListaEnlazada miembros;
    
    // Constructor con parámetros
    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
         this.miembros = new ListaEnlazada();
        
    }

    public String getNombre(){
    return nombre;
    }
   
   public void setNombre(String nombre){
        if (nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

     public String getDireccion(){
    return direccion;
    }
   
   public void setDireccion(String direccion){
        if (direccion == null || direccion.isEmpty()){
            throw new IllegalArgumentException("La direccion no puede estar vacía");
        }
        this.direccion = direccion;
    }

    public void agregarMiembro(MiembroUniversidad miembro){
        
        this.miembros.agregarPrimero(miembro);
    }

    public void listarMiembros(){
        System.out.println("Miembros de la Universdiad: "+ nombre + " :");
        
        Nodo actual = miembros.getCabeza();

        while(actual != null){

            MiembroUniversidad m = (MiembroUniversidad) actual.getDato();
            System.out.println("Miembro: "+ m.obtenerInformacionCompleta());
            actual = actual.getSiguiente();
        }
    }

    public void listarEstudiantes(){
        System.out.println("Estudiantes de la Universdiad: "+ nombre + " :");
        
        Nodo actual = miembros.getCabeza();
        while(actual != null){
            Object dato = actual.getDato();
            if(dato instanceof Estudiante){
                Estudiante e = (Estudiante) dato;
                System.out.println("- "+ e.obtenerInformacionCompleta());
            }
            actual = actual.getSiguiente();
        }
    }

    public void buscarPorRol(String rolBuscado) {
        System.out.println("Buscando miembros con el rol de: "+ rolBuscado);
        
        Nodo actual = miembros.getCabeza();
        while(actual != null){
            MiembroUniversidad mu = (MiembroUniversidad) actual.getDato();

            if (mu.obtenerRol().equalsIgnoreCase(rolBuscado)){
                System.out.println(mu.obtenerInformacionCompleta());
            }
            actual = actual.getSiguiente();
        }
    }

    public Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice){
        if(indice >= estudiantes.length){
            return null;
        }
        if(estudiantes[indice].getDocumento().equals(documento)){
            return estudiantes[indice];
        }
        return buscarEstudianteRecursivo(estudiantes, documento, indice + 1);
    }

    public Estudiante buscarEstudianteIterativo(Estudiante[] estudiantes, String documento){
        for(int i = 0; i < estudiantes.length; i++){
            if(estudiantes[i].getDocumento().equals(documento)){
                return estudiantes[i];
            }
        }
        return null;
    }

    public Estudiante busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido){
        int izquierda = 0;
        int derecha = estudiantes.length - 1;

        while(izquierda <= derecha){
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = estudiantes[medio].getApellido().compareToIgnoreCase(apellido);

            if(comparacion == 0){
                return estudiantes[medio];
            }
            if(comparacion < 0){
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }

    public Persona buscarPorDocumento(String documento){
        Nodo actual = miembros.getCabeza();
        
        while(actual != null){
            if (actual.getDato() instanceof Persona){
                Persona p = (Persona) actual.getDato();
            if(p.getDocumento().equals(documento)){
                return p;
            }
        }
        actual = actual.getSiguiente();
    }
        return null;
    }

    public int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice){
        if(indice >= estudiantes.length){
            return 0;
        }
        int contador = 0;
        if(estudiantes[indice].getCarrera().equalsIgnoreCase(carrera)){
            contador = 1;
        }
        return contador + contarEstudiantesRecursivo(estudiantes, carrera, indice + 1);
    }

    public int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera){
        int contador = 0;
        for(int i = 0; i < estudiantes.length; i++){
            if(estudiantes[i].getCarrera().equalsIgnoreCase(carrera)){
                contador++;
            }
        }
        return contador;
    }

    public Estudiante[] getSoloEstudiantes(){
        int cont = 0;

        Nodo actual = miembros.getCabeza();

        while(actual != null){
            if( actual.getDato() instanceof Estudiante){
                cont++;
            } 
            actual= actual.getSiguiente();
        }


        Estudiante[] estudiantes = new Estudiante[cont];
        
        actual = miembros.getCabeza();
        int i = 0;
        while(actual!= null){
            if(actual.getDato() instanceof Estudiante){
                estudiantes[i] = (Estudiante) actual.getDato();
                i++;
            }
            actual = actual.getSiguiente();
        }

        return estudiantes;
    }

    public void ordenarEstudiantesPorApellido(Estudiante[] lista){
        
        int n = lista.length;

        if (n <= 1) return;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(lista[j].getApellido().compareToIgnoreCase(lista[j + 1].getApellido()) > 0){
                    Estudiante temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                    
                }
            }
        }
    }


}

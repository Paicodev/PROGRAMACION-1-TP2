public class Universidad {
    private String nombre;
    private String direccion;
    private MiembroUniversidad[] miembros;
    private int cantidadMiembros;
    private int indice;

    // Constructor con parámetros
    public Universidad(String nombre, String direccion, int capacidadMaxima) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.miembros = new MiembroUniversidad[capacidadMaxima];
        this.cantidadMiembros = 0;
        this.indice = 0;
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

    public boolean agregarMiembro(MiembroUniversidad miembro){
        if(cantidadMiembros < miembros.length){
            miembros[cantidadMiembros] = miembro;
            cantidadMiembros++;
            return true;
        }else {
            System.out.println("No se pueden agregar mas miembros. Capacidad máxima alcanzada");
            return false;
        }
    }

    public void listarMiembros(){
        System.out.println("Miembros de la Universdiad: "+ nombre + " :");
        for(int i = 0; i < miembros.length; i++){
            System.out.println("- "+ miembros[i].obtenerInformacionCompleta());
        }
    }

    public void listarEstudiantes(){
        System.out.println("Estudiantes de la Universdiad: "+ nombre + " :");
        for(int i = 0; i< cantidadMiembros; i++){
            if(miembros[i] instanceof Estudiante){
                System.out.println("- "+ miembros[i].obtenerInformacionCompleta());
            }
        }
    }

    public void buscarPorRol(String rolBuscado) {
        System.out.println("Buscando miembros con el rol de: "+ rolBuscado);
        for(int i = 0; i< cantidadMiembros; i++){
            if(miembros[i].obtenerRol().equalsIgnoreCase(rolBuscado)){
                System.out.println(miembros[i].obtenerInformacionCompleta());
            }
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
        for(int i = 0; i < miembros.length; i++){
            Persona p = (Persona) miembros[i];
            if(documento.equals(p.getDocumento())){
                return p;
            }
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

    public void ordenarEstudiantesPorApellido(){
        for(int i = 0; i < cantidadMiembros - 1; i++){
            for(int j = 0; j < cantidadMiembros - i - 1; j++){
                if(miembros[j] instanceof Estudiante && miembros[j + 1] instanceof Estudiante){
                    Estudiante e1 = (Estudiante) miembros[j];
                    Estudiante e2 = (Estudiante) miembros[j + 1];
                    if(e1.getApellido().compareToIgnoreCase(e2.getApellido()) > 0){
                        miembros[j] = e2;
                        miembros[j + 1] = e1;
                    }
                }
            }
        }
    }


}

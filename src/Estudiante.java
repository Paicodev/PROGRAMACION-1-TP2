public class Estudiante extends Persona implements MiembroUniversidad{
private String carrera;
private double promedio;
private ListaEnlazada materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, double promedio, ListaEnlazada materias){
        super(nombre, apellido, edad, documento);    
        this.carrera = carrera;
        this.promedio = promedio;
        //Inicializamos la lista vacía instanciandola al ser objeto, sino es null le asignamos la que viene por parametro
        if(materias == null){
            this.materias = new ListaEnlazada();
        } else {
            this.materias = materias;
        }
    }

    public Estudiante(){
        this.materias = new ListaEnlazada();
    }

    //Metodos Getters y Setters//

    public String getCarrera(){
        return this.carrera;
    }

    public void setCarrera(String carrera){
        if(carrera == null || carrera.isEmpty()){
            throw new IllegalArgumentException("");
        }
        this.carrera = carrera;
    }

    public double getPromedio(){
        return this.edad;
    }

    public void setPromedio(double promedio){
        if (promedio < 1 || promedio > 10){
            throw new IllegalArgumentException("El promedio debe ser de entre 1 y 10");
        }
        this.promedio = promedio;
    }

    //Devolvemos el objeto Lista completo (en este caso lista de materias)
    public ListaEnlazada getMaterias(){
        return this.materias;
    }

    //raramente se usa, porque es una lista nueva que reemplazaria todo.
    public void setMaterias(ListaEnlazada materias){
        this.materias = materias;
    }

    @Override
    public String obtenerRol(){
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta(){
        return toString();
    }

    //devolvia una suma, asi que no era un promedio.
        
        if (actual == null){
            return 0;
        }
        //2- Hacemos un Casting (convertirlo) para poder usar .getCalificacion() (esto no podia hacerlo con el nodo)
        Materia materiaActual = (Materia) actual.getDato();
        // Llamada recursiva: nota actual + suma del resto
        return materiaActual.getCalificacion() + calcularSumaRecursiva(actual.getSiguiente());
    }

    //Metodo que devuelve el promedio (suma / cantidad)
    public double calcularPromedioRecursivo(){
        int cantidad = materias.contarElementos();

        if(cantidad == 0) return 0;

        double sumaTotal = calcularSumaRecursiva(materias.getCabeza());
        this.promedio = sumaTotal / cantidad;
        return sumaTotal / cantidad;
    }
    public double calcularPromedioIterativo(){
        //
        //sale del if cuando las materias son nulas o no hay materias

        int cantidad = materias.contarElementos();

        if(cantidad == 0) return 0;

        double suma = 0;

        Nodo actual = materias.getCabeza();

        while (actual != null){
            Materia materiaActual = (Materia) actual.getDato();
            suma += materiaActual.getCalificacion();
            actual = actual.getSiguiente();
        }
        
        return suma / cantidad;
    }

    @Override
    public String toString(){
        return super.toString() + "- Carrera:"+ carrera + "- Promedio: "+ promedio;
    }
}

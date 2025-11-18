public class Materia {

private static int contadorId = 0;

    private int id;
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;
    private Profesor profesor;

// Constructor con parámetros
    public Materia(int id,String nombre, String codigo, int creditos, double calificacion, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
        this.profesor = profesor;
    }

    public Materia(){
        this.id = contadorId++;
    }
    //Getters y Setters//
    //Getters y Setters de nombre
    public int getId(){
        return id;
    }

    public String getNombre() { 
        return nombre;
     }
    public void setNombre(String nombre) {
         this.nombre = nombre; 
        }
    //Getters y Setters de codigo
    public String getCodigo() { 
        return codigo; 
    }
    public void setCodigo(String codigo) {
         this.codigo = codigo; 
        }
    //Getters y Setters de creditos
    public int getCreditos() {
         return creditos; 
    }
    public void setCreditos(int creditos) { 
        this.creditos = creditos;
     }
    //Getters y Setters de calificacion
    public double getCalificacion() { 
        return calificacion;
     }
    public void setCalificacion(double calificacion) {
         this.calificacion = calificacion; 
        }

    public Profesor getProfesor(){
        return profesor;
    }

    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }

     @Override
   public String toString(){
    return "Materia: [id: "+ id +", nombre: "+ nombre+ " codigo: "+ codigo +", creditos: "+ creditos + ", calificacion :"+ calificacion +", Profesor: "+ profesor.getNombre()+"]";
    };
    }

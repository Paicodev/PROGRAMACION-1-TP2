public class Estudiante extends Persona implements MiembroUniversidad{
String carrera;
double promedio;
Materia[] materias;

    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera, double promedio, Materia materias []){
        super(nombre, apellido, edad, documento);    
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = materias;
    }

    public Estudiante(){

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

    public Materia [] getMaterias(){
        return materias;
    }

    public void setMaterias(Materia[] materias){
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
    public double calcularSumaRecursiva(Materia[] materias,int indice){
        
        if (materias == null || indice >= materias.length){
            return 0;
        }
        // Llamada recursiva: nota actual + suma del resto
        return materias[indice].getCalificacion() + calcularSumaRecursiva(materias, indice +1 );
    }

    //Metodo que devuelve el promedio (suma / cantidad)
    public double calcularPromedioRecursivo(){
        if(materias == null || materias.length == 0) return 0;
        double sumaTotal = calcularSumaRecursiva(materias, 0);
        return sumaTotal / materias.length;
    }
    public double calcularPromedioIterativo(){
        //
        //sale del if cuando las materias son nulas o no hay materias
        if (materias == null || materias.length == 0){
            return 0;
        }
        double suma = 0;
        //recorre el array de materias y suma las calificaciones
        for (int i = 0; i < materias.length; i++){
            suma += materias[i].getCalificacion();
        }
        return suma / materias.length;
    }

    @Override
    public String toString(){
        return super.toString() + "- Carrera:"+ carrera + "- Promedio: "+ promedio;
    }
}

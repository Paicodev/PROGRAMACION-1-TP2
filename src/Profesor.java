public class Profesor extends Persona implements MiembroUniversidad{
    String especialidad;
    ListaEnlazada materiasAsignadas;
    int añosExperiencia;

    public Profesor(String nombre, String apellido, int edad,String documento, String especialidad, int añosExperiencia){
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
         this.materiasAsignadas = new ListaEnlazada();
    }

    public String getEspecialidad(){
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad){
        if (especialidad == null || especialidad.isEmpty()){
            throw new IllegalArgumentException("La especialidad no puede estar vacía");
       }
        this.especialidad = especialidad;
    }
    
    //Getter y Setter de Edad
    public int getAñosExperiencia(){
        return this.añosExperiencia;
    }

   
    public void setAñosExperiencia(int añosExperiencia){
        if (añosExperiencia < 0){
            throw new IllegalArgumentException("Los años de experiencia deben ser mayor a 0");
        }
        this.añosExperiencia = añosExperiencia;
    }

    //metodo para asignar materias que no devuelve nada
     public void AsignarMateria(Materia materia){
        
        this.materiasAsignadas.agregarPrimero(materia);
    } 

    @Override
    public String obtenerRol(){
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta(){
        return toString();
    }

    @Override
    public String toString() {
        return super.toString() + " - Especialidad: "+ especialidad +" - Experiencia "+ añosExperiencia + " años";
    }
}

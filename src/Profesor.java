public class Profesor extends Persona implements MiembroUniversidad{
    String especialidad;
    Materia materias[];
    int añosExperiencia;
    int materiasAsignadas;

    public Profesor(String nombre, String apellido, int edad,String documento, String especialidad, int añosExperiencia, int maxMaterias){
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.materias = new Materia[maxMaterias];
        this.materiasAsignadas = 0;
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

     public boolean AsignarMateria(Materia materia){
        if(materiasAsignadas < materias.length){
            materias[materiasAsignadas] = materia;
            materiasAsignadas++;
            return true;
        }else {
            System.out.println("No se pueden agregar mas materias. limite alcanzado");
            return false;
        }
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

public class App {
    public static void main(String[] args) throws Exception {
        Universidad uni = new Universidad("UNViMe", "Villa Mercedes", 5);

        Profesor profesor1 = new Profesor("Pablo", "Sosa", 45, "30111222", "Programacion", 20, 5);
        Personal personal1 = new Personal("Carla", "Alvarez", 35, "35777666", "Administracion", "Secretaria", "2019-03-15");
        Materia materia1 = new Materia(1,"Programacion 1", "PROG1", 4, 1, profesor1);
        Materia materia2 = new Materia(2,"Matematica 1", "MAT1", 4, 10, profesor1);

        Materia[] materias = {materia1, materia2};
        
       
        Estudiante estudiante1 = new Estudiante("Alex", "Lopez", 23, "44333222", "Programador Universitario", 8.5, materias);
        Estudiante estudiante2 = new Estudiante("Maria", "Gomez", 22, "39994444", "Marketing Cultural", 9.0, materias);
        Estudiante estudiante3 = new Estudiante("Abril", "Bidegain", 19, "48555444", "Bioingenieria", 8.0, materias);

        Estudiante[] estudiantes = {estudiante1, estudiante2, estudiante3};

        double sumaRecursiva = estudiante1.calcularPromedioRecursivo(materias, 0);
        double promedioRecursivo = sumaRecursiva / materias.length;
        double promedioIterativo = estudiante1.calcularPromedioIterativo();

        System.out.println("\nPromedio (recursivo): " + promedioRecursivo);
        System.out.println("\nPromedio (iterativo): " + promedioIterativo);

        uni.agregarMiembro(estudiante1);
        uni.agregarMiembro(estudiante2);
        uni.agregarMiembro(estudiante3);
        uni.agregarMiembro(profesor1);
        uni.agregarMiembro(personal1);

        Estudiante copia = new Estudiante("Alejandro","Lopez", 25, "44333222", "Medicina", 9, null);
        uni.agregarMiembro(copia);

        uni.listarMiembros();

        uni.listarEstudiantes();
        
        System.out.println("\nOrdenando Estudiantes por Apellido...");
        uni.ordenarEstudiantesPorApellido();
        uni.listarEstudiantes();


        System.out.println("\n--Busqueda por documento---\n");
        Persona encontrada = uni.buscarPorDocumento("44333222");
        if(encontrada != null){
            System.out.println("Persona encontrada: " + encontrada);
        }else {
            System.out.println("No se encontró la persona con ese documento.");
        }
        System.out.println("Comparacion equals");
         System.out.println("Alumno y copia son iguales? " + estudiante1.equals(copia));

        System.out.println("\n Busqueda Binaria por Apellido: 'Gomez' ");
        Estudiante clave = uni.busquedaBinariaEstudiantes(estudiantes, "Gomez");
        if(clave != null){
            System.out.println("Estudiante encontrad@: " + clave);
        } else {
            System.out.println("No se encontró el estudiante con ese apellido.");
        }

         
    }

   
}

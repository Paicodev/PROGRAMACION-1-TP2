public class App {
    public static void main(String[] args) throws Exception {
        Universidad uni = new Universidad("UNViMe", "Villa Mercedes");

        Profesor profesor1 = new Profesor("Pablo", "Sosa", 45, "30111222", "Programacion", 20);
        Personal personal1 = new Personal("Carla", "Alvarez", 35, "35777666", "Administracion", "Secretaria", "2019-03-15");
        Materia materia1 = new Materia("Programacion 1", "PROG1", 4, 7.5, profesor1);
        Materia materia2 = new Materia("Matematica 1", "MAT1", 4, 10, profesor1);
        
       
        Estudiante estudiante1 = new Estudiante("Alex", "Lopez", 23, "44333222", "Programador Universitario", 0, null);
        Estudiante estudiante2 = new Estudiante("Maria", "Gomez", 22, "39994444", "Marketing Cultural", 0, null);
        Estudiante estudiante3 = new Estudiante("Abril", "Bidegain", 19, "48555444", "Bioingenieria", 0, null);

        Estudiante estudiante4 = new Estudiante("Beto", "Carrera", 20, "41000111", "Programador Universitario", 0, null);

        estudiante1.agregarMateria(materia1);
        estudiante1.agregarMateria(materia2);

        estudiante4.agregarMateria(materia1);

        double promedioAlex = estudiante1.calcularPromedioRecursivo();
        System.out.println("Promedio recursivo de Alex: " + promedioAlex);

        uni.agregarMiembro(estudiante1);
        uni.agregarMiembro(profesor1);
        uni.agregarMiembro(estudiante2);
        uni.agregarMiembro(estudiante3);
        uni.agregarMiembro(personal1);
        uni.agregarMiembro(estudiante4);

        System.out.println("LISTADO DE MIEMBROS : \n");
        uni.listarMiembros();

        
        System.out.println("\nOrdenando Estudiantes por Apellido...");

        Estudiante[] estudiantesParaOrdenar = uni.getSoloEstudiantes();

        uni.ordenarEstudiantesPorApellido(estudiantesParaOrdenar);
        System.out.println("lista ordenada de estudiantes:\n");
        for (Estudiante e : estudiantesParaOrdenar) {
            System.out.println(e.getApellido() + ", "+ e.getNombre());
        }


        System.out.println("\n--Busqueda por documento---\n");
        Persona encontrada = uni.buscarPorDocumento("44333222");
        if(encontrada != null){
            System.out.println("Persona encontrada: " + encontrada);
        }else {
            System.out.println("No se encontró la persona con ese documento.");
        }

        System.out.println("\n Busqueda Binaria por Apellido: 'Gomez' ");
        Estudiante clave = uni.busquedaBinariaEstudiantes(estudiantesParaOrdenar, "Gomez");
        if(clave != null){
            System.out.println("Estudiante encontrad@: " + clave.getNombre());
        } else {
            System.out.println("No se encontró el estudiante con ese apellido.");
        }

         
    }

   
}

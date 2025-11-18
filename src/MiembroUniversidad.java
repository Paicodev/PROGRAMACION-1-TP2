public interface MiembroUniversidad{
    //Devuelve el rol (sea estudiante, profesor o personal)
    String obtenerRol();
    //Devuelve un resumen con los datos del miembro en la universidad
    String obtenerInformacionCompleta();
}
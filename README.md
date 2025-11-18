# **INFORME TP2** 
## **Diferencias entre Arrays y Listas Enlazadas**
**Almacenamiento:** el Array almacena elementos pegados en memoria, la Lista los guarda dispersos en memoria, conectados por referencias.
**Tamaño/Capacidad:** Los arrays tienen un tamaño fijo que debe definirse al crearse, las Listas son dinámicas, crece o decrece según la necesidad.
**Inserción/Eliminación:**para los arrays es ineficiente, porque estos deben cambiar de indice si se ven afectados, en cambio, en Listas es muy eficiente, hacemos uso de la cabeza, recorremos y desconectamos ese nodo de la Lista.
**Acceso:** para acceder a los elementos se hace por indice ej: array[i], en cambio en Listas lo hacemos por recorrido, no hay indice.

## **Ventajas y Desventajas en el Sistema Educativo**
#### **Ventajas de Listas Enlazadas:**
hay eficiencia en memoria, ya que no se desperdicia al preasignar espacio en la Lista con cupos maximos a diferencia de los arrays.
**Gestion facilitada en colecciones:** se simplifica la manera de agregarMiembro en Universidad y agregarMateria en Estudiante.

### **Desventajas**: 
**Busqueda Lenta** : la principal desventaja es que la busqueda de un elemento por posicion o la busqueda binaria se vuelve ineficiente, porque requiere recorrer toda la lista.
**Mezcla entre busquedas**: Para mantener la eficiencia al buscar, se tuvo que optar por meter una lista en un array auxiliar, haciendo el metodo mas largo de lo que era antes.

package com.user_service.util;

public class AppSettings {

    public static final String URL_CROSS_ORIGIN = "http://localhost:4200";

    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    // Mensajes de registro
    public static class RegistrationMessages {
        public static final String EXISTS = "Ya existe dicho registro.";
        public static final String ERROR = "No se registró, consulte con el administrador.";
        public static final String SUCCESS = "Se registró correctamente.";
        public static final String EMAIL_EXISTS = "Ya existe el Email.";
        public static final String DNI_EXISTS = "Ya existe el DNI: ";
    }

    // Mensajes de actualización
    public static class UpdateMessages {
        public static final String EXISTS = "Ya existe dicho registro.";
        public static final String ERROR = "No se actualizó, consulte con el administrador.";
        public static final String SUCCESS = "Se actualizó correctamente.";
        public static final String ID_NOT_FOUND = "No existe el ID que se desea actualizar.";
    }

    // Mensajes de eliminación
    public static class DeletionMessages {
        public static final String ERROR = "No se eliminó, ya que el registro está relacionado.";
        public static final String SUCCESS = "Se eliminó correctamente.";
        public static final String ID_NOT_FOUND = "No existe el ID que se desea eliminar.";
    }

    // Mensajes de búsqueda
    public static class SearchMessages {
        public static final String ID_NOT_FOUND = "No existe el ID que desea buscar.";
    }
}

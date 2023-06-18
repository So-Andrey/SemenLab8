package localization;

import java.util.ListResourceBundle;

public class Labels_es extends ListResourceBundle {

    private static final Object[][] contents =
    {
            {"separator", ","},
            {"date_format", "dd/MM/yyyy"},
            {"name", "Nombre"},
            {"zip", "Código postal"},
            {"annual", "Facturación anual"},
            {"emploees", "Número de empleados"},
            {"type", "Tipo"},
            {"add", "Agregar"},
            {"if_min", "Si es menor"},
            {"invalid", "Entrada inválida"},
            {"not_min", "Demasiado grande"},
            {"delete", "Eliminar"},
            {"not_ur", "No es tuyo"},
            {"update", "Actualizar"},
            {"info", "Información"},
            {"u_sure", "¿Estás seguro?"},
            {"init", "Fecha de inicialización"},
            {"amount", "Cantidad de elementos"},
            {"choose", "Seleccionar archivo"},
            {"user", "Nombre de usuario"},
            {"coordinates", "Coordenadas"},
            {"date", "Fecha de creación"},
            {"creator", "Creador"},
            {"attempt", "Intento de inicio de sesión"},
            {"success", "¡Éxito!"},
            {"exists", "El nombre de usuario ya existe"},
            {"have_acc", "¿Ya tienes una cuenta?"},
            {"sign_up", "Registrarse"},
            {"login", "Iniciar sesión"},
            {"no_acc", "¿No tienes una cuenta?"},
            {"password", "Contraseña"}
    };

    public Object[][] getContents() {
        return contents;
    }

}

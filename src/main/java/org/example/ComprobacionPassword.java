package org.example;

import java.util.regex.Pattern;

public class ComprobacionPassword {

    // Patrón para validar el correo electrónico con una extensión válida
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Método para validar el correo electrónico
    public boolean validarEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Método para validar la contraseña
    public boolean validarPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&  // Al menos una letra mayúscula
                password.matches(".*\\d.*");     // Al menos un número
    }

    // Método para verificar si el correo ya está registrado
    public boolean correoRegistrado(String email, String[] emailsRegistrados) {
        for (String registrado : emailsRegistrados) {
            if (registrado.equals(email)) {
                return true;
            }
        }
        return false;
    }

    // Método para recuperación de contraseña
    public boolean recuperarPassword(String email, String[] emailsRegistrados) {
        return correoRegistrado(email, emailsRegistrados);
    }

    // ----------------- Expansión para la tercera historia de usuario -----------------

    // Método para actualizar los datos del perfil
    public boolean actualizarPerfil(String nuevoNombre, String nuevoApellido, String nuevoEmail) {
        // Validar que los campos no estén vacíos y que el correo sea válido
        if (nuevoNombre == null || nuevoNombre.isEmpty() ||
                nuevoApellido == null || nuevoApellido.isEmpty() ||
                !validarEmail(nuevoEmail)) {
            return false;
        }
        // Si todos los datos son válidos, se simula la actualización
        return true;
    }

    // Método para cambiar la contraseña
    public boolean cambiarPassword(String actualPassword, String nuevaPassword, String confirmacionPassword, String passwordCorrectaActual) {
        if (!actualPassword.equals(passwordCorrectaActual)) {
            // La contraseña actual no es correcta
            return false;
        }
        // Validar que la nueva contraseña cumpla con los requisitos
        if (!validarPassword(nuevaPassword) || !nuevaPassword.equals(confirmacionPassword)) {
            return false;
        }
        // Si todo es correcto, la contraseña se actualiza
        return true;
    }

    // Método para verificar si el usuario está autenticado
    public boolean usuarioAutenticado(boolean autenticado) {
        return autenticado;
    }
}

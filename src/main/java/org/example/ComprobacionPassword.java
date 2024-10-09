package org.example;

import java.util.regex.Pattern;

public class ComprobacionPassword {

    // Patrón para validar el correo electrónico
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Método para validar el correo electrónico
    public boolean validarEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Método para validar la contraseña
    public boolean validarPassword(String password) {
        // Condiciones: mínimo 8 caracteres, al menos una mayúscula, un número
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
}

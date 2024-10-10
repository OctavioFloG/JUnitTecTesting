package org.example;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.UUID;

public class ComprobacionPassword {

    // Patrón para validar el correo electrónico con una extensión válida
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Mapa para almacenar los tokens de recuperación asociados a los correos electrónicos
    private HashMap<String, String> tokensRecuperacion = new HashMap<>();

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

    // Método para generación de token de recuperación
    public String generarTokenRecuperacion(String email, String[] emailsRegistrados) {
        if (correoRegistrado(email, emailsRegistrados)) {
            String token = UUID.randomUUID().toString(); // Genera un token único
            tokensRecuperacion.put(email, token); // Asocia el token con el correo
            return token;
        }
        return null; // Si el correo no está registrado, no genera token
    }

    // Método simulado para enviar el correo de recuperación
    public boolean enviarEmailRecuperacion(String email, String[] emailsRegistrados) {
        String token = generarTokenRecuperacion(email, emailsRegistrados);
        if (token != null) {
            System.out.println("Enlace de recuperación: www.tusitio.com/recuperar?token=" + token);
            return true;
        }
        return false;
    }

    // Método para recuperar contraseña
    public boolean recuperarPassword(String email, String[] emailsRegistrados) {
        // Primero genera el token y verifica si el correo está registrado
        String token = generarTokenRecuperacion(email, emailsRegistrados);

        // Si se generó el token correctamente, envía el correo de recuperación
        if (token != null) {
            return enviarEmailRecuperacion(email, emailsRegistrados);
        }

        // Si el correo no está registrado o no se puede generar un token, devolver false
        return false;
    }

    // Método para validar el token de recuperación
    public boolean validarToken(String token, String email) {
        return tokensRecuperacion.containsKey(email) && tokensRecuperacion.get(email).equals(token);
    }

    // Método para restablecer la contraseña
    public boolean restablecerPassword(String token, String email, String nuevaPassword, String confirmacionPassword) {
        if (validarToken(token, email) && validarPassword(nuevaPassword) && nuevaPassword.equals(confirmacionPassword)) {
            // Aquí iría la lógica para actualizar la contraseña en la base de datos
            tokensRecuperacion.remove(email); // Remueve el token después de usarlo
            System.out.println("Contraseña actualizada correctamente para: " + email);
            return true;
        }
        return false;
    }

    // ----------------- Otros métodos -----------------

    // Método para actualizar los datos del perfil
    public boolean actualizarPerfil(String nuevoNombre, String nuevoApellido, String nuevoEmail) {
        if (nuevoNombre == null || nuevoNombre.isEmpty() ||
                nuevoApellido == null || nuevoApellido.isEmpty() ||
                !validarEmail(nuevoEmail)) {
            return false;
        }
        return true;
    }

    // Método para cambiar la contraseña
    public boolean cambiarPassword(String actualPassword, String nuevaPassword, String confirmacionPassword, String passwordCorrectaActual) {
        if (!actualPassword.equals(passwordCorrectaActual)) {
            return false;
        }
        if (!validarPassword(nuevaPassword) || !nuevaPassword.equals(confirmacionPassword)) {
            return false;
        }
        return true;
    }

    // Método para verificar si el usuario está autenticado
    public boolean usuarioAutenticado(boolean autenticado) {
        return autenticado;
    }
}

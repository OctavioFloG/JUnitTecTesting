package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComprobacionPasswordTest {

    // HOLA.
    // pruebas unitarias de contraseña
    ComprobacionPassword comprobacionPassword = new ComprobacionPassword();
//validacion email
    @Test
    void testValidarEmailValido() {
        assertTrue(comprobacionPassword.validarEmail("usuario@gmail.com"));
    }

    @Test
    void testValidarEmailInvalido() {
        assertFalse(comprobacionPassword.validarEmail("usuario@gmail"));
    }

    //Test para validar contraseña valida
    @Test
    void testValidarPasswordValida() {
        assertTrue(comprobacionPassword.validarPassword("Password1"));
    }

    //Test para validar contraseña invalida
    @Test
    void testValidarPasswordInvalida() {
        assertFalse(comprobacionPassword.validarPassword("pass1"));
        assertFalse(comprobacionPassword.validarPassword("password"));
        assertFalse(comprobacionPassword.validarPassword("PASSWORD"));
    }

    //Test para correo ya registrado
    @Test
    void testCorreoYaRegistrado() {
        String[] emailsRegistrados = {"usuario@ejemplo.com", "prueba@ejemplo.com"};
        assertTrue(comprobacionPassword.correoRegistrado("usuario@ejemplo.com", emailsRegistrados));
    }

    @Test
    void testCorreoNoRegistrado() {
        String[] emailsRegistrados = {"usuario@ejemplo.com", "prueba@ejemplo.com"};
        assertFalse(comprobacionPassword.correoRegistrado("nuevo@ejemplo.com", emailsRegistrados));
    }

    @Test
    void testRecuperarPasswordExitoso() {
        String[] emailsRegistrados = {"usuario@ejemplo.com", "prueba@ejemplo.com"};
        assertTrue(comprobacionPassword.recuperarPassword("usuario@ejemplo.com", emailsRegistrados));
    }

    @Test
    void testRecuperarPasswordUsuarioNoRegistrado() {
        String[] emailsRegistrados = {"usuario@ejemplo.com", "prueba@ejemplo.com"};
        assertFalse(comprobacionPassword.recuperarPassword("nuevo@ejemplo.com", emailsRegistrados));
    }

    @Test
    void testRestablecerPasswordExitoso() {
        String[] emailsRegistrados = {"usuario@ejemplo.com", "prueba@ejemplo.com"};
        comprobacionPassword.generarTokenRecuperacion("usuario@ejemplo.com", emailsRegistrados);
        String token = comprobacionPassword.generarTokenRecuperacion("usuario@ejemplo.com", emailsRegistrados);

        assertTrue(comprobacionPassword.restablecerPassword(token, "usuario@ejemplo.com", "NewPass1", "NewPass1"));
    }

    @Test
    void testRestablecerPasswordFalloTokenInvalido() {
        assertFalse(comprobacionPassword.restablecerPassword("tokenInvalido", "usuario@ejemplo.com", "NewPass1", "NewPass1"));
    }

    @Test
    void testActualizarPerfilExitoso() {
        assertTrue(comprobacionPassword.actualizarPerfil("Juan", "Pérez", "juan.perez@ejemplo.com"));
    }

    @Test
    void testActualizarPerfilDatosInvalidos() {
        assertFalse(comprobacionPassword.actualizarPerfil("Juan", "", "juan.perez@ejemplo.com")); // Apellido vacío
        assertFalse(comprobacionPassword.actualizarPerfil("Juan", "Pérez", "juan.perez@ejemplo")); // Correo inválido
    }

    @Test
    void testCambiarPasswordExitoso() {
        String actualPassword = "Password1";
        String nuevaPassword = "NuevaPassword1";
        String confirmacionPassword = "NuevaPassword1";
        String passwordCorrectaActual = "Password1";

        assertTrue(comprobacionPassword.cambiarPassword(actualPassword, nuevaPassword, confirmacionPassword, passwordCorrectaActual));
    }

    @Test
    void testCambiarPasswordActualIncorrecta() {
        String actualPassword = "Password1";
        String nuevaPassword = "NuevaPassword1";
        String confirmacionPassword = "NuevaPassword1";
        String passwordCorrectaActual = "OtraPassword";

        assertFalse(comprobacionPassword.cambiarPassword(actualPassword, nuevaPassword, confirmacionPassword, passwordCorrectaActual));
    }

    @Test
    void testCambiarPasswordNoCoinciden() {
        String actualPassword = "Password1";
        String nuevaPassword = "NuevaPassword1";
        String confirmacionPassword = "OtraPassword1";
        String passwordCorrectaActual = "Password1";

        assertFalse(comprobacionPassword.cambiarPassword(actualPassword, nuevaPassword, confirmacionPassword, passwordCorrectaActual));
    }

    @Test
    void testCambiarPasswordNoCumpleRequisitos() {
        String actualPassword = "Password1";
        String nuevaPassword = "short";
        String confirmacionPassword = "short";
        String passwordCorrectaActual = "Password1";

        assertFalse(comprobacionPassword.cambiarPassword(actualPassword, nuevaPassword, confirmacionPassword, passwordCorrectaActual));
    }

    @Test
    void testUsuarioNoAutenticado() {
        assertFalse(comprobacionPassword.usuarioAutenticado(false));
    }

    @Test
    void testUsuarioAutenticado() {
        assertTrue(comprobacionPassword.usuarioAutenticado(true));
    }
}

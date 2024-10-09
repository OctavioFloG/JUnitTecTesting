package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComprobacionPasswordTest {

    ComprobacionPassword comprobacionPassword = new ComprobacionPassword();

    @Test
    void testValidarEmailValido() {
        assertTrue(comprobacionPassword.validarEmail("usuario@ejemplo.com"));
    }

    @Test
    void testValidarEmailInvalido() {
        assertFalse(comprobacionPassword.validarEmail("usuario@ejemplo"));
    }

    @Test
    void testValidarPasswordValida() {
        assertTrue(comprobacionPassword.validarPassword("Password1"));
    }

    @Test
    void testValidarPasswordInvalida() {
        assertFalse(comprobacionPassword.validarPassword("pass1"));
        assertFalse(comprobacionPassword.validarPassword("password"));
        assertFalse(comprobacionPassword.validarPassword("PASSWORD"));
    }

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
}

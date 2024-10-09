package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.example.PasswordUtil.SecurityLevel.*;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {
    @DisplayName("Contraseña menor a 8 caracteres")
    @Test
    public void test1(){
        String password="1234567";
        assertEquals(WEAK,PasswordUtil.assessPassword(password));
    }

    @DisplayName("Contraseña que contiene solo letras (WEAK)")
    @Test
    public void test2(){
        String password="asdfghj";
        assertEquals(WEAK,PasswordUtil.assessPassword(password));
    }

    @DisplayName("Contraseña que contiene letras y numeros (MEDIUM)")
    @Test
    public void test3(){
        String password = "abcde1234";
        assertEquals(MEDIUM,PasswordUtil.assessPassword(password));
    }

    @DisplayName("Contraseña contiene letras y numeros (STRONG)")
    @Test
    public void test4(){
        String password="asd1234!#$";
        assertEquals(STRONG,PasswordUtil.assessPassword(password));
    }
}
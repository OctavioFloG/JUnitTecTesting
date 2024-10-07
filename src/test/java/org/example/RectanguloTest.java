package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectanguloTest {
    private Rectangulo rectangulo1;
    
    @BeforeEach
    public void setup() {
        rectangulo1 = new Rectangulo(8, 2);
    }

    @DisplayName("Verificar que el area regresada sea correcta")
    @Test
    public void test1() {
        double actual = rectangulo1.getArea();
        double expected = 16;
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Verificar que el perimetro regresado sea correcto")
    @Test
    public void test2() {
        double actual = rectangulo1.getPerimetro();
        double expected = 20;
        Assertions.assertEquals(expected, actual);
    }

}
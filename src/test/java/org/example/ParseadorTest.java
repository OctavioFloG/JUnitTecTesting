package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParseadorTest {

    private final Parseador parseador = new Parseador();
    @DisplayName("Obtiene el numero del primer término  de la ecuacion")
    @Test
    public void test1() {

        String ecuacion1 = "2x - 1 = 0";

        int resultado = parseador.obtenerParte1(ecuacion1);

        assertEquals(2, resultado);
    }

    @DisplayName("Obtiene el numero del segundo termino de la ecuacion")
    @Test
    public void test2() {

        String ecuacion1 = "2x + 1 = 0";

        int resultado = parseador.obtenerParte2(ecuacion1);

        assertEquals(1, resultado);
    }

    @DisplayName("Obtiene el numero del tercer termino de la ecuacion")
    @Test
    public void test3() {

        String ecuacion1 = "2x + 1 = 3";

        int resultado = parseador.obtenerParte3(ecuacion1);

        assertEquals(3, resultado);
    }

    EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

    @DisplayName("Obtiene el operando +")
    @Test
    public void obtenerOperadorSuma() {

        String ecuacion2 = "2x + 1 = 0";

        String operador = parseador.obtenerOperador(ecuacion2);

        assertEquals("+", operador);
    }

    @DisplayName("Obtiene el operando -")
    @Test
    public void obtenerOperadorResta() {

        String ecuacion2 = "2x - 1 = 0";

        String operador = parseador.obtenerOperador(ecuacion2);

        assertEquals("-", operador);
    }

    @DisplayName("Soluciona una ecuacion con un operando \"-\"")
    @Test
    public void solucionaEcuacionConOperadorMenos() {

        Double result = ecuacion.obtenerResultado("2x - 1 = 0");

        Double valueExpected = 0.5;

        assertEquals(valueExpected, result);
    }
    
    @DisplayName("Soluciona una ecuacion con un operando \"+\"")
    @Test
    public void solucionaEcuacionConOperadorMas() {

        Double result = ecuacion.obtenerResultado("2x + 1 = 0");

        Double valueExpected = -0.5;

        assertEquals(valueExpected, result);
    }

    @DisplayName("Soluciona una ecuacion con el valor del tercer numero aumentado")
    @Test
    public void test7() {

        Double result = ecuacion.obtenerResultado("2x + 1 = 10");

        Double valueExpected = 4.5;

        assertEquals(valueExpected, result);
    }
}

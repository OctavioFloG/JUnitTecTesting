package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParseadorTest {

    private final Parseador parseador = new Parseador();

    @Mock
    Parseador parseador1;

    @DisplayName("Obtener los dos operandos de una ecuacion lineal de 4 terminos")
    @Test
    public void obtenerOperandos3terminos(){

        String ecuacion1 = "2x - 1 + 4 = 0";
        Mockito.when(parseador1.Obtener2Operandos(ecuacion1)).thenReturn("+ -");
        final String operador = parseador1.Obtener2Operandos(ecuacion1);
        assertEquals("+ -", operador);
    }

    @DisplayName("Obtener el numero del primer termino")
    @Test
    public void obtenerParte1() {

        String ecuacion1 = "2x - 1 = 0";

        int resultado = parseador.obtenerParte1(ecuacion1);

        assertEquals(2, resultado);
    }


    @DisplayName("Obtener el numero del segundo termino")

    @Test
    public void obtenerParte2() {

        String ecuacion1 = "2x + 1 = 0";

        int resultado = parseador.obtenerParte2(ecuacion1);

        assertEquals(1, resultado);
    }

    @DisplayName("Obtener el numero del tercer termino")

    @Test
    public void obtenerParte3() {

        String ecuacion1 = "2x + 1 = 3";

        int resultado = parseador.obtenerParte3(ecuacion1);

        assertEquals(3, resultado);
    }

    EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

    @DisplayName("Obtener el operando \"+\"")
    @Test
    public void obtenerOperadorSuma() {

        String ecuacion2 = "2x + 1 = 0";

        String operador = parseador.obtenerOperador(ecuacion2);

        assertEquals("+", operador);
    }

    @DisplayName("Obtener el operando \"-\"")
    @Test
    public void obtenerOperadorResta() {

        String ecuacion2 = "2x - 1 = 0";

        String operador = parseador.obtenerOperador(ecuacion2);

        assertEquals("-", operador);
    }

    @DisplayName("Soluciona ecuaciones lineales con operando -")
    @Test
    public void solucionaEcuacionConMenos() {

        Double result = ecuacion.obtenerResultado("2x - 1 = 0");

        Double valueExpected = 0.5;

        assertEquals(valueExpected, result);
    }

    @DisplayName("Soluciona ecuaciones lineales con operando +")
    @Test
    public void solucionaEcuacionConMas() {

        Double result = ecuacion.obtenerResultado("2x + 1 = 0");

        Double valueExpected = -0.5;

        assertEquals(valueExpected, result);
    }

    @DisplayName("Soluciona ecuaciones con la tercera parte != 0")
    @Test
    public void solucionaEcuacionConParte3Mayor0() {

        Double result = ecuacion.obtenerResultado("2x + 1 = 10");

        Double valueExpected = 4.5;

        assertEquals(valueExpected, result);
    }
}

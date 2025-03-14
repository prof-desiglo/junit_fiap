package com.fiap;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuiteOk {
    private static Calc calc;

    @BeforeAll
    public static void setup(){
        // Ver o número de "Inicializando"
        // verificar que ele criou só uma instancia
        calc = new Calc();
    }

    @AfterAll
    public static void teardown(){
        System.out.println("Limpeza pós testes");
    }

    @BeforeEach
    public void beforeTest() { //ver log da execução
        System.out.println("<==== Teste Vai iniciar ====>");
        System.out.println(calc.toString());
    }

    @AfterEach
    public void afterTest() { //ver log da execução
        System.out.println("<==== Teste Terminou ====>");
    }

    @Test
    public void testSomaOk() throws Exception {
        int result = calc.soma(1, 3);
        assertEquals(4, result);
    }

    @Test
    public void testSomaOk_2() throws Exception { //Teste Falho
        int result = calc.soma(50, 1);
        assertEquals(52, result);
    }
}

package com.fiap;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

public class CalcTest {

    private Calc calc = new Calc();

    @Test
    @Tag("HappyPath")
    @DisplayName("Test OK Soma")
    public void testSomaOk() {
        // Faz uma soma Simples entre 1 e 3  e valida o resultado é 4
        try {
            int result = calc.soma(1, 3);
            assertEquals(4, result);
        } catch (Exception e) {
            fail(); //Em caso de exceção falha o teste
        }
    }

    @Test
    @Tag("HappyPath")
    public void testSomaOk_v2() throws Exception {
        // Mesmo que o testSomaOk caso o JNUIT receba uma exceção ele falha o teste
        int result = calc.soma(1, 3);
        assertEquals(4, result);
    }

    @Test
    public void testSomaMax() {
        // Verifica se ao ter um overflow do tipo inteiro o método retorna uma exceção
        try {
            int result = calc.soma(Integer.MAX_VALUE, 3);
        } catch (Exception e) {
            assertEquals( "java.lang.Exception: Overflow Positivo", e.toString());
        }
    }

    @Test
    public void testSomaMax_v2() {
        // Outra forma possível de implementar o método testSomaMax usando assertThrows
        // assertThrowsExactly permite validar que a exceção é exatamente de um tipo
        // E não uma exceção derivada (polimorfismo)
        Exception ex = assertThrowsExactly(
                Exception.class,
                () -> calc.soma(Integer.MAX_VALUE, 3),
                "Deveria Retornar Exceção de Overflow"
        );
        assertEquals("Overflow Positivo", ex.getMessage());
    }

    @Test
    public void testSomaMin() {
        // Verifica se ao ter um overflow do tipo inteiro o método retorna uma exceção
        try {
            int result = calc.soma(Integer.MIN_VALUE, -3);
        } catch (Exception e) {
            assertEquals( "java.lang.Exception: Overflow Negativo", e.toString());
        }
    }

    @Test
    public void testSomaMaxMin() {
        // Soma o Maior Int com o menor INT o resultado vai ser -1
        try {
            int result = calc.soma(Integer.MIN_VALUE, Integer.MAX_VALUE);
            assertEquals(-1, result);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @Tag("TagNameDummy")
    @Order(1)
    public void dummy() {
        // Exemplo de um teste
        // Um teste sem nenhum assert só vai falhar se tiver uma exceção não tratada
        System.out.println("Teste Dummy");
    }

    @Test
    @Tag("TagNameDummy")
    @Order(2) //Dummy 2 vai rodar depois de Dummy
    public void dummy_2() throws Exception {
        // Exemplo de um teste
        // Um teste sem nenhum assert só vai falhar se tiver uma exceção não tratada
        System.out.println("Teste Dummy 2");
        throw new Exception("Falha Dummy");
    }

}

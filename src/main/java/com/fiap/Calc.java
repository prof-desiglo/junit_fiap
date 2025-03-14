package com.fiap;

public class Calc implements Calculator {

    public Calc() {
        System.out.println("Inicializado");
    }

    @Override
    public String toString() {
        return "Calc Object:" + super.toString();
    }

    @Override
    public int soma(int valor1, int valor2) throws Exception {
        int resultado = valor1 + valor2;
        // Valida se houve um orverflow antes de devolver o resultado
        if(valor1 > 0 && valor2 > 0 && resultado < 0) throw new Exception("Overflow Positivo");
        if(valor1 < 0 && valor2 < 0 && resultado > 0) throw new Exception("Overflow Negativo");
        return resultado;
    }

    @Override
    public int divisaoInt(int valor1, int valor2) throws Exception {
        throw new Exception("Neceesário Implementar");
    }

    @Override
    public float divisao(int valor1, int valor2) throws Exception {
        throw new Exception("Neceesário Implementar");
    }

    @Override
    public int multiplicacao(int valor1, int valor2) throws Exception {
        throw new Exception("Neceesário Implementar");
    }

    @Override
    public int subtracao(int valor1, int valor2) throws Exception {
        throw new Exception("Neceesário Implementar");
    }

}
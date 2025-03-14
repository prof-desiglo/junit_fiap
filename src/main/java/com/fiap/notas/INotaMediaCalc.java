package com.fiap.notas;

public interface INotaMediaCalc {
    public void setNotaCheckpoit1(int nota);
    public void setNotaCheckpoit2(int nota);
    public void setNotaCheckpoit3(int nota);

    public void setNotaRecuperacao(int nota);
    // A nota da recuperação só pode ser setada se todas as notas setadas
    // E o Aluno está de recuperação
    // Se mediaSemRecuperacao for < 5 o aluno não faz recuperação

    public void setAprovadoConselho(boolean resultado);
    // True é que foi aprovado no conselho
    // Falso é que foi reprovado no conselho
    // Só pode ser setado se o aluno falhou na recuperação

    public float mediaSemRecuperacao();
    // Media das 3 notas de provas

    public float media();
    // Media das 3 notas se o aluno não tiver feito a recuperação
    // sera a media da mediaSemRecuperacao e da "nota da recuperação"

    public boolean EstaReprovado();
    // Se a mediaSemRecuperacao for < 5 E falhou no conselho
    // Se media (Pos Recuperacao) < 7 E falhou no conselho
    // Se o setAprovadoConselho não tiver sido chamado devera voltar falso

    public boolean EstaRecuperacao();
    // Se a mediaSemRecuperacao for > 5 e < 7
    //
    public boolean EstaAprovado();
    // Se a media > 7
    // Ou se foi aprovado no conselho

}

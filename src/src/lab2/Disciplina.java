package lab2;
import java.util.Arrays;

/**
 * Representação de uma disciplina. Toda disciplina precisa ter obrigatoriamente um nome, horas de estudo e notas.
 *
 * @author Ana Leticia Aires
 * */
public class Disciplina {
    /**
     * Nome da disciplina cadastrada.
     */
    private String nomeDisciplina;
    /**
     * Horas de Estudo em determinada disciplina.
     */
    private int horasDeEstudo;
    /**
     * Array das notas que o aluno tirou em determinada disciplina.
     */
    private double[] notas;
    /**
     * Array dos pesos das notas que o aluno tirou em determinada disciplina.
     */
    private int[] pesos;

    /**
     * Constrói uma Disciplina a partir de seu nome, com o número de notas igual a 4 por padrão, com os pesos iguais a 1 em todas as notas.
     * Toda disciplina inicia com as horas de estudo e notas zeradas.
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[4];
        this.pesos = new int[4];
        for (int i = 0; i < 4; i++){
            pesos[i] = 1;
        }

    }
    /**
     * Constrói uma Disciplina a partir de seu nome, e com o número de notas informado, com os pesos iguais a 1 em todas as notas.
     * Toda disciplina inicia com as horas de estudo e notas zeradas.
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numerodeNotas a quantidade de notas na disciplina
     */
    public Disciplina(String nomeDisciplina, int numerodeNotas) {
        this.horasDeEstudo = 0;
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numerodeNotas];
        this.pesos = new int[numerodeNotas];
        for (int i = 0; i < numerodeNotas; i++){
            pesos[i] = 1;
        }
    }
    /**
     * Constrói uma Disciplina a partir de seu nome, com o número de notas informado e com os pesos informados de cada nota.
     * Toda disciplina inicia com as horas de estudo e notas zeradas.
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numerodeNotas a quantidade de notas na disciplina
     * @param pesos os pesos de cada nota da disciplina
     */

    public Disciplina(String nomeDisciplina, int numerodeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[numerodeNotas];
        this.pesos = pesos;

    }
    /**
     * Cadastra horas de estudo do aluno.
     *
     * @param horas quantidade de horas de estudo a ser cadastrada e somada.
     */
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }
    /**
     * Cadastra as notas do aluno no array de notas.
     *
     * @param nota o número da prova o aluno quer cadastrar a nota
     * @param valorNota a nota que o aluno tirou em determinada prova
     */
    public void cadastraNota(int nota, double valorNota) {
        if(nota >= 1 && nota<= notas.length)
            this.notas[nota - 1] = valorNota;
    }
    /**
     * Calcula a média do aluno de acordo com as notas dele.
     * Se for passado o peso de cada nota será calculada uma média ponderada, caso contrário uma média simples.
     *
     * @retorna a média do aluno
     */
    private double calculaMedia() {
        double soma = 0;
        double mult = 0;
        int somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            mult = notas[i] * pesos[i];
            soma += mult;
            somaPesos += pesos[i];
        }

        double media = soma / somaPesos;
        return media;
    }

    /**
     * Retorna um booleano que diz se o aluno foi aprovado (media maior ou igual a 7), ou reprovado.
     *
     * @return true se foi aprovado, false se foi reprovado
     */
    public boolean aprovado() {
        double media = this.calculaMedia();
        if (media >= 7) {
            return true;
        }
        return false;
    }
    /**
    * Retorna uma representação de texto que representa o nome da disciplina, as horas de estudo, a média e as notas da disciplina.
    *
    * @return uma representacão em String da situação geral do aluno na disciplina, informa o nome, as horas de estudo investidas, a média e as notas
    */
    @Override
    public String toString() {
        double media = this.calculaMedia();

        return nomeDisciplina + " " + horasDeEstudo + " " + media + " " + Arrays.toString(notas);
    }
}


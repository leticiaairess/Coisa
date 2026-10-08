package lab2;
import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasDeEstudo;
    private double[] notas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[4];
    }
    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }
    private double calculaMedia() {
        double soma = 0;
        // Que massa esse for
        for (double n : notas) {
            soma += n;
        }
        // Talvez retirar a var soma?? Colocar direto no return a (soma/notas.length)
        double media = soma / notas.length;
        return media;
    }
    public boolean aprovado() {
        double media = this.calculaMedia();
        if (media >= 7) {
            return true;
        }
        return false;
    }

    // Marcar override
    public String toString() {
        double media = this.calculaMedia();
        // Tirar o duplo +
        return nomeDisciplina + + horasDeEstudo + media + Arrays.toString(notas);
    }
}


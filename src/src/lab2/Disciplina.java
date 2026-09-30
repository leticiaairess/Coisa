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
        for (double n : notas) {
            soma += n;
        }
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
    public String toString() {
        double media = this.calculaMedia();
        return "Disciplina: " + nomeDisciplina + "\nHoras de estudo: " + horasDeEstudo + "\nMédia das notas: " + media + "\nNotas: " +  Arrays.toString(notas);
    }
}


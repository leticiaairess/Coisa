package lab2;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineUsado;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nome, int tempo) {
        this.nomeDisciplina = nome;
        this.tempoOnlineEsperado = tempo;
        this.tempoOnlineUsado = 0;
    }
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUsado += tempo;
    }
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineUsado >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }
    public String toString() {
        return nomeDisciplina + tempoOnlineUsado + tempoOnlineEsperado;
    }
}

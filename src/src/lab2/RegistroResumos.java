package lab2;

public class RegistroResumos {
    private String temas[];
    private String conteudos[];
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
    }

    public int conta() {
        return this.quantidadeResumos;
    }

    public void adiciona(String tema, String conteudo) {
        if (temResumo(tema)) {
            return;
        }
        temas[proximaPosicao] = tema;
        conteudos[proximaPosicao] = conteudo;
        proximaPosicao += 1;
        if (proximaPosicao == temas.length) {
            proximaPosicao = 0;
        }
        if (quantidadeResumos < temas.length) {
            quantidadeResumos += 1;
        }
    }

    public boolean temResumo(String tema) {
        for (String t : temas) {
            if (tema.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public String[] pegaResumos() {
        String[] resumos =  new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }
        return resumos;
    }
    public String imprimeResumos() {
        String texto = "- " + quantidadeResumos + "resumo(s) cadastrado(s)\n";
        for (int i = 0; i < quantidadeResumos; i++) {
            texto += temas[i];
            if(i < quantidadeResumos - 1) {
                texto += " | ";
            }
        }
        return texto;
    }
}
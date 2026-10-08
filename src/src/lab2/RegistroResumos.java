package lab2;

public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
        this.resumos = new Resumo[numeroDeResumos];
    }

    public int conta() {
        return this.quantidadeResumos;
    }

    public void adiciona(String tema, String conteudo) {
        if (temResumo(tema)) {
            for (int i = 0; i < quantidadeResumos; i++) {
                if (resumos[i].getTema().equals(tema)) {
                    resumos[i] = new Resumo(tema, conteudo); // Atualiza na mesma gaveta
                    return;
                }
            }
        }
        resumos[proximaPosicao] = new Resumo(tema, conteudo);
        proximaPosicao += 1;
        if (proximaPosicao == resumos.length) {
            proximaPosicao = 0;
        }
        if (quantidadeResumos < resumos.length) {
            quantidadeResumos += 1;
        }
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    public String[] pegaResumos() {
        String[] resposta =  new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resposta[i] = resumos[i].toString();
        }
        return resposta;
    }
    public String imprimeResumos() {
        String texto = "- " + quantidadeResumos + " resumo(s) cadastrado(s)\n";
        for (int i = 0; i < quantidadeResumos; i++) {
            texto += resumos[i];
            if(i < quantidadeResumos - 1) {
                texto += " | ";
            }
        }
        return texto;
    }
}
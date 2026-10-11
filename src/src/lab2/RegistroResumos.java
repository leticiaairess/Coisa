package lab2;

import java.util.Arrays;
/**
 * Representação de um registro de resumos de estudos.
 * Armazena conteúdos e temas com um limite já estabelecido.
 * Se o limite for atingido, os temas e conteúdos são substituidos de maneira circular.
 *
 * @author Ana Leticia Aires
 */

public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;


    /**
     * Constrói os registros de resumos a partir do limite máximo de número de resumos que pode ser armazenado.
     * O registro começa zerado, sem resumos ainda.
     *
     * @param numeroDeResumos número máximo de resumos que pode ser armazenado
     */
    public RegistroResumos(int numeroDeResumos) {
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
        this.resumos = new Resumo[numeroDeResumos];
    }

    /**
     * Retorna a quantidade de resumos adicionados.
     *
     * @return numero de resumos adicionados.
     */
    public int conta() {

        return this.quantidadeResumos;
    }
    /**
     * Adiciona um resumo ao registro.
     * Se o tema já existir, o conteúdo desse tema é atualizado. Se o registro estiver cheio, o índice volta para o início e substitui o mais antigo.
     *
     * @param tema o tema do resumo
     * @param conteudo o conteúdo do resumo
     */
    public void adiciona(String tema, String conteudo) {
        if (temResumo(tema)) {
            for (int i = 0; i < quantidadeResumos; i++) {
                if (resumos[i].getTema().equals(tema)) {
                    resumos[i] = new Resumo(tema, conteudo);
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
    /**
     * Verifica se existe um resumo cadastrado com determinado tema.
     *
     * @param tema o tema a ser procurado
     * @return true se o tema existir, false caso nao exista
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidadeResumos; i++) {
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Retorna os resumos cadastrados pelo aluno
     * Formato: "tema: conteúdo"
     *
     * @return um array com a representação de cada resumo
     */
    public String[] pegaResumos() {
        String[] resposta =  new String[quantidadeResumos];
        for (int i = 0; i < quantidadeResumos; i++) {
            resposta[i] = resumos[i].toString();
        }
        return resposta;
    }
    /**
     * Retorna um texto com a quantidade de resumos e a lista dos temas separados por uma "|".
     *
     * @return representação em string dos resumos cadastrados pelo aluno
     */
    public String imprimeResumos() {
        String texto = "- " + quantidadeResumos + " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < quantidadeResumos; i++) {
            texto += resumos[i].getTema();
            if(i < quantidadeResumos - 1) {
                texto += " | ";
            }
        }
        return texto;
    }
    /**
     * Busca a palavra-chave no conteúdo dos resumos cadastrados pelo aluno, ignorando as letras maiúsculas e minúsculas
     * Se a palavra-chave for encontrada, insere o tema do resumo correspondente no array.
     *
     * @param chaveDeBusca a palavra-chave a ser buscada
     * @return um array de String
     */
    public String[] busca(String chaveDeBusca) {
        int cont = 0;
        for (int i=0; i < quantidadeResumos; i ++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
            cont++;
            }
        }
        String[] resultado = new String[cont];

        for (int i = 0; i < quantidadeResumos; i++)    {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                resultado[cont-1] = resumos[i].getTema();
                cont -= 1;
            }
        }
        Arrays.sort(resultado);

        return resultado;
    }
}
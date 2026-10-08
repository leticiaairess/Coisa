package lab2;

/**
 * Representa os resumos cadastrados pelo RegistroResumos.
 * Cada resumos precisa ter um tema e um conteudo.
 *
 * @author Daniela Junkes Fernandes
 */
public class Resumo {
    private String tema;
    private String conteudo;

    /**
     * Constrói um Resumo com base no tema e no conteudo
     *
     * @param tema     tema do resumo
     * @param conteudo conteudo do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;

    }

    /**
     * Pega o tema do resumo e o retorna.
     *
     * @return tema do resumo
     */
    public String getTema() {
        return tema;
    }

    public String getConteudo() {
        return conteudo;
    }

    /**
     * Retorna uma representação de texto no formato "tema: conteudo".
     *
     * @return uma string.
     */
    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}
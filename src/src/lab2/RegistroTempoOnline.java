package lab2;

/**
 * Representação de um registro de tempo online em determinada disciplina.
 * Permite comparar o tempo dedicado e a meta de tempo esperado para tal disciplina.
 *
 * @author Ana Leticia Aires
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina
     */
    private String nomeDisciplina;
    /**
     * O tempo online investido pelo aluno para determinada disciplina.
     */
    private int tempoOnlineUsado;
    /**
     *  o tempo online esperado pelo aluno na determinada disciplina
     */
    private int tempoOnlineEsperado;

    /**
     * Constrói um registro de tempo online com o tempo esperado informado pelo aluno.
     * O tempo online usado começa em zero.
     *
     * @param nome o nome da disciplina
     * @param tempo o tempo online esperado.
     */

    public RegistroTempoOnline(String nome, int tempo) {
        this.nomeDisciplina = nome;
        this.tempoOnlineEsperado = tempo;
        this.tempoOnlineUsado = 0;
    }
    /**
     * Constrói um registro de tempo online com o tempo esperado padrão de 120 horas.
     * O tempo online usado começa em zero.
     *
     * @param nome o nome da disciplina
     */
    public RegistroTempoOnline(String nome) {
        this.nomeDisciplina = nome;
        this.tempoOnlineEsperado = 120;
        this.tempoOnlineUsado = 0;

    }
    /**
     * Adiciona horas de tempo online dedicadas a determinada disciplina.
     * @param tempo tempo a ser adicionado.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnlineUsado += tempo;
    }
    /**
     * Verifica se o aluno atingiu a meta de tempo online esperado.
     * @return true se o aluno atingir a meta esperada e false caso não tenha atingido a meta.
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnlineUsado >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }
    /**
    * Retorna a representação em texto do registro de tempo online
    * no seguinte formato: "nome da disciplina  tempo online usado/tempo online esperado"
    *
    * @return a representação em String do registro
    */
    @Override
    public String toString() {
        return nomeDisciplina+ " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;
    }
}

package lab2;
/**
 * Representação da rotina de descanso de um aluno. Todo aluno precisa registrar a quantidade de horas descansadas e o número total de semanas.
 *
 * @author Ana Leticia Aires
 */

public class Descanso {
    /**
     * Total de horas de descanso registradas.
     */
    private int horasDescanso;
    /**
     * Total de semanas registradas.
     */
    private int numeroSemanas;

    /**
     * Constrói a rotina da descanso do aluno.
     * O construtor inicializa as horas de descanso e o numero de semanas como sendo 0, ou seja, o aluno começa como cansado.
     *
     */

    public Descanso() {

        this.horasDescanso = 0;
        this.numeroSemanas = 0;
    }
    /**
     * Define as horas de Descanso recebendo um valor como parametro.
     * @param valor a quantidade total de horas descansadas.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o numero de semanas descansadas.
     * @param valor o número total de semanas.
     */
    public void defineNumeroSemanas(int valor) {

        this.numeroSemanas = valor;
    }

    /**
     * Retorna o estado do estudante, cansado ou descansado de acordo com a media entre as horas de descanso e o número totais de semanas.
     * Sem horas/semanas registradas o estado inicializa como cansado.
     * Se a média registrada for igual ou maior que 26 horas, o aluno é considerado descansado, caso ao contrário, é considerado cansado.
     * @return "descansado" ou "cansado"
     */
    public String getStatusGeral() {
        if (numeroSemanas == 0) {
            return "cansado";
        }
        if (horasDescanso/ numeroSemanas >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}

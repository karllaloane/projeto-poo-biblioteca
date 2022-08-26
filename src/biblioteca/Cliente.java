package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/** Classe criada para representar um cliente, que herda da classe Pessoa
 * Possui como atributos o número máximo de empréstimos que o Cliente pode realizar,
 * se ele está ou não penalizado, bem como uma lista com os empréstimos atuais
 * @version 1.0
 * @since release 1
 */
public class Cliente extends Pessoa {

    private static int maximoEmprestimo = 2; //Pensar em uma melhor forma de armazenar
    private boolean penalizado;
    private ArrayList<Emprestimo> emprestimosAtuais;

    public Cliente() {
            super();
    }

    public Cliente(String nome, String cpf, String telefone, String email, Endereco endereco) {
            super(nome, cpf, telefone, email, endereco);
            emprestimosAtuais = new ArrayList<Emprestimo>();
            setPenalizado(false);
    }

    /** Método que recebe um ItemAcervo e um LocalDate, verifica se o item está
     * disponível (não está emprestado ou reservado), bem como se o cliente pode
     * realizar o empréstimo (não está penalizado, nem excedeu o número máximo de
     * empréstimos ativos.
     * 
     * @param item - ItemAcervo - item objeto do empréstimo
     * @param data - LocalDate - data em que o empréstimo está sendo realizado
     *
     * @return objeto da classe Emprestimo
     */
    public Emprestimo realizarEmprestimo(ItemAcervo item, LocalDate data) {

            if(!item.isDisponivel()) {
                    throw new ItemIndisponivelException("O livro nao esta disponivel!");
            }

            if(item.isReservado()) {
                if(!item.getReserva().getCliente().equals(this)) {
                        throw new ItemIndisponivelException("O livro ja esta reservado pra outra pessoa!");
                } else {
                    item.setReservado(false);
                    item.setReserva(null);
                }
            }
            
            if(this.isPenalizado()) {
                throw new ClienteComPendenciaException("O cliente possui multa(s) pendente(s)!\nImpossível"
                        + " realizar o empréstimo");
            }
            
            if(this.quantidadeEmprestimosAtuais() == maximoEmprestimo) {
                throw new ClienteComPendenciaException("O cliente já possui dois empréstimos ativos!\nImpossível"
                        + " realizar o empréstimo");
            }

            Emprestimo e = new Emprestimo(this, item, data);

            item.setDisponivel(false);

            emprestimosAtuais.add(e);

            return e;
    }

    /** Método criado para representar a devolução de item que está emprestado
     * 
     * @param i - representa a posição do empréstimo na lista de empréstimos
     * @param data - LocalDate - data que a devolução está ocorrendo
     */
    public void devolverItem(int i, LocalDate data) {

            double multa = 0;

            Emprestimo e = this.emprestimosAtuais.get(i);

            e.setDataDevolucao(data);

            multa = e.calcularMulta();

            if(multa > 0) { //se a multa for maior que zero, usuario e penalizado
                    setPenalizado(true);
            }

            e.getItem().setDisponivel(true); //livro foi devolvido mesmo com multa

    }

    /** Método criado para representar o pagamento de eventual multa devida pelo
     * cliente.
    * 
    */
    public void pagarMulta() {

            double valorTotal = 0;

            for(Emprestimo e : emprestimosAtuais) {

                    //vai pegar os emprestimos que esta multado, alterar estado da multa
                    //e finalmente remover dos emprestimos atuais

                    valorTotal += e.getValorMulta();

                    if(e.getEstaMultado()) {
                            e.setMultaPaga(true);
                            emprestimosAtuais.remove(e);
                    }	
            }
            System.out.println("Valor da multa paga: " + valorTotal);
            this.setPenalizado(false);
    }

    /**************************************************************************************************/

    /** Método que retorna a quantidade de empréstimos atuais do cliente.
     * 
     * @return int - quantidade de empréstimos atuais do cliente
     */
    public int quantidadeEmprestimosAtuais() {
            return this.emprestimosAtuais.size();
    }

    /** Método que retorna o número máximo de empréstimos simultâneos que o
     * cliente pode realizar.
     * 
     * @return int - número máximo de empréstimos
     */
    public static int getMaximoEmprestimo() {
            return maximoEmprestimo;
    }

    /** Método que atribui o número máximo de empréstimos simultâneos que os clientes
     * podem realizar.
     * 
     * @param maximoEmprestimo - int - número máximo de empréstimos
     */
    public static void setMaximoEmprestimo(int maximoEmprestimo) {
            Cliente.maximoEmprestimo = maximoEmprestimo;
    }

    /** Método que retorna um valor booleano sobre o cliente estar ou não penalizado
     * 
     * @return boolean - true se o cliente está penalizado, false caso contrário
     */
    public boolean isPenalizado() {
            return penalizado;
    }

    /** Método que define o valor do atributo penalizado
     * 
     * @param penalizado - boolean
     */
    public void setPenalizado(boolean penalizado) {
            this.penalizado = penalizado;
    }
    
    /** Método que retorna a lista de empréstimos atuais
     * 
     * @return ArrayList de Emprestimo
     */
    public ArrayList<Emprestimo> getEmprestimosAtuais() {
        return this.emprestimosAtuais;
    }
    
    /** Método toString que retorna os dados do objeto
     * 
     * @return String - dados do cliente
     */
    @Override
    public String toString() {
            return super.toString() +
                            ", Penalizado: " + penalizado +
                            ", Emprestimos atuais: " + emprestimosAtuais;
    }
        
}

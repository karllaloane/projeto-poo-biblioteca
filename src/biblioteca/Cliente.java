package biblioteca;

import java.time.DateTimeException;
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
    private ArrayList<Emprestimo> emprestimos;
    private int quantEmprestimosAtivos;

    /** Construtor que não recebe parâmetros e chama o construtor da classe mãe.
     * 
     */
    public Cliente() {
            super();
    }

    /** Construtor que recebe parâmetros e realiza a atribuição respectiva
     * 
     * @param nome
     * @param cpf
     * @param telefone
     * @param email
     * @param endereco 
     */
    public Cliente(String nome, String cpf, String telefone, String email, Endereco endereco) {
            super(nome, cpf, telefone, email, endereco);
            emprestimos = new ArrayList<Emprestimo>();
            setPenalizado(false);
            quantEmprestimosAtivos = 0;
    }

    /** Método que recebe um ItemAcervo e um LocalDate, verifica se o item está
     * disponível (não está emprestado ou reservado), bem como se o cliente pode
     * realizar o empréstimo (não está penalizado, nem excedeu o número máximo de
     * empréstimos ativos.
     * 
     * @param item - ItemAcervo - item objeto do empréstimo
     * @param data - LocalDate - data em que o empréstimo está sendo realizado
     *
     */
    public void realizarEmprestimo(ItemAcervo item, LocalDate data) {

            if(!item.isDisponivel()) {
                    throw new ItemIndisponivelException("O livro nao esta disponivel!");
            }

            if(item.isReservado()) {
                if(!item.getReserva().getCliente().getCpf().equals(this.getCpf())) {
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
            
            if(this.quantEmprestimosAtivos == maximoEmprestimo) {
                throw new ClienteComPendenciaException("O cliente já possui dois empréstimos ativos!\nImpossível"
                        + " realizar o empréstimo");
            }

            Emprestimo e = new Emprestimo(this, item, data);

            item.setDisponivel(false);

            emprestimos.add(e);
            this.quantEmprestimosAtivos++;
    }

    /** Método criado para representar a devolução de item que está emprestado
     * 
     * @param i - representa a posição do empréstimo na lista de empréstimos
     * @param data - LocalDate - data que a devolução está ocorrendo
     */
    public void devolverItem(int i, LocalDate data) {

            double multa = 0;

            Emprestimo e = this.emprestimos.get(i);
            
            if(e.getDataEmprestimo().isAfter(data))
                throw new DateTimeException("A data informada é anterior ao empréstimo");

            e.setDataDevolucao(data);
            multa = e.calcularMulta();
            
            if(multa > 0) { //se a multa for maior que zero, usuario e penalizado
                    setPenalizado(true);
            } else {
                multa = 0;
            }
            
            this.quantEmprestimosAtivos--;

            e.getItem().setDisponivel(true); //livro foi devolvido mesmo com multa   
            
            Biblioteca b = Biblioteca.getInstance();
            
            //bucando o item no acero para alterar sua situacao
            //pois por conta do arquivo esta perdendo a referencia
            for(ItemAcervo item : b.getItens()){
                if(item.getTitulo().equals(e.getItem().getTitulo())){
                    item.setDisponivel(true);
                    break;
                }
            }  
    }

    /** Método criado para representar o pagamento de eventual multa devida pelo
     * cliente.
    * 
    */
    public void pagarMulta() {

            double valorTotal = 0;


            for(int i = 0; i < emprestimos.size(); i++) {

                //vai pegar os emprestimos que esta multado, alterar estado da multa

                valorTotal += emprestimos.get(i).getValorMulta();
                System.out.println(emprestimos.get(i).getValorMulta());

                if(emprestimos.get(i).getEstaMultado()) {
                        emprestimos.get(i).setMultaPaga(true);
                }	
            }   

            this.setPenalizado(false);
    }

    /**************************************************************************************************/

    /** Método que retorna a quantidade de empréstimos atuais do cliente.
     * 
     * @return int - quantidade de empréstimos atuais do cliente
     */
    public int quantidadeEmprestimos() {
            return this.emprestimos.size();
    }

    /** Método que retorna o número máximo de empréstimos simultâneos que o
     * cliente pode realizar.
     * 
     * @return int - número máximo de empréstimos
     */
    public static int getMaximoEmprestimo() {
            return maximoEmprestimo;
    }
    
    /** Método que retorna o número de empréstimos ativos do cliente.
     * 
     * @return int - número de empréstimos ativos
     */
    public int getQuantEmprestimosAtivos() {
            return quantEmprestimosAtivos;
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
    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }
    
    /** Método toString que retorna os dados do objeto
     * 
     * @return String - dados do cliente
     */
    @Override
    public String toString() {
            return super.toString() +
                            ", Penalizado: " + penalizado +
                            ", Emprestimos: " + emprestimos;
    }
        
}

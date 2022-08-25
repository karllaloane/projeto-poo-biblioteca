package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

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

            Emprestimo e = new Emprestimo(this, item, data);

            item.setDisponivel(false);

            emprestimosAtuais.add(e);

            return e;
    }


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


    public void exibirEmprestimosAtuais() {
            if(this.emprestimosAtuais.size() == 0)
                    System.out.println("O cliente nao possui emprestimos atuais!");
            else {
                    for(int i = 1; i <= this.emprestimosAtuais.size(); i++) {
                            System.out.println(i + " - " + this.emprestimosAtuais.get(i).retornaDados());
                    }
            }
    }
    

    /**************************************************************************************************/

    public int quantidadeEmprestimosAtuais() {
            return this.emprestimosAtuais.size();
    }

    public static int getMaximoEmprestimo() {
            return maximoEmprestimo;
    }

    public static void setMaximoEmprestimo(int maximoEmprestimo) {
            Cliente.maximoEmprestimo = maximoEmprestimo;
    }

    public boolean isPenalizado() {
            return penalizado;
    }

    public void setPenalizado(boolean penalizado) {
            this.penalizado = penalizado;
    }
    

    @Override
    public String toString() {
            return super.toString() +
                            ", Penalizado: " + penalizado +
                            ", Emprestimos atuais: " + emprestimosAtuais;
    }
        
}

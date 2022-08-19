package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Biblioteca {
	
    private String nome;
    private String cnpj;
    
    private ArrayList<Emprestimo> historicoEmprestimos;
    private ArrayList<ItemAcervo> itens;	
    private ArrayList<Cliente> clientes;

    /************************* Singleton ***************************/

    private Biblioteca() {
            this.setNome("Biblioteca com nome legal");
            this.setCnpj("123456/0000");
            
            setHistoricoEmprestimos(new ArrayList<Emprestimo>());
            setItens(new ArrayList<ItemAcervo>());
            setClientes(new ArrayList<Cliente>());
            
            
    }

    public static Biblioteca biblioteca;

    public static Biblioteca getInstance(){
            if(biblioteca == null){
                    biblioteca = new Biblioteca();
    }

    return biblioteca;
}

    /**************************************************************************************************/

    public void addItens(ItemAcervo item) {
            this.itens.add(item);
    }

    public void addClientes(Cliente cliente) {
            this.clientes.add(cliente);
    }

    public void addHistoricoEmprestimos(Emprestimo emprestimo) {
            this.historicoEmprestimos.add(emprestimo);
    }

    /**************************************************************************************************/

    public ItemAcervo procurarItem(String titulo) {

            for(ItemAcervo i : this.itens) {
                    if(i.getTitulo().equals(titulo)) {
                            return i;
                    }
            }
            // lancar excecao
            return null;
    }


    public Cliente procurarCliente(String nome) {

            for(Cliente c : this.clientes) {
                    if(c.getNome().equals(nome)) {
                            return c;
                    }
            }
            // lancar excecao
            return null;
    }

    /**************************************************************************************************/
    //Relatorios

    public void exibirTodosItens() {
            itens.forEach(System.out::println);
    }

    public void exibirTodosEmprestimos() {
            System.out.println("Historico de Emprestimos:");
            historicoEmprestimos.forEach(System.out::println);
    }

    public void exibirEmprestimosAtivos() {
            //JOption
            System.out.println("Emprestimos ativos:");
            for (Emprestimo e: historicoEmprestimos) {
                    if(e.getDataDevolucao() == null)
                            System.out.println(e);
            }
            System.out.println("Fim do relatorio.");
    }

    public void exibirEmprestimosAtrasados() {
            //JOption
            for(Emprestimo e: historicoEmprestimos) {
                    if(e.getDataDevolucaoPrevista().compareTo(LocalDate.now()) < 0)
                            System.out.println(e);
            }
    }

    public double totalMultasPendentes() {

            double total = 0;

            for(Emprestimo e : historicoEmprestimos) {
                    if(e.getEstaMultado() && !e.isMultaPaga()) {
                            total += e.getValorMulta();
                    }
            }

            return total;
    }

    /**************************************************************************************************/

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getCnpj() {
            return cnpj;
    }

    public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
    }

    public ArrayList<Emprestimo> getHistoricoEmprestimos() {
            return historicoEmprestimos;
    }

    public void setHistoricoEmprestimos(ArrayList<Emprestimo> historicoEmprestimos) {
            this.historicoEmprestimos = historicoEmprestimos;
    }

    public ArrayList<ItemAcervo> getItens() {
            return itens;
    }

    public void setItens(ArrayList<ItemAcervo> itens) {
            this.itens = itens;
    }

    public ArrayList<Cliente> getClientes() {
            return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
            this.clientes = clientes;
    }

    @Override
    public String toString() {
            return "Biblioteca: " +
                            "Nome: '" + nome + '\'' +
                            ", CNPJ: '" + cnpj + '\'' +
                            ", Emprestimos: " + historicoEmprestimos +
                            "Itens :" + itens +
                            ", Clientes: " + clientes;
    }
}

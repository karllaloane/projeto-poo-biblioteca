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
		this.setNome("Biblioteca");
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
		throw new BuscaFalhouException("Nao foi localizado item com esse nome");
	}
	
	public Cliente procurarCliente(String cpf) {
		
		for(Cliente c : this.clientes) {
			if(c.getCpf().equals(cpf)) {
				return c;
			}
		}
		throw new BuscaFalhouException("Nao foi localizado cliente com esse cpf");
	}
	
        public ArrayList<Livro> listarLivrosNome(String nome){
            ArrayList<Livro> livros = new ArrayList<>();
            
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i) instanceof Livro){
                    System.out.println("Eh livro " + itens.get(i).getTitulo());
                    
                    if(itens.get(i).getTitulo().toLowerCase().contains(nome.toLowerCase())){
                        System.out.println("\nLivro " + itens.get(i).getTitulo());
                        livros.add((Livro)itens.get(i));
                    }
                        
                }
            }
            
            return livros; 
        }
        
        public ArrayList<Livro> listarLivrosAutor(String autor){
            ArrayList<Livro> livros = new ArrayList<>();
            
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i) instanceof Livro){
                    Livro l = (Livro)itens.get(i);
                    if(l.getAutor().toLowerCase().equals(autor.toLowerCase()))
                        livros.add((Livro)itens.get(i));
                }
            }
            
            return livros; 
        }
        
        public ArrayList<Periodico> listarPeriodicosNome(String nome){
            ArrayList<Periodico> livros = new ArrayList<>();
            
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i) instanceof Periodico){
                    if(itens.get(i).getTitulo().contains(nome))
                        livros.add((Periodico)itens.get(i));
                }
            }
            
            return livros; 
        }
        
	/**************************************************************************************************/
	//Relatorios
	
	public void exibirTodosItens() {
		//itens.forEach(System.out::println);
	}

	public void exibirTodosEmprestimos() {
		System.out.println("Historico de Emprestimos:");
		//historicoEmprestimos.forEach(System.out::println);
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
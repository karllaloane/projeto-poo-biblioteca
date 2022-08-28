package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

/** Classe para o objeto biblioteca, em que serão armazenados dados como
* nome, cnpj, lista de itens e lista de clientes.
* @version 1.0
* @since Release 1
*
*/

public final class Biblioteca {
	
	private String nome;
	private String cnpj;
	
	private ArrayList<ItemAcervo> itens;	
	private ArrayList<Cliente> clientes;
	
	//----------------------- Singleton ---------------------------//
	
	private Biblioteca() {
		this.setNome("Biblioteca");
		this.setCnpj("123456/0000");
		//setHistoricoEmprestimos(new ArrayList<Emprestimo>());
		setItens(new ArrayList<ItemAcervo>());
		setClientes(new ArrayList<Cliente>());	  
	}
	
	public static Biblioteca biblioteca;
        
        
	/** Método para instanciar a biblioteca utilizando o padrão singleton 
        * O método verifica se já foi criada uma instância, caso em que a retorna
        * Caso contrário, ele a cria.
        * @return biblioteca - instância da biblioteca
        */
	public static Biblioteca getInstance(){
		if(biblioteca == null){
			biblioteca = new Biblioteca();
        }
        
        return biblioteca;
    }

	//------------------------------------------------------------------//
        
        
	/** Método para adicionar um item (livro/periódico) à lista de itens (acervo)
         * 
         * @param item - objeto da classe Livro ou Periodico
         */
	public void addItens(ItemAcervo item) {
		this.itens.add(item);
	}
	
        /** Método que adiciona cliente à lista de clientes
         * 
         * @param cliente - objeto da classe Cliente
         */
	public void addClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}
        
        /** Método que remove um cliente da lista de clientes
         * 
         * @param cliente - objeto da classe Cliente a ser removido
         */
        public void removeCliente(Cliente cliente) {
            if(cliente.isPenalizado() == true)
                throw new ClienteComPendenciaException("O cliente não pode ser excluído, pois possui multa pendente");
            this.clientes.remove(cliente);
        }
        
        /** Método que remove item da lista de itens
         * 
         * @param item - ItemAcervo que será removido
         */
        public void removeItem(ItemAcervo item) {
            if(item.isDisponivel() == false)
                throw new ItemIndisponivelException("O item não pode ser excluído, pois está indisponível");
            this.itens.remove(item);
        }
		
	//------------------------------------------------------------------//
        
        
	/** Método que recebe uma String e realiza uma busca no acervo de itens
         * por títulos que correspondam ao nome exato
         * @param titulo - String com trecho do título do item buscado
         * @return i - ItemAcervo - objetos localizados com o título informado
         *
         */
	public ItemAcervo procurarItem(String titulo) {
		
		for(ItemAcervo i : this.itens) {
			if(i.getTitulo().equals(titulo)) {
				return i;
			}
		}
		throw new BuscaFalhouException("Nao foi localizado item com esse nome");
	}
        
        
	/** Método que recebe uma String de CPF e realiza busca na lista de clientes
         * 
         * @param cpf - String
         * @return c - Cliente com o cpf informado
         *
         */
	public Cliente procurarCliente(String cpf) {
		
		for(Cliente c : this.clientes) {
			if(c.getCpf().equals(cpf)) {
				return c;
			}
		}
		throw new BuscaFalhouException("Nao foi localizado cliente com esse cpf");
	}
	
        /** Método que lista os livros que contenham no título a String informada
         * 
         * @param nome - String com trecho do título buscado
         * @return livros - ArrayList com os livros localizados
         */
        public ArrayList<Livro> listarLivrosNome(String nome){
            ArrayList<Livro> livros = new ArrayList<>();
            
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i) instanceof Livro){                    
                    if(itens.get(i).getTitulo().toLowerCase().contains(nome.toLowerCase())){
                        livros.add((Livro)itens.get(i));
                    } 
                }
            }
            
            return livros; 
        }
        
        
        /** Método que lista os livros escritos por determinado autor
         * 
         * @param autor - String com nome do autor
         * @return livros - ArrayList com os livros localizados
         */
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
        
        /** Método que lista os periódicos localizados a partir de um trecho do título
         * 
         * @param nome - String com trecho do título buscado
         * @return periodicos - ArrayList de periódicos localizados
         */
        public ArrayList<Periodico> listarPeriodicosNome(String nome){
            ArrayList<Periodico> periodicos = new ArrayList<>();
            
            for(int i = 0; i < itens.size(); i++){
                if(itens.get(i) instanceof Periodico){
                    if(itens.get(i).getTitulo().toLowerCase().contains(nome.toLowerCase()))
                        periodicos.add((Periodico)itens.get(i));
                }
            }
            
            return periodicos; 
        }
        
	//-------------------------------------------------------------------------------//
	//Relatorios
	
        /** Método que retorna todos os empréstimos em aberto
         * 
         * @return emprestimos - ArrayList de emprestimos em aberto
         */
	public ArrayList<Emprestimo> buscaEmprestimosEmAberto() {
                
                ArrayList<Emprestimo> emprestimos = new ArrayList<>();
                
                for(Cliente c : clientes){
                    for (Emprestimo e: c.getEmprestimos()) {
			if(e.getDataDevolucao() == null)
				emprestimos.add(e);
                    }
                }
                
                return emprestimos;
	}
        
        /** Método que retorna todos os empréstimos existentes
         * 
         * @return emprestimos - ArrayList de emprestimos
         */
	public ArrayList<Emprestimo> buscTodosEmprestimos() {
                
                ArrayList<Emprestimo> emprestimos = new ArrayList<>();
                
                for(Cliente c : clientes){
                    for (Emprestimo e: c.getEmprestimos()) {
				emprestimos.add(e);
                    }
                }
                
                return emprestimos;
	}
	

        /** Método que calcula o valor total das multas pendentes de pagamento
         * 
         * @return total - Double que representa o valor calculado
         */
	public double totalMultasPendentes() {

		double total = 0;

		for(Cliente c : clientes){
                    for (Emprestimo e: c.getEmprestimos()) {
			if(e.getEstaMultado() && !e.isMultaPaga()) {
				total += e.getValorMulta();
			}
                    }
                }

		return total;
	}
	
	//----------------------------------------------------------------//
	
        /** Método que retorna o nome da biblioteca
         * 
         * @return nome - String com o nome
         */
	public String getNome() {
		return nome;
	}

        /** Método que atribui nome à biblioteca
         * 
         * @param nome - String com o nome desejado
         */
	public void setNome(String nome) {
		this.nome = nome;
	}

        /** Método que retorna o CNPJ da biblioteca
         * 
         * @return cnpj - String com o CNPJ
         */
	public String getCnpj() {
		return cnpj;
	}

        /** Método que atribui um CNPJ à biblioteca
         * 
         * @param cnpj - String com o CNPJ
         */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

        /** Método que retorna ArrayList com os itens do acervo
         * 
         * @return itens - ArrayList de ItemAcervo
         */
	public ArrayList<ItemAcervo> getItens() {
		return itens;
	}

        /** Método que atribui uma ArrayList de ItemAcervo ao atributo
         * 
         * @param itens - ArrayList de ItemAcervo 
         */
	public void setItens(ArrayList<ItemAcervo> itens) {
		this.itens = itens;
	}

        /** Método que retorna a ArrayList de clientes do atributo
         * 
         * @return clientes - ArrayList de clientes
         */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

        /** Método que atribui uma ArrayList de clientes ao atributo
         * 
         * @param clientes - ArrayList de clientes
         */
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

        /** Método toString que retorna os dados do objeto
         * 
         * @return String com os dados
         */
	@Override
	public String toString() {
		return "Biblioteca: " +
				"Nome: '" + nome + '\'' +
				", CNPJ: '" + cnpj + '\'' +
				"Itens :" + itens +
				", Clientes: " + clientes;
	}
}
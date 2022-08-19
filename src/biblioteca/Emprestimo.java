package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo implements Publicavel{
	
    private static int maxRenovacao = 3;
    private int quantRenovado = 0;

    private double valorMulta;
    private boolean multaPaga;
    private boolean estaMultado;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista; //manter ou deixar apenas dataDevolucao
    private LocalDate dataDevolucao;

    private Cliente cliente;
    private ItemAcervo item;

    public Emprestimo(Cliente cliente, ItemAcervo item, LocalDate dataEmprestimo) {
            this.quantRenovado = 0;
            this.cliente = cliente;
            this.item = item;
            this.item.setDisponivel(false);
            this.dataEmprestimo = dataEmprestimo;
            dataDevolucaoPrevista = this.dataEmprestimo.plusDays(item.retornaDiasEmprestimo());
            setMultaPaga(false);
            setEstaMultado(false);
    }


    public double calcularMulta() {

            this.valorMulta = this.item.getMultaDiaria() * this.dataDevolucaoPrevista.until(dataDevolucao, ChronoUnit.DAYS);

            if(valorMulta > 0) {
                    setMultaPaga(false);
                    setEstaMultado(true);
            }

            return this.valorMulta;
    }


    public boolean renovar() {

            if(quantRenovado < maxRenovacao) { //arrumar melhor jeito de guardar a quant de emprestimos

                    quantRenovado++;

                    //manter a devolucao como sendo data do dia + dias emprestimo
                    //ou dataPrevista + dias emprestimo ?
                    dataDevolucaoPrevista = this.dataDevolucaoPrevista.plusDays(item.retornaDiasEmprestimo());

                    return true;

            }

            // lancar excecao?
            //JOption
            System.out.println("Numero de renovacoes excedido");
            return false;
    }



    //**************************************************************************************************//

    public int getQuantidadeRenovacao() {
            return quantRenovado;
    }

    public void setQuantidadeRenovacao(int quantidadeRenovacao) {
            this.quantRenovado = quantidadeRenovacao;
    }

    public double getValorMulta() {
            return valorMulta;
    }

    public void setValorMulta(int valorMulta) {
            this.valorMulta = valorMulta;
    }

    public boolean isMultaPaga() {
            return multaPaga;
    }

    public void setMultaPaga(boolean multaPaga) {
            this.multaPaga = multaPaga;
    }

    public Cliente getCliente() {
            return cliente;
    }

    public void setCliente(Cliente cliente) {
            this.cliente = cliente;
    }

    public ItemAcervo getItem() {
            return item;
    }

    public void setItem(ItemAcervo item) {
            this.item = item;
    }

    public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
            this.dataEmprestimo = dataEmprestimo;
    }

    public boolean getEstaMultado() {
            return estaMultado;
    }

    public void setEstaMultado(boolean estaMultado) {
            this.estaMultado = estaMultado;
    }

    public LocalDate getDataDevolucaoPrevista() {
            return dataDevolucaoPrevista;
    }

    public void setDataDevolucao(LocalDate data) {
            this.dataDevolucao = data;
    }

    public LocalDate getDataDevolucao() {
            return dataDevolucao;
    }

    @Override
    public String retornaDados() {
            return "Emprestimo: " +
                            "Item: " + item +
                            ", Cliente: " + cliente +
                            ", Renovacoes: " + quantRenovado +
                            ", Data do Emprestimo: " + dataEmprestimo +
                            ", Data de Devolucao: " + dataDevolucao +
                            '}';
    }
}

package Model;

public class Produto extends Cadastro {
    private Double quantidade;
    private Double preco;

    public Produto() {
    }

    public Produto(Double quantidade, Double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

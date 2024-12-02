package Model;

public class Carne extends Produto{
    private int idCarne;
    private String nomeCarne;

    public Carne() {
    }

    public Carne(int idCarne, String nomeCarne, Double quantidade, Double preco) {
        super(quantidade, preco);
        this.idCarne = idCarne;
        this.nomeCarne = nomeCarne;
    }

    public int getIdCarne() {
        return idCarne;
    }

    public void setIdCarne(int idCarne) {
        this.idCarne = idCarne;
    }

    public String getNomeCarne() {
        return nomeCarne;
    }

    public void setNomeCarne(String nomeCarne) {
        this.nomeCarne = nomeCarne;
    }
}

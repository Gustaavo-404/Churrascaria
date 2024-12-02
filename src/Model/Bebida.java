package Model;

public class Bebida extends Produto {
    private int idBebida;
    private String nomeBebida;

    public Bebida() {
    }

    public Bebida(int idBebida, String nomeBebida, Double quantidade, Double preco) {
        super(quantidade, preco); 
        this.idBebida = idBebida;
        this.nomeBebida = nomeBebida;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }
    
}
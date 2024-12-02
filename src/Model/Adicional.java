package Model;

public class Adicional extends Produto{
    private int idAdicional;
    private String nomeAdicional;

    public Adicional() {
    }

    public Adicional(int idAdicional, String nomeAdicional, Double quantidade, Double preco) {
        super(quantidade, preco);
        this.idAdicional = idAdicional;
        this.nomeAdicional = nomeAdicional;
    }

    public int getIdAdicional() {
        return idAdicional;
    }

    public void setIdAdicional(int idAdicional) {
        this.idAdicional = idAdicional;
    }

    public String getNomeAdicional() {
        return nomeAdicional;
    }

    public void setNomeAdicional(String nomeAdicional) {
        this.nomeAdicional = nomeAdicional;
    }
    
}
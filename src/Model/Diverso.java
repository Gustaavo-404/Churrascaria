package Model;

public class Diverso extends Cadastro {
    
    private int idDiverso;
    private String nomeDiverso;
    private int Quantidade;
    private String Estado;

    public Diverso() {
    }

    public Diverso(int idDiverso, String nomeDiverso, int Quantidade, String Estado) {
        this.idDiverso = idDiverso;
        this.nomeDiverso = nomeDiverso;
        this.Quantidade = Quantidade;
        this.Estado = Estado;
    }

    public int getIdDiverso() {
        return idDiverso;
    }

    public void setIdDiverso(int idDiverso) {
        this.idDiverso = idDiverso;
    }

    public String getNomeDiverso() {
        return nomeDiverso;
    }

    public void setNomeDiverso(String nomeDiverso) {
        this.nomeDiverso = nomeDiverso;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
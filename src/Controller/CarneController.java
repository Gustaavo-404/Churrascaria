package Controller;

import java.sql.*;
import java.util.*;
import Model.*;

public class CarneController extends CadastroController {

    public CarneController() throws Exception {
        super();
    }

    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        
        Carne carne = (Carne) cadastro;
        
        String sql = "INSERT INTO Carne (NomeCarne, Quantidade, Preco) VALUES (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, carne.getNomeCarne());
        ps.setDouble(2, carne.getQuantidade());
        ps.setDouble(3, carne.getPreco());
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        
        Carne carne = (Carne) cadastro;
        
        String sql = "update Carne" + " set NomeCarne = ?, Quantidade = ?, Preco = ?" + " where idCarne = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, carne.getNomeCarne());
        ps.setDouble(2, carne.getQuantidade());
        ps.setDouble(3, carne.getPreco());
        ps.setInt(4, carne.getIdCarne());
        ps.execute();
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        
        Carne carne = (Carne) cadastro;
        
        String sql = "delete from Carne where idCarne = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, carne.getIdCarne());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        
        ArrayList<Cadastro> lista = new ArrayList<>();
        
        String sql = "select * from Carne";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Carne carne = new Carne();
            carne.setIdCarne(rs.getInt("idCarne"));
            carne.setNomeCarne(rs.getString("NomeCarne"));
            carne.setQuantidade(rs.getDouble("Quantidade"));
            carne.setPreco(rs.getDouble("Preco"));
            
            lista.add(carne);
        }
        
        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Carne carne = null;

        String sql = "SELECT * FROM Carne WHERE idCarne = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            carne = new Carne();
            carne.setIdCarne(rs.getInt("idCarne"));
            carne.setNomeCarne(rs.getString("NomeCarne"));
            carne.setQuantidade(rs.getDouble("Quantidade"));
            carne.setPreco(rs.getDouble("Preco"));
        } else {
            throw new Exception("Carne não encontrada para o código: " + codigo);
        }

        return carne;
    }
      
}
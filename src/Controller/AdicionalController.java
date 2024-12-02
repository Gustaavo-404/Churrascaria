package Controller;

import java.sql.*;
import java.util.*;
import Model.*;

public class AdicionalController extends CadastroController{

    public AdicionalController() throws Exception {
        super();
    }
    
    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        Adicional adicional = (Adicional) cadastro;
        
        String sql = "INSERT INTO Adicional (NomeAdicional, Quantidade, Preco) VALUES (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, adicional.getNomeAdicional());
        ps.setDouble(2, adicional.getQuantidade());
        ps.setDouble(3, adicional.getPreco());
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        Adicional adicional = (Adicional) cadastro;
        
        String sql = "update Adicional" + " set NomeAdicional = ?, Quantidade = ?, Preco = ?" + " where idAdicional = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, adicional.getNomeAdicional());
        ps.setDouble(2, adicional.getQuantidade());
        ps.setDouble(3, adicional.getPreco());
        ps.setInt(4, adicional.getIdAdicional());
        ps.execute();
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        Adicional adicional = (Adicional) cadastro;
        
        String sql = "delete from Adicional where idAdicional = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, adicional.getIdAdicional());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        ArrayList<Cadastro> lista = new ArrayList<>();
        
        String sql = "select * from Adicional";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Adicional adicional = new Adicional();
            adicional.setIdAdicional(rs.getInt("idAdicional"));
            adicional.setNomeAdicional(rs.getString("NomeAdicional"));
            adicional.setQuantidade(rs.getDouble("Quantidade"));
            adicional.setPreco(rs.getDouble("Preco"));
            
            lista.add(adicional);
        }
        
        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Adicional adicional = null;

        String sql = "SELECT * FROM Adicional WHERE idAdicional = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            adicional = new Adicional();
            adicional.setIdAdicional(rs.getInt("idAdicional"));
            adicional.setNomeAdicional(rs.getString("NomeAdicional"));
            adicional.setQuantidade(rs.getDouble("Quantidade"));
            adicional.setPreco(rs.getDouble("Preco"));
        } else {
            throw new Exception("Bebida não encontrada para o código: " + codigo);
        }

        return adicional;
    }
      
}
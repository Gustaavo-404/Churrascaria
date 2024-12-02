package Controller;

import Model.Cadastro;
import Model.Diverso;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

public class DiversoController extends CadastroController {

    public DiversoController() throws Exception {
        super();
    }

    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        Diverso diverso = (Diverso) cadastro;
        
        String sql = "INSERT INTO Diverso (NomeDiverso, Quantidade, Estado) VALUES (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, diverso.getNomeDiverso());
        ps.setInt(2, diverso.getQuantidade());
        ps.setString(3, diverso.getEstado());
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        Diverso diverso = (Diverso) cadastro;
        
        String sql = "update Diverso" + " set NomeDiverso = ?, Quantidade = ?, Estado = ?" + " where idDiverso = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, diverso.getNomeDiverso());
        ps.setInt(2, diverso.getQuantidade());
        ps.setString(3, diverso.getEstado());
        ps.setInt(4, diverso.getIdDiverso());
        ps.execute();
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        Diverso diverso = (Diverso) cadastro;
        
        String sql = "delete from Diverso where idDiverso = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, diverso.getIdDiverso());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        ArrayList<Cadastro> lista = new ArrayList<>();
        
        String sql = "select * from Diverso";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Diverso diverso = new Diverso();
            diverso.setIdDiverso(rs.getInt("idDiverso"));
            diverso.setNomeDiverso(rs.getString("NomeDiverso"));
            diverso.setQuantidade(rs.getInt("Quantidade"));
            diverso.setEstado(rs.getString("Estado"));
            
            lista.add(diverso);
        }
        
        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Diverso diverso = null;

        String sql = "SELECT * FROM Diverso WHERE idDiverso = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            diverso = new Diverso();
            diverso.setIdDiverso(rs.getInt("idDiverso"));
            diverso.setNomeDiverso(rs.getString("NomeDiverso"));
            diverso.setQuantidade(rs.getInt("Quantidade"));
            diverso.setEstado(rs.getString("Estado"));
        } else {
            throw new Exception("Item não encontrado para o código: " + codigo);
        }

        return diverso;
    }
    
}

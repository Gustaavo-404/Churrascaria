package Controller;

import Model.Cadastro;
import Model.Evento;
import java.util.*;
import java.sql.*;

public class EventoController extends CadastroController{

    public EventoController() throws Exception {
        super();
    }
    
    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        Evento evento = (Evento) cadastro;

        String sql = "INSERT INTO Evento (NomeEvento, Descricao, DataEvento, HorarioInicio, HorarioTermino) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, evento.getNomeEvento());
        ps.setString(2, evento.getDescricao());
        ps.setDate(3, evento.getDataEvento());  
        ps.setTime(4, java.sql.Time.valueOf(evento.getHorarioInicio()));  
        ps.setTime(5, java.sql.Time.valueOf(evento.getHorarioTermino()));  
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        Evento evento = (Evento) cadastro;

        String sql = "UPDATE Evento SET NomeEvento = ?, Descricao = ?, DataEvento = ?, HorarioInicio = ?, HorarioTermino = ? WHERE idEvento = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, evento.getNomeEvento());
        ps.setString(2, evento.getDescricao());
        ps.setDate(3, evento.getDataEvento());
        ps.setTime(4, java.sql.Time.valueOf(evento.getHorarioInicio()));
        ps.setTime(5, java.sql.Time.valueOf(evento.getHorarioTermino()));
        ps.setInt(6, evento.getIdEvento());
        ps.execute();
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        Evento evento = (Evento) cadastro;

        String sql = "DELETE FROM Evento WHERE idEvento = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, evento.getIdEvento());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        ArrayList<Cadastro> lista = new ArrayList<>();

        String sql = "SELECT * FROM Evento";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setIdEvento(rs.getInt("idEvento"));
            evento.setNomeEvento(rs.getString("NomeEvento"));
            evento.setDescricao(rs.getString("Descricao"));
            evento.setDataEvento(rs.getDate("DataEvento"));
            evento.setHorarioInicio(rs.getTime("HorarioInicio").toLocalTime());
            evento.setHorarioTermino(rs.getTime("HorarioTermino").toLocalTime());

            lista.add(evento);
        }

        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Evento evento = null;

        String sql = "SELECT * FROM Evento WHERE idEvento = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            evento = new Evento();
            evento.setIdEvento(rs.getInt("idEvento"));
            evento.setNomeEvento(rs.getString("NomeEvento"));
            evento.setDescricao(rs.getString("Descricao"));
            evento.setDataEvento(rs.getDate("DataEvento"));
            evento.setHorarioInicio(rs.getTime("HorarioInicio").toLocalTime());
            evento.setHorarioTermino(rs.getTime("HorarioTermino").toLocalTime());
        } else {
            throw new Exception("Evento não encontrado para o código: " + codigo);
        }

        return evento;
    }
    
}
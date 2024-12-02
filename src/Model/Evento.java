package Model;

import Model.Cadastro;
import java.sql.Date;
import java.time.LocalTime;

public class Evento extends Cadastro {
    private int idEvento;
    private String nomeEvento;
    private String descricao;
    private java.sql.Date dataEvento;
    private LocalTime horarioInicio;
    private LocalTime horarioTermino;

    public Evento() {
    }

    public Evento(int idEvento, String nomeEvento, String descricao, Date dataEvento, LocalTime horarioInicio, LocalTime horarioTermino) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.dataEvento = dataEvento;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(LocalTime horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public void setHorarioInicioFromString(String horarioInicioStr) {
        this.horarioInicio = LocalTime.parse(horarioInicioStr);
    }

    public void setHorarioTerminoFromString(String horarioTerminoStr) {
        this.horarioTermino = LocalTime.parse(horarioTerminoStr);
    }
}


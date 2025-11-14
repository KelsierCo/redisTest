package com.bbva.cgto.dto.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class EntradaDTO implements Serializable {
    private static final long serialVersionUID = 2931699728946643245L;

    private String identificadorOficina;
    private String identificadorTurno;
    private String conceptoTurno;
    private int tipoAtencion;
    private int prioridadServicio;
    private int prioridadSegmento;

    public String getIdentificadorOficina() {
        return identificadorOficina;
    }

    public void setIdentificadorOficina(String identificadorOficina) {
        this.identificadorOficina = identificadorOficina;
    }

    public String getIdentificadorTurno() {
        return identificadorTurno;
    }

    public void setIdentificadorTurno(String identificadorTurno) {
        this.identificadorTurno = identificadorTurno;
    }

    public String getConceptoTurno() {
        return conceptoTurno;
    }

    public void setConceptoTurno(String conceptoTurno) {
        this.conceptoTurno = conceptoTurno;
    }

    public int getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(int tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public int getPrioridadServicio() {
        return prioridadServicio;
    }

    public void setPrioridadServicio(int prioridadServicio) {
        this.prioridadServicio = prioridadServicio;
    }

    public int getPrioridadSegmento() {
        return prioridadSegmento;
    }

    public void setPrioridadSegmento(int prioridadSegmento) {
        this.prioridadSegmento = prioridadSegmento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("idOficina", identificadorOficina)
                .append("idTurno", identificadorTurno)
                .append("concepto", conceptoTurno)
                .append("atencionCliente", tipoAtencion)
                .toString();
    }
}

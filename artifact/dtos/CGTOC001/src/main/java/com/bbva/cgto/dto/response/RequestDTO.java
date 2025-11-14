package com.bbva.cgto.dto.response;

import java.io.Serializable;

public class RequestDTO implements Serializable {
    private static final long serialVersionUID = 2931699728946643245L;

    private String identificadorFila;
    private String identificadorTurno;
    private double ponderado;

    public String getIdentificadorFila() {
        return identificadorFila;
    }

    public void setIdentificadorFila(String identificadorFila) {
        this.identificadorFila = identificadorFila;
    }

    public String getIdentificadorTurno() {
        return identificadorTurno;
    }

    public void setIdentificadorTurno(String identificadorTurno) {
        this.identificadorTurno = identificadorTurno;
    }

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "identificadorFila='" + identificadorFila + '\'' +
                ", identificadorTurno='" + identificadorTurno + '\'' +
                ", ponderado=" + ponderado +
                '}';
    }
}

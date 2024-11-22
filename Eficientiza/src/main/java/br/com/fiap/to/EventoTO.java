package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class EventoTO {

    private int idEvento;
    @NotBlank private String tituloEvento;
    @NotBlank private String detalhesEvento;
    private LocalDate dataEvento;
    @NotBlank  private String urlImagemEvento;

    public EventoTO() {
    }

    public EventoTO(int idEvento, String tituloEvento, String detalhesEvento, LocalDate dataEvento, String urlImagemEvento) {
        this.idEvento = idEvento;
        this.tituloEvento = tituloEvento;
        this.detalhesEvento = detalhesEvento;
        this.dataEvento = dataEvento;
        this.urlImagemEvento = urlImagemEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDetalhesEvento() {
        return detalhesEvento;
    }

    public void setDetalhesEvento(String detalhesEvento) {
        this.detalhesEvento = detalhesEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getUrlImagemEvento() {
        return urlImagemEvento;
    }

    public void setUrlImagemEvento(String urlImagemEvento) {
        this.urlImagemEvento = urlImagemEvento;
    }
}

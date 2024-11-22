package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class ContatoTO {

    private int idContato;
    @NotBlank private String nomeContato;
    @NotBlank private String emailContato;
    @NotBlank private String descricaoContato;

    public ContatoTO() {
    }

    public ContatoTO(int idContato, String nomeContato, String emailContato, String descricaoContato) {
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.emailContato = emailContato;
        this.descricaoContato = descricaoContato;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getDescricaoContato() {
        return descricaoContato;
    }

    public void setDescricaoContato(String descricaoContato) {
        this.descricaoContato = descricaoContato;
    }
}

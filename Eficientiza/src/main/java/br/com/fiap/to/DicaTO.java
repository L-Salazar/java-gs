package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class DicaTO {

    private int idDica;
    @NotBlank private String tituloDica;
    @NotBlank private String descricaoDica;

    public DicaTO() {
    }

    public DicaTO(int idDica, String tituloDica, String descricaoDica) {
        this.idDica = idDica;
        this.tituloDica = tituloDica;
        this.descricaoDica = descricaoDica;
    }

    public int getIdDica() {
        return idDica;
    }

    public void setIdDica(int idDica) {
        this.idDica = idDica;
    }

    public String getTituloDica() {
        return tituloDica;
    }

    public void setTituloDica(String tituloDica) {
        this.tituloDica = tituloDica;
    }

    public String getDescricaoDica() {
        return descricaoDica;
    }

    public void setDescricaoDica(String descricaoDica) {
        this.descricaoDica = descricaoDica;
    }
}

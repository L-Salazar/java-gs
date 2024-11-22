package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class PostagemTO {

    private int idPostagem;
    @NotBlank private String tituloPostagem;
    @NotBlank private String descricaoPostagem;

    public PostagemTO() {
    }

    public PostagemTO(int idPostagem, String tituloPostagem, String descricaoPostagem) {
        this.idPostagem = idPostagem;
        this.tituloPostagem = tituloPostagem;
        this.descricaoPostagem = descricaoPostagem;
    }

    public int getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(int idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getTituloPostagem() {
        return tituloPostagem;
    }

    public void setTituloPostagem(String tituloPostagem) {
        this.tituloPostagem = tituloPostagem;
    }

    public String getDescricaoPostagem() {
        return descricaoPostagem;
    }

    public void setDescricaoPostagem(String descricaoPostagem) {
        this.descricaoPostagem = descricaoPostagem;
    }
}

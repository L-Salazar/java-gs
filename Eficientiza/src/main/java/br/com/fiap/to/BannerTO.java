package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class BannerTO {

    private int idBanner;
    @NotBlank private String urlBanner;
    private int idEvento;

    public BannerTO() {
    }

    public BannerTO(int idBanner, String urlBanner, int idEvento) {
        this.idBanner = idBanner;
        this.urlBanner = urlBanner;
        this.idEvento = idEvento;
    }

    public int getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(int idBanner) {
        this.idBanner = idBanner;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
}

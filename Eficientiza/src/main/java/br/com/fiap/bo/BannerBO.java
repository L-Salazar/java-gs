package br.com.fiap.bo;

import br.com.fiap.dao.BannerDAO;
import br.com.fiap.to.BannerTO;

import java.util.ArrayList;

public class BannerBO {

    private BannerDAO bannerDAO;

    public ArrayList<BannerTO> findAll() {
        bannerDAO = new BannerDAO();
        return bannerDAO.findAll();
    }

    public BannerTO findById(int idBanner) {
        bannerDAO = new BannerDAO();
        return bannerDAO.findById(idBanner);
    }

    public BannerTO save(BannerTO banner) {
        bannerDAO = new BannerDAO();
        return bannerDAO.save(banner);
    }

    public boolean delete(int idBanner) {
        bannerDAO = new BannerDAO();
        return bannerDAO.delete(idBanner);
    }

    public BannerTO update(BannerTO banner) {
        bannerDAO = new BannerDAO();
        return bannerDAO.update(banner);
    }

}

package br.com.fiap.bo;

import br.com.fiap.dao.DicaDAO;
import br.com.fiap.to.DicaTO;

import java.util.ArrayList;

public class DicaBO {

    private DicaDAO dicaDAO;

    public ArrayList<DicaTO> findAll() {
        dicaDAO = new DicaDAO();
        return dicaDAO.findAll();
    }

    public DicaTO findById(int idDica) {
        dicaDAO = new DicaDAO();
        return dicaDAO.findById(idDica);
    }

    public DicaTO save(DicaTO dica) {
        dicaDAO = new DicaDAO();
        return dicaDAO.save(dica);
    }

    public boolean delete(int idDica) {
        dicaDAO = new DicaDAO();
        return dicaDAO.delete(idDica);
    }

    public DicaTO update(DicaTO dica) {
        dicaDAO = new DicaDAO();
        return dicaDAO.update(dica);
    }

}

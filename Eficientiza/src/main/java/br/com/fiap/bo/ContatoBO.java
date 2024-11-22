package br.com.fiap.bo;

import br.com.fiap.dao.ContatoDAO;
import br.com.fiap.to.ContatoTO;

import java.util.ArrayList;

public class ContatoBO {

    private ContatoDAO contatoDAO;

    public ArrayList<ContatoTO> findAll() {
        contatoDAO = new ContatoDAO();
        return contatoDAO.findAll();
    }

    public ContatoTO findById(int idContato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.findById(idContato);
    }

    public ContatoTO save(ContatoTO contato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.save(contato);
    }

    public boolean delete(int idContato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.delete(idContato);
    }

    public ContatoTO update(ContatoTO contato) {
        contatoDAO = new ContatoDAO();
        return contatoDAO.update(contato);
    }

}

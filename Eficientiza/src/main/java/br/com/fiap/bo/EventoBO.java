package br.com.fiap.bo;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.to.EventoTO;

import java.util.ArrayList;

public class EventoBO {

    private EventoDAO eventoDAO;

    public ArrayList<EventoTO> findAll() {
        eventoDAO = new EventoDAO();
        return eventoDAO.findAll();
    }

    public EventoTO findById(int idEvento) {
        eventoDAO = new EventoDAO();
        return eventoDAO.findById(idEvento);
    }

    public EventoTO save(EventoTO evento) {
        eventoDAO = new EventoDAO();
        return eventoDAO.save(evento);
    }

    public boolean delete(int idEvento) {
        eventoDAO = new EventoDAO();
        return eventoDAO.delete(idEvento);
    }

    public EventoTO update(EventoTO evento) {
        eventoDAO = new EventoDAO();
        return eventoDAO.update(evento);
    }

}

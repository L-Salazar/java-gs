package br.com.fiap.bo;

import br.com.fiap.dao.PostagemDAO;
import br.com.fiap.to.PostagemTO;

import java.util.ArrayList;

public class PostagemBO {

    private PostagemDAO postagemDAO;

    public ArrayList<PostagemTO> findAll() {
        postagemDAO = new PostagemDAO();
        return postagemDAO.findAll();
    }

    public PostagemTO findById(int idPostagem) {
        postagemDAO = new PostagemDAO();
        return postagemDAO.findById(idPostagem);
    }

    public PostagemTO save(PostagemTO postagem) {
        postagemDAO = new PostagemDAO();
        return postagemDAO.save(postagem);
    }

    public boolean delete(int idPostagem) {
        postagemDAO = new PostagemDAO();
        return postagemDAO.delete(idPostagem);
    }

    public PostagemTO update(PostagemTO postagem) {
        postagemDAO = new PostagemDAO();
        return postagemDAO.update(postagem);
    }

}

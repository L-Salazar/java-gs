package br.com.fiap.dao;

import br.com.fiap.to.PostagemTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostagemDAO extends Repository {

    public ArrayList<PostagemTO> findAll() {
        ArrayList<PostagemTO> postagens = new ArrayList<>();
        String sql = "SELECT * FROM tb_postagens ORDER BY id_postagem";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PostagemTO postagem = new PostagemTO();
                    postagem.setIdPostagem(rs.getInt("id_postagem"));
                    postagem.setTituloPostagem(rs.getString("nm_titulo_postagem"));
                    postagem.setDescricaoPostagem(rs.getString("ds_descricao_postagem"));
                    postagens.add(postagem);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar postagens: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return postagens;
    }

    public PostagemTO findById(int id) {
        PostagemTO postagem = new PostagemTO();
        String sql = "SELECT * FROM tb_postagens WHERE id_postagem = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                postagem.setIdPostagem(rs.getInt("id_postagem"));
                postagem.setTituloPostagem(rs.getString("nm_titulo_postagem"));
                postagem.setDescricaoPostagem(rs.getString("ds_descricao_postagem"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar postagem: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return postagem;
    }

    public PostagemTO save(PostagemTO postagem) {
        String sql = "INSERT INTO tb_postagens (nm_titulo_postagem, ds_descricao_postagem) VALUES (?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, postagem.getTituloPostagem());
            ps.setString(2, postagem.getDescricaoPostagem());
            if(ps.executeUpdate() > 0){
                return postagem;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar postagem: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public PostagemTO update(PostagemTO postagem) {
        String sql = "UPDATE tb_postagens SET nm_titulo_postagem = ?, ds_descricao_postagem = ? WHERE id_postagem = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, postagem.getTituloPostagem());
            ps.setString(2, postagem.getDescricaoPostagem());
            ps.setInt(3, postagem.getIdPostagem());
            if(ps.executeUpdate() > 0){
                return postagem;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar postagem: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tb_postagens WHERE id_postagem = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar postagem: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }


}

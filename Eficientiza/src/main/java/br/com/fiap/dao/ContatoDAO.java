package br.com.fiap.dao;

import br.com.fiap.to.ContatoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDAO extends Repository{

    public ArrayList<ContatoTO> findAll() {
        ArrayList<ContatoTO> contatos = new ArrayList<>();
        String sql = "SELECT * FROM tb_contato";

        try (PreparedStatement ps = getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContatoTO contato = new ContatoTO();
                contato.setIdContato(rs.getInt("id_contato"));
                contato.setNomeContato(rs.getString("nm_contato"));
                contato.setEmailContato(rs.getString("nm_email"));
                contato.setDescricaoContato(rs.getString("ds_contato"));
                contatos.add(contato);
            }

            if (contatos.isEmpty()) {
                System.out.println("Nenhum contato encontrado no banco de dados.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar contatos: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return contatos;
    }


    public ContatoTO findById(int id) {
        ContatoTO contato = new ContatoTO();
        String sql = "SELECT * FROM tb_contato WHERE id_contato = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contato.setIdContato(rs.getInt("id_contato"));
                contato.setNomeContato(rs.getString("nm_contato"));
                contato.setEmailContato(rs.getString("nm_email"));
                contato.setDescricaoContato(rs.getString("ds_contato"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contato: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return contato;
    }

    public ContatoTO save(ContatoTO contato) {
        String sql = "INSERT INTO tb_contato (nm_contato, nm_email, ds_contato) VALUES (?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, contato.getNomeContato());
            ps.setString(2, contato.getEmailContato());
            ps.setString(3, contato.getDescricaoContato());
            if(ps.executeUpdate() > 0) {
                return contato;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar contato: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ContatoTO update(ContatoTO contato) {
        String sql = "UPDATE tb_contato SET nm_contato = ?, nm_email = ?, ds_contato = ? WHERE id_contato = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, contato.getNomeContato());
            ps.setString(2, contato.getEmailContato());
            ps.setString(3, contato.getDescricaoContato());
            ps.setInt(4, contato.getIdContato());
            if(ps.executeUpdate() > 0) {
                return contato;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tb_contato WHERE id_contato = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar contato: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }
}

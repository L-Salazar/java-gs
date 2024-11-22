package br.com.fiap.dao;

import br.com.fiap.to.DicaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DicaDAO extends Repository{

    public ArrayList<DicaTO> findAll() {
        ArrayList<DicaTO> dicas = new ArrayList<>();
        String sql = "SELECT * FROM tb_dicas ORDER BY id_dica";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DicaTO dica = new DicaTO();
                    dica.setIdDica(rs.getInt("id_dica"));
                    dica.setTituloDica(rs.getString("nm_titulo_dica"));
                    dica.setDescricaoDica(rs.getString("ds_descricao_dica"));
                    dicas.add(dica);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dicas: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return dicas;
    }

    public DicaTO findById(int id) {
        DicaTO dica = new DicaTO();
        String sql = "SELECT * FROM tb_dicas WHERE id_dica = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dica.setIdDica(rs.getInt("id_dica"));
                dica.setTituloDica(rs.getString("nm_titulo_dica"));
                dica.setDescricaoDica(rs.getString("ds_descricao_dica"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dica: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return dica;
    }

    public DicaTO save(DicaTO dica) {
        String sql = "INSERT INTO tb_dicas (nm_titulo_dica, ds_descricao_dica) VALUES (?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, dica.getTituloDica());
            ps.setString(2, dica.getDescricaoDica());
            if(ps.executeUpdate() > 0){
                return dica;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar dica: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public DicaTO update(DicaTO dica) {
        String sql = "UPDATE tb_dicas SET nm_titulo_dica = ?, ds_descricao_dica = ? WHERE id_dica = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, dica.getTituloDica());
            ps.setString(2, dica.getDescricaoDica());
            ps.setInt(3, dica.getIdDica());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dica: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return dica;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tb_dicas WHERE id_dica = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar dica: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }


}

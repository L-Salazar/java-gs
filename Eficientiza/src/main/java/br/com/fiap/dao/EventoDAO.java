package br.com.fiap.dao;

import br.com.fiap.to.EventoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventoDAO extends Repository{

    public ArrayList<EventoTO> findAll() {
        ArrayList<EventoTO> eventos = new ArrayList<>();
        String sql = "SELECT * FROM tb_eventos ORDER BY id_evento";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    EventoTO evento = new EventoTO();
                    evento.setIdEvento(rs.getInt("id_evento"));
                    evento.setTituloEvento(rs.getString("nm_titulo_evento"));
                    evento.setDetalhesEvento(rs.getString("ds_detalhes_evento"));
                    evento.setDataEvento(rs.getDate("dt_evento").toLocalDate());
                    evento.setUrlImagemEvento(rs.getString("url_imagem_evento"));
                    eventos.add(evento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar eventos: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return eventos;
    }

    public EventoTO findById(int id) {
        EventoTO evento = new EventoTO();
        String sql = "SELECT * FROM tb_eventos WHERE id_evento = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setTituloEvento(rs.getString("nm_titulo_evento"));
                evento.setDetalhesEvento(rs.getString("ds_detalhes_evento"));
                evento.setDataEvento(rs.getDate("dt_evento").toLocalDate());
                evento.setUrlImagemEvento(rs.getString("url_imagem_evento"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar evento: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return evento;
    }

    public EventoTO save(EventoTO evento) {
        String sql = "INSERT INTO tb_eventos (nm_titulo_evento, ds_detalhes_evento, dt_evento, url_imagem_evento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, evento.getTituloEvento());
            ps.setString(2, evento.getDetalhesEvento());
            ps.setDate(3, java.sql.Date.valueOf(evento.getDataEvento()));
            ps.setString(4, evento.getUrlImagemEvento());
            if(ps.executeUpdate() > 0) {
                return evento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar evento: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public EventoTO update(EventoTO evento) {
        String sql = "UPDATE tb_eventos SET nm_titulo_evento = ?, ds_detalhes_evento = ?, dt_evento = ?, url_imagem_evento = ? WHERE id_evento = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, evento.getTituloEvento());
            ps.setString(2, evento.getDetalhesEvento());
            ps.setDate(3, java.sql.Date.valueOf(evento.getDataEvento()));
            ps.setString(4, evento.getUrlImagemEvento());
            ps.setInt(5, evento.getIdEvento());
            if(ps.executeUpdate() > 0) {
                return evento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar evento: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tb_eventos WHERE id_evento = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar evento: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }


}

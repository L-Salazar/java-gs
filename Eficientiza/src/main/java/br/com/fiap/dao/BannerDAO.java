package br.com.fiap.dao;

import br.com.fiap.to.BannerTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BannerDAO extends Repository {

    public ArrayList<BannerTO> findAll() {
        ArrayList<BannerTO> banners = new ArrayList<>();
        String sql = "SELECT * FROM tb_banner ORDER BY id_banner";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BannerTO banner = new BannerTO();
                    banner.setIdBanner(rs.getInt("id_banner"));
                    banner.setUrlBanner(rs.getString("url_banner"));
                    banner.setIdEvento(rs.getInt("id_evento"));
                    banners.add(banner);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar banners: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return banners;
    }

    public BannerTO findById(int id) {
        BannerTO banner = new BannerTO();
        String sql = "SELECT * FROM tb_banner WHERE id_banner = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                banner.setIdBanner(rs.getInt("id_banner"));
                banner.setUrlBanner(rs.getString("url_banner"));
                banner.setIdEvento(rs.getInt("id_evento"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar banner: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return banner;
    }

    public BannerTO save(BannerTO banner) {
        String sql = "INSERT INTO tb_banner (id_banner, url_banner, id_evento) VALUES (?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, banner.getIdBanner());
            ps.setString(2, banner.getUrlBanner());
            ps.setInt(3, banner.getIdEvento());
            if(ps.executeUpdate() > 0) {
                return banner;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir banner: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public BannerTO update(BannerTO banner) {
        String sql = "UPDATE tb_banner SET url_banner = ?, id_evento = ? WHERE id_banner = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, banner.getUrlBanner());
            ps.setInt(2, banner.getIdEvento());
            ps.setInt(3, banner.getIdBanner());
            if(ps.executeUpdate() > 0){
                return banner;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar banner: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tb_banner WHERE id_banner = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar banner: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }


}

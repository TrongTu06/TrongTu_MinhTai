/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KhachHangDao {

    // Lấy toàn bộ danh sách độc giả
    public static List<KhachHangDao> getAll() {
        List<KhachHangDao> list = new ArrayList<>();
        String sql = "SELECT * FROM DocGia";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                KhachHangDao dg = new KhachHangDao(
                    rs.getInt("maDocGia"),
                    rs.getString("HoTen"),
                    rs.getDate("NgaySinh"),
                    rs.getString("DiaChi"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email")
                );
                list.add(dg);
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách độc giả:");
            e.printStackTrace();
        }

        return list;
    }

    private KhachHangDao(int aInt, String string, Date date, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Thêm độc giả mới
    public boolean insertKhachHangDao(KhachHangDao dg) {
        String sql = "INSERT INTO DocGia(HoTen, NgaySinh, DiaChi, SoDienThoai, Email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dg.getHoTen());
            ps.setString(3, dg.getDiaChi());
            ps.setString(4, dg.getSoDienThoai());
            ps.setString(5, dg.getEmail());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        dg.setMaDocGia(generatedKeys.getInt(1)); // Gán mã được sinh tự động
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm độc giả:");
            e.printStackTrace();
        }

        return false;
    }

    // Cập nhật thông tin độc giả
    public boolean updateKhachHangDao(KhachHangDao dg) {
        String sql = "UPDATE DocGia SET HoTen = ?, NgaySinh = ?, DiaChi = ?, SoDienThoai = ?, Email = ? WHERE maDocGia = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dg.getHoTen());
            ps.setString(3, dg.getDiaChi());
            ps.setString(4, dg.getSoDienThoai());
            ps.setString(5, dg.getEmail());
            ps.setString(5, (String) dg.getNgaySinh());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật độc giả:");
            e.printStackTrace();
            return false;
        }
    }

    // Xóa độc giả theo mã
    public boolean deleteKhachHangDao(int maDocGia) {
        String sql = "DELETE FROM DocGia WHERE maDocGia = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDocGia);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa độc giả:");
            e.printStackTrace();
            return false;
        }
    }

    // Tìm độc giả theo tên
    public List<KhachHangDao> searchKhachHangDao(String keyword) {
        List<KhachHangDao> list = new ArrayList<>();
        String sql = "SELECT * FROM DocGia WHERE HoTen LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    KhachHangDao dg = new KhachHangDao(
                        rs.getInt("maDocGia"),
                        rs.getString("HoTen"),
                        rs.getDate("NgaySinh"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDienThoai"),
                        rs.getString("Email")
                    );
                    list.add(dg);
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm độc giả:");
            e.printStackTrace();
        }

        return list;
    }

    private String getHoTen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getNgaySinh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getDiaChi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getSoDienThoai() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setMaDocGia(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Quản Lý Tiệm Giặt ủi");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menu Danh muc
        JMenu menuDM = new JMenu("Quản lý danh mục");
        JMenuItem qlKhachHang = new JMenuItem("Khách hàng");
        JMenuItem qlDichVu = new JMenuItem("Dịch vụ");
        
        JMenu menuDH = new JMenu("Quản lý đơn hàng");
        JMenuItem qlDonGiatUi = new JMenuItem("Đơn Giặt Ủi");
        JMenuItem qlThanhToanDonHang = new JMenuItem("Thanh Toán Đơn Hàng");
        JMenuItem qlThanhToanHoaDon = new JMenuItem("Thanh Toán Hoá Đơn");
        
        JMenu menuTK = new JMenu("Thống kê");
        JMenuItem qlThongKeVaBaoCao = new JMenuItem("Thống Kê và Báo Cáo");
        JMenuItem qlTraCuuDonHang = new JMenuItem("Tra Cứu Đơn Hàng");
        
        // Gắn item vào menu
         menuDM.add(qlKhachHang);
         menuDM.add(qlDichVu);
         menuDH.add(qlDonGiatUi);
         menuDH.add(qlThanhToanDonHang);
         menuDH.add(qlThanhToanHoaDon);
         menuTK.add(qlThongKeVaBaoCao);
         menuTK.add(qlTraCuuDonHang);
         // Gắn menu vào menu bar
        menuBar.add(menuDM);
        menuBar.add(menuDH);
        menuBar.add(menuTK);
                
      
        setJMenuBar(menuBar);

       // Panel chính dùng CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Thêm các panel chức năng
          mainPanel.add(new QuanLyKhachHangPanel(), "QL_KHACHHANG");        
          mainPanel.add(new QuanLyDichVuPanel(), "QL_DICHVU");
          mainPanel.add(new QuanLyDonGiatUiPanel(), "QL_DonGiatUi");
          mainPanel.add(new ThanhToanDonHangPanel(), "QL_DơnHang");
          mainPanel.add(new ThanhToanHoaDonPanel(), "QL_HoaDon");
          mainPanel.add(new ThongKeVaBaoCaoPanel(), "QL_ThongKeVaBaoCao");
          mainPanel.add(new TraCuuDonHangPanel(), "QL_TraCuuDonHang");
          
        add(mainPanel);

      // Xử lý sự kiện menu
        qlKhachHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_KHACHHANG"));
        qlDichVu.addActionListener(e -> cardLayout.show(mainPanel, "QL_DICHVU"));
        qlDonGiatUi.addActionListener(e -> cardLayout.show(mainPanel, "QL_DonGiatUi"));
        qlThanhToanDonHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_DơnHang"));
        qlThanhToanHoaDon.addActionListener(e -> cardLayout.show(mainPanel, "QL_HoaDon"));
        qlThongKeVaBaoCao.addActionListener(e -> cardLayout.show(mainPanel, "QL_ThongKeVaBaoCao"));
        qlTraCuuDonHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_TraCuuDonHang"));
    }

    public static void main(String[] args) {
        MainFrame frm = new MainFrame();
        frm.setVisible(true);
    }
}

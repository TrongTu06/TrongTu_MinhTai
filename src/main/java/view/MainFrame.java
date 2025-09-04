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

       JMenu menuTK = new JMenu("Thống kê");
     //  JMenuItem ql = new JMenuItem("Khách hàng");
      //  JMenuItem qlDichVu = new JMenuItem("Dịch vụ");
        
        // Gắn item vào menu
         menuDM.add(qlKhachHang);
         menuDM.add(qlDichVu);
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
      

        add(mainPanel);

      // Xử lý sự kiện menu
        qlKhachHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_KHACHHANG"));
        qlDichVu.addActionListener(e -> cardLayout.show(mainPanel, "QL_DICHVU"));
       
    }

    public static void main(String[] args) {
        MainFrame frm = new MainFrame();
        frm.setVisible(true);
    }
}

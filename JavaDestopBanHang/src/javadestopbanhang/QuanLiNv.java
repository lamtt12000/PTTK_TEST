/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadestopbanhang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javadestopbanhang.Users.Users;
import javadestopbanhang.connectDB.MyDB;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author HP
 */
public class QuanLiNv extends javax.swing.JFrame {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    /**
     * Creates new form QuanLiNv
     */
    
    public QuanLiNv() {
        initComponents();
        
        MyDB m = new MyDB();
        try {
            con=m.getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNv.class.getName()).log(Level.SEVERE, null, ex);
        }
        showData();
        tfName.setEnabled(true);
    }
     public void showData(){
        
        Vector col =new Vector();
        //Tạo tên cột 
        col.addElement("Id");
        col.addElement("Full Name");
        col.addElement("Username");
        col.addElement("Password");
        col.addElement("Role");
        
        
        //Tạo vecto dữ liệu
        Vector data = new Vector();
        
        try{
        String sql = "SELECT *FROM user";
        ps =con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            Vector st = new Vector();
            
            st.addElement(rs.getString("id"));
            st.addElement(rs.getString("name"));
            st.addElement(rs.getString("username"));
            st.addElement(rs.getString("password"));
            st.addElement(rs.getString("role"));
            
            data.add(st);
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        tbUser.setModel(new DefaultTableModel(data, col));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        cbxRole = new javax.swing.JComboBox<>();
        tfName = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        pwPass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnAddNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        cbxSearch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnXuatDS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản kí thông tin nhân viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Role");

        tfId.setEnabled(false);

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Nhân viên bán hàng", "Thủ kho" }));

        tfName.setEnabled(false);
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadestopbanhang/image/Add_new.png"))); // NOI18N
        btnAddNew.setText("AddNew");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadestopbanhang/image/Apps-system-software-update-icon.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadestopbanhang/image/Document-Delete-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKhachHang)
                    .addComponent(btnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDelete)
                        .addComponent(btnUpdate)
                        .addComponent(btnAddNew)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNew, btnDelete, btnKhachHang, btnNhanVien, btnUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNew)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNhanVien)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNew, btnDelete, btnKhachHang, btnNhanVien, btnUpdate});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwPass, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(tfName)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pwPass, tfId, tfName, tfUsername});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pwPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxRole, pwPass, tfId, tfName, tfUsername});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadestopbanhang/image/search-icon (1).png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Name", "Role" }));
        cbxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSearch, cbxSearch, tfSearch});

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUser);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" Employee management");

        jMenu1.setText("File");

        mnXuatDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadestopbanhang/image/Save-icon.png"))); // NOI18N
        mnXuatDS.setText("Xuất Danh Sách");
        mnXuatDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnXuatDSActionPerformed(evt);
            }
        });
        jMenu1.add(mnXuatDS);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
         String ktsql = "SELECT * FROM user WHERE username = ?";
         
        try {
            ps = con.prepareStatement(ktsql);
            ps.setString(1, tfUsername.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Đã bị trùng User");
            }
            else{
                String sql = "INSERT INTO user (name,username,password,role)"
                        +"VALUES(?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,tfName.getText());
                ps.setString(2,tfUsername.getText());
                ps.setString(3,pwPass.getText());
                ps.setString(4,cbxRole.getSelectedItem().toString());
                
                ps.executeUpdate();
            }
                 
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiNv.class.getName()).log(Level.SEVERE, null, ex);
        }
        showData();
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
       int row = tbUser.getSelectedRow();
        if(row!=-1){
            String id = tbUser.getValueAt(row, 0).toString();
            tfId.setText(id);
            tfName.setText(tbUser.getValueAt(row,1).toString());
            tfUsername.setText(tbUser.getValueAt(row, 2).toString());
            pwPass.setText(tbUser.getValueAt(row, 3).toString());
            cbxRole.setSelectedItem(tbUser.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_tbUserMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String sql = "UPDATE user SET name = ?,username = ?,password = ?,role = ?"
                    + " WHERE id = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1,tfName.getText());
            ps.setString(2,tfUsername.getText());
            ps.setString(3,pwPass.getText());
            ps.setString(4,cbxRole.getSelectedItem().toString());
            ps.setString(5,tfId.getText());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        showData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM user WHERE id=?";
        int choice = JOptionPane.showConfirmDialog(this, 
                "Bạn chắc chắn muốn xóa nhân viên" + tfName.getText());
        if(choice == JOptionPane.YES_OPTION){
            try{
               // int id = Integer.parseInt(txtID.getText());
                ps=con.prepareStatement(sql);
                ps.setString(1, tfId.getText());
                ps.executeUpdate();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Chọn nhân viên trước khi xóa !");
            }
        }
         showData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
         String textSearch = tfSearch.getText().toLowerCase().trim();
         String cbxrole = cbxSearch.getSelectedItem().toString();
           Vector col =new Vector();
        //Tạo tên cột 
        col.addElement("Id");
        col.addElement("Full Name");
        col.addElement("Username");
        col.addElement("Password");
        col.addElement("Role");
        //Tạo vecto dữ liệu
        Vector data = new Vector();
        
        switch(cbxrole)
        {
            case "All" :
                
                try {
                    String sql = "SELECT * FROM user";
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery();
                while(rs.next()){
                   Vector u = new Vector();
                   u.addElement(rs.getString("id"));
                   u.addElement(rs.getString("name"));
                   u.addElement(rs.getString("username"));
                   u.addElement(rs.getString("password"));
                   u.addElement(rs.getString("role"));
                    if(u.toString().toLowerCase().contains(textSearch)){
                    data.add(u);
                 } 
                   

                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Name" :
                try {
                    String sqlql = "SELECT * FROM user WHERE name LIKE ? ";
                    ps=con.prepareStatement(sqlql);
                    ps.setString(1,"%"+textSearch+"%");
                    rs=ps.executeQuery();
                while(rs.next()){
                   Vector u = new Vector();
                   u.addElement(rs.getString("id"));
                   u.addElement(rs.getString("name"));
                   u.addElement(rs.getString("username"));
                   u.addElement(rs.getString("password"));
                   u.addElement(rs.getString("role"));
                   
                   data.add(u);

                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Role" :
                try {
                    String sqla = "SELECT * FROM user WHERE role LIKE ? ";
                   
                    ps=con.prepareStatement(sqla);
                    ps.setString(1,"%"+textSearch+"%");
                    rs=ps.executeQuery();
                while(rs.next()){
                   Vector u = new Vector();
                   u.addElement(rs.getString("id"));
                   u.addElement(rs.getString("name"));
                   u.addElement(rs.getString("username"));
                   u.addElement(rs.getString("password"));
                   u.addElement(rs.getString("role"));
                   
                   data.add(u);

                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
              
        tbUser.setModel(new DefaultTableModel(data, col));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSearchActionPerformed

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void mnXuatDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnXuatDSActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File ("D:\\users"));
        int i = jfc.showSaveDialog(this);
        if(i==JFileChooser.APPROVE_OPTION){
            File f = jfc.getSelectedFile();
            try{
               
                    FileWriter out = new FileWriter(f+".xls");
                    BufferedWriter writer = new BufferedWriter(out);
                    DefaultTableModel model = (DefaultTableModel) tbUser.getModel();
                    for (int j  = 0;j<model.getColumnCount();j++){
                        writer.write(model.getColumnName(j)+"\t");
                    }
                    writer.write("\n");
                    for(int j = 0;j<model.getRowCount();j++){
                        for (int k =0;k<model.getColumnCount();k++){
                            writer.write(model.getValueAt(j, k) + "\t");
                        }
                        writer.write("\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Lưu thành công");
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
    }//GEN-LAST:event_mnXuatDSActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        showData();
        btnNhanVien.setEnabled(false);
        btnKhachHang.setEnabled(true);
         btnAddNew.setEnabled(true);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSearch.setEnabled(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
         Vector col =new Vector();
        //Tạo tên cột 
        col.addElement("Email");
        col.addElement("Name");
        col.addElement("NumberPhone");
        col.addElement("Address");
       
        //Tạo vecto dữ liệu
        Vector data = new Vector();
        
        try{
        String sql = "SELECT *FROM khachhang";
        ps =con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            Vector st = new Vector();
            
            st.addElement(rs.getString("email"));
            st.addElement(rs.getString("name"));
            st.addElement(rs.getString("numberphone"));
            st.addElement(rs.getString("address"));
            
            data.add(st);
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        tbUser.setModel(new DefaultTableModel(data, col));
        btnKhachHang.setEnabled(false);
        btnNhanVien.setEnabled(true);
        btnAddNew.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSearch.setEnabled(false);

    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLiNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLiNv q = new QuanLiNv();
                 q.pack();
                 q.setLocationRelativeTo(null);
                 q.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnXuatDS;
    private javax.swing.JPasswordField pwPass;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}

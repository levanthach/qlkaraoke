/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import connection.KetnoiKaraoke;
import controllers.TruyvanKaraoke;


/**
 *
 * @author thanc
 */
public class doanhthu extends javax.swing.JFrame {
    private JPanel contentPane;
    TruyvanKaraoke adapterMd=new TruyvanKaraoke();
    private JTable tblDt;
    
    private JTextField txtTime;

	private JComboBox comboBox;
	String chonHt=new String();
    /**
     * Creates new form viewDoanhthu
     */
    public doanhthu() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(480, 500);
        setTitle("DOANH THU");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
        contentPane.setBackground(SystemColor.decode("#76EEC6"));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        tblDt = new JTable();

		JLabel lblNewLabel_1 = new JLabel("DOANH THU PHÒNG HÁT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setBounds(10, 11, 260, 31);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin doanh thu:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 52, 450, 400);
        panel_1.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Doanh thu:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 120, 430, 270);
                panel_2.setBackground(SystemColor.decode("#76EEC6"));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		scrollPane.setViewportView(tblDt);
		
		JLabel lblNewLabel = new JLabel("Tìm ngày :");
		lblNewLabel.setBounds(18, 30, 65, 14);
		panel_1.add(lblNewLabel);
		
		txtTime = new JTextField();
		txtTime.setBounds(85, 23, 150, 30);
		panel_1.add(txtTime);
		txtTime.setColumns(10);
		
		JLabel lblNewLabe2 = new JLabel("(yyyy/mm/dd)");
		lblNewLabe2.setBounds(237, 30, 75, 14);
		panel_1.add(lblNewLabe2);
		
		JButton btnTimkiem = new JButton();
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adapterMd = new TruyvanKaraoke();
				tblDt.setModel(adapterMd.loadDt(txtTime.getText()));
			}
		});
		btnTimkiem.setBounds(315, 23, 100, 30);
        btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnTimkiem);
		
		JLabel lblNewLabe3 = new JLabel("Hiển thị theo :");
		lblNewLabe3.setBounds(18, 75, 90, 14);
		panel_1.add(lblNewLabe3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(120, 68, 140, 30);
		panel_1.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox.getSelectedIndex()==0) chonHt="0";
				else if(comboBox.getSelectedIndex()==1) chonHt="1";
				else if(comboBox.getSelectedIndex()==2) chonHt="2";
				else if(comboBox.getSelectedIndex()==3) chonHt="3";
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Chọn--", "Ngày", "Tháng", "Năm"}));
		
		JButton btnHienThi = new JButton();
		btnHienThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHienThi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chonHt=="0") JOptionPane.showMessageDialog(null, "Kiểm tra lại!");
				else
				{
					adapterMd = new TruyvanKaraoke();
					tblDt.setModel(adapterMd.loadDtFor(chonHt));
				}
			}
		});
		btnHienThi.setBounds(315, 68, 100, 30);
        btnHienThi.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnHienThi.setText("Hiển thị");
        btnHienThi.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnHienThi);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          mainchinh vm=new mainchinh();
           vm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
             java.util.logging.Logger.getLogger(doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(doanhthu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doanhthu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

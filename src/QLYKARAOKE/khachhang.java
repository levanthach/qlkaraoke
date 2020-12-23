/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLYKARAOKE;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
/**
 *
 * @author nguyenchienjf
 */
public class khachhang extends javax.swing.JFrame {
    
        TruyvanKaraoke adapterMd=new TruyvanKaraoke();
        KetnoiKaraoke adapterCtr=new KetnoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;	
	private JTextField txtLienlac;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel txtlienlac;
	private JTable tblKh;
	private JComboBox cmbGioitinh;
	private String chonGioitinh="1";
	private String chonPhong="";
	private String idKh="";
	private JLabel lblNewLabel_5;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable tblTimKh;
	private JScrollPane scrollPane_2;
	private JComboBox cmbPhong;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
    /**
     * Creates new form viewKhachHang
     */
    public khachhang() {
        initComponents();
        setTitle("Khách Hàng");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd=new TruyvanKaraoke();
			    tblKh.setModel(adapterMd.loadAllKh());
			    adapterMd=new TruyvanKaraoke();
			    adapterMd=new TruyvanKaraoke();
			    adapterMd=new TruyvanKaraoke();
                            cmbPhong.setModel(adapterMd.loadPhongList());
			  
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 536);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.setForeground(new Color(83 ,134 ,139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 240, 580, 252);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblKh = new JTable();
		tblKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idKh=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();
				txtTen.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),1).toString());
				txtCmnd.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),2).toString());
				if(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),3).toString().equals("1")) chonGioitinh="1";
				else chonGioitinh="0";
				txtLienlac.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),4).toString());
			}
		});
		scrollPane.setViewportView(tblKh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin khách hàng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 54, 580, 180);
                panel_1.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
	

		JButton btnSua = new JButton();
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			adapterMd.updateAllKh(idKh,txtTen.getText(),txtCmnd.getText(),chonGioitinh,txtLienlac.getText());
			adapterMd=new TruyvanKaraoke();
			tblKh.setModel(adapterMd.loadAllKh());
			}
		});
		btnSua.setBounds(75, 100, 120, 42);
                btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); 
                btnSua.setText("Sửa");
                btnSua.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
		        {
			if(idKh.equals("")) JOptionPane.showMessageDialog(null, "Chưa chọn KH!");
			else 
			{
			adapterMd.XoaId("tb_khachhang","ma_kh",idKh);
			adapterMd=new TruyvanKaraoke();	
			tblKh.setModel(adapterMd.loadAllKh());			
			}
			}
		}
		});
		btnXoa.setBounds(200, 100, 120, 42);
                btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); 
                btnXoa.setText("Xóa");
                btnXoa.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnXoa);
		
		lblNewLabel = new JLabel("Tên KH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 27, 85, 20);
		panel_1.add(lblNewLabel);
		
                txtTen = new JTextField();
		txtTen.setBounds(75, 19, 150, 30);
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
                
		lblNewLabel_1 = new JLabel("CMND KH:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 65, 85, 14);
		panel_1.add(lblNewLabel_1);
                
                txtCmnd = new JTextField();
		txtCmnd.setBounds(75, 58, 150, 30);
		panel_1.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		txtlienlac = new JLabel("Liên Lạc KH:");
		txtlienlac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtlienlac.setBounds(265, 27, 85, 14);
                
		panel_1.add(txtlienlac);
                txtLienlac = new JTextField();
		txtLienlac.setBounds(350, 19, 150, 30);
		panel_1.add(txtLienlac);
		txtLienlac.setColumns(10);
                
                lblNewLabel_3 = new JLabel("Giới Tính KH:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(265, 65, 85, 14);
		panel_1.add(lblNewLabel_3);
   
		cmbGioitinh = new JComboBox();
		cmbGioitinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		if(cmbGioitinh.getSelectedIndex()==0) chonGioitinh="1";
		else if(cmbGioitinh.getSelectedIndex()==1) chonGioitinh="0";
			}
		});
		cmbGioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cmbGioitinh.setBounds(350,58 , 150, 30);
		panel_1.add(cmbGioitinh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tìm khách theo phòng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_3.setBounds(330, 100, 170, 65);
                panel_3.setBackground(SystemColor.decode("#76EEC6"));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		cmbPhong = new JComboBox();
		cmbPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		adapterMd=new TruyvanKaraoke();
		if(cmbPhong.getSelectedIndex()==0) tblKh.setModel(adapterMd.loadAllKh());
		else tblKh.setModel(adapterMd.loadTimPhong(cmbPhong.getSelectedItem().toString()));
			}
		});
		cmbPhong.setBounds(10, 290, 148, 20);
		panel_3.add(cmbPhong);
		
		lblNewLabel_10 = new JLabel("DANH SÁCH KHÁCH HÀNG");
                lblNewLabel_10.setForeground(new Color(210, 105, 30));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_10);
		
		JButton btnRf = new JButton("refresh");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adapterMd=new TruyvanKaraoke();
			    tblKh.setModel(adapterMd.loadAllKh());
			    adapterMd=new TruyvanKaraoke();
			    adapterMd=new TruyvanKaraoke();
			    adapterMd=new TruyvanKaraoke();
			   cmbPhong.setModel(adapterMd.loadPhongList());
			   
			   			}
		});
		
                btnRf.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnRf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png"))); 
                btnRf.setText("CẬP NHẬT");
                btnRf.setBackground(new Color(255 ,246 ,143));
                btnRf.setBounds(360, 10, 150, 43);
		contentPane.add(btnRf);
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
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khachhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import connection.KetnoiKaraoke;
/**
 *
 * @author nguyenchienjf
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form viewLogin
     */
        private JPanel contentPane;
	private JTextField txttk;
	KetnoiKaraoke adapterCtr=new KetnoiKaraoke();
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblpass;
	private JLabel Lanel;
	private JLabel lblNewLabel_1;
	private JPasswordField pfMk;
    
    
    public login() {
        initComponents();
        setTitle("Đăng Nhập");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 350, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
                Lanel = new JLabel();
		Lanel.setBackground(new Color(255, 153, 153));
		Lanel.setBounds(0,0, 350, 350);
		contentPane.add(Lanel);
                Lanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nen.jpg")));
		Lanel.setLayout(null);
                
		txttk = new JTextField("admin");
		txttk.setBounds(94, 50, 190, 30);
		Lanel.add(txttk);
		txttk.setColumns(10);
		
		lblNewLabel = new JLabel();
                lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png")));
		lblNewLabel.setBounds(47, 38, 70, 43);
		Lanel.add(lblNewLabel);
		                                                                                                                                                                                              
		lblpass = new JLabel();
                lblpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pass.png")));
		lblpass.setBounds(47, 85, 70, 43);
		Lanel.add(lblpass);
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(57, 140, 125, 43);
                btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); 
                btnNewButton.setText("Đăng nhập");
                btnNewButton.setForeground(new Color(0, 0, 153));
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                btnNewButton.setBackground(new Color(127, 255, 212));
		Lanel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel_1.setForeground(new Color(84 ,255, 159)); 
		lblNewLabel_1.setBounds(120, 14, 157, 23);
		Lanel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton();
                btnNewButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png")));
                btnNewButton_2.setText("Đóng");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(190, 140, 100, 43);
                 btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
                btnNewButton_2.setBackground(new Color(127, 255, 212));
		Lanel.add(btnNewButton_2);
		
		pfMk = new JPasswordField();
		pfMk.setText("123");
		pfMk.setBounds(94, 90, 190, 30);
		Lanel.add(pfMk);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if(txttk.getText().equals("")||String.valueOf(pfMk.getPassword()).equals("")) 
                        {
                            if(txttk.getText().equals(""))
                                JOptionPane.showMessageDialog(null,"vui lòng nhập tài khoản");
                            else 
                                JOptionPane.showMessageDialog(null,"vui lòng nhập mật khẩu");
                                
                        }
		else if(adapterCtr.demDong("tb_login",adapterCtr.demTaikhoan(txttk.getText(),String.valueOf(pfMk.getPassword()))).equals("0"))
		JOptionPane.showMessageDialog(null,"Nhập sai tài khoản hoặc mật khẩu");
		else if(!adapterCtr.demDong("tb_login",adapterCtr.demTaikhoan(txttk.getText(),String.valueOf(pfMk.getPassword()))).equals("0"))
		{
		String tk=txttk.getText();
		String mk=String.valueOf(pfMk.getPassword());
		String matk=adapterCtr.ma_tk(tk,mk);
		adapterCtr.luuid("*",matk);
		mainchinh main=new mainchinh();
		main.setVisible(true);
    	main.setLocationRelativeTo(null);
    	JOptionPane.showMessageDialog(null,"Chào "+adapterCtr.cellTb("ten_tk",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")))+"!",null,JOptionPane.INFORMATION_MESSAGE);
    	dispose();
		}
			}
		});
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                                try {
					login frame = new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

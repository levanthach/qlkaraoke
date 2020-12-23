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
/**
 *
 * @author thanc
 */
public class nguoidung extends javax.swing.JFrame {
        private JPanel contentPane;
        private JTextField txtten;
	private JTextField txttaikhoan;
	private JTextField txtmatkhau;
	private JTable table;
	private String chonuser="";
        TruyvanKaraoke adapterMd=new TruyvanKaraoke();

    /**
     * Creates new form viewUser
     */
    public nguoidung() {
        initComponents();
        setTitle("Quản Lý Tài Khoản ");
		setResizable(false);
                setLocationRelativeTo(null);
                setSize( 680, 352);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			table.setModel(adapterMd.loadUser());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setBackground(SystemColor.decode("#76EEC6"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sách người dùng :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 378, 291);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonuser=table.getModel().getValueAt(table.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(table);
		
		txtten = new JTextField();
		txtten.setBounds(489, 83, 175, 30);
		contentPane.add(txtten);
		txtten.setColumns(10);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(489, 136, 175, 30);
		contentPane.add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		txtmatkhau = new JTextField();
		txtmatkhau.setBounds(489, 181, 175, 30);
		contentPane.add(txtmatkhau);
		txtmatkhau.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setBounds(398, 141, 88, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1.setBounds(398, 189, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ Tên:");
		lblNewLabel_2.setBounds(398, 88, 68, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thêm / Xóa tài khoản");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(450, 35, 170, 27);
		contentPane.add(lblNewLabel_3);
		
		JButton btnthem = new JButton("Thêm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if(txttaikhoan.getText().toString().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Kiểm tra tên tài khoản");
	    		}
                            else
                             if(txtten.getText().toString().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Kiểm tra tên ");
	    		}
                             else
                             if(txtmatkhau.getText().toString().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Kiểm tra mật khẩu ");
	    		}
                            
                            
	    		else
                            adapterMd.ThemUser(txttaikhoan.getText(),
                                    txtmatkhau.getText(),
                                    txtten.getText());
                            table.setModel(adapterMd.loadUser());
			}
		});
                btnthem.setBounds(450, 227, 100, 42);
                btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); 
                btnthem.setText("Thêm");
                btnthem.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnthem);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if(chonuser.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"Chưa chọn người dùng");
	    		}
                            
                        else
                            
                        if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa "+table.getModel().getValueAt(table.getSelectedRow(),1).toString()+"","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                        {
                                adapterMd.XoaId("tb_login","ma_tk",chonuser);
                                table.setModel(adapterMd.loadUser());
                        }
                                        }
		});
                btnxoa.setBounds(550, 227, 100, 42);
                btnxoa.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); 
                btnxoa.setText("Xóa");
                btnxoa.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnxoa);
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
            .addGap(0, 679, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(nguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nguoidung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nguoidung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

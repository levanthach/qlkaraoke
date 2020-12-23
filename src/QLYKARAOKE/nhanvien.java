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
 * @author nguyenchienjf
 */
public class nhanvien extends javax.swing.JFrame {
    
        TruyvanKaraoke adapterMd=new TruyvanKaraoke();
        KetnoiKaraoke adapterCtr=new KetnoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTenNv;
	private JTextField txtChucvu;
	private JTextField txtLuong;
	private JTextField txtNamsinh;
	private JTable tblNv;
	private JTextField txtChuthich;
	private JComboBox comboBox;
	String IdNv="";
	String chonGioitinh=new String();

    /**
     * Creates new form viewNhanVien
     */
    public nhanvien() {
        initComponents();
        setTitle("Nhân Viên");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd=new TruyvanKaraoke();
				tblNv.setModel(adapterMd.loadAllNv());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 530);
		contentPane = new JPanel();
                contentPane.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách Nv:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 250, 810, 250);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblNv = new JTable();
		tblNv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			IdNv=tblNv.getModel().getValueAt(tblNv.getSelectedRow(),0).toString();
			txtTenNv.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),1).toString());
			txtChucvu.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),2).toString());
			txtLuong.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),3).toString());
			txtNamsinh.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),4).toString());
			txtChuthich.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),6).toString());
			}
		});
		scrollPane.setViewportView(tblNv);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin nhân viên:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(10, 68, 810, 170);
                panel_2.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên NV :");
		lblNewLabel.setBounds(18, 36, 65, 14);
		panel_2.add(lblNewLabel);
		
		txtTenNv = new JTextField();
		txtTenNv.setBounds(85, 28, 150, 30);
		panel_2.add(txtTenNv);
		txtTenNv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chức vụ :");
		lblNewLabel_1.setBounds(18, 67, 65, 14);
		panel_2.add(lblNewLabel_1);
		
		txtChucvu = new JTextField();
		txtChucvu.setBounds(85, 59, 150, 30);
		panel_2.add(txtChucvu);
		txtChucvu.setColumns(10);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(340, 28, 150, 30);
		panel_2.add(txtLuong);
		txtLuong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Lương :");
		lblNewLabel_2.setBounds(280, 36, 65, 14);
		panel_2.add(lblNewLabel_2);
		
		txtNamsinh = new JTextField();
		txtNamsinh.setBounds(340, 59, 150, 30);
		panel_2.add(txtNamsinh);
		txtNamsinh.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Năm sinh :");
		lblNewLabel_3.setBounds(280, 67, 65, 14);
		panel_2.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(590, 28, 150, 30);
		panel_2.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox.getSelectedIndex()==0) chonGioitinh="chưa rõ";
				else if(comboBox.getSelectedIndex()==1) chonGioitinh="1";
				else if(comboBox.getSelectedIndex()==2) chonGioitinh="0";
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Chọn--", "Nam", "Nữ"}));
		
		JLabel lblNewLabel_4 = new JLabel("Giới tính :");
		lblNewLabel_4.setBounds(530, 36, 65, 14);
		panel_2.add(lblNewLabel_4);
		
		txtChuthich = new JTextField();
		txtChuthich.setBounds(590, 59, 150, 30);
		panel_2.add(txtChuthich);
		txtChuthich.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Chú thích :");
		lblNewLabel_5.setBounds(530, 67, 65, 14);
		panel_2.add(lblNewLabel_5);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(400, 100,  120, 42);
                btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); 
                btnXoa.setText("Xóa");
                btnXoa.setBackground(new Color(255 ,246 ,143));
		panel_2.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
				if(!quyen.equals("1")) {JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
				return;
				}
				if(IdNv.equals(""))
				{
	      JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
				}
				else 
				{
		   adapterMd.XoaId("tb_nhanvien","ma_nv",IdNv);
		   tblNv.setModel(adapterMd.loadAllNv());
		   
				}
			}
		});
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(250, 100,  120, 42);
                btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); 
                btnThem.setText("Thêm");
                btnThem.setBackground(new Color(255 ,246 ,143));
		panel_2.add(btnThem);
                
                btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quyen=adapterCtr.cellTb("tinhtrang",adapterCtr.itemLogin(adapterCtr.Id("id_1","id")));
				if(!quyen.equals("1")) {JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
				return;
				}
		if(txtTenNv.getText().equals("")) JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
		else if(chonGioitinh.equals("1")||chonGioitinh.equals("0")) 
		{
			  adapterMd.ThemNhanVien(txtTenNv.getText(),txtChucvu.getText(),txtLuong.getText(),txtNamsinh.getText(),chonGioitinh,txtChuthich.getText());
			  adapterMd=new TruyvanKaraoke();
			  tblNv.setModel(adapterMd.loadAllNv());
			  
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn giới tính");
		}
			}
		});
		
		JLabel lblNewLabel_8 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(30, 22, 294, 35);
                lblNewLabel_8.setForeground(new Color(210, 105, 30));
		contentPane.add(lblNewLabel_8);
		
		JButton btnRf = new JButton();
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adapterMd=new TruyvanKaraoke();
				tblNv.setModel(adapterMd.loadAllNv());
				
			}
		});
		btnRf.setBounds(650, 10, 150, 53);
                btnRf.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnRf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png"))); 
                btnRf.setText("CẬP NHẬT");
                btnRf.setBackground(new Color(255 ,246 ,143));
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
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

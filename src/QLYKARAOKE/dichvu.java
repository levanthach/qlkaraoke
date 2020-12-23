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
import javax.swing.table.*;
/**
 *
 * @author nguyenchienjf
 */
public class dichvu extends javax.swing.JFrame {
    
        TruyvanKaraoke adapterMd=new TruyvanKaraoke();
        KetnoiKaraoke adapterCtr=new KetnoiKaraoke();
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTable tblDv;
	private JTable tblDvDat;
	private JTable tblTt;
	private JTextField txtTenDv;
	private JTextField txtGiaDv;
	private JComboBox cmbNhanvien;
	private JLabel lblNv;
	private JLabel lblSldv;
	private JLabel lblTongtien;
	private String chonDichvu;
	private String chonDvvD;
	private JTextField txtDcKh;
    /**
     * Creates new form viewDichVu
     */
    public dichvu() {
        initComponents();
        setTitle("Dịch Vụ");
        setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		    adapterMd=new TruyvanKaraoke();
		    tblDv.setModel(adapterMd.loadDichVu());  
		    adapterMd=new TruyvanKaraoke();
		    tblDvDat.setModel(adapterMd.loadHdDv());
		    cmbNhanvien.setModel(adapterMd.loadNhanvienCmb());     
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 730);

		contentPane = new JPanel();
                contentPane.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nhập dịch vụ:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 439, 280, 147);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Dv :");
		lblNewLabel.setBounds(25, 24, 80, 28);
		panel.add(lblNewLabel);
		
		txtTenDv = new JTextField();
		txtTenDv.setBounds(75, 24, 150, 30);
		panel.add(txtTenDv);
		txtTenDv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giá Dv :");
		lblNewLabel_1.setBounds(25, 90, 80, 30);
		panel.add(lblNewLabel_1);
		
		txtGiaDv = new JTextField();
		txtGiaDv.setBounds(75, 91, 150, 30);
		panel.add(txtGiaDv);
		txtGiaDv.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách dịch vụ vừa đặt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setBounds(328, 55, 541, 169);
                panel_2.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		tblDvDat = new JTable();
		tblDvDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonDvvD=tblDvDat.getModel().getValueAt(tblDvDat.getSelectedRow(),0).toString();
			}
		});
		scrollPane_2.setViewportView(tblDvDat);
		
		JButton btnThemDv = new JButton("Thêm Dv");
		btnThemDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                            
                            if(txtTenDv.getText().equals("")|| txtGiaDv.getText().equals("")) 
                        {
                            if(txtTenDv.getText().equals(""))
                                JOptionPane.showMessageDialog(null,"vui lòng nhập tên dịch vụ");
                            else 
                                JOptionPane.showMessageDialog(null,"vui lòng nhập giá dịch vụ" );
                                
                        }
                            else if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm!","Kiểm tra lại",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					adapterMd.ThemDichVu(txtTenDv.getText().toString(),txtGiaDv.getText().toString());
					adapterMd=new TruyvanKaraoke();
					tblDv.setModel(adapterMd.loadDichVu());
				}
			}}
		);
		btnThemDv.setBounds(20, 600,120, 42);
                btnThemDv.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnThemDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); 
                btnThemDv.setText("Thêm");
                btnThemDv.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnThemDv);
		
		JButton btnXoaDv = new JButton("Xóa Dv");
		btnXoaDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
		        JOptionPane.showConfirmDialog (null, "Kiểm tra lại các mặt hàng chưa thanh toán trc khi xóa!","Cẩn thận!",dialogButton);
		        if(dialogButton == JOptionPane.YES_OPTION){
			adapterMd.XoaId("tb_dichvu","ma_dv",chonDichvu);
			adapterMd=new TruyvanKaraoke();
			tblDv.setModel(adapterMd.loadDichVu());
			}
			}
		});
		btnXoaDv.setBounds(149, 600,   120, 42);
                btnXoaDv.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnXoaDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); 
                btnXoaDv.setText("Xóa");
                btnXoaDv.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnXoaDv);
		
		JList list_1 = new JList();
		list_1.setBounds(369, 221, 1, 1);
		contentPane.add(list_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách dịch vụ:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(10, 55, 280, 368);
                panel_1.setBackground(SystemColor.decode("#76EEC6"));
                
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		tblDv = new JTable();
		tblDv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tblDv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chonDichvu=tblDv.getModel().getValueAt(tblDv.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(tblDv);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY));
		panel_3.setBounds(328, 278, 541, 311);
                panel_3.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("HÓA ĐƠN DỊCH VỤ");
		label.setBounds(199, 11, 141, 23);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(46, 60, 452, 185);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		
		tblTt = new JTable();
		scrollPane_3.setViewportView(tblTt);
		
		JLabel newLabel = new JLabel("Tổng tiền:");
		newLabel.setBounds(303, 277, 74, 23);
		panel_3.add(newLabel);
		
		lblTongtien = new JLabel("0 VNĐ");
		lblTongtien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongtien.setBounds(387, 275, 144, 23);
		panel_3.add(lblTongtien);
		
		JLabel lblkaraoke = new JLabel("KARAOKE NGUYỄN CHIẾN JF");
                lblkaraoke.setFont(new Font("Times New Roman", Font.BOLD, 16));
                lblkaraoke.setForeground(new Color(0, 0, 238));
		lblkaraoke.setBounds(160, 25, 300, 34);
		panel_3.add(lblkaraoke);
		
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng dv:");
		lblNewLabel_3.setBounds(303, 252, 74, 14);
		panel_3.add(lblNewLabel_3);
		
		lblSldv = new JLabel("0");
		lblSldv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSldv.setBounds(387, 250, 111, 14);
		panel_3.add(lblSldv);
		
		JLabel lblNewLabel_6 = new JLabel("Người lập phiếu:");
		lblNewLabel_6.setBounds(10, 252, 109, 14);
		panel_3.add(lblNewLabel_6);
		
		cmbNhanvien = new JComboBox();
		cmbNhanvien.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cmbNhanvien.getSelectedIndex()==0) lblNv.setText("");
				else lblNv.setText(cmbNhanvien.getSelectedItem().toString());		
			}
		});
		cmbNhanvien.setBounds(120, 244, 117, 30);
		panel_3.add(cmbNhanvien);
		
		lblNv = new JLabel("");
		lblNv.setBounds(39, 281, 153, 14);
		panel_3.add(lblNv);
		
		JButton btnXemHd = new JButton();
		btnXemHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  adapterMd=new TruyvanKaraoke();
			  tblTt.setModel(adapterMd.loadTtDv());
			
			  lblSldv.setText(adapterCtr.demDong("tb_hoadondv",adapterCtr.demHddv));
                          lblTongtien.setText(adapterCtr.demTien(adapterCtr.demtien1)+" VNĐ");
			}
		});
		btnXemHd.setBounds(650, 230, 160, 42);
                btnXemHd.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnXemHd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); 
                btnXemHd.setText("Xem Hóa Đơn");
                btnXemHd.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnXemHd);
		
		JButton btnDatDv = new JButton();
		btnDatDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		adapterMd.ThemHoaDonDv(chonDichvu,adapterCtr.gioHt,adapterCtr.ngayHt);
		adapterMd=new TruyvanKaraoke();
		tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnDatDv.setBounds(370, 230, 140, 42);
                btnDatDv.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnDatDv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/redo2.png"))); 
                btnDatDv.setText("Đặt Dịch vụ");
                btnDatDv.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnDatDv);
		
                JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		adapterMd.XoaId("tb_hoadondv","ma_hddv",chonDvvD);
		adapterMd=new TruyvanKaraoke();
		tblDvDat.setModel(adapterMd.loadHdDv());
			}
		});
		btnNewButton.setBounds(510, 230, 140, 42);
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undo2.png"))); 
                btnNewButton.setText("Hủy Dịch vụ");
                btnNewButton.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnNewButton);
                
		JButton btnXuat = new JButton("");
		btnXuat.addActionListener(new ActionListener() 
                {
			public void actionPerformed(ActionEvent e) 
                        {
                                lblSldv.setText("");
                                lblTongtien.setText("");
                                adapterMd.XoaHddv();
                                tblDvDat.setModel(adapterMd.loadHdDv());
                                JOptionPane.showMessageDialog(null, "Đã in!");
			}
		});
		btnXuat.setBounds(416, 600, 150, 43);
                btnXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); 
                btnXuat.setText("Thanh Toán");
                btnXuat.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnXuat);
		
		JButton btnthanhtoansau = new JButton("Chọn phòng đặt dịch vụ");
		btnthanhtoansau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			adapterMd=new TruyvanKaraoke();
			tblDvDat.setModel(adapterMd.loadHdDv());
			dichvuphong chonphong=new dichvuphong();
			chonphong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			chonphong.setVisible(true);
			chonphong.setLocationRelativeTo(null);
			}
		});
		btnthanhtoansau.setBounds(593, 600, 150, 43);
                btnthanhtoansau.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnthanhtoansau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); 
                btnthanhtoansau.setText("Chọn Phòng");
                btnthanhtoansau.setBackground(new Color(255 ,246 ,143));
		contentPane.add(btnthanhtoansau);
		
		JLabel lblNewLabel_5 = new JLabel("DỊCH VỤ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
                lblNewLabel_5.setForeground(new Color(210, 105, 30));
		lblNewLabel_5.setBounds(20, 11, 294, 35);
		contentPane.add(lblNewLabel_5);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRf.setBounds(620,12,150, 43);
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
            java.util.logging.Logger.getLogger(dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dichvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dichvu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

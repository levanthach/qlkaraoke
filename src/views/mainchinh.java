/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import connection.KetnoiKaraoke;
import controllers.TruyvanKaraoke;
/**
 *
 * @author nguyenchienjf
 */
public class mainchinh extends javax.swing.JFrame {
    TruyvanKaraoke adapterMd;
	KetnoiKaraoke adapterCtr;
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTextField txtCmnd;
	private JTextField txtLienlac;
	private JTable tblPhongtrong;
	private JTable tblKh;
	private JTable tblNvDp;
	private JTable tblDSPD;
	private JComboBox comboBox;
	String chonGioitinh="1";
	String chonPhong=new String();
	String chonNhanvien=new String();
	String chonKhachhang="";
	int demHangTbKh;
	private JTabbedPane tabbedPane;
	private JPanel panel_9;
	private JToolBar toolBar;
	private JPanel panel_10;
	private JLabel lblNewLabel_6;
	private JLabel lblPhng;
	private JLabel lblNhnVin;
	private JLabel lblDchV;

    /**
     * Creates new form viewMain
     */
    public mainchinh() {
        initComponents();
        setTitle("ỨNG DỤNG QUẢN LÝ KARAOKE");
		setResizable(false);
                setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			// Show list customer, room, staff, room booked
			@Override
			public void windowOpened(WindowEvent arg0) {
				adapterMd=new TruyvanKaraoke();
				tblKh.setModel(adapterMd.loadKhachhang());
				adapterMd=new TruyvanKaraoke();
				tblPhongtrong.setModel(adapterMd.loadPhong("0"));
				adapterMd=new TruyvanKaraoke();
				tblNvDp.setModel(adapterMd.loadNhanVien());
				adapterMd=new TruyvanKaraoke();
				tblDSPD.setModel(adapterMd.loadDSDatPhong());	
				adapterCtr=new KetnoiKaraoke();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(1130, 790);
		contentPane = new JPanel();
                contentPane.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.setForeground(new Color(253, 227, 167));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_9 = new JPanel();
                panel_9.setBounds(0, 70, 1120, 670);
                panel_9.setBackground(SystemColor.decode("#76EEC6"));
		panel_9.setLayout(null);
                panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Đặt Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		contentPane.add(panel_9);
                
                
		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 303, 610);
		panel_9.add(panel);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin khách hàng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Tên KH :");
		lblNewLabel.setBounds(20, 45, 60, 20);
		panel.add(lblNewLabel);
                
                txtTenKh = new JTextField();
		txtTenKh.setBounds(95, 40, 170, 30);
		panel.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CMND :");
		lblNewLabel_1.setBounds(20, 97, 60, 20);
		panel.add(lblNewLabel_1);
                
                txtCmnd = new JTextField();
		txtCmnd.setBounds(95, 92, 170, 30);
		panel.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Liên lạc :");
		lblNewLabel_5.setBounds(20, 204, 60, 20);
		panel.add(lblNewLabel_5);
                
                txtLienlac = new JTextField();
		txtLienlac.setBounds(95, 201, 170, 30);
		panel.add(txtLienlac);
		txtLienlac.setColumns(10);
		
	    comboBox = new JComboBox();
	    comboBox.setBounds(95, 145, 170, 30);
	    panel.add(comboBox);
	    comboBox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    		if(comboBox.getSelectedIndex()==0) chonGioitinh="1";
	    		else if(comboBox.getSelectedIndex()==1) chonGioitinh="0";
	    		
	    	}
	    });
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
	    
	    JLabel lblNewLabel_3 = new JLabel("Giới tính :");
	    lblNewLabel_3.setBounds(20, 153, 52, 14);
	    panel.add(lblNewLabel_3);
	    
	    JButton btnThemkh = new JButton();
	    btnThemkh.setBounds(28, 268, 120, 42);
            btnThemkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); 
            btnThemkh.setText("Thêm KH");
            btnThemkh.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnThemkh.setBackground(new Color(255 ,246 ,143));
	    panel.add(btnThemkh);
	 
	    JButton btnXoakh = new JButton();
            btnXoakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); 
            btnXoakh.setText("Xóa KH");
            btnXoakh.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnXoakh.setBackground(new Color(255 ,246 ,143));
	    btnXoakh.setBounds(160, 268, 120, 42);
	    panel.add(btnXoakh);
	    
	    JButton btnBochon = new JButton();
            btnBochon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); 
            btnBochon.setText("Bỏ chọn");
            btnBochon.setFont(new Font("Tahoma", Font.BOLD, 12));
            btnBochon.setBackground(new Color(255 ,246 ,143));
	    btnBochon.setBounds(90, 320, 120, 42);
	    panel.add(btnBochon);
	  
	    btnBochon.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		tblPhongtrong.clearSelection();
	    		tblNvDp.clearSelection();
	    		tblKh.clearSelection();
	    	}
	    });
	    btnXoakh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(chonKhachhang.equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null,"Chưa chọn khách hàng");
	    		}
	    		else
	    		{
	    		adapterMd=new TruyvanKaraoke();
	    		adapterMd.XoaId("tb_khachhang","ma_kh",chonKhachhang);
	    		adapterMd=new TruyvanKaraoke();
	    		tblKh.setModel(adapterMd.loadKhachhang());
	    		chonKhachhang="";
	    		}
	    	}
	    });
	    btnThemkh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(txtTenKh.getText().toString().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
	    		}
	    		else
	    		{
	    			adapterMd=new TruyvanKaraoke();
	    			adapterMd.ThemKhachHang(txtTenKh.getText().toString(),txtCmnd.getText().toString(),chonGioitinh,txtLienlac.getText().toString(),"0");
	    		    tblKh.setModel(adapterMd.loadKhachhang());
	    		     
	    		    txtTenKh.setText("");
	    			txtCmnd.setText("");
	    			txtLienlac.setText("");
	    		}
	    		
	    	}
	    });
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBounds(320, 30, 258, 321);
	    panel_9.add(panel_2);
	    panel_2.setBackground(SystemColor.decode("#76EEC6"));
	    panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng chờ:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_2.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBackground(new Color(102, 0, 102));
	    panel_2.add(scrollPane_1);
	    
	    tblKh = new JTable();
	    tblKh.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    	chonKhachhang=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();
	    	}
	    });
	    scrollPane_1.setViewportView(tblKh);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBounds(572, 30, 270, 321);
	    panel_9.add(panel_3);
            panel_3.setBackground(SystemColor.decode("#76EEC6"));
	    panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách phòng trống:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_3.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    panel_3.add(scrollPane_2);
	    tblPhongtrong = new JTable();
	    scrollPane_2.setViewportView(tblPhongtrong);
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBounds(840, 30, 264, 321);
	    panel_9.add(panel_5);
            panel_5.setBackground(SystemColor.decode("#76EEC6"));
	    panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nhân viên phục vụ:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_5.setLayout(new GridLayout(1, 0, 0, 0));
	    
	    JScrollPane scrollPane_3 = new JScrollPane();
	    panel_5.add(scrollPane_3);
	    
	    tblNvDp = new JTable();
	    tblNvDp.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	JOptionPane.showMessageDialog(null,"NV "+tblNvDp.getModel().getValueAt(tblNvDp.getSelectedRow(),1).toString()+" vừa được chọn.");
	    	}
	    });
	    scrollPane_3.setViewportView(tblNvDp);
	    JPanel panel_7 = new JPanel();
	    panel_7.setBounds(320, 420, 779, 220);
	    panel_9.add(panel_7);
            panel_7.setBackground(SystemColor.decode("#76EEC6"));
	    panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách phòng đã đặt :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
	    panel_7.setLayout(new GridLayout(1, 0, 0, 0));   
	    JScrollPane scrollPane = new JScrollPane();
	    panel_7.add(scrollPane);
	    
	    tblDSPD = new JTable();
	    scrollPane.setViewportView(tblDSPD);

	    JButton btnLammoi = new JButton();
	    btnLammoi.setFont(new Font("Tahoma", Font.BOLD, 13));
            btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loop2.png"))); 
            btnLammoi.setText("CẬP NHẬT");
            btnLammoi.setBackground(new Color(255 ,246 ,143));
	    btnLammoi.setBounds(720, 360, 150, 53);
	    panel_9.add(btnLammoi);
	    
	    JButton button_1 = new JButton();
            button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
            button_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bell.png"))); 
            button_1.setText("ĐẶT PHÒNG");
            button_1.setBackground(new Color(255 ,246 ,143));
	    button_1.setBounds(520, 360, 150, 53);
	    panel_9.add(button_1);
	    button_1.addActionListener(new ActionListener() {
		// Handle book room in main
	    public void actionPerformed(ActionEvent e) {
 	
	    if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng này!","Kiểm tra lại",
	    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)		
	    {
        try
    	{
    	if(tblKh.getRowCount()==0)
    	{
    		JOptionPane.showMessageDialog(null, "Chưa thêm khách hàng!");
    	}
    	else
    	{
    		demHangTbKh=tblKh.getRowCount();
                chonPhong=tblPhongtrong.getModel().getValueAt(tblPhongtrong.getSelectedRow(),0).toString();
                chonNhanvien=tblNvDp.getModel().getValueAt(tblNvDp.getSelectedRow(),0).toString();
                adapterMd=new TruyvanKaraoke();
                adapterMd.ThemKhachNhanPhong(chonPhong,"0");
                adapterMd.ThemHopDong(chonPhong,chonNhanvien);
                adapterMd.updateKhachHang();
                adapterMd.updatePhong("1",chonPhong);
                adapterMd=new TruyvanKaraoke();
                tblKh.setModel(adapterMd.loadKhachhang());
                adapterMd=new TruyvanKaraoke();
                tblPhongtrong.setModel(adapterMd.loadPhong("0"));
                adapterMd=new TruyvanKaraoke();
                tblDSPD.setModel(adapterMd.loadDSDatPhong());	
                //hiển thị lại các phòng
                chonPhong=new String();
    	}
    	}
    		catch(Exception ex)
    			{
    			JOptionPane.showMessageDialog(null,"Phải chọn Phòng và Nhân viên, kiểm tra lại!");
    		    }
                	
                }
                }
	    });
	   
	    btnLammoi.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		adapterMd=new TruyvanKaraoke();
	    		tblKh.setModel(adapterMd.loadKhachhang());
	    		adapterMd=new TruyvanKaraoke();
	    		tblPhongtrong.setModel(adapterMd.loadPhong("0"));
	    		adapterMd=new TruyvanKaraoke();
	    		tblNvDp.setModel(adapterMd.loadNhanVien());
	    		adapterMd=new TruyvanKaraoke();
	    		tblDSPD.setModel(adapterMd.loadDSDatPhong());	
	    		
	    		adapterCtr=new KetnoiKaraoke();
	    	}
	    });

		JButton btnNewButton_6 = new JButton();
		btnNewButton_6.setBounds(15, 13, 145, 42);
                btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); 
                btnNewButton_6.setText("Khách Hàng");
                btnNewButton_6.setBackground(new Color(255 ,246 ,143));
                contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		khachhang kh=new khachhang();
		kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kh.setVisible(true);
		kh.setLocationRelativeTo(null);
                dispose();
			}
		});
		JButton btnNewButton_5 = new JButton();
                btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); 
                btnNewButton_5.setText("Phòng Hát");
                btnNewButton_5.setBackground(new Color(255 ,246 ,143));
		btnNewButton_5.setBounds(160, 13, 135, 42);
		contentPane.add(btnNewButton_5);
                btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phong ph=new phong();
				ph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ph.setVisible(true);
				ph.setLocationRelativeTo(null);
                                dispose();
			}
		});
                
                
		JButton btnNewButton_3 = new JButton();
                btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); 
                btnNewButton_3.setText("Nhân viên");
                btnNewButton_3.setBackground(new Color(255 ,246 ,143));
		btnNewButton_3.setBounds(295, 13, 135, 42);
                contentPane.add(btnNewButton_3);
                
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanvien nv=new nhanvien();
				nv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				nv.setVisible(true);
				nv.setLocationRelativeTo(null);
                                 dispose();
			}
		});
		
		
		JButton btnNewButton_4 = new JButton();
                btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/food.png"))); 
                btnNewButton_4.setText("Dịch Vụ");
                btnNewButton_4.setBackground(new Color(255 ,246 ,143));
		btnNewButton_4.setBounds(430, 13, 135, 42);
                contentPane.add(btnNewButton_4);
                
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dichvu dv=new dichvu();
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dv.setVisible(true);
				dv.setLocationRelativeTo(null);
                                 dispose();
			}
		});
		JButton btnNewButton_2 = new JButton("Trả Phòng");
		btnNewButton_2.setBounds(565, 13, 135, 42);
                btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); 
                btnNewButton_2.setText("Trả Phòng");
                btnNewButton_2.setBackground(new Color(255 ,246 ,143));
                 contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traphong bl=new traphong();
				bl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				bl.setVisible(true);
				bl.setLocationRelativeTo(null);
                                 dispose();
			}
		});
		JButton btnNewButton_7 = new JButton();
                btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); 
                btnNewButton_7.setText("Doanh thu");
                btnNewButton_7.setBackground(new Color(255 ,246 ,143));
		btnNewButton_7.setBounds(700, 13, 135, 42);
                contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		doanhthu tt=new doanhthu();
		tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tt.setVisible(true);
		tt.setLocationRelativeTo(null);
                dispose();
			}
		});
		JButton btnNewButton_1 = new JButton("Tài Khoản");
                btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user4.png"))); 
                btnNewButton_1.setText("Tài Khoản");
                btnNewButton_1.setBackground(new Color(255 ,246 ,143));
		btnNewButton_1.setBounds(835, 13, 135, 42);
                contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taikhoan ht=new taikhoan();
				ht.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ht.setVisible(true);
				ht.setLocationRelativeTo(null);
                                 dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Đăng Xuất");
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); 
                btnNewButton.setText("Đăng Xuất");
                btnNewButton.setBackground(new Color(255 ,246 ,143));
		btnNewButton.setBounds(970, 13, 135, 42);
                 contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                            {
                                   login lg=new login();
                                   lg.setVisible(true);
                           lg.setLocationRelativeTo(null);
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
        setIconImages(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(mainchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new mainchinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

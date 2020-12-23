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
public class traphong extends javax.swing.JFrame {
    
        TruyvanKaraoke adapterMd=new TruyvanKaraoke();
        KetnoiKaraoke adapterCtr=new KetnoiKaraoke();
	private JPanel contentPane;
	private JTextField txttenphong;
	private JTextField txtloaiphong;
	private JTextField txtgiaphong;
	private JTextField txtngayden;
	private JTextField txtngayht;
	private JTextField txttongngay;
	private JTable tblphong;
	private JTextField txtngaydv;
	private JTextField txtsldv;
	private JTextField txttiendv;
	private JTextField txttongtien;
	String idP="0";
	private JTextField txtnhanvien;
	private JLabel lblngaytt;
	private JTextField txttonggio;
	private int tien;
	private JLabel lbltientt;
	private JTextField txtgioden;
	private JTextField txtgioht;
    /**
     * Creates new form viewBienlai
     */
    public traphong() {
        initComponents();
        setTitle("Hóa Đơn Karaoke Nguyễn Chiến JF");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
		tblphong.setModel(adapterMd.loadPhong("1"));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setBackground(SystemColor.decode("#76EEC6"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chọn phòng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel.setBounds(10, 65, 329, 437);
                panel.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblphong = new JTable();
		tblphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		idP=tblphong.getModel().getValueAt(tblphong.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(tblphong);	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin hóa đơn Karaoke :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_1.setBounds(349, 65, 535, 437);
                panel_1.setBackground(SystemColor.decode("#76EEC6"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel txtNewLabel_1 = new JLabel("Tên Phòng :");
		txtNewLabel_1.setBounds(13, 36, 81, 14);
		panel_1.add(txtNewLabel_1);
		
		JLabel txtNewLabel_2 = new JLabel("Ngày Trả :");
		txtNewLabel_2.setBounds(13, 206, 56, 14);
		panel_1.add(txtNewLabel_2);
		
		JLabel txtNewLabel_3 = new JLabel("Ngày Đến :");
		txtNewLabel_3.setBounds(13, 168, 60, 14);
		panel_1.add(txtNewLabel_3);
		
		JLabel txtNewLabel_4 = new JLabel("Loại phòng :");
		txtNewLabel_4.setBounds(13, 84, 81, 14);
		panel_1.add(txtNewLabel_4);
		
		JLabel txtNewLabel_5 = new JLabel("Giá phòng/1h :");
		txtNewLabel_5.setBounds(13, 130, 95, 14);
		panel_1.add(txtNewLabel_5);
		
	
		txttenphong = new JTextField();
		txttenphong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txttenphong.setEditable(false);
		txttenphong.setBounds(104, 28, 139, 30);
		panel_1.add(txttenphong);
		txttenphong.setColumns(10);
		
		txtloaiphong = new JTextField();
		txtloaiphong.setEditable(false);
		txtloaiphong.setBounds(104, 76, 138, 30);
		panel_1.add(txtloaiphong);
		txtloaiphong.setColumns(10);
		
		txtgiaphong = new JTextField();
		txtgiaphong.setEditable(false);
		txtgiaphong.setBounds(104, 122, 139, 30);
		panel_1.add(txtgiaphong);
		txtgiaphong.setColumns(10);
		
		
		txtngayden = new JTextField();
		txtngayden.setEditable(false);
		txtngayden.setBounds(104,160, 139, 30);
		panel_1.add(txtngayden);
		txtngayden.setColumns(10);
		
		txtngayht = new JTextField();
		txtngayht.setEditable(false);
		txtngayht.setBounds(104, 198, 139, 30);
		panel_1.add(txtngayht);
		txtngayht.setColumns(10);
		
		
		JLabel txtNewLabel_8 = new JLabel("Ngày đặt DV :");
		txtNewLabel_8.setBounds(270, 36, 95, 14);
		panel_1.add(txtNewLabel_8);
		
		txtngaydv = new JTextField();
		txtngaydv.setEditable(false);
		txtngaydv.setBounds(358, 28, 153, 30);
		panel_1.add(txtngaydv);
		txtngaydv.setColumns(10);
		
		txtsldv = new JTextField();
		txtsldv.setEditable(false);
		txtsldv.setBounds(358, 78, 153, 30);
		panel_1.add(txtsldv);
		txtsldv.setColumns(10);
		
		txttiendv = new JTextField();
		txttiendv.setEditable(false);
		txttiendv.setBounds(358, 122, 153, 30);
		panel_1.add(txttiendv);
		txttiendv.setColumns(10);
		
		JLabel txtNewLabel_9 = new JLabel("Sl dịch vụ :");
		txtNewLabel_9.setBounds(270, 84, 96, 14);
		panel_1.add(txtNewLabel_9);
		
		JLabel txtNewLabel_10 = new JLabel("Tổng tiền dv :");
		txtNewLabel_10.setBounds(270, 130, 95, 14);
		panel_1.add(txtNewLabel_10);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            adapterCtr.luuid(idP,"*");
		    hoadon bl=new hoadon();
			bl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			bl.setVisible(true);
			bl.setLocationRelativeTo(null);	
            }
		});
		btnNewButton_1.setBounds(358, 168, 150, 42);
                btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/food.png"))); 
                btnNewButton_1.setText("Xem Dịch Vụ");
                btnNewButton_1.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnNewButton_1);
		
		JLabel txtNewLabel_7 = new JLabel("Tổng số tiền thanh toán");
		txtNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNewLabel_7.setBounds(282, 303, 229, 33);
		panel_1.add(txtNewLabel_7);
		
		lblngaytt = new JLabel("");
		lblngaytt.setBounds(350, 280, 143, 14);
                lblngaytt.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblngaytt);
		
		JButton btnTraphong = new JButton();
		btnTraphong.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	if(adapterCtr.demDong("tb_phong",adapterCtr.demPhongDat).equals("0")) JOptionPane.showMessageDialog(null,"Không có phòng!");
	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn trả phòng "+tblphong.getModel().getValueAt(tblphong.getSelectedRow(),1).toString()+" ","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	{	
		txttenphong.setText("");
		txtloaiphong.setText("");
		txtgiaphong.setText("");
		txtngayden.setText("");
		txtngayht.setText("");
		txtngaydv.setText("");
		txtsldv.setText("");
		txttiendv.setText("");
		txttongtien.setText("");
                txtnhanvien.setText("");
		lblngaytt.setText("");
		txttonggio.setText("");
		lbltientt.setText("");
		txtgioden.setText("");
		txtgioht.setText("");
	    	//update phòng được chọn tinhtrang từ 1 thành 0
			adapterMd.updatePhong("0",idP);
			// xóa hóa đơn dv theo phòng được chọn
			adapterMd.XoaHddvTp(idP);
			// xóa biên lai theo phòng được chọn
			adapterMd.XoaBlTp(idP);
			// xóa khách hàng theo phòng được chọn
			adapterMd.XoaKhTp(idP);
			// xóa khách nhạn phòng theo phòng được chọn
			adapterMd.XoaKnpTp(idP);
			// xóa hợp đồng thuê phòng theo phòng
			adapterMd.XoaHdTp(idP);
			JOptionPane.showMessageDialog(null,"Đã in biên lai, tất cả dữ liệu đã xóa!");
			tblphong.setModel(adapterMd.loadPhong("1"));
	}
			}
		});
		btnTraphong.setBounds(307, 379, 150, 43);
                btnTraphong.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnTraphong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); 
                btnTraphong.setText("Thanh Toán");
                btnTraphong.setBackground(new Color(255 ,246 ,143));
		panel_1.add(btnTraphong);
		
		JLabel txtNewLabel_13 = new JLabel("TTiền Phòng :");
		txtNewLabel_13.setBounds(13, 358, 81, 14);
		panel_1.add(txtNewLabel_13);
		
		txttongtien = new JTextField();
		txttongtien.setEditable(false);
		txttongtien.setBounds(104, 352, 139, 30);
		panel_1.add(txttongtien);
		txttongtien.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhân viên PV :");
		lblNewLabel.setBounds(270, 230, 113, 14);
		panel_1.add(lblNewLabel);
		
		txtnhanvien = new JTextField();
		txtnhanvien.setEditable(false);
		txtnhanvien.setBounds(358, 224, 153, 30);
		panel_1.add(txtnhanvien);
		txtnhanvien.setColumns(10);
		
		lbltientt = new JLabel("0 VNĐ");
		lbltientt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbltientt.setBounds(340, 335, 139, 33);
		panel_1.add(lbltientt);
		
		JLabel lblNewLabel_2 = new JLabel("Số giờ :");
		lblNewLabel_2.setBounds(13, 320, 58, 14);
		panel_1.add(lblNewLabel_2);
		
		txttonggio = new JTextField();
		txttonggio.setEditable(false);
		txttonggio.setBounds(104, 312, 139, 30);
		panel_1.add(txttonggio);
		txttonggio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giờ đến :");
		lblNewLabel_1.setBounds(13, 244, 65, 14);
		panel_1.add(lblNewLabel_1);
		
		txtgioden = new JTextField();
		txtgioden.setEditable(false);
		txtgioden.setBounds(104, 238, 139, 30);
		panel_1.add(txtgioden);
		txtgioden.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Giờ Trả :");
		lblNewLabel_3.setBounds(13, 282, 55, 14);
		panel_1.add(lblNewLabel_3);
		
		txtgioht = new JTextField();
		txtgioht.setEditable(false);
		txtgioht.setBounds(104, 274, 139, 30);
		panel_1.add(txtgioht);
		txtgioht.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtngayht.setText(adapterCtr.ngayHt);
				txtgiaphong.setText(adapterCtr.cellTb("gia_phong",adapterCtr.itemGiaP(idP)));
				txtngayden.setText(adapterCtr.cellTb("ngay_dp",adapterCtr.itemTgden(idP)));
				txtgioden.setText(adapterCtr.cellTb("gio_dp",adapterCtr.itemTgden(idP)));
				txtngaydv.setText(adapterCtr.cellTb("ngay_hddv",adapterCtr.itemNgayDv(idP)));
				txtnhanvien.setText(adapterCtr.cellTb("ten_nv",adapterCtr.itemNv(idP)));
				txttenphong.setText(tblphong.getModel().getValueAt(tblphong.getSelectedRow(),1).toString());
				txtloaiphong.setText(tblphong.getModel().getValueAt(tblphong.getSelectedRow(),2).toString());
				txttiendv.setText(adapterCtr.demTien(adapterCtr.demtien2(idP))+" VNĐ");
				txtsldv.setText(adapterCtr.demDong("tb_hoadondv,tb_bienlai,tb_hdtp,tb_phong",adapterCtr.demDichvu(idP)));
				lblngaytt.setText(adapterCtr.ngayHt);
				txtgioht.setText(adapterCtr.gioHt);
				/// tính tiền khách sạn:
				String sogio=adapterCtr.demGio(adapterCtr.cellTb("ngay_dp",adapterCtr.itemTgden(idP)),adapterCtr.cellTb("gio_dp",adapterCtr.itemTgden(idP)),adapterCtr.ngayHt,adapterCtr.gioHt);
                                txttonggio.setText(sogio);
			    if(Integer.parseInt(sogio)<=1)
			    	{
			    	tien=Integer.parseInt(txtgiaphong.getText().toString());
			    	}
			    else tien=Integer.parseInt(sogio)*Integer.parseInt(txtgiaphong.getText().toString());
			    txttongtien.setText(tien+" VNĐ");
			    int thanhtoan=tien+Integer.parseInt(adapterCtr.demTien(adapterCtr.demtien2(idP)));
			    lbltientt.setText(thanhtoan+" VNĐ");
			}
		});
		btnNewButton.setBounds(349, 15, 160, 42);
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
                btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); 
                btnNewButton.setText("Xem thống kê");
                btnNewButton.setBackground(new Color(255 ,246 ,143));
                
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("THANH TOÁN - TRẢ PHÒNG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
                lblNewLabel_4.setForeground(new Color(210, 105, 30));
		lblNewLabel_4.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_4);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRf.setBounds(700, 15, 150, 43);
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
            java.util.logging.Logger.getLogger(traphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(traphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(traphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(traphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new traphong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

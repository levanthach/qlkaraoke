/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author nguyenchienjf
 */

public class TruyvanKaraoke {
	String chuoikn = "jdbc:sqlserver://localhost:1433;databaseName=QLYKARAOKE;user=sa;password=123";
	DefaultTableModel tbModel=new DefaultTableModel();
	DefaultComboBoxModel cmbModel=new DefaultComboBoxModel();
	private Connection con;
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio= new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	public String Id(String tb,String ma)
	{
	    int id1=0,id2=0;
		String id = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+tb+"");
				while(rs.next())
				{
					id = new String();
					id = rs.getString(ma);
					id1=Integer.parseInt(id);
					if(id1>=id2)
					{
						id2=id1;
					}
				}
				id=String.valueOf(id2+1);
				return id;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "lỗi id: " + ex.toString());
				return null;
			}
	}

	public void ThemKhachHang(String ten_kh,String cmnd_kh,String gioitinh_kh,String sdt_kh,String tt)
	{		
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
	int i = st.executeUpdate("insert into tb_khachhang  values(N'"+Id("tb_khachhang","ma_kh")+"',N'"+ten_kh+"',N'" +cmnd_kh+"',N'VIỆT NAM',N'" +gioitinh_kh+"',N'18',N'" +sdt_kh+"',N'"+tt+"')");	 
	if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm khách hàng");
	}catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
	}
	}
	public void ThemPhong(String ten_phong,String loai_phong,String gia_phong)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_phong(ten_phong, loai_phong, gia_phong, tinh_trang)  values(N'" +ten_phong+"',N'" +loai_phong+"',N'" +gia_phong+"',0)");
			//	if(i>0&&tinhtrang==1) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm phòng");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng!" + ex.toString());
			}
	}
	
	public void ThemDichVu(String ten_dv,String gia_dv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_dichvu  values(N'"+Id("tb_dichvu","ma_dv")+"',N'" +ten_dv+"',N'" +gia_dv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm dịch vụ");
			}catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Nhập sai tiền, phải nhập số /1000đ");
			}
	}
	
	public void ThemHopDong(String ma_phong,String ma_nv)
	{
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		int i = st.executeUpdate("insert into tb_hdtp  values(N'"+Id("tb_hdtp","ma_hd")+"',N'"+ma_phong+"',N'"+ma_nv+"',N'"+ngay.format(cal.getTime())+"',N'"+gio.format(cal.getTime())+"')");
		if(i>0) JOptionPane.showMessageDialog(null, "Phòng đã được đặt");
		  }catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm hợp đồng " + ex.toString());
			}
	}
	
	public void ThemKhachNhanPhong(String ma_phong,String tt)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
			}catch(Exception ex)
			{

				JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
			}
	}
	public void Them(String ma_phong,String tt)
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			st.executeUpdate("insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang=N'"+tt+"' and tb_phong.ma_phong='"+ma_phong+"'");
		}catch(Exception ex)
		{

			JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng nhận phòng " + ex.toString());
		}
}
	public void ThemHoaDonDv(String ma_dv,String giodv,String ngaydv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
			    st.executeUpdate("insert into tb_hoadondv  values(N'"+Id("tb_hoadondv","ma_hddv")+"',N'"+ma_dv+"',N'" +giodv+"',N'" +ngaydv+"',N'0')");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Chưa chọn dịch vụ !");
			}
	}
	public void ThemBienLai(String ma_hopdong,String ma_hddv)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_bienlai  values(N'"+Id("tb_bienlai","ma_bl")+"',N'"+ma_hopdong+"',N'"+ma_hddv+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Biên lai đã được thêm");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm biên lai!" + ex.toString());
			}
	}
  public void ThemNhanVien(String ten_nv,String username,String password,String gioi_tinh,String phone,String email)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_nhanvien(username, password, name, gioi_tinh, phone, email)  values(N'"+username+"',N'"+password+"',N'"+ten_nv+"',N'"+gioi_tinh+"',N'"+phone+"',N'"+email+"')");
				if(i>0) JOptionPane.showMessageDialog(null, "Nhân viên đã được thêm");
			}catch(Exception ex)
			{
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên!" + ex.toString());
			}
	}
  public void ThemUser(String taikhoan,String matkhau,String hoten)
	{
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(chuoikn);
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into tb_login  values(N'"+Id("tb_login","ma_tk")+"',N'"+taikhoan+"',N'"+matkhau+"',N'"+hoten+"',N'0')");
				if(i>0) JOptionPane.showMessageDialog(null, "Đã thêm người dùng");
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "lỗi thêm người dùng!" + ex.toString());
			}
	}
    public void updateMaKhto0(String makh)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='0' where tinhtrang='1' and ma_kh=N'"+makh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	public void updateMatkhau(String matkhaumoi,String ma_tk)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
				Statement st=connection.createStatement();
		       int i=st.executeUpdate("update tb_login set matkhau=N'"+matkhaumoi+"' where ma_tk='"+ma_tk+"'");		
		       if(i>0) JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu!");
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Lỗi mật khẩu!" + e.toString());
			} 
	}
	
	public void updateKhachHang()
	{
	     try 
	     {  
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  Connection connection = DriverManager.getConnection(chuoikn);
	  PreparedStatement st = connection.prepareStatement("update tb_khachhang set tinhtrang='1' where tinhtrang='0'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	public void updateAllKh(String ma_kh,String ten,String cmnd,String gioitinh,String sdt)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
PreparedStatement st = connection.prepareStatement("update tb_khachhang set ten_kh=N'"+ten+"', cmnd_kh=N'"+cmnd+"', quoctich_kh=N'VIỆT NAM', gioitinh_kh=N'"+gioitinh+"', tuoi_kh=N'18', sdt_kh=N'"+sdt+"' where ma_kh='"+ma_kh+"'");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update khách hàng!" + e.toString());
			} 
	}
	public void updatePhong(String tt,String chonPhong)
	{
	     try 
	     {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(chuoikn);
			        PreparedStatement st = connection.prepareStatement("update tb_phong set tinhtrang='"+tt+"' where ma_phong="+chonPhong+"");
			st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã trả phòng!","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update phòng!" + e.toString());
			} 
	}
	public void updateHDDV(String mot,String ko)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set tinhtrang=N'"+mot+"' where tinhtrang=N'"+ko+"'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update HDDV!" + e.toString());
			} 
	}
	public void updateHopDongInHDon(String ma_hd)
	{
	     try 
	     {  
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection connection = DriverManager.getConnection(chuoikn);
	     PreparedStatement st = connection.prepareStatement("update tb_hoadondv set ma_hd=N'"+ma_hd+"' where tinhtrang=N'1'");
	     st.executeUpdate();						    				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi update dịch vụ!" + e.toString());
			} 
	}
	public void XoaHddv()
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where tinhtrang='0'");
				st.executeUpdate();			
				//JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa!" + e.toString());
		    } 
	}
	//trả phòng 3 xóa khách hàng
	public void XoaKhTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachhang where ma_kh in (select tb_khachhang.ma_kh from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKhTp!" + e.toString());
		    } 
	} 
	//trả phòng 4 xóa khachnhanphong
	public void XoaKnpTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_khachnhanphong where ma_kh in (select tb_khachnhanphong.ma_kh from tb_khachnhanphong,tb_phong where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaKnpTp!" + e.toString());
		    } 
	} 
	//trả phòng 1
	public void XoaHddvTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hoadondv where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaHddvTp!" + e.toString());
		    } 
	} 
	//trả phòng 2 xóa biên lai
	public void XoaBlTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_bienlai where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "không có thông tin để xóa");
		    } 
	} 
	//trả phòng 5 xóa hdtp
	public void XoaHdTp(String maphong)
	{
		  try 
		     {  
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    Connection connection = DriverManager.getConnection(chuoikn);
				PreparedStatement st = connection.prepareStatement("delete from tb_hdtp where ma_phong in (select tb_hdtp.ma_phong from tb_hdtp, tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
				st.executeUpdate();							    				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi khi xóa. XoaBlTp!" + e.toString());
		    } 
	}
	public void XoaId(String table,String id1,String id2)
	{
	  try 
	     {  
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection connection = DriverManager.getConnection(chuoikn);
			PreparedStatement st = connection.prepareStatement("delete from "+table+" where "+id1+"=N'"+id2+"'");
			st.executeUpdate();			
				JOptionPane.showMessageDialog(null, "Ðã xóa","Thông báo: ",JOptionPane.YES_NO_CANCEL_OPTION);				    				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Không có gì để xóa");
	    } 
	}
	/// lOAD tất cả kh
	public DefaultTableModel loadAllKh()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,cmnd_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong order by ma_kh asc");
			String[] tieudecot = {"ID","Tên KH","CMND","Giới tính","Liên lạc","Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[8];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
				dong[2] = rs.getString("cmnd_kh");
				dong[3] = rs.getString("gioitinh_kh");
				dong[4] = rs.getString("sdt_kh");
				//dong[6] = rs.getString("tinhtrang");
				dong[5] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][8];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load Kh " + ex.toString());
			return null;
		}
		}
	//tìm kiếm phòng
	public DefaultTableModel loadTimPhong(String phong)
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select DISTINCT tb_khachhang.ma_kh,ten_kh,cmnd_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong and ten_phong=N'"+phong+"' order by ma_kh asc");
				String[] tieudecot = {"ID","Tên KH","CMND","Quốc tịch","Giới tính","Tuổi","Liên lạc","Phòng"};
				ArrayList<String[]> dulieubang = new ArrayList<String[]>();
				while(rs.next())
				{
					String[] dong = new String[8];
					dong[0] = rs.getString("ma_kh");
					dong[1] = rs.getString("ten_kh");
					dong[2] = rs.getString("cmnd_kh");
					dong[3] = rs.getString("quoctich_kh");
					dong[4] = rs.getString("gioitinh_kh");
					dong[5] = rs.getString("tuoi_kh");
					dong[6] = rs.getString("sdt_kh");
					//dong[6] = rs.getString("tinhtrang");
					dong[7] = rs.getString("ten_phong");
					dulieubang.add(dong);
				}
				//
				String[][] data = new String[dulieubang.size()][8];
				for(int i=0; i<dulieubang.size(); i++)
				{
					data[i]=dulieubang.get(i);
				}
				tbModel.setDataVector(data,tieudecot);
				return tbModel;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Báo l?i: " + ex.toString());
				return null;
			}
		}
	/**
	 * @wbp.parser.entryPoint
	 */
	public DefaultTableModel loadKhachhang()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_kh,ten_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh from tb_khachhang where tinhtrang='0' order by ma_kh asc");//load du lieu len JTable
			String[] tieudecot = {"Mã KH","Tên KH","Giới tính"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_kh");
				dong[1] = rs.getString("ten_kh");
				dong[2] = rs.getString("gioitinh_kh");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
			return null;
		}
	} 
	//LOAD PHÒNG tt=0:phòng trống, tt=1 phòng đã đặt
	public DefaultTableModel loadPhong(String tt)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_phong,ten_phong,case loai_phong when 1 then N'phòng thường' else N'Phòng Vip' end as loai_phong from tb_phong where tinhtrang=N'"+tt+"' order by ma_phong asc");
		String[] tieudecot = {"Mã Phòng","Tên Phòng","Loại Phòng"};
		ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		while(rs.next())
		{
		String[] dong = new String[3];
		dong[0] = rs.getString("ma_phong");
		dong[1] = rs.getString("ten_phong");
		dong[2] = rs.getString("loai_phong");
		dulieubang.add(dong);
		}
		String[][] data = new String[dulieubang.size()][3];
		for(int i=0; i<dulieubang.size(); i++)
		{
		data[i]=dulieubang.get(i);
		}
		tbModel.setDataVector(data,tieudecot);
		return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
		return null;
	}
	}
	public DefaultTableModel loadAllNv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_nv,username, name, gioi_tinh,phone,email from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên TK", "Tên NV", "Giới tính", "SĐT","Email"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[6];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("username");
				dong[2] = rs.getString("name");
				dong[3] = rs.getString("gioi_tinh");
				dong[4] = rs.getString("phone");
				dong[5] = rs.getString("email");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][6];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
	// LOAD NHÂN VIEN
	public DefaultTableModel loadNhanVien()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_nhanvien order by ma_nv asc");
			String[] tieudecot = {"Mã NV","Tên NV","Chức vụ"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_nv");
				dong[1] = rs.getString("ten_nv");
				dong[2] = rs.getString("chucvu_nv");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
			return null;
		}
	} 
	public DefaultTableModel loadDSDatPhong()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ten_phong,loai_phong,gia_phong,tb_hdtp.ngay_dp,tb_hdtp.gio_dp from tb_phong,tb_hdtp where tb_phong.tinhtrang='1' and tb_phong.ma_phong=tb_hdtp.ma_phong order by ma_nv asc");//load du lieu len JTable
	
			String[] tieudecot = {"Tên Phòng","Loại Phòng","Giá Phòng","Ngày Đặt Phòng","Giờ Đặt Phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_phong");
				dong[1] = rs.getString("loai_phong");
				dong[2] = rs.getString("gia_phong");
				dong[3] = rs.getString("ngay_dp");
				dong[4] = rs.getString ("gio_dp");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load phòng! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadDichVu()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_dichvu order by ma_dv asc");
			String[] tieudecot = {"ID","Tên Dv","Giá Dv"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ma_dv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gia_dv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}	
	}

	public DefaultTableModel loadDvPhong(String maphong)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ma_dv,tb_dichvu.ten_dv,tb_dichvu.gia_dv,tb_hoadondv.gio_hddv,tb_hoadondv.ngay_hddv,tb_phong.ten_phong from tb_dichvu,tb_hoadondv,tb_hdtp,tb_bienlai,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"' order by ma_dv asc");
			String[] tieudecot = {"Tên Dv","Giá Dv","Thời gian đặt","Ngày đặt","Tên phòng"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[5];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dong[4] = rs.getString("ten_phong");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][5];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}	
	}
	public DefaultTableModel loadTtDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select tb_dichvu.ten_dv,gio_hddv,tb_dichvu.gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"Dịch vụ","Đơn Giá","Thời gian đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("ten_dv");
				dong[1] = rs.getString("gia_dv");
				dong[2] = rs.getString("gio_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadHdDv()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select ma_hddv,tb_dichvu.ten_dv,gio_hddv,ngay_hddv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc");
			String[] tieudecot = {"ID","Tên Dv","Tgian đặt","Ngày đặt"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[4];
				dong[0] = rs.getString("ma_hddv");
				dong[1] = rs.getString("ten_dv");
				dong[2] = rs.getString("gio_hddv");
				dong[3] = rs.getString("ngay_hddv");
				dulieubang.add(dong);
			}
			//
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi khi load dich vụ! " + ex.toString());
			return null;
		}
	}
	public DefaultTableModel loadUser()
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tb_login order by ma_tk asc");
			String[] tieudecot = {"Id","Tên","Tên Tk","Mật khẩu!"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			int j=0;
			while(rs.next())
			{
				j++;
				if(j==1);
				else
				{
				String[] dong = new String[4];
				dong[0] = rs.getString("ma_tk");
				dong[1] = rs.getString("ten_tk");
				dong[2] = rs.getString("taikhoan");
				dong[3] = rs.getString("matkhau");
				dulieubang.add(dong);
				}
			}
			//
			String[][] data = new String[dulieubang.size()][4];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Lỗi load user" + ex.toString());
			return null;
		}	
	}
	public DefaultComboBoxModel loadQuoctich()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn quốc tịch");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select DISTINCT quoctich_kh from tb_khachhang");
			while(rs.next()){
				cmbModel.addElement(rs.getString("quoctich_kh"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadPhongList()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn phòng:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_phong from tb_phong, tb_hdtp where tb_hdtp.ma_phong=tb_phong.ma_phong");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_phong"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadUserList()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn User:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_tk from tb_login");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_tk"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	public DefaultComboBoxModel loadNhanvienCmb()
	{ 
		cmbModel=new DefaultComboBoxModel();
		cmbModel.addElement("chọn nv:");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(chuoikn);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ten_nv from tb_nhanvien");
			while(rs.next()){
				cmbModel.addElement(rs.getString("ten_nv"));
			}
			return cmbModel;
	}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public DefaultTableModel loadDt(String time)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select thoi_gian, SUM(tong_tien) as doanhthu from tb_hoadon where thoi_gian='"+time+"' group by thoi_gian");
			String[] tieudecot = {"Thời gian","Doanh thu"};
			ArrayList<String[]> dulieubang = new ArrayList<String[]>();
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("thoi_gian");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
	
	
	public DefaultTableModel loadDtFor(String chonHt)
	{
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(chuoikn);
		Statement st = con.createStatement();
		ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		if(chonHt=="1")
		{
			ResultSet rs = st.executeQuery("select thoi_gian, SUM(tong_tien) as doanhthu from tb_hoadon group by thoi_gian");
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("thoi_gian");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Thời gian","Doanh thu"};
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
		else if(chonHt == "2")
		{
			ResultSet rs = st.executeQuery("select year(thoi_gian) as nam, month(thoi_gian) as thang, sum(tong_tien) as doanhthu from tb_hoadon group by year(thoi_gian),month(thoi_gian)");
			while(rs.next())
			{
				String[] dong = new String[3];
				dong[0] = rs.getString("nam");
				dong[1] = rs.getString("thang");
				dong[2] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Năm", "Tháng", "Doanh thu"};
			String[][] data = new String[dulieubang.size()][3];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
		else
		{
			ResultSet rs = st.executeQuery("select year(thoi_gian)as nam, sum(tong_tien) as doanhthu from tb_hoadon group by year(thoi_gian)");
			while(rs.next())
			{
				String[] dong = new String[2];
				dong[0] = rs.getString("nam");
				dong[1] = rs.getString("doanhthu");
				dulieubang.add(dong);
			}
			String[] tieudecot = {"Năm","Doanh thu"};
			String[][] data = new String[dulieubang.size()][2];
			for(int i=0; i<dulieubang.size(); i++)
			{
				data[i]=dulieubang.get(i);
			}
			tbModel.setDataVector(data,tieudecot);
		}
			return tbModel;
	}
	catch(Exception ex){
		JOptionPane.showMessageDialog(null, "Lỗi khi load Nv"+ex.toString());
		return null;
	}
	}
   
}


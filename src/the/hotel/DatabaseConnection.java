package the.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DatabaseConnection {
	protected Connection conn;
	/* 
	 * Đổi Tên instance và tên CSDL trước khi sử dụng
	 * 
	 * */

	
	public DatabaseConnection() {
		try {
			
			String dbURL = "jdbc:sqlserver://localhost\\Thang;user=sa;password=123;database=QuanLyKS";
			
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			    System.out.println("Connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	/*
	 * Lấy Danh sách nhân viên
	 */
		public ArrayList<NhanVien> getListNV(){
			String sql = "select * from NhanVien";
			ArrayList<NhanVien> list = new ArrayList<NhanVien>();
			try {
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					NhanVien a =new NhanVien();
					a.setiD(rs.getInt(1));
					a.setHoTen(rs.getString(2)!=null?rs.getString(2):"");
					a.setSoDT(rs.getString(3)!=null?rs.getString(3):"");
					a.setTaiKhoan(rs.getString(4)!=null?rs.getString(4):"");
					a.setMatKhau(rs.getString(5));
					a.setLoai(rs.getInt(6));
					list.add(a);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	public boolean xoaNV(int id){
		String sql = "delete from NhanVien where ID_NV='"+id+"'";
		boolean b =false;
		try {
			Statement st =conn.createStatement();
			b = (st.executeUpdate(sql)>0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean themNV(NhanVien n) throws SQLException {
		boolean b=false;
		String sql = "insert into NhanVien(ID_NV,HoTen,DienThoai,TaiKhoan,MatKhau,Loai) values(?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, n.getiD());
		st.setNString(2, n.getHoTen());
		st.setNString(3, n.getSoDT());
		st.setNString(4, n.getTaiKhoan());
		st.setNString(5, n.getMatKhau());
		st.setInt(6, n.getLoai());
		b=(st.executeUpdate()>0);
		
		return b;
	}
	
	public boolean suaNV(NhanVien n) throws SQLException {
		boolean b=false;
		String sql = "update NhanVien set Hoten=?, DienThoai=?, TaiKhoan=?,MatKhau=?,Loai=? where ID_NV=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(6, n.getiD());
		st.setNString(1, n.getHoTen());
		st.setNString(2, n.getSoDT());
		st.setNString(3, n.getTaiKhoan());
		st.setNString(4, n.getMatKhau());
		st.setInt(5, n.getLoai());
		b=(st.executeUpdate()>0);
		
		return b;
	}
	public static void main(String[] args) {
		new DatabaseConnection();
	}
}

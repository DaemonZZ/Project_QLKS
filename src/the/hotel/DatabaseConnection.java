package the.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

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
				Statement st = conn.createStatement();
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
	
	
	
	public static void main(String[] args) {
		new DatabaseConnection();
	}
}

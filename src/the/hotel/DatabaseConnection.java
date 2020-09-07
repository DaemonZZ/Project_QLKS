package the.hotel;

import java.sql.Connection;
import java.sql.DriverManager;

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
	public static void main(String[] args) {
		new DatabaseConnection();
	}
}

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
	
		/*
		 * Lấy danh sách phòng
		 */
		public ArrayList<Phong> getListPhong(){
			String sql = "select * from Phong";
			ArrayList<Phong> list = new ArrayList<Phong>();
			try {
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Phong a =new Phong();
					a.setMaPhong(rs.getNString(1));
					a.setTang(rs.getInt(2));
					a.setLoai(rs.getInt(3));
					a.setDonGia(rs.getFloat(4));
					a.setTrangThai(rs.getInt(5));
					a.setPhone(rs.getNString(6));
					a.setSoGiuong(rs.getInt(7));
					a.setSoNguoi(rs.getInt(8));

					list.add(a);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// Lấy thông tin phòng hiện tại
		public ArrayList<QuanLyPhong> getCurrentRoomInfo(){
			String sql = "select ID_QL,QuanLyPhong.ID_DK,HoTen,QuanLyPhong.MaPhong,CheckIN,CheckOut,Gia,PhuThu,GhiChu,QuanLyPhong.TrangThai,Phong.TrangThai,QuanlyPhong.ID_KH "
					+ "from KhachHang inner join QuanLyPhong on KhachHang.ID_KH = QuanLyPhong.ID_KH "
					+ "inner join Phong on QuanLyPhong.MaPhong = Phong.MaPhong where Phong.TrangThai in (4,5)";
			ArrayList<QuanLyPhong> list = new ArrayList<QuanLyPhong>();
			try {
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					if(rs.getInt(11)==4||rs.getInt(11)==5){
						QuanLyPhong a =new QuanLyPhong();
						a.setId(rs.getInt(1));
						a.setId_Dk(rs.getInt(2));
						a.setHoTen(rs.getNString(3));
						a.setMaPhong(rs.getString(4));
						a.setCI(rs.getDate(5));
						a.setCO(rs.getDate(6));
						a.setGia(rs.getFloat(7));
						a.setPhuThu(rs.getFloat(8));
						a.setGhiChu(rs.getString(9));
						a.setTrangThai(rs.getInt(10));
						a.setId_KH(rs.getInt(12));
						list.add(a);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
	public ArrayList<DongChungTu> getListDongChungTu(int Id_QL){
		String sql ="select Id,DongChungtu.SoCT,DongChungTu.ID_DV,TenDV,SoLuong,DongChungTU.DonGia,DongChungTu.GhiChu from DongChungTu join DichVu "
				+ "on DichVu.ID_DV=DongChungTu.ID_DV "
				+ "join ChungTu on ChungTu.SoCT=DongChungTu.SoCT "
				+ "where ID_QL="+Id_QL;
		ArrayList<DongChungTu> list = new ArrayList<DongChungTu>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				DongChungTu s = new DongChungTu();
				s.setId(rs.getInt(1));
				s.setSoCT(rs.getNString(2));
				s.setId_DV(rs.getInt(3));
				s.setTenDV(rs.getNString(4));
				s.setSoLuong(rs.getInt(5));
				s.setDonGia(rs.getFloat(6));
				s.setGhiChu(rs.getNString(7));
				list.add(s);
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

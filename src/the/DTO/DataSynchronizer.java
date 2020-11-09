package the.DTO;

import the.Model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataSynchronizer extends Thread{
   private DatabaseConnection dbc;
   public static DataSynchronizer synchronizer;

   public DataSynchronizer() {
      this.dbc = new DatabaseConnection();
      synchronizer=this;
   }

   @Override
   public void run() {
      while (true){
         try {
            sleep(20000);
            syncAllData();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   public void syncAllData(){
      System.out.println("Syncing.....");
      syncKH();
      syncQLP();
      syncPhong();
      syncLich();
      syncNV();
   }
   public void syncQLP(){
      ArrayList<QuanLyPhong> olddata = dbc.getCurrentRoomInfo();
      ArrayList<QuanLyPhong> newdata = DataStorage.loader.getCurrentRoomInfo();
      ArrayList<QuanLyPhong> diffList= new ArrayList<>();
      int count=0;
      int max = dbc.nextId_QL()-1;
      for (QuanLyPhong item: newdata
           ) {
         if(!olddata.contains(item)){
            diffList.add(item);
         }
      }
      for (QuanLyPhong item: diffList
           ) {
         if(item.getId()>max) dbc.addQLPhong(item);
         else dbc.editRoominfo(item);
      }
   }
   public void syncKH(){
      ArrayList<KhachHang> olddata = dbc.getListKH();
      ArrayList<KhachHang> newdata = DataStorage.loader.getListKH();
      ArrayList<KhachHang> diffList= new ArrayList<>();
      int max = dbc.nextKH()-1;
      for (KhachHang item: newdata
      ) {
         if(!olddata.contains(item)) {
            diffList.add(item);

         }
      }
      for (KhachHang item: diffList
      ) {
         if(item.getId()>max) {
            dbc.addNewKH(item);
         }
         else {
            dbc.editKH(item);

         }

      }
   }
   public void syncPhong(){
      ArrayList<Phong> oldData = dbc.getListPhong();
      ArrayList<Phong> newData = DataStorage.loader.getListPhong();
      ArrayList<Phong> diffList = new ArrayList<>();
      for (Phong item: newData
      ) {
         if(!oldData.contains(item)) {
            diffList.add(item);
         }
      }
      for (Phong p:diffList
           ) {
         dbc.editPhong(p);
      }
   }
   public void syncLich(){
      ArrayList<Lich> oldData = dbc.getlistLich();
      ArrayList<Lich> newData = DataStorage.loader.getListLich();
      ArrayList<Lich> diffList = new ArrayList<>();
      for (Lich l: newData
           ) {
         if(!oldData.contains(l)){
            diffList.add(l);
         }
      }
      for (Lich l: diffList
           ) {
         if(l.getId()==0) dbc.addLich(l);
         else dbc.updateLich(l);
      }
   }
   public void syncNV() {
      ArrayList<NhanVien> oldData = dbc.getListNV();
      ArrayList<NhanVien> newData = DataStorage.loader.getListNV();
      ArrayList<NhanVien> diffList = new ArrayList<>();
      int max =dbc.nextNV()-1;
      for (NhanVien n: newData
           ) {
         if(!oldData.contains(n)) diffList.add(n);
      }
      for (NhanVien n : diffList
              ) {
         if(n.getiD()>max) dbc.themNV(n);
         else dbc.suaNV(n);
      }
   }
}

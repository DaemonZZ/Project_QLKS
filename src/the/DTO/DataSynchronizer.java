package the.DTO;

import the.Model.*;

import javax.swing.*;
import java.awt.*;
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
      syncChungTu();
      syncDongChungTu();
      syncPhong();
      syncLich();
      syncNV();
   }
   public void syncQLP(){
      ArrayList<QuanLyPhong> olddata = dbc.getCurrentRoomInfo();
      ArrayList<QuanLyPhong> newdata = DataStorage.loader.getCurrentRoomInfo();
      ArrayList<QuanLyPhong> diffList= new ArrayList<>();
      ArrayList<Integer> listNewId = new ArrayList<>();
      ArrayList<Integer> listOldId = new ArrayList<>();
      int max = dbc.nextId_QL()-1;
      for (QuanLyPhong item: newdata
           ) {
         listNewId.add(item.getId());
         if(!olddata.contains(item)){
            diffList.add(item);
         }
      }

      for (QuanLyPhong item: olddata
           ) {
         listOldId.add(item.getId());
      }
      for (Integer id: listOldId
           ) {
         if(!listNewId.contains(id))dbc.delQLP(id);
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
      ArrayList<Integer> listNewId = new ArrayList<>();
      ArrayList<Integer> listOldId = new ArrayList<>();
      int max = dbc.nextKH()-1;
      for (KhachHang item: newdata
      ) {
         listNewId.add(item.getId());
         if(!olddata.contains(item)) {
            diffList.add(item);
         }
      }

      for (KhachHang item: olddata
      ) {
         listOldId.add(item.getId());
      }

      for (Integer id: listOldId
           ) {
         if(!listNewId.contains(id)) dbc.delKH(id);
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
      ArrayList<String> listNewId = new ArrayList<>();
      ArrayList<String> listOldId = new ArrayList<>();
      for (Phong item: newData
      ) {
         listNewId.add(item.getMaPhong());
         if(!oldData.contains(item)) {
            diffList.add(item);
         }
      }
      for (Phong item: oldData
      ) {
         listOldId.add(item.getMaPhong());
      }
      for (String id: listOldId
           ) {
         if(!listNewId.contains(id)) dbc.delPhong(id);
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
      ArrayList<Integer> listNewId = new ArrayList<>();
      ArrayList<Integer> listOldId = new ArrayList<>();
      int max =dbc.nextNV()-1;
      for (NhanVien n: newData
           ) {
         listNewId.add(n.getiD());
         if(!oldData.contains(n)) diffList.add(n);
      }
      for (NhanVien item: oldData
      ) {
         listOldId.add(item.getiD());
      }

      for (Integer id: listOldId
           ) {
         if(!listNewId.contains(id)) dbc.xoaNV(id);
      }
      for (NhanVien n : diffList
              ) {
         if(n.getiD()>max) dbc.themNV(n);
         else dbc.suaNV(n);
      }
   }
   public void syncChamCong(){
      ArrayList<ChamCong> oldData = dbc.getlistChamCong();
      ArrayList<ChamCong> newData = DataStorage.loader.getListChamCong();
      ArrayList<ChamCong> diffList = new ArrayList<>();
      int max = dbc.nextChamCong()-1;
      for (ChamCong c: newData
           ) {
         if(!oldData.contains(c)) diffList.add(c);
      }


      for (ChamCong c: diffList
           ) {
         if(c.getId()>max) dbc.addChamCong(c);
         else dbc.editChamCong(c);
      }
   }
   public void syncDongChungTu(){
      ArrayList<DongChungTu> oldData = dbc.getListDongChungTu();
      ArrayList<DongChungTu> newData = DataStorage.loader.getListDongCT();
      ArrayList<DongChungTu> diffList = new ArrayList<>();
      ArrayList<Integer> listNewId = new ArrayList<>();
      ArrayList<Integer> listOldId = new ArrayList<>();
      for (DongChungTu d: newData
           ) {
         listNewId.add(d.getId());
         if(!oldData.contains(d)) diffList.add(d);
      }

      for (DongChungTu item: oldData
      ) {
         listOldId.add(item.getId());
      }

      for (Integer id: listOldId
           ) {
         if(!listNewId.contains(id)) dbc.delDCT(id);
      }

      for (DongChungTu d: diffList
           ) {
         if(d.getId()==0) {
            int a =dbc.addDongCT(d);
            System.out.println(a);
         }
         else dbc.editDongCT(d);
      }
   }
   public void syncChungTu(){
      ArrayList<ChungTu> oldData = dbc.getlistCT();
      ArrayList<ChungTu> newData = DataStorage.loader.getListChungTu();
      ArrayList<ChungTu> diffList = new ArrayList<>();
      ArrayList<Integer> listNewId = new ArrayList<>();
      ArrayList<Integer> listOldId = new ArrayList<>();
      int max = dbc.nextCT()-1;
      for (ChungTu c: newData
           ) {
         listNewId.add(c.getSoCT());
         if(!oldData.contains(c)) diffList.add(c);
      }
      for (Integer id: listOldId
      ) {
         if(!listNewId.contains(id)) dbc.delCT(id);
      }

      for (ChungTu c: diffList
           ) {
         if(c.getSoCT()>max) {
            dbc.addCT(c);
            System.out.println(c.getSoCT());
         }
         else {

            dbc.editCT(c);
         }
      }
   }
}

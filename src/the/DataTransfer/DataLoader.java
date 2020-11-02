package the.DataTransfer;

import the.Model.DatabaseConnection;

import java.util.ArrayList;

public class DataLoader {
    DatabaseConnection dbc = new DatabaseConnection();
    ArrayList<Lich> listLich;

    public ArrayList<Lich> getListLich() {
        return listLich;
    }

    public void setListLich(ArrayList<Lich> listLich) {
        this.listLich = listLich;
    }

    public DataLoader(int AR){
        listLich = dbc.getlistLich();
    }
}

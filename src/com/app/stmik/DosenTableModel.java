package com.app.stmik;

import com.app.entity.Dosen;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author casper
 */
public class DosenTableModel extends AbstractTableModel {
    private List<Dosen> list;
    
    public DosenTableModel(List<Dosen> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return list.get(rowIndex).getId();
            case 1: return list.get(rowIndex).getNama();
            case 2: return list.get(rowIndex).getKompetensi();
            
            default : return null;
        }
    }
    
    private String[] header = {"ID", "Nama", "Kompetensi"};
    @Override

    public String getColumnName(int column) {
        return header [column];
    }
}

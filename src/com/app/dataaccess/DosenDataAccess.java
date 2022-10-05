package com.app.dataaccess;

import com.app.connection.DBConnection;
import com.app.entity.Dosen;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casper
 */
public class DosenDataAccess {
    public List<Dosen> getAll() {
        List<Dosen> result = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM dosen";
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Dosen dosen = null;
            
            while(rs.next()) {
                dosen = new Dosen(rs);
                result.add(dosen);
            }
            
        } catch (SQLException ex) {
            System.out.println("Select dosen error! ");
        }
        
        return result;
    }
    
    public List<Dosen> getByID(int id) {
        Dosen dosen = null;
        
        try {
            String sql = "SELECT * FROM dosen";
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                dosen = new Dosen(rs);
            }
            
        } catch (SQLException ex) {
            System.out.println("Select dosen error!");
        }
        
        return dosen; //Kalau tidak connect ke database maka baris ini akan error
    }
    
    public boolean Insert(Dosen dosen) {
        String sql = "INSERT INTO dosen(nama, kompetensi) VALUES( ?,  ?)";
        
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getKompetensi());
            int result = statement.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            System.out.println("Insert dosen error!");
        }
        
        return false;
    }
    
    public boolean Update(Dosen dosen) {
        String sql = "UPDATE dosen SET nama =?, kompetensi =? WHERE id =?";

        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getKompetensi());
            statement.setInt(3, dosen.getId());
            int result = statement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.out.println("Update dosen error!");
        }

        return false;
    }
    
    public boolean Delete(Dosen dosen) {
        String sql = "DELETE FROM dosen WHERE id =?";

        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, dosen.getId());
            int result = statement.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.out.println("Delete dosen error!");
        }

        return false;
    }
}
 
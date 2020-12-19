package model;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Mahasiswa {
    private String npm;
    private String nama;
    private double IPK;
    private int jumlahMatakuliah;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa(String npm, String nama, double IPK, int jumlahMatakuliah){
        this.npm = npm;
        this.nama = nama;
        this.IPK = IPK;
        this.jumlahMatakuliah = jumlahMatakuliah;
    }
    
    public void read(){
        String selectQuery = "SELECT * FROM mahasiswa";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            
            System.out.println("NPM         | Nama                  |");
            System.out.println("=====================================");
            while(resultSet.next()){
                System.out.println(resultSet.getString("npm")+"    | "
                +resultSet.getString("nama"));   
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void create(){
        String insertQuery = "INSERT INTO mahasiswa "
                + "(npm,nama,ipk,jumlah_matakuliah)"
                + " VALUES "
                + "(?,?,?,?)";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, this.npm);
            ps.setString(2, this.nama);
            ps.setDouble(3, this.IPK);
            ps.setInt(4, this.jumlahMatakuliah);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void update(){
        String insertQuery = "UPDATE mahasiswa "
                + "SET"
                + "nama = ?, "
                + "ipk = ?, "
                + "jumlah_matakuliah = ? "
                + "WHERE npm = ?";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, this.nama);
            ps.setDouble(2, this.IPK);
            ps.setInt(3, this.jumlahMatakuliah);
            ps.setString(4, this.npm);
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void delete(){
        String deleteQuery = "DELETE FROM mahasiswa "
                + "WHERE npm = ?";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setString(1, this.npm);
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void isiAbsen(){
    }
    
    public void tambahMataKuliah(){
    }
    
    public String getNpm() {
        return npm;
    }
    
    public void setNpm(String npm) {
        this.npm = npm;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public double getIPK() {
        return IPK;
    }
    
    public void setIPK(double IPK) {
        this.IPK = IPK;
    }
    
    public int getJumlahMatakuliah() {
        return jumlahMatakuliah; 
    }
    
    public void setJumlahMatakuliah(int jumlahMatakuliah) {
        this.jumlahMatakuliah = jumlahMatakuliah;
    }
    
    
    
    

}

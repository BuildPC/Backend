import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denizcan
 */
public class SQLUtilities {
    
    public static ResultSet getUsersSet;
    public static ResultSet getUsersData;
    public static Connection DBConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://cs320project-1.duckdns.org/cs320DB";
        String user = "app";
        int port = 3306;
        String pass = "passpass";
       
        
        try{
            
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
                    
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
        return conn;
    }
    protected static void Update_table(JTable UserTable){
        try{
            ResultSet rs=null;
            PreparedStatement pst= null;
            
            
            String sql ="select username,first_name,last_name from Customer";
            pst=Frame.conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
        }
    }
    protected static void Update_tableItem(JTable UserTable){
        try{
            ResultSet rs=null;
            PreparedStatement pst= null;
            
            
            String sql ="select item_id,item_name,stock from Item";
            pst=Frame.conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
        }
    }
    
    public static ArrayList<ArrayList<String>> getUsers(Connection conn){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        
        String sql = "SELECT username,first_name FROM Customer";
        
        try{
        PreparedStatement getUsers = conn.prepareStatement(sql);
        
        getUsersSet = getUsers.executeQuery();
       
        
        while (getUsersSet.next()){
            String username = getUsersSet.getString("username");
            String fname = getUsersSet.getString("first_name");
            res.add(new ArrayList<String>());
            res.get(res.size()-1).add(username);
            res.get(res.size()-1).add(fname); 
            
        }
      //  Frame.UserTable.setModel(DbUtils.resultSetToTableModel(getUsersSet));
        
        }catch(SQLException ex){
             System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        for(ArrayList<String> arr : res){
            for(String st : arr){
           //     Frame.UserTable.
                System.out.print(st + " ");
            }
            System.out.println();
        }
        
        return res;
        
        

    }
    public static ArrayList<ArrayList<String>> getUserData(Connection conn, String username){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        System.out.println(username);
        
       String sql="Select C.phone,C.caddress From Customer C WHERE C.username ='"+username+"'";
        
        try{
        PreparedStatement getUsers = conn.prepareStatement(sql);
        
        getUsersData = getUsers.executeQuery();
       
        
        while (getUsersData.next()){
            String username1 = getUsersData.getString("phone");
            String fname = getUsersData.getString("caddress");
            res.add(new ArrayList<String>());
            UserEdit.userphoneLabel.setText("Phone number : "+username1);
            UserEdit.adresLabel.setText("Address : "+fname);
            res.get(res.size()-1).add(username1);
            res.get(res.size()-1).add(fname); 
            
        }
      //  Frame.UserTable.setModel(DbUtils.resultSetToTableModel(getUsersSet));
        
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
        return res;
    
    
    }
    public static void findElse(String username){
        
        String sql="Select phone,caddress where Customer.user_name="+username+"From Customer";
        
    }
    





    
      
      public static void AddItem(String itemName,String itemDesc,int stock,float price,int category,Connection conn,byte[] photo) throws SQLException{
          
         
          
          String addItem = "INSERT INTO Item (item_name,item_desc,stock,price,photo,category) VALUES (?,?,?,?,?,?)";
                        
                        PreparedStatement item_id = Frame.conn.prepareStatement(addItem, Statement.RETURN_GENERATED_KEYS);
                        
                        item_id.setString(1, itemName);
                        item_id.setString(2, itemDesc);
                        item_id.setInt(3,stock);
                        item_id.setFloat(4, price);
                        item_id.setBytes(5, photo);
                        item_id.setInt(6,category);
                       
                        item_id.addBatch();
                        item_id.executeBatch();
          
          
      }
     

    
}
